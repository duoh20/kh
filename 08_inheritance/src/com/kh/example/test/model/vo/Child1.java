package com.kh.example.test.model.vo;

public class Child1 {
	private String str;
	private int num;
	
	public Child1() {
		Parent p = new Parent();
		//p.num = 10; private 접근자는 해당 클래스만 가능
		
		p.dNum = 0.0;
		//default 접근자는 같은 패키지 내에서 접근 가능
		p.bool = false;
		//protected 접근자는 같은 클래스 & 후손 클래스면 접근 가능
		p.ch = 'a';
		//public 접근자는 모두 접근 가능
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	public String getStr() {
		return str;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	
}
