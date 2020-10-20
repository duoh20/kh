package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	
	//DAO의 역할: 쿼리(SQL)를 전송하는 역할만 담당하게 함
	//Service의 역할: DAO 호출, 트랜젝션처리, Connection 객체 생성, controller인자 전달 받음, 자원 반납
	//Connection을 객체를 보다 편하게 받아올 수 있도록 JDBCTempate 클래스를 생성하고, 메소드를 import static 한다.
	
	public Member loginMember(Member member) {
		Connection conn = getConnection();
		MemberDAO mDAO = new MemberDAO();
		
		Member loginUser = mDAO.loginMember(conn, member);
		close(conn);
		
		return loginUser;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertMember(conn, member);
		

		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int checkId(String userId) {
		Connection conn = getConnection();
		int result = new MemberDAO().checkId(conn, userId);
		
		close(conn); //갱신한 내용이 없으므로 commit이나 rollback할 필요 없음
		
		return result;
	}

	public Member selectMember(String loginUserId) {
		Connection conn = getConnection();
		Member member = new MemberDAO().selectMember(conn, loginUserId);
		close(conn);
		return member;
	}

	public int updateMember(Member myInfo) {
		Connection conn = getConnection();
		int result = new MemberDAO().updateMember(conn, myInfo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteMember(String userId) {
		Connection conn = getConnection();
		int result = 0;
		
		result = new MemberDAO().deleteMember(conn, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int checkNickName(String nickName) {
		
		Connection conn = getConnection();
		int result = new MemberDAO().checkNickName(conn, nickName);
		
		close(conn);
		
		return result;
	}
}
