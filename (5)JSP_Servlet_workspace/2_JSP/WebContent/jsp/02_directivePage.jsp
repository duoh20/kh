<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error/error.jsp" %>
<%-- <%@ page import="java.util.ArrayList, javva.io.FileReader" %> --%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.FileReader" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_02_directivePage</title>
</head>
<body>
	<%
		int total = 0;
		for(int i = 1; i <= 10; i++){
			total += 1;
		}
		System.out.println("덧셈 끝");
	
		ArrayList<String> list = new ArrayList<String>();
		/*
		ArrayList를 사용하려면 자바 클래스를 import 해야 한다.
		상단 <%@page 부분에 impot="자바클래스" 구문을 작성해준다.
		*/
		
		list.add(0, null);
		
		System.out.println(list.get(0).charAt(0));
		/*
			인덱스 0에 널이 있으므로 NullPointerException이 발생 
			
		*/
	%>
</body>
</html>