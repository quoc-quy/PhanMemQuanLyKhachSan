/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public class Home_GUI extends javax.swing.JFrame {

    private CardLayout cardLayout;
	private JPanel panelKhac;
	private JLabel lbKhac;
	/**
     * Creates new form Home_GUI
     */
    public Home_GUI(String userRole) {
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cardPanel.add(new Phong_GUI(), "room");
        cardPanel.add(new DichVu_GUI(), "service");
        
         adjustMenuBasedOnRole(userRole);  // Điều chỉnh menu theo vai trò
    }
    
    private void adjustMenuBasedOnRole(String userRole) {
        if (userRole.equals("NV_QUANLY")) {
            panelThongKeGiaoCa.setVisible(false);  // Ẩn Thống kê giao ca
        } else if (userRole.equals("NV_LETAN")) {
            panelThongKe.setVisible(false);   // Ẩn thống kê
            panelDichVu.setVisible(false);   // Ẩn Dịch vụ
            panelHoaDon.setVisible(false);   // Ẩn Hóa đơn
            panelKhuyenMai.setVisible(false);   // Ẩn Khuyen Mai
            panelNhanVien.setVisible(false);   // Ẩn Nhân viên
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelUser3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        panelPhong = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbPhong = new javax.swing.JLabel();
        panelKhachHang = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        panelDichVu = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbDichVu = new javax.swing.JLabel();
        panelHoaDon = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbHoaDon = new javax.swing.JLabel();
        panelThongKe = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbThongKe = new javax.swing.JLabel();
        panelKhuyenMai = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        lbKhuyenMai = new javax.swing.JLabel();
        panelNhanVien = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        lbNhanVien = new javax.swing.JLabel();
        panelThongKeGiaoCa = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        lbThongKeGiaoCa = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelTroGiup = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        lbTroGiup = new javax.swing.JLabel();
        panelDangXuat = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        lbDangXuat = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 300));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        panelUser3.setBackground(new java.awt.Color(255, 255, 255));
        panelUser3.setForeground(new java.awt.Color(255, 102, 0));
        panelUser3.setMaximumSize(new java.awt.Dimension(300, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/user_1.png"))); // NOI18N
        jLabel3.setText("jLabel1");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Trần Nguyễn Quốc Quý");

        jSeparator2.setBackground(new java.awt.Color(0, 204, 0));
        jSeparator2.setAlignmentX(10.0F);
        jSeparator2.setAlignmentY(10.0F);
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 100));

        javax.swing.GroupLayout panelUser3Layout = new javax.swing.GroupLayout(panelUser3);
        panelUser3.setLayout(panelUser3Layout);
        panelUser3Layout.setHorizontalGroup(
            panelUser3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUser3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelUser3Layout.setVerticalGroup(
            panelUser3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUser3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUser3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panelUser3);

        panelPhong.setBackground(new java.awt.Color(255, 255, 255));
        panelPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelPhong.setMaximumSize(new java.awt.Dimension(300, 60));
        panelPhong.setPreferredSize(new java.awt.Dimension(300, 60));
        panelPhong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelPhongFocusGained(evt);
            }
        });
        panelPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPhongMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/room.png"))); // NOI18N
        jLabel6.setText("jLabel3");

        lbPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbPhong.setText("Sơ đồ phòng");
        lbPhong.setMaximumSize(new java.awt.Dimension(300, 60));
        lbPhong.setMinimumSize(new java.awt.Dimension(300, 60));
        lbPhong.setPreferredSize(new java.awt.Dimension(300, 60));

        javax.swing.GroupLayout panelPhongLayout = new javax.swing.GroupLayout(panelPhong);
        panelPhong.setLayout(panelPhongLayout);
        panelPhongLayout.setHorizontalGroup(
            panelPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPhongLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        panelPhongLayout.setVerticalGroup(
            panelPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPhongLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelPhong);

        panelKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        panelKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelKhachHang.setMaximumSize(new java.awt.Dimension(300, 60));
        panelKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelKhachHangMouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/client.png"))); // NOI18N
        jLabel7.setText("jLabel5");

        lbKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbKhachHang.setText("Khách hàng");

        javax.swing.GroupLayout panelKhachHangLayout = new javax.swing.GroupLayout(panelKhachHang);
        panelKhachHang.setLayout(panelKhachHangLayout);
        panelKhachHangLayout.setHorizontalGroup(
            panelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKhachHangLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        panelKhachHangLayout.setVerticalGroup(
            panelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKhachHangLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbKhachHang))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(panelKhachHang);

        panelDichVu.setBackground(new java.awt.Color(255, 255, 255));
        panelDichVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelDichVu.setMaximumSize(new java.awt.Dimension(300, 60));
        panelDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDichVuMouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/service.png"))); // NOI18N
        jLabel10.setText("jLabel5");

        lbDichVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDichVu.setText("Dịch vụ");

        javax.swing.GroupLayout panelDichVuLayout = new javax.swing.GroupLayout(panelDichVu);
        panelDichVu.setLayout(panelDichVuLayout);
        panelDichVuLayout.setHorizontalGroup(
            panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDichVuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        panelDichVuLayout.setVerticalGroup(
            panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbDichVu))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(panelDichVu);

        panelHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        panelHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelHoaDon.setMaximumSize(new java.awt.Dimension(300, 60));
        panelHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHoaDonMouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/bill.png"))); // NOI18N
        jLabel11.setText("jLabel5");

        lbHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbHoaDon.setText("Hóa đơn");

        javax.swing.GroupLayout panelHoaDonLayout = new javax.swing.GroupLayout(panelHoaDon);
        panelHoaDon.setLayout(panelHoaDonLayout);
        panelHoaDonLayout.setHorizontalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        panelHoaDonLayout.setVerticalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbHoaDon))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(panelHoaDon);

        panelThongKe.setBackground(new java.awt.Color(255, 255, 255));
        panelThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelThongKe.setMaximumSize(new java.awt.Dimension(300, 60));
        panelThongKe.setPreferredSize(new java.awt.Dimension(300, 60));
        panelThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelThongKeMouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/thongke.png"))); // NOI18N
        jLabel13.setText("jLabel11");

        lbThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbThongKe.setText("Thống kê");

        javax.swing.GroupLayout panelThongKeLayout = new javax.swing.GroupLayout(panelThongKe);
        panelThongKe.setLayout(panelThongKeLayout);
        panelThongKeLayout.setHorizontalGroup(
            panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongKeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        panelThongKeLayout.setVerticalGroup(
            panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongKeLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbThongKe))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(panelThongKe);

        panelKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
        panelKhuyenMai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelKhuyenMai.setMaximumSize(new java.awt.Dimension(300, 60));
        panelKhuyenMai.setPreferredSize(new java.awt.Dimension(300, 60));
        panelKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelKhuyenMaiMouseClicked(evt);
            }
        });

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/voucher.png"))); // NOI18N
        jLabel30.setText("jLabel18");

        lbKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
        lbKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbKhuyenMai.setText("Khuyến mãi");

        javax.swing.GroupLayout panelKhuyenMaiLayout = new javax.swing.GroupLayout(panelKhuyenMai);
        panelKhuyenMai.setLayout(panelKhuyenMaiLayout);
        panelKhuyenMaiLayout.setHorizontalGroup(
            panelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKhuyenMaiLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        panelKhuyenMaiLayout.setVerticalGroup(
            panelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKhuyenMaiLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(lbKhuyenMai))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(panelKhuyenMai);

        panelNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        panelNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelNhanVien.setMaximumSize(new java.awt.Dimension(300, 60));
        panelNhanVien.setPreferredSize(new java.awt.Dimension(300, 60));
        panelNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelNhanVienMouseClicked(evt);
            }
        });

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/staff.png"))); // NOI18N
        jLabel32.setText("jLabel20");

        lbNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNhanVien.setText("Nhân viên");

        javax.swing.GroupLayout panelNhanVienLayout = new javax.swing.GroupLayout(panelNhanVien);
        panelNhanVien.setLayout(panelNhanVienLayout);
        panelNhanVienLayout.setHorizontalGroup(
            panelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNhanVienLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        panelNhanVienLayout.setVerticalGroup(
            panelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNhanVienLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lbNhanVien))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(panelNhanVien);

        panelThongKeGiaoCa.setBackground(new java.awt.Color(255, 255, 255));
        panelThongKeGiaoCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelThongKeGiaoCa.setMaximumSize(new java.awt.Dimension(300, 60));
        panelThongKeGiaoCa.setPreferredSize(new java.awt.Dimension(300, 60));
        panelThongKeGiaoCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelThongKeGiaoCaMouseClicked(evt);
            }
        });

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/thong-ke-giao-ca.png"))); // NOI18N
        jLabel34.setText("jLabel20");

        lbThongKeGiaoCa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbThongKeGiaoCa.setText("Thống kê giao ca");

        javax.swing.GroupLayout panelThongKeGiaoCaLayout = new javax.swing.GroupLayout(panelThongKeGiaoCa);
        panelThongKeGiaoCa.setLayout(panelThongKeGiaoCaLayout);
        panelThongKeGiaoCaLayout.setHorizontalGroup(
            panelThongKeGiaoCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongKeGiaoCaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbThongKeGiaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(panelThongKeGiaoCaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        panelThongKeGiaoCaLayout.setVerticalGroup(
            panelThongKeGiaoCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongKeGiaoCaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelThongKeGiaoCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(lbThongKeGiaoCa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelThongKeGiaoCa);

        panelTroGiup.setBackground(new java.awt.Color(255, 255, 255));
        panelTroGiup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTroGiup.setMaximumSize(new java.awt.Dimension(300, 60));
        panelTroGiup.setPreferredSize(new java.awt.Dimension(300, 60));
        panelTroGiup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTroGiupMouseClicked(evt);
            }
        });

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/help.png"))); // NOI18N
        jLabel36.setText("jLabel20");

        lbTroGiup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTroGiup.setText("Trợ giúp");

        javax.swing.GroupLayout panelTroGiupLayout = new javax.swing.GroupLayout(panelTroGiup);
        panelTroGiup.setLayout(panelTroGiupLayout);
        panelTroGiupLayout.setHorizontalGroup(
            panelTroGiupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTroGiupLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTroGiup, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        panelTroGiupLayout.setVerticalGroup(
            panelTroGiupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTroGiupLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelTroGiupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(lbTroGiup))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(panelTroGiup);

        panelDangXuat.setBackground(new java.awt.Color(255, 255, 255));
        panelDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelDangXuat.setMaximumSize(new java.awt.Dimension(300, 60));
        panelDangXuat.setPreferredSize(new java.awt.Dimension(300, 60));
        panelDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDangXuatMouseClicked(evt);
            }
        });

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/exit.png"))); // NOI18N
        jLabel38.setText("jLabel20");

        lbDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDangXuat.setText("Đăng xuất");

        javax.swing.GroupLayout panelDangXuatLayout = new javax.swing.GroupLayout(panelDangXuat);
        panelDangXuat.setLayout(panelDangXuatLayout);
        panelDangXuatLayout.setHorizontalGroup(
            panelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDangXuatLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        panelDangXuatLayout.setVerticalGroup(
            panelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDangXuatLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lbDangXuat))
                .addContainerGap(6, Short.MAX_VALUE))
        );

        jPanel1.add(panelDangXuat);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        cardPanel.setBackground(new java.awt.Color(0, 255, 204));
        cardPanel.setPreferredSize(new java.awt.Dimension(1320, 134));
        cardPanel.setLayout(new java.awt.CardLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 72)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(25, 159, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Welcome to TQSN");
        cardPanel.add(jLabel4, "card2");

        getContentPane().add(cardPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

	private void showPanel(String panelName) {
        // Lấy CardLayout từ cardPanel và hiển thị panel tương ứng
        CardLayout cardLayout = (CardLayout) ((JPanel) getContentPane().getComponent(1)).getLayout();
        cardLayout.show((JPanel) getContentPane().getComponent(1), panelName);
    }
    
//    Hàm thay đổi màu khi click chuột
    private void changePanelColor(JPanel selectedPanel, JLabel selectedLabel) {
        // Đặt màu cho panel được chọn
        selectedPanel.setBackground(Color.decode("#199FFE"));
        selectedLabel.setForeground(Color.white);

        // Khôi phục màu cho các panel còn lại
        Color defaultBackgroundColor = Color.white; // Màu nền mặc định của JPanel
        Color defaultTextColor = Color.black; // Màu chữ mặc định
        
        JPanel[] allPanels = { panelPhong, panelKhachHang, panelDichVu, panelHoaDon, 
                panelThongKe, panelKhuyenMai, panelNhanVien, panelThongKeGiaoCa, 
                panelTroGiup, panelDangXuat };

		JLabel[] allLabels = { lbPhong, lbKhachHang, lbDichVu, lbHoaDon, 
		                lbThongKe, lbKhuyenMai, lbNhanVien, lbThongKeGiaoCa, 
		                lbTroGiup, lbDangXuat };

        for (int i = 0; i < allPanels.length; i++) {
        	if (allPanels[i] != null && allPanels[i] != selectedPanel ) {  // Kiểm tra nếu panel không null
        		allPanels[i].setBackground(defaultBackgroundColor);
            }
            if (allLabels[i] != null && allLabels[i] != selectedLabel) {  // Kiểm tra nếu label không null
            	allLabels[i].setForeground(defaultTextColor);
            }
        }
    }          
    
    private void panelPhongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelPhongFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_panelPhongFocusGained

    private void panelPhongMouseClicked(java.awt.event.MouseEvent evt) {
    	changePanelColor(panelPhong, lbPhong);
        showPanel("room");
    }//GEN-LAST:event_panelPhongMouseClicked

    private void panelDichVuMouseClicked(java.awt.event.MouseEvent evt) {
    	changePanelColor(panelDichVu, lbDichVu);

        showPanel("service");
    }                                        

    private void panelHoaDonMouseClicked(java.awt.event.MouseEvent evt) {
    	changePanelColor(panelHoaDon, lbHoaDon);
    }                                        

    private void panelThongKeMouseClicked(java.awt.event.MouseEvent evt) {
    	changePanelColor(panelThongKe, lbThongKe);
    }                                         

    private void panelKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {
    	changePanelColor(panelKhuyenMai, lbKhuyenMai);
    }                                           

    private void panelNhanVienMouseClicked(java.awt.event.MouseEvent evt) {
    	changePanelColor(panelNhanVien, lbNhanVien);
    }                                          

    private void panelThongKeGiaoCaMouseClicked(java.awt.event.MouseEvent evt) {
    	changePanelColor(panelThongKeGiaoCa, lbThongKeGiaoCa);
    }                                               

    private void panelTroGiupMouseClicked(java.awt.event.MouseEvent evt) {
    	changePanelColor(panelTroGiup, lbTroGiup);
    }                                         

    private void panelKhachHangMouseClicked(java.awt.event.MouseEvent evt) {
    	changePanelColor(panelKhachHang, lbKhachHang);
    }                                           


    private void panelDangXuatMouseClicked(java.awt.event.MouseEvent evt) {
    	changePanelColor(panelDangXuat, lbDangXuat);
        int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?", "Xác nhận", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        // Nếu người dùng chọn "Có" (JOptionPane.YES_OPTION)
        if (response == JOptionPane.YES_OPTION) {
            // Quay về trang đăng nhập
            Login_GUI login = new Login_GUI();
            login.setVisible(true);
            this.dispose();  // Đóng trang Home
        } 
        // Nếu chọn "Không" thì không làm gì, chỉ đóng hộp thoại
        
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Home_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDangXuat;
    private javax.swing.JLabel lbDichVu;
    private javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbKhuyenMai;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lbPhong;
    private javax.swing.JLabel lbThongKe;
    private javax.swing.JLabel lbThongKeGiaoCa;
    private javax.swing.JLabel lbTroGiup;
    private javax.swing.JPanel panelDangXuat;
    private javax.swing.JPanel panelDichVu;
    private javax.swing.JPanel panelHoaDon;
    private javax.swing.JPanel panelKhachHang;
    private javax.swing.JPanel panelKhuyenMai;
    private javax.swing.JPanel panelNhanVien;
    private javax.swing.JPanel panelPhong;
    private javax.swing.JPanel panelThongKe;
    private javax.swing.JPanel panelThongKeGiaoCa;
    private javax.swing.JPanel panelTroGiup;
    private javax.swing.JPanel panelUser3;
    // End of variables declaration//GEN-END:variables
}
