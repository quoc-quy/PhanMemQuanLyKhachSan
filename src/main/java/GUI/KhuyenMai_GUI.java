/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import ConnectDB.ConnectDB;
import DAO.KhachHang_DAO;
import DAO.KhuyenMai_DAO;
import ENTITY.KhachHang;
import ENTITY.KhuyenMai;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 84837
 */
public class KhuyenMai_GUI extends javax.swing.JPanel {

    /**
     * Creates new form KhachHang_GUI
     */
    public KhuyenMai_GUI() {
        initComponents();
        updateHeader();
        loadDataToTable();
        
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
        tbKhuyenMai = new javax.swing.JTable();
        btnCapNhat = new javax.swing.JPanel();
        lblCapNhat = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThemKhuyenMai = new javax.swing.JLabel();
        

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        titleHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleHoaDon.setText("Danh sách khuyến mãi");

        tbKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khuyến mãi", "Mô tả", "Ngày bắt đầu", "Ngày kết thúc", "Chiết khấu (%)", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbKhuyenMai.setRowHeight(40);
        jScrollPane1.setViewportView(tbKhuyenMai);

        btnCapNhat.setBackground(new java.awt.Color(245, 109, 40));
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        

        lblCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        lblCapNhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/fixing.png"))); // NOI18N
        lblCapNhat.setText("Cập nhật");
       

        javax.swing.GroupLayout btnCapNhatLayout = new javax.swing.GroupLayout(btnCapNhat);
        btnCapNhat.setLayout(btnCapNhatLayout);
        btnCapNhatLayout.setHorizontalGroup(
            btnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        btnCapNhatLayout.setVerticalGroup(
            btnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCapNhatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCapNhat)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(25, 159, 254));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnThemKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThemKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/add.png"))); // NOI18N
        btnThemKhuyenMai.setText("Thêm khuyến mãi");
        

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemKhuyenMai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemKhuyenMai)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 703, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleHoaDon)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

   

    
    
     
    
    
    private void updateHeader(){
        JTableHeader header = tbKhuyenMai.getTableHeader();
         header.setFont(new Font("Times new Romans", Font.BOLD, 16)); 
    }
