/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.DanhSachDatPhong_DAO;
import DAO.HoaDon_DAO;

/**
 *
 * @author Admin
 */
public class DanhSachDatPhong_GUI extends javax.swing.JPanel {
	private DefaultTableModel originalModel;
	private DanhSachDatPhong_DAO danhSachDatPhongDAO = new DanhSachDatPhong_DAO();
	

    /**
     * Creates new form DanhSachDatPhong
     */
    public DanhSachDatPhong_GUI() {
        initComponents();

        updateHeader();
        
        loadDataToTable();
        setWidthColumns();
        
        
        // Lưu model ban đầu ngay khi khởi tạo
        originalModel = (DefaultTableModel) tbDanhSachDatPhong.getModel();

        
//        Chức năng tìm kiếm
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
        RoundedPanel btnHuy = new RoundedPanel(20);
        RoundedPanel btnCapNhat = new RoundedPanel(20);
        RoundedPanel btnNhanPhong = new RoundedPanel(20);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        titleHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleHoaDon.setText("Danh sách đặt phòng");

        tbDanhSachDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},  // Bắt đầu với dữ liệu rỗng
            new String[] { "Mã khách hàng", "Tên khách hàng", "CCCD", "Phái", "Ngày sinh", "Điện thoại" }
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

        btnHuy.setBackground(new java.awt.Color(255, 0, 0));
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/delete.png"))); // NOI18N
        jLabel1.setText("Hủy");

