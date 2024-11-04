package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectDB.ConnectDB;

public class LoaiPhong_DAO {
	private final ConnectDB connectDB = new ConnectDB();
	
	// Phương thức lấy giá tiền theo ngày của loại phòng dựa vào mã phòng
    public double getGiaTienTheoNgay(String maPhong) {
        double giaTienTheoNgay = 0.0;
        String sql = "SELECT lp.GiaTienTheoNgay FROM LoaiPhong lp " +
                     "JOIN Phong p ON lp.MaLoaiPhong = p.LoaiPhong " +
                     "WHERE p.MaPhong = ?";
        try (Connection conn = connectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maPhong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                giaTienTheoNgay = rs.getDouble("GiaTienTheoNgay");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giaTienTheoNgay;
    }

    // Phương thức lấy giá tiền theo giờ của loại phòng dựa vào mã phòng
    public double getGiaTienTheoGio(String maPhong) {
        double giaTienTheoGio = 0.0;
        String sql = "SELECT lp.GiaTienTheoGio FROM LoaiPhong lp " +
                     "JOIN Phong p ON lp.MaLoaiPhong = p.LoaiPhong " +
                     "WHERE p.MaPhong = ?";
        try (Connection conn = connectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maPhong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                giaTienTheoGio = rs.getDouble("GiaTienTheoGio");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giaTienTheoGio;
    }
}