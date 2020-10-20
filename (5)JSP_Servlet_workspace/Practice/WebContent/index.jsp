<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Calendar" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_실습_pizza</title>
<style>
	table{
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	tr,th,td {
 		border: 1px solid black;
 		padding: 5px;
	}
</style>
</head>

<body>
<% 
	Calendar cal = Calendar.getInstance();
	int y = cal.get(Calendar.YEAR);
	int m = cal.get(Calendar.MONTH) + 1;
	int dt = cal.get(Calendar.DATE);
	int dy = cal.get(Calendar.DAY_OF_WEEK);
	String formatDy = "";
	
	switch(dy){
	 case 0: formatDy = "일요일"; break;
	 case 1: formatDy = "월요일"; break;
	 case 2: formatDy = "화요일"; break;
	 case 3: formatDy = "수요일"; break;
	 case 4: formatDy = "목요일"; break;
	 case 5: formatDy = "금요일"; break;
	 case 6: formatDy = "토요일"; break;
	}
%>

<h1>오늘은 <span style="color: pink;"><%= y %>년 <%= m %>월 <%= dt %>일 <%= formatDy %></span>입니다.</h1>

<h1>피자 아카데미 <span></span></h1>

<table>
	<tr>
		<th style="width: 50px;">종류</th>
		<th style="width: 120x;">이름</th>
		<th style="width: 60px;">가격</th>
		<td rowspan="12"></td>
		<th style="width: 50px;">종류</th>
		<th style="width: 120px;">이름</th>
		<th style="width: 60px;">가격</th>
	</tr>
	<tr>
		<td rowspan="5" style="text-align: center;">피자</td>
		<td>치즈피자</td>
		<td>5000</td>
		<td rowspan="11" style="text-align: center;">사이드</td>
		<td>오븐구이통닭</td>
		<td>9000</td>
	</tr>
	<tr>
		<td>콤비네이션피자</td>
		<td>6000</td>
		<td>치킨스틱&윙</td>
		<td>4900</td>
	</tr>
	<tr>
		<td>포테이토피자</td>
		<td>7000</td>
		<td>치즈오븐스파티</td>
		<td>4000</td>
	</tr>
	<tr>
		<td>고구마피자</td>
		<td>7000</td>
		<td>새우링&웨지감자</td>
		<td>3500</td>
	</tr>
	<tr>
		<td>불고기피자</td>
		<td>8000</td>
		<td>갈릭포테이토</td>
		<td>3000</td>
	</tr>
	<tr>
		<td rowspan="6" style="text-align: center;">토핑</td>
		<td>고구마무스</td>
		<td>1000</td>
		<td>콜라</td>
		<td>1500</td>
	</tr>
	<tr>
		<td>콘크림무스</td>
		<td>1500</td>
		<td>사이다</td>
		<td>1500</td>
	</tr>
	<tr>
		<td>파인애플토핑</td>
		<td>2000</td>
		<td>갈릭소스</td>
		<td>500</td>
	</tr>
	<tr>
		<td>치즈토핑</td>
		<td>2000</td>
		<td>피클</td>
		<td>500</td>
	</tr>
	<tr>
		<td>치즈크러스트</td>
		<td>2000</td>
		<td>핫소스</td>
		<td>100</td>
	</tr>
	<tr>
		<td>치즈바이트</td>
		<td>3000</td>
		<td>파마산 치즈가루</td>
		<td>100</td>
	</tr>
</table>
<br>
<form method="get" action="<%= request.getContextPath() %>/order.me">
	피자: <select name="pizza">
			<option value="치즈피자">치즈피자</option>
			<option value="치즈피자">치즈피자</option>
			<option value="콤비이션피자">콤비네이션피자</option>
			<option value="포테이토피자">포테이토피자</option>
			<option value="고구마피자">고구마피자</option>
			<option value="불고기피자">불고기피자</option>
		</select>
	<br>
	토핑: <input type="checkbox" name="topping" value="고구마무스">고구마무스
		 <input type="checkbox" name="topping" value="콘크림무스">콘크림무스
		 <input type="checkbox" name="topping" value="파인애플토핑">파인애플토핑
		 <input type="checkbox" name="topping" value="치즈토핑">치즈토핑
		 <input type="checkbox" name="topping" value="치즈크러스트">치즈크러스트
		 <input type="checkbox" name="topping" value="치즈바이트">치즈바이트
	<br>
	사이드: <input type="checkbox" name="side" value="오븐구이통닭">오븐구이통닭
		  <input type="checkbox" name="side" value="치킨스틱&윙">치킨스틱&윙
		  <input type="checkbox" name="side" value="치즈오븐스파게티">치즈오븐스파게티
		  <input type="checkbox" name="side" value="새우링&웨지감자">새우링&웨지감자
		  <input type="checkbox" name="side" value="갈릭포테이토">갈릭포테이토
		  <input type="checkbox" name="side" value="콜라">콜라
		  <input type="checkbox" name="side" value="사이다">사이다
		  <input type="checkbox" name="side" value="갈릭소스">갈릭소스
		  <input type="checkbox" name="side" value="피클">피클
		  <input type="checkbox" name="side" value="핫소스">핫소스
		  <input type="checkbox" name="side" value="파마산 치즈가루">파마산 치즈가루
	<br>
	<button type="submit">확인</button>
</form>

</body>
</html>