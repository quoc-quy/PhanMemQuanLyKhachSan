package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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

    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = 
        	    "SELECT hd.MaHoaDon, hd.NgayLap, hd.NgayNhanPhong, hd.NgayTraPhong, hd.Thue, hd.TongTien, hd.TienTraKhach, " +
        	    "kh.MaKhachHang, kh.TenKhachHang, kh.Phai, kh.CCCD, kh.NgaySinh, kh.DenThoai, " +
        	    "nv.MaNhanVien, nv.TenNhanVien, nv.LoaiNhanVien, nv.Phai AS NhanVienPhai, nv.NgaySinh AS NhanVienNgaySinh, nv.CCCD AS NhanVienCCCD, nv.SDT AS NhanVienSDT, " +
        	    "km.MaKhuyenMai, km.MoTa, km.NgayBatDau, km.NgayKetThuc, km.TrangThai, km.ChietKhau " +
        	    "FROM HoaDon hd " +
        	    "JOIN KhachHang kh ON hd.MaKhachHang = kh.MaKhachHang " +
        	    "JOIN NhanVien nv ON hd.MaNhanVienLap = nv.MaNhanVien " +
        	    "LEFT JOIN KhuyenMai km ON hd.MaKhuyenMai = km.MaKhuyenMai";

        try (Connection conn = ConnectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
            	// Lấy dữ liệu từ ResultSet và khởi tạo các đối tượng liên quan
                KhachHang khachHang = new KhachHang(
                		rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getString("CCCD"),
                        rs.getString("Phai"),
                        rs.getDate("NgaySinh"),
                        rs.getString("DenThoai"));
                NhanVien nhanVien = new NhanVien(rs.getString("MaNhanVien"));
                KhuyenMai khuyenMai = new KhuyenMai(rs.getString("MaKhuyenMai"));

                HoaDon hoaDon = new HoaDon(
                    rs.getString("MaHoaDon"),
                    khuyenMai,
                    nhanVien,
                    khachHang,
                    rs.getDate("NgayLap"),
                    rs.getDate("NgayNhanPhong"),
                  	  rs.getDate("NgayTraPhong"),
                    rs.getInt("Thue"),
                    rs.getDouble("TienTraKhach"),
                    rs.getDouble("TongTien")
                );
                danhSachHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }
	
	
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
//    public List<ChiTietDichVu> getDichVuByHoaDon(String maHoaDon) {
//        List<ChiTietDichVu> chiTietDichVuList = new ArrayList<>();
//        String sql = "SELECT dv.TenDichVu, ctdv.soLuong FROM ChiTietDichVu ctdv " +
//                     "JOIN DichVu dv ON ctdv.MaDichVu = dv.MaDichVu " +
//                     "WHERE ctdv.MaHoaDon = ?";
//
//        try (Connection conn = ConnectDB.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setString(1, maHoaDon);
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                DichVu dichVu = new DichVu(rs.getString("TenDichVu"));
//                int soLuong = rs.getInt("soLuong");
//                ChiTietDichVu chiTietDichVu = new ChiTietDichVu(dichVu, null, soLuong);
//                chiTietDichVuList.add(chiTietDichVu);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return chiTietDichVuList;
//    }
//    
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
    
    private String generateMaHD() {
        String query = "SELECT MAX(CAST(SUBSTRING(MaHoaDon, 3, LEN(MaHoaDon)) AS INT)) AS MaxId FROM HoaDon";
        int nextId = 1;  // Mặc định bắt đầu từ 1

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                nextId = rs.getInt("MaxId") + 1;  // Lấy giá trị lớn nhất và cộng 1
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi khi lấy ID hóa đơn: " + ex.getMessage());
        }
        return "HD" + String.format("%05d", nextId);  // Tạo mã hóa đơn, ví dụ HD00001
    }

 // Phương thức tạo mã hóa đơn và lưu vào bảng HoaDon
    public String createHoaDon() {
        String maHoaDon = generateMaHD();  // Tạo mã hóa đơn theo quy tắc "HDxxxxx"
        
        String query = "INSERT INTO HoaDon (MaHoaDon) VALUES (?)";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            // Gán giá trị vào câu lệnh SQL
            ps.setString(1, maHoaDon);  // Mã hóa đơn
            
            // Thực thi câu lệnh SQL
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return maHoaDon;  // Trả về mã hóa đơn vừa tạo
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi khi tạo hóa đơn: " + ex.getMessage());
        }
        return null;  // Trả về null nếu có lỗi
    }

    public List<HoaDon> getHoaDonTheoKhoangThoiGian(java.sql.Date ngayCheckIn, java.sql.Date ngayCheckOut) {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();

        // Câu lệnh SQL
        String sql = "SELECT hd.MaHoaDon, hd.NgayLap, hd.NgayNhanPhong, hd.NgayTraPhong, hd.Thue, hd.TongTien, hd.TienTraKhach, " +
                     "nv.MaNhanVien, nv.TenNhanVien " +
                     "FROM HoaDon hd " +
                     "JOIN NhanVien nv ON hd.MaNhanVienLap = nv.MaNhanVien " +
                     "WHERE hd.NgayLap BETWEEN ? AND ?"; // Lọc theo ngày lập hóa đơn

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Thiết lập tham số cho câu truy vấn SQL
            ps.setDate(1, ngayCheckIn);
            ps.setDate(2, ngayCheckOut);

            // Thực thi truy vấn và lấy kết quả
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                
                // Gán dữ liệu vào đối tượng HoaDon
                hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.setNgayLap(rs.getDate("NgayLap"));
                hoaDon.setNgayNhanPhong(rs.getDate("NgayNhanPhong"));
                hoaDon.setNgayTraPhong(rs.getDate("NgayTraPhong"));
                Double tongTien = rs.getDouble("TongTien");
                if (rs.wasNull()) {  // Kiểm tra xem giá trị có NULL không
                    tongTien = 0.0;  // Nếu NULL, có thể gán giá trị mặc định
                }
                hoaDon.setTongTien(tongTien);

                // Gán nhân viên vào hóa đơn
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNhanVien(rs.getString("MaNhanVien"));
                nhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
                hoaDon.setNhanVienLap(nhanVien); // Gán nhân viên cho hóa đơn

                // Thêm hóa đơn vào danh sách
                danhSachHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachHoaDon;
    }

    
 // Phương thức để cập nhật thông tin hóa đơn trong bảng HoaDon
    public boolean capNhatHoaDon(HoaDon hoaDon, String maPhong, String maNV) {
    	String sql = "UPDATE HoaDon "
    	           + "SET MaNhanVienLap = ?, MaKhachHang = ?, NgayLap = ?, NgayNhanPhong = ?, "
    	           + "NgayTraPhong = ?, TienTraKhach = ?, TongTien = ?, Thue = ? "
    	           + "WHERE MaNhanVienLap IS NULL and MaHoaDon in ( "
    	           + "    SELECT cth.MaHoaDon "
    	           + "    FROM ChiTietHoaDon cth "
    	           + "    WHERE cth.MaPhong = ? "
    	           + ")";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Gán giá trị cho các tham số trong câu lệnh SQL
            stmt.setString(1, maNV);
            stmt.setString(2, hoaDon.getKhachHang().getMaKhachHang()); 
            stmt.setDate(3,  (Date) hoaDon.getNgayLap());
            stmt.setDate(4, (Date) hoaDon.getNgayNhanPhong());
            stmt.setDate(5, (Date) hoaDon.getNgayTraPhong());
            stmt.setDouble(6, hoaDon.getTienTraKhach()); 
            stmt.setDouble(7, hoaDon.getTongTien()); 
            stmt.setInt(8, hoaDon.getThue()); 
            stmt.setString(9, maPhong); 

            // Thực thi câu lệnh UPDATE
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Nếu có bản ghi bị ảnh hưởng
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


