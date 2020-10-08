package com.kh.member.model.dao;


import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

public class MemberDAO {

	MemberService mc = new MemberService();
	
	public int inputLogin(Connection conn, Member mem) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
				
		try {
			String query = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ?, MEMBER_PWD = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPwd());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

}
