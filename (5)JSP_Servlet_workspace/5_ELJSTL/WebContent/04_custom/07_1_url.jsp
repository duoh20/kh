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
	<a href="07_2_urlEnd.jsp?pname=귀걸이&pcount=1&option=진주추가&optoin=빨간색">07_2_urlEnd.jsp</a>
	
	<br>
	
	<c:url value="07_2_urlEnd.jsp" var="u">
		<c:param name="pname" value="반지"/>
		<c:param name="pcount" value="2"/>
		<c:param name="option" value="루비"/>
		<c:param name="option" value="각인"/>
	</c:url>
	
	<a href="${ u }">07_2_urlEnd.jsp</a>

</body>
</html>