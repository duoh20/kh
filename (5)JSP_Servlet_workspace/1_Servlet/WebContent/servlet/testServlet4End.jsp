<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--  <% %> jsp 문법임 --%>
<% 
	String name = (String)request.getAttribute("name"); //obj를 반환하므로 필요한 자료 타입으로 형변환
	String gender = (String)request.getAttribute("gender");
	String age = (String)request.getAttribute("age");
	String city = (String)request.getAttribute("city");
	String height = (String)request.getAttribute("height");
	String[] foods = (String[])request.getAttribute("foods");
	String food = String.join(", ", foods);
	String recommendation = (String)request.getAttribute("recommendation");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 출력 화면</title>
<style>
	h2{color: red;}
	span.name{color: orange; font-weight: bold;}
	span.gender{color: yellow; font-weight: bold;}
	span.age{color: green; font-weight: bold;}
	span.city{color: blue; font-weight: bold;}
	span.height{color: navy; font-weight: bold;}
	span.food{color: purple; font-weight: bold;}
</style>
</head>
<body>
	<h2>개인 취향 테스트 결과(POST)</h2>
	<span class="name"><%= name %></span>님은
	<span class="age"><%= age %></span>이시며
	<span class="city"><%= city %></span>에 사는
	키 <span class='height'><%= height %></span>cm인
	<span class='gender'><%= gender %></span>입니다.
	좋아하는 음식은 <span class='food'><%= food %></span>입니다.
	<hr>
	<h3><%= age %>에 맞는 선물 추천</h3>
	<%= recommendation %> 선물은 어떠신가요?
</body>
</html>