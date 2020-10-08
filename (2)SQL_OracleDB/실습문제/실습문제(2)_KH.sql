-- 14. EMPLOYEE테이블에서 메일주소 '_'의 앞이 4자이면서 DEPT_CODE가 D9 또는 D6이고 
--     고용일이 90/01/01 ~ 00/12/01이고, 급여가 270만 이상인 사원의 전체를 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IN('D9', 'D6')
      AND EMAIL LIKE '____#_%' ESCAPE '#'
      AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01'
      AND SALARY >= 2700000;



-- 19. EMPLOYEE테이블에서 근무 년수가 20년 이상인 직원 정보 조회
SELECT *
FROM EMPLOYEE
WHERE ADD_MONTHS(HIRE_DATE, 240) < SYSDATE;

-- 20. EMPLOYEE 테이블에서 사원명, 급여 조회 (단, 급여는 '\9,000,000' 형식으로 표시)
SELECT EMP_NAME, TO_CHAR(SALARY, 'L9,999,999')
FROM EMPLOYEE;

-- 21. EMPLOYEE테이블에서 직원 명, 부서코드, 생년월일, 나이(만) 조회
--     (단, 생년월일은 주민번호에서 추출해서 00년 00월 00일로 출력되게 하며 
--     나이는 주민번호에서 출력해서 날짜데이터로 변환한 다음 계산)
SELECT EMP_NAME, DEPT_CODE,
       SUBSTR(EMP_NO, 1, 2)|| '년 ' || SUBSTR(EMP_NO, 1, 1) || '월 ' || SUBSTR(EMP_NO, 1, 1) || '일' 생년월일,
       EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RRRR')) 나이
FROM EMPLOYEE;

-- 22. EMPLOYEE테이블에서 부서코드가 D5, D6, D9인 사원만 조회하되 D5면 총무부, D6면 기획부, D9면 영업부로 처리
--     (단, 부서코드 오름차순으로 정렬)
SELECT EMP_ID, EMP_NAME, DEPT_CODE,
       CASE WHEN DEPT_CODE = 'D5' THEN '총무부'
            WHEN DEPT_CODE = 'D6' THEN '기획부'
            ELSE '영업부'
       END
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5', 'D6', 'D9')
ORDER BY DEPT_CODE ASC;



-- 23. EMPLOYEE테이블에서 사번이 201번인 사원명, 주민번호 앞자리, 주민번호 뒷자리, 
--     주민번호 앞자리와 뒷자리의 합 조회
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 6) 앞자리, SUBSTR(EMP_NO, 8)뒷자리, TO_NUMBER(SUBSTR(EMP_NO, 1, 6) + SUBSTR(EMP_NO, 8))
FROM EMPLOYEE
WHERE EMP_ID = 201;

-- 24. EMPLOYEE테이블에서 부서코드가 D5인 직원의 보너스 포함 연봉 합 조회
SELECT SUM((SALARY + (SALARY * NVL(BONUS, 0))) * 12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- 25. 직원들의 입사일로부터 년도만 가지고 각 년도별 입사 인원수 조회
-- 전체 직원 수, 2001년, 2002년, 2003년, 2004년
SELECT COUNT(*) 전체직원수,
       COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2001', 1)) "2001년",
       COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2002', 1)) "2002년",
       COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2003', 1)) "2003년",
       COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2004', 1)) "2004년"
FROM EMPLOYEE;
