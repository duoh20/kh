-- ORDER BY : 정렬 시 사용
-- SELECT 구문의 가장 마지막에 위치, 실행 순서도 가장 마지막에 실행
SELECT EMP_ID, EMP_NAME, SALARY 급여, DEPT_CODE
FROM EMPLOYEE
-- ORDER BY EMP_NAME;
-- ORDER BY EMP_NAME ASC;
-- ORDER BY EMP_NAME DESC;
-- ORDER BY DEPT_CODE NULLS FIRST; -- (null) 먼저 보이도록 정렬 / NULL LAST가 기본 값
-- ORDER BY 2;
ORDER BY 급여;


-- GROUP BY : 같은 값들이 여러 개 기록된 컬럼을 가지고 같은 값들을 하나의 그룹으로 묶음
SELECT DEPT_CODE, SUM(SALARY) -- 에러 발생: 결과가 23 개 나오는 DEPT_CODE 행과, 1개가 행이 나오는 SUM을 함께 쓸 수 없음
FROM EMPLOYEE;

SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE; 

-- EMPLOYEE 테이블에서 부서 코드별 그룹을 지정하여 부서코드, 그룹별 급여 합계, 그룹별 급여 평균(정수 처리), 인원수 조하고 부서 코드 순으로 정렬
SELECT DEPT_CODE, SUM(SALARY), ROUND(AVG(SALARY)), COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE 테이블에서 부서코드와 보너스를 받는 사원 수 조회하고 부서코드 순으로 정렬
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE 테이블에서 직급코드, 보너스를 받는 사원 수 조회하고 직급코드 순으로 오름차순 정렬
SELECT JOB_CODE, COUNT(BONUS)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL
GROUP BY JOB_CODE
ORDER BY JOB_CODE ASC;


-- EMPLOYEE 테이블에서 성별과 성별 별 급여 평균(정수처리), 급여 합계, 인원 수로 조회하고 내림차순
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', '여') "성별", FLOOR(AVG(SALARY)), SUM(SALARY), COUNT(*) "인원 수"
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', '여')
ORDER BY "인원 수" DESC;


-- EMPLOYEE 테이블에서 부서 코드 별로 같은 직급인 사원의 급여 합계 조회(부서 코드 순으로 정렬
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE;


-- HAVING : 그룹함수로 구해 올 그룹에 대해 조건 설정할 때 사용
-- 부서코드와 급여 3000000 이상인 직원의 그룹별 평균 급여 조회 (일반 컬럼에 대한 조건 = WHERE)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE;

-- 부서 코드와 급여 평균이 3000000 이상인 그룹 조회
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000; -- HAVING은 GROUP BY 아래에 온다

-- 부서별 그룹의 급여 합계 중 9백만원을 초과하는 부서 코드와 급여 합계(부서 코드 순으로 정렬)
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) >= 9000000
ORDER BY DEPT_CODE;

/*
    !!무조건 아래 순서로 기술!!
    !!실행 순서는 순번 참조
   5: SELECT   컬럼명/별칭/계산식/함수식
   1: FROM     참조할테이블명
   2: WHERE    컬럼명/함수식/비교연산자/비교값(조건)
   3: GROUP BY 그룹으로 묶을 컬럼 명
   4: HAVING   그룹함수식/비교연산자/비교값
   6: ORDER BY 컬럼명/별칭/컬럼순번 정렬방식 [NULLS FIRST/LAST]
*/



-- 집계함수: 그룹 별 산출한 결과의 집계를 계산하는 함수
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE);

-- ROLLUP: 그룹 별로 중간 집계 처리하는 함수
-- 그룹별로 묶여진 값에 대한 중간 집계와 총 집계를 구할 때 사용
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE) -- 기준은 처음에 묶인 DEPT_CODE
ORDER BY DEPT_CODE;
-- DEPT_CODE마다 중간 집계가 되어있다.

-- CUBE : 그룹별 산출한 결과를 집계하는 함수
-- 그룹으로 지정된 모든 그룹에 대한 총 합계를 구함
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE) -- DEPT_CODE와 JOB_CODE에 대한 집계 출력
ORDER BY DEPT_CODE;

SELECT DEPT_CODE, EMP_NAME, EMP_ID, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE = 'J7';

