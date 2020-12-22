<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="error-contaioner" style="text-align: center">
		<h1>error</h1>
		<p style="color: blue;">${message}</p>
		<p style="color: blue;">${requestScope['javax.servlet.error.message']}</p>
	</div>
</body>
</html>