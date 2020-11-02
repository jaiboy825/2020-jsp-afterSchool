create table member(
	userid varchar2(10) primary key not null,
	userpwd varchar2(10) not null);
	
insert into member values('candy', 1234);
insert into member values('admin', 5678);
select * from member;


create table bookshop(
	isbn varchar2(15) primary key not null,
	title varchar2(50) not null,
	author varchar2(10) not null,
	company varchar2(50),
	price number);

insert into bookshop values('88-90-11', '오라클 3일완성', '이오라', '야메루출판사', 15000);
insert into bookshop values('90-10-12', 'JSP 달인되기', '송JP', '공갈닷컴', 20000);
insert into bookshop values('87-90-33', '자바무따기', '김자바', '디지탈박스', 35000);
select * from bookshop;