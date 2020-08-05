package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc= new BookController();
	
	public void mainMenu() {
		System.out.println("===== Welcome KH Library =====");
		System.out.println();
		int menu = 0;
		do {
			System.out.println("=====***** 메인메뉴 *****=====");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			menu = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			switch(menu) {
			case 1: insertBook(); break;
			case 2: selectList(); break;
			case 3: searchBook(); break;
			case 4: deleteBook(); break;
			case 5: ascBook(); break;
			case 9: System.out.println("프로그램을 종료합니다."); break;
			default: System.out.println("잘못 입력하였습니다.\n다시 입력해주세요.");
			}
		} while(menu != 9);
	}
	
	public void insertBook() {
		System.out.println("책 정보를 입력해주세요.");
		System.out.print("도서 명 : ");
		String title = sc.nextLine();
		System.out.print("저자 명 : ");
		String author = sc.nextLine();
		System.out.print("장르(1. 인문/ 2. 과학 / 3. 외국어 / 4. 기타) : ");
		int input = Integer.parseInt(sc.nextLine());
		String category = "";
		switch(input) {
		case 1: category = "인문"; break;
		case 2: category = "과학"; break;
		case 3: category = "외국어"; break;
		case 4: category = "기타"; break;
		}
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		Book bk = new Book(title, author, category, price);
		bc.insertBook(bk);
	}
	
	public void selectList() {
		System.out.println("===== 도서 전체 조회 =====");
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList = bc.selectList();
		if(bookList.isEmpty()) {
			System.out.println("존재 하는 도서가 없습니다.");
		} else {
			for(int i = 0; i < bookList.size(); i++) {
				System.out.println("\t" + bookList.get(i));
			}
		}
	}
	
	public void searchBook() {
		ArrayList<Book> searchBook = new ArrayList<Book>();
		System.out.println("===== 도서 검색 =====");
		System.out.print("검색 키워드 : ");
		String keyword = sc.nextLine();
		
		searchBook = bc.searchBook(keyword);
		
		if(searchBook.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for(int i = 0; i < searchBook.size(); i++) {
				System.out.println("\t" + searchBook.get(i));
			}
		}
	}
	
	public void deleteBook() {
		System.out.println("===== 도서 검색 =====");
		System.out.print("삭제할 도서 명: ");
		String title = sc.nextLine();
		System.out.print("삭제할 도서 저자명 : ");
		String author = sc.nextLine();
		
		Book removeBook =bc.deleteBook(title, author);
		
		if(removeBook != null) {
			System.out.println("성공적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제할 도서를 찾지 못했습니다.");
		}
	}
	
	public void ascBook() {
		int result = bc.ascBook();
		
		if(result == 1) {
			System.out.println("정렬에 성공하였습니다.");
		} else {
			System.out.println("정렬에 실패하였습니다.");
		}
	}
}
