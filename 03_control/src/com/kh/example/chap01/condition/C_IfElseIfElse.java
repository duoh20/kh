package com.kh.example.chap01.condition;

import java.util.Scanner;

public class C_IfElseIfElse {
	//if-else if문
	// if(조건식1) {
	//	 실행할 문장1;
	// }  else if(조건식2) {
	// 	 실행할 문장2;
	// }  else {
	//	 실행할 문장3);
	// }
	//다중 조건을 줄 수 있는 조건문
	//if문의 조건식의 결과 값이 참(true)이면 if문 안의 실행 문장1 수행
	//if문의 조건식의 결과 값이 거짓(false)이면 else if문의 조건식 결과 값이 참(true)이면 else if 안에 있는 실행문장2 수행
	//둘 다 거짓(false)이라면 실행문장3 수행
	// ===> if문에서 true라고 수행이 되었으면 그 아래 문장들은 수행되지 않음
	//      else if문이 여러 개 일 수도 있고, else문은 없을 수도 있음
	
	public void method1() {
		//입력한 숫자가 양수인지 0인지 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 한 개를 입력하세요 : ");
		int num =sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수입니다.");
		} else if(num ==0) {
			System.out.println("0입니다.");
		} else {
			System.out.println("음수입니다.");
		}
	}
	
	public void method2() {
		//점수를 하나 입력 받아 등급을 나누어 점수와 등급 출력
		//90점 이상은 A등급,
		//90점 미만 80점 이상은 B등급
		//80점 미만 70점 이상은 C등급
		//70점 미만 60점 이상은 D등급
		//60점 미만은 F등급으로 나눈다
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		char grade = ' ';
		
		//else if(score <90 && score >= 80)과 같은 형식으로 작성하지 않아도 되는 이유?
		//이미 if 조건문을 통해 입력된 숫자가 90점 이상이 아닌 숫자만 else if문에 도달할 수 있기 때문에
		//else if에는 90점 미만의 숫자만 조건에 걸리게 된다.
		//위 과정이 순차적으로 진행되기 때문에 범위 설정을 간략화할 수 있다
		if(score >= 90) {
			grade = 'A';
		} else if(score >= 80) {
			grade = 'B';
		} else if(score >= 70) {
			grade = 'C';
		} else if(score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		
		System.out.printf("당신의 점수는 %d점이고 등급은 %c입니다.", score, grade);
	}
	
	public void method3() {
		//위 문제에서 각 등급 별 중간 점수 이상의 경우에는 등급에 +라는 문자를 추가로 출력하세요
		//예) 95점 이상은 등급이 A+, 90점 이상은 A, 85점 이상은 B+, ...
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		String grade;
		
		if(score >= 95) {
			grade = "A+";
		} else if(score >= 90) {
			grade = "A";
		} else if(score >= 85) {
			grade = "B+";
		} else if(score >= 80) {
			grade = "B";
		} else if(score >= 75) {
			grade = "C+";
		} else if(score >= 70) {
			grade = "C";
		} else if(score >= 65) {
			grade = "D+";
		} else if(score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		System.out.printf("당신의 점수는 %d점이고 등급은 %s입니다.", score, grade);
	}
	
	public void method4() {
		//method3 문제와 동일
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		String grade;
		
		if(score >= 90) {
			grade ="A";
			if(score >= 95) {
				grade += "+";
			}
		} else if(score >= 80) {
			grade = "B";
			if(score >= 85) {
				grade += "+";
			}
		} else if(score >= 70) {
			grade = "C";
			if(score >= 75) {
				grade += "+";
			}
		} else if(score >= 60) {
			grade = "D";
			if(score >= 65) {
				grade += "+";
			}
		} else {
			grade = "F";
		}
		
		System.out.printf("당신의 점수는 %d점이고 등급은 %s입니다.", score, grade);
	}
}
