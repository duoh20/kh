-- 함수(FUNCTION) : 컬럼의 값을 읽어서 계산한 결과 리턴
-- 단일행 함수(SINGLE ROW FUNCTION) : 컬럼에 기록되 N개 값을 읽어서 N개 결과 리턴
-- 그룹 함수(GROUP FUNCTION) : 컬럼에 기록된 N개 값을 읽어서 1개 결과 리턴

-- SELECT절에 단일행 함수와 그룹 함수를 함께 사용 못함 : 결과 행의 개수가 다르기 때문

-- 함수 사용 가능 위치 : SELECT절, WHERE절, GROUP절, GROUP BY절, HAVING절, ORDER BY절



-- 단일행 함수
--------------------------------------------------------------------------------
-- 1. 문자 관련 함수
-- LENGTH: 글자 수 반환 / LENGTHB: 글자의 바이트 사이즈 반환
SELECT LENGTH('오라클'), LENGTHB('오라클') -- 오라클에서 한글은 3Byte
FROM DUAL; --가상 테이블(범위 테이블): '오라클' 컬럼이 없으므로 값 확인을 위한 가상 테이블 생성
SELECT LENGTH('ABCD'), LENGTHB('ABCD') FROM DUAL; -- 영어, 특수기호는 1Byte
SELECT LENGTH(EMAIL), LENGTHB(EMAIL) FROM EMPLOYEE;

-- INSTR: 해당 문자열의 위치 반환 (!!주의!! 오라클은 zero index 기반이 아님)
SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL; 
SELECT INSTR('AABAACAABBAA', 'C') FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'T') FROM DUAL; --> 없는 값이면 0 반환
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL; --> 결과3: 1부터 읽기 시작해 처음으로 나오는 B의 위치 반환
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; --> 결과10: -1(끝)부터 읽기 시작해서 처음으로 나오는 B의 위치 반환
SELECT INSTR('AABAACAABBAA', 'C', -1) FROM DUAL; --> 결과6
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; --> 결과9: 1부터 읽기 시작해 두 번째로 나오는 B의 위치 반환
SELECT INSTR('AABAACAABBAA', 'B', -1, 2) FROM DUAL; --> 결과9
SELECT INSTR('AABAACAABBAA', 'C', 1, 2) FROM DUAL; --> 결과0

-- EMPLOYEE 테이블에서 이메일의 @ 위치 반환 
SELECT EMP_NAME, EMAIL, INSTR(EMAIL, '@')
FROM EMPLOYEE;

-- LPAD / RPAD: 
SELECT LPAD(EMAIL, 20) -- 20개 칸의 왼쪽에 값을 채워넣음
FROM EMPLOYEE;
SELECT LPAD(EMAIL, 20, '#') -- 20개 칸의 왼쪽에 값을 채워넣음
FROM EMPLOYEE;
SELECT RPAD(EMAIL, 20, '*') -- 20개 칸의 오른쪽에 값을 채워넣음
FROM EMPLOYEE;

-- LOWER / UPPER / INITCAP
-- LOWER: 소문자로 변환
-- UPPER: 대문자로 변환
--INICAP: 첫번째 글자만 대문자로 변환
SELECT LOWER('welcom To My World!') From DUAL;
SELECT UPPER('welcom To My World!') From DUAL;
SELECT INITCAP('welcom To My World!') From DUAL;

-- CONCAT : 전달받은 문자열이나 컬럼을 하나로 합친 후 반환 (연결 연산자 ||와 동일)
SELECT CONCAT('가나다라', 'ABCD') FROM DUAL;
SELECT '가나다라' || 'ABCD' FROM DUAL;

-- LTRIM / RTRIM : 문자열 혹은 컬럼의 왼쪽/오른쪽에서 지정한 STR에 !!포함!!되어 있는 모든 문자 제거
-- 앞 혹은 뒤에서 부터 STR에 포함된 문자를 지우다가 다음 문자가 STR에 포함된 문자가 아니면 수행 중지하고 출력
SELECT EMP_NAME, PHONE, LTRIM(PHONE, '010'), EMAIL, RTRIM(EMAIL, '@kh.or.kr')
FROM EMPLOYEE;
--> 010 뒤에 0이나 1이오면 함께 TRIM됨
--> @ 앞에 도메인 계정에 속하는 영문자가 있으면 TRIM됨

