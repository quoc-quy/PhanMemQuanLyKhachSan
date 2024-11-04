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
public class Phong {
    private String maPhong;
    private LoaiPhong loaiPhong;
    private int soNguoiLon;
    private int soTreEm;
    private TrangThaiPhong trangThaiPhong;
    private TinhTrangPhong tinhTrangPhong;
    
    public Phong(String maPhong){
    	this.maPhong = maPhong;
    }


    public Phong(){
    }

    public Phong(String maPhong, LoaiPhong loaiPhong, int soNguoiLon, int soTreEm, TrangThaiPhong trangThaiPhong,
			TinhTrangPhong tinhTrangPhong) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.soNguoiLon = soNguoiLon;
		this.soTreEm = soTreEm;
		this.trangThaiPhong = trangThaiPhong;
		this.tinhTrangPhong = tinhTrangPhong;
	}



	public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public TrangThaiPhong getTrangThaiPhong() {
        return trangThaiPhong;
    }

    public void setTrangThaiPhong(TrangThaiPhong trangThaiPhong) {
        this.trangThaiPhong = trangThaiPhong;
    }

    public TinhTrangPhong getTinhTrangPhong() {
        return tinhTrangPhong;
    }

    public void setTinhTrangPhong(TinhTrangPhong tinhTrangPhong) {
        this.tinhTrangPhong = tinhTrangPhong;
    }
    

    public int getSoNguoiLon() {
		return soNguoiLon;
	}

	public void setSoNguoiLon(int soNguoiLon) {
		this.soNguoiLon = soNguoiLon;
	}

	public int getSoTreEm() {
		return soTreEm;
	}

	public void setSoTreEm(int soTreEm) {
		this.soTreEm = soTreEm;
	}

	@Override
    public int hashCode() {
        return Objects.hash(maPhong);
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
        final Phong other = (Phong) obj;
        return Objects.equals(this.maPhong, other.maPhong);
    }



	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", loaiPhong=" + loaiPhong + ", soNguoiLon=" + soNguoiLon + ", soTreEm="
				+ soTreEm + ", trangThaiPhong=" + trangThaiPhong + ", tinhTrangPhong=" + tinhTrangPhong + "]";
	}

    
}
