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
    SACH("Phong da duoc don sach se"), CHUA_DON("Phong chua duoc ve sinh sach se");
    
    private String tinhTrangPhong;

    TinhTrangPhong(String tinhTrangPhong) {
        this.tinhTrangPhong = tinhTrangPhong;
    }

    @Override
    public String toString() {
        return tinhTrangPhong;
    }
}

