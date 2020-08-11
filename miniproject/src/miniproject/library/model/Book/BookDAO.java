package miniproject.library.model.Book;

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
	List bookList = new ArrayList<>();
	
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
		hasFile();
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bookFile, true))){
				oos.writeObject(bookList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public ArrayList openBookList() {
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(bookFile)))) {
			bookList = (ArrayList<Book>)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (ArrayList)bookList;
	}	
}
