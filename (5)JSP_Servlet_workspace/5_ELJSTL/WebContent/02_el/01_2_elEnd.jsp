<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="action.model.vo.Person" %>
<% 
	Person person = (Person)request.getAttribute("person");
	int year = (int)request.getAttribute("year");
	String beverage = (String)request.getAttribute("beverage");
	String[] products = (String[])request.getAttribute("products");
	String book = (String)request.getAttribute("book");
	String movie = (String)request.getAttribute("movie");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>scriptlet을 통해 request 객체에 저장된 데이터 출력</h2>
	<h4>개인정보(<%= year %>)</h4>
	이름: <%= person.getName() %><br>
	성별: <%= person.getGender() %><br>
	나이: <%= person.getNai() %><br>
	<h4>취향 정보</h4>
	<%= person.getName() %>님이 가장 좋아하는 음료 : <%= beverage %><br>
	<%= person.getName() %>님이 가장 좋아하는 물건 : <%= products[0] %>  <%= products[1] %>  <%= products[2] %><br>
	<%= person.getName() %>님이 가장 좋아하는 도서 : <%= book %><span style="color:gray;">(스코프를 설정하지 않아 값을 못 받아옴)</span><br>
	<%= person.getName() %>님이 가장 좋아하는 도서 : <%= session.getAttribute("book") %><br>
	<%= person.getName() %>님이 가장 좋아하는 영화 : <%= movie %><span style="color:gray;">(스코프를 설정하지 않아 값을 못 받아옴)</span><br>
	<%= person.getName() %>님이 가장 좋아하는 영화 : <%= application.getAttribute("movie") %><br>
	
	<hr>
	
	<h2>el의 내장 객체 XXXScope를 통해 저장된 데이터 출력</h2>
	<h4>개인정보(${ requestScope.year })</h4>
	이름: ${ requestScope.person.name }<br>
	성별: ${ requestScope.person.gender }><br>
	나이: ${ requestScope.person.nai }<br>
	<h4>취향 정보</h4>
	${ requestScope.person.name }님이 가장 좋아하는 음료 : ${ requestScope.beverage }<br>
	${ requestScope.person.name }님이 가장 좋아하는 물건 : ${ requestScope.products[0] },
													  ${ requestScope.products[1] },
													  ${ requestScope.products[2] }<br>
	${ requestScope.person.name }님이 가장 좋아하는 도서 : ${ requestScope.book }<span style="color:gray;">(잘못된 스코프 설정으로 값을 못 받아옴)</span><br>
	${ requestScope.person.name }님이 가장 좋아하는 도서 : ${ sessionScope.book }<br>
	${ requestScope.person.name }님이 가장 좋아하는 영화 : ${ requestScope.movie }<span style="color:gray;">(잘못된 스코프 설정으로 값을 못 받아옴)</span><br>
	${ requestScope.person.name }님이 가장 좋아하는 영화 : ${ applicationScope.movie }<br>
	
	<br>
	
	<h2>scope 생략하여 저장된 데이터 출력</h2>
	<p>
		el은 내장 객체 pageScope, requestScope, sessionScope, applicationScope는 생략 가능<br>
		el pageScope → requestScope → sessionScope → applicationScop 순으로 찾음<br>
		여러 스코프에 동일한 속성을 기록하고 이름 충돌(name conflict)이 의심되면 명시적으로 scope를 지정해야함
	</p>
	<h4>개인정보(${ year })</h4>
	이름: ${ person.name }<br>
	성별: ${ person.gender }><br>
	나이: ${ person.nai }<br>
	<h4>취향 정보</h4>
	${ person.name }님이 가장 좋아하는 음료 : ${ beverage }<br>
	${ person.name }님이 가장 좋아하는 음료 : ${ sessionScope.beverage }<br>
	${ person.name }님이 가장 좋아하는 음료 : ${ applicationScope.beverage }<br>
	${ person.name }님이 가장 좋아하는 물건 : ${ products[0] }, 
										 ${ products[1] }, 
										 ${ products[2] }<br>
	${ person.name }님이 가장 좋아하는 도서 : ${ book }<br>
	${ person.name }님이 가장 좋아하는 영화 : ${ movie }<br>
	<hr>
</body>
</html>