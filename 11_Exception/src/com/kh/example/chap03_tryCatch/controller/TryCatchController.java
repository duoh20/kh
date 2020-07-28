package com.kh.example.chap03_tryCatch.controller;

import java.io.IOException;

public class TryCatchController {
	public void method1() {
		System.out.println("method1() 호출됨...");
		
		try {
			method2();
			System.out.println("나는 출력이 될까 안될까?");
			//method2()에서 처리를 위임한 예외 발생했으므로,
			//try를 건너뛰고 catch절이 실행된다.
		} catch (IOException e) {
			//e.printStackTrace(); //에러 정보가 빨갛게 출력됨
			System.out.println(e.getMessage()); //에러정보가 아니라 알럿을 출력하려면 getMessatge()사용
		} catch (Exception e) {
			System.out.println("Exception으로 잡음");
		} finally {
			System.out.println("예외 여부와 상관 없이 무조건 수행");
		}
		
		System.out.println("method1() 종료됨...");
	}
	
	public void method2() throws IOException {
		System.out.println("method2() 호출됨...");
		
		//throw new NullPointerException("Null이 들어왔다!!");
		//								  -------------출력할 에러 메세지 작성 가능
		//NullPointerException은 RuntimeException으로 uncheckedException이다.
		//예외 처리  안해도 에러 표시는 안나지만 비정상 종료한다.
		
		throw new IOException("강제로 IOException을 발생 시켰습니다.");
		
		//System.out.println("method2() 종료됨...");
		//checked이던 Unchecked던 관계 없이 도달할 수 없는 코드라 의미가 없어 에러 발생
	}
}
