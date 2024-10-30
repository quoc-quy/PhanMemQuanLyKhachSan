/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 84837
 */
public class PhieuDatPhong {
    private KhachHang khachHang;
    private NhanVien nhanVienLap;
    private Phong phong;
    private LocalDate ngayNhanPhong;
    private LocalDate ngayTraPhong;
    private Double tienCoc;
    
    public PhieuDatPhong(){
        
    }

    public PhieuDatPhong(KhachHang khachHang, NhanVien nhanVienLap, Phong phong, LocalDate ngayNhanPhong, LocalDate ngayTraPhong, Double tienCoc) {
        this.khachHang = khachHang;
        this.nhanVienLap = nhanVienLap;
        this.phong = phong;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.tienCoc = tienCoc;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVienLap() {
        return nhanVienLap;
    }

    public void setNhanVienLap(NhanVien nhanVienLap) {
        this.nhanVienLap = nhanVienLap;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public LocalDate getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(LocalDate ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public LocalDate getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(LocalDate ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }
    
    public Double getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(Double tienCoc) {
		this.tienCoc = tienCoc;
	}

	@Override
    public String toString() {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat dFormat = new DecimalFormat("#,###.##$");
        return "PhieuDatPhong{" + "khachHang=" + khachHang + ", nhanVienLap=" + nhanVienLap + ", phong=" + phong + ", ngayNhanPhong=" + ngayNhanPhong.format(formatter) + ", ngayTraPhong=" + ngayTraPhong.format(formatter) + ", tienCoc=" + tienCoc +'}';
    }
    
    
}
