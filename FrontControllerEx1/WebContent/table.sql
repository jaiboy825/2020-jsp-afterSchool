drop table member2;

create table member2(
	id varchar2(10) primary key not null,
	passwd varchar2(10) not null,
	name varchar2(10),
	mail varchar2(20)
);

insert into member2 values('admin', 'admin', '홍길동', 'hkd@email.com');
select * from member2;