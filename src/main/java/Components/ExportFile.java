package Components;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;

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

                // Lấy TableModel từ JTable
                TableModel model = table.getModel();
                
                // Lấy dữ liệu từ dòng đã chọn
                StringBuilder data = new StringBuilder();
                for (int i = 0; i < model.getColumnCount(); i++) {
                    data.append(model.getColumnName(i)).append(": ")
                        .append(model.getValueAt(selectedRow, i)).append("\n");
                }

                // Tạo một đoạn văn bản với dữ liệu dòng đã chọn
                Paragraph paragraph = new Paragraph(data.toString())
                        
                        .setFontSize(12);

                // Thêm đoạn văn vào document
                document.add(paragraph);
                
                // Đóng document
                document.close();

                JOptionPane.showMessageDialog(null, "Xuất PDF thành công!");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi tạo file PDF.");
            }
        }
    }
}
