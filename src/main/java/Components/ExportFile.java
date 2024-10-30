package Components;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportFile {
	// Phương thức xuất dữ liệu từ JTable sang Excel
    public void exportToExcel(JTable table) {
        JFileChooser fileChooser = new JFileChooser(); // Hộp thoại chọn thư mục
        fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Chỉ cho phép chọn thư mục

        int userSelection = fileChooser.showSaveDialog(null); // Hiển thị hộp thoại

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn thư mục mà người dùng đã chọn
            File directory = fileChooser.getSelectedFile();
            String filePath = directory.getAbsolutePath() + "/HoaDon.xlsx"; // Tạo tên file

            Workbook workbook = new XSSFWorkbook(); // Khởi tạo Workbook Excel
            Sheet sheet = workbook.createSheet("HoaDon"); // Tạo sheet mới

            TableModel model = table.getModel();

            // Tạo tiêu đề (header) cho sheet Excel
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(model.getColumnName(i));
            }

            // Điền dữ liệu từ JTable vào sheet Excel
            for (int i = 0; i < model.getRowCount(); i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Cell cell = row.createCell(j);
                    Object value = model.getValueAt(i, j);
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    }
                }
            }

            // Ghi Workbook vào file Excel
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream); // Ghi dữ liệu vào file
                JOptionPane.showMessageDialog(null, "Xuất file Excel thành công tại: " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi xuất file Excel.");
            } finally {
                try {
                    workbook.close(); // Đóng Workbook
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã hủy xuất file.");
        }
    }
}
