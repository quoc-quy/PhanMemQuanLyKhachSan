/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import ENTITY.KhachHang;
import ENTITY.LoaiNhanVien;
import ENTITY.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVien_DAO {
    private ConnectDB dbConnection = new ConnectDB();
    
//    kiểm tra coi có phải là Quản Lý 
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
    
//  kiểm tra coi có phải là Lễ tân
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
    
//  Lấy tên nhân viên bằng mã tài khoản
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
    
//  lấy danh sách nhân viên
    
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> dsNhanVien = new ArrayList<>();
        String query = "SELECT * FROM NhanVien";

        try (Connection conn = dbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
            	// Chuyển chuỗi lấy từ cơ sở dữ liệu thành enum
                String loaiNhanVienStr = rs.getString("LoaiNhanVien");
                LoaiNhanVien loaiNhanVien = LoaiNhanVien.valueOf(loaiNhanVienStr); 
                
                NhanVien nv = new NhanVien(
                    rs.getString("MaNhanVien"),
                    rs.getString("TenNhanVien"),
                    loaiNhanVien,
                    rs.getString("Phai"),
                    rs.getDate("NgaySinh"),
                    rs.getString("CCCD"),
                    rs.getString("SDT")
                );
                dsNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNhanVien;
    }
}
