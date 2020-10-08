-- 프로시져(PROCEDURE)
-- PL/SQL을 저장하는 객체
-- 필요할 때마다 복잡한 구문을 다시 입력할 필요 없이 간단히 호출해 실행 결과를 얻을 수 있음


CREATE TABLE EMP_DUP AS SELECT * FROM EMPLOYEE;
저
SELECT * FROM EMP_DUP;

-- 프로시져 생성, 성공하면 <Procedure DEL_ALL_EMP이(가) 컴파일되었습니다> 문구가 뜸
CREATE OR REPLACE PROCEDURE DEL_ALL_EMP
IS
BEGIN
    DELETE FROM EMP_DUP;
    COMMIT;
END;
/

/* 프로시저 실행을 위한 실행문 작성 */
-- 방법1
EXECUTE DEL_ALL_EMP;
-- 방법2
EXEC DEL_ALL_EMP;

-- 프로시저 수행 후 정상적으로 빈영되었는지 확인
SELECT * FROM EMP_DUP;

-- 저장된 프로시저 확인하기
SELECT * FROM USER_SOURCE;

COMMIT;


/* 매개변수 있는 프로시저 */
CREATE OR REPLACE PROCEDURE DEL_EMP_ID(V_EMP_ID EMPLOYEE.EMP_ID%TYPE) -- ... 프로시져명(매개변수명 변수타입)
IS
BEGIN
    DELETE FROM EMPLOYEE
    WHERE EMP_ID = V_EMP_ID;
END;
/


SELECT * FROM EMPLOYEE;

EXEC DEL_EMP_ID('&사번');

ROLLBACK;

-- IN/OUT 매개변수: 프로시저 내부에서 사용될 변수
-- IN 매개변수: 프로시저 내부에서 사용될 변수
-- OUT 매개변수: 프로시저 외부(호출부)에서 사용될 변수
-- 사용자가 입력한 사번으로 사원의 이름, 급여, 보너스 조회하는 SELECT_EMP_ID 프로시저
CREATE OR REPLACE PROCEDURE SELECT_EMP_ID(
    V_EMP_ID IN EMPLOYEE.EMP_ID%TYPE,
    V_EMP_NAME OUT EMPLOYEE.EMP_NAME%TYPE,
    V_SALARY OUT EMPLOYEE.SALARY%TYPE,
    V_BONUS OUT EMPLOYEE.BONUS%TYPE
)
IS
BEGIN
    SELECT EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO V_EMP_NAME, V_SALARY, V_BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = V_EMP_ID;
    
END;
/


-- 바인드 변수
-- SQL문을 실행할 때 SQL에 사용 값을 전달할 수 있는 통로 역할을 하는 변수
-- PL/SQL문 외부에서 활용할 수 있는 변수
VARIABLE VAR_EMP_NAME VARCHAR2(30);
VAR VAR_SALARY NUMBER;
VAR VAR_BONUS NUMBER;

PRINT VAR_EMP_NAME;
PRINT VAR_SALARY;
PRINT VAR_BONUS;
--> 변수 안에 넣은 값이 없어서 아무 값도 출력되지 않음

EXEC SELECT_EMP_ID('&사번', :VAR_EMP_NAME, :VAR_SALARY, :VAR_BONUS);
--> 바인드 변수가 참조를 받을 때에는 :를 붙여줘야함

SET AUTOPRINT ON;
--> 프로시저 실행 후 자동으로 PIRINT 명령 실행함



/* FUCTION */
-- 사번을 입력 받아 해당 사원의 연봉을 게산하고 리턴하는 함수 생성
CREATE OR REPLACE FUNCTION BONUS_CALC(V_EMP_ID EMPLOYEE.EMP_ID%TYPE)
RETURN NUMBER --> FUNCTION 실행하여 반환할 값의 타입 지정
IS
    V_SAL EMPLOYEE.SALARY%TYPE;
    V_BONUS EMPLOYEE.BONUS%TYPE;
    CALC_SAL NUMBER;
BEGIN
    SELECT SALARY, NVL(BONUS, 0)
    INTO V_SAL, V_BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = V_EMP_ID;
    
    CALC_SAL := (V_SAL + (V_SAL * V_BONUS)) * 12; -- 계산한 연봉을 변수에 대입
    
    RETURN CALC_SAL;
END;
/

VARIABLE VAR_CALC NUMBER; -- 바인드 변수 선언

EXEC :VAR_CALC := BONUS_CALC('&사번');
-- BONUS_CALC는 FUNCTION으로 만들어서 반환 값이 있는 상황
-- 매개 변수를 사번에 따라 다른 값을 보여줄 수 있도록 '&'연산자로 값을 받고
-- SELCET에서 사번에 대응하는 정보를 조회한 후, 연봉을 계산해 CALC_SACALC_SAL 변수에 집어 넣음

SELECT EMP_ID, EMP_NAME, BONUS_CALC(EMP_ID)
FROM EMPLOYEE
WHERE BONUS_CALC(EMP_ID) > 3000000;


