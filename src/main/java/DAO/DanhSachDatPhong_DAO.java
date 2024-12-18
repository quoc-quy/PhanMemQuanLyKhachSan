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
import ENTITY.KhachHang;
import ENTITY.LoaiPhong;
import ENTITY.NhanVien;
import ENTITY.PhieuDatPhong;
import ENTITY.Phong;
import ENTITY.TrangThaiPhong;

public class DanhSachDatPhong_DAO {
	private final ConnectDB connectDB = new ConnectDB();
	
	 // Phương thức tạo mã tự động cho MaPhieuDatPhong
	private String generateMaPhieuDatPhong(Date ngayNhanPhong, String maPhong) {
	    // Định dạng ngày theo định dạng yyyyMMdd
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    String formattedDate = dateFormat.format(ngayNhanPhong);

	    // Giả định mã phòng là 4 ký tự, nếu mã phòng dài hơn 4 ký tự thì chỉ lấy 4 ký tự đầu
	    String formattedMaPhong = maPhong.length() > 4 ? maPhong.substring(0, 4) : maPhong;

	    // Ghép chuỗi theo định dạng: PDP + ngày nhận phòng + mã phòng
	    return "PDP" + formattedDate + formattedMaPhong;
	  
	}

	public boolean addPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
	    String sql = "INSERT INTO PhieuDatPhong (MaPhieuDatPhong, MaKhachHang, MaPhong, MaNhanVienLap, NgayNhanPhong, NgayTraPhong, TienCoc, LoaiHinh, GioNhanPhong, GioTraPhong, TongTien, TrangThai) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = connectDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        // Tự động tạo mã phiếu đặt phòng
	        String maPhieuDatPhong = generateMaPhieuDatPhong(new java.sql.Date(phieuDatPhong.getNgayNhanPhong().getTime()), phieuDatPhong.getPhong().getMaPhong());
	        if (maPhieuDatPhong == null) {
	            System.out.println("Không thể tạo mã phiếu đặt phòng mới.");
	            return false;
	        }

	        // Gán mã phiếu cho đối tượng PhieuDatPhong
	        phieuDatPhong.setMaPDP(maPhieuDatPhong);

	        // Thiết lập các tham số cho PreparedStatement
	        ps.setString(1, maPhieuDatPhong);  // Sử dụng mã đã tạo
	        ps.setString(2, phieuDatPhong.getKhachHang().getMaKhachHang());
	        ps.setString(3, phieuDatPhong.getPhong().getMaPhong());
	        ps.setString(4, phieuDatPhong.getNhanVienLap().getMaNhanVien());
	        ps.setDate(5, new java.sql.Date(phieuDatPhong.getNgayNhanPhong().getTime()));
	        ps.setDate(6, new java.sql.Date(phieuDatPhong.getNgayTraPhong().getTime()));
	        ps.setDouble(7, phieuDatPhong.getTienCoc());
	        ps.setString(8, phieuDatPhong.getLoaiHinh());
	        ps.setString(9, phieuDatPhong.getGioNhanPhong());
	        ps.setString(10, phieuDatPhong.getGioTraPhong());
	        ps.setDouble(11, phieuDatPhong.getTongTien());
	        ps.setString(12, phieuDatPhong.getTrangThai());

