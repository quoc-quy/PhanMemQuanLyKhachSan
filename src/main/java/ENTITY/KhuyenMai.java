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
public class KhuyenMai {
    private String makhuyenMai;
    private String moTa;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private Boolean trangThai;
    private int chietKhau;
    
    public KhuyenMai(String makhuyenMai) {
		this.makhuyenMai = makhuyenMai;
	}

	public KhuyenMai(String makhuyenMai, String moTa, LocalDate ngayBatDau, LocalDate ngayKetThuc, Boolean trangThai, int chietKhau) {
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

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
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
        return "KhuyenMai{" + "makhuyenMai=" + makhuyenMai + ", moTa=" + moTa + ", ngayBatDau=" + ngayBatDau.format(formatter) + ", ngayKetThuc=" + ngayKetThuc.format(formatter) + ", trangThai=" + trangThai + ", chietKhau=" + dFormat.format(this.chietKhau) + '}';
    }
    
    
}
