package miniproject.library.model.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookDAO {
	
	File bookFile = new File("bookFile.txt");
	List bookList = new ArrayList();
	
	public void saveBookList(List<Book> bookList) {
		Iterator<Book> it = bookList.iterator();
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bookFile))){
			while(it.hasNext()) {
				oos.writeObject(bookList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	public Book[] openBookList() {
		Book[] other =(Book[]) bookList.toArray();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bookFile))) {
			for(int i = 0; i < bookList.size(); i++) {
				other[i] = (Book)ois.readObject();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return other;
	}	
}
