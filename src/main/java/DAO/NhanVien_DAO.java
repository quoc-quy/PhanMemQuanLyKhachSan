package DAO;

import ConnectDB.ConnectDB;
import ENTITY.LoaiNhanVien;
import ENTITY.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class NhanVien_DAO {
    private final ConnectDB connectDB = new ConnectDB();

    // Check if the user is a manager
    public boolean isManager(String maTaiKhoan) {
        boolean isManager = false;
        String query = "SELECT * FROM NHANVIEN WHERE TaiKhoan=? AND LoaiNhanVien='NV_QUANLY'";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, maTaiKhoan);
            try (ResultSet rs = ps.executeQuery()) {
                isManager = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isManager;
    }

    // Check if the user is a receptionist
    public boolean isReceptionist(String maTaiKhoan) {
        boolean isReceptionist = false;
        String query = "SELECT * FROM NHANVIEN WHERE TaiKhoan=? AND LoaiNhanVien='NV_LETAN'";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, maTaiKhoan);
            try (ResultSet rs = ps.executeQuery()) {
                isReceptionist = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isReceptionist;
    }

    // Get employee name by account ID
    public String getTenNhanVienByMaTaiKhoan(String maTaiKhoan) {
        String tenNhanVien = "";
        String query = "SELECT TenNhanVien FROM NhanVien WHERE TaiKhoan = ?";
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, maTaiKhoan);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    tenNhanVien = rs.getString("TenNhanVien");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenNhanVien;
    }

    // Get all employees
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> dsNhanVien = new ArrayList<>();
        String query = "SELECT * FROM NhanVien";

        try (Connection conn = ConnectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                LoaiNhanVien loaiNhanVien = LoaiNhanVien.valueOf(rs.getString("LoaiNhanVien"));
                NhanVien nv = new NhanVien(rs.getString("MaNhanVien"), rs.getString("TenNhanVien"), loaiNhanVien,
                        rs.getString("Phai"), rs.getDate("NgaySinh"), rs.getString("CCCD"), rs.getString("SDT"));
                dsNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNhanVien;
    }

    // Get employee by ID
    public NhanVien getNhanVienById(String maNhanVien) {
        NhanVien nhanVien = null;
        String query = "SELECT * FROM NhanVien WHERE MaNhanVien = ?";
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maNhanVien);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    LoaiNhanVien loaiNhanVien = LoaiNhanVien.valueOf(rs.getString("LoaiNhanVien"));
                    nhanVien = new NhanVien(rs.getString("MaNhanVien"), rs.getString("TenNhanVien"), loaiNhanVien,
                            rs.getString("Phai"), rs.getDate("NgaySinh"), rs.getString("CCCD"), rs.getString("SDT"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    // Add a new employee
    public boolean addNhanVien(NhanVien nhanVien) {
        if (nhanVien == null || nhanVien.getMaNhanVien() == null || nhanVien.getMaNhanVien().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dữ liệu nhân viên không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sql = "INSERT INTO NhanVien (MaNhanVien, TenNhanVien, LoaiNhanVien, NgaySinh, CCCD, SDT, Phai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nhanVien.getMaNhanVien());
            statement.setString(2, nhanVien.getTenNhanVien());
            statement.setString(3, nhanVien.getLoaiNhanVien().toString());
            statement.setDate(4, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            statement.setString(5, nhanVien.getCCCD());
            statement.setString(6, nhanVien.getSoDienThoai());
            statement.setString(7, nhanVien.getPhai());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm nhân viên: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Update an employee
 // Update an employee
    public boolean updateNhanVien(NhanVien nhanVien) {
        if (nhanVien == null || nhanVien.getMaNhanVien() == null || nhanVien.getMaNhanVien().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dữ liệu nhân viên không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sql = "UPDATE NhanVien SET TenNhanVien = ?, LoaiNhanVien = ?, NgaySinh = ?, CCCD = ?, SDT = ?, Phai = ? WHERE MaNhanVien = ?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nhanVien.getTenNhanVien());
            statement.setString(2, nhanVien.getLoaiNhanVien().getDatabaseValue());
            statement.setDate(3, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            statement.setString(4, nhanVien.getCCCD());
            statement.setString(5, nhanVien.getSoDienThoai());
            statement.setString(6, nhanVien.getPhai());
            statement.setString(7, nhanVien.getMaNhanVien());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật nhân viên: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    // Delete an employee and their account
    public boolean deleteNhanVien(String maNhanVien) {
		String sql = "DELETE FROM NhanVien WHERE MaNhanVien = ?";
		try (Connection connection = ConnectDB.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, maNhanVien);
			int rowsDeleted = statement.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
    
 // Phương thức lấy mã khách hàng dựa vào CCCD
    public String getTenNVByMaNV(String maNV) {
        String tenNV = null;
        
        String sql = "SELECT TenNhanVien FROM NhanVien WHERE MaNhanVien = ?";
        
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
            	tenNV = rs.getString("TenNhanVien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tenNV;
    }
}
