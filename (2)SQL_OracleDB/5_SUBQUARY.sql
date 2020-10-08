-- SWUBQUARY(브쿼리)
-- 하나의 SQL문 안에 포함된 또 다른 SQL문
-- 메인쿼리(기존 쿼리)를 위해 보조 역할을 하는 쿼리문

-- 부서코드가 노옹철인 사원과 같은 소속의 직원 명단 조회
-- 1) 사원명이 노옹철인 사원의 부서 조회
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';

-- 2) 부서코드가 D9인 직원 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 3) SUBQUARY를 사용해 1과 2를 한 번에 표현하는 방법
-- 조회할 DEPT_CODE는 "노옹철" 사원이 속한 부서인데
-- 어떤 부서인지 모르는 상황이라면 SUBQUARY로 조건 명시
SELECT EMP_NAME --> 알고 싶은 것은 "직원 명단"
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE  --> SUBQUARY는 ()로 묶어주어야한다.
                   FROM EMPLOYEE
                   WHERE EMP_NAME = '노옹철');

-- 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여 조회
-- 1) 전 직원의 평균 급여 조회
SELECT AVG(SALARY)
FROM EMPLOYEE;
    
-- 2) 3047662.60869565217391304347826086956522 보다 많이 받는 직원의 사번, 이름, 직급코드, 급여 조회               
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3047662.60869565217391304347826086956522;

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY)
                FROM EMPLOYEE);
                



-------------------------------------------------------------------------------
-- 서브쿼리 유형
-- 1. 단일행 서브쿼리: 서브 쿼리의 조회 결과 값의 개수가 1개일 때
-- 일반적으로 단일행 서브 쿼리 앞에는 일반 연산자 사용 : < > <= >= = != <> ^=
-- 노옹철 사원의 급여보다 많이 받는 직원의 사번, 이름, 부서코드 직급코드, 급여 조회
-- 1) 노옹철 사원 급여 조회
SELECT SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철'; --> 결과: 3700000 결과 값이 1개
-- 2) 3700000보다 많이 받는 직원의 사번, 이름, 부서코드, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3700000;
-- 3) 1 + 2
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '노옹철');
                
-- 가장 적은 급여를 받는 직원의 사번, 이름, 직급코드, 부서코드, 급여, 입사일 조회
-- 1) 가장 적은 급여 조회
SELECT MIN(SALARY)
FROM EMPLOYEE;
-- 2) 1380000을 받는 직원의 사번, 이름, 직급코드, 부서코드, 급여, 입사일 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = 1380000;
-- 3) 1 + 2
SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY)
                FROM EMPLOYEE);
                
-- 전 직원의 급여 평균보다 적은 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회(직급 순으로 정렬)
-- 1) 전 직원의 급여 평균
SELECT AVG(SALARY)
FROM EMPLOYEE;
-- 2) 3047662.60869565217391304347826086956522보다 적은 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회(직급 순으로 정렬)
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < 3047662.60869565217391304347826086956522
ORDER BY JOB_CODE;
-- 3) 1 + 2
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY)
                FROM EMPLOYEE)
ORDER BY JOB_CODE;

-- 부서 별 급여 합계 중 가장 큰 부서의 부서 명, 급여 합계 조회
-- 1) 부서 별 급여 합계 중 가장 큰 부서의 급여 합계
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;
-- 2) 부서별 급여 합계
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) -- 부서 이름이 null일 수도 있으므로 LEFT [FULL] JOIN
GROUP BY DEPT_TITLE;
-- 3) 1 + 2
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                      FROM EMPLOYEE
                      GROUP BY DEPT_CODE);
                      

-- 2) 다중행 서브쿼리: 서브 쿼리의 조회 결과 값의 개수가 여러 개일 때
-- 다중행 서브 쿼리 앞에는 일반 비교 연산자 사용 불가능
-- IN / NOT IN
--      여러 개의 결과 값 중에서 한 개라도 일치하는 값이 있는/없는 경우
-- > ANY, < ANY
--      여러 개의 결과 값 중에서 한 개라도 큰/작은 경우
--      가장 작은 값보다 큰지/가장 큰값보다 작은지
-- > ALL, < ALL
--      모든 값보다 큰/작은 경우
--      가장 작은 값보다 작은지. 가장 큰 값보다 큰지
-- EXIST / NOT EXIST
--      값이 존재하는/존재하지 않는 경우

