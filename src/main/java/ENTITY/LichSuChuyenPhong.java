package ENTITY;

import java.sql.Date;

public class LichSuChuyenPhong {
    private String maChuyenPhong;
    private String phongCu;
    private String phongMoi;
    private String lyDo;
    private java.util.Date ngayChuyenPhong;

    
    public LichSuChuyenPhong() {
        // Constructor mặc định có thể để trống hoặc khởi tạo các giá trị mặc định nếu cần
    }
    // Constructor
    public LichSuChuyenPhong(String maChuyenPhong, String phongCu, String phongMoi, String lyDo, java.util.Date ngayChuyenPhong) {
        this.maChuyenPhong = maChuyenPhong;
        this.phongCu = phongCu;
        this.phongMoi = phongMoi;
        this.lyDo = lyDo;
        this.ngayChuyenPhong = ngayChuyenPhong;
    }

    // Getters and Setters
    public String getMaChuyenPhong() {
        return maChuyenPhong;
    }

    public void setMaChuyenPhong(String maChuyenPhong) {
        this.maChuyenPhong = maChuyenPhong;
    }

    public String getPhongCu() {
        return phongCu;
    }

    public void setPhongCu(String phongCu) {
        this.phongCu = phongCu;
    }

    public String getPhongMoi() {
        return phongMoi;
    }

    public void setPhongMoi(String phongMoi) {
        this.phongMoi = phongMoi;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public java.util.Date getNgayChuyenPhong() {
        return ngayChuyenPhong;
    }

    public void setNgayChuyenPhong(java.util.Date ngayChuyenPhong) {
        this.ngayChuyenPhong = ngayChuyenPhong;
    }
}
