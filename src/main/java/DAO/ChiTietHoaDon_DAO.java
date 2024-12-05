package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import ConnectDB.ConnectDB;
import ENTITY.ChiTietHoaDon;

public class ChiTietHoaDon_DAO {
	private String generateMaChiTietHoaDon() {
	    String query = "SELECT MAX(CAST(SUBSTRING(MaChiTietHoaDon, 5, LEN(MaChiTietHoaDon)) AS INT)) AS MaxId FROM ChiTietHoaDon";
	    int nextId = 1;  // Mặc định bắt đầu từ 1

	    try (Connection conn = ConnectDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query);
	         ResultSet rs = ps.executeQuery()) {

	        if (rs.next()) {
	            nextId = rs.getInt("MaxId") + 1;  // Lấy giá trị lớn nhất và cộng 1
	        }
	    } catch (SQLException ex) {
	        System.out.println("Lỗi khi lấy ID chi tiết hóa đơn: " + ex.getMessage());
	    }
	    return "CTHD" + String.format("%04d", nextId);  // Tạo mã chi tiết hóa đơn, ví dụ CTHD0001
	}
	
	// Phương thức thêm hoặc cập nhật chi tiết hóa đơn
    public boolean addOrUpdateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon, String maHoaDon, String maPhong) {
        // Kiểm tra nếu ngày hiện tại nằm trong khoảng ngày nhận phòng và ngày trả phòng
        if (!checkIfServiceTimeIsValid(maPhong)) {
        	System.out.println("Ngày hiện tại không hợp lệ");
            return false;  // Nếu thời gian không hợp lệ, trả về false
        }

        // Kiểm tra xem dịch vụ đã tồn tại chưa
        if (checkIfDichVuExists(maPhong, chiTietHoaDon.getDichVu().getMaDichVu())) {
            // Nếu dịch vụ đã tồn tại, cập nhật số lượng và tổng tiền dịch vụ
        	System.out.println("Dịch vụ tồn tại");
            return updateChiTietHoaDon(chiTietHoaDon, maPhong);
        } else {
            // Nếu dịch vụ chưa tồn tại, thêm mới chi tiết hóa đơn
        	System.out.println("Dịch vụ không tồn tại");
            return addNewChiTietHoaDon(chiTietHoaDon, maHoaDon);
        }
    }

    // Phương thức kiểm tra thời gian dịch vụ hợp lệ
    private boolean checkIfServiceTimeIsValid(String maPhong) {
        String query = "SELECT NgayNhanPhong, NgayTraPhong " +
                       "FROM PhieuDatPhong " +
                       "WHERE MaPhong = ? AND GETDATE() BETWEEN NgayNhanPhong AND NgayTraPhong";  // Kiểm tra ngày hiện tại nằm trong khoảng

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, maPhong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;  // Ngày hiện tại nằm trong khoảng thời gian nhận và trả phòng
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi khi kiểm tra thời gian dịch vụ: " + ex.getMessage());
        }
        return false;  // Ngày hiện tại không nằm trong khoảng thời gian nhận và trả phòng
    }

    // Phương thức kiểm tra nếu dịch vụ đã tồn tại trong ChiTietHoaDon
    private boolean checkIfDichVuExists(String maPhong, String maDichVu) {
        String query = "SELECT COUNT(*) FROM ChiTietHoaDon WHERE MaPhong = ? AND MaDichVu = ?";
        
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, maPhong);
            ps.setString(2, maDichVu);

            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true;  // Dịch vụ đã tồn tại
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi khi kiểm tra dịch vụ: " + ex.getMessage());
        }
        return false;  // Dịch vụ chưa tồn tại
    }

    // Phương thức cập nhật chi tiết hóa đơn (nếu dịch vụ đã tồn tại)
    private boolean updateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon, String maPhong) {
        String query = "UPDATE ChiTietHoaDon SET SoLuong = SoLuong + ?, TongTienDichVu = TongTienDichVu + ? WHERE MaPhong = ? AND MaDichVu = ?";
        
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Cập nhật số lượng và tổng tiền dịch vụ
            ps.setInt(1, chiTietHoaDon.getSoLuong());
            ps.setDouble(2, chiTietHoaDon.getTongTienDichVu());
            ps.setString(3, maPhong);
            ps.setString(4, chiTietHoaDon.getDichVu().getMaDichVu());

            int rowsAffected = ps.executeUpdate();
            System.out.println("hoàn thành cập nhật chi tiết hóa đơn: ");
            return rowsAffected > 0;  // Nếu có dòng bị ảnh hưởng, tức là cập nhật thành công
        } catch (SQLException ex) {
            System.out.println("Lỗi khi cập nhật chi tiết hóa đơn: " + ex.getMessage());
            return false;
        }
    }

    // Phương thức thêm mới chi tiết hóa đơn (nếu dịch vụ chưa tồn tại)
    private boolean addNewChiTietHoaDon(ChiTietHoaDon chiTietHoaDon, String maHoaDon) {
        String query = "INSERT INTO ChiTietHoaDon (MaChiTietHoaDon, MaHoaDon, MaPhong, MaDichVu, SoLuong, TongTienDichVu) "
                     + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Tạo mã chi tiết hóa đơn
            String maChiTietHoaDon = generateMaChiTietHoaDon();  // Phương thức tạo mã chi tiết hóa đơn tự động
            
            // Gán giá trị vào câu lệnh SQL
            ps.setString(1, maChiTietHoaDon);  // Mã chi tiết hóa đơn
            ps.setString(2, maHoaDon);          // Mã hóa đơn
            ps.setString(3, chiTietHoaDon.getPhong().getMaPhong());  // Mã phòng
            ps.setString(4, chiTietHoaDon.getDichVu().getMaDichVu()); // Mã dịch vụ
            ps.setInt(5, chiTietHoaDon.getSoLuong());  // Số lượng
            ps.setDouble(6, chiTietHoaDon.getTongTienDichVu());  // Thành tiền

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;  // Nếu có dòng bị ảnh hưởng, tức là thêm mới thành công
        } catch (SQLException ex) {
            System.out.println("Lỗi khi thêm chi tiết hóa đơn: " + ex.getMessage());
            return false;
        }
    }
}
