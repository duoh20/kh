package miniproject.library.controller;

import java.util.HashMap;

import miniproject.library.model.Member;
import miniproject.library.model.MemberDAO;

public class MemberController {
	
	MemberDAO md = new MemberDAO();
	HashMap<String , Member> mlist = new HashMap<>();	
	
	public boolean join(String id, Member m) {
			
		if(!mlist.containsKey(id)) {
			mlist.put(id, m);
			System.out.println(id + " " + m);
				return true;
			} else {
				return false;
			}
		}
	
	
	public Member logIn(String id) {	
		System.out.println((Member)mlist.get(id));
		
		if(mlist.containsKey(id)) {
			
			Member m = (Member)mlist.get(id);	
				return  m;				
		}
		return null;
	}
	
//	public void saveRentalInfo() {
//		Hash Map
//	}
}
