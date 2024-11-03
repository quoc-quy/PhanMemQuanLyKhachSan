package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import ENTITY.KhachHang;
import ENTITY.KhuyenMai;

public class KhachHang_DAO {
	private final ConnectDB connectDB = new ConnectDB();

//  lấy danh sách khách hàng
    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> dsKhachHang = new ArrayList<>();
        String query = "SELECT * FROM KhachHang";

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                KhachHang kh = new KhachHang(
                    rs.getString("MaKhachHang"),
                    rs.getString("TenKhachHang"),
                    rs.getString("CCCD"),
                    rs.getString("Phai"),
                    rs.getDate("NgaySinh"),
                    rs.getString("DenThoai")
                );
                dsKhachHang.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKhachHang;
    }
    
    public boolean addKhachHang(KhachHang khachHang) {
    	String query = "INSERT INTO KhachHang (MaKhachHang, TenKhachHang, CCCD, Phai, NgaySinh, DenThoai) VALUES (?, ?, ?, ?, ? ,?)";
    	try(Connection conn = connectDB.getConnection();
    		PreparedStatement ps = conn.prepareStatement(query)){
    		ps.setString(1, khachHang.getMaKhachHang());
    		ps.setString(2,khachHang.getTenKhachHang());
    		ps.setString(3, khachHang.getCCCD());
    		ps.setString(4, khachHang.getPhai());
    		ps.setDate(5, new java.sql.Date(khachHang.getNgaySinh().getTime()));
    		ps.setString(6, khachHang.getDienThoai());
    		return ps.executeUpdate()>0;
    	} catch(SQLException e ) {
    		
    	}
    	return false;
    } 
    public boolean xoaKhachHang(String maKhachHang) {
    	String query = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
    	try(Connection conn = connectDB.getConnection();
   			 PreparedStatement ps = conn.prepareStatement(query)){
	    		 ps.setString(1, maKhachHang);
	    		 return ps.executeUpdate() > 0;
   	 	} catch (SQLException e ) {
   	 		
   	 	}
    	return false;
    }
    
    public boolean updateKhachHang(KhachHang khachHang) {
    	String query = "UPDATE KhachHang SET TenKhachHang = ?, CCCD = ?, Phai = ?, NgaySinh = ?, DienThoai = ? WHERE MaKhachHang = ?";
    	try(Connection conn = connectDB.getConnection();
    			PreparedStatement ps = conn.prepareStatement(query)){
    		ps.setString(1, khachHang.getMaKhachHang());
    		ps.setString(2, khachHang.getTenKhachHang());
    		ps.setString(3, khachHang.getCCCD());
    		ps.setString(4, khachHang.getPhai());
    		ps.setDate(5, (Date) khachHang.getNgaySinh());
    		ps.setString(6, khachHang.getDienThoai());
    		return ps.executeUpdate() > 0;
    	} catch(SQLException e ) {
    		
    	}
    	return false;
    }
    public KhachHang findMaKhachHang(String maKhachHang) {
    	KhachHang khachHang = null;
    	String query = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
    	try(Connection conn = connectDB.getConnection();
    			PreparedStatement ps = conn.prepareStatement(query)){
    		ps.setString(1, maKhachHang);
    		ResultSet rs = ps.executeQuery();
    		
    		if(rs.next()) {
    			khachHang = new KhachHang(
    					rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getString("CCCD"),
                        rs.getString("Phai"),
                        rs.getDate("NgaySinh"),
                        rs.getString("DienThoat")
    			);
    		}
    	} catch(SQLException e) {
    		
    	}
    	return khachHang;
    }
    
    public String getNextCustomerID() {
        String lastCustomerID = null;
        String sql = "SELECT MaKhachHang FROM KhachHang ORDER BY MaKhachHang DESC LIMIT 1";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            if (rs.next()) {
                lastCustomerID = rs.getString("MaKhachHang");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Tạo mã mới dựa trên mã gần nhất
        if (lastCustomerID != null) {
            int nextID = Integer.parseInt(lastCustomerID.substring(2)) + 1;
            return String.format("KH%04d", nextID); // Tạo mã dưới dạng KHxxxx
        } else {
            return "KH0001"; // Nếu không có mã nào thì bắt đầu từ KH0001
        }
    }
    
    // Phương thức lấy tất cả CCCD khách hàng từ cơ sở dữ liệu
    public List<String> getAllCustomerCCCD() {
        List<String> customerCCCDs = new ArrayList<>();
        try (Connection conn = ConnectDB.getConnection()) {
            String query = "SELECT CCCD FROM KhachHang";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                customerCCCDs.add(rs.getString("CCCD"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerCCCDs;
    }
    
 // Phương thức lấy thông tin khách hàng theo CCCD
    public KhachHang getCustomerByCCCD(String cccd) {
        KhachHang khachHang = null;
        try (Connection conn = ConnectDB.getConnection()) {
            String query = "SELECT * FROM KhachHang WHERE CCCD = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cccd);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                khachHang = new KhachHang(
                    rs.getString("MaKhachHang"),
                    rs.getString("TenKhachHang"),
                    rs.getString("CCCD"),
                    rs.getString("Phai"),
                    rs.getDate("NgaySinh"),
                    rs.getString("DenThoai")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }
}
