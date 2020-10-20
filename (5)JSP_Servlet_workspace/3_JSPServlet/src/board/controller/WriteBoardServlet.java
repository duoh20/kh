package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import member.model.vo.Member;

@WebServlet("/insert.bo")
public class WriteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteBoardServlet() {}

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	
    	String category = request.getParameter("category");
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	
    	Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    	String writer = loginUser.getUserId();
    	
    	Board b = new Board();
    	b.setCategory(category);
    	b.setBoardTitle(title);
    	b.setBoardContent(content);
    	b.setBoardWriter(writer);
    	b.setBoardType(1);
    	
    	int result = new BoardService().insertBoard(b);
    	
    	if(result > 0) {
    		request.getRequestDispatcher("list.bo?currentPage=1").forward(request, response);
    	} else {
    		request.setAttribute("msg", "게시글 작성에 실패했습니다.");
    		request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
    	}

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
