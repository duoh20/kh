package action.el.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.model.vo.Person;

@WebServlet("/myEL.do")
public class MyElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyElServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		char gender = request.getParameter("gender").charAt(0);
		int age = Integer.parseInt(request.getParameter("age"));
		String beverage = request.getParameter("beverage");
		String[] products = request.getParameterValues("product");
		String book = request.getParameter("book");
		String movie = request.getParameter("movie");
		
		Person rosemary = new Person(name, gender, age);
		request.setAttribute("person", rosemary);
		request.setAttribute("beverage", beverage);
		request.setAttribute("year", 2020);
		request.setAttribute("products", products);
		
		HttpSession session = request.getSession();
		session.setAttribute("book", book);
		
		ServletContext application = request.getServletContext();
		application.setAttribute("movie", movie);
		
		request.setAttribute("beverage","아메리카노");
		session.setAttribute("beverage","우유");
		application.setAttribute("beverage","물");
		
		request.getRequestDispatcher("02_el/01_2_elEnd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
