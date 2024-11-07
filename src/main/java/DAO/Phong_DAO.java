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
	
	
	public boolean updateTinhTrangPhong(String maPhong, String tinhTrangMoi) {
	    try (Connection conn = ConnectDB.getConnection()) {
	        String sql = "UPDATE Phong SET TinhTrangPhong = ? WHERE MaPhong = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, tinhTrangMoi);
	        stmt.setString(2, maPhong);
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public void capNhatTrangThaiPhong(String maPhong, String trangThai) {
	    String sql = "UPDATE Phong SET TrangThaiPhong = ? WHERE MaPhong = ?";
	    
	    try (Connection conn = ConnectDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setString(1, trangThai);
	        ps.setString(2, maPhong);
	        
	        ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public List<Phong> getAllPhongTrong() {
	    List<Phong> danhSachPhongTrong = new ArrayList<>();
	    String sql = "SELECT * FROM Phong WHERE TrangThaiPhong = 'PHONG_TRONG'";

	    try (Connection conn = ConnectDB.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        while (rs.next()) {
	            Phong phong = new Phong();
	            phong.setMaPhong(rs.getString("MaPhong"));

	            // Thiết lập đối tượng LoaiPhong
	            LoaiPhong loaiPhong = new LoaiPhong();
	            loaiPhong.setMaLoaiPhong(rs.getString("LoaiPhong"));
	            phong.setLoaiPhong(loaiPhong);

	            phong.setSoNguoiLon(rs.getInt("SoNguoiLon"));
	            phong.setSoTreEm(rs.getInt("SoTreEm"));

	            // Thiết lập đối tượng TrangThaiPhong
	            TrangThaiPhong trangThaiPhong = TrangThaiPhong.valueOf(rs.getString("TrangThaiPhong"));
	            phong.setTrangThaiPhong(trangThaiPhong);

	            // Thiết lập đối tượng TinhTrangPhong
	            TinhTrangPhong tinhTrangPhong = TinhTrangPhong.valueOf(rs.getString("TinhTrangPhong"));
	            phong.setTinhTrangPhong(tinhTrangPhong);

	            danhSachPhongTrong.add(phong);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return danhSachPhongTrong;
	}
}
