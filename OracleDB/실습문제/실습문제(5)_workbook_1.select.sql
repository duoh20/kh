/* BASIC SELECT */
-- 1. 학과목 컬럼 조회
SELECT DEPARTMENT_NAME 학과명, CATEGORY 계열
FROM TB_DEPARTMENT;

-- 2. 확과의 정원 출력
SELECT DEPARTMENT_NAME || '의 정원은 ' || CAPACITY || ' 명 입니다.' "학과별 정원"
FROM TB_DEPARTMENT;

-- 3. 국어국문학과의 휴학 중인 여학생 조회
SELECT STUDENT_NAME
FROM TB_STUDENT
     JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME LIKE '국어국문학과'
      AND ABSENCE_YN = 'Y'
      AND SUBSTR(;