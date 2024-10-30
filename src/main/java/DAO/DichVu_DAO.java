package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import ENTITY.DichVu;
import ENTITY.KhachHang;

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

}
