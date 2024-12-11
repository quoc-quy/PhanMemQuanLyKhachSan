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
                
                PdfFont arialFont = PdfFontFactory.createFont("/FONTS/Arial.ttf", PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);

                // Lấy model dữ liệu của bảng JTable
                TableModel model = table.getModel();

                // Tạo bảng PDF từ dữ liệu trong JTable
                Table pdfTable = new Table(model.getColumnCount());

                // Thêm tiêu đề cột
                for (int i = 0; i < model.getColumnCount(); i++) {
                    pdfTable.addHeaderCell(new Cell().add(new Paragraph(model.getColumnName(i))));
                }

                // Thêm dữ liệu của từng dòng trong bảng
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Object cellValue = model.getValueAt(row, col);
                        pdfTable.addCell(new Cell().add(new Paragraph(cellValue.toString())));
                    }
                }

                // Thêm bảng vào tài liệu PDF
                document.add(pdfTable);
                document.close();

                JOptionPane.showMessageDialog(null, "Đã xuất file thành công");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi khi xuất file: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hủy bỏ xuất file.");
        }
    }
}
