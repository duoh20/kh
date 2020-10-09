<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
   <%-- 에러 페이지는 page 영역에 isErrorPage 속성을 true로 명시해야한다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_Error Page</title>
</head>
<body>
	<h1>에러다~!!!</h1>
	<%= exception.getMessage() %><br>
	<%= exception.getStackTrace() %><br>
	<%= exception.getClass().getName() %><br>
	
</body>
</html>