SELECT LTRIM('     KH') FROM DUAL; -- 왼쪽의 공백만 지워짐
SELECT LTRIM('     KH', ' ') FROM DUAL;
SELECT LTRIM('0000123456', '0') FROM DUAL; -- 지정한 문자의 왼쪽부터 0을 제거
SELECT LTRIM('123123KH', '123') FROM DUAL; -- 결과: KH

SELECT RTRIM('KH     ') A FROM DUAL; -- 
SELECT RTRIM('123456000', '0') A FROM DUAL; -- 지정한 문자의 오른쪽부터 0을 제거
SELECT RTRIM('KH123456000', '0123456789') A FROM DUAL; -- 결과: KH

-- TRIM : 문자열의 앞/뒤/양쪽에 있는 문자 제거
SELECT TRIM('   KH   ') A FROM DUAL; -- 결과: KH
SELECT TRIM('2' FROM'222KH2222') A FROM DUAL; -- 결과: KH
SELECT TRIM('123' FROM '123321KH12312') A FROM DUAL;
-- 에러: trim set should have only one character
--> !!TRIM은 한글자로만 지울 수 있음!!
SELECT TRIM('1' FROM '123321KH12312') A FROM DUAL; -- 결과: 23321KH12312
SELECT TRIM(LEADING 'z' FROM 'zzzz12345zzzz') FROM DUAL; -- 앞의 z만 지워짐
SELECT TRIM(TRAILING 'z' FROM 'zzzz12345zzzz') FROM DUAL; -- 뒤의 z만 지워짐
SELECT TRIM(BOTH 'z' FROM 'zzzz12345zzzz') FROM DUAL; -- 앞, 뒤 z 모두 지워짐 (디폴트)

-- SUBSTR: 컬럼이나 문자열에서 지정한 위치부터 지정한 개수의 문자열을 잘라내어 반환
SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 5, 0) FROM DUAL; -- 갯수가 0개이면 (null)반환
SELECT SUBSTR('SHOWMETHEMONEY', 1, 6) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL; -- 뒤에서 8번째에서 3개 문자 반환: THE
SELECT SUBSTR('SHOWMETHEMONEY', -10, 2) FROM DUAL;
SELECT SUBSTR('쇼우 미 더 머니', 2, 5) FROM DUAL;

-- EMPLOYEE 테이블의 이름, 이메일, @이후를 제외한 아이디 조회
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) ID -- @의 위치를 알아낸 후 제거
FROM EMPLOYEE;

-- 주민등록번호를 이용해 남/녀 판단
-- EMPLOYEE 테이블에서 이름과 주민번호에서 성별을 나타내는 부분 조회
SELECT EMP_NAME, SUBSTR(EMP_NO, 8, 1)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 남자만 조회 (사원 명, '남')
SELECT EMP_NAME, '남' -- '남' 컬럼 생성
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

-- EMPLOYEE 테이블에서 여자만 조회 (사원 명, '여')
SELECT EMP_NAME, '여'
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 2;

-- EMPLOYEE 테이블에서 직원들의 주민번호를 이용해 사원 명, 생년, 생월, 생일 조회
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 2) 생년, SUBSTR(EMP_NO,환 3, 2) 생월, SUBSTR(EMP_NO, 4, 2) 생일
FROM EMPLOYEE;

-- REPLACE : 컬럼의 문자 혹은 문자열에서 특정 문자열을 가지고 지정한 문자열로 바꾼 후 변환
SELECT REPLACE('서울시 강남구 역삼동', '역삼동', '삼성동') FROM DUAL;

SELECT REPLACE('원격 기간동안 반에 나올 수 있는 학생 수는 15명 이하입니다', '15명', '5명') FROM DUAL;


