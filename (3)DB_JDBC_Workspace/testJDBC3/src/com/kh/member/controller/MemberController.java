package com.kh.member.controller;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.view.View;

public class MemberController {

	MemberService mService = new MemberService();
	View view = new View();
	
	public void login(Member mem) {
		mem = view.inputLogin();
		
		mService.inputLogin(mem);
	}
}
