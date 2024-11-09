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
    private String maPDP;
    private KhachHang khachHang;
    private NhanVien nhanVienLap;
    private Phong phong;
    private java.util.Date ngayNhanPhong;
    private java.util.Date ngayTraPhong;
    private Double tienCoc;
    private String loaiHinh; 
    private String gioNhanPhong;
    private String gioTraPhong;
    private Double tongTien;
    private String trangThai;
    
    public PhieuDatPhong(){
        
    }
    
    

	public PhieuDatPhong(String  maPDP,KhachHang khachHang, NhanVien nhanVienLap, Phong phong, java.util.Date ngayNhanPhong,
			java.util.Date ngayTraPhong, Double tienCoc, String loaiHinh, String gioNhanPhong, String gioTraPhong,
			Double tongTien, String trangThai) {
		super();
		this.maPDP = maPDP;
		this.khachHang = khachHang;
		this.nhanVienLap = nhanVienLap;
		this.phong = phong;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.tienCoc = tienCoc;
		this.loaiHinh = loaiHinh;
		this.gioNhanPhong = gioNhanPhong;
		this.gioTraPhong = gioTraPhong;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}

	

	public String getMaPDP() {
		return maPDP;
	}


	public void setMaPDP(String maPDP) {
		this.maPDP = maPDP;
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

	public String getLoaiHinh() {
		return loaiHinh;
	}

	public void setLoaiHinh(String loaiHinh) {
		this.loaiHinh = loaiHinh;
	}

	public String getGioNhanPhong() {
		return gioNhanPhong;
	}

	public void setGioNhanPhong(String gioNhanPhong) {
		this.gioNhanPhong = gioNhanPhong;
	}

	public String getGioTraPhong() {
		return gioTraPhong;
	}

	public void setGioTraPhong(String gioTraPhong) {
		this.gioTraPhong = gioTraPhong;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "PhieuDatPhong [maPDP=" + maPDP + ", khachHang=" + khachHang + ", nhanVienLap=" + nhanVienLap
				+ ", phong=" + phong + ", ngayNhanPhong=" + ngayNhanPhong + ", ngayTraPhong=" + ngayTraPhong
				+ ", tienCoc=" + tienCoc + ", loaiHinh=" + loaiHinh + ", gioNhanPhong=" + gioNhanPhong
				+ ", gioTraPhong=" + gioTraPhong + ", tongTien=" + tongTien + ", trangThai=" + trangThai + "]";
	}

    
}
