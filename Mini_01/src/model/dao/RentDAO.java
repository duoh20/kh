package model.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.vo.Book;
import model.vo.Member;

public class RentDAO {
	
	File rentFile = new File("rentList.txt");
	Map<String,Book> rentList = new HashMap();
	
	
	
	{
//		memberList.put("user01",new Member("남궁성", "부천", "010-0000-0000"));   
//		memberList.put("user02",new Member("홍길동" ,"광주", "010-0000-0001"));   
//		memberList.put("user03",new Member("강보람", "서울 특별시", "010-0000-0002")); 
//		memberList.put("master01",new Member("1번", "강남", "010-0000-0004", true)); 
//		
//		
//		saveMemberList(memberList);
	}
	public RentDAO() {
		if(!rentFile.exists()) {
			try {
				rentFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveRentList(Map Rent) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(rentFile)))) {
			oos.writeObject(Rent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String , Book> openRentList() {
		Map memberList = new HashMap();
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(rentFile)))) {
			rentList = (Map)ois.readObject();
		}catch (EOFException e) {
				
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rentList;
	}
	
	

	
}
