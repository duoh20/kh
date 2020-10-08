-- VIEW(뷰)
-- SELECT 쿼리 실행 결과 화면을 저장한 객체
-- 논리적 가상 테이블
-- 실질적으로 데이터를 저장하고 있지 않음
-- 테이블을 사용하는 것과 동일하게 사용 가능

-- CREATE [OR REPLACE] VIEW 뷰 명 AS 서브쿼리
-- OR REPLACE : 뷰 생성 시 기존에 같은 이름의 뷰가 있다면 해당 뷰 변경

-- 사번, 이름, 부서명, 근무 지역을 조회하고 그 결과를 V_EMPLOYEE라는 뷰를 생성하여 저장
CREATE OR REPLACE VIEW V_EMPLOYEE
AS
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     LEFT JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
     LEFT JOIN NATIONAL USING(NATIONAL_CODE);
-- 에러: insufficient privileges
-- 권한이 없음, 사용자 계정(KH)에 VIEW를 생성할 수 있는 권한을 줘야함
--> 관리자 계정(SYSTEM)에 접속해 GRANT CREATE VIEW TO KH; 실행

SELECT * FROM V_EMPLOYEE; -- 생성된  VIEW 확인

COMMIT;

SELECT *
FROM EMPLOYEE
WHERE EMP_ID = 205; --> 결과: 정중하

SELECT *
FROM V_EMPLOYEE
WHERE EMP_ID = 205; --> 결과: 정중하

UPDATE EMPLOYEE
SET EMP_NAME = '정중앙'
WHERE EMP_ID = 205;

SELECT *
FROM EMPLOYEE
WHERE EMP_ID = 205; --> 결과: 정중앙

SELECT *
FROM V_EMPLOYEE
WHERE EMP_ID = 205; --> 결과: 정중앙
-- 본 테이블이 바뀌면 VIEW의 자료도 함께 변경된다.

ROLLBACK;

-- 생성된 뷰 컬럼에 별칭 부여
-- !! 서브쿼리의 SELECT절에 함수가 사용된 경우 반드시 별칭 지정 !!
-- 사번, 사원명, 직급명, 성별(남/녀), 근무연수 조회
--SELECT EMP_ID 사번, EMP_NAME "사원 명", JOB_NAME "직급 명", DECODE(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) "근무 연수",
--       CASE WHEN SUBSTR(EMP_NO, 8, 1) = '1' THEN '남'
--            ELSE '여'
--       END 성별
--FROM EMPLOYEE
--     LEFT JOIN JOB USING(JOB_CODE);
CREATE OR REPLACE VIEW V_EMP_JOB
AS
SELECT EMP_ID 사번, EMP_NAME 이름, JOB_NAME 직급,
       DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', '여') 성별,
       EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) 근무연수
       -- 에러: must name this expression with a column alias
       --> 서브 쿼리는 반드시 별칭 지정해함
FROM EMPLOYEE
     LEFT JOIN JOB USING(JOB_CODE);

SELECT * FROM V_EMP_JOB; 

-- 별칭 한 번에 입력하기
-- 별칭에 띄어쓰기, 특수문자 포함된 경우 ""로 묶어줌
CREATE OR REPLACE VIEW V_EMP_JOB(사번, 사원이름, 직급이름, 남여, 근무연수)
AS
SELECT EMP_ID, EMP_NAME, JOB_NAME,
       DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', '여'),
       EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEE
     LEFT JOIN JOB USING(JOB_CODE);

SELECT * FROM V_EMP_JOB;


--------------------------------------------------------------------------------

CREATE OR REPLACE VIEW V_JOB
AS
SELECT JOB_CODE, JOB_NAME
FROM JOB;

SELECT * FROM JOB;
SELECT * FROM V_JOB;

INSERT INTO V_JOB VALUES('J8', '인턴');

SELECT * FROM JOB;
SELECT * FROM V_JOB;

UPDATE V_JOB
SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8';

SELECT * FROM JOB;
SELECT * FROM V_JOB;

DELETE FROM V_JOB
WHERE JOB_CODE = 'J8';

SELECT * FROM JOB;
SELECT * FROM V_JOB;
--> VIEW 테이블에 INSET, UPDATE, DELETE하면 본 테이블에도 수정 내용이 반영됨


