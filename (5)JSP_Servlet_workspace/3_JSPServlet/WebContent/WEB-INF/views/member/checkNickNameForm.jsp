<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="inputValue()">
	<b>닉네임 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkNickName.me" id="nickNameForm">
		<input type="text" id="inputNickName" name="inputNickName">
		<input type="submit" value="중복확인"/>
	</form>
	
	<br>
	<% if(request.getAttribute("result") != null){
		
			int result = (int)request.getAttribute("result");
			
			if(result > 0) {
	%>
				이미 사용 중인 닉네임입니다.
				
	<% 		} else { %>
	
				사용할 수 있는 닉네임입니다.
	<%		} 
	
		}%>
	<br>
	<br>
	
	<input type="button" id="usedId" value="확인" onclick="inputNickName();">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue(){
		
			if('<%= request.getAttribute("checkedNickName") %>' == 'null') {
				document.getElementById('inputNickName').value = opener.document.joinForm.nickName.value;
			} else {
				document.getElementById('inputNickName').value = <%= request.getAttribute("checkedNickName") %>;
			}
		}
		
		function inputNickName(){
			
			opener.document.joinForm.nickName.value = document.getElementById('inputNickName').value;
			
			self.close();
		}
	</script>
</body>
</html>