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

        try (Connection conn = ConnectDB.getConnection();
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
    	try(Connection conn = ConnectDB.getConnection();
    		PreparedStatement ps = conn.prepareStatement(query)){
    		
    		ps.setString(1, khachHang.getMaKhachHang());
    		ps.setString(2,khachHang.getTenKhachHang());
    		ps.setString(3, khachHang.getCCCD());
    		ps.setString(4, khachHang.getPhai());
    		ps.setDate(5, new java.sql.Date(khachHang.getNgaySinh().getTime()));
    		ps.setString(6, khachHang.getDienThoai());
    		return ps.executeUpdate()>0;
    	} catch(SQLException e ) {
    		
    		return false;
    	}
    } 
    public boolean xoaKhachHang(String maKhachHang) {
    	String query = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
    	try(Connection conn = ConnectDB.getConnection();
   			 PreparedStatement ps = conn.prepareStatement(query)){
	    		 ps.setString(1, maKhachHang);
	    		 return ps.executeUpdate() > 0;
   	 	} catch (SQLException e ) {
   	 		
   	 	}
    	return true;
    }
    
    public boolean updateKhachHang(KhachHang khachHang) {
    	String query = "UPDATE KhachHang SET TenKhachHang = ?, CCCD = ?, Phai = ?, NgaySinh = ?, DienThoai = ? WHERE MaKhachHang = ?";
    	try(Connection conn = ConnectDB.getConnection();
    			PreparedStatement ps = conn.prepareStatement(query)){
    		ps.setString(1, khachHang.getTenKhachHang());
    		ps.setString(2, khachHang.getCCCD());
    		ps.setString(3, khachHang.getPhai());
    		ps.setDate(4, (Date) khachHang.getNgaySinh());
    		ps.setString(5, khachHang.getDienThoai());
    		ps.setString(6, khachHang.getMaKhachHang());
    		return ps.executeUpdate() > 0;
    	} catch(SQLException e ) {
    		
    	}
    	return false;
    }
    
    public KhachHang findMaKhachHangID(String maKhachHang) {
    	KhachHang khachHang = null;
    	String query = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
    	try(Connection conn = ConnectDB.getConnection();
    			PreparedStatement ps = conn.prepareStatement(query)){
    		ps.setString(1, maKhachHang);
    		ResultSet rs = ps.executeQuery();
    		
    		if (rs.next()) {
                khachHang = new KhachHang();
                khachHang.setMaKhachHang(rs.getString("MaKhachHang"));
                khachHang.setTenKhachHang(rs.getString("TenKhachHang"));
                khachHang.setCCCD(rs.getString("CCCD"));
                khachHang.setPhai(rs.getString("Phai"));
                khachHang.setNgaySinh(rs.getDate("NgaySinh"));
                khachHang.setDienThoai(rs.getString("DenThoai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHang;

    }
    
    public String getNextCustomerID() {
        String lastCustomerID = null;
        String sql = "SELECT TOP 1 MaKhachHang FROM KhachHang ORDER BY MaKhachHang DESC";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                lastCustomerID = rs.getString("MaKhachHang");
//                System.out.println("Last Customer ID: " + lastCustomerID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "KH0001"; // Trả về mã mặc định nếu có lỗi truy vấn
        }

        // Nếu có mã cuối cùng, tách phần tiền tố và phần số
        if (lastCustomerID != null) {
            String prefix = lastCustomerID.substring(0, 2); // Lấy 2 ký tự đầu

            // Đổi thành "KH" nếu tiền tố là "KM"
            if (!prefix.equals("KH")) {
                prefix = "KH";
            }

            String numberPart = lastCustomerID.substring(2); // Lấy phần số từ mã
            
            try {
                int currentID = Integer.parseInt(numberPart); // Chuyển phần số thành số nguyên
                int nextID = currentID + 1;
                return String.format("%s%04d", prefix, nextID); // Tạo mã mới với tiền tố KH và tăng số
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Ghi lại lỗi nếu phần số không hợp lệ
                return "KH0001"; // Trả về mã mặc định nếu xảy ra lỗi
            }
        }

        // Nếu không có mã nào trong cơ sở dữ liệu, bắt đầu từ KH0001
        return "KH0001";
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
   
    // Phương thức lấy mã khách hàng dựa vào CCCD
    public String getMaKhachHangByCCCD(String cccd) {
        String maKhachHang = null;
        
        String sql = "SELECT MaKhachHang FROM KhachHang WHERE CCCD = ?";
        
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, cccd);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                maKhachHang = rs.getString("MaKhachHang");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return maKhachHang;
    }
    
 // Phương thức lấy mã khách hàng dựa vào CCCD
    public String getCCCDByMaKhachHang(String maKH) {
        String CCCD = null;
        
        String sql = "SELECT CCCD FROM KhachHang WHERE MaKhachHang = ?";
        
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, maKH);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
            	CCCD = rs.getString("CCCD");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return CCCD;
    }
    
 // Phương thức để lấy mã khách hàng dựa trên mã phòng
    public String layMaKhachHangTheoMaPhong(String maPhong) {
        String maKhachHang = null;
        String sql = "SELECT TOP 1 pdp.MaKhachHang "
                   + "FROM ChiTietHoaDon cthd "
                   + "JOIN PhieuDatPhong pdp ON cthd.MaPhong = pdp.MaPhong "
                   + "JOIN Phong p ON p.MaPhong = pdp.MaPhong "
                   + "WHERE pdp.TrangThai = N'Đã nhận' "
                   + "AND p.MaPhong = ?";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Gán giá trị cho tham số trong câu lệnh SQL
            stmt.setString(1, maPhong);  // Gán MaPhong vào tham số đầu tiên

            // Thực thi câu lệnh SELECT
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    maKhachHang = rs.getString("MaKhachHang");  // Lấy MaKhachHang từ kết quả
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maKhachHang; // Nếu không tìm thấy, trả về null
    }
}

    

