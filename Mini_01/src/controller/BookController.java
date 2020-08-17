package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import model.dao.BookDAO;
import model.dao.ListDAO;
import model.dao.RentDAO;
import model.vo.Book;

public class BookController {

	BookDAO bd = new BookDAO();
	RentDAO rd = new RentDAO();
	ListDAO ld = new ListDAO();
	List bookList = bd.openBookList(); // ArrayList의 bookList반환
	 // 대여인 사람들 목록 
	
	Map rentMap = rd.openRentList();
	
	ArrayList<String> Slist = (ArrayList<String>) ld.openList();
	
//	public void Open() {
//		
//		bookList = bd.openBookList();
//		rentMap =  rd.openRentList();
//	}
	
	/*
		홍길동  무슨 책   
		박신우  KH정보
		
		
	
	*/
//=====================================================================================================	
	/*
	 	대여할때  대여 중이면 대여중입니다. 출력 
	 	
	 	대여 가능 하면    
	 	
	 	rent = " 회원 ID ,  책 정보  "
	 	
	 	대여중 으로 true 
	 	
	 	
	 	
	 	
	 	나의 정보 에서 출력 
	 	rent ID로 검색 결과 출력 
	 	
	 	
	 	
	 	반납기능 
	 	
	 	책ID, 이름 으로  값을 받아서 
	 	
	 	대여 중 x  , false 
	 	
	 	 rent 삭제 
	 	 
	 	 
	
	
	*/
	
	
	// 새로운 도서 객체를 bookList에 추가한 후 bookList.txt에 저장
	public void addNewBook(Book book) {
		
		bookList.add(book);
		bd.saveBookList(bookList);
	}

	// bookList.txt에 담긴 정보 출력
	public void readBookList() {
		bookList = bd.openBookList();
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
	}
	
	public List getBlist() {
		
		return bookList;
	}

	// bookID로 책 검색 (+ 책 ID 생성 시 중복 체크 메소드로 사용)
	public boolean searchBookByBookID(String bookID) {
		for (int i = 0; i < bookList.size(); i++) {
			if (((Book) bookList.get(i)).getBookID().equals(bookID)) {
				return true;
			}
		}
		return false;
	}

	// title로 책 검색
	public List searchBookByTitle(String title) {
		List result = new ArrayList();
		
		for (int i = 0; i < bookList.size(); i++) {
			Book b = (Book) bookList.get(i);
			if (b.getTitle().equals(title)) {
				result.add(b);
				System.out.println(b);
			}
		}
		return result;
	}

	// author로 책 검색
	public List searchBookByAuthor(String author) {
		List result = new ArrayList();
		
		
		for (int i = 0; i < bookList.size(); i++) {
			Book b = (Book) bookList.get(i);
			if (b.getAuthor().equals(author)) {
				result.add(b);
			}
		}
		return result;
	}

	// category로 책 검색
	public List searchBookByCategory(String category) {
		List result = new ArrayList();
		for (int i = 0; i < bookList.size(); i++) {
			Book b = (Book) bookList.get(i);
			if (b.getCategory().equals(category)) {
				result.add(b);
			}
		}
		return result;
	}

	// 대여 가능한 책 검색
	public List searchBookByRentalable(boolean isRentalable) {
		List result = new ArrayList();
		for (int i = 0; i < bookList.size(); i++) {
			if (((Book) bookList.get(i)).getIsRentalable()) {
				result.add((Book) bookList.get(i));
			}
		}
		return result;
	}

	// 대여하기
	public Book rentBook(String bookID) {
		for (int i = 0; i < bookList.size(); i++) {
			Book book = (Book) bookList.get(i);
			if (book.getBookID().equals(bookID)) {
				if (book.getIsRentalable()) {
					book.setIsRentalable(false);
					System.out.println(book);
					bd.saveBookList(bookList);
					return book;
				}
			}
		}
		return null;
	}

