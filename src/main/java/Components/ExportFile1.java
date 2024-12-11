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

public class ExportFile1 {

    public void exportToPDF(JTable table) {
        // Mở hộp thoại chọn thư mục lưu file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file PDF");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Chỉ chọn thư mục
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            String filePath = selectedDirectory.getAbsolutePath() + "/TatCaHoaDon.pdf";

            try {
                // Tạo đối tượng PdfDocument để ghi vào file PDF
                PdfWriter writer = new PdfWriter(filePath);
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);

                // Sử dụng font Arial từ tệp .ttf
                PdfFont arialFont = PdfFontFactory.createFont("FONTS/Arial.ttf", PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);

                // Thêm tiêu đề cho file PDF
                document.add(new Paragraph("DANH SÁCH HÓA ĐƠN").setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER).setFont(arialFont).setFontSize(25).setBold());
                document.add(new Paragraph("\n"));
                // Tạo bảng từ JTable
                TableModel model = table.getModel();
                int columnCount = model.getColumnCount();
                Table pdfTable = new Table(columnCount);

                // Thêm tiêu đề cột vào bảng PDF
                for (int col = 0; col < columnCount; col++) {
                    pdfTable.addCell(new Cell().add(new Paragraph(model.getColumnName(col)).setFont(arialFont).setFontSize(12)));
                }

                // Thêm các dòng dữ liệu vào bảng PDF
                int rowCount = model.getRowCount();
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < columnCount; col++) {
                        pdfTable.addCell(new Cell().add(new Paragraph(model.getValueAt(row, col).toString()).setFont(arialFont).setFontSize(12)));
                    }
                }

                // Thêm bảng vào file PDF
                document.add(pdfTable);

                // Đóng tài liệu
                document.close();

                JOptionPane.showMessageDialog(null, "File PDF đã được xuất thành công!");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi xuất file PDF: " + e.getMessage());
            }
        }
    }
}
