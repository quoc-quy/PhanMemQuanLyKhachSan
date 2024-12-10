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
                document.add(new Paragraph("Hóa đơn khách sạn TQSN").setBold().setFontSize(18).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER));
                document.add(new Paragraph("\n"));

                // Lấy TableModel từ JTable
                TableModel model = table.getModel();

                // Tạo bảng để chứa thông tin hóa đơn
                Table pdfTable = new Table(2); // 2 cột: 1 cho tên thông tin và 1 cho giá trị

                // Các tên cột và giá trị từ dòng đã chọn
                String[] columnNames = {
                    "Mã hóa đơn", "Mã nhân viên", "Ngày lập", "Ngày nhận phòng", "Ngày trả phòng", "Tổng tiền"
                };

                
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
                pdfTable.addCell(new Cell().add(new Paragraph(columnNames[0])));
                pdfTable.addCell(new Cell().add(new Paragraph(maHoaDon)));
                pdfTable.addCell(new Cell().add(new Paragraph(columnNames[1])));
                pdfTable.addCell(new Cell().add(new Paragraph(maNhanVien)));
                pdfTable.addCell(new Cell().add(new Paragraph(columnNames[2])));
                pdfTable.addCell(new Cell().add(new Paragraph(ngayLap)));
                pdfTable.addCell(new Cell().add(new Paragraph(columnNames[3])));
                pdfTable.addCell(new Cell().add(new Paragraph(ngayNhanPhong)));
                pdfTable.addCell(new Cell().add(new Paragraph(columnNames[4])));
                pdfTable.addCell(new Cell().add(new Paragraph(ngayTraPhong)));
                pdfTable.addCell(new Cell().add(new Paragraph(columnNames[5])));
                pdfTable.addCell(new Cell().add(new Paragraph(tongTien)));

                // Thêm bảng vào document
                document.add(pdfTable);

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
