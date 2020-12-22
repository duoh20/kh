package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.exception.MemberException;
import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		try {
			Member member = new MemberService().selectMember(m);
			
			//로그인 정보를 저장하기 위해 session 설정
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
			session.setMaxInactiveInterval(600); //10분간 세션 유지하도록 설정
			
			response.sendRedirect(request.getContextPath());
		} catch (MemberException e) {
			request.setAttribute("message", e);
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}