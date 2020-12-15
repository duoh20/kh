<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#infoTable{margin: auto;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<h1 align="center">내 정보 보기</h1>
	<form action="${ contextPath }/memberUpdateForm.me" method="post">
		<table id="infoTable">
			<tr>
				<td width="100px">* 아이디</td>
				<td>${ loginUser.userId }</td>
			</tr>
			<tr>
				<td>* 이름</td>
				<td>${ loginUser.userName }</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;이메일</td>
				<td>${ loginUser.email }</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;생년월일</td>
				<td>${ loginUser.birthDay }</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;전화번호</td>
				<td>${ loginUser.phone }</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;주소</td>
				<td>${ loginUser.address }</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;성별</td>
				<td>
					<c:if test="${ loginUser.gender eq 'M' }">
						남자
					</c:if>
					<c:if test="${ loginUser.gender eq 'F' }">
						여자
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<br>
</body>
</html>