/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import ConnectDB.ConnectDB;
import DAO.NhanVien_DAO;
import DAO.TaiKhoan_DAO;
import UTIL.MaHoa;

import java.awt.event.KeyEvent;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Login_GUI extends javax.swing.JFrame {
	public static String maNhanVien; // Biến tĩnh để lưu mã nhân viên đăng nhập
    private TaiKhoan_DAO taiKhoanDAO = new TaiKhoan_DAO();
    private NhanVien_DAO nhanVienDAO = new NhanVien_DAO();
    
    public Login_GUI() {
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnLogin);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        iconEyeHide = new javax.swing.JLabel();
        iconEyeShow = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/hotel.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, -10, 400, 540);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("LOGIN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 33, -1, 73));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 127, 77, 27));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 77, 27));

        jLabel5.setText("______________________________________________");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 230, -1));

        jLabel6.setText("______________________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 230, 20));

        txtUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUserName.setBorder(null);
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 245, 43));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/user.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 20, 30));

        iconEyeHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/eye-hide.png"))); // NOI18N
        iconEyeHide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconEyeHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconEyeHideMouseClicked(evt);
            }
        });
        jPanel2.add(iconEyeHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        iconEyeShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/eye-show.png"))); // NOI18N
        iconEyeShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconEyeShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconEyeShowMouseClicked(evt);
            }
        });
        jPanel2.add(iconEyeShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setBorder(null);
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 252, 250, 50));

        btnLogin.setBackground(new java.awt.Color(25, 159, 254));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 310, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 0, 400, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void iconEyeShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconEyeShowMouseClicked
        // TODO add your handling code here:
        txtPassword.setEchoChar('*');
        iconEyeShow.setVisible(false);
        iconEyeShow.setEnabled(false);
        iconEyeHide.setVisible(true);
        iconEyeHide.setEnabled(true);
    }//GEN-LAST:event_iconEyeShowMouseClicked

    private void iconEyeHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconEyeHideMouseClicked
        // TODO add your handling code here:
        txtPassword.setEchoChar((char)0);
        iconEyeHide.setVisible(false);
        iconEyeHide.setEnabled(false);
        iconEyeShow.setVisible(true);
        iconEyeShow.setEnabled(true);
    }//GEN-LAST:event_iconEyeHideMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String tenDangNhap = txtUserName.getText();
        String matKhau = new String(txtPassword.getPassword());
        String matKhauMaHoa = MaHoa.toSHA1(matKhau);
          if (taiKhoanDAO.checkLogin(tenDangNhap, matKhauMaHoa)) {
        String maTaiKhoan = taiKhoanDAO.getTaiKhoanByTenDangNhap(tenDangNhap);
        String userRole;
        String userName = nhanVienDAO.getTenNhanVienByMaTaiKhoan(maTaiKhoan);

        if (nhanVienDAO.isManager(maTaiKhoan)) {
            userRole = "NV_QUANLY"; // Quản lý
        } else {
            userRole = "NV_LETAN"; // Nhân viên
        }

        // Mở trang chính và truyền vai trò vào Home_GUI
        Home_GUI home = new Home_GUI(userRole, userName);
        home.setVisible(true);
        maNhanVien = taiKhoanDAO.getMaNhanVienByTenDangNhap(tenDangNhap);
        this.dispose();  // Đóng cửa sổ login
        } else {
            JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu!");
            System.out.println(matKhauMaHoa);
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_GUI().setVisible(true);
            }
        });
    }
//    Dem
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel iconEyeHide;
    private javax.swing.JLabel iconEyeShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
