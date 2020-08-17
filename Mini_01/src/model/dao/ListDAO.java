package model.dao;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.vo.Book;

public class ListDAO {
	File ListFile = new File("LisFile.txt");
	List<String> List = new ArrayList<>();
	
	
	public ListDAO() {
		
		if(!ListFile.exists()) {
			
			try {
				ListFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public void saveList(List LisFile) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ListFile))){
				oos.writeObject(List);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List openList() {
		List LisFile = new ArrayList<>();
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ListFile)))) {
			List = (List)ois.readObject();
			
		}catch (EOFException e) {
				
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return List;
	}	

}
