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
import ENTITY.PhieuDatPhong;

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
        String sql = "INSERT INTO PhieuDatPhong (MaPhieuDatPhong, MaKhachHang, MaPhong, MaNhanVienLap, NgayNhanPhong, NgayTraPhong, TienCoc) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Tự động tạo mã phiếu đặt phòng
            String maPhieuDatPhong = generateMaPhieuDatPhong(new java.sql.Date(phieuDatPhong.getNgayNhanPhong().getTime()), phieuDatPhong.getPhong().getMaPhong());
            if (maPhieuDatPhong == null) {
                System.out.println("Không thể tạo mã phiếu đặt phòng mới.");
                return false;
            }

            // Thiết lập các tham số cho PreparedStatement
            ps.setString(1, maPhieuDatPhong);
            ps.setString(2, phieuDatPhong.getKhachHang().getMaKhachHang());
            ps.setString(3, phieuDatPhong.getPhong().getMaPhong());
            ps.setString(4, phieuDatPhong.getNhanVienLap().getMaNhanVien());
            ps.setDate(5, new java.sql.Date(phieuDatPhong.getNgayNhanPhong().getTime()));
            ps.setDate(6, new java.sql.Date(phieuDatPhong.getNgayTraPhong().getTime()));
            ps.setDouble(7, phieuDatPhong.getTienCoc());

            // Thực thi câu lệnh và kiểm tra kết quả
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
//	Lấy danh sách đặt phòng
	public List<Object[]> getAllDanhSachDatPhong() {
	    List<Object[]> danhSachDatPhong = new ArrayList<>();

	    String sql = 
	        "SELECT kh.TenKhachHang, kh.DenThoai, kh.Phai, " +
	        "pdp.MaPhieuDatPhong, pdp.MaPhong, pdp.NgayNhanPhong, pdp.NgayTraphong, pdp.TienCoc " +
	        "FROM PhieuDatPhong pdp " +
	        "JOIN KhachHang kh ON pdp.MaKhachHang = kh.MaKhachHang ";

	    try (Connection conn = ConnectDB.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	    	
	    	int index = 1; // Biến đếm bắt đầu từ 1 cho số thứ tự dòng
	        while (rs.next()) {
	            Object[] row = {
	            	index,
	                rs.getString("MaPhieuDatPhong"),
	                rs.getString("TenKhachHang"),
	                rs.getString("DenThoai"),
	                rs.getString("Phai"),
	                rs.getString("MaPhong"),
	                rs.getDate("NgayNhanPhong"),
	                rs.getDate("NgayTraPhong"),
	                rs.getInt("TienCoc")
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
}
