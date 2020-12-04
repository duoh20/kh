package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

@WebServlet("/insert.th")
public class ThumbnailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThumbnailInsertServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//String title = request.getParameter("title");
		//System.out.println(title);
		//작성한 제목을 받아오지 못하고 null 출력
		//파일 데이터를 받아오려면 페이지의 form 속성에 encType을 추가해줘야한다.
		//encodingType이 multipart/form-data으로 설정하면 request.getParameter로 값을 받아올 수 없음
		//cos.jar 추가 후 진행 <== 파일도 받고 다른 값들도 받아주는 역할 (http://www.servlets.com/)
	
		//encType이 multipart/form-data로 전송되었는지 확인
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10; //10Mbyte로 전송 파일 용량 제한, MB 계산 공식
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "thumbnail_uploadFiles/"; //저장한 사진 파일을 관리할 경로 선언
			
			//System.out.println(savePath);
			
			//사진을 저장할 thumbnail_uploadFiles 디렉토리가 존재하지 않을 경우, File io를 사용해 파일 생성
			File f = new File(savePath);
			if(!f.exists()) {
				f.mkdirs();
			}
			
			/*
			 Q: 다른 파일 명을 따로 생성하는 이유?
				1) 같은 파일 명이 있을 때 덮어 씌어짐 방지
				2) 특수문자 있을 경우 에러 발생 방지
				3) 파일 추적에 용이
			*/
			
			//MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			//	DefaultFileRenamePolicy : 같은 파일 명이 존재하는지 검사하고 있을 경우 파일 명 뒤에 숫자를 붙여 구분
			//		예시) aaa.zip		aaa1.zip	aaa2.zip
			// FileRenamePolicy을 extends하여 클래스를 생성하여 사용자 정의도 가능
			
			/* 파일 받아오기 */
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String bWriter = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
			System.out.println(title + "," + content);
			
			ArrayList<String> saveFiles = new ArrayList<String>(); //바뀐 파일 이름을 저장할 ArrayList
			ArrayList<String> originFiles = new ArrayList<String>(); //원본 파일 이름을 저장할 ArrayList
		
			Enumeration<String> files = multiRequest.getFileNames(); //폼에서 전송된 파일 리스트의 이름을 Enumeration에 담아서 반환, iterator와 같음
			
			while(files.hasMoreElements()) {
				// !!전송 순서 역순으로 가져옴!! abc로 전송하면 cba순서로 가져옴
				String name = files.nextElement();
				
				if(multiRequest.getFilesystemName(name) != null) { //MyRenamePolicy의 rename 메소드에서 작성한대로 rename된 파일명이 null이 아닐 때,
					saveFiles.add(multiRequest.getFilesystemName(name)); //바뀐 파일명 가져옴
					originFiles.add(multiRequest.getOriginalFileName(name)); //원본 파일명 가져옴
				}
			}
			
			Board b = new Board();
			b.setBoardTitle(title);
			b.setBoardContent(content);
			b.setBoardWriter(bWriter);
			b.setBoardType(2);
			b.setCategory("10");
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			for(int i = originFiles.size() - 1; i >= 0; i--) { //역순으로 for문 실행
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
			
				if(i == originFiles.size() - 1) {
					at.setFilelLevel(0);
					//썸네일은 마지막에 들어옴, 마지막 파일에 레벨을 0으로 설정하여 썸네일임을 구분
				} else {
					at.setFilelLevel(1);
					//썸네일 외 나머지 파일에는 파일 레벨을 1로 설정
				}
				
				fileList.add(at);
			}
			
			System.out.println(b);
			System.out.println(fileList);
			
			int result = new BoardService().insertThumbnail(b, fileList);
			
			if(result > 0) {
				response.sendRedirect("list.th");
			} else {
				for(int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(savePath + saveFiles.get(i));
					failedFile.delete();
				} 
				
				request.setAttribute("msg", "사진 게시판 등록에 실패했습니다.");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
