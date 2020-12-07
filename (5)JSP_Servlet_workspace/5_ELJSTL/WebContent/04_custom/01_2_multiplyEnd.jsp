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
	<h1>jstl core 라이브러</h1>
	<p>
		사용할 태그 라이브러리 선언하기: taglib 지시자 사용<br>
		prefix: 앞 첨자(접두어), 다른 태그와 구별할 수 있는 name space를 제공(변수같은 역할)<br>
		uri: 실제 웹 상의 주소가 아닌 태그 라이브러리를 나타내는 식별자로 이 지시자를 통해 작성한 태그 이름과 매칭되는 자바 코드를 찾음<br>
	</p>

	<h2>c:set 태그</h2>
	* c:set으로 생성한 변수는 pageScope임
	<%--  변수 선언 --%>
	<c:set var="no1" value="${ param.num1 }" />
	<c:set var="no2" value="${ param.num2 }" />
	
	<c:set var="result1" value="${ param.num1 * param.num2 }" /> <%--  el 안에서 연산 가능함 --%>
	<c:set var="result" value="${ no1 * no2 }" /> 
	<p>param.num1 * param.num2: ${ no1 } 곱하기 ${ no2 }의 값은? ${ result1 }</p>
	<p>no1 * no2 :${ no1 } 곱하기 ${ no2 }의 값은? ${ result }</p>
	
	<hr>
	
	<h2>c:remove 태그</h2>
	<p>지정한 변수를 모든 scope에서 검색해 삭제하거나 지정한 scope에서 삭제</p>
	<c:set var="result" value="9999" scope="request" />
	삭제 전\${ result } : ${ result }<br>
	삭제 전\${ requestScope.result } : ${ requestScope.result }<br>
	<br>
	<%-- <c:remove var="result" /> 
	<p>scope="" 속성을 설정하지 않으면 모든 스코프에서 삭제</p>
	삭제 후\${ result } : ${ result }<br>
	삭제 후\${ requestScope.result } : ${ requestScope.result } --%>
	<c:remove var="result" scope="page"/> 
	<p>scope="" 속성을 설정하지 않으면 모든 스코프에서 삭제</p>
	삭제 후\${ result } : ${ result }<br>
	삭제 후\${ requestScope.result } : ${ requestScope.result }
	
</body>
</html>