-- 부서 별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회
-- 1) 부서 별 최고 급여 조회
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;
-- 2) 서브 쿼리 이용
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
                 FROM EMPLOYEE
                 GROUP BY DEPT_CODE);

-- 관리자와 일반 직원에 해당하는 사원 정보 추출,  관리자 직원의 사번, 이름, 부서 명, 직구브, 구분(관리자/직원) 조회
-- 1) 관리자 직원 추출
SELECT DISTINCT MANAGER_ID -- 중복 제거한 관리자 번호 추출
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL;
-- 2) 관리자 직원의 사번, 이름, 부서 명, 직구브, 구분(관리자/직원)
SELECT DISTINCT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE);
-- 3) 1+2
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '관리자' 구분
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT MANAGER_ID
                 FROM EMPLOYEE
                 WHERE MANAGER_ID IS NOT NULL)
UNION
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사원' 구분
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT MANAGER_ID
                 FROM EMPLOYEE
                 WHERE MANAGER_ID IS NOT NULL);

-- 간단 버전
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME,
       CASE WHEN EMP_ID IN (SELECT DISTINCT MANAGER_ID
                            FROM EMPLOYEE
                            WHERE MANAGER_ID IS NOT NULL) THEN '관리자'
       ELSE '직원'
       END
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE);
     
-- 대리 직급의 직원들 중에서 과장 직급의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회
-- 1) 대리 직급 사원 정보 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리';
-- 2) 과장 직급의 급여
SELECT SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장';
-- 3) 1 + 2
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
      AND SALARY > ANY(SELECT SALARY
                       FROM EMPLOYEE
                            JOIN JOB USING (JOB_CODE)
                       WHERE JOB_NAME = '과장');
-- 다른 버전: > ANY 대신 MIN 사용
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
      AND SALARY > ANY(SELECT SALARY
                       FROM EMPLOYEE
                            JOIN JOB USING (JOB_CODE)
                       WHERE JOB_NAME = '과장');
                       
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
      AND SALARY > (SELECT MIN(SALARY)
                    FROM EMPLOYEE
                         JOIN JOB USING (JOB_CODE)
                    WHERE JOB_NAME = '과장');
                    
-- 차장 직급 급여의 가장 큰 값 (> ALL) 보다 많이 받는 과장 직급의 사번, 이름, 직급, 급여 조회
-- 1) 과장 직급의 사번, 이름, 직급, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장';
-- 2) 차장 직급 급여
SELECT SALARY
FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '차장';
-- 3) 1 + 2
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
      AND SALARY > ALL (SELECT SALARY
                        FROM EMPLOYEE
                             JOIN JOB USING (JOB_CODE)
                        WHERE JOB_NAME = '차장');
-- 간단 버전: MAX 사용
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '과장'
      AND SALARY > (SELECT MAX(SALARY)
                    FROM EMPLOYEE
                         JOIN JOB USING (JOB_CODE)
                    WHERE JOB_NAME = '차장');

