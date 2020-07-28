package com.kh.example.chap02_thows.run;

import com.kh.example.chap02_thows.controller.ThrowsController;

public class Run {
	public static void main(String[] args) /*throws Exception*/ {
		ThrowsController tc =new ThrowsController();
		
		try {
			tc.method1();
		} catch (Exception e) {
			//e.printStackTrace();
			//printStackTrace() 발생한 예외에 대한 정보를 출력하는 메소드
			System.out.println("예외 상황이 발생했습니다.");
		}
		
		System.out.println("정상적으로 종료됨...");
	}
}
