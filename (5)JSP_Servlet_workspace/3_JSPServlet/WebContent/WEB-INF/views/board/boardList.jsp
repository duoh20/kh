<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, board.model.vo.Board, board.model.vo.PageInfo"%> 
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<style type="text/css">
	.outer{
		width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	#listArea{text-align: center;}
	.tableArea{width:650px;	height:350px; margin-left:auto;	margin-right:auto;}
	th{border-bottom: 1px solid grey;}
	.pagingArea button{border-radius: 15px; background: #D5D5D5;}
	.buttonArea{margin-right: 50px;}
	.buttonArea button{background: #D1B2FF; border-radius: 5px; color: white; width: 80px; heigth: 25px; text-align: center;}
	button:hover{cursor: pointer;}
	#numBtn{background: #B2CCFF;}
	#choosen{background: #FFD8D8;}
	#listArea{margin: auto;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">게시판</h2>
		<div class="tableArea">
			<table id="listArea">
				<tr>
					<th width="100px">글번호</th>
					<th width="100px">카테고리</th>
					<th width="300px">글제목</th>
					<th width="100px">작성자</th>
					<th width="100px">조회수</th>
					<th width="150px">작성일</th>
				</tr>
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="6">조회된 리스트가 없습니다.</td>
				</tr>
				<% } else { %>
				<% 		for(Board b : list){ %>
				<tr>
					<td><%= b.getBoardId() %></td>
					<td><%= b.getCategory() %></td>
					<td><%= b.getBoardTitle() %></td>
					<td><%= b.getNickName() %></td>
					<td><%= b.getBoardCount() %></td>
					<td><%= b.getCreateDate() %></td>
					
				</tr>
				<%		} %>
				<% } %>
			</table>
		</div>
		
		
		<!-- 페이징 -->
		<div class="paging area" align="center">
			
			<!-- 맨 처음으로 가는 버튼 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=1'">&lt;&lt;</button>
			
			<!-- 이전 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= currentPage - 1 %>'" id="beforeBtn">&lt;</button>
			<script>
				//1 페이지에서 이전 페이지로 가면 더 이상 이동 불가하므로 비활성화
				if(<%= currentPage %> <= 1){
					 var before = $('#beforeBtn');
					 before.attr('disabled', 'true');
				}
			</script>
			
			<!--  숫자 목록 버튼 -->
			<% for(int p = startPage; p <= endPage; p++){ %>
				<% if(p == currentPage) {%>
					<button id="choosen" disabled><%= p %></button>
				<% } else { %>
					<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= p %>'"><%= p %></button>
				<% } %>
			<% } %>
			
			<!-- 다음 페이지로 -->
			<button id="afterBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= currentPage + 1 %>'">&gt;</button>
			<script>
				if(<%= currentPage %> >= <%= maxPage %>){
					var after = $('#afterBtn');
					after.attr('disabled', 'true');
				}
			</script>
			
			<!-- 마지막 페이지로 -->
			<button id="beforeBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= maxPage %>'">&gt;&gt;</button>
					
		</div>
		
		<div class="buttonArea" align="right">
			<% if(loginUser != null){ %>
			<button onclick="location.href='<%= request.getContextPath() %>/writeBoardForm.bo'">작성하기</button>
			<% } %>
		</div>
	</div>
	
	<script>
		$(function(){
			$('#listArea td').mouseenter(function(){
				$(this).parent().css({'background':'darkgray', 'cursor':'pointer'});
			}).mouseout(function(){
				$(this).parent().css('background','none');
			}).click(function(){
				var bId = $(this).parent().children().eq(0).text();
				//내가 클릭한 요소의 부모(td)의 자식들(tr) 중 첫번쨰(0) 텍스트(즉 글번호)를 가져옴)
			
				if('<%= loginUser %>' != 'null'){
					//loginUser는 로그인 유저 정보를 담고 있는 형식으로 출력되어 Unexpected identifier 문법 에러 발생
					//loginUser의 결과는 String으로 반환해주어야함. 단 loginUser = null인 경우 null도 String 처리 되므로 비교하는 값 null도 String으로 처리해주어야
					
					location.href='<%= request.getContextPath() %>/detail.bo?bId=' + bId;
				} else {
					alert('회원만 이용할 수 있는 서비스입니다.');
				}
			});
		});
	</script>
</body>
</html>