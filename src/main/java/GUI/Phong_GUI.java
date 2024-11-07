/*
 * Click nbfs://nbhost/SystemFile/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import GUI.ChiTietDatPhong_Dialog;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import DAO.DanhSachDatPhong_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import ENTITY.PhieuDatPhong;
import ENTITY.Phong;
import ENTITY.TinhTrangPhong;
import ENTITY.TrangThaiPhong;
import GUI.ThemKhachHangDialog_GUI;
import GUI.KhachHang_GUI;

/**
 *
 * @author Admin
 */
public class Phong_GUI extends javax.swing.JPanel {
    private List<JPanel> phongCards; // Danh sách để lưu trữ các card phòng
	private Phong_DAO phongDAO;
	private JPanel panelMain;
	private PhieuDatPhong phieuDatPhong;
    /**
     * Creates new form Phong_GUI
     */
    public Phong_GUI() {
        phongCards = new ArrayList<>(); // Khởi tạo danh sách
        phongDAO = new Phong_DAO();
        initComponents();
        loadDataToCards();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        jDialog1.setLocationRelativeTo(null);
    }

    private void setExtendedState(int maximizedBoth) {
		// TODO Auto-generated method stub
		
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    

    private void initComponents() {
    	
    	String[] tangOptions = {"Phòng đơn", "Phòng đôi", "Phòng gia đình"};
    	JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BorderLayout());
        JPanel headerPanel = new JPanel();
        JComboBox<String> tangComboBox = new JComboBox<>(tangOptions);
        
        tangComboBox.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tangComboBox.setForeground(Color.decode("#004B97"));
        tangComboBox.setBackground(Color.white);
     // Đặt kích thước cho JComboBox
        tangComboBox.setPreferredSize(new Dimension(140, 40)); // Kích thước phù hợp
        
        headerPanel.setBackground(Color.white);        
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        
     // Thêm lọc ngày tháng năm
        Calendar calendar = Calendar.getInstance();
        JPanel panelLocNgay = new JPanel();
        JLabel lbLocTu = new JLabel("Từ");
        lbLocTu.setFont(new Font("Segoe UI", Font.BOLD, 16));
        JDateChooser txtNgayCheckIn = new com.toedter.calendar.JDateChooser();
        JDateChooser txtNgayCheckOut = new com.toedter.calendar.JDateChooser();
		txtNgayCheckIn.setDateFormatString("dd/MM/yyyy");
		txtNgayCheckOut.setDateFormatString("dd/MM/yyyy");

        // Ngày Check-in là ngày hiện tại
        java.util.Date checkInDate = calendar.getTime();
        txtNgayCheckIn.setDate(checkInDate);
        JLabel lbLocDen = new JLabel("Đến");
        lbLocDen.setFont(new Font("Segoe UI", Font.BOLD, 16));
        // Ngày Check-out là ngày hôm sau
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        java.util.Date checkOutDate = calendar.getTime();
        txtNgayCheckOut.setDate(checkOutDate);
        panelLocNgay.add(lbLocTu);
        panelLocNgay.add(txtNgayCheckIn);
        panelLocNgay.add(lbLocDen);
        panelLocNgay.add(txtNgayCheckOut);
        
        panelLocNgay.setBackground(Color.white);
        
        JLabel lblTitle = new JLabel("Danh sách phòng");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        headerPanel.add(panelLocNgay, BorderLayout.WEST);
        //Panel bên phải
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
      
        
     // Thêm các JLabel vào rightPanel
        JLabel lblFilter1 = new JLabel("Tất cả(20)");
        lblFilter1.setIcon(new ImageIcon(getClass().getResource("/IMAGES/phong-home.png")));
        lblFilter1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JLabel lblPhongTrong = new JLabel("Phòng trống()");
        lblPhongTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	lblPhongTrongClicked(evt);
            }
        });
        
        lblPhongTrong.setIcon(new ImageIcon(getClass().getResource("/IMAGES/phong-trong.png")));
        lblPhongTrong.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblPhongTrong.setForeground(Color.decode("#0094FE"));
        JLabel lblFilter3 = new JLabel("Đang sử dụng()");
        lblFilter3.setIcon(new ImageIcon(getClass().getResource("/IMAGES/phong-ban.png")));
        lblFilter3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblFilter3.setForeground(Color.decode("#FA5950"));
        JLabel lblFilter4 = new JLabel("Chưa dọn()");
        lblFilter4.setIcon(new ImageIcon(getClass().getResource("/IMAGES/phong-do.png")));
        lblFilter4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblFilter4.setForeground(Color.decode("#004B97"));
        
        // Thiết lập font hoặc màu cho các JLabel bên phải nếu cần
        lblFilter1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblFilter1.setBorder(BorderFactory.createEmptyBorder(5, 2, 2, 2));
        lblPhongTrong.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblPhongTrong.setBorder(BorderFactory.createEmptyBorder(5, 2, 2, 2));
        lblFilter3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblFilter3.setBorder(BorderFactory.createEmptyBorder(5, 2, 2, 2));
        lblFilter4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblFilter4.setBorder(BorderFactory.createEmptyBorder(5, 2, 2, 2));

        // Thêm các JLabel vào rightPanel
        rightPanel.add(tangComboBox);
        rightPanel.add(lblFilter1);
        rightPanel.add(lblPhongTrong);
        rightPanel.add(lblFilter3);
        rightPanel.add(lblFilter4);


        // Thêm rightPanel vào bên phải của headerPanel
        headerPanel.add(rightPanel, BorderLayout.EAST);
        // Tạo panel chính chứa các card phòng
        panelMain = new JPanel(new GridLayout(0, 4, 10, 10)); // 4 cột, khoảng cách 10px
        panelMain.setBackground(Color.white);
        
        JScrollPane scrollPane = new JScrollPane(panelMain);

        
        mainContainer.add(headerPanel, BorderLayout.NORTH);
        mainContainer.add(scrollPane, BorderLayout.CENTER);
        
        // Cấu hình giao diện chính
        setLayout(new BorderLayout());
        add(mainContainer, BorderLayout.CENTER);

        setSize(800, 600);
        
     // Đăng ký ActionListener cho JComboBox
        tangComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy tầng đã chọn và lọc danh sách phòng
                int selectedTang = tangComboBox.getSelectedIndex() + 1; // Tầng 1, 2, 3 ứng với chỉ số 1, 2, 3
