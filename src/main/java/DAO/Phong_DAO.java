package DAO;

import ENTITY.LoaiPhong;
import ENTITY.Phong;
import ENTITY.TinhTrangPhong;
import ENTITY.TrangThaiPhong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;

public class Phong_DAO {
	private final ConnectDB connectDB = new ConnectDB();
	
	public List<Phong> getAllPhong() {
        List<Phong> dsPhong = new ArrayList<>();
        String query = "SELECT MaPhong, SoNguoiLon, SoTreEm, TrangThaiPhong, TinhTrangPhong, " +
                "LoaiPhong.MaLoaiPhong, LoaiPhong.TenLoaiPhong, " +
                "LoaiPhong.GiaTienTheoNgay, LoaiPhong.GiaTienTheoGio " +
                "FROM Phong " +
                "JOIN LoaiPhong ON Phong.LoaiPhong = LoaiPhong.MaLoaiPhong";

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Tạo đối tượng LoaiPhong
            	LoaiPhong loaiPhong = new LoaiPhong(
            		    rs.getString("MaLoaiPhong"),
            		    rs.getString("TenLoaiPhong"),
            		    rs.getDouble("GiaTienTheoGio"),
            		    rs.getDouble("GiaTienTheoNgay"),
            		    false
            		);

                // Lấy giá trị enum từ chuỗi trong cơ sở dữ liệu
                TrangThaiPhong trangThai = TrangThaiPhong.valueOf(rs.getString("TrangThaiPhong"));
                TinhTrangPhong tinhTrang = TinhTrangPhong.valueOf(rs.getString("TinhTrangPhong"));

                // Tạo đối tượng Phong
                Phong phong = new Phong(
                    rs.getString("MaPhong"),
                    loaiPhong,
                    rs.getInt("SoNguoiLon"),
                    rs.getInt("SoTreEm"),
                    trangThai,
                    tinhTrang
                );

                dsPhong.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhong;
    }
	
	public List<Phong> getPhongTheoTang(int tang) {
	    List<Phong> dsPhong = new ArrayList<>();
	    String query = "SELECT MaPhong, SoNguoiLon, SoTreEm, TrangThaiPhong, TinhTrangPhong, " +
	            "LoaiPhong.MaLoaiPhong, LoaiPhong.TenLoaiPhong, " +
	            "LoaiPhong.GiaTienTheoNgay, LoaiPhong.GiaTienTheoGio " +
	            "FROM Phong " +
	            "JOIN LoaiPhong ON Phong.LoaiPhong = LoaiPhong.MaLoaiPhong " +
	            "WHERE SUBSTRING(Phong.MaPhong, 2, 1) = ?"; // Lọc theo ký tự đầu tiên của MaPhong

	    try (Connection conn = connectDB.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {

	        pstmt.setString(1, String.valueOf(tang)); // Truyền tham số tầng vào câu truy vấn
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            // Tạo đối tượng LoaiPhong
	            LoaiPhong loaiPhong = new LoaiPhong(
	                rs.getString("MaLoaiPhong"),
	                rs.getString("TenLoaiPhong"),
	                rs.getDouble("GiaTienTheoGio"),
	                rs.getDouble("GiaTienTheoNgay"),
	                false
	            );

	            // Lấy giá trị enum từ chuỗi trong cơ sở dữ liệu
	            TrangThaiPhong trangThai = TrangThaiPhong.valueOf(rs.getString("TrangThaiPhong"));
	            TinhTrangPhong tinhTrang = TinhTrangPhong.valueOf(rs.getString("TinhTrangPhong"));

	            // Tạo đối tượng Phong
	            Phong phong = new Phong(
	                rs.getString("MaPhong"),
	                loaiPhong,
	                rs.getInt("SoNguoiLon"),
	                rs.getInt("SoTreEm"),
	                trangThai,
	                tinhTrang
	            );

	            dsPhong.add(phong);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dsPhong;
	}
}
