<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board" %>
<%
	Board board = (Board)request.getAttribute("board");
	String category = board.getCategory();
	System.out.println(category);
	int cate = 0;
	switch(category){
	case "공통": cate = 10; break;
	case "운동": cate = 20; break;
	case "등산": cate = 30; break;
	case "게임": cate = 40; break;
	case "낚시": cate = 50; break;
	case "요리": cate = 60; break;
	case "기타": cate = 70; break;
	}
	
	String[] selected = new String[7];
	selected[(cate/10) - 1] = "selected";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Board</title>
<style>
	.outer{
		width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	.tableArea {width:500px; height:350px; margin-left:auto; margin-right:auto;}
	#updateBtn, #cancelBtn{background: #B2CCFF; border-radius: 10px; color: white; width: 80px; height: 25px; display: inline-block;}
	#updateBtn:hover, #cancelBtn:hover{cursor: pointer;}
	#cancelBtn{background: #D1B2FF;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
		
	<div class="outer">
		<br>
		<h2 align="center">게시판 수정</h2>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/update.bo" method="post">
				<table>
					<tr>
						<th>분야<input type="hidden" name="bId" value="<%= board.getBoardId() %>"></th>
						<td>
							<select name="category">
								<option>--------</option>
								<option value="10" <%= selected[0] %>>공통</option>
								<option value="20" <%= selected[1] %>>운동</option>
								<option value="30" <%= selected[2] %>>등산</option>
								<option value="40" <%= selected[3] %>>게임</option>
								<option value="50" <%= selected[4] %>>낚시</option>
								<option value="60" <%= selected[5] %>>요리</option>
								<option value="70" <%= selected[6] %>>기타</option>
							</select>
						</td>	
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" size="58" name="title" value="<%= board.getBoardTitle() %>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="15" cols="60" name="content" style="resize:none;"><%= board.getBoardContent() %></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button type="submit" id="updateBtn">수정</button>
					<div id="cancelBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo'">취소</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>