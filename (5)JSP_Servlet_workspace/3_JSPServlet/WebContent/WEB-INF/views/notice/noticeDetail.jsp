<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice" %>

<%@ page import="notice.model.vo.Notice" %>

<%
	Notice notice = new Notice();
	notice = (Notice)request.getAttribute("notice");
	System.out.println(notice);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.outer{
		width: 600px; height: 500px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	.tableArea {width:450px; height:350px; margin-left:auto; margin-right:auto;}
	#updateNoBtn{background: #D1B2FF;}
	#cancelBtn{background: #B2CCFF;}
	#deleteNoBtn{background: #D5D5D5;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">공지사항</h2>
		<div class="tableArea">
			<form action="noticeUpdateForm.no" id="detailForm" name="detailForm" method="post">
				<table>
					<tr>
						<th>제목</th>
						<td colspan="3">
							<input type="hidden" name="no" value="<%= notice.getNoticeNo() %>">
							<!-- db에서 수정할 정보를 가져올 때 notice 번호를 가지고 db에서 정보를 가져오기 위함, 혹은 가져올 정보 마다 hidden을 넣고 가져오는 방법도 있다 -->
							<%= notice.getNoticeTitle() %>
						</td>				
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<%= notice.getNickName() %>
						</td>
						<th>작성일</th>
						<td><%= notice.getNoticeDate() %></td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content" cols="60" rows="15" style="resize:none;" readonly><%= notice.getNoticeContent() %></textarea>
						</td>
					</tr>
				</table>
			
				<br>
				
				<div align="center">
					<% if(loginUser != null && loginUser.getUserId().equals(notice.getNoticeWriter())){ %>
					<input type="submit" id="updateNoBtn" value="수정">
					<input type="submit" id="updateNoBtn" value="삭제"> <!-- /delete.no?no=(번호)로 넘기면 됨 -->
					<% } %>
					<input type="button" onclick="location.href='javascript:history.go(-1);'" id="cancelBtn" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>