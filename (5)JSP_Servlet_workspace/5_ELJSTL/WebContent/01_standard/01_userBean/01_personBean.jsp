<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP 표준 액션 태그 중 useBean을 사용하여 VO클래스의 객체 정보를 불러와보기</h2>
	<jsp:useBean id="person1" class="action.model.vo.Person" scope="request"></jsp:useBean>
	<!-- 
		import action.model.vo;
		Person pserson1 = new Person();
		
		해당 스코프에서 속성 값이 해당 클래스 타입으로 person이 존재하면 해당 객체를 가져오고 없으면 새로 생성
	-->
	
	이름: <jsp:getProperty property="name" name="person1" /><br>
	성별: <jsp:getProperty property="gender" name="person1" /><br>
	나이: <jsp:getProperty property="nai" name="person1" /><br>
	<!-- get/setProperty는 vo의 getter 메소드 이름을 보고 가져옴 필드에 age가 없어도 getAge()라는 getter가 있다면 가져옴 -->
	
	<h2>JSP 표준 액션 태그 중 useBean을 사용해 VO 클래스에 데이터 초기화하기</h2>
	<jsp:useBean id="person2" class="action.model.vo.Person" scope="request"></jsp:useBean>
	
	<jsp:setProperty property="name" name="person2" value="박신우" /><br>
	<jsp:setProperty property="gender" name="person2" value="F" /><br>
	<jsp:setProperty property="nai" name="person2" value="20" /><br>
	
	<br>
	이름: <jsp:getProperty property="name" name="person2" /><br>
	성별: <jsp:getProperty property="gender" name="person2" /><br>
	나이: <jsp:getProperty property="nai" name="person2" /><br>
</body>
</html>