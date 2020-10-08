package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet3 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String city = req.getParameter("city");
		String height = req.getParameter("height");
		String[] foods = req.getParameterValues("food");
		
		String recommendation = "";
		switch(age) {
		case "10대 미만": recommendation = "인형"; break;
		case "10대": recommendation = "스마트폰"; break;
		case "20대": recommendation = "돈"; break;
		case "30대": recommendation = "집"; break;
		case "40대": recommendation = "여행"; break;
		case "50대": recommendation = "건강"; break;
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
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
		out.printf("키 <span class='height'>%s</sapn>cm인 ", height);
		out.printf("<span class='gender'>%s</sapn>입니다.", gender);
		out.println("좋아하는 음식은 <span class='food'>");
		for(int i =0; i < foods.length; i++) {
			if(i == 0) {
				out.printf("%s", foods[i]);
			} else {
				out.printf(", %s", foods[i]);
			}
		}
		out.println("</span>입니다.");
		out.println("<hr>");
		out.println("<h3>" + age + "에 맞는 선물 추천</h3>");
		out.println("'" + recommendation + "' 선물은 어떠신가요?");
		out.println("</body>");
		out.println("</html>");
	}
}
