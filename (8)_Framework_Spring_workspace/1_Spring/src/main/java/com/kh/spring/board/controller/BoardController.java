package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.exception.BoardException;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.PageInfo;
import com.kh.spring.common.Pagination;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	@Autowired
	private MultipartResolver multipartResolver;
	
	@RequestMapping("blist.bo")
	public ModelAndView boardList(@RequestParam(value="page", required=false) Integer page, ModelAndView mv) {
		//Integer로 받아오는 이유,currentPage가 없으면 null, 있으면 숫자로 받아옴
		// 만약 기본 자료형 int null이 없고 기본값인 0으로 받아오는데,
		// url에서 page 파라미터를 조작할 수 있고, null값이 허용되지 않음
		// 따라서 레퍼런스 클래스인 Integer로 page를 받아옴
		// 하지만 처음 board에 들어오면 파라미터에 page가 존재하지 않아 404 에러가 발생함
		// url에 파라미터가 존재하지 않을 수도 있음을 required=false를 넣어 명시해야한다

		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int listCount = bService.getListCount();
		
		PageInfo pi = Pagination.getPageInfo(currentPage,  listCount);
		
		ArrayList<Board> list = bService.selectList(pi);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("boardListView");
		} else {
			throw new BoardException("게시글 전체 조회에 실패했습니다.");
		}
		return mv;
	}
	
	@RequestMapping("binsertView.bo")
	public String boardInsertView() {
		return "boardInsertForm";
	}
	
	@RequestMapping("binsert.bo")
	public String boardInsert(@ModelAttribute Board b, @RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request) {
		// view에서 uploadFile 파미터로 보낸 input의 타입이 type="file"이므로 이를 받아줄 MultipartFile 객체를 사용해야함
		// 첨부 파일이 있고 없고는 MulipartFile 객체가 null이냐 아니냐로 따지는 게 아니라,
		// MultipartFile 안에 있는 메소드 getOriginalFileName()로 판별 가
		// 첨부 파일이 있을 때 : 파일 실제 이름
		// 첨부 파일이 없을 때 : (공백)
		
		if(uploadFile != null && !uploadFile.isEmpty()) { //첨부 파일이 있다면
			String renameFileName = saveFile(uploadFile, request);
			
			if(renameFileName != null) {
				b.setRenameFileName(renameFileName);
				b.setOriginalFileName(uploadFile.getOriginalFilename());
			}
		}
		
		int result = bService.insertBoard(b);
		
		if(result > 0) {
			return "redirect:blist.bo";
		} else {
			throw new BoardException("게시글 등록에 실패했습니다.");
		}
	}
	
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		//웹 서버 contextPath를 불러와 폴더의 경로를 받아옴 (여기서 resources 폴더는 webapp 하위의 것을 말함)
		
		String savePath = root + "\\buploadFiles";
		//이스케이프 문자 \를 붙이면 원래 문자로 인식
		
		//savePath에 buploadFile 폴더가 없을 경우 폴더를 만들게 함
		File folder = new File(savePath);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "." + originFileName.substring(originFileName.lastIndexOf(".") + 1);
		
		String renamePath = folder + "\\" + renameFileName;
		
		try {
			file.transferTo(new File(renamePath));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		//업로드된 파일을 폴더에 저장까지 완료한 후 DB에 저장할 파일 이름을 리턴함
		return renameFileName;
	}
	
}
