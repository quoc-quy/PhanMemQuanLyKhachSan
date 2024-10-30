/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ENTITY;

/**
 *
 * @author 84837
 */
public enum TrangThaiPhong {
    DANG_SU_DUNG("Phong dang duoc su dung"), PHONG_TRONG("Phong trong");
    
    private String trangThaiPhong;

    TrangThaiPhong(String trangThaiPhong) {
        this.trangThaiPhong = trangThaiPhong;
    }

    @Override
    public String toString() {
        return trangThaiPhong;
    }
}