-- 뷰의 구조
SELECT * FROM USER_VIEWS;
-- USER_VIEWS: DD(Data Dictionary)의 한 종류로 사용자 정의 뷰 확인하고자 할 때 사용
-- USER_VIEWS의 TEXT 컬럼을 보면 내가 작성한 SQL 구문이 저장되어 있음

-- DML 명령어로 조작이 불가능한 경우
-- 1. 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
-- 2. 뷰에 포함되지 않은 컬럼 중에 베이스가 되는 테이블 컬럼이 NOT NULL 제약조건이 지정된 경우
-- 3. 산술표현식으로 정의된 경우
-- 4. 그룹함수나 GROUP BY절을 포함한 경우
-- 5. DISTINCT를 포함한 경우
-- 6. JOIN을 이용해 여러 테이블을 연결한 경우

-- 1. 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
CREATE OR REPLACE VIEW V_JOB2
AS
SELECT JOB_CODE
FROM JOB;

SELECT * FROM V_JOB2;

INSERT INTO V_JOB2 VALUES('J8', '인턴');
UPDATE V_JOB2 SET JOB_NAME = '인턴' WHERE JOB_CODE = 'J7';
DELETE FROM V_JOB2 WHERE JOB_NAME = '인턴';
--> JOB_NAME 컬럼이 존재하지 않기 떄문에 삽입, 변경, 삭제 모두 불가능

-- 2. 뷰에 포함되지 않은 컬럼 중에 베이스가 되는 테이블 컬럼이 NOT NULL 제약조건이 지정된 경우
CREATE OR REPLACE VIEW V_JOB3
AS
SELECT JOB_NAME
FROM JOB;

SELECT * FROM V_JOB3;

INSERT INTO V_JOB3 VALUES('인턴'); --> NOT_NULL 에러: 본테이블에 JOB_CODE가 NOT NULL인 제약 조건이 있어서 삽입 불가
INSERT INTO JOB VALUES('J8', '인턴'); -- 본 테이블에 값 추가
SELECT * FROM V_JOB3;
UPDATE V_JOB3 SET JOB_NAME = '알바' WHERE JOB_NAME = '인턴'; -- 변경 성공
DELETE FROM V_JOB3 WHERE JOB_NAME = '알바'; --변경 성공
SELECT * FROM JOB;
SELECT * FROM V_JOB3;
--> NOT_NULL 제약 조건에 걸리지 않으면 삽입, 변경, 삭제 모두 가능


-- 3. 산술표현식으로 정의된 경우
-- 사번, 이름, 급여, 보너스가 포함된 연봉 데이터를 가지고 있는 EMP_SAL 뷰 생성
CREATE OR REPLACE VIEW EMP_SAL
AS
SELECT EMP_ID, EMP_NAME, (SALARY + SALARY * NVL(BONUS,0)) 연봉, BONUS --> NVL 함수를 사용했으므로 VIEW 생성을 위해 별칭을 붙여줘야함
FROM EMPLOYEE;

SELECT * FROM EMP_SAL;

INSERT INTO EMP_SAL VALUES(800, '정진훈', 3000000, 36000000);
UPDATE EMP_SAL SET 연봉 = 800000 WHERE EMP_ID = 200;
-- 에러: virtual column not allowed herevirtual column not allowed here
--> 연봉에 산술 표현식으로 정의되어 있어서 수정 불가

COMMIT;

SELECT * FROM EMP_SAL WHERE 연봉 = 6000000;
DELETE FROM EMP_SAL WHERE 연봉 = 6000000;

ROLLBACK;


-- 4. 그룹함수나 GROUP BY절을 포함한 경우
-- 부서코드, 급여 합계, 급여 평균 데이터를 가지고 있는 V_GROUPDEPT 뷰 생성
CREATE OR REPLACE VIEW V_GROUPDEPT
AS
SELECT DEPT_CODE, SUM(SALARY) "급여 합계", FLOOR(AVG(SALARY)) "급여 평균"
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT * FROM V_GROUPDEPT;

INSERT INTO V_GROUPDEPT VALUES('D10', 6000000, 4000000);
UPDATE V_GROUPDEPT SET DEPT_CODE = 'D10' WHERE DEPT_CODE = 'D1';
DELETE FROM V_GROUPDEPT WHERE DEPT_CODE = 'D1';
-- 에러: virtual column not allowed here


-- 5. DISTINCT를 포함한 경우
CREATE OR REPLACE VIEW V_DT_EMP
AS
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

SELECT * FROM V_DT_EMP;

