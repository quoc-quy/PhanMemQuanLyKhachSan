
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import Components.ExportFile;
import DAO.HoaDon_DAO;
import ENTITY.HoaDon;

/**
 *
 * @author Admin
 */
public class HoaDon_GUI extends javax.swing.JPanel {
	private DefaultTableModel originalModel;

	/**
	 * Creates new form DichVu_GUI
	 */
	public HoaDon_GUI() {
		initComponents();
		loadDataToTable();
		updateHeader();

		// Lưu model ban đầu ngay khi khởi tạo
		originalModel = (DefaultTableModel) tbHoaDon.getModel();

//        Chức năng tìm kiếm
		btnTimKiem.addActionListener(e -> filterTableData());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
		jSeparator1 = new javax.swing.JSeparator();
		titleHoaDon = new javax.swing.JLabel();
		RoundedPanel panelThemHoaDon = new RoundedPanel(20);
		jLabel8 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tbHoaDon = new javax.swing.JTable();
		RoundedPanel btnXuatFile = new RoundedPanel(20);
		jLabel1 = new javax.swing.JLabel();
		btnTimKiem = new javax.swing.JButton();
		txtTimKiem = new javax.swing.JTextField();
		setLayout(new java.awt.CardLayout());

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		titleHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		titleHoaDon.setText("Hóa đơn");

		panelThemHoaDon.setBackground(new java.awt.Color(25, 159, 254));
		panelThemHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel8.setForeground(new java.awt.Color(255, 255, 255));
		jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/add.png"))); // NOI18N
		jLabel8.setText("Tạo hóa đơn");
		jLabel8.setIconTextGap(10);

		javax.swing.GroupLayout panelThemHoaDonLayout = new javax.swing.GroupLayout(panelThemHoaDon);
		panelThemHoaDon.setLayout(panelThemHoaDonLayout);
		panelThemHoaDonLayout.setHorizontalGroup(panelThemHoaDonLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelThemHoaDonLayout.createSequentialGroup().addContainerGap().addComponent(jLabel8,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		panelThemHoaDonLayout.setVerticalGroup(panelThemHoaDonLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelThemHoaDonLayout.createSequentialGroup().addContainerGap().addComponent(jLabel8,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

		tbHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ "", "", "", null, null, null, null, null }, { "", null, null, null, null, null, null, null },
				{ "", null, null, null, null, null, null, null }, { "", null, null, null, null, null, null, null },
				{ "", null, null, null, null, null, null, null }, { "", null, null, null, null, null, null, null } },
				new String[] { "Mã hóa đơn", "Khách hàng", "Phòng", "Ngày nhận", "Ngày trả", "Khuyến mãi",
						"Tổng thanh toán" }) {
			Class[] types = new Class[] { java.lang.Object.class, java.lang.String.class, java.lang.String.class,
					java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class,
					java.lang.Double.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa dữ liệu trong bảng
			}
		});
		tbHoaDon.setRowHeight(40);
		jScrollPane1.setViewportView(tbHoaDon);

		btnXuatFile.setBackground(new java.awt.Color(129, 251, 184));
		btnXuatFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
		btnXuatFileLayout
				.setHorizontalGroup(btnXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(btnXuatFileLayout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
								.addContainerGap(19, Short.MAX_VALUE)));
		btnXuatFileLayout
				.setVerticalGroup(btnXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(btnXuatFileLayout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

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

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(titleHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
						.addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 195,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnTimKiem)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelThemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(23, 23, 23))
				.addComponent(jSeparator1).addComponent(jScrollPane1));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(12, 12, 12)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(titleHoaDon)
								.addComponent(panelThemHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnXuatFile, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtTimKiem))
						.addGap(7, 7, 7)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)));

		add(jPanel2, "card2");
	}

