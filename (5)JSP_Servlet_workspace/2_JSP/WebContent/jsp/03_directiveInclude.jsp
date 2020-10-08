<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<%-- <%	
	Date now = new Date();
	String today = String.format("%ty년 %tm월 %td일 %tA", now, now, now, now);
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_03_directiveInclude</title>
</head>
<body>
	<h1>
		오늘 날짜
		<span style="color:yellowgreen;">
			<%@ include file="today.jsp" %>
		</span>
	</h1>
</body>
</html>