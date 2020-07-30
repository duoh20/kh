package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.list.model.comparable.StudentComparator;
import com.kh.example.list.model.vo.Student;

public class ListController {
	public ListController() {}
	
	public void doList() {
		ArrayList list1 = new ArrayList();
		//List is a raw type. References to generic type List<E> should be parameterized
		//제네릭이을 지정하지 않으면 제네릭이 지정되어 있지 않았다는 알림 메세지가 뜨는데
		//이땐 Object 타입(모든 자료형)을 받을 수 있다.
		
		ArrayList<Student> list = new ArrayList(3);
		//제네릭으로 Student만 들어갈 수 있도록 타입을 제한하면, Student타입만 받을 수 있다.
		//()안에 특정 숫자를 집어 넣어서 3개짜리 ArrayList를 만들 수 있음
		
		//add(E e): 리스트 끝에 데이터 추가
		list.add(new Student("테스트", 0));
		list.add(new Student("도대담", 60));
		System.out.println("list : " + list);
		
		//장점1: 크기에 제약 없음
		list.add(new Student("남나눔", 90));
		list.add(new Student("하현호", 85));
		System.out.println("list : " + list);
		System.out.println("현재 list에 담긴 element 개수(size) : " + list.size());
		
		//장점2: 추가/삭제/정렬 등의 기능 처리 간단
		//add(int index, E e) index번째에 데이터 추가
		list.add(0, new Student("류라라", 100));
		list.add(3, new Student("강건강", 40));
		System.out.println("list : " + list);
		//remove(int index)index번째에 데이터 삭제
		//remove(Object o) 해당 데이터 삭제 index번째에 데이터 삭제
		list.remove(1);
		System.out.println("list : " + list);
		list.remove(new Student("강건강", 40));
		//remove()는 주소값을 삭제함, Object의 equals()를 통해 비교하는데
		//remove()는 equals를 따로 오버라이딩하지 않았기 때문에 Object에 정의된 대로 주소값을 통해 비교함
		//문자열 등 다른 기준으로 equals()하려면 따로 오버라이딩해서 사용
		System.out.println("list : " + list);
		
		//정렬방법1. Collection 클래스 이용: 컬랙션을 이용할 때 유용한 메소드를 모아놓은 클래스(자매품: Arrays)
		Collections.sort(list); //정렬 기준을 정해줘야만 함
		System.out.println("list 정렬1 : " + list);
		
		//정렬방법2. List.sort() 메소드 이용
		list.add(new Student("박보배", 85));
		list.sort(new StudentComparator());
		System.out.println("list 정렬2 : " + list);
		
		//장점3. 여러 타입을 저장할 수 있다.
		//list.add("끝"); //Student만 들어가도록 제한했는데 String을 집어 넣으려해서 에러남
		
		//set(int index , E e): index번째에 있는 요소를 e로 수정
		list.set(2,  new Student("도대담", 60));
		System.out.println(list);
		
		//get(int index) index번째에 있는 요소를 가지고 옴
		Student s = list.get(2);
		System.out.println(s);
		System.out.println(list); //요소를 가져와도 리스트에는 변경 없음
		
		//subList(int index1, int index2) index1번째에 ~ index2번째까지 리스트 반환 
		System.out.println(list.subList(2, 5));
		
		//contains(Object o) o가 리스트에 존재하면 true 반환
		//indexOf(Object o) o가 리스트에 위치하는 인덱스 반환
		boolean bool = list.contains(new Student("남나눔", 90));
		System.out.println(bool);
		int index = list.indexOf(new Student("남나눔", 90));
		System.out.println(index);
		int index2 = list.indexOf(new Student("테스트", 0));
		System.out.println(index2);
		
		//clear() 저장된 모든 객체 삭제
		//isEmpty() 리스트가 비어있으면 true 반환
		list.clear();
		System.out.println("list : " + list);
		System.out.println("list : " + list.isEmpty());
	}
}