	        // Thực thi câu lệnh
	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            return true;
	        } else {
	            return false;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
//	Lấy danh sách đặt phòng
	public List<Object[]> getAllDanhSachDatPhong() {
	    List<Object[]> danhSachDatPhong = new ArrayList<>();

	    String sql = 
	        "SELECT kh.TenKhachHang, kh.DenThoai, " +
	        "pdp.MaPhieuDatPhong, pdp.MaKhachHang, pdp.MaPhong, pdp.NgayNhanPhong, pdp.NgayTraPhong, pdp.TienCoc, pdp.TrangThai " +
	        "FROM PhieuDatPhong pdp " +
	        "LEFT JOIN KhachHang kh ON pdp.MaKhachHang = kh.MaKhachHang";

	    try (Connection conn = ConnectDB.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        
	        int index = 1; // Biến đếm bắt đầu từ 1 cho số thứ tự dòng
	        while (rs.next()) {
	            // Kiểm tra MaKhachHang và thiết lập tên khách hàng là "Khách lẻ" nếu cần
	            String maKhachHang = rs.getString("MaKhachHang");
	            String tenKhachHang = rs.getString("TenKhachHang");

	            if (maKhachHang == null) {
	                tenKhachHang = "Khách lẻ"; // Nếu MaKhachHang là null, đặt tên khách hàng là "Khách lẻ"
	            }

	            String soDienThoai = rs.getString("DenThoai") != null ? rs.getString("DenThoai") : "Không có";
	            String trangThai = rs.getString("TrangThai");
	            String maPhieuDatPhong = rs.getString("MaPhieuDatPhong");
	            String maPhong = rs.getString("MaPhong");
	            Date ngayNhanPhong = rs.getDate("NgayNhanPhong");
	            Date ngayTraPhong = rs.getDate("NgayTraPhong");
	            Double tienCoc = rs.getDouble("TienCoc");

	            // Thêm dòng dữ liệu vào danh sách
	            Object[] row = {
	                index,
	                maPhieuDatPhong,
	                tenKhachHang,
	                soDienThoai,
	                maPhong,
	                ngayNhanPhong,
	                ngayTraPhong,
	                tienCoc,
	                trangThai
	            };
	            danhSachDatPhong.add(row);
	            index++; // Tăng biến đếm lên 1 cho dòng tiếp theo
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return danhSachDatPhong;
	}

 	// Xóa đặt phòng
 	public boolean deletePhieuDatPhong(String MaPhieuDatPhong) {
 		String query = "DELETE FROM PhieuDatPhong WHERE MaPhieuDatPhong = ?";

 		try (Connection conn = connectDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

 			pstmt.setString(1, MaPhieuDatPhong);

 			return pstmt.executeUpdate() > 0;
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return false;
 	}
 	
 	 public boolean updatePhieuDatPhong(PhieuDatPhong phieuDatPhong) {
         String sql = "UPDATE PhieuDatPhong SET MaKhachHang = ?, MaPhong = ?, MaNhanVienLap = ?, "
                    + "NgayNhanPhong = ?, NgayTraPhong = ?, TienCoc = ? WHERE MaPhieuDatPhong = ?";

         try (Connection conn = ConnectDB.getConnection();
              PreparedStatement ps = conn.prepareStatement(sql)) {

             ps.setString(1, phieuDatPhong.getKhachHang().getMaKhachHang());
             ps.setString(2, phieuDatPhong.getPhong().getMaPhong());
             ps.setString(3, phieuDatPhong.getNhanVienLap().getMaNhanVien());
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
 	 
 	// Lấy danh sách đặt phòng theo điều kiện ngày nhận, ngày trả, và trạng thái
 	public List<Object[]> getDanhSachDatPhongTheoDieuKien(java.util.Date ngayNhan, java.util.Date ngayTra, String trangThai) {
 	    List<Object[]> danhSachDatPhong = new ArrayList<>();

 	    // Xây dựng câu truy vấn SQL động dựa trên các điều kiện
 	    String sql = "SELECT kh.TenKhachHang, kh.DenThoai, " +
 	                 "pdp.MaPhieuDatPhong, pdp.MaKhachHang, pdp.MaPhong, pdp.NgayNhanPhong, pdp.NgayTraPhong, pdp.TienCoc, pdp.TrangThai " +
 	                 "FROM PhieuDatPhong pdp " +
 	                 "LEFT JOIN KhachHang kh ON pdp.MaKhachHang = kh.MaKhachHang " +
 	                 "WHERE pdp.NgayNhanPhong >= ? AND pdp.NgayTraPhong <= ?";

 	    // Nếu trạng thái không phải là "Tất cả", thêm điều kiện lọc theo trạng thái
 	    if (!"Tất cả".equals(trangThai)) {
 	        sql += " AND pdp.TrangThai = ?";
 	    }

 	    try (Connection conn = ConnectDB.getConnection();
 	         PreparedStatement ps = conn.prepareStatement(sql)) {

 	        // Khởi tạo chỉ số cho tham số
 	        int paramIndex = 1;

 	        // Thiết lập tham số cho ngày nhận (nếu `ngayNhan` là null, dùng ngày mặc định)
 	        if (ngayNhan == null) {
 	            ngayNhan = new java.util.Date(0); // Ngày mặc định
 	        }
 	        ps.setDate(paramIndex++, new java.sql.Date(ngayNhan.getTime()));

 	        // Thiết lập tham số cho ngày trả (nếu `ngayTra` là null, dùng ngày hiện tại)
 	        if (ngayTra == null) {
 	            ngayTra = new java.util.Date(); // Ngày hiện tại
 	        }
 	        ps.setDate(paramIndex++, new java.sql.Date(ngayTra.getTime()));

 	        // Nếu lọc theo trạng thái, thiết lập thêm tham số cho trạng thái
 	        if (!"Tất cả".equals(trangThai)) {
 	            ps.setString(paramIndex++, trangThai);
 	        }

 	        try (ResultSet rs = ps.executeQuery()) {
 	            int index = 1; // Biến đếm để thêm số thứ tự dòng
 	            while (rs.next()) {
 	                String maKhachHang = rs.getString("MaKhachHang");
 	                String tenKhachHang = rs.getString("TenKhachHang") != null ? rs.getString("TenKhachHang") : "Khách lẻ";
 	                String soDienThoai = rs.getString("DenThoai") != null ? rs.getString("DenThoai") : "Không có";
 	                String maPhieuDatPhong = rs.getString("MaPhieuDatPhong");
 	                String maPhong = rs.getString("MaPhong");
 	                Date ngayNhanPhong = rs.getDate("NgayNhanPhong");
 	                Date ngayTraPhong = rs.getDate("NgayTraPhong");
 	                Double tienCoc = rs.getDouble("TienCoc");
 	                String trangThaiPhong = rs.getString("TrangThai");

 	                // Thêm dòng dữ liệu vào danh sách
 	                Object[] row = {
 	                    index,
 	                    maPhieuDatPhong,
 	                    tenKhachHang,
 	                    soDienThoai,
 	                    maPhong,
 	                    ngayNhanPhong,
 	                    ngayTraPhong,
 	                    tienCoc,
 	                    trangThaiPhong
 	                };
 	                danhSachDatPhong.add(row);
 	                index++;
 	            }
 	        }
 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	    }

 	    return danhSachDatPhong;
 	}
 	
 	
 	public PhieuDatPhong getChiTietPhieuDatPhong(String maPhieuDatPhong) {
        PhieuDatPhong phieuDatPhong = null;
        String sql = "SELECT pdp.MaPhieuDatPhong, kh.TenKhachHang, nv.TenNhanVien, p.MaPhong, kh.CCCD, " +
                     "pdp.NgayNhanPhong, pdp.NgayTraPhong, pdp.TienCoc, pdp.LoaiHinh, " +
                     "pdp.GioNhanPhong, pdp.GioTraPhong, pdp.TongTien, pdp.TrangThai " +
                     "FROM PhieuDatPhong pdp " +
                     "LEFT JOIN KhachHang kh ON pdp.MaKhachHang = kh.MaKhachHang " +
                     "LEFT JOIN NhanVien nv ON pdp.MaNhanVienLap = nv.MaNhanVien " +
                     "LEFT JOIN Phong p ON pdp.MaPhong = p.MaPhong " +
                     "WHERE pdp.MaPhieuDatPhong = ?";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maPhieuDatPhong);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    phieuDatPhong = new PhieuDatPhong();
                    
                    // Thiết lập các thuộc tính của PhieuDatPhong
                    phieuDatPhong.setKhachHang(new KhachHang(rs.getString("CCCD")));
                    phieuDatPhong.setPhong(new Phong(rs.getString("MaPhong")));
                    phieuDatPhong.setNgayNhanPhong(rs.getDate("NgayNhanPhong"));
                    phieuDatPhong.setNgayTraPhong(rs.getDate("NgayTraPhong"));
                    phieuDatPhong.setTienCoc(rs.getDouble("TienCoc"));
                    phieuDatPhong.setLoaiHinh(rs.getString("LoaiHinh"));
                    phieuDatPhong.setGioNhanPhong(rs.getString("GioNhanPhong"));
                    phieuDatPhong.setGioTraPhong(rs.getString("GioTraPhong"));
                    phieuDatPhong.setTongTien(rs.getDouble("TongTien"));
                    phieuDatPhong.setTrangThai(rs.getString("TrangThai"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuDatPhong;
    }
 	
 	
 // Phương thức cập nhật trạng thái của phòng
    public boolean capNhatTrangThaiPhong(String maPhong, String trangThai) {
        String sql = "UPDATE Phong SET TrangThaiPhong = ? WHERE MaPhong = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, trangThai);
            ps.setString(2, maPhong);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Phương thức cập nhật trạng thái của phiếu đặt phòng
    public boolean capNhatTrangThaiPhieuDatPhong(String maPhieuDatPhong, String trangThai) {
        String sql = "UPDATE PhieuDatPhong SET TrangThai = ? WHERE MaPhieuDatPhong = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, trangThai);
            ps.setString(2, maPhieuDatPhong);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public PhieuDatPhong layThongTinPhieuDatPhong(String maPhong) {
        PhieuDatPhong phieuDatPhong = null;
        String query = "SELECT * FROM PhieuDatPhong WHERE MaPhong = ? AND TrangThai = N'Đã nhận'";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, maPhong);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                phieuDatPhong = new PhieuDatPhong();
                phieuDatPhong.setMaPDP(rs.getString("MaPhieuDatPhong"));
                phieuDatPhong.getNhanVienLap().setMaNhanVien(rs.getString("MaNhanVienLap"));;
                phieuDatPhong.getKhachHang().setMaKhachHang(rs.getString("MaKhachHang"));
                phieuDatPhong.setNgayNhanPhong(rs.getDate("NgayNhanPhong"));
                phieuDatPhong.setNgayTraPhong(rs.getDate("NgayTraPhong"));
                phieuDatPhong.getPhong().setMaPhong(rs.getString("MaPhong"));
                phieuDatPhong.setTienCoc(rs.getDouble("TienCoc"));
                phieuDatPhong.setLoaiHinh(rs.getString("LoaHinh"));
                phieuDatPhong.setTongTien(rs.getDouble("TongTien"));
                phieuDatPhong.setTrangThai(rs.getString("TrangThai"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phieuDatPhong;
    }
    
    public PhieuDatPhong getRoomInfo(String maPhong) {
    	KhachHang_DAO khDAO = new KhachHang_DAO();
        PhieuDatPhong phieuDatPhong = null;
        String query = "SELECT * FROM PhieuDatPhong WHERE MaPhong = ? AND TrangThai = N'Đã nhận'";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, maPhong);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                phieuDatPhong = new PhieuDatPhong();

                // Gán thông tin cho PhieuDatPhong
                phieuDatPhong.setMaPDP(rs.getString("MaPhieuDatPhong"));
                phieuDatPhong.setNhanVienLap(new NhanVien(rs.getString("MaNhanVienLap")));
                
                // Kiểm tra nếu MaKhachHang là NULL
                String maKhachHang = rs.getString("MaKhachHang");
                if (maKhachHang == null || maKhachHang.isEmpty()) {
                    // Nếu MaKhachHang là NULL hoặc rỗng, gán "Khách lẻ" cho tên khách hàng
                    KhachHang khachHang = new KhachHang();
                    khachHang.setTenKhachHang("Khách lẻ");  // Gán "Khách lẻ" nếu không có khách hàng
                    phieuDatPhong.setKhachHang(khachHang);
                } else {
                    // Nếu có MaKhachHang, tạo đối tượng KhachHang với MaKhachHang
                    phieuDatPhong.setKhachHang(khDAO.findMaKhachHangID(maKhachHang));
                }

                // Cập nhật các thông tin khác
                phieuDatPhong.setNgayNhanPhong(rs.getDate("NgayNhanPhong"));
                phieuDatPhong.setNgayTraPhong(rs.getDate("NgayTraPhong"));
                phieuDatPhong.setPhong(new Phong(rs.getString("MaPhong")));
                phieuDatPhong.setTienCoc(rs.getDouble("TienCoc"));
                phieuDatPhong.setLoaiHinh(rs.getString("LoaiHinh"));
                phieuDatPhong.setTongTien(rs.getDouble("TongTien"));
                phieuDatPhong.setTrangThai(rs.getString("TrangThai"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phieuDatPhong;
    }
    
 // Phương thức để lấy danh sách các phiếu đặt phòng
    public List<Object[]> getDanhSachDatPhong(String maPDP) {
        List<Object[]> ds = new ArrayList<>();
        String sql = "SELECT pdp.MaPhong, " +
                     "pdp.NgayNhanPhong, pdp.NgayTraPhong, pdp.LoaiHinh, " +
                     "CASE " +
                     "   WHEN pdp.LoaiHinh = N'Ngày đêm' THEN lp.GiaTienTheoNgay " +
                     "   WHEN pdp.LoaiHinh = N'Giờ' THEN lp.GiaTienTheoGio " +
                     "   ELSE 0 " +
                     "END AS GiaTien, " +
                     "pdp.TongTien " +
                     "FROM PhieuDatPhong pdp " +
                     "JOIN Phong p ON pdp.MaPhong = p.MaPhong AND pdp.MaPhieuDatPhong = ? " +
                     "JOIN LoaiPhong lp ON p.LoaiPhong = lp.MaLoaiPhong";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Gán giá trị cho tham số trong câu truy vấn
            stmt.setString(1, maPDP);  // Thiết lập tham số maPDP vào câu truy vấn
            
            try (ResultSet rs = stmt.executeQuery()) {
                // Lặp qua kết quả trả về
            	int index = 1;
                while (rs.next()) {
                    String maPhong = rs.getString("MaPhong");
                    Date ngayNhanPhong = rs.getDate("NgayNhanPhong");
                    Date ngayTraPhong = rs.getDate("NgayTraPhong");
                    double giaTien = rs.getDouble("GiaTien");
                    double tongTien = rs.getDouble("TongTien");

                    // Thêm thông tin vào danh sách
                    Object[] row = new Object[] {index, maPhong, ngayNhanPhong, ngayTraPhong, giaTien, tongTien};
                    ds.add(row);
                    index++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
}
