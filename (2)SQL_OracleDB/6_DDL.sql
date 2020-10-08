-- DDL: 데이터 정의 언어
-- 객체를 만들고(CREATE), 수정하고(ALTER), 삭제(DROP)하는 구문

-- CREATE : 데이터베이스 객체를 생성하는 구문
-- 테이블 생성 구문
CREATE TABLE MEMBER (
    MEMBER_ID VARCHAR2(20),
    MEMBER_PWD VARCHAR2(20),
    MEMBER_NAME VARCHAR2(20)
);

SELECT * FROM MEMBER; --> 테이블이 생성되었으나 들어간 데이터가 없어 빈 셀로 출력됨

-- 컬럼에 주석 달기
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원아이디'; --> 실행 후 열 뷰 가서 열을 보면 COMMENT 컬럼에 정보가 추가 되어 있음
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS '비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS '회원이름';

DESC MEMBER; --> DESCRIPTION 테이블의 구조 정보 확인 가능



-------------------------------------------------------------------------------
-- 제약조건(CONSTRAINTS)
-- 테이블 작성 시 각 컬럼의 값 기록에 대해 제약 조건 설정 가능
-- 데이터 무결성* 보장을 목적으로 함
-- * 데이터 무결성: 데이터의 정확성, 일관성, 유효성이 유지되는 것
-- 입력 데이터에 문제가 없는지 자동으로 검사하는 목적
-- 제약조건은 테이블을 처음 만들 때 지정해도 되고, 테이블 생성 후 지정해도 됨

-- 제약 조건 확인
DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS; -->사용자가 지정한 제약조건 확인
SELECT * FROM USER_CONS_COLUMNS; -->제약조건이 있는 컬럼 확인

-- NOT NULL :
-- 삽입/수정 시 NULL값을 허용하지 않도록 컬럼 레벨에서 제한
-- 컬럼에 반드시 값이 기록되어야 하는 경우 사용
CREATE TABLE USER_NOCONST(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
); 

INSERT INTO USER_NOCONST -- 데이터 삽입(DML)
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_NOCONST
VALUES (2, NULL, NULL, NULL, NULL, '010-2222-3333', 'kang123@kh.or.kr'); -- 제약 조건이 없어서 자유롭게 NULL값을 저장할 수 있음

-- 제약 조건 설정하는 방법
-- 방법1) 테이블을 만들 때 같이 설정하기
--       1-1. 테이블 레벨에 설정
--       1-2. 컬럼 레벨에 설정
CREATE TABLE USER_NOTNULL(
    USER_NO NUMBER NOT NULL, --> 컬럼 레벨에서 제약조건 설정 !!NOT NULL은 컬럼 레벨에서만 설정 가능하니 주의!!
    USER_ID VARCHAR2(20) NOT NULL,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_NOTNULL -- 데이터 삽입
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_NOTNULL
VALUES (2, NULL, NULL, NULL, NULL, '010-2222-3333', 'kang123@kh.or.kr');
-- ORA-01400: cannot insert NULL into ("KH"."USER_NOTNULL"."USER_ID")
--> 제약 조건이 입력되어 있어 사용 불가


-- UNIQUE
-- 컬럼에 입력하는 값에 대해 중복을 제한하는 제약조건
-- 컬럼 레벨, 테이블 레벨에서 모두 설정 가능
-- 테이블 레벨로 많이 쓰임: (NOT NULL이 컬럼 레벨에서만 사용되므로 여러 제약 조건이 더해질 경우 가독성이 떨어질 수 있어서)
SELECT * FROM USER_NOCONST;

INSERT INTO USER_NOCONST -- 중복 데이터 삽입 가능
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-111능-2222', 'kang123@kh.or.kr');

CREATE TABLE USER_UNIQUE(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20) UNIQUE, --> 컬럼 레벨에서 제약조건 설정
    USER_PWD VARCHAR2(20),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
); 

INSERT INTO USER_UNIQUE -- 데이터 삽입 가능
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_UNIQUE -- 중복 ID 데이터 삽입
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');
-- ORA-00001: unique constraint (KH.SYS_C007061) violated (ID에 UNIQUE 제약조건 걸려있어 중복 데이터 삽입 불가)
-- 여기서 SYS 번호는 임의로 설정됨: 제약조건은 이름을 설정해줄 수 있는데, 설정하지 않으면 임의의 SYS 번호가 부여됨

