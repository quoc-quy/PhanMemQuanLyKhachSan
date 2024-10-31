/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author 84837
 */
public enum TinhTrangPhong {
    SACH("Sạch"), CHUA_DON("Chưa dọn");
    
    private String tinhTrangPhong;

    TinhTrangPhong(String tinhTrangPhong) {
        this.tinhTrangPhong = tinhTrangPhong;
    }

    @Override
    public String toString() {
        return tinhTrangPhong;
    }
}

