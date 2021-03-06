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

@WebServlet("/info.me")
public class MemberInfoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInfoFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		
		try {
			member = new MemberService().selectMember(member);
			request.setAttribute("loginUser", member);
			request.getRequestDispatcher("WEB-INF/views/member/memberInfo.jsp").forward(request, response);
		} catch (MemberException e) {
			request.setAttribute("message", e);
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
