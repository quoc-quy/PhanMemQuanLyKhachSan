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
import ENTITY.NhanVien;
import ENTITY.PhieuDatPhong;
import ENTITY.Phong;
import ENTITY.KhachHang;

public class PhieuDatPhong_DAO {
	private final ConnectDB connectDB = new ConnectDB();
	
	public boolean addPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
        String sql = "INSERT INTO PhieuDatPhong (MaKhachHang, MaPhong, MaNhanVienLap, NgayNhanPhong, NgayTraPhong, TienCoc) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

        	ps.setString(1, phieuDatPhong.getKhachHang().getMaKhachHang());
            ps.setString(2, phieuDatPhong.getPhong().getMaPhong());
            ps.setString(3, phieuDatPhong.getNhanVienLap().getMaNhanVien()); // Giả định mã nhân viên lập được lấy từ phieuDatPhong
            ps.setDate(4, new java.sql.Date(phieuDatPhong.getNgayNhanPhong().getTime()));
            ps.setDate(5, new java.sql.Date(phieuDatPhong.getNgayTraPhong().getTime()));
            ps.setDouble(6, phieuDatPhong.getTienCoc());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	

	public List<PhieuDatPhong> getAllPhieuDatPhong() {
        List<PhieuDatPhong> dsPhieuDatPhong = new ArrayList<>();
        String query = "SELECT MaPhieuDatPhong MaKhachHang, MaPhong, MaNhanVienLap, NgayNhanPhong, NgayTraPhong, " +
                       "TienCoc, LoaiHinh, GioNhanPhong, GioTraPhong, TongTien, TrangThai " +
                       "FROM PhieuDatPhong";

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Lấy các giá trị từ ResultSet
            	String maPDP = rs.getString("MaPhieuDatPhong");
                String maKhachHang = rs.getString("MaKhachHang");
                String maPhong = rs.getString("MaPhong");
                String maNhanVien = rs.getString("MaNhanVienLap");
                Date ngayNhanPhong = rs.getDate("NgayNhanPhong");
                Date ngayTraPhong = rs.getDate("NgayTraPhong");
                double tienCoc = rs.getDouble("TienCoc");
                String loaiHinh = rs.getString("LoaiHinh");
                String gioNhanPhong = rs.getString("GioNhanPhong");
                String gioTraPhong = rs.getString("GioTraPhong");
                double tongTien = rs.getDouble("TongTien");
                String trangThai = rs.getString("TrangThai");

                // Tạo đối tượng PhieuDatPhong
                PhieuDatPhong phieuDatPhong = new PhieuDatPhong(
                	maPDP,
                    new KhachHang(maKhachHang), // Giả định rằng bạn có constructor cho KhachHang với mã khách hàng
                    new NhanVien(maNhanVien),   // Giả định rằng bạn có constructor cho NhanVien với mã nhân viên
                    new Phong(maPhong),         // Giả định rằng bạn có constructor cho Phong với mã phòng
                    ngayNhanPhong,
                    ngayTraPhong,
                    tienCoc,
                    loaiHinh,
                    gioNhanPhong,
                    gioTraPhong,
                    tongTien,
                    trangThai
                );

                // Thêm vào danh sách
                dsPhieuDatPhong.add(phieuDatPhong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsPhieuDatPhong;
    }
	public PhieuDatPhong getPhieuDatPhongByMaPhong(String maPhong) {
	    // Kiểm tra xem mã phòng có hợp lệ không
	    if (maPhong == null || maPhong.isEmpty()) {
	        System.out.println("Mã phòng không hợp lệ.");
	        return null;
	    }
	    
	    PhieuDatPhong phieuDatPhong = null;
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        // Kết nối với cơ sở dữ liệu
	        conn = connectDB.getConnection();
	        if (conn == null) {
	            throw new SQLException("Không thể kết nối với cơ sở dữ liệu.");
	        }
	        
	        // Câu lệnh SQL để lấy phiếu đặt phòng theo mã phòng
	        String sql = "SELECT pdp.*, kh.* " +
                    "FROM PhieuDatPhong pdp " +
                    "LEFT JOIN KhachHang kh ON pdp.MaKhachHang = kh.MaKhachHang " +
                    "WHERE pdp.MaPhong = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, maPhong);
	        
	        // Thực hiện truy vấn
	        rs = stmt.executeQuery();
	        
	        // Kiểm tra kết quả
	        if (rs.next()) {
	            String ma = rs.getString("MaKhachHang");
	            String ten = rs.getString("TenKhachHang");
	            if(ma == null) {
	            	ten = "Khách lẻ";
	            }
	            System.out.println("Đã tìm thấy phiếu đặt phòng cho phòng: " + maPhong);
	            phieuDatPhong = new PhieuDatPhong();
	            
	            // Gán các giá trị từ ResultSet vào phieuDatPhong với các tên cột chính xác
	            phieuDatPhong.setMaPDP(rs.getString("MaPhieuDatPhong")); // Sửa "maPDP" thành "MaPhieuDatPhong"
	            phieuDatPhong.setKhachHang(new KhachHang(ten, ma)); 
	            phieuDatPhong.setNhanVienLap(new NhanVien(rs.getString("MaNhanVienLap"))); 
	            phieuDatPhong.setPhong(new Phong(rs.getString("MaPhong"))); 
	            phieuDatPhong.setNgayNhanPhong(rs.getDate("NgayNhanPhong"));
	            phieuDatPhong.setNgayTraPhong(rs.getDate("NgayTraPhong"));
	            phieuDatPhong.setTienCoc(rs.getDouble("TienCoc"));
	            phieuDatPhong.setLoaiHinh(rs.getString("LoaiHinh"));
	            phieuDatPhong.setGioNhanPhong(rs.getString("GioNhanPhong"));
	            phieuDatPhong.setGioTraPhong(rs.getString("GioTraPhong"));
	            phieuDatPhong.setTongTien(rs.getDouble("TongTien"));
	            phieuDatPhong.setTrangThai(rs.getString("TrangThai"));
	            
	            
	        } else {
	            System.out.println("Không tìm thấy phiếu đặt phòng cho mã phòng: " + maPhong);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng kết nối và tài nguyên
	        connectDB.closeConnection(conn, stmt, rs);
	    }

	    return phieuDatPhong;
	}

}
