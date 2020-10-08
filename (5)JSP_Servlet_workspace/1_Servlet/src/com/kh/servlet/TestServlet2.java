package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet2 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이름, 성별, 나이, 사는 곳, 키, 좋아하는 음식을 console에 출력해보기
		
		//값을 넘겨 받기 전부터 encoding 구문을 실행해야 암호화하지 않은 텍스트를 받아올 수 있다
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] foods = request.getParameterValues("food");
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("name : " + age);
		System.out.println(city);
		System.out.println(height);
		for(int i = 0; i < foods.length; i++) {
			if(i == 0) {
				System.out.print("좋아하는 음식 : " + foods[i]);
			} else {
				System.out.println(", " + foods[i]);
			}
		}
		
		response.setContentType("text/html; charset=UTF-8");
		//IO 객체를 이용해 화면에 내용 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인 정보 출력 화면</title>");
		out.println("<Style>");
		out.println("h2{color: red;}");
		out.println("span.name{color: orange; font-weight: bold;}");
		out.println("span.gender{color: yellow; font-weight: bold; background: black;}");
		out.println("span.age{color: green; font-weight: bold;}");
		out.println("span.city{color: blue; font-weight: bold;}");
		out.println("span.height{color: navy; font-weight: bold;}");
		out.println("span.food{color: purple; font-weight: bold;}");
		out.println("</style>");
		out.println("<body>");
		out.printf("<span class='name'>%s</sapn>님은 ", name);
		out.printf("<span class='age'>%s</sapn>이시며 ", age);
		out.printf("<span class='city'>%s</sapn>에 사는 ", city);
		out.printf("<span class='height'>%s</sapn>cm인 ", height);
		out.printf("<span class='gender'>%s</sapn>입니다. ", gender);
		out.println("좋아하는 음식은 <span class='food'>");
		for(int i =0; i < foods.length; i++) {
			if(i == 0) {
				out.printf("%s", foods[i]);
			} else {
				out.printf(", %s", foods[i]);
			}
		}
		out.println("</span> 입니다.");
		out.println("</body>");
		out.println("</html>");
	    
	}
}
