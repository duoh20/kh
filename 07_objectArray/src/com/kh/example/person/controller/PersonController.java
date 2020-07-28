package com.kh.example.person.controller;

import com.kh.example.person.model.vo.Person;

public class PersonController {
	public void method1() {
		//객체 배열은 객체에 대한 배열
		Person[] pArr = new Person[5]; //Person 객체가 들어갈 수 있는 5개의 공간 pArr 생성
		
		for (int i = 0; i < pArr.length; i++) {
			System.out.print(pArr[i] + " ");
		}
		System.out.println();
		
		//for (int i = 0; i < pArr.length; i++) {
		//	System.out.println(pArr[i].personInfo());
		//}
		//System.out.println();
		//NullPointerException
		
		//인덱스를 이용해 초기화
		pArr[0] = new Person("강건강", 25, '남', 179.5, 75.6);
		pArr[1] = new Person("남나눔", 13, '남', 155.9, 45.2);
		pArr[2] = new Person("도대담", 40, '남', 185.1, 80.8);
		pArr[3] = new Person("류라라", 5, '여', 100.7, 13.0);
		pArr[4] = new Person("문미미", 27, '여', 160.4, 55.2);
		
		for (int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].personInfo());
		}
		System.out.println();
	}
	
	public void method2() {
		//객체 배열도 할당과 동시에 초기화 가능
		int[] iarr = {1, 2, 3, 4, 5};
		
		Person[] pArr = {new Person("박보배" , 28, '여', 171.0, 50.2),
						 new Person("송성실", 17, '남', 156.9, 42.0),
						 new Person("윤예의", 32, '남', 179.2, 74.2)};
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].personInfo());
		}
	}
}
