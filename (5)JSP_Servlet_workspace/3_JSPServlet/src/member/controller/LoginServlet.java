package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;


@WebServlet(urlPatterns="/login.me", name="LoginServlet") //어노테이션 방식으로 서블릿 연결
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member member = new Member(userId, userPwd);
		//로그인을 시도한 멤버의 ID와 비밀번호를 member 객체에 담음


		Member loginUser = new MemberService().loginMember(member);
		//로그인 성공한 유저의 모든 정보를 담은 변수 loginUser 생성 
		if(loginUser != null) { //로그인을 성공한 사람이 있을 때,
			
			//로그인한 정보는 request에 담으면 안된다, 한 번 요청으로 사라지기 때문임.
			//로그인 정보는 session 객체에 담아야한다.
			HttpSession session = request.getSession();
			
			//db에서 가져온 loginUser를 "loginUser" 변수에 담는다.
			session.setAttribute("loginUser", loginUser);
			//세션은 일정 시간이 지나면 만료한다. 기본 유효 시간은 30분이다.
			session.setMaxInactiveInterval(10000); //10분 동안 유효할 수 있도록 설정
			
			/*
			  Q: 화면을 넘겨줄 때, RequestDispatcher.forward()를 써야할까,
			  HttpServletResponse.sendRedirect()를 써야할까?
			 
			  A: 둘 다 사용 가능
			  데이터가 session에 담겨있기 때문에 session이 만료하기 전에는 데이터가 남아있다.
			  따라서 어떤 방식으로 페이지를 넘겨도 상관 없다. 
			 */
			//response.sendRedirect("index.jsp"); //메인으로 돌아가면되서 req 객체를 사용한다.
			response.sendRedirect(request.getContextPath());
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			//sendRedirect()는 URL을 재작성함.
			//request.getRequestDispatcher도 사용 가능하지만, 로그인 시 값이 전송되는 것을 보여주지 않도록 sendRedirect를 사용
		} else { //로그인을 성공하지 못했을 때,
			request.setAttribute("msg", "로그인 실패");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
