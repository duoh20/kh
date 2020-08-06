package miniproject.book.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import miniproject.book.model.vo.Book;


public class BookDAO {
	ArrayList<Book> bookList = new ArrayList<Book>();
	Book book = new Book();
	File file = new File("booklist.txt");
	
	public BookDAO() {
		File file = new File("booklist.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileSave() {
		Book[] bk = (Book[])bookList.toArray();
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("booklist.txt"))) {
			for(int i = 0; i < bk.length; i++) {
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		File file = new File("booklist.txt");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
