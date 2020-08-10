package miniproject.library.view;

import java.util.Scanner;

import miniproject.library.model.Book.Book;
import miniproject.library.model.Book.BookDAO;

public class BookView {
	Scanner sc = new Scanner(System.in);
	BookDAO bd = new BookDAO();
	
	public void test() {
		String menu = "";
		while(menu != "9") {
			System.out.println("책 저장 테스트");
			System.out.print("제목 : ");
			String title = sc.nextLine();
			System.out.print("저자 : ");
			String author = sc.nextLine();
			System.out.print("장르 : ");
			String category = sc.nextLine();
			 
			Book book = new Book();
			System.out.print("그만하려면 9 입력 ");
			menu = sc.nextLine();
			
		}
	}
}
