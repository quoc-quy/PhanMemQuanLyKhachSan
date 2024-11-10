package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ENTITY.Phong;
import ENTITY.PhieuDatPhong;

public class ChiTietDatPhong_Dialog extends javax.swing.JDialog {

    public ChiTietDatPhong_Dialog(Frame parent, Phong phong, PhieuDatPhong phieuDatPhong) {
        super(parent, "Chi tiết phòng - " + phong.getMaPhong(), true);
        
        setSize(600, 400);
        setLocationRelativeTo(parent);

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
        dialogPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.setBackground(Color.white);

        JLabel lblKhachHang = new JLabel("Khách hàng: " + phieuDatPhong.getKhachHang().getTenKhachHang());
        lblKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblKhachHang.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblKhachHang);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel lblLoaiHinh = new JLabel("Loại hình: " + phieuDatPhong.getLoaiHinh());
        lblLoaiHinh.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblLoaiHinh.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblLoaiHinh);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel lblCheckIn = new JLabel("Check-in: " + phieuDatPhong.getNgayNhanPhong());
        lblCheckIn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblCheckIn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblCheckIn);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel lblCheckOut = new JLabel("Check-out: " + phieuDatPhong.getNgayTraPhong());
        lblCheckOut.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblCheckOut.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblCheckOut);
        dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        JLabel lblTongTien = new JLabel("Tổng tiền: " + phieuDatPhong.getTongTien());
        lblTongTien.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTongTien.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.add(lblTongTien);
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
        
        btnChuyenPhong.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				showChangeRoomGUI(phong, phieuDatPhong);
			}
		});
        
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
        btnDichVu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String maphong = phong.getMaPhong();

			    Window window = SwingUtilities.getWindowAncestor(ChiTietDatPhong_Dialog.this);
			    ThemDichVu_Dialog dialogThemDV = new ThemDichVu_Dialog(window, true, maphong, ChiTietDatPhong_Dialog.this);
			    ChiTietDatPhong_Dialog.this.dispose();
			    dialogThemDV.setModal(true);
			    dialogThemDV.toFront();
			    dialogThemDV.requestFocus();
			    dialogThemDV.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        
        buttonPanel.add(btnTraPhong);
        buttonPanel.add(btnChuyenPhong);
        buttonPanel.add(btnDatPhong);
        buttonPanel.add(btnDichVu);

        // Đăng ký sự kiện cho các nút nếu cần thiết (ví dụ: btnReturnRoom.addActionListener(...))

        add(dialogPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    private void showChangeRoomGUI(Phong phong, PhieuDatPhong phieuDatPhong) {
    	Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(this);
		ChuyenPhong_Dialog_GUI chuyenPhong_Dialog_GUI = new ChuyenPhong_Dialog_GUI(parentFrame, phong, phieuDatPhong, this);
		chuyenPhong_Dialog_GUI.setVisible(true);
    }
}