        javax.swing.GroupLayout btnHuyLayout = new javax.swing.GroupLayout(btnHuy);
        btnHuy.setLayout(btnHuyLayout);
        btnHuyLayout.setHorizontalGroup(
            btnHuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHuyLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnHuyLayout.setVerticalGroup(
            btnHuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHuyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        btnCapNhat.setBackground(new java.awt.Color(245, 109, 40));
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/fixing.png"))); // NOI18N
        jLabel2.setText("Cập nhật");

        javax.swing.GroupLayout btnCapNhatLayout = new javax.swing.GroupLayout(btnCapNhat);
        btnCapNhat.setLayout(btnCapNhatLayout);
        btnCapNhatLayout.setHorizontalGroup(
            btnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        btnCapNhatLayout.setVerticalGroup(
            btnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCapNhatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        btnNhanPhong.setBackground(new java.awt.Color(25, 159, 254));
        btnNhanPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/add.png"))); // NOI18N
        jLabel3.setText("Nhận Phòng");

        javax.swing.GroupLayout btnNhanPhongLayout = new javax.swing.GroupLayout(btnNhanPhong);
        btnNhanPhong.setLayout(btnNhanPhongLayout);
        btnNhanPhongLayout.setHorizontalGroup(
            btnNhanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNhanPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnNhanPhongLayout.setVerticalGroup(
            btnNhanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNhanPhongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        txtTimKiem.setForeground(new java.awt.Color(144, 144, 144));
        txtTimKiem.setText("Nhập tên KH, SDT để tìm");
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

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Search.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tìm khách hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(titleHoaDon)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {
        txtTimKiem.setText("");
        txtTimKiem.setForeground(Color.BLACK);
    }

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {
        txtTimKiem.setForeground(Color.decode("#909090"));
    }

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {
    	int selectedRow = tbDanhSachDatPhong.getSelectedRow(); // Lấy dòng được chọn
        if (selectedRow != -1) {
            // Hiển thị hộp thoại xác nhận
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy đặt phòng này không?", "Xác nhận hủy", JOptionPane.YES_NO_OPTION);
            
            // Nếu người dùng chọn YES thì thực hiện xóa
            if (confirm == JOptionPane.YES_OPTION) {
                String maPhieuDatPhong = tbDanhSachDatPhong.getValueAt(selectedRow, 1).toString(); // Giả sử mã hóa đơn ở cột thứ 2

                // Gọi phương thức xóa từ DAO
                boolean isDeleted = danhSachDatPhongDAO.deletePhieuDatPhong(maPhieuDatPhong);

                if (isDeleted) {
                    // Xóa dòng khỏi bảng giao diện sau khi xóa thành công
                    ((DefaultTableModel) tbDanhSachDatPhong.getModel()).removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa không thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần hủy!");
        }
    }
    
    private void updateHeader() {
		JTableHeader header = tbDanhSachDatPhong.getTableHeader();
		header.setFont(new Font("Times new Romans", Font.BOLD, 16));
	}
    
    private void setWidthColumns() {
        tbDanhSachDatPhong.getColumnModel().getColumn(0).setMaxWidth(50); // Đặt chiều rộng tối thiểu cho cột STT
        tbDanhSachDatPhong.getColumnModel().getColumn(4).setMaxWidth(100);
        tbDanhSachDatPhong.getColumnModel().getColumn(5).setMaxWidth(70);
	}
    
    private void loadDataToTable() {
        DanhSachDatPhong_DAO danhSachDatPhongDAO = new DanhSachDatPhong_DAO();
        List<Object[]> dsHoaDon = danhSachDatPhongDAO.getAllDanhSachDatPhong();

        DefaultTableModel tableModel = new DefaultTableModel(
            new Object[][] {},  // Bắt đầu với dữ liệu rỗng
            new String[] { "Stt", "Mã Phiếu đặt phòng", "Tên khách hàng", "Số điện thoại", "Phái", "Phòng", "Ngày nhận", "Ngày trả", "Tiền cọc" }
        );

        tbDanhSachDatPhong.setModel(tableModel);
        tableModel.setRowCount(0);

        // Định dạng ngày theo dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Object[] row : dsHoaDon) {
            tableModel.addRow(new Object[]{
                row[0],  
                row[1],
                row[2],  
                row[3],  
                row[4],  
                row[5],
                dateFormat.format(row[6]), 
                dateFormat.format(row[7]),
                row[8]
            });
        }
    }
    
    // Phương thức lọc dữ liệu
    private void filterTableData() {
        String keyword = txtTimKiem.getText().trim().toLowerCase(); // Lấy từ khóa tìm kiếm

        // Kiểm tra nếu từ khóa rỗng, khôi phục dữ liệu ban đầu
        if (keyword.isEmpty()) {
            tbDanhSachDatPhong.setModel(originalModel); // Khôi phục model ban đầu
            return;
        }

        // Tạo model mới để chứa dữ liệu lọc
        DefaultTableModel filteredModel = new DefaultTableModel(
        		new String[] { "Stt", "Mã Phiếu đặt phòng", "Tên khách hàng", "Số điện thoại", "Phái", "Phòng", "Ngày nhận", "Ngày trả", "Tiền cọc" }, 
                0
        );

        boolean found = false; // Đánh dấu nếu tìm thấy dữ liệu

        // Duyệt qua từng hàng trong originalModel và lọc dữ liệu
        for (int i = 0; i < originalModel.getRowCount(); i++) {// Lấy tên khách hàng và mã phòng, kiểm tra null và loại bỏ khoảng trắng
            String tenKhachHang = originalModel.getValueAt(i, 2) != null 
                    ? originalModel.getValueAt(i, 2).toString().trim().toLowerCase() 
                    : "";
			String maPhong = originalModel.getValueAt(i, 3) != null 
			               ? originalModel.getValueAt(i, 3).toString().trim().toLowerCase() 
			               : "";
			

            // Kiểm tra nếu từ khóa xuất hiện trong tên khách hàng hoặc mã phòng
            if (tenKhachHang.contains(keyword) || maPhong.contains(keyword)) {
                filteredModel.addRow(new Object[]{
                    originalModel.getValueAt(i, 0),
                    originalModel.getValueAt(i, 1), 
                    originalModel.getValueAt(i, 2), 
                    originalModel.getValueAt(i, 3),
                    originalModel.getValueAt(i, 4),
                    originalModel.getValueAt(i, 5), 
                    originalModel.getValueAt(i, 6),
                    originalModel.getValueAt(i, 7) 
                });
                found = true; // Đánh dấu là đã tìm thấy dữ liệu
            }
        }

        // Cập nhật JTable với model đã lọc hoặc hiển thị thông báo nếu không tìm thấy
        if (found) {
            tbDanhSachDatPhong.setModel(filteredModel);
            setWidthColumns();// Cập nhật model đã lọc
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu phù hợp!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCapNhat;
    private javax.swing.JPanel btnHuy;
    private javax.swing.JPanel btnNhanPhong;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDanhSachDatPhong;
    private javax.swing.JLabel titleHoaDon;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
