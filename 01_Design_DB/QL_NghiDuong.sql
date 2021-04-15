create database QL_NghiDuong;
use QL_NghiDuong;
create table ViTri(
	idvitri int primary key,
    tenvitri varchar(45)
);

INSERT INTO ViTri(idvitri,tenvitri) values(2,'Quản Lý');
INSERT INTO ViTri(idvitri,tenvitri) values(5,'Phục Vụ');
INSERT INTO ViTri(idvitri,tenvitri) values(1,'Giám đốc');
INSERT INTO ViTri(idvitri,tenvitri) values(3,'Giám sát');
INSERT INTO ViTri(idvitri,tenvitri) values(4,'Chuyên viên');
INSERT INTO ViTri(idvitri,tenvitri) values(6,'Lễ Tân');
select*from ViTri;
create table TrinhDo(
	idtrinhdo int primary key,
    trinhdo varchar(45)
);
INSERT INTO TrinhDo(idtrinhdo,trinhdo) values(0,'Sau Đai Học');
INSERT INTO TrinhDo(idtrinhdo,trinhdo) values(1,'Đại Học');
INSERT INTO TrinhDo(idtrinhdo,trinhdo) values(2,'Cao Đẳng');
INSERT INTO TrinhDo(idtrinhdo,trinhdo) values(3,'Trung Cấp');
select *from TrinhDo;
create table BoPhan(
	idbophan int primary key,
    tenbophan varchar(45)
);
INSERT INTO BoPhan(idbophan,tenbophan) values(1,'Quản lý');
INSERT INTO BoPhan(idbophan,tenbophan) values(2,'Phục Vụ');
INSERT INTO BoPhan(idbophan,tenbophan) values(3,'Hành Chính');
INSERT INTO BoPhan(idbophan,tenbophan) values(4,'Sale-Marketing');
select * from BoPhan;
create table NhanVien(
	idnhanvien int primary key,
    Hoten int,
    idvitri int,
    idtrinhdo int,
    idbophan int,
    ngaysinh date,
    socmnd varchar(45),
    luong varchar(45),
    sdt varchar(45),
    email varchar(45),
    diachi varchar(45),
    foreign key (idvitri ) references ViTri(idvitri),
    foreign key (idtrinhdo) references TrinhDo(idtrinhdo),
    foreign key (idbophan) references BoPhan(idbophan)
);
ALTER TABLE NhanVien Modify Hoten varchar(45);
insert into NhanVien(idnhanvien,Hoten,idvitri,idtrinhdo,idbophan,ngaysinh,socmnd,luong,sdt,email,diachi)
values(1001,'Hoàng Văn Hiếu',5,2,1,'1999/01/06','197405491','15000000','0987654312','hieuvanhoang99@gmail.com','Quảng Trị');
insert into NhanVien(idnhanvien,Hoten,idvitri,idtrinhdo,idbophan,ngaysinh,socmnd,luong,sdt,email,diachi)
values(1002,'Nguyễn Huấn',5,1,2,'1999/08/24','197015746','15000000','0985123456','huannguyen99@gmail.com','Đà Nẵng');
insert into NhanVien(idnhanvien,Hoten,idvitri,idtrinhdo,idbophan,ngaysinh,socmnd,luong,sdt,email,diachi)
values(1003,'Nguyễn Văn Tùng',5,3,4,'1999/06/12','197012478','12000000','0905123456','tungnguyen99@gmail.com','Quảng Nam');
insert into NhanVien(idnhanvien,Hoten,idvitri,idtrinhdo,idbophan,ngaysinh,socmnd,luong,sdt,email,diachi)
values(1004,'Trần Tuấn Kiệt',5,1,3,'1999/12/24','197016987','15000000','0905123456','kiettran99@gmail.com','Quảng Trị');
select * from NhanVien;
create table DichVuDiKem(
	iddichvudikem int primary key,
	tendichvudikem varchar(45),
    gia int,
    donvi int,
    trangthaikhadung varchar(45)
);
ALTER TABLE DichVuDiKem Modify donvi varchar(45);
insert into DichVuDiKem(iddichvudikem, tendichvudikem,gia,donvi,trangthaikhadung)
values(1,'Thuê xe di chuyển tham quan resort',150000,'Giờ','Khả Dụng');
insert into DichVuDiKem(iddichvudikem, tendichvudikem,gia,donvi,trangthaikhadung)
values(2,'Nước uống',15000,'Chai','Khả Dụng');
insert into DichVuDiKem(iddichvudikem, tendichvudikem,gia,donvi,trangthaikhadung)
values(3,'Thức ăn',150000,'Tuỳ Loại','Khả Dụng');
insert into DichVuDiKem(iddichvudikem, tendichvudikem,gia,donvi,trangthaikhadung)
values(4,'Karaoke',150000,'Giờ','Khả Dụng');
insert into DichVuDiKem(iddichvudikem, tendichvudikem,gia,donvi,trangthaikhadung)
values(5,'Massage',300000,'Tuỳ Loại','Khả Dụng');
select * from DichVuDiKem;
create table LoaiKhach(
	idloaikhach int primary key,
    tenloaikhach varchar(45)
);
insert into LoaiKhach(idloaikhach,tenloaikhach) values (1,'Diamond');
insert into LoaiKhach(idloaikhach,tenloaikhach) values (2,'Platinium');
insert into LoaiKhach(idloaikhach,tenloaikhach) values (3,'Gold');
insert into LoaiKhach(idloaikhach,tenloaikhach) values (4,'Silver');
insert into LoaiKhach(idloaikhach,tenloaikhach) values (5,'Member');
select * from LoaiKhach;
create table KieuThue(
	idkieuthue int primary key,
    tenkieuthue varchar(45),
    gia int
);
insert into KieuThue(idkieuthue,tenkieuthue,gia)values(0,'Thuê Theo Năm',1200000000);
insert into KieuThue(idkieuthue,tenkieuthue,gia)values(1,'Thuê Theo Tháng',30000000);
insert into KieuThue(idkieuthue,tenkieuthue,gia)values(2,'Thuê Theo Ngày',1000000);
insert into KieuThue(idkieuthue,tenkieuthue,gia)values(3,'Thuê Theo Giờ',200000);
select * from KieuThue;
create table LoaiDichVu(
	idloaidichvu int primary key,
    tenloaidichvu varchar(45)
);
insert into LoaiDichVu(idloaidichvu,tenloaidichvu)values(1,'Villa');
insert into LoaiDichVu(idloaidichvu,tenloaidichvu)values(2,'House');
insert into LoaiDichVu(idloaidichvu,tenloaidichvu)values(3,'Room');
select * from LoaiDichVu;
create table KhachHang(
	idkhachhang int primary key,
    idloaikhach int,
    hoten varchar(45),
    ngaysinh date,
    socmnd varchar(45),
    sdt varchar(45),
    email varchar(45),
    diachi varchar(45),
    foreign key (idloaikhach) references LoaiKhach(idloaikhach)
);
insert into KhachHang(idkhachhang,idloaikhach,hoten,ngaysinh ,socmnd,sdt,email,diachi)
values(101,1,'Hoàng Bút','1935/06/09','16581237','0918123789','buthoang@gmail.com','Quảng Trị');
insert into KhachHang(idkhachhang,idloaikhach,hoten,ngaysinh ,socmnd,sdt,email,diachi)
values(102,2,'Hoàng Thị Lựu','1945/12/09','13581275','0935555555','buthoang@gmail.com','Triệu Đông');
insert into KhachHang(idkhachhang,idloaikhach,hoten,ngaysinh ,socmnd,sdt,email,diachi)
values(103,4,'Lê Thị Họng','1960/06/09','19763514','0908888668','hongle@gmail.com','Triệu Thành');
insert into KhachHang(idkhachhang,idloaikhach,hoten,ngaysinh ,socmnd,sdt,email,diachi)
values(104,3,'Lê Tập','1989/06/09','18546354','0906666666','letap@gmail.com','Hà Nội');
insert into KhachHang(idkhachhang,idloaikhach,hoten,ngaysinh ,socmnd,sdt,email,diachi)
values(105,1,'Hoàng Duc','1935/06/09','175821463','0982455555','duchoang@gmail.com','Đà Nẵng');
select *from KhachHang;

