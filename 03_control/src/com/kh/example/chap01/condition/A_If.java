package com.kh.example.chap01.condition;

import java.util.Scanner;

public class A_If {
	//단독 if문
	//if(조건식) {
	//	실행할 문장
	//}
	//조건식의 결과 값이 참(true)면 { }안에 있는 코드 실행
	//조건식의 결과 값이 거짓(false)면 { }안에 있는 코드는 무시하고 넘어감
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		//입력한 숫자가 양수인지 음수인지 출력
		System.out.print("숫자 한 개를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("입력하신 숫자는 양수입니다.");
		}
		
		if(num == 0) {
			System.out.println("입력하신 숫자는 0입니다.");
		}
		
		if(num < 0) {
			System.out.println("입력하신 숫자는 음수입니다.");
		}
		
		System.out.print("프로그램 종료");
		//프로그램은 위에서부터 순차적으로 수행한다.
		//입력한 값이 num에 저장되고, if 조건을 확인하여 true일 경우 {}안의 수행문을 수행하는 식의 흐름을 이해하는 것이 중요하다.
	}
	
	public void method2() {
		//입력한 숫자가 짝수인지 홀수인지 출력
		System.out.print("숫자 한 개를 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num != 0 && num % 2 ==0) {
			System.out.println("입력하신 숫자는 짝수입니다.");
		}
		
		if (num == 0) {
			System.out.println("입력하신 숫자는 0입니다.");
		}
		
		if (num != 0 && num % 2 != 0) {
			System.out.println("입력하신 숫자는 홀수입니다.");
		}
	}
	
	public void method3() {
		//입력한 숫자가 1~10 사이의 숫자인지 확인
		System.out.print("숫자 한 개를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 0 && num < 11) {
			System.out.println("1과 10 사이의 숫자입니다.");
		}
		
		if(num > 11 || num < 0){
			System.out.println("1과 10 사이의 숫자가 아닙니다.");
		}
	}
	
	public void method4() {
		//문자열 비교하기
		//이름을 입력받아 본인 이름과 같으면 본인입니다 출력
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		//주의!! 문자열 비교는 ==으로 할 수 없음
		//문자열 비교는 String 클래스 안에 있는 equals()로 메소드 비교
		if(name.equals("박신우")) {
			System.out.println("본인입니다.");
		}
		
		//문자열 비교 시 false는 부정을 사용
		if(!name.equals("박신우")) {
			System.out.println("본인이 아닙니다.");
		}
	}
}