//   Sự kiện xuất file
	private void btnXuatFileMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnXuatFileMouseClicked
		ExportFile exporter = new ExportFile();
		exporter.exportToExcel(tbHoaDon); // Xuất dữ liệu từ bảng tbHoaDon
	}

	private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {
		txtTimKiem.setText("");
		txtTimKiem.setForeground(Color.BLACK);
	}

	private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {
		txtTimKiem.setForeground(Color.decode("#909090"));
	}

	private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void updateHeader() {
		JTableHeader header = tbHoaDon.getTableHeader();
		header.setFont(new Font("Times new Romans", Font.BOLD, 16));
	}

	private void loadDataToTable() {
		// Lấy danh sách hóa đơn từ HoaDon_DAO
		HoaDon_DAO hoaDonDAO = new HoaDon_DAO();
		List<HoaDon> dsHoaDon = hoaDonDAO.getAllHoaDon(); // Giả sử bạn đã có phương thức này trong DAO để lấy danh sách
															// HoaDon

		// Tạo TableModel với các cột cần hiển thị
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {}, // Bắt đầu với dữ liệu rỗng
				new String[] { "Mã Hóa Đơn", "Mã Khuyến Mãi", "Mã Nhân Viên", "Mã Khách Hàng", "Ngày Lập",
						"Ngày Nhận Phòng", "Ngày Trả Phòng", "Tiền Trả Khách", "Tổng Tiền", "Thuế" });

		// Set TableModel cho JTable
		tbHoaDon.setModel(tableModel);
		tableModel.setRowCount(0); // Xóa các hàng cũ trước khi thêm dữ liệu mới

		// Định dạng ngày theo dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// Duyệt qua danh sách HoaDon và thêm dữ liệu vào bảng
		for (HoaDon hoaDon : dsHoaDon) {
			// Lấy dữ liệu từ các đối tượng HoaDon và các đối tượng liên quan
			String maHoaDon = hoaDon.getMaHoaDon();
			String maKhuyenMai = hoaDon.getKhuyenMai() != null ? hoaDon.getKhuyenMai().getMakhuyenMai() : "";
			String maNhanVien = hoaDon.getNhanVienLap().getMaNhanVien();
			String maKhachHang = hoaDon.getKhachHang().getMaKhachHang();
			String ngayLap = dateFormat.format(hoaDon.getNgayLap());
			String ngayNhanPhong = dateFormat.format(hoaDon.getNgayNhanPhong());
			String ngayTraPhong = dateFormat.format(hoaDon.getNgayTraPhong());
			double tienTraKhach = hoaDon.getTienTraKhach();
			double tongTien = hoaDon.getTongTien();
			int thue = hoaDon.getThue();

			// Thêm hàng vào bảng
			tableModel.addRow(new Object[] { maHoaDon, // Mã hóa đơn
					maKhuyenMai, // Mã khuyến mãi
					maNhanVien, // Mã nhân viên
					maKhachHang, // Mã khách hàng
					ngayLap, // Ngày lập
					ngayNhanPhong, // Ngày nhận phòng
					ngayTraPhong, // Ngày trả phòng
					tienTraKhach, // Tiền trả khách
					tongTien, // Tổng tiền
					thue // Thuế
			});
		}

	}

	// Phương thức lọc dữ liệu
	private void filterTableData() {
		String keyword = txtTimKiem.getText().trim().toLowerCase(); // Lấy từ khóa tìm kiếm

		// Kiểm tra nếu từ khóa rỗng, khôi phục dữ liệu ban đầu
		if (keyword.isEmpty()) {
			tbHoaDon.setModel(originalModel); // Khôi phục model ban đầu
			return;
		}

		// Tạo model mới để chứa dữ liệu lọc
		DefaultTableModel filteredModel = new DefaultTableModel(new String[] { "Mã hóa đơn", "Khách hàng", "Phòng",
				"Ngày nhận", "Ngày trả", "Khuyến mãi", "Tổng thanh toán" }, 0);

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
		if (found) {
			tbHoaDon.setModel(filteredModel); // Cập nhật model đã lọc
		} else {
			JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu phù hợp!");
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnTimKiem;
	private javax.swing.JPanel btnXuatFile;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JPanel panelThemHoaDon;
	private javax.swing.JTable tbHoaDon;
	private javax.swing.JLabel titleHoaDon;
	private javax.swing.JTextField txtTimKiem;
	// End of variables declaration//GEN-END:variables
}
