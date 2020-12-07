<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>우리 가족</h1>
	<ul>
		<c:set var="family" scope="request">신형만, 봉미선, 신짱구, 신짱</c:set>
		<c:forTokens items="${ family }" delims=", " var="f">
			<li>${ f }</li>
		</c:forTokens>
	</ul>
	
	<h1>우리 가족</h1>
	<ul>
		<c:forTokens items="${ familiesWithDelimeters }" delims=",./ " var="f">
			<li>${ f }</li>
		</c:forTokens>
	</ul>
</body>
</html>