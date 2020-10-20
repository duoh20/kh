package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

@WebServlet("/checkNickName.me")
public class CheckNickNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckNickNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String nickName = request.getParameter("inputNickName");
		System.out.println(nickName);
		
		int result = new MemberService().checkNickName(nickName);
		System.out.println(result);
		
		request.setAttribute("result", result);
		request.setAttribute("checkedNickName", nickName);
		
		request.getRequestDispatcher("WEB-INF/views/member/checkNickNameForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}