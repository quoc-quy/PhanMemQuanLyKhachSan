package Components;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import ENTITY.HoaDon;
import ENTITY.KhachHang;

import javax.swing.*;
import javax.swing.table.TableModel;

import java.awt.Desktop;
import java.io.File;

public class ExportFile {
	
	public void exportInvoiceToPDF(HoaDon hd, String maPhong, String loaiPhong, String phuThu, String km, double tienPhong, double tienDV,KhachHang kh, TableModel tableModel) {
	    try {
	        // Đường dẫn lưu file
	        String directoryPath = "C:\\Users\\Admin\\OneDrive\\Máy tính\\HoaDon";
	        File directory = new File(directoryPath);

	        // Tạo thư mục nếu chưa tồn tại
	        if (!directory.exists()) {
	            directory.mkdirs();
	        }

	        String filePath = directoryPath + "\\hoaDon.pdf";
	        File file = new File(filePath);

	        try (PdfWriter writer = new PdfWriter(file);
	             PdfDocument pdf = new PdfDocument(writer);
	             Document document = new Document(pdf)) {

	            // Load font hỗ trợ Tiếng Việt
	            PdfFont font = null;
	            try {
	                font = PdfFontFactory.createFont("FONTS/Arial.ttf", PdfEncodings.IDENTITY_H);
	                System.out.println("Font loaded successfully!");
	            } catch (Exception e) {
	                e.printStackTrace();
	                System.out.println("Lỗi khi tải font: " + e.getMessage());
	            }

	            // Header thông tin công ty
	            document.add(new Paragraph("KHÁCH SẠN TQSN")
	                    .setFont(font)
	                    .setFontSize(18)
	                    .setBold()
	                    .setTextAlignment(TextAlignment.CENTER));
	            document.add(new Paragraph("12 Nguyễn Văn Bảo, Gò Vấp, TP. Hồ Chí Minh")
	                    .setFont(font)
	                    .setFontSize(10)
	                    .setTextAlignment(TextAlignment.CENTER));
	            document.add(new Paragraph("Hotline: 19002024 - 19002025")
	                    .setFont(font)
	                    .setFontSize(10)
	                    .setTextAlignment(TextAlignment.CENTER));
	            document.add(new Paragraph("Website: www.khachsanTQSN.com")
	                    .setFont(font)
	                    .setFontSize(10)
	                    .setTextAlignment(TextAlignment.CENTER));
	            document.add(new Paragraph("\n"));

	            // Tiêu đề hóa đơn
	            document.add(new Paragraph("HÓA ĐƠN THANH TOÁN")
	                    .setFont(font)
	                    .setBold()
	                    .setFontSize(20)
	                    .setTextAlignment(TextAlignment.CENTER));
	            document.add(new Paragraph("\n"));

	            // Bố trí thông tin khách hàng và hóa đơn
	            Table infoTable = new Table(new float[]{1, 1});
	            infoTable.setWidth(UnitValue.createPercentValue(100));

	            infoTable.addCell(new Cell().add(new Paragraph("Tên khách hàng: " + kh.getTenKhachHang()).setFont(font)).setBorder(Border.NO_BORDER));
	            infoTable.addCell(new Cell().add(new Paragraph("Số phòng: " + maPhong).setFont(font)).setBorder(Border.NO_BORDER));
	            infoTable.addCell(new Cell().add(new Paragraph("Ngày lập hóa đơn: " + hd.getNgayLap()).setFont(font)).setBorder(Border.NO_BORDER));
	            infoTable.addCell(new Cell().add(new Paragraph("Loại phòng: " + loaiPhong).setFont(font)).setBorder(Border.NO_BORDER));
	            infoTable.addCell(new Cell().add(new Paragraph("Mã hóa đơn: " + hd.getMaHoaDon()).setFont(font)).setBorder(Border.NO_BORDER));
	            infoTable.addCell(new Cell().add(new Paragraph("Ngày nhận phòng: " + hd.getNgayNhanPhong()).setFont(font)).setBorder(Border.NO_BORDER));
	            infoTable.addCell(new Cell().add(new Paragraph("Nhân viên: " + hd.getNhanVienLap().getTenNhanVien()).setFont(font)).setBorder(Border.NO_BORDER));
	            infoTable.addCell(new Cell().add(new Paragraph("Ngày trả phòng: " + hd.getNgayTraPhong()).setFont(font)).setBorder(Border.NO_BORDER));

	            document.add(infoTable);
	            document.add(new Paragraph("\n"));

	            // Bảng chi tiết dịch vụ	
	            float[] columnWidths = {1, 5, 2, 2, 2}; // Đặt độ rộng cho 5 cột
	            Table table = new Table(columnWidths);
	            table.setWidth(UnitValue.createPercentValue(100));

	            table.addHeaderCell(new Cell().add(new Paragraph("STT").setFont(font).setBold()));
	            table.addHeaderCell(new Cell().add(new Paragraph("Tên dịch vụ").setFont(font).setBold()));
	            table.addHeaderCell(new Cell().add(new Paragraph("Đơn giá").setFont(font).setBold()));
	            table.addHeaderCell(new Cell().add(new Paragraph("Số lượng").setFont(font).setBold()));
	            table.addHeaderCell(new Cell().add(new Paragraph("Thành tiền").setFont(font).setBold()));

	            for (int i = 0; i < tableModel.getRowCount(); i++) {
	                table.addCell(new Cell().add(new Paragraph(tableModel.getValueAt(i, 0).toString()).setFont(font)));
	                table.addCell(new Cell().add(new Paragraph(tableModel.getValueAt(i, 1).toString()).setFont(font)));
	                table.addCell(new Cell().add(new Paragraph(tableModel.getValueAt(i, 3).toString()).setFont(font)));
	                table.addCell(new Cell().add(new Paragraph(tableModel.getValueAt(i, 2).toString()).setFont(font)));
	                table.addCell(new Cell().add(new Paragraph(tableModel.getValueAt(i, 4).toString()).setFont(font)));
	            }
	            document.add(table);

	            // Tiền phòng
	            document.add(new Paragraph("\n"));
	            document.add(new Paragraph("Tiền phòng: " + tienPhong + " VNĐ")
	                    .setFont(font)
	                    .setBold()
	                    .setTextAlignment(TextAlignment.RIGHT).setFixedLeading(12f));

	            // Tiền dịch vụ
	            document.add(new Paragraph("\n"));
	            document.add(new Paragraph("Tiền dịch vụ: " + tienDV + " VNĐ")
	                    .setFont(font)
	                    .setBold()
	                    .setTextAlignment(TextAlignment.RIGHT).setFixedLeading(12f));

	            // phụ thu
	            document.add(new Paragraph("\n"));
	            document.add(new Paragraph("Phụ thu: " + phuThu + " VNĐ")
	                    .setFont(font)
	                    .setBold()
	                    .setTextAlignment(TextAlignment.RIGHT).setFixedLeading(12f));

	            // Khuyến mãi
	            document.add(new Paragraph("\n"));
	            document.add(new Paragraph("Khuyến mãi: " + km + "%")
	                    .setFont(font)
	                    .setBold()
	                    .setTextAlignment(TextAlignment.RIGHT).setFixedLeading(12f));

	            // Thuế
	            document.add(new Paragraph("\n"));
	            document.add(new Paragraph("Thuế: " + hd.getThue() + " %")
	                    .setFont(font)
	                    .setBold()
	                    .setTextAlignment(TextAlignment.RIGHT).setFixedLeading(12f));

	            // Tổng tiền
	            document.add(new Paragraph("\n"));
	            document.add(new Paragraph("Tổng tiền: " + hd.getTongTien() + " VNĐ")
	                    .setFont(font)
	                    .setBold()
	                    .setFontSize(16)
	                    .setTextAlignment(TextAlignment.RIGHT));

	            // Cảm ơn khách hàng
	            document.add(new Paragraph("\n"));
	            document.add(new Paragraph("CẢM ƠN QUÝ KHÁCH!")
	                    .setFont(font)
	                    .setFontSize(20)
	                    .setBold()
	                    .setTextAlignment(TextAlignment.CENTER));

	            JOptionPane.showMessageDialog(null, "Xuất hóa đơn thành công tại: " + filePath);

	            // Mở file PDF sau khi xuất
	            if (Desktop.isDesktopSupported()) {
	                Desktop desktop = Desktop.getDesktop();
	                desktop.open(file);
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Lỗi khi xuất hóa đơn: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}


	public void openPdfFile(String filePath) {
	    try {
	        File file = new File(filePath);
	        if (!file.exists()) {
	            System.out.println("File does not exist: " + filePath);
	            return;
	        }

	        if (Desktop.isDesktopSupported()) {
	            Desktop desktop = Desktop.getDesktop();
	            desktop.open(file); // Mở file PDF
	        } else {
	            System.out.println("Desktop is not supported on this system.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Lỗi khi mở file PDF: " + e.getMessage());
	    }
	}
	public void printPdfFile(String filePath) {
	    try {
	        File file = new File(filePath);
	        if (!file.exists()) {
	            System.out.println("File does not exist: " + filePath);
	            return;
	        }

	        if (Desktop.isDesktopSupported()) {
	            Desktop desktop = Desktop.getDesktop();
	            desktop.print(file); // In file PDF
	        } else {
	            System.out.println("Desktop is not supported on this system.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Lỗi khi in file PDF: " + e.getMessage());
	    }
	}
	
//    public void exportToPDF(JTable table) {
//        // Lấy dòng được chọn trong JTable
//        int selectedRow = table.getSelectedRow();
//        if (selectedRow == -1) {
//            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xuất.");
//            return;
//        }
//
//        // Mở hộp thoại chọn thư mục lưu file
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setDialogTitle("Chọn nơi lưu file PDF");
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Chỉ cho phép chọn thư mục
//
//        int userSelection = fileChooser.showSaveDialog(null);
//        if (userSelection == JFileChooser.APPROVE_OPTION) {
//            // Lấy thư mục và tạo đường dẫn cho file PDF
//            File directory = fileChooser.getSelectedFile();
//            String filePath = directory.getAbsolutePath() + "/HoaDon.pdf"; // Tên file PDF
//
//            // Khởi tạo file PDF
//            try {
//                // Tạo PdfWriter
//                PdfWriter writer = new PdfWriter(filePath);
//                // Khởi tạo PdfDocument
//                PdfDocument pdf = new PdfDocument(writer);
//                // Tạo document
//                Document document = new Document(pdf);
//
//                // Tạo tiêu đề cho hóa đơn
//                PdfFont arialFont = PdfFontFactory.createFont("/FONTS/Arial.ttf", PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
//
//                // Áp dụng font Arial cho các đoạn văn bản
//                document.add(new Paragraph("Khách sạn TQSN - Phục vụ tận tình")
//                    .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
//                
//                document.add(new Paragraph("12 Nguyễn Văn Bảo, phường 4, Gò Vấp, thành phố Hồ Chí Minh")
//                    .setItalic().setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
//                
//                document.add(new Paragraph("Hotline: 19002024 - 19002025")
//                    .setItalic().setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
//                
//                document.add(new Paragraph("Website: www.khachsanTQSN.com")
//                    .setItalic().setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
//                
//                document.add(new Paragraph("\n"));
//                
//                document.add(new Paragraph("HÓA ĐƠN THANH TOÁN")
//                    .setBold().setFontSize(25).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER).setFont(arialFont));
//                document.add(new Paragraph("_____________________________________________________________________________")).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
//                	
//                document.add(new Paragraph("\n"));
//                // Lấy TableModel từ JTable
//                TableModel model = table.getModel();
//
//                // Tạo bảng để chứa thông tin hóa đơn
//                
//                
//
//                // Các tên cột và giá trị từ dòng đã chọn
//                PdfFont arialFont1 = null;
//                try {
//                    arialFont1 = PdfFontFactory.createFont("/FONTS/Arial.ttf", PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    JOptionPane.showMessageDialog(null, "Không thể tải font Arial.");
//                    return;
//                }
//
//                
//                
//               
//                // Định dạng ngày
//                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//                // Lấy dữ liệu từ dòng đã chọn
//                String maHoaDon = model.getValueAt(selectedRow, 0).toString();
//                String tenKhachHang = model.getValueAt(selectedRow, 1).toString();
//                String tenNhanVien = model.getValueAt(selectedRow, 2).toString();
//                String ngayLap = model.getValueAt(selectedRow, 3).toString(); 
//                String ngayNhanPhong = model.getValueAt(selectedRow, 4).toString();
//                String ngayTraPhong = model.getValueAt(selectedRow, 5).toString();
//                String tienTraKhach = model.getValueAt(selectedRow, 6).toString();
//                String thue = model.getValueAt(selectedRow, 7).toString();
//                String tongTien = model.getValueAt(selectedRow, 8).toString();
//                
//
//                // Thêm các giá trị vào bảng PDF
//                document.add(new Paragraph("Mã hóa đơn:        " + maHoaDon)
//                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
//                document.add(new Paragraph("Tên khách hàng:        " + tenKhachHang)
//                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
//                document.add(new Paragraph("Tên nhân viên lập:        " + tenNhanVien)
//                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
//                document.add(new Paragraph("Ngày lập hóa đơn:        " + ngayLap)
//                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
//                document.add(new Paragraph("Ngày nhận phòng:        " + ngayNhanPhong)
//                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
//                document.add(new Paragraph("Ngày trả phòng:        " + ngayTraPhong)
//                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
//                document.add(new Paragraph("_____________________________________________________________________________")).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
//                
//                document.add(new Paragraph("\n"));
//                document.add(new Paragraph("Thuế VAT:        " + thue + "%")
//                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
//                
//                document.add(new Paragraph("Tổng tiền thanh toán:        " + tongTien)
//                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
//                
//                document.add(new Paragraph("Tiền thối cho khách:        " + tienTraKhach)
//                        .setBold().setFontSize(13).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT).setFont(arialFont));
//                document.add(new Paragraph("_____________________________________________________________________________")).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
//                
//                document.add(new Paragraph("\n"));
//                document.add(new Paragraph("Thông tin thanh toán")
//                        .setBold().setFontSize(15).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
//                    
//                    document.add(new Paragraph("Ngân hàng: Ngân hàng thương mai cổ phần Ngoại thương Việt Nam")
//                        .setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
//                    
//                    document.add(new Paragraph("Tên tài khoản: Nguyễn Văn A")
//                            .setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
//                    
//                    document.add(new Paragraph("Số tài khoản: 0123456771991")
//                            .setFontSize(12).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT).setFont(arialFont));
//                    document.add(new Paragraph("\n"));
//                    document.add(new Paragraph("XIN CẢM ƠN QÚY KHÁCH !!!")
//                            .setBold().setFontSize(25).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER).setFont(arialFont));
//                // Đóng document
//                document.close();
//
//                // Thông báo thành công
//                JOptionPane.showMessageDialog(null, "Đã xuất file PDF thành công!");
//            } catch (IOException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi xuất file PDF.");
//            }
//        }
//    }
}
