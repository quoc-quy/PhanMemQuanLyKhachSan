/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author 84837
 */
public class KhuyenMai {
    private String makhuyenMai;
    private String moTa;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String trangThai;
    private int chietKhau;
    
    public KhuyenMai(String makhuyenMai) {
		this.makhuyenMai = makhuyenMai;
	}

	public KhuyenMai(String makhuyenMai, String moTa, Date ngayBatDau, Date ngayKetThuc, String trangThai, int chietKhau) {
        this.makhuyenMai = makhuyenMai;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.chietKhau = chietKhau;
    }

    public String getMakhuyenMai() {
        return makhuyenMai;
    }

    public void setMakhuyenMai(String makhuyenMai) {
        this.makhuyenMai = makhuyenMai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(int chietKhau) {
        this.chietKhau = chietKhau;
    }
    
    

    @Override
    public String toString() {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat dFormat = new DecimalFormat("#,###.##$");
        return "KhuyenMai{" + "makhuyenMai=" + makhuyenMai + ", moTa=" + moTa + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", trangThai=" + trangThai + ", chietKhau=" + dFormat.format(this.chietKhau) + '}';
    }
    
    
}
