package common;

import board.model.vo.PageInfo;

public class Pagination {
	// 이 클래스는 페이징 정보를 계산하는 클래스이다.
	// 계산한 페이지 정보들은 PageInfo에 담아 전송한다.
	public static PageInfo getPageInfo(int currentPage, int listCount) {
		PageInfo pi = null;
		int pageLimit = 10;
		int maxPage;
		int startPage;
		int endPage;
		int boardLimit = 5;
		
		//전체 페이지는 listCoun에서 boardLimit를 나눈 값
		//나머지가 있어도 1페이지를 차지하므로 올림하여 표시
		//Math.ceil의 반환값이 double이라 int로 형변환
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1)/ pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		return pi;
	}
}