-- EMPLOYEE 테이블에서 이메일의 도메인을 gmail.com으로 변경
SELECT REPLACE(EMAIL, 'kh.or.kr', 'gmial.com')
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사원 명, 주민번호 조회
-- 단, 주민번호는 생년월일만 보이게 하고 '-' 다음 값은 '*'로 변경
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 7), 14, '*')
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 7), LENGTH(EMP_NO), '*')
FROM EMPLOYEE;

SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 7) || '******'
FROM EMPLOYEE;

-- 2. 숫자 관련 함수 : 자바의 MATH 클래스와 비슷함
-- ABS: 절대값을 구하여 반환하는 함수
SELECT ABS(10.9) FROM DUAL;
SELECT ABS(-10.9) FROM DUAL; -- 양수로 변경
SELECT ABS(10) FROM DUAL;
SELECT ABS(-10) FROM DUAL;

-- MOD : 나머지를 구함(자바의 모듈러와 같은 역할)
SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(-10, 3) FROM DUAL; --> 결과: -1, 나머지 값의 부호는 나누어지는 수의 부호를 따라감
SELECT MOD(10, -3) FROM DUAL; --> 결과: 1
SELECT MOD(10.9, 3) FROM DUAL; --> 결과: 1.9, 소숫점 나머지도 그대로 가져옴

-- ROUND : 반올림하여 리턴하는 함수
SELECT ROUND(123.456) FROM DUAL; --> 결과: 123
SELECT ROUND(123.789) FROM DUAL; --> 결과: 124
SELECT ROUND(123.567, 0) FROM DUAL; --> 결과: 124, 소수점 아래 첫번째에서 반올림(인덱스가 0부터 시작)
SELECT ROUND(123.567, 1) FROM DUAL; --> 결과: 123.6
SELECT ROUND(123.567, 2) FROM DUAL; --> 결과: 123.57
SELECT ROUND(123.567, -2) FROM DUAL; --> 결과: 100, 2는 반올림될 수 없는 정수이므로 버려짐

SELECT ROUND(-10.61) FROM DUAL;
-- 양수: 0 1 2 3 4 (내림) / 5 6 7 8 9 (올림)
-- 음수: 5 6 7 8 9 (내림) / 0 1 2 3 4 (올림)

-- FLOOR : 내림(수학적)
SELECT FLOOR(123.456) FROM DUAL; --> 결과: 123
SELECT FLOOR(123.678) FROM DUAL; --> 결과: 123

-- TRUNC : 버림(절삭)
SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.678) FROM DUAL;  --> 결과: 123.3
SELECT TRUNC(123.456, 1) FROM DUAL; --> 결과: 123.4, 소수 1번째 자리에서 버림
SELECT TRUNC(123.456, 2) FROM DUAL; --> 결과: 123.45, 소수 2번째 자리에서 버림
SELECT TRUNC(123.456, -1) FROM DUAL; --> 결과: 120, 정수 첫번째 자리 버림

-- CELIL: 올림
SELECT CEIL(123.456) FROM DUAL; --> 결과: 124
SELECT CEIL(123.789) FROM DUAL;


-- 3. 날짜 관련 함수
-- SYSDATE : 시스템에 저장된 날짜를 반환
SELECT SYSDATE FROM DUAL;

-- MONTHS_BETEWEEN : 개월 수의 차이를 숫자로 리턴
-- EMPLOYEE 테이블에서 사원의 이름, 입사일, 근무 개월 수 조회
SELECT EMP_NAME, HIRE_DATE, MONTHS_BETWEEN(SYSDATE, HIRE_DATE) -- FLOOR를 사용하여 변환해줌
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE, ABS(MONTHS_BETWEEN(HIRE_DATE, SYSDATE)) -- 음수가 나오기 때문에 ABS로 절대값으로 바꿔줌
FROM EMPLOYEE;

-- ADD_MONTHS : 날짜에서 숫자만큼 개월 수를 더하여 리턴
SELECT ADD_MONTHS(SYSDATE, 5) FROM DUAL;
SELECT ADD_MONTHS(SYSDATE, 3) FROM DUAL;
--EMPLOYEE 테이블에서 사원 명, 입사일, 입사 후 6개월이 된 날짜 조회
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 6)
FROM EMPLOYEE;

