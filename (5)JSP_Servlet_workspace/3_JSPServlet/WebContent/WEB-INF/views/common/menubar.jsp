<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginUser
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP&Servlet</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<style>
	body{
		background:url('<%= request.getContextPath() %>/images/bg.png') no-repeat center center fixed;
		background-size: cover;
	}
	.loginArea{float: right;}
	#loginTable{text-align: right;}
	#loginTable td:nth-child(1){padding-right: 15px;}
	.loginBtns{float: right; margin-left: 5px;}
	#loginBtn, #myPage{background: #D1B2FF;}
	#joinBtn, #logout{background: #B2CCFF;}
	input[type=button], input[type=submit]{cursor: pointer; border-radius: 15px; color: white;}
	#userInfo label{font-weight: bold;}

	.wrap{background: white; width: 100%; height: 50px;}
	.menu{
		background: white; color: navy; text-align: center; font-weight: bold; 
		vertical-align: middle; width: 150px; height: 50px; display: table-cell;
	}
	nav{width: 600px; margin-left: auto; margin-right: auto;}
	.menu:hover {background: beige; color:orangered; font-weight:bold; cursor:pointer;}
</style>
</head>
<body>
	<h1 align="center">Welcome to JSP&amp;Servlet World!</h1>
	
	<div class="loginArea">
		<!-- 로그인이 안되었을 때만 보이는 영역 -->
		<form id="loginForm" action="<%= request.getContextPath() %>/login.me" method="post">
		<!--  contextPath를 모르겠을 땐, request 객체의 getContextPath()를 사용해 root context를 찾을 수 있다. -->
			<table id="loginTable">
				<tr>
					<td><label>ID</label></td>
					<td><input type="text" name="userId" id="userId"></td>
				</tr>
				<tr>
					<td><label>PWD</label></td>
					<td><input type="password" name="userPwd" id="userPwd"></td>
				</tr>
			</table>
			<div class="loginBtns">
				<input type="submit" id="loginBtn" value="로그인">
				<input type="button" id="joinBtn" value="회원가입">
			</div>
		</form>
	</div>
	<br clear="all">
</body>
</html>