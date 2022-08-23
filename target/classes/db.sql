----------- 회원 ------------

create table smvc_project_member(
	spm_id varchar2(10 char) primary key,
	spm_pw varchar2(10 char) not null,
	spm_bcn varchar2(70 char) not null,
	spm_name varchar2(10 char) not null,
	spm_birthday date not null,
	spm_address varchar2(100 char) not null,
	spm_photo varchar2(100 char) not null
);

select * from SMVC_PROJECT_MEMBER;

delete from smvc_project_member where spm_id = 'test1';


----------- 게시판 ------------

create table smvc_project_board(
	spb_no number(5) primary key,
	spb_writer varchar2(10 char) not null,
	spb_title varchar2(50 char) not null,
	spb_content varchar2(500 char) not null,
	spb_date date not null,
	spb_color varchar2(9 char) not null,
	constraint board_writer
		foreign key(spb_writer) references smvc_project_member(spm_id)
		on delete cascade
);

create sequence smvc_project_board_seq;

select * from smvc_project_board;

select *
from (
	select rownum as rn, spb_no, spb_writer, spb_title, spb_content, spb_date, spb_color, spm_photo
	from (
		select spb_no, spb_writer, spb_title, spb_content, spb_date, spb_color, spm_photo
		from smvc_project_board, SMVC_PROJECT_MEMBER 
		where spm_id = spb_writer
		order by spb_date desc
	) 
) where rn >= 2 and rn <= 5;

------------------------------

create table smvc_project_weather_color(
	spwc_hour number(2) not null,
	spwc_temp
	spwc_humidity
	spwc_description
	spwc_color
);

select *
from (
	select rownum as rn, spb_no, spb_writer, spb_title, spb_content, spb_date, spb_color, spm_photo
	from (
		select spb_no, spb_writer, spb_title, spb_content, spb_date, spb_color, spm_photo
		from smvc_project_board, SMVC_PROJECT_MEMBER 
		where spm_id = spb_writer
		order by spb_date desc
	) 
) where rn >= 2 and rn <= 5;