<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core>if</title>
</head>
<body>
	<p>\${param.num1}은 String으로 받아오기 때문에 \${Integer.parseInt(param.num1)}를 사용해 형변환한다.</p>
	<c:if test="${ Integer.parseInt(param.num1) > Integer.parseInt(param.num2) }">
		결과 : ${ Integer.parseInt(param.num1) }은 큽니다, ${ Integer.parseInt(param.num2) } 보다<br>
	</c:if>
	<c:if test="${ Integer.parseInt(param.num1) < Integer.parseInt(param.num2) }">
		결과 : ${ Integer.parseInt(param.num1) }은 큽니다, ${ Integer.parseInt(param.num2) } 보다<br>
	</c:if>
</body>
</html>