package member.model.DAO;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import member.model.exception.MemberException;
import member.model.vo.Member;

public class MemberDAO {

	public Member selectMember(SqlSession session, Member m) throws MemberException {
		//session.selectOne(String arg0);
		//session.selectOne(String arg0, Object arg1);
		//String arg0 = 첫 번째 매개변수: 어떤 쿼리에 연결할지 지정
		//Object arg1 = 두 번째 매개변수: 쿼리에 전달할 값
		//							  여러 타입의 객체를 전달하고 싶다면 HashMap으로 전달
		//HashMap<String, Object> map = new HashMap<String, Object>();
		//map.put("string", str);
		//map.put("member", member);
		//map.put("int", int);
		Member member = session.selectOne("memberMapper.loginMember", m);
		
		if(member == null) {
			//예외가 발생하면 비정상 종료가 되면서 예외처리를 위임한 곳에서 예외 처리를 함
			//이 예제에서 예외가 발생하면 해당 처리는 Servlet까지 위임될 예정이기 때문에
			//예외가 발생할 경우 Service의 session.close()에 닿을 수 없어 자원 회수가 불가능하다.
			//따라서 DAO에서 session.close()해준다.
			session.close();
			//throw 현재 메서드 혹은 상위 메서드에 예외를 강제로 발생시킴
			//throws 자신을 호출한 상위 메서드에 예외를 발생시킴
			throw new MemberException("로그인에 실패했습니다.");
		}
		
		return member;
	}

	public void insertMember(SqlSession session, Member m) throws MemberException {
		int result = session.insert("memberMapper.insertMember", m);
		
		if(result<= 0) {
			session.rollback();
			session.close();
			throw new MemberException("회원가입에 실패하였습니다.");
		}
	}

	public void pwdUpdate(SqlSession session, HashMap<String, String> map) throws MemberException {
		int result = session.update("memberMapper.pwdUpdate", map);
		
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new MemberException("비밀번호 수정에 실패했습니다.");
		}
	}

	public void deleteMember(SqlSession session, String userId) throws MemberException {
		int result = session.update("memberMapper.deleteMember", userId);
		
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new MemberException("회원 탈퇴에 실패했습니다.");
		}
	}

	public void updateMember(SqlSession session, Member m) throws MemberException {
		int result = session.update("memberMapper.updateMember",m);
		
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new MemberException("정보 수정에 실패했습니다.");
		}
	}
}