//                filterRoomsByFloor(selectedTang);
            }
        });
        lblFilter1.addMouseListener(new MouseListener() {
			
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
				getAllRooms();
			}
		});
    }
    
    private void refreshData() {
        panelMain.removeAll(); // Xóa toàn bộ dữ liệu cũ khỏi panelMain
        loadDataToCards(); // Tải lại dữ liệu từ database
    }

    private void loadDataToCards() {
        List<Phong> dsPhong = phongDAO.getAllPhong();
        int count = 0;
        int tang = 1;
        
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        JPanel tangPanel = createTangPanel(tang);
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); 

        for (Phong phong : dsPhong) {
        	 tangPanel.add(createRoomCard(phong));
             count++;
            
             if (count % 8 == 0) {
                 panelMain.add(tangPanel); // Thêm tầng hiện tại vào panelMain
                 tang++; // Tăng biến đếm tầng

                 // Tạo một JPanel mới cho tầng tiếp theo với tiêu đề mới
                 tangPanel = createTangPanel(tang);
             }
        }
        
        if (count % 8 != 0) {
            panelMain.add(tangPanel);
        }

        panelMain.revalidate(); // Cập nhật lại giao diện sau khi thêm card
        panelMain.repaint();
    }
    
 // Hàm tạo một JPanel với TitledBorder cho từng tầng
    private JPanel createTangPanel(int tang) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 4, 10, 10)); // 2 dòng, 4 cột với khoảng cách giữa các phòng
        TitledBorder border = BorderFactory.createTitledBorder("Tầng " + tang);
        border.setTitleFont(new Font("Segoe UI", Font.BOLD, 20)); // Chọn font, kiểu chữ và kích cỡ
        
        panel.setBorder(border);  // Đặt tiêu đề là tầng
        return panel;
    }

    private JPanel createRoomCard(Phong phong) {
        // Tạo panel con đại diện cho một phòng
    	RoundedPanel card = new RoundedPanel(20);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.decode("#0094FE"));
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Thêm thông tin phòng vào card
        JLabel lblMaPhong = new JLabel(phong.getMaPhong());
        lblMaPhong.setForeground(Color.WHITE);
        lblMaPhong.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblMaPhong.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));

        JLabel lblLoaiPhong = new JLabel(phong.getLoaiPhong().getTenLoaiPhong());
        lblLoaiPhong.setForeground(Color.WHITE);
        lblLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblLoaiPhong.setBorder(BorderFactory.createEmptyBorder(5, 10, 2, 10));
        
        JLabel lblGiaNgay = new JLabel(""+phong.getLoaiPhong().getGiaTienTheoNgay());
        lblGiaNgay.setForeground(Color.WHITE);
        lblGiaNgay.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblGiaNgay.setIcon(new ImageIcon(getClass().getResource("/IMAGES/sun.png")));
        lblGiaNgay.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        JLabel lblGiaGio = new JLabel(""+phong.getLoaiPhong().getGiaTienTheoGio());
        lblGiaGio.setForeground(Color.WHITE);
        lblGiaGio.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblGiaGio.setIcon(new ImageIcon(getClass().getResource("/IMAGES/watch.png")));
        lblGiaGio.setBorder(BorderFactory.createEmptyBorder(5, 10, 2, 10));
       
        RoundedPanel panelTinhTrang = new RoundedPanel(30);
        JLabel lblTinhTrang = new JLabel(phong.getTinhTrangPhong().toString());
        if(phong.getTinhTrangPhong() == TinhTrangPhong.SACH) {
        	lblTinhTrang.setForeground(Color.decode("#2F9245"));
        	lblTinhTrang.setIcon(new ImageIcon(getClass().getResource("/IMAGES/Vector.png")));
        	panelTinhTrang.setBackground(Color.decode("#E6FFEB"));
        	if(phong.getTrangThaiPhong() == TrangThaiPhong.DANG_SU_DUNG) {
            	card.setBackground(Color.decode("#FA5950"));
        	}
        }else {
        	lblTinhTrang.setForeground(Color.decode("#CC0000"));
        	lblTinhTrang.setIcon(new ImageIcon(getClass().getResource("/IMAGES/notclean.png")));
        	panelTinhTrang.setBackground(Color.decode("#FFE6E6"));
        	card.setBackground(Color.decode("#004B97"));
        }
        panelTinhTrang.add(lblTinhTrang);
        
        panelTinhTrang.addMouseListener(new MouseListener() {
			
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
				
				int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn chuyển trạng thái phòng này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
			    if (confirm != JOptionPane.YES_OPTION) {
			        // Nếu người dùng chọn "No", thoát khỏi sự kiện mà không thực hiện thêm
			        return;
			    }
				// Lấy tình trạng hiện tại của phòng (là một enum)
			    TinhTrangPhong tinhTrangHienTai = phong.getTinhTrangPhong();

			    // Chuyển đổi tình trạng
			    TinhTrangPhong tinhTrangMoi = (tinhTrangHienTai == TinhTrangPhong.SACH) ? TinhTrangPhong.CHUA_DON : TinhTrangPhong.SACH;

			    // Cập nhật tình trạng mới vào CSDL
			    if (phongDAO.updateTinhTrangPhong(phong.getMaPhong(), tinhTrangMoi.name())) {
			        phong.setTinhTrangPhong(tinhTrangMoi); // Cập nhật trong đối tượng

			        // Cập nhật giao diện dựa trên tình trạng mới
			        if (tinhTrangMoi == TinhTrangPhong.SACH) {
			            lblTinhTrang.setForeground(Color.decode("#2F9245"));
			            lblTinhTrang.setText("Sạch");
			            lblTinhTrang.setIcon(new ImageIcon(getClass().getResource("/IMAGES/Vector.png")));
			            panelTinhTrang.setBackground(Color.decode("#E6FFEB"));
			            panelTinhTrang.setMaximumSize(new Dimension(lblTinhTrang.getPreferredSize().width + 20, lblTinhTrang.getPreferredSize().height + 10));
			            panelTinhTrang.setPreferredSize(new Dimension(lblTinhTrang.getPreferredSize().width + 20, lblTinhTrang.getPreferredSize().height + 10));
			            panelTinhTrang.setAlignmentX(Component.CENTER_ALIGNMENT);
			        } else {
			            lblTinhTrang.setForeground(Color.decode("#CC0000"));
			            lblTinhTrang.setText("Chưa dọn");
			            lblTinhTrang.setIcon(new ImageIcon(getClass().getResource("/IMAGES/notclean.png")));
			            panelTinhTrang.setBackground(Color.decode("#FFE6E6"));
			            panelTinhTrang.setMaximumSize(new Dimension(lblTinhTrang.getPreferredSize().width + 20, lblTinhTrang.getPreferredSize().height + 10));
			            panelTinhTrang.setPreferredSize(new Dimension(lblTinhTrang.getPreferredSize().width + 20, lblTinhTrang.getPreferredSize().height + 10));
			            panelTinhTrang.setAlignmentX(Component.CENTER_ALIGNMENT);
			        }
			    } else {
			        JOptionPane.showMessageDialog(null, "Cập nhật thất bại.");
			    }
			    lblMaPhong.setAlignmentX(Component.LEFT_ALIGNMENT);
		        lblLoaiPhong.setAlignmentX(Component.LEFT_ALIGNMENT);
		        lblGiaNgay.setAlignmentX(Component.LEFT_ALIGNMENT);
		        lblGiaGio.setAlignmentX(Component.LEFT_ALIGNMENT);
		        panelTinhTrang.setAlignmentX(Component.LEFT_ALIGNMENT);
				refreshData();
			}

		});
        
        panelTinhTrang.setMaximumSize(new Dimension(lblTinhTrang.getPreferredSize().width + 20, lblTinhTrang.getPreferredSize().height + 10));
        panelTinhTrang.setPreferredSize(new Dimension(lblTinhTrang.getPreferredSize().width + 20, lblTinhTrang.getPreferredSize().height + 10));
        panelTinhTrang.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lblMaPhong.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblLoaiPhong.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblGiaNgay.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblGiaGio.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelTinhTrang.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Thêm các thành phần vào card
        card.add(lblMaPhong);
        card.add(lblLoaiPhong);
        card.add(lblGiaGio);
        card.add(lblGiaNgay);
        card.add(panelTinhTrang);
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        card.addMouseListener(new MouseListener() {
			
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
				showRoomDetailsDialog(phong);
				
			}
		});
        phongCards.add(card);
        
        return card;
    }
    
 // Phương thức để cập nhật màu của `card` dựa trên mã phòng
    public void updateRoomColor(String maPhong, Color color) {
        for (JPanel card : phongCards) {
        	refreshData();
            JLabel lblMaPhong = (JLabel) card.getComponent(0); // Giả định nhãn mã phòng là phần tử đầu tiên
            if (lblMaPhong.getText().equals(maPhong)) {
                card.setBackground(color); // Cập nhật màu
                break;
            }
        }
    }
    
