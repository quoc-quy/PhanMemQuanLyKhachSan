/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import DAO.DanhSachDatPhong_DAO;
import DAO.LichSuChuyenPhong_DAO;
import DAO.Phong_DAO;

/**
 *
 * @author 84837
 */
public class LichSuChuyenPhong_GUI extends javax.swing.JPanel {
	private DefaultTableModel originalModel;
    private JTable tbLichSuChuyenPhong;
	private LichSuChuyenPhong_DAO lichSuChuyenPhongDao = new LichSuChuyenPhong_DAO();
    private Phong_DAO phongDAO = new Phong_DAO();

    /**
     * Creates new form LichSuChuyenPhong_GUI
     */
    public LichSuChuyenPhong_GUI() {
        initComponents();
        setDefaultDate();
        updateHeader();
        
        loadDataToTable();
        

        
		// Lưu model ban đầu ngay khi khởi tạo
        originalModel = (DefaultTableModel) tbLichSuChuyenPhong.getModel();
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
        titleHoaDon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNgayCheckIn = new com.toedter.calendar.JDateChooser();
        tbLichSuChuyenPhong = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgayCheckOut = new com.toedter.calendar.JDateChooser();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        titleHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleHoaDon.setText("Lịch sử chuyển phòng");
        
        tbLichSuChuyenPhong.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},  // Bắt đầu với dữ liệu rỗng
                new String[] { "Mã chuyển phòng", "Mã phiếu đặt phòng","Phòng cũ", "Phòng mới", "Lý do", "Ngày chuyển phòng"}
            ) {
                Class<?>[] types = new Class<?>[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;  // Không cho phép chỉnh sửa dữ liệu trong bảng
                }
            });
        tbLichSuChuyenPhong.setRowHeight(40);
            jScrollPane1.setViewportView(tbLichSuChuyenPhong);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        txtNgayCheckIn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNgayCheckInPropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Từ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Đến");

        txtNgayCheckOut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNgayCheckOutPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleHoaDon)
                    .addComponent(txtNgayCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgayCheckInPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNgayCheckInPropertyChange
        if (txtNgayCheckIn.getDate() != null && txtNgayCheckOut.getDate() != null) {
            // Gọi hàm lọc theo ngày
            loadDataToTable();
        }
    }//GEN-LAST:event_txtNgayCheckInPropertyChange

    private void txtNgayCheckOutPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNgayCheckOutPropertyChange
        if (txtNgayCheckIn.getDate() != null && txtNgayCheckOut.getDate() != null) {
            // Gọi hàm lọc theo ngày
            loadDataToTable();
        }
    }//GEN-LAST:event_txtNgayCheckOutPropertyChange
    
    private void updateHeader() {
		JTableHeader header = tbLichSuChuyenPhong.getTableHeader();
		header.setFont(new Font("Times new Romans", Font.BOLD, 16));
	}
    
    private void txtNgayCheckInPropertyChange1(java.beans.PropertyChangeEvent evt) {   
        loadDataToTable(); // Gọi lại khi thay đổi ngày check-in
    }

    private void txtNgayCheckOutPropertyChange1(java.beans.PropertyChangeEvent evt) {   
        loadDataToTable(); // Gọi lại khi thay đổi ngày check-out
    }
    
    public void loadDataToTable() {
        LichSuChuyenPhong_DAO lichSuChuyenPhongDao = new LichSuChuyenPhong_DAO();
        List<Object[]> dsChuyenPhong;

        // Kiểm tra xem ngày Check-In và Check-Out có được chọn không
        if (txtNgayCheckIn.getDate() == null || txtNgayCheckOut.getDate() == null) {
            // Nếu chưa chọn ngày, lấy tất cả dữ liệu
            dsChuyenPhong = lichSuChuyenPhongDao.getAllLichSuChuyenPhong();
        } else {
            // Nếu đã chọn ngày, lọc theo khoảng thời gian
            java.sql.Date ngayCheckIn = new java.sql.Date(txtNgayCheckIn.getDate().getTime());
            java.sql.Date ngayCheckOut = new java.sql.Date(txtNgayCheckOut.getDate().getTime());
            dsChuyenPhong = lichSuChuyenPhongDao.getLichSuChuyenPhongTheoKhoangThoiGian(ngayCheckIn, ngayCheckOut);
        }

        DefaultTableModel tableModel = new DefaultTableModel(
            new Object[][] {},  // Bắt đầu với dữ liệu rỗng
            new String[] { "Mã chuyển phòng", "Mã phiếu đặt phòng", "Phòng cũ", "Phòng mới", "Lý do", "Ngày chuyển phòng" }
        );

        tbLichSuChuyenPhong.setModel(tableModel);
        tableModel.setRowCount(0);

        // Định dạng ngày theo dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Object[] row : dsChuyenPhong) {
            // Kiểm tra nếu giá trị ngày chuyển phòng là không null
            String ngayChuyenPhong = null;
            if (row[5] != null && row[5] instanceof java.sql.Date) {
                ngayChuyenPhong = dateFormat.format((java.sql.Date) row[5]);
            }

            tableModel.addRow(new Object[]{ 
                row[0],  // Mã chuyển phòng
                row[1],  // Mã phiếu đặt phòng
                row[2],  // Phòng cũ
                row[3],  // Phòng mới
                row[4],  // Lý do
                ngayChuyenPhong  // Ngày chuyển phòng
            });
        }
    }
    
    private void setDefaultDate() {
    	Calendar calendar = Calendar.getInstance();

        // Đặt giờ về 0:00 để tránh sai lệch thời gian
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        txtNgayCheckIn.setDateFormatString("dd/MM/yyyy");
        txtNgayCheckOut.setDateFormatString("dd/MM/yyyy");

        // Ngày Check-in là ngày hiện tại
        java.util.Date checkInDate = calendar.getTime();
        txtNgayCheckIn.setDate(checkInDate);

        // Ngày Check-out là ngày hôm sau
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        java.util.Date checkOutDate = calendar.getTime();
        txtNgayCheckOut.setDate(checkOutDate);
    }







    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleHoaDon;
    private com.toedter.calendar.JDateChooser txtNgayCheckIn;
    private com.toedter.calendar.JDateChooser txtNgayCheckOut;
    // End of variables declaration//GEN-END:variables
}
