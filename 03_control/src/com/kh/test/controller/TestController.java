package com.kh.test.controller;

public class TestController {
	public void methodA() {
		System.out.println("methodA() 호출됨");
		methodB();
		System.out.println("methodA() 종료됨");
	}
	
	public void methodB() {
		System.out.println("methodB() 호출됨");
		methodC();
		System.out.println("methodB() 종료됨");
	}
	
	public void methodC() {
		System.out.println("methodC() 호출됨");
		System.out.println("methodC() 종료됨");
	}
}
