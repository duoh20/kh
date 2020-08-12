package test;

import java.util.List;
import java.util.Scanner;

import Contoller.BookController;
import model.dao.BookDAO;

public class Test {

	public static void main(String[] args) {
		BookController bc = new BookController();
		BookDAO bd = new BookDAO();
		List bl = bd.openBookList();
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		
		System.out.print("책 id 입력 :");
		String bookID = sc.nextLine();
		
		
		bc.addRentList(bc.rentBook(bl, bookID));
		bc.readBookList();
	}

}
