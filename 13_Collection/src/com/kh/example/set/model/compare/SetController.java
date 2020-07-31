package com.kh.example.set.model.compare;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.kh.example.set.model.vo.Dog;

public class SetController {
	
	public void doSet() {
		//HashSet<Dog> set = new HashSet<>(); //타입 추론: 제네릭을 생략할 수 있음
		HashSet<Dog> set = new HashSet<Dog>(); 
		
		//add(E e) : set 안에 데이터 추가
		set.add(new Dog("마음", 3.3));
		set.add(new Dog("모모", 2.3));
		set.add(new Dog("이든", 5.6));
		System.out.println(set); //add한 순서대로 저장 안됨
		
		set.add(new Dog("모모", 2.3)); //new 하여 주소 값이 달라 다른 객체로 인식함(동득 객체)
		System.out.println(set); //equals()와 hashCode()를 오버라이팅해야함
		//Integer, String 등의 값을 사용하여 HashSet을 생성하면,
		//Integer, String 클래스 자체에서 equals가 값을 비교할 수 있도록 이미 오버라이딩 되어있기 때문에 중복 제거 됨
		
		
		//LinkedHashSet
		LinkedHashSet<Dog> set2 = new LinkedHashSet<Dog>();
		set2.add(new Dog("초코", 2.1));
		set2.add(new Dog("콩이", 8.3));
		set2.add(new Dog("두부", 5.0));
		set2.add(new Dog("초코", 2.1));
		System.out.println(set2); //add한 순서대로 유지되면서 중복 제거됨
		set2.add(new Dog("로이", 6.1));
		set2.add(new Dog("공주", 5.2));
		set2.add(new Dog("왕자", 9.5));
		set2.add(new Dog("조이", 12.5));
		System.out.println(set2);
		
		//TreeSet
		TreeSet<Dog> set3 = new TreeSet<Dog>(set2);
		//							set2에 있던 요소를 set3에 옮겨옴
		System.out.println(set3);
		
		TreeSet<Dog> set4 = new TreeSet<Dog>(new DogComparator()); //Comparator를 구현한 클래스
		set4.addAll(set2); //set4에 데이터 복사
		set4.add(new Dog("봄이", 6.1)); //몸무게가 같은 강아지가 있어서 같은 객체로 판단하고 중복 제거함
		System.out.println(set4);
		
		//출력 하기
		//인덱스가 없어서 요소에 접근할 수 없음, 따라서 Enumeration, Iterator, ListIterator로 접근
		Iterator<Dog> it = set4.iterator(); //iterator()는 Iterator<Dog> 반환, 참조 변수에 넣어줌
		while(it.hasNext()) { //iterator()안에 다음 값이 있는지 검사해 boolean 값 반환
			System.out.println(it.next());
		}
		
		TreeSet<Dog> set5 = new TreeSet<Dog>(new DogComparator());
		Iterator<Dog> it2 = set5.iterator();
		while(it2.hasNext()) { //iterator()는 데이터의 끝에 닿으면 역할이 끝남, 한번 더 돌리려면 새로운 객체를 다시 만들어야함
			System.out.println("re : " + it2.next());
		}
		
	}
}
