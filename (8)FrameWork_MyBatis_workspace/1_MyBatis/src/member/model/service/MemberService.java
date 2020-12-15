package member.model.service;

import static common.Template.getSqlSession;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import member.model.DAO.MemberDAO;
import member.model.exception.MemberException;
import member.model.vo.Member;

public class MemberService {

	public Member selectMember(Member m) throws MemberException {
		SqlSession session = getSqlSession();
		Member member = new MemberDAO().selectMember(session, m);
		
		session.close();
		//받아온 member가 null일 때 예외처리는 Servlet에서 처리함
		
		return member;
	}

	public void insertMemebr(Member m) throws MemberException {
		SqlSession session = getSqlSession();
		new MemberDAO().insertMember(session, m);
		
		session.commit();
		session.close();
	}
	
	public void pwdUpdate(HashMap<String, String> map) throws MemberException {
		SqlSession session = getSqlSession();
		new MemberDAO().pwdUpdate(session, map);
		
		session.commit();
		session.close();
	}

	public void deleteMember(String userId) throws MemberException {
		SqlSession session = getSqlSession();
		new MemberDAO().deleteMember(session, userId);
		
		session.commit();
		session.close();
	}

	public void updateMember(Member m) throws MemberException {
		SqlSession session = getSqlSession();
		new MemberDAO().updateMember(session, m);
		
		session.commit();
		session.close();
	}

}
