/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class TaiKhoan_DAO {
    private ConnectDB dbConnection = new ConnectDB();

    public boolean checkLogin(String tenDangNhap, String matKhau) {
        boolean isValid = false;
        Connection connection = dbConnection.getConnection();
        try {
            String query = "SELECT * FROM TAIKHOAN WHERE TenDangNhap=? AND MatKhau=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
        }
        return isValid;
    }

    public String getTaiKhoanByTenDangNhap(String tenDangNhap) {
        String maTaiKhoan = "";
        Connection connection = dbConnection.getConnection();
        try {
            String query = "SELECT MaTaiKhoan FROM TAIKHOAN WHERE TenDangNhap=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenDangNhap);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                maTaiKhoan = rs.getString("MaTaiKhoan");
            }
        } catch (SQLException e) {
        }
        return maTaiKhoan;
    }
    
 // Phương thức lấy mã nhân viên dựa vào tên đăng nhập
    public String getMaNhanVienByTenDangNhap(String tenDangNhap) {
        String maNhanVien = null;
        String sql = "SELECT NhanVien.MaNhanVien FROM NhanVien "
                + "JOIN TaiKhoan ON NhanVien.TaiKhoan = TaiKhoan.MaTaiKhoan "
                + "WHERE TaiKhoan.TenDangNhap = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tenDangNhap);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maNhanVien = rs.getString("MaNhanVien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maNhanVien;
    }
}
