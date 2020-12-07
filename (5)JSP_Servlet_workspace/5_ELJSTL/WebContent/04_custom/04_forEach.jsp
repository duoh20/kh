<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="6">
		${ i }
		<h${ i }>반복문</h${ i }>
	</c:forEach>
	<br>
	<h2>step 속성 값을 2로 설정</h2>
	<c:forEach var="i" begin="1" end="6" step="2">
		<h${ i }>반복문</h${ i }>
	</c:forEach>
	<br>
	<h2>역순으로 출력</h2>
	<c:forEach var="i" begin="6" end="1"><!-- 조건 자체가 flase라 안됨 -->
		<h${ i }>반복문</h${ i }>
	</c:forEach>
	<%-- <c:forEach var="i" begin="6" end="1" step="-1"><!-- Error: step은 0보다 크거나 같아야함 -->
		<h${ i }>반복문</h${ i }>
	</c:forEach> --%>
	<c:forEach var="i" begin="1" end="6">
		<h${ 7-i }>반복문</h${ 7-i }>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="6" varStatus="vs">
	<!--  varStatu 객체를 vs라는 이름으로 지정한 것 -->
		vs.first: ${ vs.first }<br>
		vs.last: ${ vs.last }<br>
		vs.index: ${ vs.index }<br>
		vs.count: ${ vs.count }<br>
		vs.current: ${ vs.current }<br>
		<hr>
	</c:forEach>
</body>
</html>