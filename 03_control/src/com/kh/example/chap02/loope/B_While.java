package com.kh.example.chap02.loope;

import java.util.Scanner;

public class B_While {
	//while(조건식) {
	//	실행문장;
	//	[증감식 or 분기문;]
	//}
	//조건식확인-> (조건식이 true일 때) 실행문장 수행 -> 조건식 확인 -> (반복)
	//조건식 결과가 false가 될 때까지 반복
	
	Scanner sc = new Scanner(System.in);

	public void method1() {
		//1부터 5까지 출력
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			i++; //!무한 반복문 주의! 증감식을 적지 않으면 무한 반복함
		}
	}
	
	public void method1_1() {
		//자기소개 다섯번하기 : 내 이름은 박신우야
		int i = 0;
		while (i < 5) {
			System.out.println("내 이름은 박신우야");
			i++;
		}
	}
	
	public void method2() {
		//5부터 1까지 출력
		//방법1
		//int i = 1;
		//while (i < 6) {
		//	System.out.println(6 - i);
		//	i++;
		//}
		
		//방법2
		int i = 5;
		while (i >=1) {
			System.out.println(i);
			i--;
		}
	}
	
	public void method3() {
		//1부터 10사이의 홀수만 출력
		int i = 1;
		
		while(i < 11) {
			System.out.print(i + " ");
			i += 2;
		}
		
		//while(i < 11) {
		//	if(i%2 == 1) {
		//		System.out.print(i);
		//	} else {
		//		System.out.print(" ");
		//	}
		//	i++;
		//}
	}
	
	public void method4() {
		//정수 두 개 입력 받아 그 사이 숫자 출력
		//사용자가 첫번째 숫자를 더 크게 입력해도 제대로 출력되게 만들기
		
		System.out.println("정수 두 개를 입력하세요.");
		System.out.println("단, 첫 번째 숫자를 두 번째 숫자보다 작게 입력해주세요.");
		System.out.print("첫번째 숫자 : ");
		int start = sc.nextInt();
		System.out.print("두번째 숫자 : ");
		int end = sc.nextInt();
		
		int max;
		int min;
		
		if(start > end) {
			max = start;
			min = end;
		} else {
			max = end;
			min = start;
		}		
		
		while (min <= max) {
			System.out.print(min + " ");
			min++;
		}
	}
	
	public void method4_1() { 
		//정수 하나를 입력 받아 그 수가 1~9 사이의 수 일때만 그 수의 구구단 출력
		//조건이 맞지 않으면 "1~9 사이의 양수를 입력하여야 합니다." 출력
		
		System.out.print("1부터 9 사이의 숫자 한 개를 입력하세요 : ");
		int dan = sc.nextInt();
		
		if (dan > 0 && dan < 10) {
			int i = 1;
			while (i < 10) {
				System.out.println(dan + " * " + i + " = " + (dan * i));
				i++;
			}
		} else {
			System.out.println("1부터 9사이의 양수를 입력해야합니다.");
		}
	}
	
	public void method5() {
		//1부터 10 사이의 임의의 난수를 정해 1부터 난수까지 정수 합계
		int ran = (int)(Math.random() * 10 + 1);
		int sum = 0;
		
		int i = 1;
		while (i <= ran) {
			sum += i;
			i++;
		}
		
		System.out.println("1부터 " + ran + "까지의 합 : " + sum );
		System.out.println();
	}
	
	public void method6() {
		//문자열을 입력 받아 인덱스 별로 문자 출력
		System.out.println("문자열 입력: ");
		String str = sc.nextLine();
		
		System.out.println("내가 입력한 문자열 : " + str);
		
		//for(int i = 0; i < str.length(); i++) { //String의 length()를 사용해 문자열의 길이를 반환(int)
		//	char ch = str.charAt(i);
		//	System.out.println(i + " : " + ch);
		//}
		
		int i = 0;
		while(i < str.length()) {
			char ch = str.charAt(i);
			System.out.println(i + " : " + ch);
			i++;
		}
	}
	
	public void method7() {
		//2단부터 9단까지 출력
		int dan = 2;
		
		while(dan < 10) {
			int i = 1; //i 값이 1로 초기화 되어야하므로 while문 안에 선언한다
			while(i <10) {
				System.out.println(dan + " * " + i + " = " + (dan * i));
				i++;
			}
			dan++;
		}
	}

	
	public void method8() {
		//아날로그 시계 : 0시 0분 ~ 23시 59분까지 출력
		
		int hour = 0;
		while(hour < 24) {
			int min = 0;
			while(min < 60) {
				System.out.println(hour + "시" + min + "분");
				min++;
			}
			hour++;
		}
	}
	
	public void method11() {	
		//메뉴에 대한 반복문은 while문을 많이 쓴다.
		//반복 횟수가 정해져있지 않았기 때문임
		//단, 메뉴가 종료되기 전까지 계속 반복한다는 종료 조건은 있다.
		int menu = 0; //초기화
		while (menu != 9) {
			System.out.println("1. 1~5 출력");
			System.out.println("2. 5~1 출력");
			System.out.println("3. 1~10 사이 홀수 출력");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");			
			menu = sc.nextInt();

			switch(menu) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("종료합니다."); break;
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void method12() {
	//method12()에 while, switch, return이 담겨있음 → return이 실행되면 method12()가 종료됨
		
		//while(true) { //무한 반복문, 끝낼 수 있는 조건이 없음
			//System.out.println("1. 1~5 출력");
			//System.out.println("2. 5~1 출력");
			//System.out.println("3. 1~10 중 홀수만 출력");
			//System.out.println("9. 종료");
			//System.out.print("메뉴 선택 : ");
			//int menu = sc.nextInt();
		
			//switch(menu) {
			//case 1: method1(); break;
			//case 2: method2(); break;
			//case 3: method3(); break;
			//case 9: System.out.println("종료합니다."); return;
			                                             //나를 부른 메소드로 되돌아감
			                                             //이 예제에서는 main 메소드로 돌아감
			//default : System.out.println("잘못 입력하셨습니다.");
			//}
			
		int menu = 0;
		do {
			System.out.println("1. 1~5 출력");
			System.out.println("2. 5~1 출력");
			System.out.println("3. 1~10 중 홀수만 출력");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
		
			switch(menu) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("종료합니다."); break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		} while( menu != 9);
	}
}

