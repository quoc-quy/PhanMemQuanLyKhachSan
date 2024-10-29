package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectDB.ConnectDB;


public class KhuyenMai_DAO {
			 private ConnectDB dbConnection = new ConnectDB();
		 
//		 Kiểm tra mã khuyến mãi
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
				 e.printStackTrace();
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
				e.printStackTrace();
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
	}

