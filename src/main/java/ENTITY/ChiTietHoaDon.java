/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author 84837
 */
public class ChiTietHoaDon {
	private String maCTHD;
    private HoaDon hoaDon;
    private Phong phong;
    private DichVu dichVu;
    private int soLuong;
    private Double tongTienDichVu;
    
    
    
    public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(String maCTHD, HoaDon hoaDon, Phong phong, DichVu dichVu, int soLuong, Double tongTienDichVu) {
		super();
		this.maCTHD = maCTHD;
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
		this.tongTienDichVu = tongTienDichVu;
	}
	
	

	public String getMaCTHD() {
		return maCTHD;
	}

	public void setMaCTHD(String maCTHD) {
		this.maCTHD = maCTHD;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}


	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}



	public Phong getPhong() {
		return phong;
	}



	public void setPhong(Phong phong) {
		this.phong = phong;
	}



	public DichVu getDichVu() {
		return dichVu;
	}



	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}



	public int getSoLuong() {
		return soLuong;
	}



	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}



	public Double getTongTienDichVu() {
		return tongTienDichVu;
	}



	public void setTongTienDichVu(Double tongTienDichVu) {
		this.tongTienDichVu = tongTienDichVu;
	}



	// Phương thức tính tiền phòng
    public double tinhTienPhong() {
        double tienPhong = 0;

        // Kiểm tra nếu phòng có giá theo ngày
        if (phong.getLoaiPhong().isTinhTheoNgay()) {
            tienPhong = phong.getLoaiPhong().getGiaTienTheoNgay() * soLuong;
        } 
        // Nếu phòng tính giá theo giờ
        else {
            tienPhong = phong.getLoaiPhong().getGiaTienTheoGio() * soLuong;
        }

        return tienPhong;
    }



	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", phong=" + phong + ", dichVu=" + dichVu + ", soLuong=" + soLuong
				+ ", tongTienDichVu=" + tongTienDichVu + "]";
	}
    
}
