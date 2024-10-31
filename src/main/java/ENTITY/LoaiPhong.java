/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.text.DecimalFormat;

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
    
    public LoaiPhong(){
    }

    

    public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, Double giaTienTheoGio, Double giaTienTheoNgay,
			boolean tinhTheoNgay) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.giaTienTheoGio = giaTienTheoGio;
		this.giaTienTheoNgay = giaTienTheoNgay;
		this.tinhTheoNgay = tinhTheoNgay;
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


	@Override
	public String toString() {
		DecimalFormat dFormat = new DecimalFormat("#,###.##$");
		return "LoaiPhong [maLoaiPhong=" + maLoaiPhong + ", tenLoaiPhong=" + tenLoaiPhong + ", giaTienTheoGio="
				+ dFormat.format(giaTienTheoGio) + ", giaTienTheoNgay=" + dFormat.format(giaTienTheoNgay) + ", tinhTheoNgay=" + tinhTheoNgay + "]";
	}

	
    
    
}
