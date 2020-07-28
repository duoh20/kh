package com.kh.example.chap02_abst.family.controller;

import com.kh.example.chap02_abst.family.model.vo.Baby;
import com.kh.example.chap02_abst.family.model.vo.Family;
import com.kh.example.chap02_abst.family.model.vo.Mother;

public class FamilyController {
	public void method() {
		//Family f = new Family();
		//추상 클래스는 객체 생성이 불가능함, 대신 참조 변수를 받을 수 있음
		
		Family m = new Mother("어머니", 50, 70, "출산");
		Family b = new Baby("베이비", 3.5, 70);
		//Family를 상속 받은 Mother와 Baby의 객체를 Family 레퍼런스 변수 m과 b에 각각 담을 수 있음
		
		System.out.println(m);
		System.out.println(b);
		
		m.eat();
		b.eat();
		
		m.sleep();
		b.sleep();
		
		System.out.println(m);
		System.out.println(b);
	}
}
