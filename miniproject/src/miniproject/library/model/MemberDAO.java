package miniproject.library.model;

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

public class MemberDAO {

	File memberFile = new File("memberList.txt");
	Map memberList = new HashMap();
	
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
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
}
