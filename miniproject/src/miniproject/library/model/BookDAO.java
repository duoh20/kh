package miniproject.library.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	
	File bookFile = new File("bookFile.txt");
	
	public BookDAO() {
		List bookList = new ArrayList<>();
	}
	
	public void hasFile() {
		if(!bookFile.exists()) {
			try {
				bookFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveBookList(List bookList) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bookFile))){
				oos.writeObject(bookList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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