-- LAST_DAY : 해당 달에 마지막 날짜 리턴
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;

-- NEXT_DATE : 기준 날짜에서 구하려는 요일에 가장 가까운 날짜 리턴
SELECT SYSDATE, NEXT_DAY(SYSDATE, '금요일') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 5) FROM DUAL;
-- 일 월 화 수 목 금 토
-- 1  2  3  4  5  6  7
SELECT SYSDATE, NEXT_DAY(SYSDATE, '목') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '수연씨는 우리 반 미소천사') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '일초라도 안보이면 이렇게 초조한데 삼초는 어떻게 기다려 이야이야이야') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'THURSDAY') FROM DUAL; -- 한글로 local이 설정되어 있어 인식 불가

ALTER SESSION SET NLS_LANGUAGE = AMERICAN; -- 영어로 바꾼 후에는 THURSDAY 사용 가능, 단 목요일 불가
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'THU') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'THUoooooo000o') FROM DUAL;

ALTER SESSION SET NLS_LANGUAGE = KOREAN; -- 한국어로 세션 변경


-- EXTRACT: 년, 월, 일 정보를 추출해 리턴
-- EXTRACT(YEAR FROM 날짜): 년도 추출
-- EXTRACT(MONTH FROM 날짜): 달 추출
-- EXTRACT(DAY FROM 날짜): 일 추출
-- 4. EMPLOYEE 테이블에서 사원 명, 입사 년도, 입사 달, 입사 일 조회
SELECT EMP_NAME,
       EXTRACT(YEAR FROM HIRE_DATE) "입사 연도",
       EXTRACT(MONTH FROM HIRE_DATE) "입사 달",
       EXTRACT(DAY FROM HIRE_DATE) "입사 일"
FROM EMPLOYEE
-- DB에서 자료 정렬하기 (오름차순이 디폴트)
-- 오름차순 정렬(생략가능): ORDER BY 이름 ASC
-- 내림차순 정렬(생략불가): ORDER BY 이름 DESC
-- ORDER BY EXTRACT(YEAR FROM HIRE_DATE)
-- ORDER BY 4 -- SELECT에 4번째로 작성한 내용(입사일)을 기준으로 정렬
-- ORDER BY EMP_NAME; -- DB에서 정렬하기
-- ORDER BY "입사 연도"; -- 컬럼명이 아닌 "별칭"으로 정렬 가능
ORDER BY "입사 연도" ASC, 이름 DESC; -- 오름/내림차순 혼합 정렬 가능

-- EMPLOYEE 테이블에서 사원의 이름, 입사 월 입사 일, 근무 년수 조회
-- 단 근무 년수는 현재년도 - 입사년도로 조회하세요
SELECT EMP_NAME, HIRE_DATE,
       EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) "근무년수"
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE,
       FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) "근무년수"
FROM EMPLOYEE;

-- 4. 형변환 함수
-- TO_CHAR : 날짜/숫자 데이터를 문자 데이터 변경
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '99999') A FROM DUAL; -- 5칸, 오른쪽 정렬, 빈칸 공백('9'는 하나의 자리수를 의미)
SELECT TO_CHAR(1234, '00000') A FROM DUAL; -- 5칸, 오른쪽 정렬, 빈칸 0으로 채움
SELECT TO_CHAR(1234, 'L99999') A FROM DUAL; -- L 원화 기호 추가
SELECT TO_CHAR(1234, 'FML99999') A FROM DUAL; -- FM추가하여 원화 기호 앞의 공백 지움
SELECT TO_CHAR(1234, 'FM$99999') A FROM DUAL; -- 달러 기호 추가
SELECT TO_CHAR(1234, 'FM99,999') A FROM DUAL; -- 자리 수 구분 추가 + 공백 제거
SELECT TO_CHAR(1234, '00,000') A FROM DUAL; -- 빈자리 0으로 채움
SELECT TO_CHAR(1234, '999') A FROM DUAL; -- 자리 수가 부족해 ###으로 표시됨


