package Contoller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.dao.BookDAO;
import model.dao.MemberDAO;
import model.vo.Book;
import model.vo.Member;

public class MemberController {

	
		MemberDAO md = new MemberDAO();
	 	Map mlist =  md.openMemberList();
	
	 
	    BookDAO bd = new BookDAO();
	 	List blist = bd.openBookList(); // ArrayList의 bookList반환

	

	
	public MemberController() {
		
		
	}
	
	
	
	public List  getBlist() {
		
		return blist;
	}
	 
	
	
	public boolean join( String id, Member m) {
		
//		HashMap<String , Member> mlist =  mdao.mlist;
		
		if(!mlist.containsKey(id)) {
			
			mlist.put(id, m);
			System.out.println(id+" " + m);
			
			
			return true;
			
			
		} else {
			return false;
		}
	}
	
	
	
	public Member logIn(String id) {
//		HashMap<String , Member> mlist =  mdao.mlist;
		
		System.out.println((Member)mlist.get(id));
		
		if(mlist.containsKey(id)) {
			
			
			Member m = (Member)mlist.get(id);	
			
			
		
				return   m;
	
				
		}
		
		return null;
	}
	
	public void insertBook(Book bk) {

		blist.add(bk);
	}
	
	
	public void showMlist() {
//		HashMap<String , Member> mlist = mdao.mlist;
		
		Set set = mlist.keySet();
		
		 Iterator  it = set.iterator();    //Iterator
			
			while(it.hasNext()) {  // 다음 값이 있다면 
				
				System.out.println(it.next());    //한번 실행하면 [끝] 값을 가지고 끝나기 때문에 재활용 불가능 
				
			}		
	}

	
	

	
	
}
