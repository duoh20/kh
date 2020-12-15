<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   .outer{
      width:900px; min-height:50px; padding-bottom: 50px;
      margin-left:auto; margin:auto; margin-top:50px; margin-bottom: 50px; 
   }
   #boardTable{text-align:center; margin: auto; width: 900px;}
   #boardTable th{border-bottom: 3px solid lightgray;}
   #boardTable td{border-bottom: 1px solid lightgray;}
</style>
</head>
<body>
   <jsp:include page="../common/menubar.jsp"/>
      
   <!------------- 0_1.로그인한 회원만 게시물 보기를 하기 위해 다음과같은 조건 추가  -------------->
   <c:if test="${ !empty loginUser }">
      <div class="outer">
         <br>
         <h1 align="center">게시판</h1>
                  
         <!---------------- 1. 게시물 리스트 ------------------>
         <!-- 1_1. 게시물 리스트 보기  -->
         <table id="boardTable">
            <tr>
               <th>글 번호</th>
               <th>제목 </th>
               <th>작성자</th>
               <th>조회수</th>
               <th>작성일</th>
            </tr>
            
            <!-- forEach를 통해 request에 담겨있는 list들을 하나씩 접근하여 출력 -->
            <c:forEach items="${ list }" var="board">
               <tr>
                  <td>${ board.bId }</td>
                  <td>${ board.bTitle }</td>
                  <td>${ board.nickName }</td>
                  <td>${ board.bCount }</td>
                  <td>${ board.bCreateDate }</td>
               </tr>
            </c:forEach>
         </table>
         
         <!-- 1_2. 게시물 리스트 페이징 부분 -->
         <div class="pagingArea" align="center">
         
         	<!-- searchValue가 있으면 검색 Servlet으로, 있으면 게시판 조회 servlet으로 넘김 -->
         	<c:if test="${ searchValue eq null }">
         		<c:set var="loc" value="/selectList.bo"/>
         	</c:if>
         	<c:if test="${ searchValue ne null }">
         		<c:set var="loc" value="/search.bo"/>
         	</c:if>
         
         
         	<!-- [이전] -->
         	<c:if test="${ pi.currentPage <= 1 }">
         		<!-- 1 페이지면 이전 버튼만 보이고 작동 안함 -->
         		[이전]
         	</c:if>
         	<c:if test="${ pi.currentPage > 1 }">
         		<c:url var="blistBack" value="${ loc }">
         			
         			<!--  만약 검색어가 있다면 -->
         			<c:if test="${searchValue ne null }">
         				<!--  이전, 다음, 번호 등 페이지를 눌렀을 때 검색 조건을 유지시키기 위해 검색 옵션과 검색어를 가져옴 -->
         				<c:param name="searchCondition" value="${ searchCondition }"/>
         				<c:param name="searchValue" value="${ searchValue }"/>
         			</c:if>
         			
         			<!-- 이전 페이지로 이동 시킴 -->
         			<c:param name="currentPage" value="${ pi.currentPage - 1 }"/>
         		</c:url>
         		
         		<a href="${ blistBack }">[이전]</a>
         	</c:if>
         	
         	<!-- 페이지 -->
         	<c:forEach begin="${ pi.startPage }" end="${ pi.endPage }" var="p">
         		<c:if test="${ p eq pi.currentPage }">
         			<font color="red" size="4"><b>[${ p }]</b></font>
         		</c:if>
         		<c:if test="${ p ne pi.currentPage }">
         			<c:url var="blistCheck" value="${ loc }">
         				<c:if test="${ searchValue ne null }">
	         				<!--  이전, 다음, 번호 등 페이지를 눌렀을 때 검색 조건을 유지시키기 위해 검색 옵션과 검색어를 가져옴 -->
	         				<c:param name="searchCondition" value="${ searchCondition }"/>
	         				<c:param name="searchValue" value="${ searchValue }"/>
	         			</c:if>
         				
         				<c:param name="currentPage" value="${ p }"/>
         			</c:url>
         			
         			<a href="${ blistCheck }">${ p }</a>
         		</c:if>
         	</c:forEach>
         	
         	<!--  [다음] -->
         	<c:if test="${ pi.currentPage >= pi.maxPage }">
         		<!-- 1 페이지면 이전 버튼만 보이고 작동 안함 -->
         		[다음]
         	</c:if>
         	<c:if test="${ pi.currentPage < pi.maxPage }">
         		<c:url var="blistNext" value="${ loc }">
         			<c:if test="${searchValue ne null }">
         				<!--  이전, 다음, 번호 등 페이지를 눌렀을 때 검색 조건을 유지시키기 위해 검색 옵션과 검색어를 가져옴 -->
         				<c:param name="searchCondition" value="${ searchCondition }"/>
         				<c:param name="searchValue" value="${ searchValue }"/>
	         		</c:if>
	         			
         			<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
         		</c:url>
         		<a href="${ blistNext }">[다음]</a>
         	</c:if>
         
         </div>
         
         <!-----------  2. 상세보기 ------------->
         <script type="text/javascript">
            $(function(){
               $("#boardTable").find("td").mouseenter(function(){
                  $(this).parents("tr").css({"background":"black", "color":"white", "cursor":"pointer"});
               }).mouseout(function(){
                  $(this).parents("tr").css({"background":"none", "color":"black"});
               }).click(function(){
                  var bId=$(this).parents().children("td").eq(0).text();
   
                  location.href="selectOne.bo?bId="+bId;
               });
            });
         </script>
      </div>
   </c:if>
   
   <!-------------- 0_2. 로그인하지 않은경우 ---------------->
   <c:if test="${ empty loginUser }">
      <c:set var="message" value="로그인이 필요한 서비스입니다." scope="request"/>
      <jsp:forward page="../common/errorPage.jsp"/>
   </c:if>
   
   <!---------------- 3. 게시물 검색 ------------------>
   <div id="searchArea" align="center">
      <label>검색 조건</label>
      <select id="searchCondition" name="searchCondition">
         <option>-------</option>
         <option value="writer">작성자</option>
         <option value="title">제목</option>
         <option value="content">내용</option>
      </select>
      
      <input id="searchValue" type="search">
      <button onclick="searchBoard();">검색하기</button>
   </div>
   <script type="text/javascript">
      function searchBoard(){
         var searchCondition = $("#searchCondition").val();
         var searchValue = $("#searchValue").val();
         
         location.href="search.bo?searchCondition="+searchCondition+"&searchValue="+searchValue;
      }
   </script>
</body>
</html>