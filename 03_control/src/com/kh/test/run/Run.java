package com.kh.test.run;

import com.kh.test.controller.TestController;

public class Run {
	public static void mian(String[] args) {
		System.out.println("main() 호출됨...");
		
		TestController tc = new TestController();
		tc.methodA();
		
		System.out.println("main() 종료됨...");
	}
}
