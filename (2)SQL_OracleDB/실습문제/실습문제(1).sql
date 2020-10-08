------------- 실습문제----------------------------
-- 1. EMPLOYEE 테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
-- 단, 별칭은 근무일수1, 근무일수2로 하고
-- 모두 정수처리(내림), 양수가 되도록 처리
SELECT EMP_NAME, ABS(FLOOR(HIRE_DATE-SYSDATE)) 근무일수1, ABS(FLOOR(SYSDATE - HIRE_DATE)) 근무일수2
FROM EMPLOYEE;

-- 2. EMPLOYEE 테이블에서 사번이 홀수인 직원들의 정보 모두 조회
SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;


-- 3. EMPLOYEE 테이블에서 근무 년수가 20년 이상인 직원 정보 조회
SELECT * 
FROM EMPLOYEE
WHERE (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)) >= 20;

-- 4. EMPLOYEE 테이블에서 사원명, 입사일, 입사한 월의 근무일수를 조회
SELECT EMP_NAME, HIRE_DATE, EXTRACT(DAY FROM HIRE_DATE)
FROM EMPLOYEE;

