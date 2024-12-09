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
import ENTITY.HoaDon;
import ENTITY.LichSuChuyenPhong;
import ENTITY.NhanVien;

public class LichSuChuyenPhong_DAO {
	private final ConnectDB connectDB = new ConnectDB();
	
	public List<Object[]> getAllLichSuChuyenPhong() {
	    List<Object[]> danhSachLichSu = new ArrayList<>();

	    String sql = 
	        "SELECT lscp.MaChuyenPhong, lscp.MaPhieuDatPhong, lscp.PhongCu, lscp.PhongMoi, lscp.LyDo, lscp.NgayChuyenPhong " +
	        "FROM LichSuChuyenPhong lscp";

	    try (Connection conn = ConnectDB.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        int index = 1; // Biến đếm bắt đầu từ 1 cho số thứ tự dòng
	        while (rs.next()) {
	            String maChuyenPhong = rs.getString("MaChuyenPhong");
	            String maPhieuDatPhong = rs.getString("MaPhieuDatPhong");
	            String phongCu = rs.getString("PhongCu");
	            String phongMoi = rs.getString("PhongMoi");
	            String lyDo = rs.getString("LyDo");
	            Date ngayChuyenPhong = rs.getDate("NgayChuyenPhong");

	            // Thêm dòng dữ liệu vào danh sách
	            Object[] row = {
	                index,  // Số thứ tự dòng
	                maChuyenPhong,
	                maPhieuDatPhong,
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
	
	public boolean checkMaPDPExists(String maPDP) {
	    String sql = "SELECT COUNT(*) FROM PhieuDatPhong WHERE MaPhieuDatPhong = ?";
	    try (Connection conn = ConnectDB.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, maPDP);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1) > 0;  // Trả về true nếu MaPDP tồn tại
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;  // Trả về false nếu không tồn tại
	}

	public boolean saveLichSuChuyenPhong(LichSuChuyenPhong lichSuChuyenPhong) {
	    // In giá trị MaPDP ra console trước khi thực hiện INSERT
	    String maPDP = lichSuChuyenPhong.getMaPDP();
	    System.out.println("MaPhieuDatPhong cần chèn vào LichSuChuyenPhong: " + maPDP);

	    // Tiến hành kiểm tra và chèn dữ liệu vào bảng LichSuChuyenPhong
	    if (!checkMaPDPExists(maPDP)) {
	        System.out.println("Mã Phiếu Đặt Phòng không tồn tại.");
	        return false;
	    }

	    // Tiến hành thực hiện INSERT vào bảng LichSuChuyenPhong
	    try (Connection conn = ConnectDB.getConnection()) {
	        String sql = "INSERT INTO LichSuChuyenPhong (maChuyenPhong, maPhieuDatPhong, phongCu, phongMoi, lyDo, ngayChuyenPhong) "
	                   + "VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        
	        stmt.setString(1, lichSuChuyenPhong.getMaChuyenPhong());
	        stmt.setString(2, maPDP);  // Chèn MaPDP vào
	        stmt.setString(3, lichSuChuyenPhong.getPhongCu());
	        stmt.setString(4, lichSuChuyenPhong.getPhongMoi());
	        stmt.setString(5, lichSuChuyenPhong.getLyDo());
	        stmt.setDate(6, new java.sql.Date(lichSuChuyenPhong.getNgayChuyenPhong().getTime()));

	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
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
	
	public List<Object[]> getLichSuChuyenPhongTheoKhoangThoiGian(java.sql.Date ngayCheckIn, java.sql.Date ngayCheckOut) {
	    List<Object[]> danhSachLichSu = new ArrayList<>();

	    // Sửa câu lệnh SQL để lọc theo Ngày chuyển phòng
	    String sql = "SELECT lscp.MaChuyenPhong, lscp.MaPhieuDatPhong, lscp.PhongCu, lscp.PhongMoi, lscp.LyDo, lscp.NgayChuyenPhong " +
	                 "FROM LichSuChuyenPhong lscp " +
	                 "WHERE lscp.NgayChuyenPhong BETWEEN ? AND ?";  // Điều kiện lọc theo ngày

	    try (Connection conn = ConnectDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        // Thiết lập tham số cho câu truy vấn SQL
	        ps.setDate(1, ngayCheckIn);
	        ps.setDate(2, ngayCheckOut);

	        // Thực thi truy vấn và lấy kết quả
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String maChuyenPhong = rs.getString("MaChuyenPhong");
	            String maPhieuDatPhong = rs.getString("MaPhieuDatPhong");
	            String phongCu = rs.getString("PhongCu");
	            String phongMoi = rs.getString("PhongMoi");
	            String lyDo = rs.getString("LyDo");
	            Date ngayChuyenPhong = rs.getDate("NgayChuyenPhong");

	            // Thêm một dòng dữ liệu vào danh sách
	            Object[] row = {
	                maChuyenPhong,
	                maPhieuDatPhong,
	                phongCu,
	                phongMoi,
	                lyDo,
	                ngayChuyenPhong
	            };

	            // Thêm dòng vào danh sách
	            danhSachLichSu.add(row);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return danhSachLichSu;
	}




}
