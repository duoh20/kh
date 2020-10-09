package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testServlet1.do")
public class TestServlet1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doGet 메소드 실행");
		//servlet이 연결되었는지 확인
		
		/* 화면에서 보낸 값을 받아오기 */
		//request안의 getParameter(String)으로 받아
		//javax.servlet.http.HttpServletRequest.getParameter(name:String):String //반환 값이 String
		//매개변수의 name은 input에 정의한 name 속성의 값
		
		//testServlet1에 만든 form 태그의 값 받아오기
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		//String food = request.getParameter("food"); //값이 여러 개인 경우, 한 개만 불러옴
		String[] foods = request.getParameterValues("food"); //여러 개의 값을 String[]로 반환
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		for (String food : foods) {
			System.out.println("food : " + food);
		}
		
		//입력 받은 값을 가지고 html 화면 조작하기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인정보 출력 화면</title>");
		out.println("<style>");
		out.println("h2{color: red;}");
		out.println("span.name{color: orange; font-weight: blod;}");
		out.println("span.gender{color: yellow; font-weight: blod; background-color: black;}");
		out.println("span.age{color: green; font-weight: blod;}");
		out.println("span.city{color: blue; font-weight: blod;}");
		out.println("span.height{color: navy; font-weight: blod;}");
		out.println("span.foods{color: purple; font-weight: blod;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인 취향 테스트 결과(GET)</h2>");
		out.printf("<span class='name'>%s</span>님은 ", name);
		out.printf("<span class='age'>%s</span>이시며, ", age);
		out.printf("<span class='city'>%s</span>에 사는 ", city);
		out.printf("<span class='height'>%s</span>cm인 ", height);
		out.printf("<span class='gender'>%s</span>입니다. ", gender);
		out.printf("좋아하는 음식은 <span class='food'>");
		for(int i = 0; i <foods.length; i++) {
			if(i == 0) {
				out.printf("%s", foods[i]);
			} else {
				out.printf(", %s", foods[i]);
			}
		}
		out.println("</span> 입니다. ");
		out.println("</body>");
		out.println("</html>");
	}
	
	
}
