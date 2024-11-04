/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.sql.Date;
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
    private java.util.Date ngayNhanPhong;
    private java.util.Date ngayTraPhong;
    private Double tienCoc;
    private String loaiHinh; 
    private java.util.Date gioCheckIn; 
    private java.util.Date gioCheckOut; 
    private Double tongTien;
    
    public PhieuDatPhong(){
        
    }

    

    public PhieuDatPhong(KhachHang khachHang, NhanVien nhanVienLap, Phong phong, java.util.Date ngayNhanPhong,
			java.util.Date ngayTraPhong, Double tienCoc, String loaiHinh, java.util.Date gioCheckIn, java.util.Date gioCheckOut,
			Double tongTien) {
		super();
		this.khachHang = khachHang;
		this.nhanVienLap = nhanVienLap;
		this.phong = phong;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.tienCoc = tienCoc;
		this.loaiHinh = loaiHinh;
		this.gioCheckIn = gioCheckIn;
		this.gioCheckOut = gioCheckOut;
		this.tongTien = tongTien;
	}



	public String getLoaiHinh() {
		return loaiHinh;
	}



	public void setLoaiHinh(String loaiHinh) {
		this.loaiHinh = loaiHinh;
	}



	public java.util.Date getGioCheckIn() {
		return gioCheckIn;
	}



	public void setGioCheckIn(java.util.Date gioCheckIn) {
		this.gioCheckIn = gioCheckIn;
	}



	public java.util.Date getGioCheckOut() {
		return gioCheckOut;
	}



	public void setGioCheckOut(java.util.Date gioCheckOut) {
		this.gioCheckOut = gioCheckOut;
	}



	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
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

    public java.util.Date getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(java.util.Date ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public java.util.Date getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(java.util.Date ngayTraPhong) {
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
		return "PhieuDatPhong [khachHang=" + khachHang + ", nhanVienLap=" + nhanVienLap + ", phong=" + phong
				+ ", ngayNhanPhong=" + ngayNhanPhong + ", ngayTraPhong=" + ngayTraPhong + ", tienCoc=" + tienCoc
				+ ", loaiHinh=" + loaiHinh + ", gioCheckIn=" + gioCheckIn + ", gioCheckOut=" + gioCheckOut
				+ ", tongTien=" + tongTien + "]";
	}

	
    
    
}