INSERT INTO V_DT_EMP VALUES('J9');
UPDATE V_DT_EMP SET JOB_CODE = 'J9' WHERE JOB_CODE = 'J7';
DELETE FROM V_DT_EMP WHERE JOB_CODE = 'J1';
-- 에러: data manipulation operation not legal on this view

-- 6. JOIN을 이용해 여러 테이블을 연결한 경우
CREATE OR REPLACE VIEW V_JOINEMP
AS
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
     
SELECT * FROM V_JOINEMP;

INSERT INTO V_JOINEMP VALUES(888, '조세오', '인사관리부');
-- cannot modify more than one base table through a join view
UPDATE V_JOINEMP SET DEPT_TITLE = '인사관리부' WHERE EMP_ID = '219';
-- cannot modify a column which maps to a non key-preserved table

COMMIT;

DELETE FROM V_JOINEMP WHERE EMP_ID = 219;
--> 삭제는 가능함

SELECT * FROM V_JOINEMP;
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT; --> 영향받지 않음

ROLLBACK;



-- VIEW 옵션
-- 1. OR RELACE : 동일한 뷰 이름이 존재하면 덮어쓰고, 존재하지 않으면 새로 생성
-- 2. FORCE / NOFORCE
--    FORCE: 서브쿼리에 사용된 테이블이 ----- 뷰 생성
--    NOFORCE: 서브쿼리에 사용된 테이블이 ----- 뷰 생성
-- 3. WITH CHECK OPTION : 옵션을 설정한 컬럼의 값을 ----하게 함
-- 4. WITH READ ONLY: 뷰를 ----(--- 수행 불가)


-- 1. OR RELACE : 동일한 뷰 이름이 존재하면 덮어쓰고, 존재하지 않으면 새로 생성
CREATE OR REPLACE VIEW V_EMP1
AS
SELECT EMP_NO, EMP_NAME
FROM EMPLOYEE;

SELECT * FROM V_EMP1;

CREATE OR REPLACE VIEW V_EMP1
AS
SELECT EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE;

SELECT * FROM V_EMP1;

CREATE VIEW V_EMP1 --> OR REPLACE를 제거
AS
SELECT EMP_NO, SALARY
FROM EMPLOYEE;
-- name is already used by an existing object

SELECT * FROM V_EMP1;



-- 2. FORCE / NOFORCE
--    FORCE: 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성
--    NOFORCE: 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성(기본 값)
CREATE OR REPLACE FORCE VIEW V_EMP2
AS
SELECT TCODE, TNAME, TCONTENT
FROM TT;
-- 컴파일 오류와 함께 뷰가 생성되었습니다.
--> TT라는 테이블이 존재하지 않지만 VIEW는 생성된다.

SELECT * FROM V_EMP2; --> SELECT 불가
SELECT * FROM USER_VIEWS; -- SELECT * FROM V_EMP2;

CREATE OR REPLACE NOFORCE VIEW V_EMP2 -- NOFORCE가 디폴트, 안적어도 생성 안되는 건 동일함
AS
SELECT TCODE, TNAME, TCONTENT
FROM TT; --> table or view does not exist


-- 3. WITH CHECK OPTION : 옵션을 설정한 컬럼의 값을 수정 불가능 하게 함
CREATE OR REPLACE VIEW V_EMP3
AS
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'
WITH CHECK OPTION;

SELECT * FROM V_EMP3;

UPDATE V_EMP3 SET DEPT_CODE = 'D1' WHERE EMP_ID = 200;
-- 에러  view WITH CHECK OPTION where-clause violation
--> VIEW 생성 시 WHERE 절에 DEPT_CODE 컬럼에 WITH CHECK OPTION 걸어서 수정 불가
UPDATE V_EMP3 SET EMP_NAME = '박신우' WHERE EMP_ID = 200;
SELECT * FROM V_EMP3;

ROLLBACK;


-- 4. WITH READ ONLY: 뷰를 조회만 가능(DML 수행 불가)
CREATE OR REPLACE VIEW V_DEPT
AS
SELECT * FROM DEPARTMENT
WITH READ ONLY;

SELECT * FROM V_DEPT;
DELETE FROM V_DEPT;
-- 에러: cannot perform a DML operation on a read-only view
--> VIEW 생성 시 WITH READ ONLY 옵션을 걸어서 수정 불가


-- SEQUENCE
-- :순자적으로 정수 값을 자동으로 생성하는 객체로 자동 번호 발생기 역할을 함






