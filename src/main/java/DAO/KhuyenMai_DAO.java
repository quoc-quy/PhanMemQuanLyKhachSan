/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import ENTITY.KhuyenMai;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Snowy
 */
public class KhuyenMai_DAO {
	private ConnectDB dbConnection = new ConnectDB();
	
//	 Kiểm tra mã khuyến mãi
	 public boolean isExp(String maKhuyenMai) {
		 boolean isExp = false;
		 Connection connection=dbConnection.getConnection();
		 try {
			 String query = "SELECT * FROM KhuyenMai WHERE MaKhuyenMai = ? AND TrangThai = 'Het hang'";
			 PreparedStatement ps = connection.prepareStatement(query);
			 ps.setString(1, maKhuyenMai);
			 ResultSet rs = ps.executeQuery();
			 
			 if(rs.next()) {
				 isExp=true;
			 }
		 } catch(SQLException e) {
			
		 }
		 return isExp;
	 }
	public boolean isActive(String maKhuyenMai) {
		boolean isActive = false;
		Connection connection = dbConnection.getConnection();
		try {
			String query = "SELECT * FROM KhuyenMai WHERE MaKhuyenMai = ? AND TrangThai = 'Hoat dong'";
			 PreparedStatement ps = connection.prepareStatement(query);
	         ps.setString(1, maKhuyenMai);
	         ResultSet rs = ps.executeQuery();
	         
	         if(rs.next()) {
	        	 isActive=true;
	         }
		}catch(SQLException e){
			
		}
		return isActive;
	}
	public String  getMoTaByMaKhuyenMai(String maKhuyenMai) {
		String moTa="";
		String query = "SELECT MoTa FROM KhuyenMai WHERE MaKhuyenMai = ?";
		try(Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, maKhuyenMai);
			 ResultSet rs = ps.executeQuery();
			 
			 if(rs.next()) {
				 moTa=rs.getString("MoTa");
			 }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return moTa;
	}

    // Phương thức loadData để lấy tất cả dữ liệu từ bảng KhuyenMai
    public List<KhuyenMai> getAllKhuyenMai() {
        List<KhuyenMai> dsKhuyenMai = new ArrayList<>();
        String query = "SELECT * FROM KhuyenMai";
        
        try (Connection conn = dbConnection.getConnection();
            Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
              KhuyenMai km;
                km = new KhuyenMai(
                        rs.getString("MaKhuyenMai"),
                        rs.getString("MoTa"),
                        rs.getDate("NgayBatDau"),
                        rs.getDate("NgayKetThuc"),
                        rs.getString("TrangThai"),
                        rs.getInt("ChietKhau")
                );
                
                
                dsKhuyenMai.add(km);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dsKhuyenMai;
    }
    
//    add khuyen mai 
    public boolean addKhuyenMai(KhuyenMai khuyenMai) {
    	String query = "INSERT INTO KhuyenMai (MaKhuyenMai, MoTa, NgayBatDau, NgayKetThuc, TrangThai, ChietKhau) VALUES (?, ?, ?, ?, ?, ?)";
    	try(Connection conn = dbConnection.getConnection();
    		PreparedStatement ps = conn.prepareStatement(query)){
    		ps.setString(1,khuyenMai.getMakhuyenMai());
    		ps.setString(2,khuyenMai.getMoTa());
    		ps.setDate(3,(Date) khuyenMai.getNgayBatDau());
    		ps.setDate(4,(Date) khuyenMai.getNgayKetThuc());
    		ps.setString(5,khuyenMai.getTrangThai());
    		ps.setInt(6,khuyenMai.getChietKhau());
    			return ps.executeUpdate()>0;
    	}catch(SQLException e) {
    		
    	}
    	return false;
    }
    
    public boolean updateKhuyenMai(KhuyenMai khuyenMai) {
    	String query = "UPDATE KhuyenMai SET MoTa = ?, NgayBatDau = ?, NgayKetThuc = ?, TrangThai = ?, ChietKhau = ? WHERE MaKhuyenMai = ?";
    	try(Connection conn = dbConnection.getConnection();
    			PreparedStatement ps = conn.prepareStatement(query)){
    		ps.setString(1, khuyenMai.getMakhuyenMai());
    		ps.setString(2,khuyenMai.getMoTa());
    		ps.setDate(3,(Date) khuyenMai.getNgayBatDau());
    		ps.setDate(4, (Date) khuyenMai.getNgayKetThuc());
    		ps.setString(5, khuyenMai.getTrangThai());
    		ps.setInt(6,khuyenMai.getChietKhau());
    		return ps.executeUpdate() > 0;
    	}catch(SQLException e) {
    		
    	}
    	return false;
    }
    
    public boolean deleteKhuyenMai(String maKhuyenMai) {
    	 String query = "DELETE FROM KhuyenMai WHERE MaKhuyenMai = ?";
    	 try(Connection conn = dbConnection.getConnection();
    			 PreparedStatement ps = conn.prepareStatement(query)){
	    		 ps.setString(1, maKhuyenMai);
	    		 return ps.executeUpdate() > 0;
    	 } catch(SQLException e) {
    		 
    	 }
    	 return false;
    }
    
    public KhuyenMai findMaKhuyenMai(String maKhuyenMai) {
    	KhuyenMai khuyenMai = null;
    	String query = "SELECT * FROM KhuyenMai WHERE MaKhuyenMai = ?";
    	try(Connection conn = dbConnection.getConnection();
    			PreparedStatement ps = conn.prepareStatement(query)){
    		ps.setString(1, maKhuyenMai);
    		ResultSet rs = ps.executeQuery();
    		
    		if(rs.next()) {
    			khuyenMai = new KhuyenMai(
    					rs.getString("MaKhuyenMai"),
                        rs.getString("MoTa"),
                        rs.getDate("NgayBatDau"),
                        rs.getDate("NgayKetThuc"),
                        rs.getString("TrangThai"),
                        rs.getInt("ChietKhau")
    			);
    		}
    	} catch(SQLException e) {
    		
    	}
    	return khuyenMai;
    }
}