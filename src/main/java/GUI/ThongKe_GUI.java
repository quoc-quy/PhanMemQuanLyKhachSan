/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import DAO.ThongKe_DAO;

/**
 *
 * @author Admin
 */
public class ThongKe_GUI extends javax.swing.JPanel {

    /**
     * Creates new form ThongKe_GUI
     */
    public ThongKe_GUI() {
        initComponents();   
        chartPanel.setLayout(new BorderLayout());
        add(chartPanel, BorderLayout.CENTER); // Thêm chartPanel vào giao diện chính
        chartPanel.setPreferredSize(new Dimension(800, 700));
        chartPanel.revalidate();
        setDefaultDatesAndShowTodayRevenue(); // Hiển thị doanh số của ngày hôm nay

        // Lắng nghe sự kiện thay đổi ngày
        txtNgayBatDau.addPropertyChangeListener("date", evt -> onDateChanged());
        txtNgayKetThuc.addPropertyChangeListener("date", evt -> onDateChanged());// Lắng nghe sự kiện thay đổi tháng
        cboThang.addActionListener(e -> onMonthChanged());
        cboNam.addActionListener(e -> onYearChanged());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cboThang = new javax.swing.JComboBox<>();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        cboNam = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(908, 670));

        chartPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cboThang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 01", "Tháng 02", "Tháng 03", "Tháng 04", "Tháng 05", "Tháng 06", "Tháng 07", "Tháng 08", "Tháng 09", "Tháng 10", "Tháng 11", "Tháng 12" }));

        txtNgayBatDau.setDateFormatString("dd/MM/yyyy");
        txtNgayBatDau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtNgayKetThuc.setDateFormatString("dd/MM/yyyy");
        txtNgayKetThuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cboNam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Năm 2024", "Năm 2023", " " }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Từ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Đến");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboThang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(cboNam, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    // End of variables declaration//GEN-END:variables
    
// ===================================================================================================================================
 // Tạo biểu đồ từ dữ liệu
    private void createChart(String startDate, String endDate) {
        // Kiểm tra tham số
        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đầy đủ ngày bắt đầu và ngày kết thúc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy dữ liệu từ ThongKe_DAO
        Map<String, Double> revenueData = ThongKe_DAO.getRevenueByDate(startDate, endDate);

        if (revenueData.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu trong khoảng ngày đã chọn.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Tạo dataset cho biểu đồ
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Double> entry : revenueData.entrySet()) {
            dataset.addValue(entry.getValue(), "Doanh Thu", entry.getKey());
        }

        // Tạo biểu đồ
        JFreeChart barChart = ChartFactory.createBarChart(
                "Thống Kê Doanh Thu Theo Ngày",
                "Ngày",
                "Doanh Thu (VND)",
                dataset   
        );

        // Hiển thị biểu đồ
        ChartPanel chart = new ChartPanel(barChart);
        chartPanel.removeAll();
        chartPanel.add(chart, BorderLayout.CENTER);
        chartPanel.validate();
        chartPanel.repaint();
    }
    
 // Lấy ngày định dạng yyyy-MM-dd từ JDateChooser
    private String getFormattedDate(JDateChooser dateChooser) {
        if (dateChooser.getDate() == null) { // Kiểm tra nếu giá trị null
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateChooser.getDate());
    }
    
 // Đặt ngày mặc định cho các trường JDateChooser
    private void setDefaultDatesAndShowTodayRevenue() {
        java.util.Date currentDate = new java.util.Date(); // Lấy ngày hiện tại
        txtNgayBatDau.setDate(currentDate); // Đặt ngày hiện tại cho txtNgayBatDau
        txtNgayKetThuc.setDate(currentDate); // Đặt ngày hiện tại cho txtNgayKetThuc

        // Hiển thị doanh số của ngày hôm nay
        String today = getFormattedDate(txtNgayBatDau);
        createChart(today, today);
    }
    
    private void onDateChanged() {
        String startDate = getFormattedDate(txtNgayBatDau);
        String endDate = getFormattedDate(txtNgayKetThuc);

        // Kiểm tra nếu giá trị không hợp lệ
        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đầy đủ ngày bắt đầu và ngày kết thúc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Gọi phương thức tạo biểu đồ với khoảng ngày mới
        createChart(startDate, endDate);
    }

 // ===================================================================================================================================
    private void onMonthChanged() {
        // Lấy tháng từ cboThang (bỏ chữ "Tháng")
        String monthText = cboThang.getSelectedItem().toString(); // Ví dụ: "Tháng 01"
        int month = Integer.parseInt(monthText.replace("Tháng ", "")); // Chỉ lấy số

        // Lấy năm từ cboNam (bỏ chữ "Năm")
        String yearText = cboNam.getSelectedItem().toString(); // Ví dụ: "Năm 2024"
        int year = Integer.parseInt(yearText.replace("Năm ", "")); // Chỉ lấy số

        // Lấy dữ liệu doanh thu theo tháng và năm
        Map<String, Double> revenueData = ThongKe_DAO.getRevenueByMonth(month, year);

        // Tạo dataset cho biểu đồ
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Double> entry : revenueData.entrySet()) {
            dataset.addValue(entry.getValue(), "Doanh Thu", entry.getKey());
        }

        // Tạo biểu đồ
        JFreeChart barChart = ChartFactory.createBarChart(
                "Thống Kê Doanh Thu Theo Tháng",
                "Ngày",
                "Doanh Thu (VND)",
                dataset
        );

        // Hiển thị biểu đồ
        ChartPanel chart = new ChartPanel(barChart);
        chartPanel.removeAll();
        chartPanel.add(chart, BorderLayout.CENTER);
        chartPanel.validate();
        chartPanel.repaint();
    }

    // ===================================================================================================================================
    private void onYearChanged() {
        String yearText = cboNam.getSelectedItem().toString(); // Lấy giá trị từ cboNam
        int year = Integer.parseInt(yearText.replace("Năm ", "")); // Bỏ chữ "Năm"

        // Lấy dữ liệu doanh thu theo năm (đã sắp xếp trong DAO)
        Map<String, Double> revenueData = ThongKe_DAO.getRevenueByYear(year);

        // Tạo dataset cho biểu đồ
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        // Sắp xếp dữ liệu theo thứ tự tháng (nếu cần)
        for (int month = 1; month <= 12; month++) {
            String monthKey = "Tháng " + String.format("%02d", month); // Định dạng Tháng 01, Tháng 02, ...
            Double revenue = revenueData.getOrDefault(monthKey, 0.0); // Lấy doanh thu hoặc 0 nếu không có
            dataset.addValue(revenue, "Doanh Thu", monthKey); // Thêm vào dataset
        }

        // Tạo biểu đồ
        JFreeChart barChart = ChartFactory.createBarChart(
                "Thống Kê Doanh Thu Theo Năm",
                "Tháng",
                "Doanh Thu (VND)",
                dataset
        );

        // Hiển thị biểu đồ
        ChartPanel chart = new ChartPanel(barChart);
        chartPanel.removeAll();
        chartPanel.add(chart, BorderLayout.CENTER);
        chartPanel.validate();
        chartPanel.repaint();
    }


    
}
