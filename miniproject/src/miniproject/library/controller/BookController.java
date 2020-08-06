package miniproject.library.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import miniproject.book.model.dao.BookDAO;
import miniproject.book.model.vo.Book;

public class BookController {
	private ArrayList<Book> booklist = new ArrayList<Book>();
	File file = new File("booklist.txt");
	
	public void fileRead() {
	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
}
