package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/insert.no")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String userId = "admin"; //공지사항은 운영자만 작성 가능하므로 admin으로 고정
		String date = request.getParameter("date"); //getParameter()는 String을 반환하므로 String으로 받아서 Date 형으로 변환
		String content = request.getParameter("content");
		
		System.out.println(title);
		System.out.println(date);
		System.out.println(content);
		
		Date dat = null;
		if(!date.equals("")) { //날짜를 입력 안하면 빈 문자열을 반환함, 오늘 날짜로 설정해줌
			String[] dateArr = date.split("-");
			
			int year = Integer.parseInt(dateArr[0]);
			int month = Integer.parseInt(dateArr[1]) -1; //month는 0부터 시작하므로
			int day = Integer.parseInt(dateArr[2]);
			
			dat = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		} else {
			dat = new Date(new GregorianCalendar().getTimeInMillis());
		}
		
		//System.out.println(dat);
		
		Notice n = new Notice(title, content, userId, dat);
		int result =  new NoticeService().insertNotice(n);
		
		if(result > 0) {
			response.sendRedirect("list.no");
		} else {
			request.setAttribute("msg", "공지사항 등록에 실패했습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
