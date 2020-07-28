package com.kh.example.chap02_thows.controller;

public class ThrowsController {
	public void method1() throws Exception {
		System.out.println("method1() 호출됨...");
		method2();//method2에서 위임한 예외처리를 main()으로 위임
		System.out.println("method1() 종료됨...");		
	}
	
	public void method2() throws Exception {
		System.out.println("method2() 호출됨...");
		method3(); //method3에서 위임한 예외처리를 method1()로 위임
		System.out.println("method2() 종료됨...");		
	}
	
	public void method3() throws Exception {
		System.out.println("method3() 호출됨...");
		
		throw new Exception();
		//throw는 Exception 강제로 발생 (!!주의: throws는 예외처리를 위임)
		//Error: Unhandled exception type Exception(Exception타입의 처리하지 않은 예외 존재)
		//throws Exception을 명시하면 method3을 호출한 method2로 예외처리를 위임함
		
		//System.out.println("method3() 종료됨...");
		//Error: Unreachable code
		//Exception이 발생하면 도달할 수 없는 코드라 의미 없는 코드가 됨
	}
}
