package com.kh.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order.me")
public class Order extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pizza = req.getParameter("pizza");
		String[] toppings = req.getParameterValues("topping");
		String[] sides = req.getParameterValues("side");
		
		//받아온 값 확인
		System.out.println(pizza);
		for(String topping : toppings) {
			System.out.println(topping);
		}
		for(String side : sides) {
			System.out.println(side);
		}
		
		req.setAttribute("pizza", pizza);
		req.setAttribute("toppings", toppings);
		req.setAttribute("sides", sides);
		
		RequestDispatcher view = req.getRequestDispatcher("order.jsp");
		view.forward(req, resp);
	}
	
}
