/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 84837
 */
public class DichVu {
    private String maDichvu;
    private String tenDichVu;
    private int soLuong;
    private Double donGia;
    private String donViTinh;
    
    public DichVu(){
        this("", "", 0, 0.0, "");
    }

    public DichVu(String maDichvu, String tenDichVu, int soLuong, Double donGia, String donViTinh) {
        this.maDichvu = maDichvu;
        this.tenDichVu = tenDichVu;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
    }

    public String getMaDichvu() {
        return maDichvu;
    }

    public void setMaDichvu(String maDichvu) {
        this.maDichvu = maDichvu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat dFormat = new DecimalFormat("#,###.##$");
        return "DichVu{" + "maDichvu=" + maDichvu + ", tenDichVu=" + tenDichVu + ", soLuong=" + soLuong + ", donGia=" + dFormat.format(this.donGia) + ", donViTinh=" + donViTinh + '}';
    }
    
    
}
