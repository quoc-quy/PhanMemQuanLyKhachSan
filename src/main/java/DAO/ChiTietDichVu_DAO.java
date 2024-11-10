package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConnectDB.ConnectDB;
import ENTITY.ChiTietDichVu;

public class ChiTietDichVu_DAO {
	// Phương thức lưu chi tiết dịch vụ
    public void luuChiTietDichVu(ChiTietDichVu chiTietDichVu) {
        String query = "INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, chiTietDichVu.getHoaDon().getMaHoaDon());
            pstmt.setString(2, chiTietDichVu.getDichVu().getMaDichvu());
            pstmt.setInt(3, chiTietDichVu.getSoLuong());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