-- EMPLOYEE 테이블에서 사원명, 급여 조회 (급여는 '\(원화기호)9,000,000' 형식으로 표시)
SELECT EMP_NAME "사원명", TO_CHAR(SALARY, 'FML999,999,999') "급여"
FROM EMPLOYEE;

SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS') FROM DUAL; -- AM,PM은 시스템 시간에 맞춰 나옴, HH24: 24시각제, MI분, SS초
SELESELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON DY, YYYY') FROM DUAL; --8월, 목 2020
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY') FROM DUAL; -- 2020-08-20 목요일
SELECT TO_CHAR(SYSDATE, 'YYYY-FMMM-DD DAY') FROM DUAL; -- 2020-8-20 목요일, FM을 MM에 붙이면 DD까지 적용됨
SELECT TO_CHAR(SYSDATE, 'YEAR, Q') FROM DUAL; -- TWENTY TWENTY, 3(YEAR: 영어로 년도 표기, Q: 분기)

-- 오늘 날짜에 대해 연도 4자리, 2자리, 연도 이름 출력
SELECT TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'YY'), TO_CHAR(SYSDATE, 'YEAR') FROM DUAL;

-- 오늘 날짜에서 월만 출력
SELECT TO_CHAR(SYSDATE, 'MM'), TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'MON'), TO_CHAR(SYSDATE, 'RM') -- RM: 로마숫자표기력
FROM DUAL;
    
-- 오늘 날짜에서 일만 출력
SELECT TO_CHAR(SYSDATE, 'DDD'), -- 일년 기준으로 며칠
       TO_CHAR(SYSDATE, 'DD'), -- 이번달 기준으로 며칠
       TO_CHAR(SYSDATE, 'D') -- 이번주 기준 며칠
FROM DUAL;  
       
-- EMPLOYEE 테이블에서 이름, 입사일 조회
-- 입사일은 포맷 적용 : 2020년 08월 20일 (목)
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일" "("DY")"')
FROM EMPLOYEE;

