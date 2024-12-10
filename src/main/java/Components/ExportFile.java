package Components;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ExportFile {

    public void exportToPDF(JTable table) {
        // Lấy dòng được chọn trong JTable
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xuất.");
            return;
        }

        // Mở hộp thoại chọn thư mục lưu file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file PDF");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Chỉ cho phép chọn thư mục

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Lấy thư mục và tạo đường dẫn cho file PDF
            File directory = fileChooser.getSelectedFile();
            String filePath = directory.getAbsolutePath() + "/HoaDon.pdf"; // Tên file PDF

            // Khởi tạo file PDF
            try {
                // Tạo PdfWriter
                PdfWriter writer = new PdfWriter(filePath);
                // Khởi tạo PdfDocument
                PdfDocument pdf = new PdfDocument(writer);
                // Tạo document
                Document document = new Document(pdf);

                // Tạo tiêu đề cho hóa đơn
                PdfFont arialFont = PdfFontFactory.createFont("/FONTS/Arial.ttf", PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);

                // Áp dụng font Arial cho các đoạn văn bản
                document.add(new Paragraph("Khách sạn TQSN - Phục vụ tận tình")
                    .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
                
                document.add(new Paragraph("12 Nguyễn Văn Bảo, phường 4, Gò Vấp, thành phố Hồ Chí Minh")
                    .setItalic().setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
                
                document.add(new Paragraph("Hotline: 19002024 - 19002025")
                    .setItalic().setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
                
                document.add(new Paragraph("Website: www.khachsanTQSN.com")
                    .setItalic().setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
                
                document.add(new Paragraph("\n"));
                
                document.add(new Paragraph("HÓA ĐƠN THANH TOÁN")
                    .setBold().setFontSize(25).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER).setFont(arialFont));
                document.add(new Paragraph("_____________________________________________________________________________")).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
                	
                document.add(new Paragraph("\n"));
                // Lấy TableModel từ JTable
                TableModel model = table.getModel();

                // Tạo bảng để chứa thông tin hóa đơn
                
                

                // Các tên cột và giá trị từ dòng đã chọn
                PdfFont arialFont1 = null;
                try {
                    arialFont1 = PdfFontFactory.createFont("/FONTS/Arial.ttf", PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Không thể tải font Arial.");
                    return;
                }

                
                
               
                // Định dạng ngày
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                // Lấy dữ liệu từ dòng đã chọn
                String maHoaDon = model.getValueAt(selectedRow, 0).toString();
                String maNhanVien = model.getValueAt(selectedRow, 1).toString();
                String ngayLap = model.getValueAt(selectedRow, 2).toString(); 
                String ngayNhanPhong = model.getValueAt(selectedRow, 3).toString();
                String ngayTraPhong = model.getValueAt(selectedRow, 4).toString();
                String tongTien = model.getValueAt(selectedRow, 5).toString();
                

                // Thêm các giá trị vào bảng PDF
                document.add(new Paragraph("Mã hóa đơn:        " + maHoaDon)
                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
                document.add(new Paragraph("Mã nhân viên lập:        " + maNhanVien)
                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
                document.add(new Paragraph("Ngày lập hóa đơn:        " + ngayLap)
                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
                document.add(new Paragraph("Ngày nhận phòng:        " + ngayNhanPhong)
                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
                document.add(new Paragraph("Ngày trả phòng:        " + ngayTraPhong)
                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
                document.add(new Paragraph("_____________________________________________________________________________")).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
                
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Tổng tiền thanh toán:        " + tongTien)
                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
                
                document.add(new Paragraph("Thông tin thanh toán")
                        .setBold().setFontSize(15).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
                    
                    document.add(new Paragraph("Ngân hàng: Ngân hàng thương mai cổ phần Ngoại thương Việt Nam")
                        .setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
                    
                    document.add(new Paragraph("Tên tài khoản: Nguyễn Văn A")
                            .setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
                    
                    document.add(new Paragraph("Số tài khoản: 0123456771991")
                            .setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
                    document.add(new Paragraph("\n"));
                    document.add(new Paragraph("XIN CẢM ƠN QÚY KHÁCH !!!")
                            .setBold().setFontSize(25).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER).setFont(arialFont));
                // Đóng document
                document.close();

                // Thông báo thành công
                JOptionPane.showMessageDialog(null, "Đã xuất file PDF thành công!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi xuất file PDF.");
            }
        }
    }
}