//    Hàm đổ dữ liệu từ database vào JTable
    private void loadDataToTable() {
    	KhuyenMai_DAO khuyenMaiDAO = new KhuyenMai_DAO();
        List<KhuyenMai> dsKhuyenMai = khuyenMaiDAO.getAllKhuyenMai();
        
      DefaultTableModel tableModel = new DefaultTableModel(
		    new Object[][] {},  // Bắt đầu với dữ liệu rỗng
		    new String[] { "Mã khuyến mãi", "Mô tả", "Ngày bắt đầu", "Ngày kết thúc", "Chiết khấu","Trạng thái" }
		);
  	tbKhuyenMai.setModel(tableModel);
        
        tableModel.setRowCount(0);

        // Định dạng ngày theo dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (KhuyenMai km : dsKhuyenMai) {
            Object[] row = {
                km.getMakhuyenMai(),
                km.getMoTa(),
                dateFormat.format(km.getNgayBatDau()),
                dateFormat.format(km.getNgayKetThuc()),
                String.valueOf(km.getChietKhau()),
                km.getTrangThai()
            };
            tableModel.addRow(row);
        }
        lblCapNhat.setEnabled(false);
        btnCapNhat.setEnabled(false);
        
        tbKhuyenMai.getSelectionModel().addListSelectionListener(e -> {
        	if(!e.getValueIsAdjusting()) {
        		boolean isRowSelected = tbKhuyenMai.getSelectedRow() != -1;
        				lblCapNhat.setEnabled(isRowSelected);
        				btnCapNhat.setEnabled(isRowSelected);
        	}
        });
        
        lblCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (tbKhuyenMai.getSelectedRow() != -1) { // Check if a row is selected
					updateKhuyenMai();
					; // Call update service dialog method
				}
			}
		});
        
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (tbKhuyenMai.getSelectedRow() != -1) { // Check if a row is selected
					updateKhuyenMai(); // Call update service dialog method
				}
			}
		});
        
        
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				 updateKhuyenMai(); // Call update service dialog method
				
			}
		});  
        
        
        
        btnThemKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				showAddKhuyenMaiDialog(evt); // Call update service dialog method
				
			}
		});       
}
    private void updateKhuyenMai() {
    	int selectedRow = tbKhuyenMai.getSelectedRow();
    	if(selectedRow == -1) {
    		JOptionPane.showMessageDialog(this, "Chọn khuyến mãi cần cập nhật");
    		return;
    	}
    	String khuyenMaiID= (String) tbKhuyenMai.getValueAt(selectedRow, 0);
    	KhuyenMai_DAO khuyenMaiDAO = new KhuyenMai_DAO();
    	KhuyenMai khuyenMai = khuyenMaiDAO.getBangMaKhuyenMai(khuyenMaiID);
    	
    	JDialog updateKhuyenMaiDialog = creatUpdateKhuyenMaiDialog(khuyenMai,khuyenMaiDAO);
    		updateKhuyenMaiDialog.setVisible(true);
    }  	
   private JDialog  creatUpdateKhuyenMaiDialog(KhuyenMai khuyenMai,KhuyenMai_DAO khuyenMaiDAO) {
	   JDialog  updateKhuyenMaiDialog = new JDialog();
	   updateKhuyenMaiDialog.setTitle("Cập nhật khuyến mãi");
	   updateKhuyenMaiDialog.setSize(500,400);
	   updateKhuyenMaiDialog.setLocationRelativeTo(this);
	   updateKhuyenMaiDialog.setModal(true);
	   
	   // UI	
	   javax.swing.JTextField txtMaKhuyenMai = createTextField(khuyenMai.getMakhuyenMai(), false);
	   javax.swing.JTextField txtMoTa = new javax.swing.JTextField(khuyenMai.getMoTa(), 20);
	   
	   JDateChooser dateChooserNgayBatDau = new JDateChooser();
	    dateChooserNgayBatDau.setDateFormatString("dd/MM/yyyy");
	    dateChooserNgayBatDau.setDate(khuyenMai.getNgayBatDau());

	    JDateChooser dateChooserNgayKetThuc = new JDateChooser();
	    dateChooserNgayKetThuc.setDateFormatString("dd/MM/yyyy");
	    dateChooserNgayKetThuc.setDate(khuyenMai.getNgayKetThuc());

	   javax.swing.JTextField txtTrangThai = new javax.swing.JTextField(khuyenMai.getTrangThai(), 20);
	   javax.swing.JTextField txtChietKhau = new javax.swing.JTextField(String.valueOf(khuyenMai.getChietKhau()),20);
	   
	   javax.swing.JButton btnSave = new javax.swing.JButton("Lưu");
	   javax.swing.JButton btnCancel = new javax.swing.JButton("Hủy");
	   
	   //btnSave add action 
	   btnSave.addActionListener(e -> updateKhuyenmaiData(
		        updateKhuyenMaiDialog, khuyenMai, khuyenMaiDAO, txtMoTa, dateChooserNgayBatDau, dateChooserNgayKetThuc, txtTrangThai, txtChietKhau));
	   //btn cancel add action
	   btnCancel.addActionListener(e->updateKhuyenMaiDialog.dispose());
	   //Panel setup	
	   javax.swing.JPanel formPanel = createFormPanel(txtMaKhuyenMai, txtMoTa, dateChooserNgayBatDau, dateChooserNgayKetThuc,
				txtTrangThai, txtChietKhau);
	   javax.swing.JPanel buttonPanel = createButtonPanel(btnCancel, btnSave);
	   //main panel setup
	   javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.BorderLayout(10, 10));
		mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.add(formPanel, java.awt.BorderLayout.CENTER);
		mainPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

		updateKhuyenMaiDialog.add(mainPanel);
		return updateKhuyenMaiDialog;
   }
   private JPanel createButtonPanel(JButton btnCancel, JButton btnSave) {
	// TODO Auto-generated method stub
	   javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
		buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
		buttonPanel.add(btnCancel);
		buttonPanel.add(btnSave);
		return buttonPanel;  
	
}

