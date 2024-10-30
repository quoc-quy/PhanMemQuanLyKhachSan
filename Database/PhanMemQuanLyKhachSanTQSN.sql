create database PhanMemQuanLyKhachSanTQSN

use PhanMemQuanLyKhachSanTQSN

-------------------------------------- Tài Khoản ---------------------------
CREATE TABLE TaiKhoan (
    MaTaiKhoan NVARCHAR(50) PRIMARY KEY,
    TenDangNhap NVARCHAR(50),
    MatKhau NVARCHAR(50)
)

INSERT INTO TaiKhoan (MaTaiKhoan, TenDangNhap, MatKhau) VALUES ('TK001', 'Quy', '123');
INSERT INTO TaiKhoan (MaTaiKhoan, TenDangNhap, MatKhau) VALUES ('TK002', 'Thanh', '123');
INSERT INTO TaiKhoan (MaTaiKhoan, TenDangNhap, MatKhau) VALUES ('TK003', 'Son', '123');
INSERT INTO TaiKhoan (MaTaiKhoan, TenDangNhap, MatKhau) VALUES ('TK004', 'Nguyen', '123');


-------------------------------------- Nhân Viên ---------------------------
CREATE TABLE NhanVien (
    MaNhanVien NVARCHAR(6) PRIMARY KEY,
    TenNhanVien NVARCHAR(50),
    LoaiNhanVien NVARCHAR(50) NOT NULL,
    TaiKhoan NVARCHAR(50),
    NgaySinh DATE,
    CCCD NVARCHAR(12),
    SDT NVARCHAR(10),
    Phai NVARCHAR(50),
    FOREIGN KEY (TaiKhoan) REFERENCES TaiKhoan(MaTaiKhoan),
    CONSTRAINT chk_LoaiNhanVien CHECK (LoaiNhanVien IN ('NV_QUANLY', 'NV_LETAN')) -- Thêm ràng buộc CHECK
);

INSERT INTO NhanVien (MaNhanVien, TenNhanVien, LoaiNhanVien, TaiKhoan, NgaySinh, CCCD, SDT, Phai) VALUES 
('QL001', 'Tran Nguyen Quoc Quy', 'NV_QUANLY', 'TK001', '2004-09-14', '080204009324', '0353879898', 'Nam'),
('NV001', 'Mai Cong Thanh', 'NV_LETAN', 'TK002', '2004-12-21', '080204009112', '0353645479', 'Nam'),
('NV002', 'Huynh Nguyen Lam Son', 'NV_LETAN', 'TK003', '2004-03-21', '097004009112', '0678565759', 'Nam'),
('NV003', 'Pham Van Nguyen', 'NV_LETAN', 'TK004', '2004-04-22', '087697863452', '0367564657', 'Nam');


---------------------------------------Loại Phòng ---------------------------
CREATE TABLE LoaiPhong (
    MaLoaiPhong NVARCHAR(6) PRIMARY KEY,
    TenLoaiPhong NVARCHAR(50),
    GiaTienTheoNgay DOUBLE,
	GiaTienTheoGio DOUBLE
);

INSERT INTO LoaiPhong (MaLoaiPhong, TenLoaiPhong, GiaTienTheoNgay, GiaTienTheoGio) VALUES
('LP001', 'Phong Don', 300000, 80000),
('LP002', 'Phong Doi', 400000, 150000),
('LP003', 'Phong Gia Dinh', 600000, 200000);

ALTER TABLE LoaiPhong
ADD MoTaPhong NVARCHAR(255);

--------------------------------------- Phòng ---------------------------

CREATE TABLE Phong (
    MaPhong NVARCHAR(6) PRIMARY KEY,
    LoaiPhong NVARCHAR(6),
    SoNguoiLon INT,
    SoTreEm INT,
    TrangThaiPhong NVARCHAR(50),
    TinhTrangPhong NVARCHAR(50),
    FOREIGN KEY (LoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong),
    CONSTRAINT chk_TrangThaiPhong CHECK (TrangThaiPhong IN ('PHONG_TRONG', 'DANG_SU_DUNG')), -- Thêm ràng buộc CHECK
    CONSTRAINT chk_TinhTrangPhong CHECK (TinhTrangPhong IN ('SACH', 'CHUA_DON')), -- Thêm ràng buộc CHECK
);

