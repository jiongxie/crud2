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