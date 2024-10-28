package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import ENTITY.KhachHang;

public class KhachHang_DAO {
	private final ConnectDB connectDB = new ConnectDB();

//  lấy danh sách khách hàng
    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> dsKhachHang = new ArrayList<>();
        String query = "SELECT * FROM KhachHang";

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                KhachHang kh = new KhachHang(
                    rs.getString("MaKhachHang"),
                    rs.getString("TenKhachHang"),
                    rs.getString("CCCD"),
                    rs.getString("Phai"),
                    rs.getDate("NgaySinh"),
                    rs.getString("DenThoai")
                );
                dsKhachHang.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKhachHang;
    }
}
