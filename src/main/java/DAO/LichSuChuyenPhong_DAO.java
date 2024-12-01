package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ConnectDB.ConnectDB;
import ENTITY.LichSuChuyenPhong;

public class LichSuChuyenPhong_DAO {
	private final ConnectDB connectDB = new ConnectDB();
	
	public List<Object[]> getAllLichSuChuyenPhong() {
	    List<Object[]> danhSachLichSu = new ArrayList<>();

	    String sql = 
	        "SELECT lscp.MaChuyenPhong, lscp.PhongCu, lscp.PhongMoi, lscp.LyDo, lscp.NgayChuyenPhong " +
	        "FROM LichSuChuyenPhong lscp";

	    try (Connection conn = ConnectDB.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        int index = 1; // Biến đếm bắt đầu từ 1 cho số thứ tự dòng
	        while (rs.next()) {
	            String maChuyenPhong = rs.getString("MaChuyenPhong");
	            String phongCu = rs.getString("PhongCu");
	            String phongMoi = rs.getString("PhongMoi");
	            String lyDo = rs.getString("LyDo");
	            Date ngayChuyenPhong = rs.getDate("NgayChuyenPhong");

	            // Thêm dòng dữ liệu vào danh sách
	            Object[] row = {
	                index,  // Số thứ tự dòng
	                maChuyenPhong,  // Mã chuyển phòng
	                phongCu,  // Phòng cũ
	                phongMoi,  // Phòng mới
	                lyDo,  // Lí do chuyển phòng
	                ngayChuyenPhong  // Ngày chuyển phòng
	            };
	            danhSachLichSu.add(row);
	            index++;  // Tăng biến đếm lên 1 cho dòng tiếp theo
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return danhSachLichSu;  // Trả về danh sách các dòng dữ liệu
	}
	
	public boolean saveLichSuChuyenPhong(LichSuChuyenPhong lichSuChuyenPhong) {
	    // Kết nối tới cơ sở dữ liệu thông qua ConnectDB
	    try (Connection conn = ConnectDB.getConnection()) {  
	        // Câu lệnh SQL để chèn dữ liệu vào bảng LichSuChuyenPhong
	        String sql = "INSERT INTO LichSuChuyenPhong (maChuyenPhong, phongCu, phongMoi, lyDo, ngayChuyenPhong) VALUES (?, ?, ?, ?, ?)";

	        // Tạo PreparedStatement từ kết nối
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        
	        // Gán giá trị cho các tham số trong câu lệnh SQL
	        stmt.setString(1, lichSuChuyenPhong.getMaChuyenPhong());
	        stmt.setString(2, lichSuChuyenPhong.getPhongCu());
	        stmt.setString(3, lichSuChuyenPhong.getPhongMoi());
	        stmt.setString(4, lichSuChuyenPhong.getLyDo());
	        stmt.setDate(5, new java.sql.Date(lichSuChuyenPhong.getNgayChuyenPhong().getTime()));
	        
	        // Thực thi câu lệnh SQL
	        int rowsAffected = stmt.executeUpdate();
	        
	        // Nếu có ít nhất 1 bản ghi bị thay đổi (chèn thành công), trả về true
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        // Nếu có lỗi xảy ra, in ra thông báo lỗi
	        e.printStackTrace();
	        return false;  // Nếu có lỗi, trả về false
	    }
	}
	
	public String generateMaChuyenPhong() {
	    String maChuyenPhong = "CP";
	    int maxNumber = 0;

	    // Lấy số thứ tự cao nhất từ cơ sở dữ liệu
	    String sql = "SELECT MAX(CAST(SUBSTRING(MaChuyenPhong, 3, LEN(MaChuyenPhong)) AS INT)) FROM LichSuChuyenPhong";
	    
	    try (Connection conn = ConnectDB.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        if (rs.next()) {
	            maxNumber = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Tăng thêm 1 vào số thứ tự và tạo mã mới
	    maChuyenPhong += String.format("%03d", maxNumber + 1);

	    return maChuyenPhong;
	}
	
}
