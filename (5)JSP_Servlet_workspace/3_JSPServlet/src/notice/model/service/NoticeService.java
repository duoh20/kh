package notice.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {

	public ArrayList<Notice> selectList() {
		Connection conn = getConnection();
		
		ArrayList<Notice> list =new NoticeDAO().selectList(conn);
		
		close(conn);
		
		return list;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		
		int result = new NoticeDAO().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Notice selectNotice(int no) {
		Connection conn = getConnection();

		NoticeDAO dao = new NoticeDAO();
		int result = dao.updateCount(conn, no);
		
		Notice n = null;
		
		if(result > 0) {
			n = dao.selectNotice(conn, no);
			
			if(n != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return n;
	}

}
