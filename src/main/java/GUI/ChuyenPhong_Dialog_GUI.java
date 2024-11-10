package GUI;

import javax.swing.*;

import org.apache.xmlbeans.impl.store.Cur;

import com.toedter.calendar.JDateChooser;

import DAO.DanhSachDatPhong_DAO;
import DAO.LoaiPhong_DAO;
import DAO.Phong_DAO;
import ENTITY.PhieuDatPhong;
import ENTITY.Phong;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChuyenPhong_Dialog_GUI extends JDialog {
    private JComboBox<String> loaiPhongComboBox;
    private JComboBox<String> availableRoomsComboBox;
    private JDateChooser checkInDateChooser;
    private JDateChooser checkOutDateChooser;
    private JLabel lblTongTien; // Thêm nhãn hiển thị tổng tiền
    private JComboBox<String> cboLoaiHinh; // Thêm JComboBox cho Loại hình
    private ChiTietDatPhong_Dialog chiTietDatPhongDialog;

    public ChuyenPhong_Dialog_GUI(Frame parent, Phong phong, PhieuDatPhong phieuDatPhong, ChiTietDatPhong_Dialog chiTietDatPhongDialog) {
        super(parent, "Phòng hiện tại - " + phong.getMaPhong(), true);
        this.chiTietDatPhongDialog = chiTietDatPhongDialog;

        setSize(500, 400);
        setLocationRelativeTo(parent);

        JPanel dialogPanel = new JPanel(new BorderLayout(10, 10));
        dialogPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dialogPanel.setBackground(Color.white);

        JPanel centerPanel = new JPanel(new GridLayout(6, 2, 5, 5)); // Thêm hàng để chứa loại hình
        centerPanel.setBackground(Color.white);

        // Thêm phần Loại hình
        JLabel lblLoaiHinh = new JLabel("Loại hình:");
        lblLoaiHinh.setFont(new Font("Segoe UI", Font.BOLD, 16));
        centerPanel.add(lblLoaiHinh);

        cboLoaiHinh = new JComboBox<>(new String[]{"Ngày đêm", "Giờ"});
        cboLoaiHinh.addActionListener(e -> calculateTotalAmount()); // Cập nhật tổng tiền khi thay đổi loại hình
        centerPanel.add(cboLoaiHinh);

        JLabel lblCheckIn = new JLabel("Ngày Check-In: ");
        lblCheckIn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        centerPanel.add(lblCheckIn);
        
        checkInDateChooser = new JDateChooser();
        checkInDateChooser.setDate(new Date());
        checkInDateChooser.getDateEditor().addPropertyChangeListener(e -> calculateTotalAmount());
        centerPanel.add(checkInDateChooser);

        JLabel lblCheckOut = new JLabel("Ngày Check-Out: ");
        lblCheckOut.setFont(new Font("Segoe UI", Font.BOLD, 16));
        centerPanel.add(lblCheckOut);
        
        checkOutDateChooser = new JDateChooser();
        checkOutDateChooser.setDate(new Date());
        checkOutDateChooser.getDateEditor().addPropertyChangeListener(e -> calculateTotalAmount());
        centerPanel.add(checkOutDateChooser);

        JLabel lblLoaiPhong = new JLabel("Loại phòng: ");
        lblLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
        centerPanel.add(lblLoaiPhong);
        
        loaiPhongComboBox = new JComboBox<>(new String[]{"Phong Don", "Phong Doi", "Phong Gia Dinh"});
        loaiPhongComboBox.addActionListener(e -> updateAvailableRooms());
        centerPanel.add(loaiPhongComboBox);

        JLabel lblPhongTrong = new JLabel("Phòng trống: ");
        lblPhongTrong.setFont(new Font("Segoe UI", Font.BOLD, 16));
        centerPanel.add(lblPhongTrong);
        
        availableRoomsComboBox = new JComboBox<>();
        availableRoomsComboBox.addActionListener(e -> calculateTotalAmount());
        centerPanel.add(availableRoomsComboBox);

        JLabel lblTongTienTitle = new JLabel("Tổng tiền:");
        lblTongTienTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        centerPanel.add(lblTongTienTitle);

        lblTongTien = new JLabel("0 VND");
        lblTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        centerPanel.add(lblTongTien);

        dialogPanel.add(centerPanel, BorderLayout.CENTER);

        JButton confirmButton = new JButton("Xác nhận");
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
            newBooking.setKhachHang(phieuDatPhong.getKhachHang());
            newBooking.setNhanVienLap(phieuDatPhong.getNhanVienLap());
            newBooking.setTienCoc(phieuDatPhong.getTienCoc());
            newBooking.setLoaiHinh(phieuDatPhong.getLoaiHinh());
            newBooking.setGioNhanPhong(phieuDatPhong.getGioNhanPhong());
            newBooking.setGioTraPhong(phieuDatPhong.getGioTraPhong());
            newBooking.setTongTien(Double.parseDouble(lblTongTien.getText().replace(" VND", "").replace(",", ""))); // Set tổng tiền
            newBooking.setTrangThai("Đã nhận");

            boolean bookingSuccess = bookingDAO.addPhieuDatPhong(newBooking);

            if (bookingSuccess) {
                boolean updateNewRoomStatus = bookingDAO.capNhatTrangThaiPhong(selectedRoom, "DANG_SU_DUNG");
                if (!updateNewRoomStatus) {
                    JOptionPane.showMessageDialog(this, "Đổi phòng thành công nhưng không thể cập nhật trạng thái phòng mới.");
                } else {
                    JOptionPane.showMessageDialog(this, "Đổi phòng thành công.");
                    dispose(); // Đóng ChuyenPhong_Dialog_GUI
                    chiTietDatPhongDialog.dispose();
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Không thể đặt phòng mới.");
            }
        });

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southPanel.setBackground(Color.white);
        southPanel.add(confirmButton);
        dialogPanel.add(southPanel, BorderLayout.SOUTH);

        add(dialogPanel);

        // Lần đầu tiên cập nhật danh sách phòng và tính toán tổng tiền
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
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày Check-in và Check-out hợp lệ");
        }
    }

    private void calculateTotalAmount() {
        try {
            // Lấy loại hình từ JComboBox (bạn cần chắc chắn đã thêm ComboBox để chọn loại hình)
            String loaiHinh = (String) cboLoaiHinh.getSelectedItem();
            String maPhong = (String) availableRoomsComboBox.getSelectedItem();

            // Kiểm tra giá trị null để tránh lỗi
            if (loaiHinh == null || maPhong == null || checkInDateChooser.getDate() == null || checkOutDateChooser.getDate() == null) {
                lblTongTien.setText("0 VND");
                return;
            }

            // Tạo đối tượng LoaiPhong_DAO để truy xuất dữ liệu giá phòng
            LoaiPhong_DAO loaiPhongDAO = new LoaiPhong_DAO();

            // Khai báo giá phòng theo loại hình
            double giaPhong;
            if ("Ngày đêm".equals(loaiHinh)) {
                giaPhong = loaiPhongDAO.getGiaTienTheoNgay(maPhong); // Lấy giá tiền theo ngày
            } else if ("Giờ".equals(loaiHinh)) {
                giaPhong = loaiPhongDAO.getGiaTienTheoGio(maPhong); // Lấy giá tiền theo giờ
            } else {
                JOptionPane.showMessageDialog(this, "Loại hình không hợp lệ.");
                return;
            }

            double tongTien = 0;

            // Lấy dữ liệu ngày và giờ từ JDateChooser và giả định giờ check-in và check-out nếu cần
            Date ngayCheckIn = checkInDateChooser.getDate();
            Date ngayCheckOut = checkOutDateChooser.getDate();
            String gioCheckIn = "14:00";  // Giả định giờ check-in là 14:00 nếu không có dữ liệu thời gian
            String gioCheckOut = "12:00"; // Giả định giờ check-out là 12:00 nếu không có dữ liệu thời gian

            // Tính toán tổng tiền dựa trên loại hình
            if ("Ngày đêm".equals(loaiHinh)) {
                // Tính số ngày ở
                long diffInMillies = Math.abs(ngayCheckOut.getTime() - ngayCheckIn.getTime());
                int soNgayO = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                tongTien = soNgayO * giaPhong;
            } else if ("Giờ".equals(loaiHinh)) {
                // Tính số giờ ở dựa trên giờ check-in và check-out
                Calendar calendarCheckIn = Calendar.getInstance();
                calendarCheckIn.setTime(ngayCheckIn);
                calendarCheckIn.set(Calendar.HOUR_OF_DAY, 14); // Giả định giờ check-in là 14:00
                calendarCheckIn.set(Calendar.MINUTE, 0);

                Calendar calendarCheckOut = Calendar.getInstance();
                calendarCheckOut.setTime(ngayCheckOut);
                calendarCheckOut.set(Calendar.HOUR_OF_DAY, 12); // Giả định giờ check-out là 12:00
                calendarCheckOut.set(Calendar.MINUTE, 0);

                long diffInMillies = Math.abs(calendarCheckOut.getTimeInMillis() - calendarCheckIn.getTimeInMillis());
                int soGio = (int) TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                // Xử lý lỗi nếu số giờ tính ra là 0 hoặc âm
                if (soGio <= 0) {
                    JOptionPane.showMessageDialog(this, "Thời gian check-out phải lớn hơn thời gian check-in.");
                    lblTongTien.setText("0 VND");
                    return;
                }

                tongTien = soGio * giaPhong;
            }

            // Hiển thị tổng tiền đã tính
            lblTongTien.setText(String.format("%.0f VND", tongTien));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi trong quá trình tính toán: " + e.getMessage());
        }
    }

}
