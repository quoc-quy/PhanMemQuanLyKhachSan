/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import javax.swing.text.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ConnectDB.ConnectDB;
import DAO.DichVu_DAO;
import ENTITY.DichVu;

/**
 *
 * @author Admin
 */
public class DichVu_GUI extends javax.swing.JPanel {

	/**
	 * Creates new form DichVu_GUI
	 */
	public DichVu_GUI() {
		initComponents();
		loadDataToTableDichVu();
		updateHeader();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel5 = new javax.swing.JLabel();
		btnXoa = new javax.swing.JPanel();
		btnXoa = new RoundedPanel(20);
		lbXoa = new javax.swing.JLabel();
		btnCapNhat = new javax.swing.JPanel();
		btnCapNhat = new RoundedPanel(20);
		lbCapNhat = new javax.swing.JLabel();
		btnThemDichVu = new javax.swing.JPanel();
		btnThemDichVu = new RoundedPanel(20);
		lbThemDichVu = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setLayout(new java.awt.CardLayout());

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabel5.setText("Dịch vụ");

		btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		lbXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		lbXoa.setForeground(Color.white);
		lbXoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/delete.png"))); // NOI18N
		lbXoa.setText("Xóa");
		lbXoa.setIconTextGap(10);

		javax.swing.GroupLayout btnXoaLayout = new javax.swing.GroupLayout(btnXoa);
		btnXoa.setLayout(btnXoaLayout);
		btnXoaLayout.setHorizontalGroup(btnXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(btnXoaLayout.createSequentialGroup().addContainerGap().addComponent(lbXoa,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(18, 18, 18)));
		btnXoaLayout.setVerticalGroup(btnXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(btnXoaLayout.createSequentialGroup().addContainerGap().addComponent(lbXoa)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		lbCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		lbCapNhat.setForeground(Color.white);
		lbCapNhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/fixing.png"))); // NOI18N
		lbCapNhat.setText("Cập nhật");
		lbCapNhat.setIconTextGap(10);

		javax.swing.GroupLayout btnCapNhatLayout = new javax.swing.GroupLayout(btnCapNhat);
		btnCapNhat.setLayout(btnCapNhatLayout);
		btnCapNhatLayout
				.setHorizontalGroup(btnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(btnCapNhatLayout.createSequentialGroup().addContainerGap()
								.addComponent(lbCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addContainerGap()));
		btnCapNhatLayout.setVerticalGroup(btnCapNhatLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(btnCapNhatLayout.createSequentialGroup().addContainerGap().addComponent(lbCapNhat,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		btnThemDichVu.setBackground(new java.awt.Color(25, 159, 254));
		btnThemDichVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		lbThemDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		lbThemDichVu.setForeground(new java.awt.Color(255, 255, 255));
		lbThemDichVu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/add.png"))); // NOI18N
		lbThemDichVu.setText("Thêm dịch vụ");
		lbThemDichVu.setIconTextGap(10);

		javax.swing.GroupLayout btnThemDichVuLayout = new javax.swing.GroupLayout(btnThemDichVu);
		btnThemDichVu.setLayout(btnThemDichVuLayout);
		btnThemDichVuLayout.setHorizontalGroup(btnThemDichVuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(btnThemDichVuLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(lbThemDichVu,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(14, 14, 14)));
		btnThemDichVuLayout.setVerticalGroup(btnThemDichVuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(btnThemDichVuLayout.createSequentialGroup().addContainerGap().addComponent(lbThemDichVu,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

		jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, "", "", null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Mã sản phẩm", "Tên sản phẩm", "Đơn vị tính", "Số lượng", "Đơn giá" }) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.Integer.class, java.lang.Float.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jTable1.setRowHeight(40);
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
						.addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addComponent(jSeparator1));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(8, 8, 8)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(jLabel5)
								.addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnThemDichVu, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)));

		add(jPanel2, "card2");
	}// </editor-fold>//GEN-END:initComponents

	private void updateHeader() {
		JTableHeader header = jTable1.getTableHeader();
		header.setFont(new Font("Times new Romans", Font.BOLD, 16));

	}

	// Hàm đổ dữ liệu từ database vào JTable cho DichVu
	private void loadDataToTableDichVu() {
		DichVu_DAO dichVuDAO = new DichVu_DAO();
		List<DichVu> dsDichVu = dichVuDAO.getAllDichVu();

		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {}, // Bắt đầu với dữ liệu rỗng
				new String[] { "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá", "Đơn vị tính" });
		jTable1.setModel(tableModel);

		tableModel.setRowCount(0);

		// Duyệt qua danh sách dịch vụ
		for (DichVu dv : dsDichVu) {
		    // Định dạng đơn giá
		    DecimalFormat df = new DecimalFormat("#,###,###");
		    String formattedDonGia = df.format(dv.getDonGia());

		    // Thêm dữ liệu vào hàng trong bảng
		    Object[] row = {
		        dv.getMaDichVu(),
		        dv.getTenDichVu(),
		        dv.getSoLuong(),
		        formattedDonGia,  // Sử dụng giá trị đã định dạng
		        dv.getDonViTinh()
		    };
		    tableModel.addRow(row);
		}

		// Inside your constructor or initComponents method
		btnXoa.setEnabled(false); // Initially disable the "Xóa" label
		btnCapNhat.setEnabled(false); // Initially disable the "Cập nhật" label
		btnXoa.setEnabled(false);
		btnXoa.setBackground(Color.GRAY);
		btnXoa.setForeground(Color.white);
		btnCapNhat.setEnabled(false);
		btnCapNhat.setBackground(Color.GRAY);
		btnCapNhat.setForeground(Color.white);
		// Add ListSelectionListener to enable labels on row selection
		jTable1.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				boolean isRowSelected = jTable1.getSelectedRow() != -1; // Check if a row is selected
				btnXoa.setEnabled(isRowSelected); // Enable or disable "Xóa"
				btnCapNhat.setEnabled(isRowSelected); // Enable or disable "Cập nhật"
				btnXoa.setEnabled(isRowSelected); // Enable or disable "Xóa"
				btnXoa.setBackground(Color.red);
				btnCapNhat.setEnabled(isRowSelected); // Enable or disable "Cập nhật"
				btnCapNhat.setBackground(Color.orange);
			}
		});

		// Add mouse click event for "Xóa" label
		lbXoa.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (jTable1.getSelectedRow() != -1) { // Check if a row is selected
					deleteService(); // Call delete service method
				}
			}
		});
		btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (jTable1.getSelectedRow() != -1) { // Check if a row is selected
					deleteService(); // Call delete service method
				}
			}
		});

		// Add mouse click event for "Cập nhật" label
		lbCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (jTable1.getSelectedRow() != -1) { // Check if a row is selected
					openUpdateServiceDialog(); // Call update service dialog method
				}
			}
		});
		btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (jTable1.getSelectedRow() != -1) { // Check if a row is selected
					openUpdateServiceDialog(); // Call update service dialog method
				}
			}
		});

		// Inside the DichVu_GUI class, within the initComponents() method or after
		// initializing components:

		btnThemDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				openAddServiceDialog(evt);
			}
		});
		// Xử lý sự kiện khi nhấp vào JLabel "Xóa"
		btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				deleteService();
			}
		});

		// Xử lý sự kiện khi nhấp vào JLabel "Cập nhật"
		btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				openUpdateServiceDialog();
			}
		});

	}

	private void deleteService() {
		int selectedRow = jTable1.getSelectedRow();
		if (selectedRow != -1) {
			int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dịch vụ này?",
					"Xác nhận xóa", javax.swing.JOptionPane.YES_NO_OPTION);

			if (confirm == javax.swing.JOptionPane.YES_OPTION) {
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				String maDichVu = (String) model.getValueAt(selectedRow, 0); // Assuming first column is 'maDichVu'

				try (Connection conn = ConnectDB.getConnection()) {
					String sql = "DELETE FROM DichVu WHERE maDichVu = ?";
					try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
						pstmt.setString(1, maDichVu);
						pstmt.executeUpdate();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					javax.swing.JOptionPane.showMessageDialog(this, "Lỗi khi xóa dịch vụ: " + e.getMessage(), "Lỗi",
							javax.swing.JOptionPane.ERROR_MESSAGE);
				}

				model.removeRow(selectedRow); // Remove from JTable
			}
		} else {
			javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn dịch vụ ở danh sách bên dưới để xóa.",
					"Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void openUpdateServiceDialog() {
	    int selectedRow = jTable1.getSelectedRow();
	    if (selectedRow == -1) {
	        javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn dịch vụ ở danh sách bên dưới để cập nhật.",
	                "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    // Create update dialog
	    JDialog updateServiceDialog = new JDialog();
	    updateServiceDialog.setTitle("Cập Nhật Dịch Vụ");
	    updateServiceDialog.setSize(700, 400);
	    updateServiceDialog.setLocationRelativeTo(this);
	    updateServiceDialog.setModal(true);

	    // Retrieve current data from the selected row
	    String maDichVu = (String) jTable1.getValueAt(selectedRow, 0);
	    String tenDichVu = (String) jTable1.getValueAt(selectedRow, 1);
	    int soLuong = (Integer) jTable1.getValueAt(selectedRow, 2);
	    double donGia = (Double) jTable1.getValueAt(selectedRow, 3);
	    String donViTinh = (String) jTable1.getValueAt(selectedRow, 4);

	    // Create UI components
	    JLabel titleLabel = new JLabel("Cập Nhật Dịch Vụ");
	    titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22)); // Tăng kích cỡ chữ
	    titleLabel.setForeground(Color.BLACK);

	    JLabel lblMaDichVu = new JLabel("Mã Dịch Vụ:");
	    JTextField txtMaDichVu = new JTextField(maDichVu, 20);
	    txtMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    txtMaDichVu.setEnabled(false); // Make this field non-editable

	    JLabel lblTenDichVu = new JLabel("Tên dịch vụ:");
	    JTextField txtTenDichVu = new JTextField(tenDichVu, 20);
	    txtTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // Tăng kích cỡ chữ cho JTextField

	    JLabel lblSoLuong = new JLabel("Số lượng:");
	    JTextField txtSoLuong = new JTextField(String.valueOf(soLuong), 20);
	    txtSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // Tăng kích cỡ chữ cho JTextField

	    JLabel lblDonGia = new JLabel("Đơn giá:");
	    JTextField txtDonGia = new JTextField(String.valueOf(donGia), 20);
	    txtDonGia.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // Tăng kích cỡ chữ cho JTextField

	    JLabel lblDonViTinh = new JLabel("Đơn vị tính:");
	    JTextField txtDonViTinh = new JTextField(donViTinh, 20);
	    txtDonViTinh.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // Tăng kích cỡ chữ cho JTextField

	    // Save and Cancel buttons
	    JButton btnSave = new JButton("Lưu");
	    JButton btnCancel = new JButton("Hủy");

	    Dimension buttonSize = new Dimension(120, 45); // Tăng kích thước nút
	    btnSave.setPreferredSize(buttonSize);
	    btnCancel.setPreferredSize(buttonSize);

	    btnSave.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Tăng kích cỡ chữ cho nút
	    btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Tăng kích cỡ chữ cho nút
	    btnSave.setBackground(Color.decode("#199FFE"));
	    btnSave.setForeground(Color.WHITE);
	    btnCancel.setBackground(Color.decode("#D3D3D3"));

	    // Save button action listener
	    btnSave.addActionListener(e -> {
	        try {
	            // Update the table model
	            jTable1.setValueAt(txtTenDichVu.getText(), selectedRow, 1);
	            jTable1.setValueAt(Integer.parseInt(txtSoLuong.getText()), selectedRow, 2);
	            jTable1.setValueAt(Double.parseDouble(txtDonGia.getText()), selectedRow, 3);
	            jTable1.setValueAt(txtDonViTinh.getText(), selectedRow, 4);

	            // Update in the database
	            try (Connection conn = ConnectDB.getConnection()) {
	                String sql = "UPDATE DichVu SET tenDichVu = ?, soLuong = ?, donGia = ?, donViTinh = ? WHERE maDichVu = ?";
	                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	                    pstmt.setString(1, txtTenDichVu.getText());
	                    pstmt.setInt(2, Integer.parseInt(txtSoLuong.getText()));
	                    pstmt.setDouble(3, Double.parseDouble(txtDonGia.getText()));
	                    pstmt.setString(4, txtDonViTinh.getText());
	                    pstmt.setString(5, maDichVu);
	                    pstmt.executeUpdate();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	                javax.swing.JOptionPane.showMessageDialog(updateServiceDialog,
	                        "Lỗi khi cập nhật dịch vụ: " + ex.getMessage(), "Lỗi",
	                        javax.swing.JOptionPane.ERROR_MESSAGE);
	            }

	            updateServiceDialog.dispose(); // Close dialog
	        } catch (NumberFormatException ex) {
	            javax.swing.JOptionPane.showMessageDialog(updateServiceDialog, "Số lượng và đơn giá phải là số hợp lệ.",
	                    "Lỗi định dạng", javax.swing.JOptionPane.ERROR_MESSAGE);
	        }
	    });

	    // Cancel button action listener
	    btnCancel.addActionListener(e -> updateServiceDialog.dispose());

	    // Form panel setup
	    JPanel formPanel = new JPanel();
	    Font labelFont = new Font("Segoe UI", Font.BOLD, 20); // Tăng kích cỡ chữ cho nhãn
	    Dimension textFieldSize = new Dimension(250, 45); // Kích thước JTextField

	    formPanel.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(5, 5, 5, 5);
	    gbc.anchor = GridBagConstraints.WEST;

	    // Add components to the form panel
	    gbc.gridx = 0; gbc.gridy = 0; formPanel.add(lblMaDichVu, gbc);
	    gbc.gridx = 1; formPanel.add(txtMaDichVu, gbc);

	    gbc.gridx = 0; gbc.gridy = 1; formPanel.add(lblTenDichVu, gbc);
	    gbc.gridx = 1; formPanel.add(txtTenDichVu, gbc);

	    gbc.gridx = 0; gbc.gridy = 2; formPanel.add(lblSoLuong, gbc);
	    gbc.gridx = 1; formPanel.add(txtSoLuong, gbc);

	    gbc.gridx = 0; gbc.gridy = 3; formPanel.add(lblDonGia, gbc);
	    gbc.gridx = 1; formPanel.add(txtDonGia, gbc);

	    gbc.gridx = 0; gbc.gridy = 4; formPanel.add(lblDonViTinh, gbc);
	    gbc.gridx = 1; formPanel.add(txtDonViTinh, gbc);

	    // Button panel
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    buttonPanel.add(btnCancel);
	    buttonPanel.add(btnSave);

	    // Main panel setup
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BorderLayout(10, 10));
	    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    mainPanel.add(formPanel, BorderLayout.CENTER);
	    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

	    updateServiceDialog.add(mainPanel);
	    updateServiceDialog.setVisible(true);
	}


	private javax.swing.JPanel createFormPanel(javax.swing.JTextField txtMaDichVu, javax.swing.JTextField txtTenDichVu,
			javax.swing.JTextField txtSoLuong, javax.swing.JTextField txtDonGia, javax.swing.JTextField txtDonViTinh) {
		javax.swing.JPanel formPanel = new javax.swing.JPanel();
		formPanel.setLayout(new java.awt.GridBagLayout());
		java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
		gbc.insets = new java.awt.Insets(5, 5, 5, 5);
		gbc.anchor = java.awt.GridBagConstraints.WEST;

		formPanel.add(new javax.swing.JLabel("Mã Dịch Vụ:"), gbc);
		gbc.gridx = 1;
		formPanel.add(txtMaDichVu, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		formPanel.add(new javax.swing.JLabel("Tên Dịch Vụ:"), gbc);
		gbc.gridx = 1;
		formPanel.add(txtTenDichVu, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		formPanel.add(new javax.swing.JLabel("Số Lượng:"), gbc);
		gbc.gridx = 1;
		formPanel.add(txtSoLuong, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		formPanel.add(new javax.swing.JLabel("Đơn Giá:"), gbc);
		gbc.gridx = 1;
		formPanel.add(txtDonGia, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		formPanel.add(new javax.swing.JLabel("Đơn Vị Tính:"), gbc);
		gbc.gridx = 1;
		formPanel.add(txtDonViTinh, gbc);

		return formPanel;
	}

	private javax.swing.JPanel createButtonPanel(javax.swing.JButton btnCancel, javax.swing.JButton btnSave) {
		javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
		buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
		buttonPanel.add(btnCancel);
		buttonPanel.add(btnSave);
		return buttonPanel;
	}

	// Define the method to open the add service dialog
//Static variable to keep track of the next service code
	private void openAddServiceDialog(java.awt.event.MouseEvent evt) {
		// Create a new dialog for adding services
		JDialog addServiceDialog = new JDialog();
		addServiceDialog.setTitle("Thêm mới dịch vụ");
		addServiceDialog.setSize(700, 400);
		addServiceDialog.setLocationRelativeTo(this);
		addServiceDialog.setModal(true);

		// Automatically generate Ma Dịch Vụ from database
		String generatedMaDichVu = generateServiceCode();

		// Create and set up UI components
		JLabel titleLabel = new JLabel("Thêm dịch vụ");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleLabel.setForeground(Color.BLACK);

		JLabel lblMaDichVu = new JLabel("Mã Dịch Vụ:");
		JTextField txtMaDichVu = new JTextField(generatedMaDichVu, 20);
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtMaDichVu.setEnabled(false); // Make this field non-editable

		JLabel lblTenDichVu = new JLabel("Tên dịch vụ:");
		lblTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JTextField txtTenDichVu = new JTextField(20);

		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JTextField txtSoLuong = new JTextField(20);

		JLabel lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JTextField txtDonGia = new JTextField(20);

		JLabel lblDonViTinh = new JLabel("Đơn vị tính:");
		lblDonViTinh.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JTextField txtDonViTinh = new JTextField(20);

		// Save and Cancel buttons
		JButton btnSave = new JButton("Lưu");
		JButton btnCancel = new JButton("Hủy");

		Dimension buttonSize = new Dimension(100, 40);
		btnSave.setPreferredSize(buttonSize);
		btnCancel.setPreferredSize(buttonSize);

		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSave.setBackground(Color.decode("#199FFE"));
		btnSave.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.decode("#D3D3D3"));

		// Save button action listener
		btnSave.addActionListener(e -> {
			// Retrieve and validate input
			String maDichVu = txtMaDichVu.getText().trim();
			String tenDichVu = txtTenDichVu.getText().trim();
			String soLuongStr = txtSoLuong.getText().trim();
			String donGiaStr = txtDonGia.getText().trim();
			String donViTinh = txtDonViTinh.getText().trim();

			if (isInputValid(tenDichVu, soLuongStr, donGiaStr, donViTinh)) {
				try {
					int soLuong = Integer.parseInt(soLuongStr);
					double donGia = Double.parseDouble(donGiaStr);

					// Add new row to table model
					DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
					tableModel.addRow(new Object[] { maDichVu, tenDichVu, soLuong, donGia, donViTinh });

					// Insert into the database
					insertServiceIntoDatabase(maDichVu, tenDichVu, soLuong, donGia, donViTinh);

					addServiceDialog.dispose(); // Close the dialog after saving
				} catch (NumberFormatException ex) {
					showErrorMessage(addServiceDialog, "Số lượng và đơn giá phải là số hợp lệ.");
				}
			} else {
				showWarningMessage(addServiceDialog, "Vui lòng điền đầy đủ thông tin.");
			}
		});

		// Cancel button action listener
		btnCancel.addActionListener(e -> addServiceDialog.dispose());

		// Panel setup
		// Create a JPanel for the form
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridBagLayout());

		// Define fonts and dimensions
		Font labelFont = new Font("Segoe UI", Font.BOLD, 20);
		Font textFieldFont = new Font("Segoe UI", Font.PLAIN, 20);
		Dimension textFieldSize = new Dimension(250, 45);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;

		// Set label font
		lblMaDichVu.setFont(labelFont);
		lblTenDichVu.setFont(labelFont);
		lblSoLuong.setFont(labelFont);
		lblDonGia.setFont(labelFont);
		lblDonViTinh.setFont(labelFont);

		// Add components to the form panel
		gbc.gridx = 0;
		gbc.gridy = 0;
		formPanel.add(lblMaDichVu, gbc);
		gbc.gridx = 1;
		formPanel.add(txtMaDichVu, gbc);
		txtMaDichVu.setPreferredSize(textFieldSize);
		txtMaDichVu.setFont(textFieldFont);
		txtMaDichVu.setEnabled(false); // Make this field non-editable

		gbc.gridx = 0;
		gbc.gridy = 1;
		formPanel.add(lblTenDichVu, gbc);
		gbc.gridx = 1;
		formPanel.add(txtTenDichVu, gbc);
		txtTenDichVu.setPreferredSize(textFieldSize);
		txtTenDichVu.setFont(textFieldFont);

		gbc.gridx = 0;
		gbc.gridy = 2;
		formPanel.add(lblSoLuong, gbc);
		gbc.gridx = 1;
		formPanel.add(txtSoLuong, gbc);
		txtSoLuong.setPreferredSize(textFieldSize);
		txtSoLuong.setFont(textFieldFont);

		gbc.gridx = 0;
		gbc.gridy = 3;
		formPanel.add(lblDonGia, gbc);
		gbc.gridx = 1;
		formPanel.add(txtDonGia, gbc);
		txtDonGia.setPreferredSize(textFieldSize);
		txtDonGia.setFont(textFieldFont);

		gbc.gridx = 0;
		gbc.gridy = 4;
		formPanel.add(lblDonViTinh, gbc);
		gbc.gridx = 1;
		formPanel.add(txtDonViTinh, gbc);
		txtDonViTinh.setPreferredSize(textFieldSize);
		txtDonViTinh.setFont(textFieldFont);

		// Button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(btnCancel);
		buttonPanel.add(btnSave);

		// Main panel setup
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.add(formPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		addServiceDialog.add(mainPanel);
		addServiceDialog.setVisible(true);
	}

	// Method to validate input fields
	private boolean isInputValid(String tenDichVu, String soLuongStr, String donGiaStr, String donViTinh) {
		return !tenDichVu.isEmpty() && !soLuongStr.isEmpty() && !donGiaStr.isEmpty() && !donViTinh.isEmpty();
	}

	// Method to insert service into the database
	private void insertServiceIntoDatabase(String maDichVu, String tenDichVu, int soLuong, double donGia,
			String donViTinh) {
		try (Connection conn = ConnectDB.getConnection()) {
			String sql = "INSERT INTO DichVu (maDichVu, tenDichVu, soLuong, donGia, donViTinh) VALUES (?, ?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, maDichVu);
				pstmt.setString(2, tenDichVu);
				pstmt.setInt(3, soLuong);
				pstmt.setDouble(4, donGia);
				pstmt.setString(5, donViTinh);
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			showErrorMessage(null, "Lỗi khi thêm dịch vụ: " + ex.getMessage());
		}
	}

	// Utility method to show error messages
	private void showErrorMessage(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
	}

	// Utility method to show warning messages
	private void showWarningMessage(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
	}

	// Method to generate the next service code
	private String generateServiceCode() {
		String nextCode = "DV001"; // Default code
		try (Connection conn = ConnectDB.getConnection()) {
			String sql = "SELECT MAX(maDichVu) FROM DichVu";
			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					String lastCode = rs.getString(1);
					if (lastCode != null) {
						int lastNumber = Integer.parseInt(lastCode.substring(2)); // Extract number part
						nextCode = "DV" + String.format("%03d", lastNumber + 1); // Increment and format
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			showErrorMessage(null, "Lỗi khi truy xuất mã dịch vụ: " + ex.getMessage());
		}
		return nextCode;
	}

	// DocumentFilter to allow only numbers
	private static class NumericDocumentFilter extends DocumentFilter {
		@Override
		public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
				throws BadLocationException {
			if (string != null && string.matches("\\d*")) { // Check if input is numeric
				super.insertString(fb, offset, string, attr);
			}
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
				throws BadLocationException {
			if (text != null && text.matches("\\d*")) { // Check if input is numeric
				super.replace(fb, offset, length, text, attrs);
			}
		}

		@Override
		public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
			super.remove(fb, offset, length);
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel btnCapNhat;
	private javax.swing.JPanel btnThemDichVu;
	private javax.swing.JPanel btnXoa;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTable jTable1;
	private javax.swing.JLabel lbCapNhat;
	private javax.swing.JLabel lbThemDichVu;
	private javax.swing.JLabel lbXoa;
	// End of variables declaration//GEN-END:variables
}
