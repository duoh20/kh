-- DML: 데이터 조작 언어
-- 테이블에 값을 삽입하거나(INSERT), 수정하거나(UPDATE), 삭제(DELETE)하는 구문

-- INSERT
-- 새로운 행을 추가하는 구문(테이블 행 개수 증가)
-- INSET INTO 테이블명[(컬럼명1, 컬럼명2, 컬럼3, ...)]
-- VALUES(데이터1, 데이터2, 데이터3, ...)
-- 테이블에 내가 선택한 컬럼에 대한 값 INSERT를 하고 싶을 때는 테이블 명 뒤에 컬럼명 작성 : 선택 안된 컬럼은 NULL이 들어감
-- 테이블 명 뒤에 컬럼 명을 작성하지 않는다면 모든 컬럼에 대한 값을 INSERT함: 단 컬럼의 순서를 지켜서 VALUES에 기입

-- EMPLOYEE 테이블에 장채현 사원 정보 저장
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL,
                     SALARY, BONUS, MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN)
VALUES(900, '장채현', '901111-2050503', 'jang_ch@kh.or.kr', '01055557834', 'D1', 'J7', 'S3',
       4300000, 0.2, '200', SYSDATE, NULL, DEFAULT);
       --> ENT_YN의 DEFAULT 값이 'N'으로 셋팅되어 있으므로 N 값이 들어감

ROLLBACK;

INSERT INTO EMPLOYEE -->
VALUES(900, '장채현', '901111-2050503', 'jang_ch@kh.or.kr', '01055557834', 'D1', 'J7', 'S3',
       4300000, 0.2, '200', SYSDATE, NULL, DEFAULT);
       
COMMIT;

-- 모든 사원의 사원 번호, 사원명, 부서명이 담긴 테이블
CREATE TABLE EMP_01(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    DEPT_TITLE VARCHAR2(20)
);

INSERT INTO EMP_01(
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
         LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
);

SELECT * FROM EMP_01;

CREATE TABLE TB FROM EMPLOYEE WEHRE 1=2;
SELECT * FROM TB;
DROP TABLE TB;

-- INSERT ALL
-- INSERT 시 서브 쿼리가 사용하는 테이블이 같은 경우
-- 두 개 이상의 테이블에 INSERT ALL을 이용해 한 번에 삽입 가능
-- 단, 서브쿼리의 조건절이 같아야함

CREATE TABLE EMP_DEPT_D1
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
   FROM EMPLOYEE
   WHERE 1 = 0;
   --> 1 = 0이 거짓이라서 아무 데이터도 들어가지 않음
   
SELECT * FROM EMP_DEPT_D1;

CREATE TABLE EMP_MANAGER
AS SELECT EMP_ID, EMP_NAME, MANAGER_ID
   FROM EMPLOYEE
   WHERE 1 = 0;
   
SELECT * FROM EMP_MANAGER;

-- EMP_DEPT_D1 테이블에 EMPLOYEE 테이블에 있는 부서코드가 D1인 직원을 조회하여 사번, 이름, 소속부서, 입사일 삽입
-- EMP_MANAGER 테이블에 EMPLOYEE 테이블에 있는 부서코드가 D1인 직원을 조회하여 사번, 이름, 관리자 사번 삽입

-- 각각 집어 넣기
INSERT INTO EMP_DEPT_D1(
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1'
);

INSERT INTO EMP_MANAGER(
    SELECT EMP_ID, EMP_NAME, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1'
);

SELECT * FROM EMP_DEPT_D1;
SELECT * FROM EMP_MANAGER;

ROLLBACK;

-- 한 번에 집어 넣기
INSERT ALL
INTO EMP_DEPT_D1 VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1';

-- EMPLOYEE 테이블의 구조를 복사하여 사번, 이름, 입사일, 급여를 기록할 수 있는 EMP_OLD 테이블, EMP_NEW 테이블 실행
CREATE TABLE EMP_OLD
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
   FROM EMPLOYEE
   WHERE 1 = 0;
   
CREATE TABLE EMP_NEW
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
   FROM EMPLOYEE
   WHERE 1 = 0;
   
-- EMPLOYEE 테이브르이 입사일 기준으로 2000년 1월 1일 이전에 입사한 사원의 사번, 이름, 급여, 입사일 조회하여
-- EMP_OLD 테이블에 삽입하고 이후에 입사한 사원의 정보는 EMP_NEW 테이블에 삽입

INSERT INTO EMP_OLD(
    SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
    FROM EMPLOYEE
    WHERE HIRE_DATE < '2000/01/01'
);
    
INSERT INTO EMP_NEW(
    SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
    FROM EMPLOYEE
    WHERE HIRE_DATE >= '2000/01/01'
);

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;
ROLLBACK;

-- 한 번에 작성하기
INSERT ALL
WHEN HIRE_DATE < '2000/01/01'
     THEN INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
WHEN HIRE_DATE >= '2000/01/01'
     THEN INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE;

ROLLBACK;



-- WHEN - ELSE로 작성하기
INSERT ALL
WHEN HIRE_DATE < '2000/01/01'
     THEN INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
ELSE
     INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE;




--------------------------------------------------------------------------------
-- UPDATE : 테이블에 기록된 컬럼의 값 수정(전체 행 개수에는 변화 없음)
-- UPDATE 테이블명
-- SET 컬럼명 = 바꿀값
-- [WHERE 컬럼명 비교연산자 비교값]; --> 조건 생성 가능
CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY;

-- DEPT_COPY 테이블에서 DEPT_ID가 'D9'인 행의 DEPT_TITLE을 '전략기획팀'으로 수정
UPDATE DEPT_COPY
SET DEPT_TITLE = '전략기획팀'; --> DEPT_TITLE의 모든 데이터가 전략기획팀으로 바뀜

