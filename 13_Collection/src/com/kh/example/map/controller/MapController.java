package com.kh.example.map.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.kh.example.map.model.compare.SnackComparator;
import com.kh.example.map.model.vo.Snack;

public class MapController {
	public void doMap() {
		HashMap<String, Snack> map = new HashMap<String, Snack>(); //제네릭 설정도 키, 값 하나씩 정해줘야함
		
		//put(K key, V value):키와 값 추가
		map.put("새우깡", new Snack("짠맛", 1500));
		map.put("다이제", new Snack("단맛", 2500));
		map.put("포테이토칩", new Snack("짠맛", 1500));
		map.put("고소미", new Snack("고소한맛", 1000));
		System.out.println(map); //저장 순서에 상관 없이 배치, Snack 짠맛 1500원이 있는데 중복 제거 되지 않고 나옴
		map.put("새우깡", new Snack("매운맛", 1500));
		System.out.println(map); //키가 중복되면 해당하는 키에 새로운 값(value)을 덮어씌움
		
		//containsKey(Object key) key가 있으면 true 반환
		//containsValue(Object value) value가 있으면 true 반환
		System.out.println(map.containsKey("새우깡"));
		System.out.println(map.containsValue(new Snack("짠맛", 1500)));//주소값이 달라서, snack안에 hashCode()와 equals() 재정의
		
		//get(Object key): key에 대한 값을 반환
		System.out.println(map.get("새우깡"));//주소값이 달라서 false 반환, Snack 클래스에 hashCode()와 equals() 재정의 필요
		System.out.println(map.get("포카칩"));//없는 키를 넣으면 null 반환
	
		//values() 모든 값들을 Collection에 담아 반환
		System.out.println(map.values());
		
		//Element에 접근하기
		//방법1 keySet(): 모든 key를 set에 담아 반환
		map.keySet(); //key 설정을 String으로 해두었기 때문에 반환형이 String
		Set<String> set1 = map.keySet();
		Iterator<String> it1 = set1.iterator();
		while(it1.hasNext()) {
			String key = it1.next();
			System.out.printf("key : %s, value : %s\n", key, map.get(key));
		}
		
		//방법1 entrySet(): 모든 entry(key+value)를 set에 담아 반환
		Set<Entry<String, Snack>> set2 = map.entrySet();//제너릭안에 제너릭이 들어가있는 상태
		//System.out.println(set2);
		Iterator<Entry<String, Snack>> it2 = set2.iterator();
		while(it2.hasNext()) {
			Entry<String, Snack> en = it2.next();
			System.out.printf("key : %s, value : %s\n", en.getKey(), en.getValue());
		}
		
		System.out.println();
		
		//TreeMap
		TreeMap<String, Snack> map2 = new TreeMap<String, Snack>();
		map2.putAll(map);
		//자동으로 key를 기준으로 오름차순 정렬함
		System.out.println(map2);
		
		//내림차순으로 정렬하고 싶다면????
		//사용자 정렬 기준을 정의한 SnackComparator 클래스 생성하여 Comparator를 구현
		TreeMap<String, Snack> map3 = new TreeMap<String, Snack>(new SnackComparator());
		map3.putAll(map);
		System.out.println(map3);
		
		System.out.println(map3.size());
		
		//remove(Object key) : 해당 key의 entry 삭제 후 그 key의 value 반환
		System.out.println(map3.remove("다이제"));
		System.out.println(map3);

		//remove(Object key, Object value): 해당 key의 entry 삭제 후 그 key의 value 반환
		System.out.println(map3.remove("포테이토", new Snack("짠맛",1500))); //key와 value가 일치하는 entry가 없어서 삭제 수행 못하고 false 반환
		System.out.println(map3);
		
		map3.clear();//모두 삭제
		System.out.println(map3);
		System.out.println(map3.isEmpty());
	}
	
	public void doProperties() {
		Properties prop = new Properties();
		//prop.put(1, 10); //hashTable에서 상속 받은 put을 사용하면 String이 아닌 것도 넣을 수 있음
		prop.setProperty("채소", "오이"); //이 메소드를 사용해야함
		prop.setProperty("과일", "사과"); //이 메소드를 사용해야함
		prop.setProperty("간식", "젤리"); //이 메소드를 사용해야함
		prop.setProperty("채소", "피망"); //이 메소드를 사용해야함
		System.out.println(prop); //순서 유지 x, 덮어쓰기 o
		
		System.out.println(prop.getProperty("채소")); //key를 통해 value 접근
		System.out.println(prop.getProperty("견과")); //없는 key를 가져오면 null 반환
		System.out.println(prop.getProperty("채소", "땅콩")); //key를 통해 value 반환, 값이 달라도 key에 저장된 값(피망) 반환
		System.out.println(prop.getProperty("견과", "땅콩")); //Properties 참조 변수에 존재 하지 않는 key라면 뒤의 값(땅콩) 반환
	}
	
	public void fileSave() {
		Properties prop = new Properties();
		prop.setProperty("title", "Properties Practice");
		prop.setProperty("width", "1920");
		prop.setProperty("height", "1080");
		prop.setProperty("language", "kor");
		
		//try(FileOutputStream fos = new FileOutputStream("test.properties")) {
		try(FileOutputStream fos = new FileOutputStream("test.xml")) { 
			//store(OutputStream out, String comments) 저장된 정보를 바이트 스트림으로 출력 저장, comments는 주석으로 저장
			//store(Writer writer, String comments) 저장된 정보를 문자 스트림으로 출력 저장, comments는 주석으로 저장			
			//prop에 담은 Properties를 fos를 통해  "Properties Test File" 주석을 달아 저장한다.
			//prop.store(fos, "Properties Test File");
			
			//storeToXML(OutputStream out, String comments) 저장된 정보를 바이트 스트림으로 xml로 출력 저장, comments는 주석으로 저장
			prop.storeToXML(fos, "storeToXML Test File");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void fileOpen() {
		//try(FileInputStream fis = new FileInputStream("test.properties")) {
		try(FileInputStream fis = new FileInputStream("test.xml")) {
			
			Properties prop = new Properties(); //파일을 읽어와 prop에 담기
			
			//load(InputStream inStream) 바이트 스트림으로 저장된 파일의 내용을 읽어와 Properties에 저장
			//load(Reader reader) 문자 스트림으로 저장된 파일의 내용을 읽어와 Properties에 저장
			//prop.load(fis); //load(): properties를 읽어오는 메소드
		
			//loadFromXML(InputStream in): 바이트 스트림으로 저장된 xml 파일의 내용을 읽어와서 Properties에 저장
			
			prop.loadFromXML(fis);
			System.out.println(prop);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
