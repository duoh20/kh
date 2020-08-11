package miniproject.library.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import miniproject.library.controller.BookController;
import miniproject.library.model.Book;

public class BookView {
	Scanner sc = new Scanner(System.in);
	BookController bc = new BookController();
	
	public void test() {
		int menu = 0;
		
//		while(menu != 9) {
//			System.out.println("책 저장 테스트");
//			System.out.print("책 ID : ");
//			String bookId = sc.nextLine();
//			System.out.print("제목 : ");
//			String title = sc.nextLine();
//			System.out.print("저자 : ");
//			String author = sc.nextLine();
//			System.out.print("장르 : ");
//			String category = sc.nextLine();
//			 
//			Book book = new Book(bookId, title, author, category);
//			bc.addNewBook(book);
//			System.out.println(title + " 도서를 추가했습니다.");
//			System.out.print("그만하려면 9 입력 : ");
//			menu = Integer.parseInt(sc.nextLine());
//			System.out.println();
//		}
		
//		System.out.println("arrayList에 들어있는 정보");
//		bc.readBookList();
//		System.out.println();
//		System.out.println("2차원 배열화 해본 결과");
//		String[][] sArr = bc.listBookInfo();
//		for(int i = 0; i < sArr.length; i++) {
//			for(int j = 0; j < sArr[i].length; j++) {
//				System.out.print(sArr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("끝");	
		
		System.out.println("책 정보 검색 테스트");
		System.out.print("저자 : ");
		String author = sc.nextLine();		
		//boolean result = bc.updateBookTile();
		System.out.println(bc.searchBookByAuthor(author));
		//System.out.println(result);
	}
}