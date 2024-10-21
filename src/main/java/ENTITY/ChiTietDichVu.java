/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author 84837
 */
public class ChiTietDichVu {
    private DichVu dichVu;
    private HoaDon hoaDon;
    private int soLuong;
    
    public ChiTietDichVu(){
        
    }

    public ChiTietDichVu(DichVu dichVu, HoaDon hoaDon, int soLuong) {
        this.dichVu = dichVu;
        this.hoaDon = hoaDon;
        this.soLuong = soLuong;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    } 

    @Override
    public String toString() {
        return "ChiTietDichVu{" + "dichVu=" + dichVu + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + '}';
    }
    
}
