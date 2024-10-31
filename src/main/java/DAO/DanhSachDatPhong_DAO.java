package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;

public class DanhSachDatPhong_DAO {
	public List<Object[]> getAllDanhSachDatPhong() {
	    List<Object[]> danhSachDatPhong = new ArrayList<>();

	    String sql = 
	        "SELECT kh.TenKhachHang, kh.DenThoai, kh.Phai, " +
	        "pdp.MaPhong, pdp.NgayNhanPhong, pdp.NgayTraphong, pdp.TienCoc " +
	        "FROM PhieuDatPhong pdp " +
	        "JOIN KhachHang kh ON pdp.MaKhachHang = kh.MaKhachHang ";

	    try (Connection conn = ConnectDB.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	    	
	    	int index = 1; // Biến đếm bắt đầu từ 1 cho số thứ tự dòng
	        while (rs.next()) {
	            Object[] row = {
	            	index,
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
}