-- 집합 연산자 : SET OPERATION
-- 여러가지 조건이 있을 때 그에 해당하는 여러 개의 결과 값을 결합하고자 할 떄 사용
-- UNION: 합집합(OR)
-- INTERSECT : 교집합(AND)
-- UNION ALL: 합집합 + 교집합 (OR껼과에 AND 값이 더해짐)
-- MINUS : 차집합

-- UNION : 여러 개의 쿼리 결과를 하나로 합치는 연산자(중복된 영역을 제외하여 하나로 합침)
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 200;

SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 201;

SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 201 OR EMP_ID = 200;

SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 200
UNION
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 201;

-- UNION을 사용하여 DEPT_CODE가 D5이거나 급여가 300만원을 초과하는 직원의 사번, 이름, 부서코드, 급여 조회
-- OR 사용
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;

SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- UNION ALL : 여러 개의 쿼리 결과를 하나로 합치는 연산자
-- UNION과 차이점은 중복 영역을 모두 포함(합집합 + 교집합)
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- INTERSECT : 여러 개의 SELECT한 결과에서 공통 부분만 결과로 추출(집합)
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- MINUS : 선행 SELECT한 결과에서 다음 SELECT 결과와 겹치는 부분을 제외한 나머지 부분만 추출(차집합)
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_NO, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 그룹 함수 : 하나의 결과를 출력하는 함수
-- SUM
-- EMPLOYEE 테이블에서 전 사원의 급여 총합 조회
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 남자 사원의 급여 총합 조회
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

-- EMPLOYEE 테이블에서 부서 코드가 D5인 직원의 보너스 포함 연봉 합계 조회
SELECT SUM((SALARY + (SALARY * NVL(BONUS, 0)))*12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';


-- AVG : 평균을 더하여 리턴
-- EMPLOYEE 테이블에서 전 사원의 급여 평균 조회
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 전 사원의 보너스 평균을 소수 셋 째자리에서 반올림한 것 조회
SELECT ROUND(AVG(NVL(BONUS, 0)), 2)
FROM EMPLOYEE;

SELECT AVG(BONUS) "기본 평균"， AVG（DISTINCT BONUS） "중복 제거 평균"， AVG(NVL(BONUS, 0)) NULL이 0dmfh qkRnls vudrbs
FROM EMPLOYEE;


-- 그룹 함수 : 하나의 결과를 출력하는 함수
-- SUM
-- EMPLOYEE 테이블에서 전 사원의 급여 총합 조회
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 남자 사원의 급여 총합 조회
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

-- EMPLOYEE 테이블에서 부서 코드가 D5인 직원의 보너스 포함 연봉 합계 조회
SELECT SUM((SALARY + (SALARY * NVL(BONUS, 0)))*12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';


-- AVG : 평균을 더하여 리턴
-- EMPLOYEE 테이블에서 전 사원의 급여 평균 조회
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 전 사원의 보너스 평균을 소수 셋 째자리에서 반올림한 것 조회
SELECT ROUND(AVG(NVL(BONUS, 0)), 2)
FROM EMPLOYEE;

SELECT AVG(BONUS) "기본 평균"， AVG（DISTINCT BONUS） "중복 제거 평균"， AVG(NVL(BONUS, 0)) NULL이 0dmfh qkRnls vudrbs
FROM EMPLOYEE;


-- MIN
-- EMPLOYEE 테이블에서 가장 적은 급여 조회
SELECT MIN(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 알파벳 순서가 가장 빠른 이메일, 가장 빠른 입사일 조회
SELECT MIN(EMAIL), MIN(HIRE_DATE)
FROM EMPLOYEE;


-- MAX
-- EMPLOYEE 테이블에서 가장 많은 급여 조회
-- EMPLOYEE 테이블에서 알파벳 순서가 가장 늦은 이메일, 가장 최근 입사일 조회
SELECT MAX(SALARY), MAX(EMAIL), MAX(HIRE_DATE)
FROM EMPLOYEE;


-- COUNT : 행 개수를 헤아려 리턴
-- COUNT([DISTINCT] 컬럼명): 중복을 제거한 행 개수를 헤어려 리턴
-- COUNT(*) : NULL을 포함한 전체 행 개수 리턴
-- COUNT(컬럼 명) : NULL을 제외한 실제 값이 기록된 행 개수 리턴
-- EMPLOYEE 테이블에서 전체 사원 수, 부서코드가 있는 사원 수, 사원들이 속해있는 부서의 수 조회
SELECT COUNT(*), COUNT(DEPT_CODE), COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;

