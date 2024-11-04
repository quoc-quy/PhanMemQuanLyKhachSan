package GUI;

import javax.swing.*;
import java.awt.*;
import ENTITY.Phong;
import ENTITY.PhieuDatPhong;

public class ChiTietDatPhong_Dialog extends JDialog {

    public ChiTietDatPhong_Dialog(Frame parent, Phong phong) {
        super(parent, "Chi tiết phòng - " + phong.getMaPhong(), true);
        
        setSize(600, 400);
        setLocationRelativeTo(parent);

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
        dialogPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.setBackground(Color.white);

        JLabel lblMaPhong = new JLabel("Mã phòng: " + phong.getMaPhong());
        lblMaPhong.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblMaPhong.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblMaPhong);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel lblLoaiPhong = new JLabel("Loại phòng: " + phong.getLoaiPhong().getTenLoaiPhong());
        lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblLoaiPhong.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblLoaiPhong);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel lblGiaNgay = new JLabel("Giá ngày: " + phong.getLoaiPhong().getGiaTienTheoNgay());
        lblGiaNgay.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblGiaNgay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblGiaNgay);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel lblGiaGio = new JLabel("Giá giờ: " + phong.getLoaiPhong().getGiaTienTheoGio());
        lblGiaGio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblGiaGio.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblGiaGio);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel lblTinhTrang = new JLabel("Tình trạng: Đang sử dụng");
        lblTinhTrang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTinhTrang.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblTinhTrang);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        // Thêm các nút chức năng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnTraPhong = new JButton("Trả phòng");
        JButton btnChuyenPhong = new JButton("Chuyển phòng");
        JButton btnDatPhong = new JButton("Đặt phòng");
        JButton btnDichVu = new JButton("Dịch vụ");
        
        btnTraPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnTraPhong.setBackground(Color.decode("#FF0000"));
        btnTraPhong.setMaximumSize(new Dimension(btnTraPhong.getPreferredSize().width + 20, btnTraPhong.getPreferredSize().height + 10));
        btnTraPhong.setPreferredSize(new Dimension(btnTraPhong.getPreferredSize().width + 20, btnTraPhong.getPreferredSize().height + 10));
        btnTraPhong.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTraPhong.setForeground(Color.white);
        btnTraPhong.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.setBackground(Color.white);
        
        btnChuyenPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnChuyenPhong.setBackground(Color.decode("#F56D28"));
        btnChuyenPhong.setMaximumSize(new Dimension(btnChuyenPhong.getPreferredSize().width + 20, btnChuyenPhong.getPreferredSize().height + 10));
        btnChuyenPhong.setPreferredSize(new Dimension(btnChuyenPhong.getPreferredSize().width + 20, btnChuyenPhong.getPreferredSize().height + 10));
        btnChuyenPhong.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnChuyenPhong.setForeground(Color.white);
        btnChuyenPhong.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.setBackground(Color.white);
        
        btnDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnDatPhong.setBackground(Color.decode("#199FFE"));
        btnDatPhong.setMaximumSize(new Dimension(btnDatPhong.getPreferredSize().width + 20, btnDatPhong.getPreferredSize().height + 10));
        btnDatPhong.setPreferredSize(new Dimension(btnDatPhong.getPreferredSize().width + 20, btnDatPhong.getPreferredSize().height + 10));
        btnDatPhong.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDatPhong.setForeground(Color.white);
        btnDatPhong.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.setBackground(Color.white);
        
        btnDichVu.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnDichVu.setBackground(Color.decode("#130CB7"));
        btnDichVu.setMaximumSize(new Dimension(btnDichVu.getPreferredSize().width + 20, btnDichVu.getPreferredSize().height + 10));
        btnDichVu.setPreferredSize(new Dimension(btnDichVu.getPreferredSize().width + 20, btnDichVu.getPreferredSize().height + 10));
        btnDichVu.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDichVu.setForeground(Color.white);
        btnDichVu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.setBackground(Color.white);

        buttonPanel.add(btnTraPhong);
        buttonPanel.add(btnChuyenPhong);
        buttonPanel.add(btnDatPhong);
        buttonPanel.add(btnDichVu);

        // Đăng ký sự kiện cho các nút nếu cần thiết (ví dụ: btnReturnRoom.addActionListener(...))

        add(dialogPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}