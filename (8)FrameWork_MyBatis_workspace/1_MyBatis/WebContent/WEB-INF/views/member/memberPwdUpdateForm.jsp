<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#pwdTable{margin: auto;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<h1 align="center">비밀번호 수정</h1>
	<form action="${ contextPath }/mPwdUpdate.me" method="post">
	<input type="hidden" vlaue="${ loginUser.userId }">
		<table id="pwdTable">
			<tr>
				<td>* 현재 비밀번호</td>
				<td><input type="password" name="userPwd" required></td>
			</tr>
			<tr>
				<td>* 새 비밀번호</td>
				<td><input type="password" name="newPwd" required></td>
			</tr>
			<tr>
				<td>* 새 비밀번호 확인</td>
				<td><input type="password" name="newPwd2" required></td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<br>
						<input type="submit" value="수정하기">
						<button type="reset">취소</button>
						<button onclick="history.back()">뒤로가기</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<script>
		$(function(){
			$('input[name=newPwd2]').focusout(function(){
				$('tr:eq(5)>td').empty();
				var pw1 = $('input[name=newPwd]').val();
				var pw2 = $('input[name=newPwd2]').val();
				
				if(pw1 == '' && pw2 == '') {
					$('tr:eq(5)>td').append('비밀 번호를 입력해주세요.');
					$('input[name=newPwd]').focus();
				}
				
				if(pw1 != null && pw1 != pw2) {
					$('tr:eq(5)>td').append('입력하신 비밀번호가 일치하지 않습니다.');
					$('input[name=newPwd]').focus();
				}
			});
		});
	</script>
</body>
</html>