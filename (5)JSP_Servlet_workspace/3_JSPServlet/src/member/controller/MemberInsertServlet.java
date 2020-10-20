package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;


@WebServlet("/insert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInsertServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("joinUserId");
		String userPwd = request.getParameter("joinUserPwd");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] irr = request.getParameterValues("interest");
		String interest = "";
		if(irr != null) {
			for(int i = 0; i < irr.length; i++) {
				if(i == irr.length -1)
					interest += irr[i];
				else
					interest += irr[i] + ",";
			}
		}
		//String interest = String.join(", ", irr);
		
		Member member = new Member(userId, userPwd, userName, nickName, phone, email, address, interest);
		
		int result = new MemberService().insertMember(member);
		//DML이므로 반환값은 int

		if(result > 0) {
			//request.setAttribute("msg", "회원 가입에 성공했습니다.");
			//request.getRequestDispatcher(request.getContextPath()).forward(request, response);
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("msg", "회원가입에 실패했습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
