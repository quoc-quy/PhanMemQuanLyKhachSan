package GUI;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import DAO.Phong_DAO;
import ENTITY.PhieuDatPhong;
import ENTITY.Phong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class ChuyenPhong_Dialog_GUI extends JDialog {
	public ChuyenPhong_Dialog_GUI(Frame parent, Phong phong, PhieuDatPhong phieuDatPhong) {
        super(parent, "Phòng hiện tại - " + phieuDatPhong.getPhong().getMaPhong(), true);
        
        setSize(700, 500);
        setLocationRelativeTo(parent);

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
        dialogPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.setBackground(Color.white);

        JLabel lblMaPhong = new JLabel("Phòng hiện tại: " + phong.getMaPhong());
        lblMaPhong.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblMaPhong.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblMaPhong);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel lblLoaiPhong = new JLabel("Khách hàng: " + phieuDatPhong.getKhachHang().getTenKhachHang());
        lblLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblLoaiPhong.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblLoaiPhong);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel lblGiaNgay = new JLabel("Phòng mới: ");
        lblGiaNgay.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblGiaNgay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblGiaNgay);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        JDateChooser txtNgayCheckIn = new com.toedter.calendar.JDateChooser();
        JDateChooser txtNgayCheckOut = new com.toedter.calendar.JDateChooser();
        Calendar calendar = Calendar.getInstance();
        JPanel panelLocNgay = new JPanel();
        JLabel lbLocTu = new JLabel("Từ");
        lbLocTu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtNgayCheckIn.setDateFormatString("dd/MM/yyyy");
		txtNgayCheckOut.setDateFormatString("dd/MM/yyyy");

        // Ngày Check-in là ngày hiện tại
        java.util.Date checkInDate = calendar.getTime();
        txtNgayCheckIn.setDate(checkInDate);
        JLabel lbLocDen = new JLabel("Đến");
        lbLocDen.setFont(new Font("Segoe UI", Font.BOLD, 16));
        // Ngày Check-out là ngày hôm sau
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        java.util.Date checkOutDate = calendar.getTime();
        txtNgayCheckOut.setDate(checkOutDate);
        panelLocNgay.add(lbLocTu);
        panelLocNgay.add(txtNgayCheckIn);
        panelLocNgay.add(lbLocDen);
        panelLocNgay.add(txtNgayCheckOut);
        panelLocNgay.setBackground(Color.white);

        JLabel lblGiaGio = new JLabel("Check-in: " + phieuDatPhong.getNgayNhanPhong());
        lblGiaGio.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblGiaGio.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblGiaGio);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel lblTinhTrang = new JLabel("Check-in: Đang sử dụng");
        lblTinhTrang.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTinhTrang.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblTinhTrang);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        // Thêm các nút chức năng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnXacNhan = new JButton("Xác nhận");
        
        btnXacNhan.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnXacNhan.setBackground(Color.decode("#199FFE"));
        btnXacNhan.setMaximumSize(new Dimension(btnXacNhan.getPreferredSize().width + 20, btnXacNhan.getPreferredSize().height + 10));
        btnXacNhan.setPreferredSize(new Dimension(btnXacNhan.getPreferredSize().width + 20, btnXacNhan.getPreferredSize().height + 10));
        btnXacNhan.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnXacNhan.setForeground(Color.white);
        btnXacNhan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.setBackground(Color.white);

        buttonPanel.add(btnXacNhan);

        // Đăng ký sự kiện cho các nút nếu cần thiết (ví dụ: btnReturnRoom.addActionListener(...))

        add(dialogPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
