package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import ENTITY.ChiTietDichVu;
import ENTITY.DichVu;
import ENTITY.HoaDon;
import ENTITY.KhachHang;
import ENTITY.KhuyenMai;
import ENTITY.NhanVien;
import GUI.HoaDon_GUI;

public class HoaDon_DAO {
	private final ConnectDB connectDB = new ConnectDB();
//	// Lấy tất cả các hóa đơn từ CSDL
//    public List<HoaDon> getAllHoaDon() {
//        List<HoaDon> danhSachHoaDon = new ArrayList<>();
//        String sql = 
//        	    "SELECT hd.MaHoaDon, hd.NgayLap, hd.NgayNhanPhong, hd.NgayTraPhong, hd.Thue, hd.TongTien, hd.TienTraKhach, " +
//        	    "kh.MaKhachHang, kh.TenKhachHang, kh.Phai, kh.CCCD, kh.NgaySinh, kh.DenThoai, " +
//        	    "nv.MaNhanVien, nv.TenNhanVien, nv.LoaiNhanVien, nv.Phai AS NhanVienPhai, nv.NgaySinh AS NhanVienNgaySinh, nv.CCCD AS NhanVienCCCD, nv.SDT AS NhanVienSDT, " +
//        	    "km.MaKhuyenMai, km.MoTa, km.NgayBatDau, km.NgayKetThuc, km.TrangThai, km.ChietKhau " +
//        	    "FROM HoaDon hd " +
//        	    "JOIN KhachHang kh ON hd.MaKhachHang = kh.MaKhachHang " +
//        	    "JOIN NhanVien nv ON hd.MaNhanVienLap = nv.MaNhanVien " +
//        	    "LEFT JOIN KhuyenMai km ON hd.MaKhuyenMai = km.MaKhuyenMai";
//
//        try (Connection conn = ConnectDB.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//            	// Lấy dữ liệu từ ResultSet và khởi tạo các đối tượng liên quan
//                KhachHang khachHang = new KhachHang(
//                		rs.getString("MaKhachHang"),
//                        rs.getString("TenKhachHang"),
//                        rs.getString("CCCD"),
//                        rs.getString("Phai"),
//                        rs.getDate("NgaySinh"),
//                        rs.getString("DenThoai"));
//                NhanVien nhanVien = new NhanVien(rs.getString("MaNhanVien"));
//                KhuyenMai khuyenMai = new KhuyenMai(rs.getString("MaKhuyenMai"));
//
//                HoaDon hoaDon = new HoaDon(
//                    rs.getString("MaHoaDon"),
//                    khuyenMai,
//                    nhanVien,
//                    khachHang,
//                    rs.getDate("NgayLap").toLocalDate(),
//                    rs.getDate("NgayNhanPhong").toLocalDate(),
//                    rs.getDate("NgayTraPhong").toLocalDate(),
//                    rs.getInt("Thue"),
//                    rs.getDouble("TienTraKhach"),
//                    rs.getDouble("TongTien")
//                );
//                danhSachHoaDon.add(hoaDon);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return danhSachHoaDon;
//    }
	
	
	public List<Object[]> getAllHoaDonWithPhong() {
	    List<Object[]> danhSachHoaDon = new ArrayList<>();

	    String sql = 
	        "SELECT hd.MaHoaDon, kh.TenKhachHang, p.MaPhong, hd.NgayNhanPhong, hd.NgayTraPhong, " +
	        "km.ChietKhau, hd.TongTien " +
	        "FROM HoaDon hd " +
	        "JOIN KhachHang kh ON hd.MaKhachHang = kh.MaKhachHang " +
	        "JOIN ChiTietHoaDon cthd ON hd.MaHoaDon = cthd.MaHoaDon " +
	        "JOIN Phong p ON cthd.MaPhong = p.MaPhong " +
	        "LEFT JOIN KhuyenMai km ON hd.MaKhuyenMai = km.MaKhuyenMai";

	    try (Connection conn = ConnectDB.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        while (rs.next()) {
	            Object[] row = {
	                rs.getString("MaHoaDon"),
	                rs.getString("TenKhachHang"),
	                rs.getString("MaPhong"),
	                rs.getDate("NgayNhanPhong"),
	                rs.getDate("NgayTraPhong"),
	                rs.getInt("ChietKhau"),
	                rs.getDouble("TongTien")
	            };
	            danhSachHoaDon.add(row);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return danhSachHoaDon;
	}

    // Lấy số lượng dịch vụ đã sử dụng cho một hóa đơn cụ thể
    public List<ChiTietDichVu> getDichVuByHoaDon(String maHoaDon) {
        List<ChiTietDichVu> chiTietDichVuList = new ArrayList<>();
        String sql = "SELECT dv.TenDichVu, ctdv.soLuong FROM ChiTietDichVu ctdv " +
                     "JOIN DichVu dv ON ctdv.MaDichVu = dv.MaDichVu " +
                     "WHERE ctdv.MaHoaDon = ?";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maHoaDon);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DichVu dichVu = new DichVu(rs.getString("TenDichVu"));
                int soLuong = rs.getInt("soLuong");
                ChiTietDichVu chiTietDichVu = new ChiTietDichVu(dichVu, null, soLuong);
                chiTietDichVuList.add(chiTietDichVu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietDichVuList;
    }
    
    // Phương thức lưu hóa đơn, trả về mã hóa đơn đã tạo
    public String luuHoaDon(HoaDon hoaDon) {
        String maHoaDon = "";
        String query = "INSERT INTO HoaDon (MaKhuyenMai, MaNhanVienLap, MaKhachHang, NgayLap, NgayNhanPhong, NgayTraPhong, TongTien, Thue) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, hoaDon.getKhuyenMai().getMakhuyenMai());
            pstmt.setString(2, hoaDon.getNhanVienLap().getMaNhanVien());
            pstmt.setString(3, hoaDon.getKhachHang().getMaKhachHang());
            pstmt.setDate(4, new java.sql.Date(hoaDon.getNgayLap().getTime()));
            pstmt.setDate(5, new java.sql.Date(hoaDon.getNgayNhanPhong().getTime()));
            pstmt.setDate(6, new java.sql.Date(hoaDon.getNgayTraPhong().getTime()));
            pstmt.setDouble(7, hoaDon.getTongTien());
            pstmt.setDouble(8, hoaDon.getThue());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                maHoaDon = rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maHoaDon;
    }
}


