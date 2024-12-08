/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 84837
 */
public class HoaDon {
    private String maHoaDon;
    private KhuyenMai khuyenMai;
    private NhanVien nhanVienLap;
    private KhachHang khachHang;
    private java.util.Date ngayLap;
    private java.util.Date ngayNhanPhong;
    private java.util.Date ngayTraPhong;
    private int thue;
    private Double tienTraKhach;
    private Double tongTien;

    

    public HoaDon() {
		super();
	}



	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	

	public HoaDon(String maHoaDon, KhuyenMai khuyenMai, NhanVien nhanVienLap, KhachHang khachHang, java.util.Date ngayLap,
			java.util.Date ngayNhanPhong, java.util.Date ngayTraPhong, int thue, Double tienTraKhach, Double tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.khuyenMai = khuyenMai;
		this.nhanVienLap = nhanVienLap;
		this.khachHang = khachHang;
		this.ngayLap = ngayLap;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.thue = thue;
		this.tienTraKhach = tienTraKhach;
		this.tongTien = tongTien;
	}



	public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public NhanVien getNhanVienLap() {
        return nhanVienLap;
    }

    public void setNhanVienLap(NhanVien nhanVienLap) {
        this.nhanVienLap = nhanVienLap;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public java.util.Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(java.util.Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public java.util.Date getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(java.util.Date ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public java.util.Date getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(java.util.Date ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }

    public int getThue() {
        return thue;
    }

    public void setThue(int thue) {
        this.thue = thue;
    }

    public Double getTongTien() {
        return tongTien;
    }
    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
    
    
    public Double getTienTraKhach() {
		return tienTraKhach;
	}



	public void setTienTraKhach(Double tienTraKhach) {
		this.tienTraKhach = tienTraKhach;
	}



	public double tinhTongTien(double tienPhong, List<ChiTietDichVu> dichVuList) {
        double tongTienDichVu = 0;

        // Tính tổng tiền dịch vụ dựa trên đơn giá và số lượng
        for (ChiTietDichVu chiTiet : dichVuList) {
            tongTienDichVu += chiTiet.getDichVu().getDonGia() * chiTiet.getSoLuong();
        }

        // Tổng tiền = Tiền phòng + Tiền dịch vụ
        this.tongTien = tienPhong + tongTienDichVu;
        return this.tongTien;
    }
    
    public double tinhTongThanhToan(double tienCoc) {
        double chietKhau = (khuyenMai != null) ? khuyenMai.getChietKhau() : 0;

        // Tính tiền sau chiết khấu
        double tienSauChietKhau = tongTien - (tongTien * chietKhau / 100);

        // Tính tiền thuế
        double tienThue = tienSauChietKhau * thue / 100;

        // Tổng thanh toán = Tiền sau chiết khấu + Thuế - Tiền cọc
        return tienSauChietKhau + tienThue - tienCoc;
    }

	@Override
    public int hashCode() {
        return Objects.hash(maHoaDon);
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
        final HoaDon other = (HoaDon) obj;
        return Objects.equals(this.maHoaDon, other.maHoaDon);
    }

	@Override
	public String toString() {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat dFormat = new DecimalFormat("#,###.##$");
		return "HoaDon [maHoaDon=" + maHoaDon + ", khuyenMai=" + khuyenMai + ", nhanVienLap=" + nhanVienLap
				+ ", khachHang=" + khachHang + ", ngayLap=" + ngayLap + ", ngayNhanPhong=" + ngayNhanPhong
				+ ", ngayTraPhong=" + ngayTraPhong + ", thue=" + thue + ", tienKhachDua=" + tienTraKhach
				+  ", tongTien=" + tongTien + "]";
	}



	public void setTongTien(double tongTien2) {
		// TODO Auto-generated method stub
		
	}



	public void setTienTraKhach(double double1) {
		// TODO Auto-generated method stub
		
	}
    
    

    
    
    
}
