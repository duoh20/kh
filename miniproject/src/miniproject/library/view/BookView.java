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
		
		while(menu != 9) {
			System.out.println("책 저장 테스트");
			System.out.print("책 ID : ");
			String bookId = sc.nextLine();
			System.out.print("제목 : ");
			String title = sc.nextLine();
			System.out.print("저자 : ");
			String author = sc.nextLine();
			System.out.print("장르 : ");
			String category = sc.nextLine();
			 
			Book book = new Book(bookId, title, author, category);
			bc.addNewBook(book);
			System.out.println(title + " 도서를 추가했습니다.");
			System.out.print("그만하려면 9 입력 : ");
			menu = Integer.parseInt(sc.nextLine());
			System.out.println();
		}
		
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
		
		
		
		System.out.println("책 대여 테스트");
		List rentalList = new ArrayList(5);
		while(menu != 9) {
			System.out.print("책 id : ");
			String bookID = sc.nextLine();
			Book book = bc.rentBook(bookID);
			if(book != null) {
				rentalList.add(book);
			} else {
				System.out.println("대여 중이거나 없는 책입니다.");
			}
			
			System.out.print("그만 빌리려면 9 : ");
			menu = Integer.parseInt(sc.nextLine());
		}
		
		System.out.println("대여 목록");
		System.out.println(rentalList);
		System.out.println("도서관 소장 도서 리스트");
		bc.readBookList();
		
	
		System.out.println("책 반납 테스트");
		System.out.print("반납할 책 id : ");
		String bookID = sc.nextLine();
		rentalList = bc.returnBook(rentalList, bookID);
		if(rentalList != null) {
			System.out.println("반납 성공");
			System.out.println("반납 후 목록");
			System.out.println(rentalList);
		} else {
			System.out.println("대여 중인 책이 없습니다.");
		}
				
		System.out.println("도서관 소장 도서 리스트");
		bc.readBookList();
	}
}