SELECT * FROM DEPT_COPY;
ROLLBACK;

UPDATE DEPT_COPY
SET DEPT_TITLE = '전략기획팀'
WHERE DEPT_ID = 'D9';
-- 총무부에서 전략기획팀으로 수정됨

COMMIT;

-- 방명수 사원의 급여와 보너스 율을 유재식 사원과 동일하게 변경
CREATE TABLE EMP_SALARY
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS
   FROM EMPLOYEE;

SELECT * FROM EMP_SALARY
WHERE EMP_NAME IN ('유재식', '방명수');

UPDATE EMP_SALARY
SET SALARY = (SELECT SALARY
              FROM EMPLOYEE
              WHERE EMP_NAME = '유재식'),
    BONUS = (SELECT BONUS
              FROM EMPLOYEE
              WHERE EMP_NAME = '유재식')
WHERE EMP_NAME = '방명수';

UPDATE EMP_SALARY
SET (SALARY, BONUS) = (SELECT SALARY, BONUS
                       FROM EMPLOYEE
                       WHERE EMP_NAME = '유재식')
WHERE EMP_NAME IN ('노옹철', '전형돈', '정중하', '하동운');

SELECT * FROM EMP_SALARY
WHERE EMP_NAME IN ('유재식', '방명수', '노옹철', '전형돈', '정중하', '하동운');

-- EMP_SALARY 테이블에서 아시아 지역에 근무하는 직원의 보너스를 0.3으로 변경
-- 아시아 지역에 근무하는 직원의 사번, 이름, 급여, 보너스, 근무지역 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS, LOCAL_NAME
FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE LOCAL_NAME LIKE '%ASIA%';

-- 아시아 지역에 근무하는 직원의 보너스를 0.3.으로 업데이트
UPDATE EMP_SALARY
SET BONUS = 0.3
WHERE EMP_ID IN(SELECT EMP_ID
                FROM EMPLOYEE
                JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
                WHERE LOCAL_NAME LIKE '%ASIA%');

SELECT * FROM EMP_SALARY;

COMMIT;

-- UPDATE 시 주의사항! : UPDATE할 떄 변경할 값은 해당 컬럼에 대한 제약조건에 위배되지 않아야함
-- EMPLOYEE 테이블의 DEPT_CODE에 외래키 제약조건 추가
-- 참조 테이블은 DEPARTMENT, 참조 컬럼은 DEPARTMENT의 기본키
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT;

UPDATE EMPLOYEE
SET DEPT_CODE = '65'
WHERE DEPT_CODE = 'D6';
--> FK 제약조건 위반 에러: integrity constraint (KH.SYS_C007146) violated - parent key not found
--> DEPT_CODE에 65가 없어서 에러

SELECT * FROM EMP_SALARY;

ROLLBACK;

UPDATE DEPARTMENT
SET LOCATION_ID = '65'
WHERE LOCATION_ID = 'L2';
--> FK 제약조건 위반 에러: integrity constraint (KH.SYS_C007133) violated - parent key not found

UPDATE EMPLOYEE
SET EMP_NAME = NULL
WHERE EMP_ID = 200;
--> NOT NULL 제약 조건 위반 에러: cannot update ("KH"."EMPLOYEE"."EMP_NAME") to NULL



--------------------------------------------------------------------------------
-- DELETE : 테이블의 행을 삭제하는 구문(테이블의 행 개수가 줄어듦)
-- DELETE FROM 테이블명 WHERE 조건 설정
-- 만일 WHERE 조건 설정을 하지 않으면 모든 행이 다 삭제됨

COMMIT;

SELECT * FROM EMPLOYEE; --> 24개 행 확인

DELETE FROM EMPLOYEE
WHERE EMP_NAME = '장채현';

SELECT * FROM EMPLOYEE; --> 23개 행 확인

ROLLBACK;

SELECT * FROM EMPLOYEE;

DELETE FROM EMPLOYEE; --> 0개 행 확인

SELECT * FROM EMPLOYEE;

ROLLBACK;

SELECT * FROM EMPLOYEE;

DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1';
--> 제약 조건이 걸려서 삭제 불가: integrity constraint (KH.SYS_C007146) violated - child record found
--> 제약조건 비활성화하기 
ALTER TABLE EMPLOYEE
DISABLE CONSTRAINT SYS_C007146 CASCADE;

DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1';

SELECT * FROM DEPARTMENT; --> D1 삭제된 것 확인
SELECT * FROM EMPLOYEE; --> 자식 테이블엔 남아있음, 영향 안받음
ROLLBACK;

ALTER TABLE EMPLOYEE
ENABLE CONSTRAINT SYS_C007146; --> 다시 제약 조건 살리기

-- TRUNCATE : 테이블 전체 행 삭제 시 사용
--            DELETE보다 수행 속도가 더 빠름
--            ROLLBACK을 통해 복구 불가 (DELETE는 가능)
--            진짜 아예 필요 없는 데이터만 TRUNCATE로 삭제하자

SELECT * FROM EMP_SALARY;
COMMIT;

DELETE FROM EMP_SALARY;
SELECT * FROM EMP_SALARY;

ROLLBACK;
SELECT * FROM EMP_SALARY;

TRUNCATE TABLE EMP_SALARY; --> Table EMP_SALARY이(가) 잘렸습니다.
SELECT * FROM EMP_SALARY;

ROLLBACK;
SELECT * FROM EMP_SALARY; --> 롤백해도 복구가 안됨

SELECT *
FROM MEMBER;