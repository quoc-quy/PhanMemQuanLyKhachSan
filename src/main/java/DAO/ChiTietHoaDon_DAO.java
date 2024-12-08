package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            return false;  // Nếu thời gian không hợp lệ, trả về false
        }

        // Kiểm tra xem dịch vụ đã tồn tại chưa
        if (checkIfDichVuExists(maPhong, chiTietHoaDon.getDichVu().getMaDichVu())) {
            // Nếu dịch vụ đã tồn tại, cập nhật số lượng và tổng tiền dịch vụ
            return updateChiTietHoaDon(chiTietHoaDon, maPhong);
        } else {
            // Nếu dịch vụ chưa tồn tại, thêm mới chi tiết hóa đơn
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
    
 // Phương thức lấy thông tin dịch vụ và chi tiết hóa đơn cho mã phòng
    public List<Object[]> getChiTietHoaDonByMaPhong(String maPhong) {
        List<Object[]> ds = new ArrayList<>();
        
        // Câu truy vấn SQL
        String sql = "SELECT " +
                     "dv.TenDichVu, " +
                     "dv.DonGia, " +
                     "ct.SoLuong, " +
                     "ct.TongTienDichVu " +
                     "FROM ChiTietHoaDon ct " +
                     "JOIN HoaDon hd ON ct.MaHoaDon = hd.MaHoaDon " +
                     "JOIN DichVu dv ON ct.MaDichVu = dv.MaDichVu " +
                     "WHERE ct.MaPhong = ? AND hd.MaNhanVienLap IS NULL";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Thiết lập tham số cho câu truy vấn
            stmt.setString(1, maPhong);  // Gán giá trị cho maPhong

            try (ResultSet rs = stmt.executeQuery()) {
                // Lấy kết quả từ ResultSet và thêm vào danh sách
            	int index = 1;
                while (rs.next()) {
                    String tenDichVu = rs.getString("TenDichVu");
                    double donGia = rs.getDouble("DonGia");
                    int soLuong = rs.getInt("SoLuong");
                    double tongTienDichVu = rs.getDouble("TongTienDichVu");

                    // Thêm dữ liệu vào danh sách
                    Object[] row = new Object[] {index, tenDichVu, soLuong, donGia, tongTienDichVu};
                    ds.add(row);
                    index++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
    
    
 // Phương thức để thêm chi tiết hóa đơn khi nhấn nút Đặt nhanh
    public boolean themChiTietHoaDon(String maHoaDon, String maPhong) {
        try (Connection conn = ConnectDB.getConnection()) {
            // Tạo MaChiTietHoaDon ngẫu nhiên hoặc sử dụng UUID
            String maChiTietHoaDon = generateMaChiTietHoaDon();  // Hoặc tạo mã tự động theo logic của bạn

            // SQL để thêm chi tiết hóa đơn
            String sql = "INSERT INTO ChiTietHoaDon (MaChiTietHoaDon, MaHoaDon, MaPhong ) "
                        + "VALUES (?, ?, ?)";

            // Tạo PreparedStatement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, maChiTietHoaDon);  // MaChiTietHoaDon
                stmt.setString(2, maHoaDon);         // MaHoaDon
                stmt.setString(3, maPhong);          // MaPhong

                // Thực thi câu lệnh INSERT
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;  // Nếu có bản ghi được thêm thành công
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
