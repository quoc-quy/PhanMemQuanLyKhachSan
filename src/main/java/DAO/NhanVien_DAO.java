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
		try (Connection connection = ConnectDB.getConnection();
				PreparedStatement ps = connection
						.prepareStatement("SELECT * FROM NHANVIEN WHERE TaiKhoan=? AND LoaiNhanVien='NV_QUANLY'")) {
			ps.setString(1, maTaiKhoan);
			ResultSet rs = ps.executeQuery();
			isManager = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isManager;
	}

	// Check if the user is a receptionist
	public boolean isReceptionist(String maTaiKhoan) {
		boolean isReceptionist = false;
		try (Connection connection = ConnectDB.getConnection();
				PreparedStatement ps = connection
						.prepareStatement("SELECT * FROM NHANVIEN WHERE TaiKhoan=? AND LoaiNhanVien='NV_LETAN'")) {
			ps.setString(1, maTaiKhoan);
			ResultSet rs = ps.executeQuery();
			isReceptionist = rs.next();
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
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tenNhanVien = rs.getString("TenNhanVien");
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
				String loaiNhanVienStr = rs.getString("LoaiNhanVien");
				LoaiNhanVien loaiNhanVien = LoaiNhanVien.valueOf(loaiNhanVienStr);
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
					String loaiNhanVienStr = rs.getString("LoaiNhanVien");
					LoaiNhanVien loaiNhanVien = LoaiNhanVien.valueOf(loaiNhanVienStr);
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
		String sql = "INSERT INTO NhanVien (MaNhanVien, TenNhanVien, LoaiNhanVien, Phai, NgaySinh, SoDienThoai) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection connection = ConnectDB.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, nhanVien.getMaNhanVien());
			statement.setString(2, nhanVien.getTenNhanVien());
			statement.setString(3, nhanVien.getLoaiNhanVien().toString()); // Ensure LoaiNhanVien is properly formatted
			statement.setString(4, nhanVien.getPhai());
			statement.setDate(5, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
			statement.setString(6, nhanVien.getSoDienThoai());

			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Update an employee
	// Update an employee
	public boolean updateNhanVien(NhanVien nhanVien) {
	    // Validate input
	    if (nhanVien == null || nhanVien.getMaNhanVien() == null || nhanVien.getMaNhanVien().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Dữ liệu nhân viên không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return false; // Exit if the employee data is invalid
	    }

	    // Get the enum name directly, which will be either "NV_LETAN" or "NV_QUANLY"
	    String loaiNhanVienString = nhanVien.getLoaiNhanVien().name();

	    String sql = "UPDATE NhanVien SET TenNhanVien = ?, LoaiNhanVien = ?, NgaySinh = ?, CCCD = ?, SDT = ?, Phai = ? WHERE MaNhanVien = ?";

	    try (Connection connection = ConnectDB.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {

	        statement.setString(1, nhanVien.getTenNhanVien());
	        statement.setString(2, loaiNhanVienString); // Directly use the enum name
	        statement.setDate(3, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
	        statement.setString(4, nhanVien.getCCCD());
	        statement.setString(5, nhanVien.getSoDienThoai());
	        statement.setString(6, nhanVien.getPhai());
	        statement.setString(7, nhanVien.getMaNhanVien());

	        int rowsUpdated = statement.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        // Use a logging framework instead of printing the stack trace
	        System.err.println("Error updating NhanVien: " + e.getMessage());
	        JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật dữ liệu: " + e.getMessage(), "Lỗi",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	}



	// Delete an employee
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
}
