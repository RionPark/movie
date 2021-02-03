
/* Drop Triggers */

DROP TRIGGER TRI_user_info_ui_num;



/* Drop Tables */

DROP TABLE user_info CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_user_info_ui_num;




/* Create Sequences */

CREATE SEQUENCE SEQ_user_info_ui_num INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE user_info
(
	ui_num number(7,0) NOT NULL,
	ui_name varchar2(30) NOT NULL,
	ui_id varchar2(10) NOT NULL UNIQUE,
	ui_pwd varchar2(20) NOT NULL,
	ui_genre varchar2(50) NOT NULL,
	ui_email varchar2(30),
	ui_phone1 char(3) NOT NULL,
	ui_phone2 varchar2(10) NOT NULL,
	ui_address varchar2(300) NOT NULL,
	ui_hint varchar2(10) NOT NULL,
	ui_answer varchar2(100) NOT NULL,
	credat char(8) NOT NULL,
	cretim char(6) NOT NULL,
	moddat char(8) NOT NULL,
	modtim char(6) NOT NULL,
	PRIMARY KEY (ui_num)
);



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_user_info_ui_num BEFORE INSERT ON user_info
FOR EACH ROW
BEGIN
	SELECT SEQ_user_info_ui_num.nextval
	INTO :new.ui_num
	FROM dual;
END;

/




