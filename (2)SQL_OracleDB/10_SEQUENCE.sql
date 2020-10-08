-- 시퀀스(SEQUENCE) : 자동 번호 발생기 역할을 하는 객체
-- CREATE SEQUENCE 시퀀스명
-- EX. 게시판에 글을 올리면 자동으로 번호가 발생
-- 순차적으로 정수 값을 자동으로 생성

CREATE SEQUENCE SEQ_EMP_ID
START WITH 300 -- 시작 숫자
INCREMENT BY 5 -- 증가 숫자
MAXVALUE 310 -- 최대 값
NOCYCLE -- 사이클 돌지 않겠다
NOCACHE; -- 메모리 상에서 관리하지 않겠다

SELECT * FROM USER_SEQUENCES;

-- 시퀀스 사용
-- 시퀀스명.CURRVAL : 현재 생성된 시퀀스 값(마지막으로 호출된 NEXTVAL의 값을 저장)
-- 시퀀스명.NEXTVAL : 기존 시퀀스 값에서 증가치만큼 증가한 값
--                  최초로 시퀀스를 실행시킴
SELECT SEQ_EMP_ID.CURRVAL FROM DUAL;
-- sequence SEQ_EMP_ID.CURRVAL is not yet defined in this sessio
--> NEXTVAL을 실행한 적이 없어서

SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMP_ID.CURRVAL FROM DUAL; -- 300
SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL; -- 310
SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL;
-- sequence SEQ_EMP_ID.NEXTVAL exceeds MAXVALUE and cannot be instantiated

SELECT * FROM USER_SEQUENCES;

-- START WITH 변경 불가능 : 기존 시퀀스를 DROP한 후 재생성해야함
ALTER SEQUENCE SEQ_EMP_ID
INCREMENT BY 10
MAXVALUE 400
NOCYCLE
NOCACHE;

SELECT * FROM USER_SEQUENCES;
SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL;
SELECT SEQ_EMP_ID.CURRVAL FROM DUAL;

/*
    CURRVAL / NEXTVAL 사용 가능 여부
        사용 가능
            서브쿼리가 아닌 SELECT문
            INSERT문의 SELECT절
            INSERT문의 VALUES절
            UPDATE문의 SET절
        
        사용 불가능
            VIEW의 SELECT절
            DISTINCT 키워드가 있는 SELECT문
            GROUP BY, HAVING, ORDER BY의 SELECT문
            SELECT, DELETE, UPDATE문의 서브쿼리
            CREATE TABLE, ALTER TABLE 명령의 DEFAULT값
*/

INSERT INTO EMPLOYEE
VALUES (SEQ_EMP_ID.NEXTVAL, '홍길동', '660606-166666', 'hong_GD123@kh.or.kr',
        '01011112222', 'D2', 'J7', 's1', 5000000, 0.1, 200, SYSDATE, NULL, DEFAULT);
SELECT * FROM EMPLOYEE;
 
 CREATE TABLE TMP_EMPLOYEE(
    E_ID NUMBER DEFAULT SEQ_EMP_ID.CURRVAL,
    E_NAME VARCHAR2(20)
 ); -- 에러: column not allowed here
 
 ROLLBACK;