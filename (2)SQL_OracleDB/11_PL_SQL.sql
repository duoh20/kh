-- PL/SQL (Procedural Language extension to SQL)
-- 오라클 자체에 내장되어 있는 절차적 언어
-- SQL문장 내에서 변수의 정의, 조건처리(IF), 반복처리(LOOP, FOR, WHILE)등을 지원하여 SLQ의 단점 보완

-- PL/SQL의 구조
-- 선언부(DECLARER SECTOION) : DECLARE로 시작, 변수/상수 선언
-- 실행부(EXECUTABLE SECTION) : BEGIN으로 시작, 제어문/반복문/함수 정의 등 로직 기술
-- 예외처리부 (EXCEPTION ECTION) : EXCEPTION으로 시작, 예외 발생 시 해결하기 위한 문장 기술

-- PL/SQL의 장점
-- BLOCK 구조로 다수의 SQL 문장을 한 번에 ORACLE DB로 보내 처리하므로 수행 속도 향상
-- 단순하며, 복잡한 데이터 형태의 변수 및 테이블의 데이터 구조와 컬렴 명의 준하여 동적으로 변수를 생성할 수 있음



/* PL/SQL 구문 작성하기 */
-- 출력하는 내용을 화면에 보여주도록 설정하는 환경변수를 ON으로 설정 (디폴트는 OFF)
SET SERVEROUTPUT ON;

-- 화면에 HELLO WORLD 출력
-- System.out.println("HELLO WORLD");
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD');
END;
/
--> /는 환전한 종결을 의미하므로 항상 PL/SQL 구문의 마지막에 입력해줘야함

-- 타입 변수 선언
-- 변수 선언 및 초기화, 변수 값 출력

DECLARE
--선언부: 변수선언
    EMP_ID NUMBER; -- 자바: int emp_id와 같음
    EMP_NAME VARCHAR2(20); -- 자바: String emp_name
    
    PI CONSTANT NUMBER := 3.14; -- 자바: final int PI = 3.14;
    --> := 변수 대입 연산자
BEGIN
--실행부: 함수작성
    EMP_ID := 888;
    EMP_NAME := '배장남';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID); -- DBMS에서는 연결연산자 ||로 연결
    --System.out.println("emp_id : " + empt_id); -- java는 +로 연결
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('PI :  ' || PI);
END;
/


/* 레퍼런스 변수의 선언과 초기화, 변수 값 출력 */
DECLARE
    ID EMPLOYEE.EMP_ID%TYPE;
    -- 변수 EMP_ID의 타입을 EMPLOYEE 테이블의 EMP_ID 컬럼 타입으로 지정
    -- 변수는 EMPLOYEE 테이블에 정의한 컬럼 명과 같아도 되고 달라도 됨
    NAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO ID, NAME --> INTO절 추가해 조회한 값을 받을 변수 지정
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번'; 
    --> '&'은 자바의 Scanner처럼 사용자 입력을 받음, 안내문에 들어갈 컬럼명을 입력
    -- 입력창에 <'사번'에 대한 값 입력> 이라는 알림으로 표시
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || NAME);
END;
/

-- 레퍼런스 변수로 EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY를 선언하고
-- EMPLOYEE 테이블에서 사번, 이름, 직급코드, 부서코드, 급여를 조회한 후 선언한 레퍼런스 변수에 담어 출력하라
-- 단, 입력 받은 이름과 일치하는 조건의 직원을 조회하라
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_CODE EMPLOYEE.DEPT_CODE%TYPE;
    JOB_CODE EMPLOYEE.JOB_CODE%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
    INTO EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
    FROM EMPLOYEE
    WHERE EMP_NAME = '&사원이름';

    DBMS_OUTPUT.PUT_LINE('사번 : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('부서코드 : ' || DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('직급코드 : ' || JOB_CODE);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SALARY);    
END;
/

-- 한 행에 대한 ROWTYPE 변수 선언과 초기화
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('EMP_NO : ' || E.EMP_NO);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || E.SALARY);
END;
/

/* 선택문(조건문) */
-- IF - THEN - END IF (단일 IF문)
-- EMP_ID를 입력 받아 해당 사원의 사번, 이름, 급여, 보너스율 출력
-- 단, 보너스를 받지 않는 사원은 보너스율 출력 전 '보너스를 지급받지 않는 사원입니다.' 출력
DECLARE
    ID EMPLOYEE.EMP_ID%TYPE;
    NAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, BONUS
    INTO ID, NAME, SALARY, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || NAME);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || SALARY);
    
    IF(BONUS IS NULL)
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다.');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || BONUS * 100 || '%');

