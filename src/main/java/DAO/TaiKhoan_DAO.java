/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.mail.PasswordAuthentication;


import ConnectDB.ConnectDB;
import UTIL.MaHoa;



/**
 *
 * @author Admin
 */
public class TaiKhoan_DAO {
    private ConnectDB dbConnection = new ConnectDB();

    public boolean checkLogin(String tenDangNhap, String matKhau) {
        boolean isValid = false;
        Connection connection = dbConnection.getConnection();
        try {
            String query = "SELECT * FROM TAIKHOAN WHERE TenDangNhap=? AND MatKhau=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);  // Mật khẩu đã mã hóa trong Java

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isValid = true; // Đăng nhập thành công
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }


    public String getTaiKhoanByTenDangNhap(String tenDangNhap) {
        String maTaiKhoan = "";
        Connection connection = dbConnection.getConnection();
        try {
            String query = "SELECT MaTaiKhoan FROM TAIKHOAN WHERE TenDangNhap=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenDangNhap);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                maTaiKhoan = rs.getString("MaTaiKhoan");
            }
        } catch (SQLException e) {
        }
        return maTaiKhoan;
    }
    
 // Phương thức lấy mã nhân viên dựa vào tên đăng nhập
    public String getMaNhanVienByTenDangNhap(String tenDangNhap) {
        String maNhanVien = null;
        String sql = "SELECT NhanVien.MaNhanVien FROM NhanVien "
                + "JOIN TaiKhoan ON NhanVien.TaiKhoan = TaiKhoan.MaTaiKhoan "
                + "WHERE TaiKhoan.TenDangNhap = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tenDangNhap);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maNhanVien = rs.getString("MaNhanVien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maNhanVien;
    }
    
    public boolean isEmailExist(String email) {
        boolean exists = false;
        Connection connection = dbConnection.getConnection();
        try {
            String query = "SELECT * FROM TAIKHOAN WHERE Email=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exists = true; // Email tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public void sendResetPasswordEmail(String email) {
    	String resetToken = generateResetToken();
        // Cấu hình thông tin gửi email
        String host = "smtp.gmail.com";
        final String user = "mait58674@gmail.com";  // Địa chỉ email của bạn
        final String password = "gvbq owdz ampz plig"; // Mật khẩu email của bạn
        String to = email; // Người nhận email
        String subject = "Đặt lại mật khẩu của bạn";
        String message = "Xin chào, \n\n" +
                         "Bạn yêu cầu đặt lại mật khẩu. Mã xác nhận của bạn là: " + resetToken + "\n\n" +
                         "Nếu bạn không yêu cầu đặt lại mật khẩu, vui lòng bỏ qua email này.";

        // Thiết lập các thuộc tính của email
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587"); // Sử dụng cổng 587 cho STARTTLS
        properties.put("mail.smtp.auth", "true"); // Bật xác thực SMTP
        properties.put("mail.smtp.starttls.enable", "true"); // Bật STARTTLS

        // Cấu hình phiên gửi email
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
        	// Tạo đối tượng email
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(user));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText(message);

            // Gửi email
            Transport.send(msg);
            JOptionPane.showMessageDialog(null, "Gửi email thành công! Vui lòng kiểm tra email của bạn.");
            
            // Sau khi gửi thành công, yêu cầu người dùng nhập mã token
            String enteredToken = JOptionPane.showInputDialog("Nhập mã xác nhận bạn nhận được từ email:");

            // Kiểm tra mã token
            if (enteredToken.equals(resetToken)) {
                // Mã đúng, hiển thị khung nhập mật khẩu mới
                String newPassword = JOptionPane.showInputDialog("Nhập mật khẩu mới:");
                newPassword = MaHoa.toSHA1(newPassword);
                // Cập nhật mật khẩu vào cơ sở dữ liệu
                updatePassword(email, newPassword);
                JOptionPane.showMessageDialog(null, "Mật khẩu đã được cập nhật thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Mã xác nhận không đúng. Vui lòng thử lại.");
                
            }
        } catch (MessagingException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã có lỗi khi gửi email!");
        }
    }

    // Phương thức tạo mã xác nhận hoặc token (có thể dùng UUID hoặc tạo bằng cách khác)
    public String generateResetToken() {
        Random rand = new Random();
        int token = rand.nextInt(900000) + 100000; // Sinh ngẫu nhiên một số trong khoảng 100000 đến 999999
        return String.valueOf(token); // Chuyển số thành chuỗi
    }
    
    public void updatePassword(String email, String newPassword) {
        Connection connection = dbConnection.getConnection();
        try {
            String query = "UPDATE TAIKHOAN SET MatKhau=? WHERE Email=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, email);
            int result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật mật khẩu: " + e.getMessage());
        }
    }
}
