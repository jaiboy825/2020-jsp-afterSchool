create table artist_tbl(
artist_id char (4) primary key not null,
artist_name varchar2(20),
artist_birth char(8),
artist_gender char(1),
talent char(1),
agency varchar2(20)
)
drop table artist_tbl;

insert into artist_tbl (artist_id,artist_name,artist_birth,artist_gender,talent,agency) values('A001','황스타',19970101,'F',1,'A엔터테인먼드');
insert into artist_tbl (artist_id,artist_name,artist_birth,artist_gender,talent,agency) values('A002','정스타',19980201,'M',2,'B엔터테인먼드');
insert into artist_tbl (artist_id,artist_name,artist_birth,artist_gender,talent,agency) values('A003','박스타',19990301,'M',3,'C엔터테인먼드');
insert into artist_tbl (artist_id,artist_name,artist_birth,artist_gender,talent,agency) values('A004','김스타',20000401,'M',1,'D엔터테인먼드');
insert into artist_tbl (artist_id,artist_name,artist_birth,artist_gender,talent,agency) values('A005','서스타',20010501,'F',2,'E엔터테인먼드');

select*from artist_tbl;

create table mento_tbl(
mento_id char(4) primary key not null,
mento_name varchar2(20)
)

insert into mento_tbl(mento_id,mento_name) values('J001','이멘토');
insert into mento_tbl(mento_id,mento_name) values('J002','안멘토');
insert into mento_tbl(mento_id,mento_name) values('J003','한멘토');

create table point_tbl(
serial_no char(4) primary key not null,
artist_id varchar2 (20),
mento_id char(8),
point number(3)
)

insert into point_tbl(serial_no,artist_id,mento_id,point) values('P001','A001','J001',84);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P002','A001','J002',82);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P003','A001','J003',86);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P004','A002','J001',98);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P005','A002','J002',99);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P006','A002','J003',100);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P007','A003','J001',23);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P008','A003','J002',43);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P009','A003','J003',34);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P010','A004','J001',67);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P011','A004','J002',56);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P012','A004','J003',89);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P013','A005','J001',3);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P014','A005','J002',6);
insert into point_tbl(serial_no,artist_id,mento_id,point) values('P015','A005','J003',9);


select  ar.artist_id ,artist_name, sum(point) sum ,round(avg(point),2) avg,rank() over(order by sum(point) desc) rank 
from ARTIST_TBL ar, POINT_TBL po where ar.artist_id = po.artist_id group by (ar.artist_id ,artist_name ) order by rank  asc;

select rollup(point) from POINT_TBL;





















