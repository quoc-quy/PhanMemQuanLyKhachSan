package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import ENTITY.DichVu;

public class DichVu_DAO {
	private final ConnectDB connectDB = new ConnectDB();

//  lấy danh sách dịch vụ
    public List<DichVu> getAllDichVu() {
        List<DichVu> dsDichVu = new ArrayList<>();
        String query = "SELECT * FROM DichVu";

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                DichVu dv = new DichVu(
                    rs.getString("MaDichVu"),
                    rs.getString("TenDichVu"),
                    rs.getInt("SoLuong"),
                    rs.getDouble("DonGia"),
                    rs.getString("DonViTinh")
                );
                dsDichVu.add(dv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsDichVu;
    }
    
 // Thêm dịch vụ mới
 	public boolean insertDichVu(DichVu dv) {
 		String query = "INSERT INTO DichVu (maDichVu, tenDichVu, soLuong, donGia, donViTinh) VALUES (?, ?, ?, ?, ?)";

 		try (Connection conn = connectDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

 			pstmt.setString(1, dv.getMaDichvu());
 			pstmt.setString(2, dv.getTenDichVu());
 			pstmt.setInt(3, dv.getSoLuong());
 			pstmt.setDouble(4, dv.getDonGia());
 			pstmt.setString(5, dv.getDonViTinh());

 			return pstmt.executeUpdate() > 0;
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return false;
 	}

 	// Cập nhật dịch vụ
 	public boolean updateDichVu(DichVu dv) {
 		String query = "UPDATE DichVu SET tenDichVu = ?, soLuong = ?, donGia = ?, donViTinh = ? WHERE maDichVu = ?";

 		try (Connection conn = connectDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

 			pstmt.setString(1, dv.getTenDichVu());
 			pstmt.setInt(2, dv.getSoLuong());
 			pstmt.setDouble(3, dv.getDonGia());
 			pstmt.setString(4, dv.getDonViTinh());
 			pstmt.setString(5, dv.getMaDichvu());

 			return pstmt.executeUpdate() > 0;
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return false;
 	}

 	// Xóa dịch vụ
 	public boolean deleteDichVu(String maDichVu) {
 		String query = "DELETE FROM DichVu WHERE maDichVu = ?";

 		try (Connection conn = connectDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

 			pstmt.setString(1, maDichVu);

 			return pstmt.executeUpdate() > 0;
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return false;
 	}

 	// Lấy dịch vụ theo mã dịch vụ
 	public DichVu getDichVuById(String maDichVu) {
 		String query = "SELECT * FROM DichVu WHERE maDichVu = ?";
 		DichVu dichVu = null;

 		try (Connection conn = connectDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

 			pstmt.setString(1, maDichVu);
 			ResultSet rs = pstmt.executeQuery();

 			if (rs.next()) {
 				dichVu = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"), rs.getInt("soLuong"),
 						rs.getDouble("donGia"), rs.getString("donViTinh"));
 			}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return dichVu;
 	}
 	
 // Lấy đơn giá bằng tên dịch vụ
 	public Double layDonGiaBytenDichVu(String tenDV) {
 	    String query = "SELECT DonGia FROM DichVu WHERE TenDichVu = ?";
 	    double dongia = 0;

 	    try (Connection conn = ConnectDB.getConnection();
 	         PreparedStatement pstmt = conn.prepareStatement(query)) {
 	        
 	        // Đặt giá trị cho tham số tenDV
 	        pstmt.setString(1, tenDV);

 	        // Thực thi câu lệnh truy vấn
 	        ResultSet rs = pstmt.executeQuery();

 	        // Kiểm tra kết quả và lấy giá trị DonGia
 	        if (rs.next()) {
 	            dongia = rs.getDouble(1); // Lấy giá trị từ cột đầu tiên (DonGia)
 	        }
 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	    }
 	    return dongia;
 	}
}
