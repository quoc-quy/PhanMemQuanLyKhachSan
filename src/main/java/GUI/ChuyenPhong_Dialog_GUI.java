package GUI;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import DAO.DanhSachDatPhong_DAO;
import DAO.Phong_DAO;
import ENTITY.PhieuDatPhong;
import ENTITY.Phong;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;

public class ChuyenPhong_Dialog_GUI extends JDialog {
    private JComboBox<String> loaiPhongComboBox;
    private JComboBox<String> availableRoomsComboBox;
    private JDateChooser checkInDateChooser;
    private JDateChooser checkOutDateChooser;

    public ChuyenPhong_Dialog_GUI(Frame parent, Phong phong, PhieuDatPhong phieuDatPhong) {
        super(parent, "Phòng hiện tại - " + phong.getMaPhong(), true);

        setSize(500, 300);
        setLocationRelativeTo(parent);

        // Sử dụng BorderLayout cho dialog panel
        JPanel dialogPanel = new JPanel(new BorderLayout(10, 10));
        dialogPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel CENTER chứa các thành phần nhập liệu
        JPanel centerPanel = new JPanel(new GridLayout(4, 2, 5, 5)); // 4 hàng, 2 cột với khoảng cách 5px
        centerPanel.setBackground(Color.white);
        dialogPanel.setBackground(Color.white);

        // Khởi tạo các thành phần giao diện
        JLabel lblCheckIn = new JLabel("Ngày Check-In: ");
        lblCheckIn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblCheckIn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(lblCheckIn);
        checkInDateChooser = new JDateChooser();
        checkInDateChooser.setDate(new Date());
        checkInDateChooser.getDateEditor().addPropertyChangeListener(e -> updateAvailableRooms());
        centerPanel.add(checkInDateChooser);

        JLabel lblCheckOut = new JLabel("Ngày Check-Out: ");
        lblCheckOut.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblCheckOut.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(lblCheckOut);
        checkOutDateChooser = new JDateChooser();
        checkOutDateChooser.setDate(new Date());
        checkOutDateChooser.getDateEditor().addPropertyChangeListener(e -> updateAvailableRooms());
        centerPanel.add(checkOutDateChooser);

        JLabel lblLoaiPhong = new JLabel("Loại phòng: ");
        lblLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblLoaiPhong.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
 
        centerPanel.add(lblLoaiPhong);
        loaiPhongComboBox = new JComboBox<>(new String[]{"Phong Don", "Phong Doi", "Phong Gia Dinh"});
        loaiPhongComboBox.addActionListener(e -> updateAvailableRooms());
        centerPanel.add(loaiPhongComboBox);

        JLabel lblPhongTrong = new JLabel("Phòng trống: ");
        lblPhongTrong.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblPhongTrong.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(lblPhongTrong);
        availableRoomsComboBox = new JComboBox<>();
        centerPanel.add(availableRoomsComboBox);
        

        // Thêm các thành phần vào BorderLayout
        dialogPanel.add(centerPanel, BorderLayout.CENTER);

        // Nút xác nhận ở phía dưới
        JButton confirmButton = new JButton("Xác nhận");
        confirmButton.addActionListener(e -> {
            String selectedRoom = (String) availableRoomsComboBox.getSelectedItem();
            // Xử lý logic khi chọn phòng trống, ví dụ: chuyển phòng
            dispose();
        });
        confirmButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        confirmButton.setBackground(Color.decode("#199FFE"));
        confirmButton.setMaximumSize(new Dimension(confirmButton.getPreferredSize().width + 20, confirmButton.getPreferredSize().height + 10));
        confirmButton.setPreferredSize(new Dimension(confirmButton.getPreferredSize().width + 20, confirmButton.getPreferredSize().height + 10));
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setForeground(Color.white);
        confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        confirmButton.addActionListener(e -> {
            String selectedRoom = (String) availableRoomsComboBox.getSelectedItem();
            if (selectedRoom == null || selectedRoom.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng muốn đổi sang.");
                return;
            }

            DanhSachDatPhong_DAO bookingDAO = new DanhSachDatPhong_DAO();

            // Hủy phòng hiện tại
            boolean cancelSuccess = bookingDAO.deletePhieuDatPhong(phieuDatPhong.getMaPDP());

            if (!cancelSuccess) {
                JOptionPane.showMessageDialog(this, "Không thể hủy phòng hiện tại.");
                return;
            }

            // Cập nhật trạng thái phòng cũ thành "PHONG_TRONG"
            boolean updateOldRoomStatus = bookingDAO.capNhatTrangThaiPhong(phieuDatPhong.getPhong().getMaPhong(), "PHONG_TRONG");
            if (!updateOldRoomStatus) {
                JOptionPane.showMessageDialog(this, "Không thể cập nhật trạng thái phòng cũ.");
                return;
            }

            // Tạo đối tượng PhieuDatPhong mới cho phòng muốn đổi sang
            PhieuDatPhong newBooking = new PhieuDatPhong();
            newBooking.setPhong(new Phong(selectedRoom));
            newBooking.setNgayNhanPhong(checkInDateChooser.getDate());
            newBooking.setNgayTraPhong(checkOutDateChooser.getDate());
            newBooking.setKhachHang(phieuDatPhong.getKhachHang()); // Giữ nguyên thông tin khách hàng
            newBooking.setNhanVienLap(phieuDatPhong.getNhanVienLap()); // Giữ nguyên thông tin nhân viên lập
            newBooking.setTienCoc(phieuDatPhong.getTienCoc());
            newBooking.setLoaiHinh(phieuDatPhong.getLoaiHinh());
            newBooking.setGioNhanPhong(phieuDatPhong.getGioNhanPhong());
            newBooking.setGioTraPhong(phieuDatPhong.getGioTraPhong());
            newBooking.setTongTien(phieuDatPhong.getTongTien());
            newBooking.setTrangThai("Đã nhận"); // Trạng thái mới là "DANG_SU_DUNG"

            // Thêm phiếu đặt phòng mới
            boolean bookingSuccess = bookingDAO.addPhieuDatPhong(newBooking);

            if (bookingSuccess) {
                // Cập nhật trạng thái phòng mới thành "DANG_SU_DUNG"
                boolean updateNewRoomStatus = bookingDAO.capNhatTrangThaiPhong(selectedRoom, "DANG_SU_DUNG");
                if (!updateNewRoomStatus) {
                    JOptionPane.showMessageDialog(this, "Đổi phòng thành công nhưng không thể cập nhật trạng thái phòng mới.");
                } else {
                    JOptionPane.showMessageDialog(this, "Đổi phòng thành công.");
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Không thể đặt phòng mới.");
            }
        });


        // Tạo panel chứa nút xác nhận, căn phải
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Đặt FlowLayout căn phải
        southPanel.setBackground(Color.white);
        southPanel.add(confirmButton);
        dialogPanel.add(southPanel, BorderLayout.SOUTH);

        add(dialogPanel);

        // Lần đầu tiên cập nhật danh sách phòng
        updateAvailableRooms();
    }

    private void updateAvailableRooms() {
        String selectedRoomType = (String) loaiPhongComboBox.getSelectedItem();
        Date checkInDate = checkInDateChooser.getDate();
        Date checkOutDate = checkOutDateChooser.getDate();

        if (checkInDate != null && checkOutDate != null && checkInDate.before(checkOutDate)) {
            Phong_DAO phongDAO = new Phong_DAO();
            List<Phong> availableRooms = phongDAO.getPhongTrongTrongKhoangThoiGian(checkInDate, checkOutDate);
            
            availableRooms.removeIf(phong -> !phong.getLoaiPhong().getTenLoaiPhong().equals(selectedRoomType));

            availableRoomsComboBox.removeAllItems();
            for (Phong phong : availableRooms) {
                availableRoomsComboBox.addItem(phong.getMaPhong());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọ ngày Check-in và ngày Check-out hợp lệ");
        }
    }
}
