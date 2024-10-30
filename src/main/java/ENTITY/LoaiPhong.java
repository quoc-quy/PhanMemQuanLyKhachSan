/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;


/**
 *
 * @author 84837
 */
public class LoaiPhong {
    private String maLoaiPhong;
    private String tenLoaiPhong;
    private Double giaTienTheoGio;
    private Double giaTienTheoNgay;
    private boolean tinhTheoNgay;
    private String moTaPhong;
    
    public LoaiPhong(){
    }

    

    public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, Double giaTienTheoGio, Double giaTienTheoNgay,
			boolean tinhTheoNgay, String moTaPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.giaTienTheoGio = giaTienTheoGio;
		this.giaTienTheoNgay = giaTienTheoNgay;
		this.tinhTheoNgay = tinhTheoNgay;
		this.moTaPhong = moTaPhong;
	}



	public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }
    

    public Double getGiaTienTheoGio() {
		return giaTienTheoGio;
	}

	public void setGiaTienTheoGio(Double giaTienTheoGio) {
		this.giaTienTheoGio = giaTienTheoGio;
	}

	public Double getGiaTienTheoNgay() {
		return giaTienTheoNgay;
	}

	public void setGiaTienTheoNgay(Double giaTienTheoNgay) {
		this.giaTienTheoNgay = giaTienTheoNgay;
	}

	public boolean isTinhTheoNgay() {
		return tinhTheoNgay;
	}

	public void setTinhTheoNgay(boolean tinhTheoNgay) {
		this.tinhTheoNgay = tinhTheoNgay;
	}
	
	

	public String getMoTaPhong() {
		return moTaPhong;
	}



	public void setMoTaPhong(String moTaPhong) {
		this.moTaPhong = moTaPhong;
	}



	@Override
	public String toString() {
		return "LoaiPhong [maLoaiPhong=" + maLoaiPhong + ", tenLoaiPhong=" + tenLoaiPhong + ", giaTienTheoGio="
				+ giaTienTheoGio + ", giaTienTheoNgay=" + giaTienTheoNgay + ", tinhTheoNgay=" + tinhTheoNgay + "]";
	}

	
    
    
}
