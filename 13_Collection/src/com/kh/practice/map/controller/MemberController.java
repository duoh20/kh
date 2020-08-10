package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {

	private HashMap<String, Member> map = new HashMap<String, Member>();
	
	public boolean joinMembership(String id, Member m) {
		if(!map.containsKey(id)) {
			map.put(id, m);
			return true;
		} else {
			return false;
		}
	}
	
	public String login(String id, String password) {
		if(map.containsKey(id)) {
			Member m = map.get(id);
			String savedPw = m.getPassword();
			
			if(savedPw.equals(password)) {
				return m.getName();
			} else {
				return null;
			}
		}
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		
		if(map.containsKey(id)) {
			Member m = map.get(id);
			String mOldPw = m.getPassword();
			if(mOldPw.equals(oldPw)) {
				m.setPassword(newPw);
				return true;
			}
		}
		return false;
	}
	
	public void changeName(String id, String newName) {
			Member m = map.get(id);
			m.setName(newName);
	}
	
	public TreeMap sameName(String name) {
		TreeMap tm = new TreeMap();
		Set readMap = map.keySet(); //keySet()으로 바꾼 후 set타입으로 바꿈
		Iterator it = readMap.iterator(); //iterator를 사용해 순차적으로 탐색
		
		while(it.hasNext()) {
			String key = (String)it.next(); //Object를 반환하므로 String으로 변환
			Member m = map.get(key);
			if(m.getName().contentEquals(name)) {
				tm.put(key, name);
			}
		}
		return tm;
	}
}
