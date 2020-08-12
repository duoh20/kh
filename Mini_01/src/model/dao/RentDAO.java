package model.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import model.vo.Book;

public class RentDAO {
	
	File rentFile = new File("rentFile.txt");
	
	public RentDAO() {
		if(!rentFile.exists())
			try {
				rentFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public boolean saveRentFile(Map rentList) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(rentFile)))){
			oos.writeObject(rentList);
			oos.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public Map openRentFile() {
		Map<String, Book> rentList = new HashMap<>();
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(rentFile)))){
			rentList = (Map<String, Book>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rentList;
	}
}
