/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import javax.swing.text.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
		lbXoa = new javax.swing.JLabel();
		btnCapNhat = new javax.swing.JPanel();
		lbCapNhat = new javax.swing.JLabel();
		btnThemDichVu = new javax.swing.JPanel();
		lbThemDichVu = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setLayout(new java.awt.CardLayout());

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabel5.setText("Dịch vụ");

		btnXoa.setBackground(new java.awt.Color(255, 51, 51));
		btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		lbXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		lbXoa.setForeground(new java.awt.Color(255, 255, 255));
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

		btnCapNhat.setBackground(new java.awt.Color(245, 109, 40));
		btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		lbCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		lbCapNhat.setForeground(new java.awt.Color(255, 255, 255));
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

		for (DichVu dv : dsDichVu) {
			Object[] row = { dv.getMaDichvu(), dv.getTenDichVu(), dv.getSoLuong(), dv.getDonGia(), dv.getDonViTinh() };
			tableModel.addRow(row);
		}

		// Inside your constructor or initComponents method
		lbXoa.setEnabled(false); // Initially disable the "Xóa" label
		lbCapNhat.setEnabled(false); // Initially disable the "Cập nhật" label
		btnXoa.setEnabled(false);
		btnCapNhat.setEnabled(false);

		// Add ListSelectionListener to enable labels on row selection
		jTable1.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				boolean isRowSelected = jTable1.getSelectedRow() != -1; // Check if a row is selected
				lbXoa.setEnabled(isRowSelected); // Enable or disable "Xóa"
				lbCapNhat.setEnabled(isRowSelected); // Enable or disable "Cập nhật"
				btnXoa.setEnabled(isRowSelected); // Enable or disable "Xóa"
				btnCapNhat.setEnabled(isRowSelected); // Enable or disable "Cập nhật"
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

		// Tạo hộp thoại cập nhật dịch vụ
		JDialog updateServiceDialog = new JDialog();
		updateServiceDialog.setTitle("Cập Nhật Dịch Vụ");
		updateServiceDialog.setSize(450, 350);
		updateServiceDialog.setLocationRelativeTo(this);
		updateServiceDialog.setModal(true);

		// Lấy dữ liệu hiện tại từ dòng được chọn
		String maDichVu = (String) jTable1.getValueAt(selectedRow, 0);
		String tenDichVu = (String) jTable1.getValueAt(selectedRow, 1);
		int soLuong = (Integer) jTable1.getValueAt(selectedRow, 2);
		double donGia = (Double) jTable1.getValueAt(selectedRow, 3);
		String donViTinh = (String) jTable1.getValueAt(selectedRow, 4);

		// Tạo các thành phần UI cho hộp thoại
		javax.swing.JTextField txtMaDichVu = new javax.swing.JTextField(maDichVu);
		javax.swing.JTextField txtTenDichVu = new javax.swing.JTextField(tenDichVu);
		javax.swing.JTextField txtSoLuong = new javax.swing.JTextField(String.valueOf(soLuong));
		javax.swing.JTextField txtDonGia = new javax.swing.JTextField(String.valueOf(donGia));
		javax.swing.JTextField txtDonViTinh = new javax.swing.JTextField(donViTinh);

		javax.swing.JButton btnSave = new javax.swing.JButton("Lưu");
		javax.swing.JButton btnCancel = new javax.swing.JButton("Hủy");

		// Thêm sự kiện cho nút Lưu
		btnSave.addActionListener(e -> {
			// Biểu thức chính quy cho các trường
			String maDichVuRegex = "^[A-Za-z0-9]+$"; // ví dụ: chỉ chứa chữ và số
			String tenDichVuRegex = "^[\\p{L} ]{3,50}$"; // ví dụ: chữ cái và khoảng trắng, từ 3 đến 50 ký tự
			String soLuongRegex = "^[1-9][0-9]*$"; // số nguyên dương
			String donGiaRegex = "^\\d+(\\.\\d{1,2})?$"; // số thực dương với tối đa 2 chữ số sau dấu thập phân
			String donViTinhRegex = "^[\\p{L} ]+$"; // chỉ chứa chữ cái và khoảng trắng

			// Kiểm tra dữ liệu đầu vào
			if (!txtMaDichVu.getText().matches(maDichVuRegex)) {
				javax.swing.JOptionPane.showMessageDialog(updateServiceDialog, "Mã dịch vụ không hợp lệ.");
				return;
			}
			if (!txtTenDichVu.getText().matches(tenDichVuRegex)) {
				javax.swing.JOptionPane.showMessageDialog(updateServiceDialog, "Tên dịch vụ không hợp lệ.");
				return;
			}
			if (!txtSoLuong.getText().matches(soLuongRegex)) {
				javax.swing.JOptionPane.showMessageDialog(updateServiceDialog, "Số lượng không hợp lệ.");
				return;
			}
			if (!txtDonGia.getText().matches(donGiaRegex)) {
				javax.swing.JOptionPane.showMessageDialog(updateServiceDialog, "Đơn giá không hợp lệ.");
				return;
			}
			if (!txtDonViTinh.getText().matches(donViTinhRegex)) {
				javax.swing.JOptionPane.showMessageDialog(updateServiceDialog, "Đơn vị tính không hợp lệ.");
				return;
			}

			// Nếu tất cả hợp lệ, cập nhật dữ liệu
			jTable1.setValueAt(txtMaDichVu.getText(), selectedRow, 0);
			jTable1.setValueAt(txtTenDichVu.getText(), selectedRow, 1);
			jTable1.setValueAt(Integer.parseInt(txtSoLuong.getText()), selectedRow, 2);
			jTable1.setValueAt(Double.parseDouble(txtDonGia.getText()), selectedRow, 3);
			jTable1.setValueAt(txtDonViTinh.getText(), selectedRow, 4);

			updateServiceDialog.dispose();
		});
		// Nút lưu cập nhật dữ liệu vào JTable
		btnSave.addActionListener(e -> {
			try {
				jTable1.setValueAt(txtMaDichVu.getText(), selectedRow, 0);
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
						pstmt.setString(5, txtMaDichVu.getText());
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

		// Nút hủy để đóng hộp thoại
		btnCancel.addActionListener(e -> updateServiceDialog.dispose());

		// Thiết lập bố cục cho hộp thoại
		javax.swing.JPanel formPanel = createFormPanel(txtMaDichVu, txtTenDichVu, txtSoLuong, txtDonGia, txtDonViTinh);
		javax.swing.JPanel buttonPanel = createButtonPanel(btnCancel, btnSave);

		javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.BorderLayout(10, 10));
		mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.add(formPanel, java.awt.BorderLayout.CENTER);
		mainPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

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
		addServiceDialog.setSize(450, 400);
		addServiceDialog.setLocationRelativeTo(this);
		addServiceDialog.setModal(true);

		// Automatically generate Ma Dịch Vụ from database
		String generatedMaDichVu = generateServiceCode();

		JLabel titleLabel = new JLabel("Thêm nhân viên");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleLabel.setForeground(Color.BLACK);

		javax.swing.JLabel lblMaDichVu = new javax.swing.JLabel("Mã Dịch Vụ:");
		javax.swing.JTextField txtMaDichVu = new javax.swing.JTextField(generatedMaDichVu, 20);
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtMaDichVu.setEnabled(false);
		txtMaDichVu.setEditable(false); // Make this field non-editable

		// Other UI components (same as in your code)
		JLabel lblTenDichVu = new JLabel("Tên dịch vụ:");
		lblTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JTextField txtTenDichVu = new JTextField(20);
		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JTextField txtSoLuong = new JTextField(20);
		((AbstractDocument) txtSoLuong.getDocument()).setDocumentFilter(new NumericDocumentFilter()); // Apply filter

		JLabel lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JTextField txtDonGia = new JTextField(20);
		((AbstractDocument) txtDonGia.getDocument()).setDocumentFilter(new NumericDocumentFilter()); // Apply filter

		JLabel lblDonViTinh = new JLabel("Đơn vị tính:");
		lblDonViTinh.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		JTextField txtDonViTinh = new JTextField(20);

		javax.swing.JButton btnSave = new javax.swing.JButton("Lưu");
		javax.swing.JButton btnCancel = new javax.swing.JButton("Hủy");
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSave.setBackground(Color.decode("#199FFE"));
		btnSave.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.decode("#D3D3D3"));

		// Save button action listener to add data to JTable
		btnSave.addActionListener(e -> {
			// Retrieve and validate input
			String maDichVu = txtMaDichVu.getText().trim();
			String tenDichVu = txtTenDichVu.getText().trim();
			String soLuongStr = txtSoLuong.getText().trim();
			String donGiaStr = txtDonGia.getText().trim();
			String donViTinh = txtDonViTinh.getText().trim();

			if (tenDichVu.isEmpty() || soLuongStr.isEmpty() || donGiaStr.isEmpty() || donViTinh.isEmpty()) {
				javax.swing.JOptionPane.showMessageDialog(addServiceDialog, "Vui lòng điền đầy đủ thông tin.",
						"Thông báo", javax.swing.JOptionPane.WARNING_MESSAGE);
				return;
			}

			try {
				int soLuong = Integer.parseInt(soLuongStr);
				double donGia = Double.parseDouble(donGiaStr);

				// Add new row to table model
				DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
				tableModel.addRow(new Object[] { maDichVu, tenDichVu, soLuong, donGia, donViTinh });

				// Insert into the database
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
					javax.swing.JOptionPane.showMessageDialog(addServiceDialog,
							"Lỗi khi thêm dịch vụ: " + ex.getMessage(), "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
				}

				addServiceDialog.dispose(); // Close the dialog after saving
			} catch (NumberFormatException ex) {
				javax.swing.JOptionPane.showMessageDialog(addServiceDialog, "Số lượng và đơn giá phải là số hợp lệ.",
						"Lỗi định dạng", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		});

		// Cancel button action listener to close the dialog
		btnCancel.addActionListener(e -> addServiceDialog.dispose());

		// Panel setup (same as in your code)
		javax.swing.JPanel formPanel = new javax.swing.JPanel();
		formPanel.setLayout(new java.awt.GridBagLayout());
		java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
		gbc.insets = new java.awt.Insets(5, 5, 5, 5);
		gbc.anchor = java.awt.GridBagConstraints.WEST;

		gbc.gridx = 0;
		gbc.gridy = 0;
		formPanel.add(lblMaDichVu, gbc);
		gbc.gridx = 1;
		formPanel.add(txtMaDichVu, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		formPanel.add(lblTenDichVu, gbc);
		gbc.gridx = 1;
		formPanel.add(txtTenDichVu, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		formPanel.add(lblSoLuong, gbc);
		gbc.gridx = 1;
		formPanel.add(txtSoLuong, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		formPanel.add(lblDonGia, gbc);
		gbc.gridx = 1;
		formPanel.add(txtDonGia, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		formPanel.add(lblDonViTinh, gbc);
		gbc.gridx = 1;
		formPanel.add(txtDonViTinh, gbc);

		// Button panel
		javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
		buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
		buttonPanel.add(btnCancel);
		buttonPanel.add(btnSave);

		// Main panel setup
		javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.BorderLayout(10, 10));
		mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.add(formPanel, java.awt.BorderLayout.CENTER);
		mainPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

		addServiceDialog.add(mainPanel);
		addServiceDialog.setVisible(true);
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
			javax.swing.JOptionPane.showMessageDialog(null, "Lỗi khi truy xuất mã dịch vụ: " + ex.getMessage(), "Lỗi",
					javax.swing.JOptionPane.ERROR_MESSAGE);
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
