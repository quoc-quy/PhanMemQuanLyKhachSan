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
public class NhanVien_DAO {
    private ConnectDB dbConnection = new ConnectDB();

    public boolean isManager(String maTaiKhoan) {
        boolean isManager = false;
        Connection connection = dbConnection.getConnection();
        try {
            String query = "SELECT * FROM NHANVIEN WHERE TaiKhoan=? AND LoaiNhanVien='NV_QUANLY'";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maTaiKhoan);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isManager = true;
            }
        } catch (SQLException e) {
        }
        return isManager;
    }
    
    public boolean isReceptionist(String maTaiKhoan) {
        boolean isReceptionist = false;
        Connection connection = dbConnection.getConnection();
        try {
            String query = "SELECT * FROM NHANVIEN WHERE TaiKhoan=? AND LoaiNhanVien='NV_LETAN'";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maTaiKhoan);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isReceptionist = true;
            }
        } catch (SQLException e) {
        }
        return isReceptionist;
    }
    
    public String getTenNhanVienByMaTaiKhoan(String maTaiKhoan) {
        String tenNhanVien = "";
        String query = "SELECT TenNhanVien FROM NhanVien WHERE TaiKhoan = ?";
        
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, maTaiKhoan);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                tenNhanVien = rs.getString("TenNhanVien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tenNhanVien;
    }
}
