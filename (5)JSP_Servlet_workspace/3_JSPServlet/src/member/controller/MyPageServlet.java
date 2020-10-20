package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;


@WebServlet("/myPage.me")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyPageServlet(){}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//이미 로그인 되어있다는 전제 하에 진행하므로 세션에서 로그인한 맴버 정보에게서 아이디를 가져온다.
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		String loginUserId = loginUser.getUserId();
		
		Member member = new MemberService().selectMember(loginUserId);
		
		String page = null;
		
		if(member != null) {
			page = "WEB-INF/views/member/mypage.jsp";
			request.setAttribute("member", member);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 조회에 실패했습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
