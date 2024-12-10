package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import ConnectDB.ConnectDB;

public class ThongKe_DAO {
	// Phương thức lấy dữ liệu doanh thu theo khoảng ngày
    public static Map<String, Double> getRevenueByDate(String startDate, String endDate) {
        Map<String, Double> revenueData = new HashMap<>();
        String query = "SELECT NgayLap, SUM(TongTien) AS DoanhThu " +
                       "FROM HoaDon " +
                       "WHERE NgayLap BETWEEN ? AND ? " +
                       "GROUP BY NgayLap " +
                       "ORDER BY NgayLap";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, startDate); // Gán giá trị ngày bắt đầu
            stmt.setString(2, endDate);   // Gán giá trị ngày kết thúc

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String date = rs.getString("NgayLap");
                    Double revenue = rs.getDouble("DoanhThu");
                    revenueData.put(date, revenue); // Thêm vào Map
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revenueData;
    }
    
    public static Map<String, Double> getRevenueByMonth(int month, int year) {
        Map<String, Double> revenueData = new HashMap<>();
        String query = "SELECT FORMAT(NgayLap, 'yyyy-MM-dd') AS Ngay, SUM(TongTien) AS DoanhThu " +
                       "FROM HoaDon " +
                       "WHERE MONTH(NgayLap) = ? AND YEAR(NgayLap) = ? " +
                       "GROUP BY FORMAT(NgayLap, 'yyyy-MM-dd') " +
                       "ORDER BY Ngay";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, month); // Gán giá trị tháng
            stmt.setInt(2, year); // Gán giá trị năm

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String date = rs.getString("Ngay");
                    Double revenue = rs.getDouble("DoanhThu");
                    revenueData.put(date, revenue); // Thêm vào Map
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revenueData;
    }
    
    public static Map<String, Double> getRevenueByYear(int year) {
        Map<String, Double> revenueData = new LinkedHashMap<>(); // Sử dụng LinkedHashMap để giữ thứ tự
        String query = "SELECT MONTH(NgayLap) AS Thang, SUM(TongTien) AS DoanhThu " +
                       "FROM HoaDon " +
                       "WHERE YEAR(NgayLap) = ? " +
                       "GROUP BY MONTH(NgayLap) " +
                       "ORDER BY Thang"; // Sắp xếp theo tháng tăng dần

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, year); // Gán giá trị năm

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int month = rs.getInt("Thang"); // Lấy giá trị tháng
                    Double revenue = rs.getDouble("DoanhThu"); // Lấy doanh thu
                    revenueData.put("Tháng " + String.format("%02d", month), revenue); // Định dạng Tháng 01, Tháng 02, ...
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revenueData;
    }


}
