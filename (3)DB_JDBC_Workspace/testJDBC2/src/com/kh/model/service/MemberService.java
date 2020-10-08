package com.kh.model.service;

import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.rollback;
import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberService {
	//DAO를 호출하여 데이터 접근/갱신
	//트랜잭션 처리
	
	//Controller로부터 인자 전달 받음
	//Connection객체 생성
	//DAO 객체 생성
	//DAO에 Connection 객체, 인자 전달,
	//DAO 수행 결과를 가지고 비즈니스 로직 및 트랜잭션 관리
	
	public int insertMember(Member mem) {
		
		Connection conn = getConnection();
		//static 메소드는 생성자 생성 없이 가져올 수 있음:Connection conn = JDBCTemplate.getConnection();
		//단, 클래스 이름 붙이지 않고 메소드를 가져오려면 클래스명 상단에 import static으로 기술해준다
		
		MemberDAO mDAO = new MemberDAO();
		
		int result = mDAO.insertMember(conn, mem);
		//왜 insertMember 메소드에 conn을 전달해주나?
		//커넥션에서 쿼리를 보내는 객체 생성을 담당하고 있어서 conn을 보내주지 않으면 쿼리를 생성할 수 없다,.
		//따라서 DAO애 전달해줘야 한다.
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public ArrayList<Member> selectAll() {
		Connection conn = getConnection();
		
		MemberDAO mDAO = new MemberDAO();
		ArrayList<Member> list= mDAO.seletAll(conn); //DAO에커넥션과 인자 전달, 단 여기선 전달할 인자가 없으므로 conn만 전달 
		
		return list;
	}
	
	public ArrayList<Member> selectMember(String id) {
		Connection conn = getConnection();
		
		MemberDAO mDAO = new MemberDAO();
		
		ArrayList<Member> list = mDAO.selectMemberId(conn, id);
		
		return list;
	}

	public ArrayList<Member> selectMember(char gender) {
		Connection conn = getConnection();
		
		MemberDAO mDAO = new MemberDAO();
		
		ArrayList<Member> list = mDAO.selectGender(conn, gender);
		
		return list;
	}

	public int checkMember(String memberId) {
		Connection conn = getConnection();
		MemberDAO mDAO = new MemberDAO();
		int result = mDAO.checkMember(conn, memberId);
		
		return result;
	}

	public int updateMember(String input, int sel, String memberId) {
		Connection conn = getConnection();
		MemberDAO mDAO = new MemberDAO();
		int result = mDAO.updateMember(conn, input, sel, memberId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		
		MemberDAO mDAO = new MemberDAO();
		int result = mDAO.deleteMember(conn, memberId);
		
		if(result != 1) {
			rollback(conn);
		} else {
			commit(conn);
		}
		return result;
	}

	public void exitProgram() {
		Connection conn = getConnection(); //static 만들어진 커넥션 객체를 불러와 종료시
		close(conn);
	}
}
