create table emp (
	num number(7) primary key,
	name varchar2(20) not null,
	age number(3),
	score number(7));
create sequence seq_num increment by 1 start with 1 nocycle nocache;
insert into emp(num, name, age, score) values(seq_num.nextval, 'jj',18, 100);
select * from emp;