END;
/


-- IF - THEN - ELSE - END IF (IF-ELSE문)
-- EMP_ID를 입력 받아 해당 사원의 사번, 이름, 부서명, 소속 출력
-- TEAM 변수를 만들어 소속이 'KO'인 사원은 '국내팀', 아닌 사원은 '해외팀' 저장
DECLARE
    ID EMPLOYEE.EMP_ID%TYPE;
    NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPTTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NATIONALCODE LOCATION.NATIONAL_CODE%TYPE;
    
    TEAM VARCHAR2(20);
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    INTO ID, NAME, DEPTTITLE, NATIONALCODE
    FROM EMPLOYEE
         LEFT FULL JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
         JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
    WHERE EMP_ID = '&사번';
    
    IF(NATIONALCODE = 'KO')
        THEN  TEAM := '국내팀';
    ELSE
        TEAM := '해외팀';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || NAME);
    DBMS_OUTPUT.PUT_LINE('부서명 : ' || DEPTTITLE);
    DBMS_OUTPUT.PUT_LINE('소속 : ' || NATIONALCODE);
    DBMS_OUTPUT.PUT_LINE('팀 : ' || TEAM);
END;
/

-- 사원의 연봉을 구하는 PL/SQL 작성
-- 보너스가 있는 사원은 보너스도 포함하여 계산
-- 급여 이름 연봉(보너스 포함, ₩999,999,999형식으로 출력)
-- 연봉은 따로 변수를 만들어서 값 저장
DECLARE
    VEMP EMPLOYEE%ROWTYPE;
    YSALARY NUMBER;
BEGIN
    SELECT *
    INTO VEMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    -- YSALARY := VEMP.SALARY * (1 + NVL(VEMP.BONUS, 0) * 12);
    
    IF(VMEP.BONUS IS NULL)
        THEN YSALARY := VEMP.SALARY * 12;
    ELSE
        YSALARY := VEMP.SALARY * (1 + VEMP.BONUS) * 12;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('이름 : ' || VEMP.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || VEMP.SALARY);
    DBMS_OUTPUT.PUT_LINE('연봉 : ' || TO_CHAR(YSALARY, 'FML999,999,999'));
    
END;
/

 SELECT EMP_ID, SALARY, TO_CHAR(SALARY * (1+ NVL(BONUS, 0)) * 12, 'FML999,999,999')
 FROM EMPLOYEE;
 
 
 -- IF - THEN - ELSIF - ELSE - END IF (IF - ELSE IF문)
 -- 점수를 입력받아 SCORE 변수에 저장
 -- 90점 이상은 'A', 80점 이상은 'B', 70점 이상은 'C', 60점 이상은 'D', 60점 미만은 'F'로 처리해 GREAD 변수 저장
 -- 당신의 점수는 90점이고, A학점입니다.
 DECLARE
    SCORE INT; -- ANCI 타입 자료형
    GRADE VARCHAR2(2);
 BEGIN
    SCORE := '&점수';
    
    IF SCORE >= 90 THEN GRADE := 'A';
    ELSIF SCORE >= 80 THEN GRADE := 'B';
    ELSIF SCORE >= 70 THEN GRADE := 'C';
    ELSIF SCORE >= 60 THEN GRADE := 'D';
    ELSE GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('당신의 점수는 ' || SCORE || '점이고, 학점은 ' || GRADE || '학점입니다.' );
 END;
/