private javax.swing.JPanel createFormPanel(javax.swing.JTextField txtMaKhuyenMai, javax.swing.JTextField txtMoTa, JDateChooser dateChooserNgayBatDau, JDateChooser dateChooserNgayKetThuc, javax.swing.JTextField txtTrangThai, javax.swing.JTextField txtChietKhau) {
	// TODO Auto-generated method stub
	javax.swing.JPanel formPanel = new javax.swing.JPanel();
	formPanel.setLayout(new java.awt.GridBagLayout());
	java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
	gbc.insets = new java.awt.Insets(5, 5, 5, 5);
	gbc.anchor = java.awt.GridBagConstraints.WEST;
	
	addComponent(formPanel, gbc, 0, 0, "Mã khuyến mãi:", txtMaKhuyenMai);
	addComponent(formPanel, gbc, 0, 1, "Mô tả:", txtMoTa);
	addComponent(formPanel, gbc, 0, 2, "Ngày bắt đầu:", dateChooserNgayBatDau);
	addComponent(formPanel, gbc, 0, 3, "Ngày kết thúc:", dateChooserNgayKetThuc);
	addComponent(formPanel, gbc, 0, 4, "Trạng thái:", txtTrangThai);
	addComponent(formPanel, gbc, 0, 5, "Chiết khấu:", txtChietKhau);
	
	
	return formPanel;
}

private void addComponent(javax.swing.JPanel panel, GridBagConstraints gbc, int gridX, int gridY, String labelText,
		javax.swing.JComponent component) {
	// TODO Auto-generated method stub
	gbc.gridx = gridX;
	gbc.gridy = gridY;
	panel.add(new javax.swing.JLabel(labelText), gbc);
	gbc.gridx = gridX + 1;
	panel.add(component, gbc);
	
}

