create table board3 (
	idx int not null auto_increment,
	title varchar(20),
	name varchar(20),
	content varchar(100),
	pwd varchar(20) default '1234',
	primary key(idx)
);

insert into board3 values (default, '첫 게시','변형섭','안녕하세요...',default);
drop table board3;
select * from board3 order by idx desc;
select count(*) from board3;

create table member (
	idx int not null auto_increment,
	mid varchar(20),
	pwd varchar(20),
	primary key(idx)
);
 insert into member values(default, 'admin', '1234');
 select * from member;
 
 alter table board3 add fname varchar(100);
 alter table board3 add rfname varchar(100);
 