<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	Member member = (Member)request.getAttribute("member");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width: 48%; height: 450px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 5%;
	}
	#myForm td {text-align: center;}
	#myForm>table{margin: auto;}
	#updateBtn {background: #D1B2FF; color: white;}
	#updatePwdBtn {background: #FFD8D8; color: white;}
	#deleteBtn {background: #D5D5D5; color: white;}
	#goMain {background: #B2CCFF; color: white;}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">내 정보 보기</h2>
		
		<form action="<%= request.getContextPath() %>/updateForm.me" method="post" id="myForm" name="myForm">
			<table>
				<tr>
					<td width="200px">아이디</td>
					<td width="200px">
					<%= member.getUserId() %>
					<!-- <input type="text" maxlength="13" name="myId" required> --></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><%= member.getUserName() %><!-- <input type="text" name="myName" required> --></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><%= member.getNickName() %><!-- <input type="text" maxlength="15" name="myNickName" required> --></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<%= member.getPhone() == null ? "-" : member.getPhone() %>
						<!-- <input type="tel" maxlength="11" name="myPhone" placeholder="(-없이)01012345678"> -->
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<%= member.getEmail() == null ? "-" : member.getEmail() %>
						<!-- <input type="email" name="myEmail"> -->
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<%= member.getAddress() ==  null ? "-" : member.getAddress() %>
						<!-- <input type="text" name="myAddress"> -->
					</td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<%= member.getInterest() ==  null ? "-" : member.getInterest() %>
						<!-- <input type="checkbox" id="sports" name="myInterest" value="운동">
						<label for="sports">운동</label>
						<input type="checkbox" id="climbing" name="myInterest" value="등산">
						<label for="climbing">등산</label>
						<input type="checkbox" id="fishing" name="myInterest" value="낚시">
						<label for="fishing">낚시</label>
						<input type="checkbox" id="cooking" name="myInterest" value="요리">
						<label for="cooking">요리</label>
						<input type="checkbox" id="game" name="myInterest" value="게임">
						<label for="game">게임</label>
						<input type="checkbox" id="etc" name="myInterest" value="기타">
						<label for="etc">기타</label> -->
					</td>
				</tr>
			</table>
			
			<br>
			
			<div class="myPageBtns" align="center">
				<input id="updateBtn" type="submit" value="수정하기" onclick="location.href='updateForm.me'">
				<input id="updatePwdBtn" type="button" value="비밀번호 변경 하기" onclick="location.href='updatePwdForm.me'">
				<input id="deleteBtn" type="button" value="탈퇴하기" onclick="deleteMember();">
				<input type="button" id="goMain" value="메인으로" onclick="location.href='main.go'">
			</div>
		</form>
	</div>
	
	<script>
		function deleteMember(){
			var bool = confirm('정말 탈퇴하시겠어요?');// 정말 삭제할거냐고 물어본 후, 삭제하겠다고 하면 delete.me로 요청
			
			if(bool)
				location.href='delete.me';
			}
	</script>
</body>
</html>