package model.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.vo.Book;

public class BookDAO {
	
	File bookFile = new File("bookFile.txt");
	
	public BookDAO() {
		if( !bookFile.exists()) {
			try {
				bookFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void saveBookList(List bookList) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bookFile))){
			oos.writeObject(bookList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List openBookList() {
		List bookList = new ArrayList<>();
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(bookFile)))) {
			bookList = (List)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return bookList;
	}	
}