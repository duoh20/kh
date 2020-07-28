package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	
	private Member[] m = new Member[SIZE];
	public final static int SIZE = 10;
	
	public int existMemberNum() {
		int count = 0;
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	public Boolean checkId(String inputId) {
		for(int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				if(m[i].getId().contentEquals(inputId)) {
					return true ;
				}
			}
		} //!!!! if 결과에 맞지 않으면 리턴 값이 없을 수도 있어서 무조건 리턴값이 있어야함
		return false;
	}
	
	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		int index = 0;
		for (int i = 0; i < m.length; i++) {
			if(m[i] == null) {
				index = i;
				break;
			}
		}
		m[index] = new Member(id, name, password, email, gender, age);
	}
	
	public String searchId(String id) {
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(m[i].getId().equals(id)) {
					return m[i].inform();
				}
			}
		}
		return null;
	}
	
	public Member[] searchName(String name) {
		Member result[] = new Member[SIZE];
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(m[i].getName().equals(name)) {
					result[i] = m[i];
				}
			}
		}
		return result;
	}
	
	public Member[] searchEmail(String email) {
		Member[] result = new Member[SIZE];
		for(int i = 0; i < m.length; i++) {
			if(m[i].getEmail().equals(email))
				result[i] = m[i];
		}
		return result;
	}
	
	public Boolean updatePassword(String id, String password) {
		for(int i = 0; i < m.length; i++) {
			if(m[i].getId().equals(id)) {
				m[i].setPassword(password);
				return true;
			}
		}
		return true;
	}
	
//	public Boolean updateName(String id, String name) {
//		
//	}
//	
//	public Boolean updateEmail(String id, String email) { 
//		
//	}
//	
//	public Boolean delete(String id) {
//		
//	}
//	
//	public void delete() {
//		
//	}
	
	public Member[] printAll() {
		return m;
	}
}
