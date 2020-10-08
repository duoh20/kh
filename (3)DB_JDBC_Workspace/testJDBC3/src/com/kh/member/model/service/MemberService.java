package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.getConnection;
import java.sql.Connection;

import com.kh.member.controller.MemberController;
import com.kh.member.model.dao.MemberDAO;
import com.kh.member.model.vo.Member;

public class MemberService {
	
	MemberController mc = new MemberController();
	MemberDAO mDAO = new MemberDAO();

	public void inputLogin(Member mem) {
		Connection conn = getConnection();
		int Result = mDAO.inputLogin(conn, mem);
	}

}