INSERT INTO Phong (MaPhong, LoaiPhong, SoNguoiLon, SoTreEm, TrangThaiPhong, TinhTrangPhong) VALUES
('P101', 'LP001', 1, 1, 'PHONG_TRONG', 'SACH'),
('P102', 'LP001', 1, 1, 'DANG_SU_DUNG', 'SACH'),
('P103', 'LP001', 1, 1, 'PHONG_TRONG', 'CHUA_DON'),
('P104', 'LP001', 1, 1, 'DANG_SU_DUNG', 'SACH'),
('P105', 'LP002', 2, 1, 'PHONG_TRONG', 'SACH'),
('P106', 'LP002', 2, 1,'DANG_SU_DUNG', 'SACH'),
('P107', 'LP002', 2, 1, 'PHONG_TRONG', 'CHUA_DON'),
('P108', 'LP002', 2, 1, 'DANG_SU_DUNG', 'SACH'),
('P201', 'LP003', 2, 2, 'PHONG_TRONG', 'CHUA_DON'),
('P202', 'LP003', 2, 2, 'DANG_SU_DUNG', 'SACH'),
('P203', 'LP003', 2, 2, 'PHONG_TRONG', 'CHUA_DON'),
('P204', 'LP003', 2, 2, 'DANG_SU_DUNG', 'SACH'),
('P205', 'LP001', 1, 1, 'PHONG_TRONG', 'SACH'),
('P206', 'LP002', 2, 1, 'DANG_SU_DUNG', 'SACH'),
('P207', 'LP003', 2, 2, 'PHONG_TRONG', 'SACH'),
('P208', 'LP001', 1, 1, 'DANG_SU_DUNG', 'SACH'),
('P301', 'LP002', 2, 1, 'PHONG_TRONG', 'CHUA_DON'),
('P302', 'LP003', 2, 2, 'DANG_SU_DUNG', 'SACH'),
('P303', 'LP002', 2, 1, 'PHONG_TRONG', 'CHUA_DON'),
('P304', 'LP001', 1, 1, 'PHONG_TRONG', 'CHUA_DON')


--------------------------------------- Khách Hàng ---------------------------
CREATE TABLE KhachHang (
    MaKhachHang NVARCHAR(20) PRIMARY KEY,
    TenKhachHang NVARCHAR(50),
    CCCD NVARCHAR(13),
    Phai NVARCHAR(10),
	NgaySinh DATE,
    DenThoai NVARCHAR(11)
);

INSERT INTO KhachHang (MaKhachHang, TenKhachHang, CCCD, Phai, NgaySinh, DenThoai) VALUES
('KH0001', 'Nguyen Van An', '001201001234', 'Nam', '1990-01-15', '0901234567'),
('KH0002', 'Tran Thi Bich', '002201002345', 'Nu', '1985-04-20', '0912345678'),
('KH0003', 'Le Van Cuong', '003301003456', 'Nam', '1992-07-10', '0934567890'),
('KH0004', 'Pham Thi Dao', '004401004567', 'Nu', '1987-02-25', '0945678901'),
('KH0005', 'Vu Van Dung', '005501005678', 'Nam', '1993-08-08', '0923456789'),
('KH0006', 'Do Thi Hoa', '006601006789', 'Nu', '1989-11-18', '0972345678'),
('KH0007', 'Nguyen Van Hoang', '007701007890', 'Nam', '1991-05-22', '0981234567'),
('KH0008', 'Tran Thi Khanh', '008801008901', 'Nu', '1986-09-30', '0902345678'),
('KH0009', 'Le Van Lam', '009901009012', 'Nam', '1994-06-14', '0935678901'),
('KH0010', 'Pham Thi Mai', '010101010123', 'Nu', '1988-12-02', '0913456789'),
('KH0011', 'Vu Van Nam', '011201011234', 'Nam', '1995-03-29', '0924567890'),
('KH0012', 'Do Thi Ngoc', '012301012345', 'Nu', '1990-10-17', '0976789012'),
('KH0013', 'Nguyen Van Phuc', '013401013456', 'Nam', '1992-02-12', '0987890123'),
('KH0014', 'Tran Thi Quyen', '014501014567', 'Nu', '1987-08-19', '0908901234'),
('KH0015', 'Le Van Son', '015601015678', 'Nam', '1993-11-05', '0939012345'),
('KH0016', 'Pham Thi Thao', '016701016789', 'Nu', '1989-04-25', '0910123456'),
('KH0017', 'Vu Van Tien', '017801017890', 'Nam', '1991-07-15', '0921234567'),
('KH0018', 'Do Thi Uyen', '018901018901', 'Nu', '1986-05-23', '0973456789'),
('KH0019', 'Nguyen Van Vinh', '019001019012', 'Nam', '1994-09-09', '0984567890'),
('KH0020', 'Tran Thi Xuan', '020101020123', 'Nu', '1988-01-28', '0905678901');


--------------------------------------- Phiếu Đặt Phòng ---------------------------

CREATE TABLE PhieuDatPhong (
    MaPhieuDatPhong NVARCHAR(20) PRIMARY KEY,
    MaKhachHang NVARCHAR(20),
    MaNhanVienLap NVARCHAR(6),
    MaPhong NVARCHAR(6),
    NgayNhanPhong DATE,
    NgayTraPhong DATE,
    CONSTRAINT fk_khachHang FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
    CONSTRAINT fk_nhanVienLap FOREIGN KEY (MaNhanVienLap) REFERENCES NhanVien(MaNhanVien),
    CONSTRAINT fk_phong FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong)
);