//    private void filterRoomsByFloor(int tang) {
//        panelMain.removeAll(); // Xóa các phòng hiện có trong panelMain
//
//        // Đặt BoxLayout cho panelMain để các tầng hiển thị theo chiều dọc
//        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
//
//        // Tạo một JPanel với TitledBorder cho tầng được chọn
//        JPanel tangPanel = new JPanel();
//        tangPanel.setLayout(new GridLayout(6, 4, 10, 10)); // 6 dòng x 4 cột
//        TitledBorder border = BorderFactory.createTitledBorder("Tầng " + tang);
//        border.setTitleFont(new Font("Segoe UI", Font.BOLD, 20));
//        
//        tangPanel.setBorder(border); // Đặt đường viền với tiêu đề tầng
//
//        // Gọi DAO để lấy danh sách phòng theo tầng
//        List<Phong> danhSachPhong = phongDAO.getPhongTheoTang(tang);
//
//        // Thêm các phòng vào tangPanel
//        for (Phong phong : danhSachPhong) {
//            JPanel card = createRoomCard(phong);
//            tangPanel.add(card);
//        }
//
//        // Nếu số lượng phòng ít hơn 4 x 6 (24), thêm các JPanel trống vào tangPanel
//        int totalSlots = 4 * 6; // 4 cột x 6 dòng
//        int emptySlots = totalSlots - danhSachPhong.size();
//        for (int i = 0; i < emptySlots; i++) {
//            tangPanel.add(new JPanel()); // Thêm JPanel trống
//        }
//
//        // Thêm tangPanel vào panelMain
//        panelMain.add(tangPanel);
//
//        panelMain.revalidate(); // Cập nhật lại giao diện
//        panelMain.repaint();
//    }
    
    
    private void hienThiTatCaPhongTrong() {
        panelMain.removeAll(); // Xóa tất cả các phần tử hiện có trong panelMain

        // Đặt bố cục GridLayout cho panelMain để hiển thị tất cả các phòng trống
        panelMain.setLayout(new GridLayout(6, 4, 10, 10)); // 6 hàng x 4 cột, điều chỉnh tùy theo số phòng

        // Gọi phương thức getAllPhongTrong() để lấy danh sách các phòng trống
        List<Phong> danhSachPhongTrong = phongDAO.getAllPhongTrong();

        // Thêm các phòng trống vào panelMain
        for (Phong phong : danhSachPhongTrong) {
            JPanel card = createRoomCard(phong); // Phương thức tạo giao diện phòng
            panelMain.add(card);
        }

        // Nếu số lượng phòng ít hơn 4 x 6 (24), thêm các JPanel trống vào panelMain để lấp đầy
        int totalSlots = 4 * 6; // 4 cột x 6 dòng
        int emptySlots = totalSlots - danhSachPhongTrong.size();
        for (int i = 0; i < emptySlots; i++) {
            panelMain.add(new JPanel()); // Thêm JPanel trống
        }

        panelMain.revalidate(); // Cập nhật lại giao diện
        panelMain.repaint();
    }
    
    private void getAllRooms() {
    	panelMain.removeAll();
    	
    	loadDataToCards();
    }
    
    private void lblPhongTrongClicked(java.awt.event.MouseEvent evt) {
    	hienThiTatCaPhongTrong();
    }
    
    //JDialogDatPhong
    private void showRoomDetailsDialog(Phong phong) {// Khởi tạo DAO để lấy thông tin phiếu đặt phòng theo mã phòng
    	if (phong.getTrangThaiPhong() == TrangThaiPhong.DANG_SU_DUNG) { // Kiểm tra trạng thái "Đang Sử Dụng"
            // Sử dụng RoomDetailDialog cho phòng đang sử dụng
    		Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(this);
    		ChiTietDatPhong_Dialog chiTietDatPhongDialog = new ChiTietDatPhong_Dialog(parentFrame, phong);
    		chiTietDatPhongDialog.setVisible(true);
        }
    	else {
    		JDialog dialog = new JDialog();
            dialog.setTitle("Chi tiết phòng - " + phong.getMaPhong());
            dialog.setModal(true); // Chặn các thao tác bên ngoài khi mở dialog
            dialog.setSize(450, 400);
            dialog.setLocationRelativeTo(null); // Hiển thị dialog ở giữa màn hình

            // Tạo JPanel chứa thông tin phòng
            JPanel dialogPanel = new JPanel();
            dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
            dialogPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            dialogPanel.setBackground(Color.white);

            // Tạo và thêm các JLabel vào dialogPanel cùng với JSeparator
            JLabel lblMaPhong = new JLabel(phong.getMaPhong());
            lblMaPhong.setFont(new Font("Segoe UI", Font.BOLD, 24));
            lblMaPhong.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
            dialogPanel.add(lblMaPhong);
            dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

            JLabel lblLoaiPhong = new JLabel("Loại phòng: " + phong.getLoaiPhong().getTenLoaiPhong());
            lblLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
            lblLoaiPhong.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
            dialogPanel.add(lblLoaiPhong);
            dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

            JLabel lblGiaNgay = new JLabel("Giá ngày: " + phong.getLoaiPhong().getGiaTienTheoNgay());
            lblGiaNgay.setFont(new Font("Segoe UI", Font.BOLD, 16));
            lblGiaNgay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
            dialogPanel.add(lblGiaNgay);
            dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

            JLabel lblGiaGio = new JLabel("Giá giờ: " + phong.getLoaiPhong().getGiaTienTheoGio());
            lblGiaGio.setFont(new Font("Segoe UI", Font.BOLD, 16));
            lblGiaGio.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
            dialogPanel.add(lblGiaGio);
            dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

            JLabel lblTinhTrang = new JLabel("Tình trạng: " + phong.getTinhTrangPhong());
            lblTinhTrang.setFont(new Font("Segoe UI", Font.BOLD, 16));
            lblTinhTrang.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
            dialogPanel.add(lblTinhTrang);
            dialogPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

            JButton btnDatPhong = new JButton("Đặt phòng");
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            btnDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btnDatPhong.setBackground(Color.decode("#199FFE"));
            btnDatPhong.setMaximumSize(new Dimension(btnDatPhong.getPreferredSize().width + 20, btnDatPhong.getPreferredSize().height + 10));
            btnDatPhong.setPreferredSize(new Dimension(btnDatPhong.getPreferredSize().width + 20, btnDatPhong.getPreferredSize().height + 10));
            btnDatPhong.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnDatPhong.setForeground(Color.white);
            btnDatPhong.setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttonPanel.add(btnDatPhong);
            buttonPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
            buttonPanel.setBackground(Color.white);

            btnDatPhong.addMouseListener(new MouseListener() {
    			
    			private Frame parentFrame;
				private Phong_GUI phongGUI;

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
//        				showBookingDialog(phong);
    				String maPhong = phong.getMaPhong(); // Giả sử phong là đối tượng hợp lệ có phương thức getMaPhong()

    				// Sử dụng SwingUtilities để lấy Window chứa Phong_GUI
    			    Window window = SwingUtilities.getWindowAncestor(Phong_GUI.this);
    			    DatPhong_Dialog_GUI dialogDatPhong = new DatPhong_Dialog_GUI(parentFrame, true, maPhong, phongGUI);
    			    dialog.dispose();
    			    dialogDatPhong.setVisible(true);
    				
    			}
    		});
            
        
            // Thêm dialogPanel vào JDialog
            dialog.add(dialogPanel);
            dialog.setLayout(new BorderLayout());
            dialog.add(dialogPanel, BorderLayout.CENTER);
            dialog.add(buttonPanel, BorderLayout.SOUTH);
            dialog.setVisible(true);
    	}
    }
    
    
		
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel panel101;
    private javax.swing.JPanel panel102;
    private javax.swing.JPanel panel103;
    private javax.swing.JPanel panel104;
    private javax.swing.JPanel panel105;
    private javax.swing.JPanel panel106;
    private javax.swing.JPanel panel107;
    private javax.swing.JPanel panel108;
    private javax.swing.JPanel panel201;
    private javax.swing.JPanel panel202;
    private javax.swing.JPanel panel203;
    private javax.swing.JPanel panel204;
    // End of variables declaration//GEN-END:variables
}
