<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>개인정보 입력 결과(action)</h2>
	<jsp:useBean id="person" class="action.model.vo.Person" scope="request">
			<!-- person이 request scope이므로 scope를 request로 설정하면 별도로 setProperty를 하지 않아도 됨 -->
			<%-- <jsp:setProperty property="name" name="person" param="name" />
			<jsp:setProperty property="nai" name="person" param="age" />
			<jsp:setProperty property="gender" name="person" param="gender"/> --%>
	</jsp:useBean>
	<table>
		<tr>
			<td>성명</td>
			<td><jsp:getProperty property="name" name="person" /></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><jsp:getProperty property="nai" name="person" /></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><jsp:getProperty property="gender" name="person" /></td>
		</tr>
	</table>
</body>
</html>