package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConnectDB.ConnectDB;
import ENTITY.PhieuDatPhong;

public class PhieuDatPhong_DAO {
	private final ConnectDB connectDB = new ConnectDB();
	
	public boolean addPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
        String sql = "INSERT INTO PhieuDatPhong (MaKhachHang, MaPhong, MaNhanVienLap, NgayNhanPhong, NgayTraPhong, TienCoc) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

        	ps.setString(1, phieuDatPhong.getKhachHang().getMaKhachHang());
            ps.setString(2, phieuDatPhong.getPhong().getMaPhong());
            ps.setString(3, phieuDatPhong.getNhanVienLap().getMaNhanVien()); // Giả định mã nhân viên lập được lấy từ phieuDatPhong
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
