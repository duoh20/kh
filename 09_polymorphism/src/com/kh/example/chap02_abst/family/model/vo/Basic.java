package com.kh.example.chap02_abst.family.model.vo;

public interface Basic {
	
	//필드에 상수만 선언 가능
	//public abstract 생략 가능
	/*public static final*/ double PI = 3.14;
	
	//추상 메소드만 작성 가능
	/*public abstract*/ void eat();
	/*public abstract*/ void sleep();
	
	//Basic b = new Basic(); //인터페이스는 객체 생성 불가능, 대신 참조 변수 가능
	Basic mother = new Mother();
	Basic baby = new Baby();
}
