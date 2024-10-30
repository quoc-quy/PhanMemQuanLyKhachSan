/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author 84837
 */
public class ChiTietHoaDon {
    private HoaDon hoaDon;
    private Phong phong;
    private int soLuong;
    
    public ChiTietHoaDon(){
        this.soLuong = 0;
    }

    public ChiTietHoaDon(HoaDon hoaDon, Phong phong, int soLuong) {
        this.hoaDon = hoaDon;
        this.phong = phong;
        this.soLuong = soLuong;
    }
    

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
 // Phương thức tính tiền phòng
    public double tinhTienPhong() {
        double tienPhong = 0;

        // Kiểm tra nếu phòng có giá theo ngày
        if (phong.getLoaiPhong().isTinhTheoNgay()) {
            tienPhong = phong.getLoaiPhong().getGiaTienTheoNgay() * soLuong;
        } 
        // Nếu phòng tính giá theo giờ
        else {
            tienPhong = phong.getLoaiPhong().getGiaTienTheoGio() * soLuong;
        }

        return tienPhong;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "hoaDon=" + hoaDon + ", phong=" + phong + ", soLuong=" + soLuong + '}';
    }
    
    
}
