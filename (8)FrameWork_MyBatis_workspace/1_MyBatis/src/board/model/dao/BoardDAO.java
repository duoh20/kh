package board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import board.model.exception.BoardException;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import board.model.vo.SearchCondition;

public class BoardDAO {

	public int getListCount(SqlSession session) throws BoardException {
		
		int listCount = session.selectOne("boardMapper.listCount");
		
		if(listCount <= 0) {
			session.close();
			throw new BoardException("게시물 조회에 실패했습니다.");
		}
		return listCount;
	}

	public ArrayList<Board> selectBoardList(SqlSession session, PageInfo pi) throws BoardException {
		
		/* 몇 개의 게시글을 건너 뛰어야하는지 계산 */
		//한 페이지에 5개의 글을 보여준다 가정하면,
		// 1page --> 0 = (1-1)*5
		// 2page --> 5 = (2-1)*5
		// 3page --> 10 = (3-1)*5
		// 4page --> 15 = (4-1)*5
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		//RowBounds는 mybatis에서 제공하는 페이징 메서드
		//offset만큼의 게시글을 건너뛴 후 pi.getBoardLimit()만큼의 글을 가져옴
		
		//페이징 처리 시 매개변수 3개인 selectList 사용
		ArrayList<Board> list = (ArrayList)session.selectList("boardMapper.selectBoardList", null, rowBounds);
		
		if(list == null) {
			session.close();
			throw new BoardException("게시글 조회에 실패했습니다.");
		}
		
		return list;
	}

	public int updateCount(SqlSession session, int bId) throws BoardException {
		int result = session.update("boardMapper.updateBoardCount", bId);
		
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new BoardException("게시판 증가에 실패했습니다.");
		}
		
		return result;
	}
	
	public Board selectBoardDetail(SqlSession session, int bId) throws BoardException {
		Board board = session.selectOne("boardMapper.selectBoardDetail", bId);
		
		if(board == null) {
			session.rollback();
			session.close();
			throw new BoardException("게시판 상세 조회에 실패했습니다.");
		}
		return board;
	}

	public int getSearchResultListCont(SqlSession session, SearchCondition sc) throws BoardException {
		int listCount = session.selectOne("boardMapper.selectSearchResultCount", sc);
		
		if(listCount <= 0) {
			session.close();
			throw new BoardException("검색 결과의 카운트 조회에 실패했습니다.");
		}
		return listCount;
	}

	public ArrayList<Board> selectSearchResultList(SqlSession session, SearchCondition sc, PageInfo pi) throws BoardException {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		
		RowBounds rowbounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Board> li = (ArrayList)session.selectList("boardMapper.selectSearchResultList", sc, rowbounds);

		if(li == null) {
		 session.close();
		 throw new BoardException("게시판 목록을 가져오는데 실패했습니다.");
		}
		
		return li;
	}
}
