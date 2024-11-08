package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import ENTITY.KhachHang;
import ENTITY.NhanVien;
import ENTITY.PhieuDatPhong;
import ENTITY.Phong;

public class DanhSachDatPhong_DAO {
	private final ConnectDB connectDB = new ConnectDB();
	
	 // Phương thức tạo mã tự động cho MaPhieuDatPhong
	private String generateMaPhieuDatPhong(Date ngayNhanPhong, String maPhong) {
	    // Định dạng ngày theo định dạng yyyyMMdd
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    String formattedDate = dateFormat.format(ngayNhanPhong);

	    // Giả định mã phòng là 4 ký tự, nếu mã phòng dài hơn 4 ký tự thì chỉ lấy 4 ký tự đầu
	    String formattedMaPhong = maPhong.length() > 4 ? maPhong.substring(0, 4) : maPhong;

	    // Ghép chuỗi theo định dạng: PDP + ngày nhận phòng + mã phòng
	    return "PDP" + formattedDate + formattedMaPhong;
	  
	}

	public boolean addPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
	    String sql = "INSERT INTO PhieuDatPhong (MaPhieuDatPhong, MaKhachHang, MaPhong, MaNhanVienLap, NgayNhanPhong, NgayTraPhong, TienCoc, LoaiHinh, GioNhanPhong, GioTraPhong, TongTien, TrangThai) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = connectDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        // Tự động tạo mã phiếu đặt phòng
	        String maPhieuDatPhong = generateMaPhieuDatPhong(new java.sql.Date(phieuDatPhong.getNgayNhanPhong().getTime()), phieuDatPhong.getPhong().getMaPhong());
	        if (maPhieuDatPhong == null) {
	            System.out.println("Không thể tạo mã phiếu đặt phòng mới.");
	            return false;
	        }

	        // Thiết lập các tham số cho PreparedStatement
	        ps.setString(1, maPhieuDatPhong);
	        ps.setString(2, phieuDatPhong.getKhachHang().getMaKhachHang());
	        ps.setString(3, phieuDatPhong.getPhong().getMaPhong());
	        ps.setString(4, phieuDatPhong.getNhanVienLap().getMaNhanVien());
	        ps.setDate(5, new java.sql.Date(phieuDatPhong.getNgayNhanPhong().getTime()));
	        ps.setDate(6, new java.sql.Date(phieuDatPhong.getNgayTraPhong().getTime()));
	        ps.setDouble(7, phieuDatPhong.getTienCoc());
	        
	        // Các cột bổ sung
	        ps.setString(8, phieuDatPhong.getLoaiHinh());
	        ps.setString(9, phieuDatPhong.getGioNhanPhong());
	        ps.setString(10, phieuDatPhong.getGioTraPhong()); 
	        ps.setDouble(11, phieuDatPhong.getTongTien());
	        ps.setString(12, phieuDatPhong.getTrangThai());

	        // Thực thi câu lệnh và kiểm tra kết quả
	        int rowsAffected = ps.executeUpdate();
	        return rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
//	Lấy danh sách đặt phòng
	public List<Object[]> getAllDanhSachDatPhong() {
	    List<Object[]> danhSachDatPhong = new ArrayList<>();

	    String sql = 
	        "SELECT kh.TenKhachHang, kh.DenThoai, " +
	        "pdp.MaPhieuDatPhong, pdp.MaKhachHang, pdp.MaPhong, pdp.NgayNhanPhong, pdp.NgayTraPhong, pdp.TienCoc, pdp.TrangThai " +
	        "FROM PhieuDatPhong pdp " +
	        "LEFT JOIN KhachHang kh ON pdp.MaKhachHang = kh.MaKhachHang";

	    try (Connection conn = ConnectDB.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        
	        int index = 1; // Biến đếm bắt đầu từ 1 cho số thứ tự dòng
	        while (rs.next()) {
	            // Kiểm tra MaKhachHang và thiết lập tên khách hàng là "Khách lẻ" nếu cần
	            String maKhachHang = rs.getString("MaKhachHang");
	            String tenKhachHang = rs.getString("TenKhachHang");

	            if (maKhachHang == null) {
	                tenKhachHang = "Khách lẻ"; // Nếu MaKhachHang là null, đặt tên khách hàng là "Khách lẻ"
	            }

	            String soDienThoai = rs.getString("DenThoai") != null ? rs.getString("DenThoai") : "Không có";
	            String trangThai = rs.getString("TrangThai");
	            String maPhieuDatPhong = rs.getString("MaPhieuDatPhong");
	            String maPhong = rs.getString("MaPhong");
	            Date ngayNhanPhong = rs.getDate("NgayNhanPhong");
	            Date ngayTraPhong = rs.getDate("NgayTraPhong");
	            Double tienCoc = rs.getDouble("TienCoc");

	            // Thêm dòng dữ liệu vào danh sách
	            Object[] row = {
	                index,
	                maPhieuDatPhong,
	                tenKhachHang,
	                soDienThoai,
	                maPhong,
	                ngayNhanPhong,
	                ngayTraPhong,
	                tienCoc,
	                trangThai
	            };
	            danhSachDatPhong.add(row);
	            index++; // Tăng biến đếm lên 1 cho dòng tiếp theo
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return danhSachDatPhong;
	}

 	// Xóa đặt phòng
 	public boolean deletePhieuDatPhong(String MaPhieuDatPhong) {
 		String query = "DELETE FROM PhieuDatPhong WHERE MaPhieuDatPhong = ?";

 		try (Connection conn = connectDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

 			pstmt.setString(1, MaPhieuDatPhong);

 			return pstmt.executeUpdate() > 0;
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return false;
 	}
 	
 	 public boolean updatePhieuDatPhong(PhieuDatPhong phieuDatPhong) {
         String sql = "UPDATE PhieuDatPhong SET MaKhachHang = ?, MaPhong = ?, MaNhanVienLap = ?, "
                    + "NgayNhanPhong = ?, NgayTraPhong = ?, TienCoc = ? WHERE MaPhieuDatPhong = ?";

         try (Connection conn = ConnectDB.getConnection();
              PreparedStatement ps = conn.prepareStatement(sql)) {

             ps.setString(1, phieuDatPhong.getKhachHang().getMaKhachHang());
             ps.setString(2, phieuDatPhong.getPhong().getMaPhong());
             ps.setString(3, phieuDatPhong.getNhanVienLap().getMaNhanVien());
             ps.setDate(4, new java.sql.Date(phieuDatPhong.getNgayNhanPhong().getTime()));
             ps.setDate(5, new java.sql.Date(phieuDatPhong.getNgayTraPhong().getTime()));
             ps.setDouble(6, phieuDatPhong.getTienCoc());

             int rowsAffected = ps.executeUpdate();
             return rowsAffected > 0;

         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         }
     }
 	 
}