	// 반납하기
	public List returnBook(List rentalList, String bookID) {
		List updateList = new ArrayList(5);
		for (int i = 0; i < rentalList.size(); i++) {
			Book book = (Book) rentalList.get(i);
			if (book.getBookID().equals(bookID)) {
				for (int j = 0; j < bookList.size(); j++) {
					if (((Book) bookList.get(j)).getBookID().equals(bookID)) {
						((Book) bookList.get(j)).setIsRentalable(true);
						break;
					}
				}
			} else {
				updateList.add(rentalList.get(i));
			}
		}
		bd.saveBookList(bookList);
		return updateList;
	}

	// 책 제목 수정
	public boolean updateBookTitle(String bookID, String newTitle) {
		if (searchBookByBookID(bookID)) {
			for (int i = 0; i < bookList.size(); i++) {
				if (((Book) bookList.get(i)).getBookID().equals(bookID)) {
					((Book) bookList.get(i)).setTitle(newTitle);
				}
			}
			bd.saveBookList(bookList);
			return true;
		}
		return false;
	}

	// 책 작가 수정
	public boolean updateBookAuthor(String bookID, String newAuthor) {
		if (searchBookByBookID(bookID)) {
			for (int i = 0; i < bookList.size(); i++) {
				if (((Book) bookList.get(i)).getBookID().equals(bookID)) {
					((Book) bookList.get(i)).setAuthor(newAuthor);
				}
			}
			bd.saveBookList(bookList);
			return true;
		}
		return false;
	}

	// 책 카테고리 수정
	public boolean updateBookCategory(String bookID, String newCategory) {
		if (searchBookByBookID(bookID)) {
			for (int i = 0; i < bookList.size(); i++) {
				if (((Book) bookList.get(i)).getBookID().equals(bookID)) {
					((Book) bookList.get(i)).setCategory(newCategory);
				}
			}
			bd.saveBookList(bookList);
			return true;
		}
		return false;
	}

	// 책 정보를 담은 bookList를 String타입의 2차원 배열로 변경
//	public String[][] tableData(String id) {
//		String[][] b = new String[0][];
//		Book book = (Book)rentMap.get(id);
		
//		if(!rentMap.isEmpty()) {
//		String[][] b = new String[0][4]();
//		
//			b[0][1] = book.getBookID();
//			b[0][2] = book.getTitle();
//			b[0][3] = book.getAuthor();
//			b[0][4] = book.getCategory();
//			b[0][5] = book.getIsRentalable()+"";
//			System.out.println(book);
//			
//			   Set<Entry<String,String>> entrySet = map.entrySet();
//			    Iterator<Entry<String, String>> iterator = entrySet.iterator();
//			    while (iterator.hasNext()) {
//			        Map.Entry entry = (Map.Entry) iterator.next();
//			        System.out.println(entry.getKey() + "=" + entry.getValue());
//			    }
//		}
			
//		if(rentMap.isEmpty()) {
//			b[0][1] = " ";
//			b[0][2] = " ";
//			b[0][3] = " ";
//			b[0][4] = " ";
//			b[0][5] = " ";
//			System.out.println(b);
//		}
//		return b;
//	}
	
	
//=====================================================================================================	
	
	public ArrayList<Book> searchBook(String keyword) {

		
		 ArrayList<Book> bk = new  ArrayList<Book>();
		
		ArrayList<Book> blist = (ArrayList<Book>) bd.openBookList();
		
		for(Book b : blist ) {
			if(b.getTitle().contains(keyword)) {
				
				
				bk.add(b);
			}
			
		}
		
			
			
		return bk;
		
	}
	
	public void  saveAll() {
		bd.saveBookList(bookList);
		rd.saveRentList(rentMap);
		ld.saveList(Slist);
	}
	
