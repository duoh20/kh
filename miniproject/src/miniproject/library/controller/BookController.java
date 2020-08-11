package miniproject.library.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import miniproject.library.model.Book;
import miniproject.library.model.BookDAO;

public class BookController {
	
	BookDAO bd = new BookDAO();
	List bookList = bd.openBookList(); //ArrayList의 bookList반환
	
	//새로운 도서 객체를 bookList에 추가한 후  bookList.txt에 저장
	public void addNewBook(Book book) {
		System.out.println(book);
		bookList.add(book);
		bd.saveBookList(bookList);
	}
	
	//bookList.txt에 담긴 정보 출력
	public void readBookList() {
		bookList = bd.openBookList();
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
	}

	//책 title로 책 검색
	public List searchBookByTitle(String title) {
		List result = new ArrayList();
		for(int i = 0; i < bookList.size(); i++) {
			Book b = (Book)bookList.get(i);
			if(b.getTitle().equals(title)) {
				result.add(b);
			}
		}
		return result;
	}

	//책 author로 책 검색
	public List searchBookByAuthor(String Author) {
		List result = new ArrayList();
		for(int i = 0; i < bookList.size(); i++) {
			Book b = (Book)bookList.get(i);
			if(b.getAuthor().equals(Author)) {
				result.add(b);
			}
		}
		return result;
	}
	
	//bookID로 책 검색
	public List searchBookByBookID(String bookID) {
		List result = new ArrayList();
		for(int i = 0; i < bookList.size(); i++) {
			Book b = (Book)bookList.get(i);
			if(b.getBookID().equals(bookID)) {
				result.add(b);
			}
		}
		return result;
	}

	//책 정보를 담은 bookList를 String타입의 2차원 배열로 변경
	public String[][] listBookInfo() {
		String[][] bl = new String[bookList.size()][];
		for(int i = 0; i < bookList.size(); i++) {
			String b = bookList.get(i).toString();
			String[] row = b.split(",");
			bl[i] = new String[row.length];
			for(int j = 0; j < bl[i].length; j++) {
				bl[i][j] = row[j];
			}
		}
		return bl;
	}
}