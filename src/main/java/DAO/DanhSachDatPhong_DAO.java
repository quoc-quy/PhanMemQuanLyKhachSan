package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;

public class DanhSachDatPhong_DAO {
	private final ConnectDB connectDB = new ConnectDB();
	
//	Lấy danh sách đặt phòng
	public List<Object[]> getAllDanhSachDatPhong() {
	    List<Object[]> danhSachDatPhong = new ArrayList<>();

	    String sql = 
	        "SELECT kh.TenKhachHang, kh.DenThoai, kh.Phai, " +
	        "pdp.MaPhieuDatPhong, pdp.MaPhong, pdp.NgayNhanPhong, pdp.NgayTraphong, pdp.TienCoc " +
	        "FROM PhieuDatPhong pdp " +
	        "JOIN KhachHang kh ON pdp.MaKhachHang = kh.MaKhachHang ";

	    try (Connection conn = ConnectDB.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	    	
	    	int index = 1; // Biến đếm bắt đầu từ 1 cho số thứ tự dòng
	        while (rs.next()) {
	            Object[] row = {
	            	index,
	                rs.getString("MaPhieuDatPhong"),
	                rs.getString("TenKhachHang"),
	                rs.getString("DenThoai"),
	                rs.getString("Phai"),
	                rs.getString("MaPhong"),
	                rs.getDate("NgayNhanPhong"),
	                rs.getDate("NgayTraPhong"),
	                rs.getInt("TienCoc")
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
}
