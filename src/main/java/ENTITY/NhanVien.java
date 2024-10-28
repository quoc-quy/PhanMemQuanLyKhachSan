/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author 84837
 */
public class NhanVien {
    
    private String maNhanVien;
    private String tenNhanVien;
    private LoaiNhanVien loaiNhanVien;
    private String phai;
    private LocalDate ngaySinh;
    private String password;
    private String CCCD;
    private String soDienThoai;
    private String trangThai;
    
    public NhanVien(){
        this("", "", LoaiNhanVien.NV_LETAN, "", LocalDate.now(), "", "", "", "");
    }

    public NhanVien(String maNhanVien, String tenNhanVien, LoaiNhanVien loaiNhanVien, String phai, LocalDate ngaySinh, String password, String CCCD, String soDienThoai, String trangThai) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.loaiNhanVien = loaiNhanVien;
        this.phai = phai;
        this.ngaySinh = ngaySinh;
        this.password = password;
        this.CCCD = CCCD;
        this.soDienThoai = soDienThoai;
        this.trangThai = trangThai;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public LoaiNhanVien getLoaiNhanVien() {
        return loaiNhanVien;
    }

    public void setLoaiNhanVien(LoaiNhanVien loaiNhanVien) {
        this.loaiNhanVien = loaiNhanVien;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhanVien);
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
        final NhanVien other = (NhanVien) obj;
        return Objects.equals(this.maNhanVien, other.maNhanVien);
    }
    
    

    @Override
    public String toString() {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat dFormat = new DecimalFormat("#,###.##$");
        return "NhanVien{" + "maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", loaiNhanVien=" + loaiNhanVien + ", phai=" + phai + ", ngaySinh=" + ngaySinh.format(formatter) + ", password=" + password + ", CCCD=" + CCCD + ", soDienThoai=" + soDienThoai + ", trangThai=" + trangThai + '}';
    }
}