INSERT INTO PhieuDatPhong (MaPhieuDatPhong, MaKhachHang, MaNhanVienLap, MaPhong, NgayNhanPhong, NgayTraPhong) VALUES
('PDP01102024P101', 'KH0001', 'NV001', 'P101', '2024-10-01', '2024-10-03'),
('PDP05102024P102', 'KH0002', 'NV002', 'P102', '2024-10-05', '2024-10-07'),
('PDP08102024P203', 'KH0003', 'NV001', 'P203', '2024-10-08', '2024-10-10'),
('PDP12102024P202', 'KH0004', 'NV003', 'P204', '2024-10-12', '2024-10-14'),
('PDP15102024P105', 'KH0005', 'NV002', 'P105', '2024-10-15', '2024-10-18');


--------------------------------------- Khuyến Mãi ---------------------------
CREATE TABLE KhuyenMai (
    MaKhuyenMai NVARCHAR(20) PRIMARY KEY,
    MoTa NVARCHAR(100),
    NgayBatDau DATE,
    NgayKetThuc DATE,
    TrangThai NVARCHAR(20),
    ChietKhau INT
);

INSERT INTO KhuyenMai (MaKhuyenMai, MoTa, NgayBatDau, NgayKetThuc, TrangThai, ChietKhau) VALUES
('KM001', 'Giam 10% cho cac dich vu', '2024-11-01', '2024-11-30', 'Het hang', 10),
('KM002', 'Giam 5% cho khach hang moi', '2024-12-01', '2024-12-31', 'Hoat dong', 5),
('KM003', 'Giam 5% cho khach hang moi', '2024-09-01', '2024-09-30', 'Hoat dong', 5);


--------------------------------------- Hóa Đơn ---------------------------
CREATE TABLE HoaDon (
    MaHoaDon NVARCHAR(20) PRIMARY KEY,
    MaKhuyenMai NVARCHAR(20),
    MaNhanVienLap NVARCHAR(6),
    MaKhachHang NVARCHAR(20),
    NgayLap DATE,
    NgayNhanPhong DATE,
    NgayTraPhong DATE,
    TienTraKhach FLOAT,
    TongTien FLOAT,
    CONSTRAINT fk_khuyenMai FOREIGN KEY (MaKhuyenMai) REFERENCES KhuyenMai(MaKhuyenMai),
    CONSTRAINT fk_nhanVienLapHoaDon FOREIGN KEY (MaNhanVienLap) REFERENCES NhanVien(MaNhanVien),
    CONSTRAINT fk_khachHangHoaDon FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);

INSERT INTO HoaDon (MaHoaDon, MaKhuyenMai, MaNhanVienLap, MaKhachHang, NgayLap, NgayNhanPhong, NgayTraPhong, TienTraKhach, TongTien) VALUES
('HD01102024NV0010001', 'KM001', 'NV001', 'KH0001', '2024-10-01', '2024-10-01', '2024-10-03', 100000, 300000),
('HD01102024NV0010002', 'KM002', 'NV001', 'KH0002', '2024-10-01', '2024-10-01', '2024-10-05', 200000, 500000),
('HD02102024NV0020003', 'KM003', 'NV002', 'KH0003', '2024-10-02', '2024-10-02', '2024-10-04', 150000, 400000),
('HD02102024NV0020004', 'KM001', 'NV002', 'KH0004', '2024-10-02', '2024-10-02', '2024-10-06', 100000, 600000),
('HD03102024NV0030005', 'KM002', 'NV003', 'KH0005', '2024-10-03', '2024-10-03', '2024-10-05', 250000, 700000),
('HD03102024NV0030006', 'KM003', 'NV003', 'KH0006', '2024-10-03', '2024-10-03', '2024-10-06', 300000, 800000),
('HD04102024NV0010007', 'KM001', 'NV001', 'KH0007', '2024-10-04', '2024-10-04', '2024-10-07', 350000, 900000),
('HD04102024NV0010008', 'KM002', 'NV001', 'KH0008', '2024-10-04', '2024-10-04', '2024-10-08', 400000, 1000000),
('HD05102024NV0020009', 'KM003', 'NV002', 'KH0009', '2024-10-05', '2024-10-05', '2024-10-09', 450000, 1100000),
('HD05102024NV0020010', 'KM001', 'NV002', 'KH0010', '2024-10-05', '2024-10-05', '2024-10-10', 500000, 1200000),
('HD06102024NV0030011', 'KM002', 'NV003', 'KH0011', '2024-10-06', '2024-10-06', '2024-10-11', 550000, 1300000),
('HD06102024NV0030012', 'KM003', 'NV003', 'KH0012', '2024-10-06', '2024-10-06', '2024-10-12', 600000, 1400000),
('HD07102024NV0010013', 'KM001', 'NV001', 'KH0013', '2024-10-07', '2024-10-07', '2024-10-13', 650000, 1500000),
('HD07102024NV0010014', 'KM002', 'NV001', 'KH0014', '2024-10-07', '2024-10-07', '2024-10-14', 700000, 1600000),
('HD08102024NV0020015', 'KM003', 'NV002', 'KH0015', '2024-10-08', '2024-10-08', '2024-10-15', 750000, 1700000),
('HD08102024NV0020016', 'KM001', 'NV002', 'KH0016', '2024-10-08', '2024-10-08', '2024-10-16', 800000, 1800000),
('HD09102024NV0030017', 'KM002', 'NV003', 'KH0017', '2024-10-09', '2024-10-09', '2024-10-17', 850000, 1900000),
('HD09102024NV0030018', 'KM003', 'NV003', 'KH0018', '2024-10-09', '2024-10-09', '2024-10-18', 900000, 2000000),
('HD10102024NV0010019', 'KM001', 'NV001', 'KH0019', '2024-10-10', '2024-10-10', '2024-10-19', 950000, 2100000),
('HD10102024NV0010020', 'KM002', 'NV001', 'KH0020', '2024-10-10', '2024-10-10', '2024-10-20', 1000000, 2200000);

