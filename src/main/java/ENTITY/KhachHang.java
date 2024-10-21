/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.util.Objects;

/**
 *
 * @author 84837
 */
public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String CCCD;
    private String phai;
    private String dienThoai;
    
    public KhachHang(){
        this("", "", "", "", "");
    }

    public KhachHang(String maKhachHang, String tenKhachHang, String CCCD, String phai, String dienThoai) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.CCCD = CCCD;
        this.phai = phai;
        this.dienThoai = dienThoai;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKhachHang);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.maKhachHang, other.maKhachHang);
    }
    
    

    @Override
    public String toString() {
        return "KhachHang{" + "maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", CCCD=" + CCCD + ", phai=" + phai + ", dienThoai=" + dienThoai + '}';
    }
    
    
}
