CREATE TABLE tbl_artist (
artist_id char(4) NOT NULL PRIMARY KEY,
artist_name varchar2(20),
artist_birth char(8),
artist_gender char(1),
talent char(1),
agency varchar2(20)
);

-----------------------------------------------

CREATE TABLE tbl_mento (
mento_id char(4) NOT NULL PRIMARY KEY,
mento_name varchar2(20)
)

------------------------------------------------

CREATE TABLE tbl_point(
serial_no char(4) NOT NULL PRIMARY KEY,
artist_id varchar2(20),
mento_id char(8),
point number(3)
)

----------------------------------------------

insert into tbl_artist(artist_id, artist_name, artist_birth, artist_gender, talent, agency) VALUES('A001','황스타','19970101','F','1','A엔터테이먼트');
insert into tbl_artist(artist_id, artist_name, artist_birth, artist_gender, talent, agency) VALUES('A002','정스타','19980201','M','2','B엔터테이먼트');
insert into tbl_artist(artist_id, artist_name, artist_birth, artist_gender, talent, agency) VALUES('A003','박스타','19990301','M','3','C엔터테이먼트');
insert into tbl_artist(artist_id, artist_name, artist_birth, artist_gender, talent, agency) VALUES('A004','김스타','20000401','M','1','D엔터테이먼트');
insert into tbl_artist(artist_id, artist_name, artist_birth, artist_gender, talent, agency) VALUES('A005','서스타','20010501','F','2','E엔터테이먼트');

----------------------------------------------

insert into tbl_mento(mento_id, mento_name) values('J001', '이멘토');
insert into tbl_mento(mento_id, mento_name) values('J002', '안멘토');
insert into tbl_mento(mento_id, mento_name) values('J003', '한멘토');

----------------------------------------------

insert into tbl_point(serial_no, artist_id, mento_id, point) values('P001', 'A001', 'J001', 84);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P002', 'A001', 'J002', 82);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P003', 'A001', 'J003', 86);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P004', 'A002', 'J001', 98);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P005', 'A002', 'J002', 99);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P006', 'A002', 'J003', 100);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P007', 'A003', 'J001', 23);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P008', 'A003', 'J002', 43);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P009', 'A003', 'J003', 34);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P010', 'A004', 'J001', 67);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P011', 'A004', 'J002', 56);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P012', 'A004', 'J003', 89);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P013', 'A005', 'J001', 3);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P014', 'A005', 'J002', 6);
insert into tbl_point(serial_no, artist_id, mento_id, point) values('P015', 'A005', 'J003', 9);


