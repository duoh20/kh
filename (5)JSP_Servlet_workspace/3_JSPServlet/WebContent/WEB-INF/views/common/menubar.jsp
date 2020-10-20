<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="member.model.vo.Member" %>

<% 
	Member loginUser = (Member)session.getAttribute("loginUser");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP&Servlet</title>
<%-- request.getContextPath() == Web Content--%>
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
		<% if(loginUser == null) { %>
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
				<input type="button" id="joinBtn" value="회원가입" onclick="memberJoin();">
			</div>
		</form>
		<% } else { %>
		<div id="userInfo" align="right">
			<label><%= loginUser.getUserName() %>님의 방문을 환영합니다.</label>
			<div class="btns">
				<div id="myPageBtn" onclick="myPage();">내 정보 보기</div>
				<div id="logoutBtn" onclick="logout();">로그아웃</div>
			</div>
		</div>
		<% } %>
	</div>
	<br clear="all">
	
	<br>
	<div class="wrap">
		<nav>
			<div class="menu" onclick="goHome();">HOME</div>
			<div class="menu" onclick="goNotice();">공지사항</div>
			<div class="menu" onclick="goBoard();">게시판</div>
			<div class="menu" onclick="goThumbnail();">사진게시판</div>
		</nav>
	</div>
	
	<script>
		function logout(){
			location.href='<%= request.getContextPath() %>/logout.me';
		}
		
		function memberJoin(){
			location.href='<%= request.getContextPath() %>/signUpForm.me';
		}
		
		function myPage(){
			location.href='<%= request.getContextPath() %>/myPage.me';
		}

		function goHome(){
			location.href='<%= request.getContextPath() %>';
		}
		function goNotice(){
			location.href='<%= request.getContextPath() %>/list.no';
		}	
		function goBoard(){
			location.href='<%= request.getContextPath() %>/list.bo';
		}	
		function goThumbnail(){
			location.href='<%= request.getContextPath() %>/list.th';
		}	
		
	</script>
</body>
</html>