CREATE TABLE USER_UNIQUE2(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    UNIQUE(USER_ID) --> 테이블 레벨에서 제약조건 설정
);

CREATE TABLE USER_UNIQUE3(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    UNIQUE(USER_ID, USER_NO) --> 한 쌍으로 UNIQUE 구분함
    -- UNIQUE(USER_ID), --> 이렇게 되면 하나씩 UNIQUE 구분함
    -- UNIQUE(USER_ID)
);

INSERT INTO USER_UNIQUE3
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_UNIQUE3
VALUES (2, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_UNIQUE3
VALUES (2, 'user02', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_UNIQUE3
VALUES (1, 'user02', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');
-- 위 4개 모두 데이터가 추가되는 이유?  USER_ID와 USER_NO가 묶여서 UNIQUE 조건이 걸렸기 때문이다.


-- 제약조건 이름 짓기
-- 컬럼 레벨: 컬럼명 자료타입 CONSTRAINT "제약조건이름" 제약 조건
-- 테이블 레벨: CONSTRAINT건 "제약조건이름" 제약조건
-- 컬럼명은 대게 "테이블이름-컬럼명-옵션"과 같은 형식으로 설정한다
CREATE TABLE CONS_NAME(
    TEST_DATA1 VARCHAR2(20) CONSTRAINT CN_TD1_NN NOT NULL, --> 컬럼 레벨에서 제약조건 이름 설정
    TEST_DATA2 VARCHAR2(20) CONSTRAINT CN_TD2_UQ UNIQUE, --> NN = NOT NULL / UQ = UNIQUE
    TEST_DATA3 VARCHAR2(30),
    CONSTRAINT CN_TD3_UK UNIQUE(TEST_DATA3) --> 테이블 레벨에서 제약조건 이름 설정
);

INSERT INTO CONS_NAME
VALUES(NULL, 'TEAT2', 'TEST3'); --> ORA-01400: cannot insert NULL into ("KH"."CONS_NAME"."TEST_DATA1")
INSERT INTO CONS_NAME
VALUES('TEAT1', 'TEAT2', 'TEST3');
INSERT INTO CONS_NAME
VALUES('TEAT1', 'TEAT2', 'TEST3'); --> unique constraint (KH.CN_TD2_UQ) violated




-------------------------------------------------------------------------------
-- PRIMARY KEY(PK, 기본키)
-- NOT NULL + UNIQUE 속성을 모두 가지고 있음
-- 테이블에서 한 행의 정보를 찾기 위해 사용할 컬럼 의미: 테이블에 대한 식별자 역할
-- 한 테이블 당 한 개의 PK만 설정 가능
-- 컬럼 레벨, 테이블 레벨 둘 다 설정 가능
CREATE TABLE USER_PRIMARYKEY(
    USER_NO NUMBER CONSTRAINT UR_UN_PK PRIMARY KEY, --> 컬럼 레벨에서 기본키 지정
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_PRIMARYKEY
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_PRIMARYKEY
VALUES (1, 'user02', 'pass02', '남나눔', '남', '010-2222-2222', 'nam123@kh.or.kr');
-- unique constraint (KH.UR_UN_PK) violated
-- PK인 USER_ID를 1로 중복 설정하자 UNIQUE특성에 위배되었다는 에러 메세지 발생

INSERT INTO USER_PRIMARYKEY
VALUES (NULL, 'user03', 'pass03', '도대담', '남', '010-3333-4444', 'doh123@kh.or.kr');
-- ORA-01400: cannot insert NULL into ("KH"."USER_PRIMARYKEY"."USER_NO")
-- PK가 UNIQUE와 NOT NULL 속성을 가지고 있기 때문에 에러 메세지도 PK에 문제가 있다는 종류의 메세지가 아니라
-- UINIQUE 혹은 NOT NULL에 위배되었음으로 출력됨

CREATE TABLE USER_PRIMARYKEY2(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    CONSTRAINT UR_USERNO_PK PRIMARY KEY(USER_NO, USER_ID) --> 테이블 레벨 설정, 이렇게 하면 한 쌍으로 조건 판단함
    --> !!주의 PK는 테이블 당 하나만 설정 가능
); -- 하나의 계정 안에서 제약조건 이름은 중복될 수 없음

--DROP TABLE USER_PRIMARYKEY2; -->테이블 제거하는 구문

INSERT INTO USER_PRIMARYKEY2
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_PRIMARYKEY2
VALUES (1, 'user02', 'pass02', '남나눔', '남', '010-2222-3333', 'nam123@kh.or.kr');

INSERT INTO USER_PRIMARYKEY2
VALUES (2, 'user01', 'pass01', '도대담', '남', '010-3333-4444', 'doh123@kh.or.kr');
-- 위 3개 모두 삽입 가능: USER_NO과 USER_ID를 한 쌍으로 판단하기 때문




-------------------------------------------------------------------------------
-- FOREIGN KEY(FK, 외래키)
-- 참조된 다른 테이블이 제공하는 값만 사용 가능
-- FOREIGN KEY 제약조건에 의해 테이블 간의 관계 형성
-- 제공되는 값 외에 NULL 값도 삽입 가능함

-- 컬럼 레벨에서 지정하는 경우
-- 컬럼명 자료형(크기) [CONSTRAINT 제약조건명] REFERENCES 참조테이블명 [(참조할 컬럼)] [삭제 룰]

-- 테이블 레벨에서 지정하는 경우
-- [CONSTRAINT 제약조건명] FOREIGN KEY(적용할 컬럼명) REFERENCES 참조테이블명 [(참조할 컬럼)] [삭제 룰]
CREATE TABLE USER_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);
INSERT INTO USER_GRADE VALUES(10, '일반회원');
INSERT INTO USER_GRADE VALUES(20, '우수회원');
INSERT INTO USER_GRADE VALUES(30, '특별회원');

SELECT * FROM USER_GRADE;

CREATE TABLE USER_FOREIGNKEY(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER,
    CONSTRAINT UF_GRADE_FK FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE(GRADE_CODE) --> 테이블 레벨에서 FK 설정
);

INSERT INTO USER_FOREIGNKEY
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY
VALUES (2, 'user02', 'pass02', '남나눔', '남', '010-2222-3333', 'nam123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY
VALUES (3, 'user03', 'pass03', '도대담', '남', '010-3333-4444', 'doh123@kh.or.kr', 30);

INSERT INTO USER_FOREIGNKEY
VALUES (4, 'user04', 'pass04', '류라라', '여', '010-4444-5555', 'ryu123@kh.or.kr', NULL);

SELECT * FROM USER_FOREIGNKEY;

INSERT INTO USER_FOREIGNKEY
VALUES (5, 'user05', 'pass05', '문미미', '여', '010-5555-6666', 'moon123@kh.or.kr', 50);
-- ORA-02291: integrity constraint (KH.UF_GRADE_FK) violated - parent key not found
SELECT * FROM USER_GRADE;
-- USER_FOREIGNKEY 테이블은 USER_GRADE 테이블을 부모로 삼고 USER_GRADE 테이블의 값을 참조하고 있음
-- 부모 테이블에 50에 대한 값이 설정되어 있지 않기 때문에 데이터를 삽입할 수 없다.



-------------------------------------------------------------------------------
-- 삭제 옵션 (DML 옵션)
DELETE FROM USER_GRADE
WHERE GRADE_CODE = 10;
-- ORA-02292: integrity constraint (KH.UF_GRADE_FK) violated - child record foundORA-02292: integrity constraint (KH.UF_GRADE_FK) violated - child record found
-- 삭제하려는 값을 참고하고 있는 자식 테이블이 있어 삭제할 수 없다는 에러 메세지

COMMIT;
-- 트랜잭션 : DB의 상태를 별화시키기 위해서 수행하는 작업 단위
-- COMMIT : 모든 작업을 정상적으로 처리하겠다고 확정하는 명령어
--          변경된 내용을 모두 영구 저장
--          COMMIT을 수행하면 하나의 트랜잭션 과정을 종료함
-- ROLLBACK : 작업 중 문제가 발생했을 때, 트랜잭션의 처리 과정에서 발생한 변경 사항을 취소하고 트랜잭션 과정 종료
-- DQL 명령은 데이터 테이블에 변경 사항이 생긴 것이 아니기 때문에 따로 COMMIT이 필요하지 않다.

DELETE FROM USER_GRADE
WHERE GRADE_CODE = 20;
--> USER_FOREIGNKEY 테이블에서 20을 참조한 적이 없기 때문에 삭제 가능

SELECT * FROM USER_GRADE;
-- 확인하면 20이 제거된 상태

ROLLBACK;
SELECT * FROM USER_GRADE;
-- 롤백하면 다시 이전 COMMIT POINT로 돌아가서 제거한 "20 우수회원" 튜플이 복구됨

CREATE TABLE USER_GRADE2(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);
INSERT INTO USER_GRADE2 VALUES(10, '일반회원');
INSERT INTO USER_GRADE2 VALUES(20, '우수회원');
INSERT INTO USER_GRADE2 VALUES(30, '특별회원');

CREATE TABLE USER_FOREIGNKEY2(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER,
    CONSTRAINT UF_GRADE_FK2 FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE2(GRADE_CODE) ON DELETE SET NULL
    -- 부모 키 삭제 시 자식 키를 NULL로 변경하는 옵션
);

INSERT INTO USER_FOREIGNKEY2
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY2
VALUES (2, 'user02', 'pass02', '남나눔', '남', '010-2222-3333', 'nam123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY2
VALUES (3, 'user03', 'pass03', '도대담', '남', '010-3333-4444', 'doh123@kh.or.kr', 30);

INSERT INTO USER_FOREIGNKEY2
VALUES (4, 'user04', 'pass04', '류라라', '여', '010-4444-5555', 'ryu123@kh.or.kr', NULL);

INSERT INTO USER_FOREIGNKEY2
VALUES (5, 'user05', 'pass05', '문미미', '여', '010-5555-6666', 'moon123@kh.or.kr', 50);
--> 삭제 옵션과 상관 없이 부모 테이블에 없는 값은 삽입 불가

COMMIT;

SELECT * FROM USER_GRADE2;
SELECT * FROM USER_FOREIGNKEY2;

DELETE FROM USER_GRADE2
WHERE GRADE_CODE = 10;
--> 삭제 옵션 때문에 참조 중인 튜플이 있어도 삭제 가능
SELECT * FROM USER_FOREIGNKEY2;
--> 삭제 후 GRADE_CODE의 값이 10인 튜플은 해당 값이 null로 바뀐 상태 확인 가능


CREATE TABLE USER_GRADE3(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);
INSERT INTO USER_GRADE3 VALUES(10, '일반회원');
INSERT INTO USER_GRADE3 VALUES(20, '우수회원');
INSERT INTO USER_GRADE3 VALUES(30, '특별회원');

CREATE TABLE USER_FOREIGNKEY3(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER,
    CONSTRAINT UF_GRADE_FK3 FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE3(GRADE_CODE) ON DELETE CASCADE
    --> 부모키 삭제 시 해당 값을 참조 중인 자식 튜플이 모두 제거됨
);

INSERT INTO USER_FOREIGNKEY3
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY3
VALUES (2, 'user02', 'pass02', '남나눔', '남', '010-2222-3333', 'nam123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY3
VALUES (3, 'user03', 'pass03', '도대담', '남', '010-3333-4444', 'doh123@kh.or.kr', 30);

INSERT INTO USER_FOREIGNKEY3
VALUES (4, 'user04', 'pass04', '류라라', '여', '010-4444-5555', 'ryu123@kh.or.kr', NULL);

INSERT INTO USER_FOREIGNKEY3
VALUES (5, 'user05', 'pass05', '문미미', '여', '010-5555-6666', 'moon123@kh.or.kr', 50);
--> CASCADE 옵션과 상관 없이 부모 테이블에 없는 값은 삽입 불가

COMMIT;

SELECT * FROM USER_GRADE3;
SELECT * FROM USER_FOREIGNKEY3;

DELETE FROM USER_GRADE3
WHERE GRADE_CODE = 10;
--> 부모키 삭제 시 해당 값을 참조 중인 자식 튜플이 모두 제거됨
SELECT * FROM USER_FOREIGNKEY2;



-- CHECK : 컬럼에 기록되는 값에 조건 설정
-- CHECK(컬럼명 비교연산자 비교값)
-- 비교 값은 리터럴만 사용 가능, 변하는 값이나 함수 사용 불가
CREATE TABLE USER_CHECK(
    USER_NO NUMBER PRIMARY KEY, --> 컬럼 레벨에서 기본키 지정
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10) CHECK(GENDER IN ('남','녀')), --> 남, 녀 값만 저장 가능
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_CHECK
VALUES (1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_CHECK
VALUES (2, 'user02', 'pass02', '남나눔', '남자', '010-2222-3333', 'nam123@kh.or.kr');
-->  check constraint (KH.SYS_C007115) violated

-- 비교 값은 리터럴만 사용 가능, 변하는 값이나 함수 사용 불가
CREATE TABLE USER_CHECK2(
    TEST_NUMBER NUMBER, --> 컬럼 레벨에서 기본키 지정
    CONSTRAINT UC2_TN_CK CHECK(TEST_NUMBER > 0)
);

INSERT INTO USER_CHECK2
VALUES(10);

INSERT INTO USER_CHECK2
VALUES(-10);
-- check constraint (KH.UC_TN_CK) violated, 양수만 입력 가능하도록 제약 조건 설정함

CREATE TABLE USER_CHECK3(
    C_NAME VARCHAR2(15 CHAR),
    --> VARCHAR2(15):15 Byte(한글은 3바이트이므로 7글자 가능)
    --> VARCHAR2(15 CHAR): 15글자
    C_PRICE NUMBER,
    C_LEVEL CHAR(1),
    C_DATE DATE,
    CONSTRAINT UC3_CN_PK PRIMARY KEY(C_NAME),
    CONSTRAINT UC3_CP_CK CHECK(C_PRICE BETWEEN 1 AND 99999),
    CONSTRAINT UC3_CL_CK CHECK(C_LEVEL = 'A' OR C_LEVEL = 'B' OR C_LEVEL = 'C'),
    CONSTRAINT UC3_CD_CK CHECK(C_DATE >= TO_DATE('2016/01/01','YYYY/MM/DD'))
);



-- SUBQUARY를 이용한 테이블 생성 (기존 테이블 복사)
CREATE TABLE EMPLOYEE_COPY
AS
SELECT * FROM EMPLOYEE;

-- SUBQUARY로 필요한 정보만 가져와서 테이블 생성
CREATE TABLE EMPLOYEE_COPY2
AS
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE);

-- 제약조건 추가
-- ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명)
-- ALTER TABLE 테이블명 ADD FOREIGN KEY(컬럼명) REFERENCES 테이블명(컬럼명)
-- ALTER TABLE 테이블명 ADD UNIQUE(컬럼명)
-- ALTER TABLE 테이블명 ADD CHECK(컬럼명)
-- ALTER TABLE 테이블명 MODIFY (컬럼명) NOT NULL
CREATE TABLE USER_GRADE4(
    GRADE_CODE NUMBER,
    GRADE_NAME VARCHAR2(30)
);

ALTER TABLE USER_GRADE4 ADD PRIMARY KEY(GRADE_CODE); --> ALTER(변경)의 ADD 명령을 통해 PK 제약조건 추가


CREATE TABLE USER_FOREIGNKEY4(
   USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER
);

ALTER TABLE USER_FOREIGNKEY4 ADD UNIQUE(USER_ID);
ALTER TABLE USER_FOREIGNKEY4 MODIFY USER_PWD NOT NULL;
ALTER TABLE USER_FOREIGNKEY4 ADD CHECK(GENDER IN('남', '여'));
ALTER TABLE USER_FOREIGNKEY4 ADD FOREIGN KEY (GRADE_CODE) REFERENCES USER_GADE4;

-- DEPARTMENT 테이블의 LOCATION_ID에 외래키 제약조건 추가
-- 참조 테이블은 LOCATION, 참조 컬럼은 LOCATION의 기본키
ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION; -- LOCAL_CODE가 참조 테이블의 PK이므로 생략 가능
-- OR: ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION(LOCATION_CODE);

-- [실습 문제]
-- 회원가입용 테이블 생성(USER_TEST)
-- 컬럼명 : USER_NO(회원번호) - 기본키(PK_USER_NO), 
--         USER_ID(회원아이디) - 중복금지(UK_USER_ID),
--         USER_PWD(회원비밀번호) - NULL값 허용안함(NN_USER_PWD),
--         PNO(주민등록번호) - 중복금지(UK_PNO), NULL 허용안함(NN_PNO),
--         GENDER(성별) - '남' 혹은 '여'로 입력(CK_GENDER),
--         PHONE(연락처),
--         ADDRESS(주소),
--         STATUS(탈퇴여부) - NOT NULL(NN_STATUS), 'Y' 혹은 'N'으로 입력(CK_STATUS)
-- 각 컬럼의 제약조건에 이름 부여할 것
-- 5명 이상 INSERT할 것