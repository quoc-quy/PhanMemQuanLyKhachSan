//package Components;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import javax.swing.*;
//import javax.swing.table.TableModel;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class ExportFile {
//	 public void exportToExcel(JTable table, String filePath) {
//	        Workbook workbook = new XSSFWorkbook(); // Tạo workbook Excel mới
//	        Sheet sheet = workbook.createSheet("HoaDon"); // Tạo sheet mới
//
//	        TableModel model = table.getModel();
//
//	        // Tạo tiêu đề (header) cho sheet
//	        Row headerRow = sheet.createRow(0);
//	        for (int i = 0; i < model.getColumnCount(); i++) {
//	            Cell cell = headerRow.createCell(i);
//	            cell.setCellValue(model.getColumnName(i)); // Đặt tên cột
//	        }
//
//	        // Điền dữ liệu từ JTable vào sheet
//	        for (int i = 0; i < model.getRowCount(); i++) {
//	            Row row = sheet.createRow(i + 1);
//	            for (int j = 0; j < model.getColumnCount(); j++) {
//	                Cell cell = row.createCell(j);
//	                Object value = model.getValueAt(i, j);
//	                if (value != null) {
//	                    cell.setCellValue(value.toString()); // Ghi dữ liệu vào ô Excel
//	                }
//	            }
//	        }
//
//	        // Ghi workbook vào file Excel
//	        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
//	            workbook.write(outputStream);
//	            JOptionPane.showMessageDialog(null, "Xuất file Excel thành công!");
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            JOptionPane.showMessageDialog(null, "Lỗi khi xuất file Excel.");
//	        } finally {
//	            try {
//	                workbook.close();
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	    }
//}
