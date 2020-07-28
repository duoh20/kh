package com.kh.example.chap01.condition;

import java.util.Scanner;

public class D_switch {
	
	//조건식의 결과 값을 case에서 찾아 명령을 수행하는 조건문
	//해당하는 값이 case에 없을 경우에는 default의 명령문 수행
	
	//case와 수행문 사이에는 콜론(:)을 써야함
	//break가 없으면 멈추지 않고 계속 수행
	
	//switch(변수) {
	//case 값1: 실행문1; break; → 변수 값이 값1이면 실행
	//case 값2: 실행문2; break; → 변수 값이 값2이면 실행
	//default: 실행문1; break; → 변수 값이 case문에 없으면 실행
	//}
	
	public void method1() {
		//정수 두 개와 연산 기호 문자 1개를 입력 받아
		//연산 기호 문자에 해당하는 계산을 수행하고 출력하시오
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 값 : ");
		int first = sc.nextInt();
		System.out.print("두 번째 값: ");
		int second = sc.nextInt();
		System.out.print("연산자(+, -, *, /) : ");
		char op = sc.next().charAt(0);
		
		int result = 0;
		
		switch (op) {
		case '+':
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '*':
			result = first * second;
			break;
		case '/':
			result = first / second;
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
		}
		System.out.println(first + " " + op + " " + second + " = " + result);
	}
	
	public void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*****신우네 과일가게입니다!^^*****");
		System.out.println("사과, 바나나, 복숭아, 키위 있습니다~ 가격 편하게 물어보세요!");
		System.out.print("어떤 과일의 가격이 궁금하세요 : ");
		String fruit = sc.nextLine();
		
		int price =0;
		
		switch(fruit) {
		case "사과":
			price = 1000;
			break;
		case "바나나":
			price = 3000;
			break;
		case "복숭아":
			price = 2000;
			break;
		case "키위":
			price = 5000;
			break;
		default:
			System.out.println("그 과일은 신우네 과일가게에는 없습니다.ㅠㅠ 옆에 신우마트로 가보세요!");
		}
		System.out.println(fruit + "의 가격은 " + price + "원입니다.");
	}
	
	public void method3() {
		//1월부터 12월까지 입력받아 해당하는 달의 마지막 날짜를 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("1월~12월까지 중 하나를 입력하세요 : ");
		int num = sc.nextInt();
		
		//switch (num) {
		//case 1: System.out.println("31일까지입니다."); break;
		//case 3: System.out.println("31일까지입니다."); break;
		//case 5: System.out.println("31일까지입니다."); break;
		//case 7: System.out.println("31일까지입니다."); break;
		//case 8: System.out.println("31일까지입니다."); break;
		//case 10: System.out.println("31일까지입니다."); break;
		//case 12: System.out.println("31일까지입니다."); break;
		//case 4: System.out.println("30일까지입니다."); break;
		//case 6: System.out.println("30일까지입니다."); break;
		//case 9: System.out.println("30일까지입니다."); break;
		//case 11: System.out.println("30일까지입니다."); break;
		//case 2: System.out.println("28일까지입니다."); break;
		//}
		
		switch (num) {
		case 1: case 3: case 5: case 7: 
		case 8: case 10: case 12:
			System.out.println("31일까지입니다."); break;
		case 4: case 6: case 9: case 11:
			System.out.println("30일까지입니다."); break;
		case 2:
			System.out.println("28일까지입니다."); break;
		default:
			System.out.println("1부터 12사이의 숫자를 입력하세요.");
		}
	}
	
	public void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("***** G클래스 우리의 메뉴입니다. *****");
		System.out.println("1. 간단하게 계산하기");
		System.out.println("2. 신우네 과일 가게");
		System.out.println("3. 월의 막날 출력하기");
		System.out.print("메뉴 번호 : ");
		int menu = sc.nextInt();
		
		switch (menu) {
		case 1:
			//System.out.println("간단 계산");
			method1(); //메소드 호출
			break;
		case 2:
			//System.out.println("신우네");
			method2();
			break;
		case 3:
			//System.out.println("막날");
			method3();
			break;
		default:
			System.out.println("메뉴 번호를 다시 입력해주세요.");
		}
	}
}
