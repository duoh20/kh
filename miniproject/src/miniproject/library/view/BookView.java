package miniproject.library.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import miniproject.library.controller.BookController.BookController;
import miniproject.library.model.Book.Book;

public class BookView {
	Scanner sc = new Scanner(System.in);
	BookController bc = new BookController();
	
	public void test() {
		int menu = 0;
		
		while(menu != 9) {
			System.out.println("책 저장 테스트");
			System.out.print("제목 : ");
			String title = sc.nextLine();
			System.out.print("저자 : ");
			String author = sc.nextLine();
			System.out.print("장르 : ");
			String category = sc.nextLine();
			 
			Book book = new Book(title, author, category);
			bc.addNewBook(book);
			System.out.println(title + " 도서를 추가했습니다.");
			System.out.print("그만하려면 9 입력 : ");
			menu = Integer.parseInt(sc.nextLine());
			System.out.println();
		}
		
		bc.readBookList();
	}
}
