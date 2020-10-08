package com.kh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet4 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("Utf-8");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String height = req.getParameter("height");
		String city = req.getParameter("city");
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
		
		//req.setAttribute(변수명name,해당변수에 담길 값(데이터)o);
		req.setAttribute("name", name);
		req.setAttribute("gender", gender);
		req.setAttribute("age", age);
		req.setAttribute("city", city);
		req.setAttribute("height", height);
		req.setAttribute("foods", foods);
		req.setAttribute("recommendation", recommendation);
		
		/*
		 	화면으로 제어권을 넘기는 방법은 2가지가 있다.
				1) RequestDispatcher.forward()
					- 화면에 전달할 값이 존재할 때 사용 (회원정보 조회, 게시판 리스트, 검색 등)
				2) HttpServletResponse.sendRedirect()
					- 화면에 전달할 값이 존재하지 않을 때 사용 (회원 탈퇴, 단순 화면 이동)
					- 새로운 request, response 객체 생성하기 때문 값이 전달되지 않음
				* WEB-INF 안에서 페이지 이동을 관리할 경우, server에서 a 태그로 이동이 되지 않기 때문에 사용
				  웹 콘텐츠 안에 관리하면 상관 없지만 회사마다 입장이 다르다.
		 */
		
		//이 예제에서는 전달할 값이 있으므로 RequestDispatcher를 사용
		RequestDispatcher view = req.getRequestDispatcher("servlet/testServlet4End.jsp");
		view.forward(req, resp);
	}
}
