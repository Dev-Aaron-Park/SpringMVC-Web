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

----------- 댓글 ------------

create table smvc_project_comment(
	spc_no number(5) primary key,
	spc_board_no number(5) not null,
	spc_writer varchar2(10 char) not null,
	spc_content varchar2(200 char) not null,
	spc_date date not null,
	constraint comment_board
		foreign key(spc_board_no) references smvc_project_board(spb_no)
		on delete cascade
);

create sequence smvc_project_comment_seq;

select * from smvc_project_comment;

------------------------------

create table smvc_project_weather_color(
	spwc_hour number(2) not null,
	spwc_temp
	spwc_humidity
	spwc_description
	spwc_color
);

------------ 갤러리 ------------

create table smvc_project_gallery(
	spg_no number(5) primary key,
	spg_writer varchar2(10 char) not null,
	spg_photo varchar2(100 char) not null,
	spg_memo varchar2(25 char) not null,
	spg_date date not null,
	constraint gallery_writer
		foreign key(spg_writer) references smvc_project_member(spm_id)
		on delete cascade
);

create sequence smvc_project_gallery_seq;

