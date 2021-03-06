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
	
	//bookID로 책 검색 (+ 책 ID 생성 시 중복 체크 메소드로 사용)
	public boolean searchBookByBookID(String bookID) {
		for(int i = 0; i < bookList.size(); i++) {
			if(((Book)bookList.get(i)).getBookID().equals(bookID)) {
				return true;
			}
		}
		return false;
	}

	//title로 책 검색
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

	//author로 책 검색
	public List searchBookByAuthor(String author) {
		List result = new ArrayList();
		for(int i = 0; i < bookList.size(); i++) {
			Book b = (Book)bookList.get(i);
			if(b.getAuthor().equals(author)) {
				result.add(b);
			}
		}
		return result;
	}
	
	//category로 책 검색
	public List searchBookByCategory(String category) {
		List result = new ArrayList();
		for(int i = 0; i < bookList.size(); i++) {
			Book b = (Book)bookList.get(i);
			if(b.getCategory().equals(category)) {
				result.add(b);
			}
		}
		return result;
	}
	
	//대여 가능한 책 검색
	public List searchBookByRentalable(boolean isRentalable) {
		List result = new ArrayList();
		for(int i = 0; i < bookList.size(); i++) {
			if(((Book)bookList.get(i)).getIsRentalable()) {
				result.add((Book)bookList.get(i));
			}
		}
		return result;
	}
	
	//대여하기
	public Book rentBook(String bookID) {
		for(int i = 0; i < bookList.size(); i++) {
			Book book = (Book)bookList.get(i);
			if(book.getBookID().equals(bookID)) {
				if(book.getIsRentalable()) {
					book.setIsRentalable(false);
					System.out.println(book);
					bd.saveBookList(bookList);
					return book;
				}
			}
		}
		return null;
	}
	
	//반납하기
	public List returnBook(List rentalList, String bookID) {
		List updateList = new ArrayList(5);
		for(int i = 0; i < rentalList.size(); i++) {
			Book book = (Book)rentalList.get(i);
			if(book.getBookID().equals(bookID)) {
				for(int j = 0; j < bookList.size(); j++) {
					if(((Book)bookList.get(j)).getBookID().equals(bookID)) {
						((Book)bookList.get(j)).setIsRentalable(true);
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
	
	//책 제목 수정
	public boolean updateBookTitle(String bookID, String newTitle) {
		if(searchBookByBookID(bookID)) {
			for (int i = 0; i < bookList.size(); i++) {
				if(((Book)bookList.get(i)).getBookID().equals(bookID)) {
					((Book) bookList.get(i)).setTitle(newTitle);
				}
			}
		bd.saveBookList(bookList);
		return true;
		}
		return false;
	}
	
	//책 작가 수정
	public boolean updateBookAuthor(String bookID, String newAuthor) {
		if(searchBookByBookID(bookID)) {
			for (int i = 0; i < bookList.size(); i++) {
				if(((Book)bookList.get(i)).getBookID().equals(bookID)) {
					((Book) bookList.get(i)).setAuthor(newAuthor);
				}
			}
			bd.saveBookList(bookList);
			return true;
		}
		return false;
	}
	
	//책 카테고리 수정
	public boolean updateBookCategory(String bookID, String newCategory) {
		if(searchBookByBookID(bookID)) {
			for (int i = 0; i < bookList.size(); i++) {
				if(((Book)bookList.get(i)).getBookID().equals(bookID)) {
					((Book) bookList.get(i)).setCategory(newCategory);
				}
			}
			bd.saveBookList(bookList);
			return true;
		}
		return false;
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