package com.kh.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.model.dao.MemberDAO;
import com.kh.model.service.MemberService;
import com.kh.view.MemberMenu;
import com.kh.model.vo.Member;

public class MemberController {
	MemberMenu menu = new MemberMenu();
	//MemberDAO mDAO = new MemberDAO();
	private MemberService mService = new MemberService();
	
	public void insertMember() {
		
		Member mem = menu.insertMember();
		
		int result = mService.insertMember(mem);
		
		if(result > 0) {
			menu.displaySuccess(result + "개 행을 추가했습니다.");
		} else {
			menu.displayError("추가 중 오류가 발생했습니다.");
		}
	}

	public void selectAll() {
		ArrayList<Member> list = mService.selectAll();
		
		if(list.isEmpty()) {
			menu.displayError("조회 결과가 없습니다.");
		} else {
			menu.displayMember(list);
		}
	}

	public void selectMember() {
		int sel = menu.selectMember();
		
		ArrayList<Member> list = null;
		
		switch(sel) {
		case 1:
			String id = menu.inputMemberId(); 
			list = mService.selectMember(id);
			break;
		case 2:
			char gender = menu.inputGender();
			list = mService.selectMember(gender);
			break;
		}
		
		if(!list.isEmpty()) {
			menu.displayMember(list);
		} else {
			menu.displayError("조회 결과가 없습니다.");
		}
	}

	public void updateMember() {
		String memberId = menu.inputMemberId();
		
		int check = mService.checkMember(memberId);
		
		if(check != 1) { //memberId는 중복되지 않아야하므로 에러처리
			menu.displayError("입력한 아이디가 존재하지 않습니다.");
		} else {
			int sel = menu.updateMember();
			
			if(sel == 0) return;
			
			String input = menu.inputUpdate();
			int result = mService.updateMember(input, sel, memberId); //input:바꿀값, sel:수정할 항목, memberId:바꿀 맴
			
			if(result > 0) {
				menu.displaySuccess(result + "개 행을 수정했습니다.");
			} else {
				menu.displayError("데이터 수정 과정 중 오류 발생");
			}
		}
	}

	public void deleteMember() {
		String memberId = menu.inputMemberId();
		int check = mService.checkMember(memberId);
		
		if(check != 1) {
			menu.displayError("입력한 아이디가 존재하지 않습니다.");
		} else {
			char yn = menu.checkDelete();
			
			if(yn != 'Y') {
				return;
			} else {
				int result = mService.deleteMember(memberId);
				
				if(result > 0) {
					menu.displaySuccess(result + "개 행을 삭제했습니다.");
				} else {
					menu.displayError("데이터 삭제 과정 중 오류 발생");
				}
			}
		}
	}

	public void exitProgram() {
		mService.exitProgram();
	}
}