-- CASE - WHEN - THEN - END (SWITCH-CASE문)
-- 사번을 입력하여 해당 사원의 사번, 이름, 부서 명 출력
DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DNAME VARCHAR2(20);
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    DNAME := CASE EMP.DEPT_CODE
                WHEN 'D1' THEN '인사관리부'
                WHEN 'D2' THEN '회계관리부'
                WHEN 'D3' THEN '마케팅부'
                WHEN 'D4' THEN '국내영업부'
                WHEN 'D5' THEN '해외영업1부'
                WHEN 'D6' THEN '해외영업2부'
                WHEN 'D7' THEN '해외영업3부'
                WHEN 'D8' THEN '기술지원부'
                WHEN 'D9' THEN '총무부'
              END;
    
    /*
    IF문으로 바꿔볼 수도 있다.
    IF EMP.DEPT_CODE='D1' THEN DNAME := '인사관리부';
    ELSIF EMP.DEPT_CODE='D2' THEN DNAME := '인사관리부';
    ELSIF EMP.DEPT_CODE='D3' THEN DNAME := '마케팅부';
    ELSIF EMP.DEPT_CODE='D4' THEN DNAME := '국내영업부';
    ELSIF EMP.DEPT_CODE='D5' THEN DNAME := '해외영업1부';
    ELSIF EMP.DEPT_CODE='D6' THEN DNAME := '해외영업2부';
    ELSIF EMP.DEPT_CODE='D7' THEN DNAME := '해외영업3부';
    ELSIF EMP.DEPT_CODE='D8' THEN DNAME := '기술지원부';
    ELSE DNAME := '총무부';
    END IF;
    */
    
    DBMS_OUTPUT.PUT_LINE('사번 이름   부서명');
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_ID || ' ' || EMP.EMP_NAME || ' ' || DNAME);
END;
/



/* 반복문 */
-- BASIC LOOP
-- 내부에 처리문 작성하고 마지막에 LOOP를 벗어날 조건 명시
-- 1부터 5까지 순차적으로 출력
DECLARE
    N NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT(N);
        N := N + 1;
        
        -- 반복문 종료 방법 1. IF문 활용
        -- IF N> 5 THEN EXIT;
        -- END IF;
        
        -- 반복문 종료 방법 2. EXIT WHEN으로 작성
        EXIT WHEN N > 5;
    END LOOP;
END;
/

-- FOR LOOP
-- 1부터 5까지 출력
BEGIN
    LOOP
        DBMS_OUTPUT(N);
        N := N + 1;
        
        -- 반복문 종료 방법 1. IF문 활용
        -- IF N> 5 THEN EXIT;
        -- END IF;
        
        -- 반복문 종료 방법 2. EXIT WHEN으로 작성
        EXIT WHEN N > 5;
    END LOOP;
END;
/

BEGIN
    FOR N IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/

-- 1부터 5까지 거꾸로 출력
BEGIN
    FOR N IN REVERSE 1..5 -- REVERSE를 추가함, 5..1처럼 작성 불가(증가하는 값 순서로 작성 가능하므로)
    LOOP
        DBMS_OUTPUT.PUT(N); -- NEWLINE이 들어오기 전까지 BUFFER를 비우지 않음
    END LOOP;
    DBMS_OUTPUT.NEW_LINE;
END;
/

-- WHILE LOOP
DECLARE
    N NUMBER := 1;
BEGIN
    WHILE N <= 5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N + 1 ;
    END LOOP;
END;
/

COMMIT;


/* 예외처리 */
-- 
BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID = '&사번'
    WHERE EMP_ID = 200;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('이미 존재하는 사번입니다.');
END;
/

DECLARE
    NAME VARCHAR2(30);
BEGIN
    SELECT EMP_NAME
    INTO NAME
    FROM EMPLOYEE
    WHERE EMP_ID = 2044;
EXCEPTION
    WHEN NO_DATA_FOUND
    THEN DBMS_OUTPUT.PUT_LINE('조회 결과가 없습니다.');
END;
/




--------------------------------------------------------------------------------
/* 실습문제 */
--1. 사원의 연봉을 구하는 PL/SQL 블럭 작성, 보너스가 있는 사원은 보너스도 포함하여 계산
DECLARE
    EMP EMPLOYEE%ROWTYPE;
    YSALARY NUMBER;
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    IF EMP.BONUS IS NULL THEN YSALARY := EMP.SALARY * 12;
    ELSE YSALARY := EMP.SALARY * (1 + EMP.BONUS) * 12;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME || ' 사원의 연봉은 ' || TO_CHAR(YSALARY, 'FM999,999,999') || '원 입니다.');
    
END;
/

--2. 구구단 짝수단 출력
--   2-1) FOR LOOP
BEGIN
    FOR
    DBMS_OUTPUT.PUT_LINE(N * );
    
END;
/

--   2-2) WHILE LOOP1. 사원의 연봉을 구하는 PL/SQL 블럭 작성, 보너스가 있는 사원은 보너스도 포함하여 계산
DECLARE
BEGIN
END;
/