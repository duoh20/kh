package miniproject.library.controller.BookController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import miniproject.library.model.Book.Book;
import miniproject.library.model.Book.BookDAO;

public class BookController {
	List<Book> bookList = new ArrayList<Book>();
	BookDAO bd = new BookDAO();
	
	public void checkFile(String file) {
		File f = new File(file);
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean addNewBook(Book book) {
		if(book != null) {
			bookList.add(book);
			bd.saveBookList(bookList);
			return true;
		} 
		return false;
	}
	
	//{객체1, 객체2, 객체3..}
	//{{객체 1의 필드들}, {객체2의 필드들}...}
	
	public String[][] readBookList() {
		String[][] bl = new String[bookList.size()][];
		for(int i = 0; i < bookList.size(); i++) {
			for(int j = 0; j < bookList.get(i). j++) {
			
			}
		}
		return bl;
	}
	
	
	
	public boolean SearchBookByAuthor(Book book) {
		return false;
	}
	
	public void insertBook() {
		Scanner sc = new Scanner(System.in);
		System.out.print("제목:");
		String title = sc.nextLine();
		System.out.print("작가:");
		String author = sc.nextLine();
		System.out.print("장르: ");
		String category = sc.nextLine();
		boolean isRentalable = false;
		
		Book book = new Book(title, author, category, isRentalable);
		bd.saveBookList(bookList);
	}	
}
