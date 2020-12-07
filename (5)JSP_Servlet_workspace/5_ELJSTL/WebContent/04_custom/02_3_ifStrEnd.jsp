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
	<%
		String str1 = request.getParameter("str1");
		String str2 = request.getParameter("str2");
	%>
	스크립틀릿:<br>연산자로 비교: <%= str1 == str2 %> / equals()로 비교: <%= str1.equals(str2) %><br> 
	String을 == 으로 비교하면 주소값을 비교하므로 equals() 메소드를 사용해 비교해야함
	
	<hr>
	
	<c:if test="${ param.str1.equals(param.str2) }">
		${ param.str1 }와 ${ param.str2 }는 같습니다.
	</c:if>
	<c:if test="${ !param.str1.equals(param.str2) }">
		${ param.str1 }와 ${ param.str2 }는 같지 않습니다.
	</c:if>
	
	<hr>
	
	<c:if test="${ param.str1 eq param.str2 }">
		${ param.str1 }와 ${ param.str2 }는 같습니다.
	</c:if>
	<c:if test="${ param.str1 ne param.str2 }">
		${ param.str1 }와 ${ param.str2 }는 같지 않습니다.
	</c:if>
	
	<hr>
	
	<c:if test="${ param.str1 == param.str2 }">
		${ param.str1 }와 ${ param.str2 }는 같습니다.
	</c:if>
	<c:if test="${ param.str1 != param.str2 }">
		${ param.str1 }와 ${ param.str2 }는 같지 않습니다.
	</c:if>
</body>
</html>