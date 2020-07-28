package com.kh.example.chap02.loope;

import java.util.Scanner;

public class A_For {
	// for(초기식; 조건식; 증감식;) {
	//  	실행 문장;
	// }
	//초기식 → 조건식 확인 → (조건식 true면) 실행문장 수행 → 증감식 → 조건식 확인 → (반복)
	//조건식의 결과가 false일 때까지 반복
	
	//for문 안에 있는 초기식, 조건식, 증감식 생략 가능
	//초기식은 무엇인지, 조건은 무엇인지, 증감은 얼마나 되는지 소괄호 안은 아니어도 어딘가에는 표기해야함
	//결국 for()안에서만 생략될 뿐 모두 필요한 요소
	
	Scanner sc = new Scanner(System.in);
	public void method1() {
		//1부터 5까지 출력
		for (int i = 1; i <=5; i++) {
			System.out.println(i+"번째 반복문 수행");
		}
	}
	
	public void method1_1() {
		//자기소개 다섯번 하기 : 내 이름은 박신우야
		//초기화를 꼭 0이나 1로하지 않아도 상관 없다.
		//for(int i = 1; i <= 5; i++) { → 5번 반복
		//for(int i = 2; i <= 7; i++) { → 5번 반복
		for(int i = 0; i < 5; i++) {
			System.out.println("내 이름은 박신우야");
		}
	}
	
	public void method2() {
		//5부터 1까지 출력하기
		
		//방법1
		//for(int i = 5; i > 0; i--) {
		//	System.out.println(i);
		//}
		
		//방법2
		for(int i = 1; i <= 5; i++) {
			System.out.println(6 - i);
		}
	}
	
	public void method2_1() {
		//8부터 3까지 출력
		
		//방법1
		//for(int i = 8; i > 2; i--) {
		//	System.out.print(i + " ");
		//}

		//방법2
		for(int i = 1; i < 7; i++) {
			System.out.print(9 - i + " ");
		}
	}
	
	public void method3() {
		//1에서 10 사이의 홀수만 출력
		//for (int i = 0; i < 10; i++) {
		//	if (i%2 != 0) {
		//		System.out.print(i + " ");
		//	}
		//}
		
		//증감식을 바꿔서 2씩 증가시킴
		for(int i =1; i <= 10; i += 2) {
			System.out.print(i);
		}
	}
	
	public void method4() {
		//정수 2개를 입력받아 그 사이 숫자 출력
		//정수 두 개를 입력하세요.
		//단, 첫 번째 숫자를 두 번째 숫자보다 작게 입력해주세요
		//첫 번째 숫자 : 5
		//두 번째 숫자 : 8
		//5 6 7 8
		
		System.out.println("정수 두 개를 입력하세요.");
		System.out.println("단, 첫 번째 숫자를 두 번째 숫자보다 작게 입력해주세요.");
		System.out.print("첫 번째 숫자 : ");
		int start = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int end = sc.nextInt();
		
		//방법1
		//for(int i = start; start <= end; i++) {
		//	System.out.print(i + " ");
		//}
		
		//방법2
		//초기화식을 생략
		//for(;  <= end; start++) {
		//	System.out.print(start + " ");
		//}
		
		//Q. 큰 수를 먼저 적어도 돌아가게 하려면??
		int max = 0; //두 숫자 중 큰 숫자를 저장할 공간 생성
		int min = 0; //두 숫자 중 작은 숫자를 저장할 공간 생성
		//큰 수는 max에 작은 수는 min에 저장하도록 if문을 만든다
		if(start <= end) {
			max = end;
			min = start;
		} else {
			max = start;
			min = end;
		}
		//max 변수와 min 변수를 가지고 반복문을 만든다. 
		for(; min <= max; min++) {
			System.out.print(min + " ");
		}
	}
	
	public void method4_1() {
		//정수를 하나 입력 받아 그 수가 1~9 사이의 숫자일때만 그 수의 구구단 출력
		//조건이 맞지 않으면 "1~9 사이의 양수를 입력해야합니다" 출력
		System.out.print("1~9 사이의 양수를 하나 입력하세요 : ");
		int dan = sc.nextInt();
		
		if(dan >= 1 && dan < 10) {
			for(int i = 1; i <= 9; i++) {
				System.out.println(dan + " x " + i + " = " + (dan * i));
			}
		}
	}
	
	public void method5() {
		//1부터 10 사이의 임의의 난수를 정해 1부터 난수까지의 합계
		//랜덤 값 생성 메서드: Math.random()
		//0이상 1미만의 실수를 랜덤으로 반환(double)
		//System.out.println(Math.random());
		//(0단계) 0 <= Math.random() < 1 (실수)
		//(1단계) 0 <= Math.random() * 10 < 10 : 0 ~ 9.999999999999
		//(2단계) 1 <= Math.ramdom() * 10 + 1 < 11 : 1 ~ 10.9999999999999
		//(3단계) 1 <= (int)(Math.random() * 10 + 1) < 11 : 1 ~10
		
		int random = (int)(Math.random() * 10 + 1);
		int sum = 0;
		
		for(int i = 1; i <= random; i++) {
			sum += i;
		}
		
		System.out.print("1 부터" + random + "까지의 합 :" + sum);
	}
	
	public void method6() {
		//중첩 for문: for문 안에 for문 사용 가능
		//2단부터 9단까지 출력
		for (int i = 2; i < 10; i++) {
			System.out.println(i+ " 단 ");
				for(int j = 1; j < 10; j++) {
					System.out.println(i + " * " + j + " = " + (i*j));
				}
		}
	}
	
	public void method7() {
		//아날로그 시계 0시 0분 ~ 0시 23시 59분
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 60; j++) {
				System.out.printf("%d시 %d분\n", i, j);
			}
		}
	}
	
	public void method8() {
		//한 줄에 별표(*)가 5번 출력되는데 그 줄은 사용자가 입력한 수 만큼 출력
		//ex)
		//출력할 줄 수:3
		//*****
		//*****
		//*****
		System.out.print("출력할 줄 수 : ");
		int row = sc.nextInt();
		
		//for (int i = 1; i <= input; i++) {
		//	System.out.print("*****\n");
		//}
		
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void method9() {
		//한 줄에 별표 문자를 입력한 줄 수와 칸 수만큼 입력
		//단, 줄 수와 칸수가 일치하는 위치에는 줄 번호에 대한 정수 출력
		//ex)
		//줄 수:5	줄 수:4
		//칸 수:4	칸 수:5
		//1***		1****
		//*2**		*2***
		//**3*		**3**
		//***4		***4*
		//****
		
		System.out.print("줄 수 : ");
		int row = sc.nextInt();
		System.out.print("칸 수 : ");
		int col = sc.nextInt();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == j) {
					System.out.print(i+1);
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
