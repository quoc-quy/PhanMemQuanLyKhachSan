/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Components.ExportFile;
import DAO.HoaDon_DAO;
import ENTITY.HoaDon;
import ENTITY.NhanVien;

/**
 *
 * @author 84837
 */
public class BaoCaoCongViec_GUI extends javax.swing.JPanel {
	private DefaultTableModel originalModel;
    /**
     * Creates new form BaoCaoCongViec_GUI
     */
    public BaoCaoCongViec_GUI() {
        initComponents();
        setDefaultDate();
        updateHeader();
        loadDataToTable(); 
        originalModel = (DefaultTableModel) tbDanhSachDatPhong.getModel();
        
        btnTimKiem.addActionListener(e -> filterTableData());
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
        tbDanhSachDatPhong = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNgayCheckIn = new com.toedter.calendar.JDateChooser();
        txtNgayCheckOut = new com.toedter.calendar.JDateChooser();
        cboTrangThai = new javax.swing.JComboBox<>();
        btnXuatFile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        titleHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleHoaDon.setText("Hóa đơn");

        tbDanhSachDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},  // Bắt đầu với dữ liệu rỗng
            new String[] { "Mã hóa đơn", "Mã nhân viên", "Ngày lập", "Ngày nhận phòng", "Ngày trả phòng", "Tổng tiền"
 }
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
        tbDanhSachDatPhong.setRowHeight(40);
        jScrollPane1.setViewportView(tbDanhSachDatPhong);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Đến");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Từ");

        txtNgayCheckIn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNgayCheckInPropertyChange(evt);
            }
        });

        txtNgayCheckOut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNgayCheckOutPropertyChange(evt);
            }
        });

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "QL001", "NV001", "NV002", "NV003", " " }));
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        btnXuatFile = new RoundedPanel(30);
        btnXuatFile.setBackground(new java.awt.Color(129, 251, 184));
        btnXuatFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatFile.setMaximumSize(new java.awt.Dimension(100, 50));
        btnXuatFile.setPreferredSize(new java.awt.Dimension(100, 50));
        btnXuatFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXuatFileMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Export.png"))); // NOI18N
        jLabel1.setText("Xuất file");

        javax.swing.GroupLayout btnXuatFileLayout = new javax.swing.GroupLayout(btnXuatFile);
        btnXuatFile.setLayout(btnXuatFileLayout);
        btnXuatFileLayout.setHorizontalGroup(
            btnXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnXuatFileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnXuatFileLayout.setVerticalGroup(
            btnXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnXuatFileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Search.png"))); // NOI18N

        txtTimKiem.setForeground(new java.awt.Color(144, 144, 144));
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addGap(27, 27, 27)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNgayCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleHoaDon)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(txtNgayCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXuatFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                    .addComponent(txtTimKiem))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgayCheckInPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNgayCheckInPropertyChange
    	if (txtNgayCheckIn.getDate() != null && txtNgayCheckOut.getDate() != null) {
            // Gọi hàm lọc theo ngày
            loadDataToTable();
        }
    }//GEN-LAST:event_txtNgayCheckInPropertyChange
    private void updateHeader() {
		JTableHeader header = tbDanhSachDatPhong.getTableHeader();
		header.setFont(new Font("Times new Romans", Font.BOLD, 16));
	}

    private void txtNgayCheckOutPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNgayCheckOutPropertyChange
    	if (txtNgayCheckIn.getDate() != null && txtNgayCheckOut.getDate() != null) {
            // Gọi hàm lọc theo ngày
            loadDataToTable();
        }
    }//GEN-LAST:event_txtNgayCheckOutPropertyChange

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
    	loadDataToTable();
    }//GEN-LAST:event_cboTrangThaiActionPerformed

    private void btnXuatFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatFileMouseClicked
        // TODO add your handling code here:
    	ExportFile exporter = new ExportFile();
		exporter.exportToPDF(tbDanhSachDatPhong); // Xuất dữ liệu từ bảng tbHoaDon
    }//GEN-LAST:event_btnXuatFileMouseClicked

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        // TODO add your handling code here:
    	txtTimKiem.setText("");
		txtTimKiem.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        // TODO add your handling code here:
    	txtTimKiem.setForeground(Color.decode("#909090"));
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed
    
    private void loadDataToTable() {
        HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
        DefaultTableModel model = (DefaultTableModel) tbDanhSachDatPhong.getModel();
        model.setRowCount(0);  // Reset bảng

        // Lấy giá trị ngày từ txtNgayCheckIn và txtNgayCheckOut
        java.util.Date ngayCheckIn = txtNgayCheckIn.getDate();
        java.util.Date ngayCheckOut = txtNgayCheckOut.getDate();

        // Lấy mã nhân viên từ cboTrangThai (comboBox)
        String maNhanVien = cboTrangThai.getSelectedItem() != null ? cboTrangThai.getSelectedItem().toString() : null;

        // Nếu cả hai ngày đều có giá trị
        if (ngayCheckIn != null && ngayCheckOut != null && maNhanVien != null) {
            java.sql.Date sqlNgayCheckIn = new java.sql.Date(ngayCheckIn.getTime());
            java.sql.Date sqlNgayCheckOut = new java.sql.Date(ngayCheckOut.getTime());
            // Lọc hóa đơn theo khoảng thời gian và mã nhân viên (nếu có)
            List<HoaDon> danhSachHoaDon;
            
            if (maNhanVien != null && !maNhanVien.equals("Tất cả")) {
                danhSachHoaDon = hoaDon_DAO.getHoaDonTheoKhoangThoiGian(sqlNgayCheckIn, sqlNgayCheckOut, maNhanVien);
            } else {
                danhSachHoaDon = hoaDon_DAO.getHoaDonTheoKhoangThoiGian(sqlNgayCheckIn, sqlNgayCheckOut, null); // Nếu mã nhân viên là "Tất cả", bỏ qua lọc theo nhân viên
            }

            // Thêm dữ liệu vào bảng
            for (HoaDon hoaDon : danhSachHoaDon) {
                String maHoaDon = hoaDon.getMaHoaDon();
                String maNhanVien1 = hoaDon.getNhanVienLap() != null ? hoaDon.getNhanVienLap().getMaNhanVien() : "Không có";
                java.util.Date ngayLap = hoaDon.getNgayLap();
                java.util.Date ngayNhanPhong = hoaDon.getNgayNhanPhong();
                java.util.Date ngayTraPhong = hoaDon.getNgayTraPhong();
                Double tongTien = hoaDon.getTongTien();

                model.addRow(new Object[]{
                    maHoaDon,
                    maNhanVien1,
                    ngayLap,
                    ngayNhanPhong,
                    ngayTraPhong,
                    tongTien
                });
            }
        } else {
            // Nếu không có ngày chọn, có thể thông báo lỗi hoặc làm gì đó
        	
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khoảng thời gian!");
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

    private void filterTableData() {
		String keyword = txtTimKiem.getText().trim().toLowerCase(); // Lấy từ khóa tìm kiếm

		// Tạo model mới để chứa dữ liệu lọc
		DefaultTableModel filteredModel = new DefaultTableModel(new String[] { "Mã hóa đơn", "Mã nhân viên", "Ngày lập", "Ngày nhận phòng", "Ngày trả phòng", "Tổng tiền" }, 0);

		boolean found = false; // Đánh dấu nếu tìm thấy dữ liệu

		// Duyệt qua từng hàng trong originalModel và lọc dữ liệu
		for (int i = 0; i < originalModel.getRowCount(); i++) {// Lấy tên khách hàng và mã phòng, kiểm tra null và loại
																// bỏ khoảng trắng
			String tenKhachHang = originalModel.getValueAt(i, 1) != null
					? originalModel.getValueAt(i, 1).toString().trim().toLowerCase()
					: "";
			String maPhong = originalModel.getValueAt(i, 2) != null
					? originalModel.getValueAt(i, 2).toString().trim().toLowerCase()
					: "";

			// Kiểm tra nếu từ khóa xuất hiện trong tên khách hàng hoặc mã phòng
			if (tenKhachHang.contains(keyword) || maPhong.contains(keyword)) {
				filteredModel.addRow(new Object[] { originalModel.getValueAt(i, 0), // Mã hóa đơn
						originalModel.getValueAt(i, 1), // Khách hàng
						originalModel.getValueAt(i, 2), // Phòng
						originalModel.getValueAt(i, 3), // Ngày nhận
						originalModel.getValueAt(i, 4), // Ngày trả
						originalModel.getValueAt(i, 5), // Khuyến mãi
						originalModel.getValueAt(i, 6) // Tổng thanh toán
				});
				found = true; // Đánh dấu là đã tìm thấy dữ liệu
			}
		}

		// Cập nhật JTable với model đã lọc hoặc hiển thị thông báo nếu không tìm thấy
		if(!found) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào trùng với từ khóa");
		}
		tbDanhSachDatPhong.setModel(filteredModel);
	}





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JPanel btnXuatFile;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDanhSachDatPhong;
    private javax.swing.JLabel titleHoaDon;
    private com.toedter.calendar.JDateChooser txtNgayCheckIn;
    private com.toedter.calendar.JDateChooser txtNgayCheckOut;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