-- TO_DATE : 문자나 숫자를 날짜 데이터로 변환
SELECT TO_DATE('20200101', 'YYYYMMDD') FROM DUAL;
SELECT TO_DATE(20200101, 'YYYYMMDD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('20200101', 'YYYYMMDD'), 'YYYY,MON') FROM DUAL;
SELECT TO_CHAR(TO_DATE('210208 215000', 'YYMMDD HH24MISS'), 'YYYY-MM-DD PM HH:MI:SS DY') FROM DUAL;

-- RR과 YY의 차이
-- Y를 적용할 경우 두 자리 연도에 현재 세기 적용
-- R을 적용할 경우 두 자리 연도가 50 이상 일때는 이전 세기, 50 미만 일때는 현재 세기
SELECT TO_CHAR(TO_DATE('980504', 'YYMMDD'), 'YYYYMMDD') FROM DUAL; -- 20980504
SELECT TO_CHAR(TO_DATE('140925', 'YYMMDD'), 'YYYYMMDD') FROM DUAL; -- 20140915
SELECT TO_CHAR(TO_DATE('980504', 'RRMMDD'), 'YYYYMMDD') FROM DUAL; -- 19980504
SELECT TO_CHAR(TO_DATE('140925', 'RRMMDD'), 'YYYYMMDD') FROM DUAL; -- 20140915

-- EMPLOYEE 테이블에서 2000년도 이후에 입사한 사원의 사번, 이름, 입사일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
-- WHERE HIRE_DATE >= '00/01/01'; -- 혹은
WHERE HIRE_DATE >= TO_DATE(20000101, 'RRRRMMDD');


-- TO_NUMBER : 문자 데이터를 숫자 데이터로 변환
SELECT TO_NUMBER('123456789') FROM DUAL;
SELECT '123' + '456' FROM DUAL; --> 결과: 579, 알아서 숫자로 형변환 되어서 계산됨
SELECT '123' + '456A' FROM DUAL; --> 문자가 섞이면 숫자로 자동 형변환 불가
SELECT '1,000,000' + '550,000' FROM DUAL; --> 자리수 구분자도 문자로 처리해 계산 안됨
SELECT TO_NUMBER('1,000,000', '9,999,999') + TO_NUMBER('550,000', '999,999') FROM DUAL;


-- 5. NULL 관련 함수
SELECT SALARY * (1 + BONUS)
FROM EMPLOYEE;

-- NVL(컬럼명, 컬럼값이 NULL일 때 바꿀 값)
SELECT EMP_NAME, BONUS, NVL(BONUS, 0) -- (null)을 0으로 바꿔주었음
FROM EMPLOYEE;

-- NVL2 (컬럼 명, 바꿀 값1, 바꿀 값2)
-- 해당 컬럼의 값이 있으면 바꿀 값1로 변경, 컬럼의 값이 없으면 바꿀 값2로 변경
-- EMPLOYEE 테이블에서 보너스가 NULL인 직원은 0.5로, NULL이 아닌 직원은 0.7로 변경
SELECT EMP_NAME, BONUS, NVL2(BONUS, 0.7, 0.5) 
FROM EMPLOYEE;


-- NULLIF(비교대상1, 비교대상2)
-- 두 개의 값이 동일하면 NULL, 동일하지 않으면 비교대상1 반환
SELECT NULLIF(123, 123), NULLIF(123, 124) FROM DUAL;



-- 6. 선택 함수
-- DECODE(계산식|컬럼명, 조건값1, 선택값1, 조건값2, 선택값2, 조건값3, 선택값3, ....)
-- 비교하려고 하는 컬럼이나 값이 조건식과 같으면 결과 값을 반환
SELECT EMP_ID, EMP_NAME, EMP_NO,
       DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', 2, '여');
       -- DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', '여'); -- 1이 아니면 모두 '여'로 출력
FROM EMPLOYEE;

-- 직원의 급여를 인상하고자 한다
-- 직급코드가 J7이면 급여의 10% 인상
-- 직급코드가 J6이면 급여의 15% 인상
-- 직급코드가 J5이면 급여의 20% 인상
-- 그외 직급은 5% 인상
-- EMPLOYEE 테이블에서 직원 명, 직급 코드, 급여, 인상 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY,
       DECODE(JOB_CODE, 'J7', SALARY*1.1,
                        'J6', SALARY*1.15,
                        'J5', SALARY*1.2,
                        SALARY*1.05) 인상급여
FROM EMPLOYEE;


-- CASE WHEN 조건식 THEN 결과값
--      WHEN 조건식 THEN 결과값
--      ELSE 결과값
-- END
-- 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 결과 값 반환(조건은 범위 값 가능)
SELECT EMP_ID, EMP_NAME, EMP_NO,
        CASE WHEN SUBSTR(EMP_NO, 8, 1) = 1 THEN '남'
             ELSE '여'
        END 성별
FROM EMPLOYEE;

SELECT EMP_NAME, SALARY,
        CASE WHEN JOB_CODE = 'J7' THEN SALARY * 1.1
             WHEN JOB_CODE = 'J6' THEN SALARY * 1.15
             WHEN JOB_CODE = 'J5' THEN SALARY * 1.2
             ELSE SALARY * 1.05
        END 인상급여
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, SALARY,
       CASE WHEN SALARY > 5000000 THEN '1등급'
            WHEN SALARY > 3500000 THEN '2등급'
            WHEN SALARY > 2000000 THEN '3등급'
            ELSE '4등급'
        END 등급
FROM EMPLOYEE;

-- 사번, 사원명, 급여
-- 급여가 500만원 이상이면 '고급'
-- 급여가 300~500만원이면 '중급'
-- 그 이하는 '초급'으로 출력 처리하고 별칭은 '구분'으로 한다.
SELECT EMP_ID, EMP_NAME, SALARY,
       CASE WHEN SALARY >= 5000000 THEN '고급'
            WHEN SALARY >= 3500000 THEN '중급'
            ELSE '초급'
        END 구분
FROM EMPLOYEE;-- SUBSTR: 컬럼이나 문자열에서 지정한 위치부터 지정한 개수의 문자열을 잘라내어 반환