	public void rentMap(String id , Book b) {
		
		System.out.println("\n  대여 기능 실행 :  " + id);
		
		
		
		if(b.getIsRentalable() == false) {
			
			b.setIsRentalable(true);
			System.out.println(id + " " + b + " 대여 완료");
			
			Slist.add(id + "#" + b.getTitle());
			System.out.println("사용자가 빌린 책 : " + Slist);
			
			rentMap.put(id, b);
			bd.saveBookList(bookList);
			rd.saveRentList(rentMap);
			ld.saveList(Slist);
			 JOptionPane.showMessageDialog(null, b.getTitle() +"이 대여되었습니다.");
			System.out.println("\n대여 종료");
			
		}
		else {
			JOptionPane.showMessageDialog(null, "이미 대여중인 책입니다.", "danger", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean returnMap(String id , String tite) {
		
//			bookList =bd.openBookList();
//			rentMap = rd.openRentList();
			
			Set set = rentMap.keySet();
			
			Iterator it = set.iterator();
			
			ArrayList<String> list = new ArrayList();
			
			System.out.println(set);
			int i = 0;
			int index = 0 ;
			list.add(id);
			
			for(String s1 : Slist) {
				
				
				String splitStr = s1 ;
				String[] strArr = splitStr.split("#");
				
				if(strArr[0].equals(id)) {
					list.add(strArr[1]);
				}
			}
			
			
			
//		while(it.hasNext()) {
//			
//			
//			String key = (String) it.next();
//			System.out.println(key+ " == " +id ); 
//			
//			if(key.equals(id)) {
//				
//				System.out.println("실행");
//				if(i==0) {
//				list.add(id); i=1;}
//				Book b = (Book)rentMap.get(key);
//				list.add(b.getTitle());
//				System.out.println(list+ " ?"); 
//				bd.saveBookList(bookList);
//				rd.saveRentList(rentMap);
//			}
//			
//		}
		
		System.out.println("사용자가 빌린 책 : " + list);
		/*
			id1        id2
			
			Book		Book
			Book
			
			
		*/
		
		int c = 0 ;
		
		for(String s :list) {
			
			if(s.equals(tite) && list.get(0).equals(id) ) {
				
				 
						rentMap.remove(id);
						Slist.remove(id+"#"+s);
						System.out.println(id + " " + tite + " 반납 성공");
						Book b = searchBook2(tite);
						b.setIsRentalable(false);
						bd.saveBookList(bookList);
						rd.saveRentList(rentMap);
						ld.saveList(Slist);
						return true;
			
			
			
			}
			
		}
			return false;
//		System.out.println(id + " " + tite + " 반납 실패");
//		
//		
//		System.out.println(rentMap);
		
		
//		for(Book s :list) {
//				
//			if(s.equals(b)) {
//				
//				for(Book s2 : (List<Book>)bookList) {
//					
//					if(s2.equals(s)) {
//						
//						s2.setIsRentalable(false);
//						System.out.println("되냐?");
//						
//						bd.saveBookList(bookList);
//						rentMap.remove(id, s);
//						rd.saveRentList(rentMap);
//						
//						System.out.println(rentMap);
//						break;
//						
//					}
//					
//				}
//	
//			}
//			
//		}
//		
		
			
			
			
	
		
	}
	
	
	public Book searchBook2(String keyword) {

		bookList =bd.openBookList();

		
		ArrayList<Book> blist = (ArrayList<Book>)bookList;
		
		for(Book b : blist ) {
			if(b.getTitle().equals(keyword)) {
				
				
				
				return b;
			}
			
		}
		
			
			
		return null;
		
	}
	
	
	public void saveB(Book b) {
		
		bookList =bd.openBookList();
		
		
		ArrayList<Book> blist = (ArrayList<Book>)bookList;
		
		for (int i = 0; i < blist.size(); i++) {
			if(blist.get(i).equals(b)) {
				
				blist.set(i, b);
			}
			
		}
		bookList = blist;
		bd.saveBookList(bookList);
	}
	
	public Map getRent() {
		System.out.println(rentMap);
		return rentMap;
	}
	public ArrayList<String> getList() {
		
		return Slist;
	}
	
//=====================================================================================================		

}