-- 3.  다중열 서브쿼리: 서브 SELECT절에 나열된 항목 수가 여러 개일 때（컬럼이 여러 개)
-- 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는 사원의 이름, 직급코드, 부서코드, 입사일 조회
-- 1) 퇴사한 여직원의 부서와 직급 코드 조회
SELECT JOB_CODE, DEPT_CODE
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y';
-- 2) 사원의 이름, 직급코드, 부서코드, 입사일 조회
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                  FROM EMPLOYEE
                  WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y')
      AND JOB_CODE =  (SELECT JOB_CODE --> 퇴사한 여직원과 동일한 직급 판단하기 위한 조건 추가
                       FROM EMPLOYEE
                       WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y')
      AND EMP_NAME != (SELECT EMP_NAME --> 퇴사한 여직원의 이름은 조회하지 않기위한 조건 추가
                       FROM EMPLOYEE
                       WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y');
-- 다중열 서브 쿼리 이용
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y')
      AND EMP_NAME != (SELECT EMP_NAME --> 퇴사한 여직원의 이름은 조회하지 않기위한 조건 추가
                       FROM EMPLOYEE
                       WHERE SUBSTR(EMP_NO, 8, 1) = 2 AND ENT_YN = 'Y');


-- 4. 다중행 다중열 서브쿼리: 조회 결과 행 수와 열 수가 여러 개일 때
-- 자기 직급의 평균 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여 조회
-- 급여와 급여 평균은 십만원 단위로 계산 == TRUNC(컬럼명, -5)
-- 1) 직급별 평균 급여 계산
SELECT JOB_CODE, TRUNC(AVG(SALARY), -5), AVG(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;
-- 2) 자기 직급의 평균 급여를 받고 있는 직원
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, TRUNC(AVG(SALARY), -5)
                             FROM EMPLOYEE
                             GROUP BY JOB_CODE);

SELECT ROWNUM, EMP_NAME
FROM EMPLOYEE;            
        


-------------------------------------------------------------------------------        
-- 인라인 뷰(INLINE-VIEW)
-- FORM절에 서브쿼리를 사용한 것
-- 이미 작성된 테이블을 사용하는 것이 아니라, 내가 원하는 내용만 테이블로 만들어 그 안에서 가져오는 것
-- 전 직원 중 급여가 높은 상위 5명의 순위, 이름, 급여 조회
-- 선동일, 송종기, 정중하, 대북혼, 노옹철
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;
-- 위 코드는 다음과 같은 순서로 실행된다
-- 1) FROM절의 테이블을 가져옴
SELECT *
FROM EMPLOYEE;
-- 2) FROM절에서 WHERE 조건에 부합하는 행 확인
SELECT *
FROM EMPLOYEE
WHERE ROWNUM <= 5;
-- 3) SELECT에서 출력할 컬럼 확인
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM <= 5;
-- 4) ORDER BY 조건에 따라 추출한 데이터 정렬
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;
--> 즉, 위 처럼 SQL 구문을 작성하면 전체 직원의 급여 순이 아니라, ROWNUM 5번째로 자른 상태에서 급여 순이 출력되므로 원하는 결과를 얻을 수 없다.
--> FROM절에서 내림차순으로 정렬된 상태에서 데이터를 추출할 수 있도록 아래처럼 바꿔 적어주자
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT *
      FROM EMPLOYEE
      ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;
-- ORDER BY SALARY DESC; FROM절에서 이미 정렬했기 때문에 없어도 됨

-- 급여 평균 3위 안에 드는 부서의 부서 코드와 부서 명, 평균 급여 조회
SELECT DEPT_CODE, DEPT_TITLE, FLOOR(AVG(SALARY))
FROM EMPLOYEE
     JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE ROWNUM <= 3
GROUP BY DEPT_CODE, DEPT_TITLE
ORDER BY FLOOR(AVG(SALARY)) DESC; -- WRONG

SELECT DEPT_CODE, DEPT_TITLE, 평균급여 --<<FROM절 안에 있는 컬럼 외에 다른 컬럼 사용 불가, 그룹함수 중복 사용 불가하므로 별칭으로 불러옴
FROM(SELECT DEPT_CODE, DEPT_TITLE, FLOOR(AVG(SALARY)) 평균급여
     FROM EMPLOYEE
          JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     GROUP BY DEPT_CODE, DEPT_TITLE
     ORDER BY FLOOR(AVG(SALARY)) DESC)
WHERE ROWNUM <= 3;


-------------------------------------------------------------------------------
-- RANK() OVER / DENSE_RANK() OVER
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) 순위
FROM EMPLOYEE; --> 결과: ... 19, 19, 21.../공동 순위 발생 시, 다음 랭크는 중복 발생 수 만큼 건너 뛴 순위로 매김

SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) 순위
FROM EMPLOYEE; --> 결과: ... 19, 19, 20.../공동 순위 발생 시, 다음 랭크는 연속 숫자로 순위 매김
