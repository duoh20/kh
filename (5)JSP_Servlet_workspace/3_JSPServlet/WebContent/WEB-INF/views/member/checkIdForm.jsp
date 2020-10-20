<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="inputValue()">
<!-- body가 로드되자 마자 inputValue() 실헹 -->
<!-- Servlet으로 페이지를 불러올 때 계속해서 페이지가 onload되기 때문에, inputId의 값을 계속 불러온다.
따라서 처리가 필요하다. -->
	<b>아이디 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkId.me" id="idCheckForm">
		<input type="text" id="inputId" name="inputId">
		<input type="submit" value="중복확인"/>
	</form>
	
	<br>
	<%
	
		if(request.getAttribute("result") != null){
			int result = (int)request.getAttribute("result");
			
			if(result > 0) {
	%>
				이미 사용 중인 아이디입니다. 
	
	<% 		} else { %>
				사용 가능한 아이디입니다.
	<%		}
		}
	%>
	<br>
	<br>
	
	<input type="button" id="usedId" value="확인" onclick="usedId();">
	<input type="button" id="cancel" value="취소" onclick="window.close();">

	<script>
		function inputValue(){
			//document.getElementById('inputId').value
			//	= opener.document.joinForm.joinUserId.value;
				//나를 열어준 창(== opener)에서 id가 'joinForm'인 요소의 value값을 가지고 와 inputId에 집어 넣어준다
		
			
			/* 주의 사항 */
			//request.getAttribute은 String을 반환하므로, String으로 비교해주어야함
			//비교하는 값인 null을 문자열로 처리하지 않으면 값으로써 비교하기 때문에 올바른 비교가 아님!
			//null도 문자열 처리한다.
			//if('user02' == null) X
			//if('null' == 'null') O
			
			if('<%= request.getAttribute("checkedId") %>' == 'null') {
				document.getElementById('inputId').value = opener.document.joinForm.joinUserId.value;
			} else {
				document.getElementById('inputId').value = "<%= request.getAttribute("checkedId") %>";
			}
		}
		
		function usedId(){
			opener.document.joinForm.joinUserId.value = document.getElementById('inputId').value;
			
			self.close();
			//window.close()도 사용 가능
		}
	</script>
</body>
</html>