create table DichVu(
	iddichvu int primary key,
	tendichvu varchar(45),
    dientich int,
    sotang int,
    songuoitoida varchar(45),
    chiphithue varchar(45),
    idkieuthue int,
    idloaidichvu int,
    trangthai varchar(45),
    constraint foreign key (idkieuthue) references KieuThue(idkieuthue),
    constraint foreign key (idloaidichvu) references LoaiDichVu(idloaidichvu)
);
insert into DichVu(iddichvu,tendichvu,dientich,sotang,songuoitoida,chiphithue,idkieuthue,idloaidichvu,trangthai)
values(1,'Villa',90,2,'10 người','1000000',2,1,'Chưa Sử Dụng');
insert into DichVu(iddichvu,tendichvu,dientich,sotang,songuoitoida,chiphithue,idkieuthue,idloaidichvu,trangthai)
values(2,'Room',40,1,'4 người','300000',3,3,'Đang Sử Dụng');
insert into DichVu(iddichvu,tendichvu,dientich,sotang,songuoitoida,chiphithue,idkieuthue,idloaidichvu,trangthai)
values(3,'House',80,2,'6 người','120000000',0,2,'Đã Sử Dụng');
select *from DichVu;
create table HopDong(
	idhopdong int primary key,
	idnhanvien int,
    idkhachhang int,
    iddichvu int,
    ngaylamhopdong date,
    ngayketthuc date,
    tiendatcoc int,
    tongtien int,
    constraint foreign key (idnhanvien) references NhanVien(idnhanvien),
    constraint foreign key (idkhachhang) references KhachHang(idkhachhang),
    constraint foreign key (iddichvu) references DichVu(iddichvu)
);
insert into HopDong(idhopdong,idnhanvien,idkhachhang,iddichvu,ngaylamhopdong,ngayketthuc,tiendatcoc,tongtien)
values(001,1001,101,2,'2019/12/01','2019/12/01',300000,300000);
insert into HopDong(idhopdong,idnhanvien,idkhachhang,iddichvu,ngaylamhopdong,ngayketthuc,tiendatcoc,tongtien)
values(002,1002,101,1,'2020/07/05','2020/07/06',500000,1000000);
insert into HopDong(idhopdong,idnhanvien,idkhachhang,iddichvu,ngaylamhopdong,ngayketthuc,tiendatcoc,tongtien)
values(003,1004,101,3,'2018/12/01','2019/11/30',30000000,120000000);
select *from HopDong;

create table HopDongChiTiet(
	idhopdongchitiet int primary key,
    idhopdong int,
    iddichvudikem int,
    soluong int,
    foreign key (idhopdong) references HopDong(idhopdong),
    foreign key (iddichvudikem) references DichVuDiKem(iddichvudikem)
);
insert into HopDongChiTiet(idhopdongchitiet,idhopdong,iddichvudikem,soluong)
values(1,001,1,1);
insert into HopDongChiTiet(idhopdongchitiet,idhopdong,iddichvudikem,soluong)
values(2,002,3,5);
insert into HopDongChiTiet(idhopdongchitiet,idhopdong,iddichvudikem,soluong)
values(3,003,4,2);
select *from HopDongChiTiet;

select * from nhanvien where Hoten like 'H%_____________' or Hoten like 'T%_____________' or Hoten like 'K%_____________';

select * from khachhang where  diachi in ('Quảng Trị', 'Đà Nẵng') and year(CURDATE()) - year(ngaysinh) between 18 and 50;

select count(*) from hopdong where idkhachhang in (
select k.idkhachhang from khachhang k inner join loaikhach l
on k.idloaikhach = l.idloaikhach
where l.tenloaikhach like 'Diamond');


