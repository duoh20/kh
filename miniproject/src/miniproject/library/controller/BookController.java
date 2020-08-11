package miniproject.library.controller;

import java.util.List;

import miniproject.library.model.Book;
import miniproject.library.model.BookDAO;

public class BookController {
	
	BookDAO bd = new BookDAO();
	List bookList = bd.openBookList(); //ArrayList의 bookList반환
	
	
	public List getBookList() {
		return bookList;
	}
	
	public void addNewBook(Book book) {
		bookList.add(book);
		bd.saveBookList(bookList);
	}
	
	public void readBookList() {
		bookList = bd.openBookList();
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
	}
	
	
	//arrayList를 {{객체 1의 필드들}, {객체2의 필드들}...}과 같은 형태로 바꿔보기
	public void listBookInfo() {
		Book[][] bl = new Book[bookList.size()][]; //2차원 배열을 담을 그릇 생성
		for(int i = 0; i < bookList.size(); i++) { //행 길이는 arrayList 길이와 같음
			Book[] row = (Book[]) bookList.get(i); //row에 각 행에 담길 개별 객체 추출
			bl[i] = new Book[row.length];  //각 행에 담길 열의 길이 구함
			for(int j = 0; j < bl[i].length; j++) {//각 행의 열 길이 만큼 돌면서 값 출력
				System.out.println(bl[i][j]); //i행 j열 정보 출력
			}
		}
		//return bl;
	}
	
	public boolean SearchBookByAuthor(Book book) {
		return false;
	}
}