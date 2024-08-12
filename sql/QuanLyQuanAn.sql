--create database QuanLyQuanAn
go

--use QuanLyQuanAn
go

use SD19301_Team4

create table BanAn (
	id varchar(10) primary key,
	Ten nvarchar(100) not null,
	GhiChu nvarchar(100) not null, -- trống, Có người
);
go

create table NhanVien (
	id varchar(10) primary key,
	TenNV nvarchar(100) not null,
	TenDangNhap nvarchar(100) not null,
	MatKhau nvarchar(100) not null,
	VaiTro bit default 0 not null, -- 1 admin, 0 nhân viên
);
go

create table LoaiDoAn (
	id varchar(10) primary key,
	Ten nvarchar(100) not null
);
go

create table DoAn (
	id varchar(10) primary key,
	Ten nvarchar(100) not null,
	idLoaiDoAn varchar(10) not null,
	Gia float not null,

	foreign key (idLoaiDoAn) references dbo.LoaiDoAn(id)
);
go

create table HoaDon (
	id INT IDENTITY(1,1) PRIMARY KEY,
	Ngay date not null default getdate(),
	idBan varchar(10) not null,
	Tongtien float not null,
	

	foreign key (idBan) references dbo.BanAn(id)
);
go

create table DatMon (
	TenMon nvarchar(100) not null,
	SoLuong nvarchar(100) not null,
	Gia float not null,
	ThanhTien float not null,
	idBan varchar(10) not null,

	foreign key (idBan) references dbo.BanAn(id)
);
go

insert into NhanVien ( id, TenNV, TenDangNhap, MatKhau, VaiTro) values 
( 'NV001',N'Tin', N'abc', N'123',1),
( 'NV002',N'Tam', N'Tam', N'123', 0)
go

insert into BanAn (id, Ten, GhiChu) values 
('BA001', N'Bàn 1', N'Trống'),
('BA002', N'Bàn 2', N'Có người'),
('BA003', N'Bàn 3', N'Trống');
go

insert into LoaiDoAn (id, Ten) values 
('LDA001', N'Món chính'),
('LDA002', N'Khai vị'),
('LDA003', N'Tráng miệng');
go

insert into DoAn (id, Ten, idLoaiDoAn, Gia) values 
('DA001', N'Phở bò', 'LDA001', 50000),
('DA002', N'Gỏi cuốn', 'LDA002', 30000),
('DA003', N'Chè ba màu', 'LDA003', 25000);
go

insert into HoaDon ( Ngay, idBan, Tongtien) values 
('2023-08-04','BA001',10000),
('2023-08-05','BA002',20000),
('2023-08-06','BA003',30000),
('2024-01-05','BA001',30000),
('2024-01-07','BA002',40000),
('2024-02-08','BA003',50000),
('2024-02-09','BA001',60000),
('2024-03-02','BA002',70000),
('2024-03-03','BA003',80000),
('2024-04-05','BA001',90000),
('2024-04-03','BA002',100000),
('2024-05-02','BA003',110000),
('2024-05-01','BA001',120000),
('2024-06-05','BA002',130000),
('2024-06-06','BA003',140000);
go

select * from BanAn;
select * from LoaiDoAn;
select * from DoAn;
select * from HoaDon;
select * from NhanVien;
select * from DatMon;
go

SELECT HoaDon.Ngay, BanAn.Ten AS Ban, HoaDon.Tongtien
FROM HoaDon
JOIN BanAn ON HoaDon.idBan = BanAn.id
WHERE DAY(HoaDon.Ngay) = 5;
go