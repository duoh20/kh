package action.summary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.model.vo.Person;

@WebServlet("/handler.do")
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SummaryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//이름, 나이, 성별, 뷰 받아오기
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		char gender = request.getParameter("gender").charAt(0);
		String view = request.getParameter("view");
		
		//Person(이름, 나이 성별) person 생성
		Person person = new Person(name, gender, age);
		
		//request 영역에 person 담기
		request.setAttribute("person", person);
		
		//뷰 전송(view)
		request.getRequestDispatcher("03_summary/" + view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
