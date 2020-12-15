package member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.exception.MemberException;
import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/mupdate.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		String userId = member.getUserId();
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		
		int year =Integer.parseInt(request.getParameter("year"));
		int month =Integer.parseInt(request.getParameter("month"));
		int date =Integer.parseInt(request.getParameter("date"));
		Date birthDay = new Date(new GregorianCalendar(year, month-1, date).getTimeInMillis());
		
		Member m = new Member(userId, null, userName,  nickName,  email, birthDay, gender, phone,  address);
		
		try {
			MemberService service = new MemberService();
			service.updateMember(m);
			
			//session의 이전 유저 정보 업데이트
			m = service.selectMember(member);
			session.setAttribute("loginUser", m);
			response.sendRedirect(request.getContextPath() + "/info.me");
		} catch (MemberException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
