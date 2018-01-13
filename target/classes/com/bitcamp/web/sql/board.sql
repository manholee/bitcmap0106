SELECT * FROM tab;
SELECT * FROM member;
DROP TABLE member;
CREATE sequence seq start with 1000;

CREATE TABLE member(
	ID VARCHAR2(100),
	PW VARCHAR2(100),
	EMAIL VARCHAR2(100),
	NAME VARCHAR2(100),
	REG_DATE DATE
);
SELECT * FROM member;

CREATE TABLE board(
	seq number(4) primary key,
	title varchar2(20),
	content varchar2(100),
	reg_date date,
	id varchar2(20)
);

SELECT * FROM board;
INSERT INTO member values('man','123','man@naver.com','만',sysdate);