private void updateKhuyenmaiData(JDialog dialog, KhuyenMai khuyenMai, KhuyenMai_DAO khuyenMaiDAO,
		JTextField txtMoTa, JDateChooser dateChooserNgayBatDau, JDateChooser dateChooserNgayKetThuc, JTextField txtTrangThai,
		JTextField txtChietKhau) {
	// TODO Auto-generated method stub
	   String moTa = txtMoTa.getText().trim();
	   String trangThai =txtTrangThai.getText().trim();
	   String chietKhauStr=txtChietKhau.getText().trim();
	   
	   java.util.Date ngayBatDauUtil = dateChooserNgayBatDau.getDate();
	   java.util.Date ngayKetThucUtil = dateChooserNgayKetThuc.getDate();
	   
	   if (ngayBatDauUtil == null || ngayKetThucUtil == null) {
	        JOptionPane.showMessageDialog(dialog, "Vui lòng chọn ngày bắt đầu và ngày kết thúc.", "Thông báo",
	                JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    java.sql.Date ngayBatDau = new java.sql.Date(ngayBatDauUtil.getTime());
	    java.sql.Date ngayKetThuc = new java.sql.Date(ngayKetThucUtil.getTime());


	   
	    if (isInputValid(moTa, dateChooserNgayBatDau.getDate(), dateChooserNgayKetThuc.getDate(), trangThai, chietKhauStr)) {
	        try {
	            int chietKhau = Integer.parseInt(chietKhauStr);

	            // Tự động cập nhật trạng thái nếu ngày hiện tại đã qua ngày kết thúc
	            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
	            if (currentDate.after(ngayKetThuc)) {
	                trangThai = "Het han";
	            } else trangThai = "Hoat dong";

	            khuyenMai.setMoTa(moTa);
	            khuyenMai.setNgayBatDau(ngayBatDau);
	            khuyenMai.setNgayKetThuc(ngayKetThuc);
	            khuyenMai.setTrangThai(trangThai);
	            khuyenMai.setChietKhau(chietKhau);

	            if (khuyenMaiDAO.updateKhuyenMai(khuyenMai)) {
	                loadDataToTable();
	                JOptionPane.showMessageDialog(dialog, "Khuyến mãi cập nhật thành công");
	                dialog.dispose();
	            } else {
	                JOptionPane.showMessageDialog(dialog, "Cập nhật không thành công.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(dialog, "Chiết khấu phải là số nguyên.", "Lỗi định dạng",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(dialog, "Vui lòng điền đầy đủ thông tin.", "Thông báo",
	                JOptionPane.WARNING_MESSAGE);
	    }
}

private boolean isInputValid(String moTa, java.util.Date ngayBatDau, java.util.Date ngayKetThuc, String trangThai, String chietKhau) {
    return !moTa.isEmpty() && ngayBatDau != null && ngayKetThuc != null && !trangThai.isEmpty() && !chietKhau.isEmpty();
}


private javax.swing.JTextField createTextField(String text, boolean editable) {
		javax.swing.JTextField textField = new javax.swing.JTextField(text, 20);
		textField.setEditable(editable);
		return textField;
}
   private java.sql.Date parseDate(String dateString) throws java.text.ParseException {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = dateFormat.parse(dateString);
		return new java.sql.Date(date.getTime());
	}
   
   public void showAddKhuyenMaiDialog(java.awt.event.MouseEvent evt) {
	   JDialog addKhuyenMaiDialog = new JDialog((Frame) null,"Thêm khuyễn mãi",true);
	   addKhuyenMaiDialog.setSize(500,400);
	   addKhuyenMaiDialog.setLocationRelativeTo(this);
	   
	   
	   //UI	
	   String MaKhuyenMai = generateNewKhuyenMaiID();
	   javax.swing.JLabel lblMaKhuyenMai = new javax.swing.JLabel("Mã khuyến mãi: ");
	   javax.swing.JTextField txtMaKhuyenMai = new javax.swing.JTextField(MaKhuyenMai, 20);
	   txtMaKhuyenMai.setEditable(false);
	   
	   JTextField txtMoTa=new JTextField(20);
	   JDateChooser dateChooserNgayBatDau = new JDateChooser();
	   JDateChooser dateChooserNgayKetThuc = new JDateChooser();
	   dateChooserNgayBatDau.setDateFormatString("dd/MM/yyyy");
       dateChooserNgayKetThuc.setDateFormatString("dd/MM/yyyy");
	   JTextField txtTrangThai = new JTextField(20);
	   JTextField txtChietKhau=new JTextField(20);
	   
	   JButton btnSave = new JButton("Lưu");
	   JButton btnCancel = new JButton("Hủy");
	   
	   // layout components
	   	JPanel formPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		
		addFormRow(formPanel,gbc,0,"Mã khuyến mãi:",txtMaKhuyenMai);
		addFormRow(formPanel,gbc,1,"Mô tả:",txtMoTa);
		addFormRow(formPanel, gbc, 2, "Ngày bắt đầu:", dateChooserNgayBatDau);
		addFormRow(formPanel, gbc, 3, "Ngày kết thúc:", dateChooserNgayKetThuc);
		addFormRow(formPanel,gbc,4,"Trạng thái:",txtTrangThai);
		addFormRow(formPanel,gbc,5,"Chiết khấu:",txtChietKhau);
		
		// Button panel setup
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(btnCancel);
		buttonPanel.add(btnSave);
		
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.add(formPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		//Event Listeners
		btnSave.addActionListener(e -> {
			if(saveKhuyenMaiData(addKhuyenMaiDialog,txtMoTa,dateChooserNgayBatDau,dateChooserNgayKetThuc,txtTrangThai,txtChietKhau)) {
				addKhuyenMaiDialog.dispose();
			}
		});
		btnCancel.addActionListener(e -> addKhuyenMaiDialog.dispose());
		
		addKhuyenMaiDialog.add(mainPanel);
		addKhuyenMaiDialog.setVisible(true);

   }
   
private boolean saveKhuyenMaiData(JDialog dialog, JTextField txtMoTa, JDateChooser dateChooserNgayBatDau,
		JDateChooser dateChooserNgayKetThuc, JTextField txtTrangThai, JTextField txtChietKhau) {
	// TODO Auto-generated method stub
	String moTa=txtMoTa.getText().trim();
	java.util.Date ngayBatDau = dateChooserNgayBatDau.getDate();
	java.util.Date ngayKetThuc = dateChooserNgayKetThuc.getDate();
	String trangThai =txtTrangThai.getText().trim();
	String chietKhau =txtChietKhau.getText().trim();
	
	if (moTa.isEmpty() || ngayBatDau == null|| ngayKetThuc== null ||trangThai.isEmpty() || chietKhau.isEmpty()) {
        JOptionPane.showMessageDialog(dialog, "Vui lòng điền đầy đủ thông tin.", "Thông báo",
                JOptionPane.WARNING_MESSAGE);
        return false;
    }
	
	

    
    
    
	String maKhuyenMai = generateNewKhuyenMaiID();
	 if (maKhuyenMai == null) {
	        // Hiển thị thông báo lỗi nếu không tạo được mã
	        JOptionPane.showMessageDialog(dialog, "Lỗi khi tạo mã khuyến mãi mới.", "Lỗi",
	                JOptionPane.ERROR_MESSAGE);
	        return false; // Trả về false để chỉ ra rằng có lỗi xảy ra
    }
	
	// Lưu dữ liệu vào cơ sở dữ liệu
    if (saveToDatabase(maKhuyenMai, moTa, ngayBatDau, ngayKetThuc, trangThai, chietKhau)) {
        // Thêm dòng mới vào bảng với thứ tự hoán đổi
        DefaultTableModel tableModel = (DefaultTableModel) tbKhuyenMai.getModel();
        tableModel.addRow(new Object[] { maKhuyenMai, moTa, ngayBatDau, ngayKetThuc, trangThai, chietKhau});
        return true;
    } else {
        JOptionPane.showMessageDialog(dialog, "Lỗi lưu dữ liệu vào cơ sở dữ liệu.", "Lỗi",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }
	

	
}

private boolean saveToDatabase(String maKhuyenMai, String moTa, java.util.Date ngayBatDau, java.util.Date ngayKetThuc,
		String trangThai, String chietKhau) {
	// TODO Auto-generated method stub
	ConnectDB connectDB = new ConnectDB();
	try (Connection conn = connectDB.getConnection()) { // Use the connection from ConnectDB
		if (conn == null) {
			JOptionPane.showMessageDialog(null, "Không thể kết nối tới cơ sở dữ liệu.", "Lỗi kết nối",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		String sql = "INSERT INTO KhuyenMai (MaKhuyenMai, MoTa, NgayBatDau, NgayKetThuc, TrangThai, ChietKhau) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
				pstmt.setString(1, maKhuyenMai); // Thiết lập tham số 1 (MaKhuyenMai)
			    pstmt.setString(2, moTa); // Thiết lập tham số 2 (MoTa)
			    pstmt.setDate(3, new java.sql.Date(ngayBatDau.getTime())); // Thiết lập tham số 3 (NgayBatDau)
			    pstmt.setDate(4, new java.sql.Date(ngayKetThuc.getTime())); // Thiết lập tham số 4 (NgayKetThuc)
			    pstmt.setString(5, trangThai); // Thiết lập tham số 5 (TrangThai)
			    pstmt.setString(6, chietKhau); // Thiết lập tham số 6 (ChietKhau)
			
			int rowInserted = pstmt.executeUpdate();
			return rowInserted > 0;	
			
		} 
		} catch (SQLException e ) {
			e.printStackTrace();
			return false;
		}
	}



	// TODO Auto-generated method stub
	private String generateNewKhuyenMaiID() {
		String nextCode = "KM001"; // Default code
		try (Connection conn = ConnectDB.getConnection()) {
			String sql = "SELECT MAX(maKhuyenMai) FROM KhuyenMai";
			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					String lastCode = rs.getString(1);
					if (lastCode != null) {
						int lastNumber = Integer.parseInt(lastCode.substring(2)); // Extract number part
						nextCode = "KM" + String.format("%03d", lastNumber + 1); // Increment and format
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


// Helper method to add components in formPanel
   private void addFormRow(JPanel panel, GridBagConstraints gbc, int row, String labelText, Component component) {
	   	gbc.gridx = 0;
		gbc.gridy = row;
		panel.add(new JLabel(labelText), gbc);

		gbc.gridx = 1;
		panel.add(component, gbc);
   }
   
   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCapNhat;
    private javax.swing.JLabel btnThemKhuyenMai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCapNhat;
    private javax.swing.JLabel lblThemKhuyenMai;
    private javax.swing.JTable tbKhuyenMai;
    private javax.swing.JLabel titleHoaDon;
    // End of variables declaration//GEN-END:variables

   
}