ALTER TABLE HoaDon
ADD Thue INT;

UPDATE HoaDon
SET Thue = 10;


--------------------------------------- Chi Tiết Hóa Đơn ---------------------------

CREATE TABLE ChiTietHoaDon (
    MaHoaDon NVARCHAR(20),
    MaPhong NVARCHAR(6),
    ThoiLuong INT,
    PRIMARY KEY (MaHoaDon, MaPhong),
    CONSTRAINT fk_hoaDon FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    CONSTRAINT fk_phongHoaDon FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong)
);

INSERT INTO ChiTietHoaDon (MaHoaDon, MaPhong, ThoiLuong) VALUES
('HD01102024NV0010001', 'P101', 2),
('HD01102024NV0010002', 'P102', 3),
('HD02102024NV0020003', 'P103', 1),
('HD02102024NV0020004', 'P104', 2),
('HD03102024NV0030005', 'P205', 4),
('HD03102024NV0030006', 'P301', 2),
('HD04102024NV0010007', 'P302', 3),
('HD04102024NV0010008', 'P203', 5),
('HD05102024NV0020009', 'P304', 2),
('HD05102024NV0020010', 'P105', 1);


--------------------------------------- Dịch Vụ ---------------------------
CREATE TABLE DichVu (
    MaDichVu VARCHAR(20) PRIMARY KEY,
    TenDichVu VARCHAR(50),
    DonViTinh VARCHAR(20),
	SoLuong INT,
    DonGia FLOAT
);

INSERT INTO DichVu (MaDichVu, TenDichVu, DonViTinh, SoLuong, DonGia) VALUES
('DV001', 'Ca phe sua', 'Ly', 100, 25000),
('DV002', 'Ca phe den', 'Ly', 100, 20000),
('DV003', 'Banh mi', 'O', 50, 15000),
('DV004', 'Sting', 'Chai', 50, 20000),
('DV005', 'Nuoc cam ep', 'Ly', 70, 35000),
('DV006', 'Mi', 'hop', 30, 25000),
('DV007', 'Pho bo', 'To', 20, 50000),
('DV008', 'Com ga', 'Phan', 25, 60000),
('DV009', 'Mi xao hai san', 'Dia', 20, 70000),
('DV010', 'Pizza hai san', 'Cai', 15, 150000);

--------------------------------------- Chi Tiết Dịch Vụ ---------------------------
CREATE TABLE ChiTietDichVu (
    MaDichVu VARCHAR(20),
    MaHoaDon NVARCHAR(20),
    SoLuong INT,
    PRIMARY KEY (MaDichVu, MaHoaDon),
    CONSTRAINT fk_dichVu FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDichVu),
    CONSTRAINT fk_hoaDonDichVu FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon)
);

INSERT INTO ChiTietDichVu (MaDichVu, MaHoaDon, SoLuong) VALUES
('DV001', 'HD01102024NV0010001', 2),
('DV002', 'HD01102024NV0010002', 3),
('DV003', 'HD02102024NV0020003', 1),
('DV004', 'HD02102024NV0020004', 2),
('DV005', 'HD03102024NV0030005', 1),
('DV006', 'HD03102024NV0030006', 2),
('DV007', 'HD04102024NV0010007', 3),
('DV008', 'HD04102024NV0010008', 1),
('DV009', 'HD05102024NV0020009', 2),
('DV010', 'HD05102024NV0020010', 1);