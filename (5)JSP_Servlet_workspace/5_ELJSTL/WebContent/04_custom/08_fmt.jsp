<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL fmt</h2>
	<p>날짜, 시간, 숫자 데이터의 출력 형식을 지정할 때 사용</p>
	
	<h3>숫자 데이터 포맷 지정: formatNmber 태그 사용</h3>
	천 단위씩 구분 기호 적용 : <fmt:formatNumber value="123456789"/><br>
 		ㄴ groupingUsed 디폴트는 true : <fmt:formatNumber value="123456789" groupingUsed="true"/><br>
	숫자 그대로 출력 : <fmt:formatNumber value="123456789" groupingUsed="false"/><br>
	formatNumber에서 groupingUsed는 true가 기본 값<br>
	
	<br>
	
	<b>실수 값 소수점 아래 자리수 지정 : pattern 속성 사용</b><br>
	디폴트: <fmt:formatNumber value="1.234567" /><br>
	소수점 아래 3번째 자리에서 반올림 함<br>
	
	pattern="#.##" : <fmt:formatNumber value="1.239567" pattern="#.##" /><br>
	패턴을 초과한 자리수는 반올림<br>
	
	pattern="#.00" : <fmt:formatNumber value="1.2" pattern="#.00" /><br>
	패턴보다 자리 수가 작을 경우 0으로 채움<br>
	
	<h3>type 속성으로 백분율, 통화기호 표시</h3>
	<ul>
	<li>type="percent" : <fmt:formatNumber value="0.12" type="percent" /><br>
	백분율로 변환</li>
	<li>type="currency" : <fmt:formatNumber value="123456788" type="currency" /><br>
	통화 기호 표시</li>
	<li>currencySymbol="$"  : <fmt:formatNumber value="123456788" type="currency" currencySymbol="$" /><br>
	통화 기호 출력</li>
	</ul>
</body>
</html>