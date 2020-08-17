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

import model.vo.Member;

public class MemberDAO {

	File memberFile = new File("memberList.txt");
	Map<String,Member> memberList = new HashMap();
	
	
	
	{
//		
//		if(true) {
//		memberList.put("user01",new Member("남궁성", "부천", "010-0000-0000"));   
//		memberList.put("user02",new Member("홍길동" ,"광주", "010-0000-0001"));   
//		memberList.put("user03",new Member("강보람", "서울 특별시", "010-0000-0002")); 
//		memberList.put("master01",new Member("1번", "강남", "010-0000-0004", true)); 
//		
//		
//		saveMemberList(memberList);}
	}
	public MemberDAO() {
		if(!memberFile.exists()) {
			try {
				memberFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveMemberList(Map Member) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(memberFile)))) {
			oos.writeObject(Member);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Map openMemberList() {
		Map memberList = new HashMap();
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(memberFile)))) {
			memberList = (Map)ois.readObject();
		} catch (IOException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
}
