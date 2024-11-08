package DAO;

import ENTITY.LoaiPhong;
import ENTITY.PhieuDatPhong;
import ENTITY.Phong;
import ENTITY.TinhTrangPhong;
import ENTITY.TrangThaiPhong;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import ConnectDB.ConnectDB;

public class Phong_DAO {
	private final ConnectDB connectDB = new ConnectDB();
	
	public List<Phong> getAllPhong() {
        List<Phong> dsPhong = new ArrayList<>();
        String query = "SELECT MaPhong, SoNguoiLon, SoTreEm, TrangThaiPhong, TinhTrangPhong, " +
                "LoaiPhong.MaLoaiPhong, LoaiPhong.TenLoaiPhong, " +
                "LoaiPhong.GiaTienTheoNgay, LoaiPhong.GiaTienTheoGio " +
                "FROM Phong " +
                "JOIN LoaiPhong ON Phong.LoaiPhong = LoaiPhong.MaLoaiPhong";

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Tạo đối tượng LoaiPhong
            	LoaiPhong loaiPhong = new LoaiPhong(
            		    rs.getString("MaLoaiPhong"),
            		    rs.getString("TenLoaiPhong"),
            		    rs.getDouble("GiaTienTheoGio"),
            		    rs.getDouble("GiaTienTheoNgay"),
            		    false
            		);

                // Lấy giá trị enum từ chuỗi trong cơ sở dữ liệu
                TrangThaiPhong trangThai = TrangThaiPhong.valueOf(rs.getString("TrangThaiPhong"));
                TinhTrangPhong tinhTrang = TinhTrangPhong.valueOf(rs.getString("TinhTrangPhong"));

                // Tạo đối tượng Phong
                Phong phong = new Phong(
                    rs.getString("MaPhong"),
                    loaiPhong,
                    rs.getInt("SoNguoiLon"),
                    rs.getInt("SoTreEm"),
                    trangThai,
                    tinhTrang
                );

                dsPhong.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhong;
    }
	
	
	public boolean updateTinhTrangPhong(String maPhong, String tinhTrangMoi) {
	    try (Connection conn = ConnectDB.getConnection()) {
	        String sql = "UPDATE Phong SET TinhTrangPhong = ? WHERE MaPhong = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, tinhTrangMoi);
	        stmt.setString(2, maPhong);
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	
	public void capNhatTrangThaiPhong(String maPhong, String trangThai) {
	    String sql = "UPDATE Phong SET TrangThaiPhong = ? WHERE MaPhong = ?";
	    
	    try (Connection conn = ConnectDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setString(1, trangThai);
	        ps.setString(2, maPhong);
	        
	        ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public List<Phong> getPhongTrong() {
	    List<Phong> dsPhong = new ArrayList<>();
	    String query = "SELECT MaPhong, SoNguoiLon, SoTreEm, TrangThaiPhong, TinhTrangPhong, " +
	                   "LoaiPhong.MaLoaiPhong, LoaiPhong.TenLoaiPhong, " +
	                   "LoaiPhong.GiaTienTheoNgay, LoaiPhong.GiaTienTheoGio " +
	                   "FROM Phong " +
	                   "JOIN LoaiPhong ON Phong.LoaiPhong = LoaiPhong.MaLoaiPhong " +
	                   "WHERE TrangThaiPhong = 'PHONG_TRONG'"; // Chỉ điều kiện TrangThaiPhong
	    
	    try (Connection conn = connectDB.getConnection(); 
	         Statement stmt = conn.createStatement(); 
	         ResultSet rs = stmt.executeQuery(query)) {
	        
	        while (rs.next()) {
	            // Tạo đối tượng LoaiPhong
	            LoaiPhong loaiPhong = new LoaiPhong(
	                rs.getString("MaLoaiPhong"),
	                rs.getString("TenLoaiPhong"),
	                rs.getDouble("GiaTienTheoGio"),
	                rs.getDouble("GiaTienTheoNgay"),
	                false
	            );

	            // Lấy giá trị enum từ chuỗi trong cơ sở dữ liệu
	            TrangThaiPhong trangThai = TrangThaiPhong.valueOf(rs.getString("TrangThaiPhong"));
	            TinhTrangPhong tinhTrang = TinhTrangPhong.valueOf(rs.getString("TinhTrangPhong"));

	            // Tạo đối tượng Phong
	            Phong phong = new Phong(
	                rs.getString("MaPhong"),
	                loaiPhong,
	                rs.getInt("SoNguoiLon"),
	                rs.getInt("SoTreEm"),
	                trangThai,
	                tinhTrang
	            );

	            dsPhong.add(phong);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dsPhong;
	}
	
	public List<Phong> getPhongDangSuDung() {
	    List<Phong> dsPhong = new ArrayList<>();
	    String query = "SELECT MaPhong, SoNguoiLon, SoTreEm, TrangThaiPhong, TinhTrangPhong, " +
	                   "LoaiPhong.MaLoaiPhong, LoaiPhong.TenLoaiPhong, " +
	                   "LoaiPhong.GiaTienTheoNgay, LoaiPhong.GiaTienTheoGio " +
	                   "FROM Phong " +
	                   "JOIN LoaiPhong ON Phong.LoaiPhong = LoaiPhong.MaLoaiPhong " +
	                   "WHERE TrangThaiPhong = 'DANG_SU_DUNG'"; // Chỉ điều kiện TrangThaiPhong
	    
	    try (Connection conn = connectDB.getConnection(); 
	         Statement stmt = conn.createStatement(); 
	         ResultSet rs = stmt.executeQuery(query)) {
	        
	        while (rs.next()) {
	            // Tạo đối tượng LoaiPhong
	            LoaiPhong loaiPhong = new LoaiPhong(
	                rs.getString("MaLoaiPhong"),
	                rs.getString("TenLoaiPhong"),
	                rs.getDouble("GiaTienTheoGio"),
	                rs.getDouble("GiaTienTheoNgay"),
	                false
	            );

	            // Lấy giá trị enum từ chuỗi trong cơ sở dữ liệu
	            TrangThaiPhong trangThai = TrangThaiPhong.valueOf(rs.getString("TrangThaiPhong"));
	            TinhTrangPhong tinhTrang = TinhTrangPhong.valueOf(rs.getString("TinhTrangPhong"));

	            // Tạo đối tượng Phong
	            Phong phong = new Phong(
	                rs.getString("MaPhong"),
	                loaiPhong,
	                rs.getInt("SoNguoiLon"),
	                rs.getInt("SoTreEm"),
	                trangThai,
	                tinhTrang
	            );

	            dsPhong.add(phong);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dsPhong;
	}

	public List<Phong> getPhongChuaDon() {
	    List<Phong> dsPhong = new ArrayList<>();
	    String query = "SELECT MaPhong, SoNguoiLon, SoTreEm, TrangThaiPhong, TinhTrangPhong, " +
	                   "LoaiPhong.MaLoaiPhong, LoaiPhong.TenLoaiPhong, " +
	                   "LoaiPhong.GiaTienTheoNgay, LoaiPhong.GiaTienTheoGio " +
	                   "FROM Phong " +
	                   "JOIN LoaiPhong ON Phong.LoaiPhong = LoaiPhong.MaLoaiPhong " +
	                   "WHERE TinhTrangPhong = 'CHUA_DON'"; // Chỉ điều kiện TrangThaiPhong
	    
	    try (Connection conn = connectDB.getConnection(); 
	         Statement stmt = conn.createStatement(); 
	         ResultSet rs = stmt.executeQuery(query)) {
	        
	        while (rs.next()) {
	            // Tạo đối tượng LoaiPhong
	            LoaiPhong loaiPhong = new LoaiPhong(
	                rs.getString("MaLoaiPhong"),
	                rs.getString("TenLoaiPhong"),
	                rs.getDouble("GiaTienTheoGio"),
	                rs.getDouble("GiaTienTheoNgay"),
	                false
	            );

	            // Lấy giá trị enum từ chuỗi trong cơ sở dữ liệu
	            TrangThaiPhong trangThai = TrangThaiPhong.valueOf(rs.getString("TrangThaiPhong"));
	            TinhTrangPhong tinhTrang = TinhTrangPhong.valueOf(rs.getString("TinhTrangPhong"));

	            // Tạo đối tượng Phong
	            Phong phong = new Phong(
	                rs.getString("MaPhong"),
	                loaiPhong,
	                rs.getInt("SoNguoiLon"),
	                rs.getInt("SoTreEm"),
	                trangThai,
	                tinhTrang
	            );

	            dsPhong.add(phong);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dsPhong;
	}

	
	public List<Phong> getPhongByType(String loaiPhong) {
	    List<Phong> dsPhong = new ArrayList<>();

	    // Tạo câu truy vấn để tìm các phòng theo loại phòng (không sử dụng N)
	    String query = "SELECT MaPhong, SoNguoiLon, SoTreEm, TrangThaiPhong, TinhTrangPhong, " +
	               "LoaiPhong.MaLoaiPhong, LoaiPhong.TenLoaiPhong, " +
	               "LoaiPhong.GiaTienTheoNgay, LoaiPhong.GiaTienTheoGio " +
	               "FROM Phong " +
	               "JOIN LoaiPhong ON Phong.LoaiPhong = LoaiPhong.MaLoaiPhong " +
	               "WHERE LoaiPhong.TenLoaiPhong COLLATE SQL_Latin1_General_CP1_CI_AI LIKE ?";


	    try (Connection conn = connectDB.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        
	        // Đặt tham số cho câu truy vấn, thêm % để tìm kiếm gần đúng
	        stmt.setString(1, "%" + loaiPhong + "%");
	        System.out.println("Chuỗi truy vấn SQL: " + stmt);

	        ResultSet rs = stmt.executeQuery();

	        int resultCount = 0; // Biến đếm số kết quả
	        while (rs.next()) {
	            resultCount++;

	            // Tạo đối tượng LoaiPhong từ kết quả truy vấn
	            LoaiPhong loaiPhongObj = new LoaiPhong(
	                rs.getString("MaLoaiPhong"),
	                rs.getString("TenLoaiPhong"),
	                rs.getDouble("GiaTienTheoGio"),
	                rs.getDouble("GiaTienTheoNgay"),
	                false
	            );

	            // Lấy giá trị enum từ chuỗi trong cơ sở dữ liệu
	            TrangThaiPhong trangThai = TrangThaiPhong.valueOf(rs.getString("TrangThaiPhong"));
	            TinhTrangPhong tinhTrang = TinhTrangPhong.valueOf(rs.getString("TinhTrangPhong"));

	            // Tạo đối tượng Phong từ kết quả truy vấn
	            Phong phong = new Phong(
	                rs.getString("MaPhong"),
	                loaiPhongObj,
	                rs.getInt("SoNguoiLon"),
	                rs.getInt("SoTreEm"),
	                trangThai,
	                tinhTrang
	            );

	            dsPhong.add(phong);
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); // In lỗi nếu có vấn đề khi thực hiện truy vấn
	    }

	    return dsPhong;
	}

	public List<Phong> getPhongTrongTrongKhoangThoiGian(java.util.Date selectedCheckInDate, java.util.Date selectedCheckOutDate) {
	    List<Phong> dsPhongTrong = new ArrayList<>();

	    // Lấy tất cả các phòng từ database
	    List<Phong> dsPhong = getAllPhong(); // Phương thức này lấy tất cả phòng từ bảng Phong

	    // Lấy danh sách tất cả các phiếu đặt phòng từ database
	    PhieuDatPhong_DAO phieuDatPhongDAO = new PhieuDatPhong_DAO();
	    List<PhieuDatPhong> dsPhieuDatPhong = phieuDatPhongDAO.getAllPhieuDatPhong(); // Phương thức này lấy tất cả phiếu đặt phòng

	    for (Phong phong : dsPhong) {
	        boolean isAvailable = true;

	        for (PhieuDatPhong phieuDat : dsPhieuDatPhong) {
	            if (phieuDat.getPhong().getMaPhong().equals(phong.getMaPhong())) {
	                java.util.Date ngayNhan = phieuDat.getNgayNhanPhong();
	                java.util.Date ngayTra = phieuDat.getNgayTraPhong();

	                // Kiểm tra xem khoảng thời gian có trùng với ngày đặt phòng không
	                if ((selectedCheckInDate.before(ngayTra) && selectedCheckOutDate.after(ngayNhan)) ||
	                    selectedCheckInDate.equals(ngayNhan) || selectedCheckOutDate.equals(ngayTra)) {
	                    isAvailable = false;
	                    break;
	                }
	            }
	        }

	        if (isAvailable) {
	            dsPhongTrong.add(phong);
	        }
	    }
	    return dsPhongTrong;
	}

}
