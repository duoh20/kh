package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Member;

public class MemberDAO {
	
	private Properties prop = null;
	
	public MemberDAO() {
		prop = new Properties();
		try {
			prop.load(new FileReader("query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(Connection conn, Member mem) {
		
		/*
	 	이전 프로젝트에서 DAO가 맡은 업무
	 		1) JDBC드라이버 등록
	 		2) DB연결(Connection 객체 생성)
	 		3) SQL 전송
	 		4) 처리 결과에 따른 트랜잭션 처리(commit, rollback)
	 		5) 자원 반납
	 		
	 	실제 DAO가 해야하는 역할은 3번 뿐 ==> 쿼리 전송 후 반환 값 받아오기
	 	1, 2, 4, 5번의 경우 어디서든 공통적으로 이루어지기 때문에 한 번에 묶어서 실행 ==> JDBCTemplate 클래스
	 	
		 */
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPwd());
			pstmt.setString(3, mem.getMemberName());
			pstmt.setString(4, mem.getGender() + ""); //gender가 char니까 ""를 붙여 String으로 바꿔주었
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getPhone());
			pstmt.setString(7, mem.getAddress());
			pstmt.setInt(8, mem.getAge());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt); //Connection은 받아온 것이기 때문에 안닫아줘도 됨
		}
		
		return result;
	}

	public ArrayList<Member> seletAll(Connection conn) {

		// DAO는 쿼리 전송 역할을함 :SELECT * FROM MEMBER 모든 정보 조회)
		
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		
		String query = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement(); //완성형 쿼리이므로 Statement 실행
			rset = stmt.executeQuery(query); //실행한 쿼리를 리절트셋에 담음
			
			list = new ArrayList<Member>();
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String memberPwd = rset.getString("member_pwd");
				String memberName = rset.getString("member_name");
				char gender = rset.getString("gender").charAt(0);
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				int age = rset.getInt("age");
				String address = rset.getString("address");
				Date enrollDate = rset.getDate("enroll_date");
				
				Member member = new Member(memberId, memberPwd, memberName, gender,
										   email, phone, age, address, enrollDate);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public ArrayList<Member> selectMemberId(Connection conn, String id) {
		//tatement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		String query = prop.getProperty("selectMemberId");
		

		
		try {
			//stmt = conn.createStatement();
			//query += " '%" + id + "%'"; //프로퍼티 파일에 작성한 쿼리 완성 방법
			//	//properties 파일에 WHERE절의 LIKE까지 작성하고, 이 이후 부분은 query에다 완성시킴
			//rset = stmt.executeQuery(query);
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setNString(1,  "%" + id + "%");
			// "%" + id + "%" 이렇게 작성하면 자동으로 작은 따옴표가 붙음 '"%" + id + "%"'
			rset = pstmt.executeQuery();
			
			while(rset.next() ) {
				String memberId = rset.getString("member_id");
				String memberPwd = rset.getString("member_pwd");
				String memberName = rset.getString("member_name");
				char gender = rset.getString("gender").charAt(0);
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				int age = rset.getInt("age");
				String address = rset.getString("address");
				Date enrollDate = rset.getDate("enroll_date");
				
				Member member = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address, enrollDate);
				list.add(member);
;			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			//close(stmt);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> selectGender(Connection conn, char gender) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		String query = prop.getProperty("gender");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gender + "");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String memberPwd = rset.getString("member_pwd");
				String memberName = rset.getString("member_name");
				char gen = rset.getString("gender").charAt(0);
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				int age = rset.getInt("age");
				String address = rset.getString("address");
				Date enrollDate = rset.getDate("enroll_Date");
				
				Member member = new Member(memberId, memberPwd, memberName, gen, email, phone, age, address, enrollDate);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int checkMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		//1)정보까지 가져오기: SELECT * FROM MEMBER WHERE MEMBER_ID = ? ==> Member 객체 반환
		//2)해당 값이 존재하는지, 몇명인지만 조회: SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ? ==> int 반환
		
		String query = prop.getProperty("checkMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1); //여기서 1은 첫번째 컬럼을 뜻함
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int updateMember(Connection conn, String input, int sel, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMember" + sel);
		/*
			input   : 수정할 값
			sel	    : 어떤 것에 대해 바꿀지 (1.비밀번호/2.이메일/3.전화번호/4.주소)
				1)UPDATE MEMBER SET MEMBER_PWD = ? WHERE MEMBER_ID = ?
				2)UPDATE MEMBER SET EMAIL = ? WHERE MEMBER_ID = ?
				3)UPDATE MEMBER SET PHONE = ? WHERE MEMBER_ID = ?
				4)UPDATE MEMBER SET ADDRESS = ? WHERE MEMBER_ID = ?
				** 주의! 컬럼을 위치홀더로 대체하면 리터럴로 인식되어 에러가 발생한다
			memberId: 누구를 바꿀지
		 */
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, input);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
