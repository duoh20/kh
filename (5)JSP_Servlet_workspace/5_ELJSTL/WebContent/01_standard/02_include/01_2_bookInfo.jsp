<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center;">
		<h3>신간 소개</h3>
		도서 명 : 돈의 속성<br>
		저자 : 김승호<br>
		페이지 수 : 283 페이이<br>
		가격 : 16,800원<br>
		
		<hr>
		
		<!--  스크립틀릿으로 include -->
		<%@include file="01_1_bookCopyRight.jsp" %>
		
		<hr>
		
		<!--  jsp 액션 태그로 include -->
		<jsp:include page="01_1_bookCopyRight.jsp"></jsp:include>
	</div>
</body>
</html>