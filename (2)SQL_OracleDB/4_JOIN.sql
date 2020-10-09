-- JOIN : 하나 이상의 테이블에서 데이터를 조회하기 위해 사용
-- 수행 결과는 하나의 ResultSet으로 나옴

-- 사번, 사원 명, 부서코드, 부서 명을 조회하고자 할 때
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE;

SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;

-- 내부 조인(INNER JOIN == 등가조인)
-- : 연결되는 컬럼의 값이 일치하는 행들만 조인

-- 오라클 전용 구문
-- : FORM절에 ','로 구분하여 합치게 될 테이블 명을 기술하고, WHERE절에 합치기에 사용할 컬럼명 명시
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;

SELECT EMP_ID, EMP_NAME, JOB.JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;
-- column ambiguously defined : 컬럼이 불명확하게 정의됨
-- EMPLOYEE와 JOB테이블에 같은 컬럼명이 존재하기 때문, 어떤 테이블의 JOB_CODE인지 밝혀 적어준다

SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J -- 별칭을 정해서 사용할 수도 있음
WHERE E.JOB_CODE = J.JOB_CODE;


-- ANSI 표준 구문
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE); -- USING을 사용해 JOB 테이블의 JOB_CODE임을 참조함을 명시
     
     
     
-- 부서 명과 해당 부서의 지역 명 조회
-- 오라클
SELECT DEPT_TITLE, LOCAL_NAME
FROM DEPARTMENT, LOCATION
WHERE LOCATION_ID = LOCAL_CODE;

-- ANSI
SELECT DEPT_TITLE, LOCAL_NAME
FROM DEPARTMENT
     JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE);
     


-- 외부 조인(OUTER JOIN)
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE; -- 23개 결과

SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID; -- 21개 결과 (null 값을 가진 사원은 DEPT_TITLE을 매칭해줄 수 없어서 누락됨)

SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID); --21개 결과
     
     
-- LEFT [OUTER] JOIN : 합치기에 사용한 두 테이블 중  왼쪽에 기술된 테이블의 컬럼 수를 기준으로 JOIN
-- ANSI
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
     LEFT OUTER JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
     
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);  -- OUTER 생략 가능
     
-- 오라클
SELECT EMP_NAME, DEPT_TITLE, DEPT_CODE, DEPT_ID
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID; -- DEPTC_CODE(EMPLOYEE에 맞춰 JOIN), 기준 컬럼에 맞춰주는 컬럼에 (+) 추가
 
     
     
-- RIGHT [OUTER] JOIN : 합치기에 사용한 두 테이블 중 오른쪽에 기술된 테이블의 컬럼 수를 기준으로 JOIN
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
     RIGHT /*OUTER*/ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); -- 24개(해외영엄3부, 마케팅부, 국내영업부에 속한 사원이 없어서 null로 표기되어 추가됨)

SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;



-- FULL [OUTER] JOIN : 합치기에 사용한 두 테이블이 가진 모든 행을 결과에 포함
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
     FULL OUTER JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID(+);
-- a predicate may reference only one outer-joined table
-- FULL OUTTER 구문은 오라클 전용 구문으로 구현 불가, (+)는 한 쪽에만 사용 가능, ANSI로만 구현 가능


-- 직급이 대리이면서 아시아 지역에 근무하는 직원 조회
-- 사번, 이름, 직급 명, 부서 명, 근무 지역 명, 급여
-- 오라클SYSTEM

SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE E, DEPARTMENT, JOB J, LOCATION
WHERE DEPT_CODE = DEPT_ID
      AND E.JOB_CODE = J.JOB_CODE
      AND LOCATION_ID = LOCAL_CODE
      AND JOB_NAME = '대리'
      AND LOCAL_NAME LIKE 'ASIA%';


-- ANSI
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE E
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE)
     JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
WHERE JOB_NAME = '대리'
      AND LOCAL_NAME LIKE 'ASIA%';