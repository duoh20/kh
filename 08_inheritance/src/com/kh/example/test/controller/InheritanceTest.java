package com.kh.example.test.controller;

import com.kh.example.test.model.vo.Child1;
import com.kh.example.test.model.vo.Child2;
import com.kh.example.test.model.vo.Parent;

public class InheritanceTest {
	
	public void method() {
		System.out.println("Parent 클래스 num 필드에 접근");
		Parent p = new Parent(); //객체 생성
		p.setNum(9);
		System.out.println("Parent 안에 있는 num : " + p.getNum());
		
		System.out.println("Child1 클래스의 str 필드에 접근");
		Child1 c1 = new Child1();
		c1.setStr("Hello");
		System.out.println("Child1 안에 있는 str 필드 " + c1.getStr());
		
		System.out.println("Child1클래스의 num 필드 접근");
		c1.setNum(99);
		System.out.println("Child1 안에 있는 num : " + c1.getNum());
		
		System.out.println("Child2클래스 str 필드 접근");
		Child2 c2 = new Child2();
		c2.setStr("World");
		System.out.println("Child2 안에 있는 str : " + c2.getStr());		
		
		System.out.println("Child2가 상속받은 Parent 필드 접근");
		//c2.num;
		//The field Parent.num is not visible
		//Parent의 맴버 변수 num은 private 필드라 직접 변경 불가
		
		c2.setNum(999);
		System.out.println("Child2 안에 있는 num : " + c2.getNum()); //결과 999
		System.out.println("Parent 안에 있는 num : " + p.getNum()); //결과 9
		//parent와 child 필드에 저장되는 값은 연결된 값이 아님 주의!!
	}
}
