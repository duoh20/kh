package com.kh.example.test.model.vo;

public class Child2 extends Parent {
	private String str;
	
	public Child2() {
		//super.num = 10; //private는 접근 불가
		super.dNum = 10;
		super.bool = false;
		super.ch = 'a';
	}
	public void setStr(String str) {
		this.str =str;
	}
	
	public String getStr() {
		return str;
	}
}
