package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴 번호를 입력하세요 : ");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1: System.out.println("입력 메뉴입니다."); break;
		case 2: System.out.println("수정 메뉴입니다."); break;
		case 3: System.out.println("조회 메뉴입니다."); break;
		case 4: System.out.println("삭제 메뉴입니다."); break;
		case 7: System.out.println("프로그램이 종료됩니다."); break;
		default: System.out.println("잘못 입력하였습니다.");
		}
	}
	
	public void practice2() {
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num > 0) {
			if(num % 2 == 0) {
				System.out.println("짝수다");
			} else {
				System.out.println("홀수다");
			}
		} else {
			System.out.println("양수만 입력해주세요.");
		}
	}
	
	public void practice3() {
		System.out.print("국어점수 : ");
		int korean = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		System.out.print("영어점수 : ");
		int english = sc.nextInt();
		
		int sum = korean + math + english;
		double average = sum/3;
		
		if (korean >= 40 && math >= 40 && english >= 40 && average >= 60) {
			System.out.println("국어 : " + korean);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + english);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + average);
			System.out.println("축하합니다, 합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
	}
	
	public void practice4() {
		System.out.print("1~12 사이의 정수 입력 : ");		
		int month = sc.nextInt();
		switch(month) {
		case 11: case 12: case 1: System.out.println(month + "월은 겨울입니다."); break;
		case 2: case 3: case 4: System.out.println(month + "월은 봄입니다."); break;
		case 5: case 6: case 7: System.out.println(month + "월은 여름입니다."); break;
		case 8: case 9: case 10: System.out.println(month + "월은 가을입니다."); break;
		default: 
		} System.out.println(month + "월은 잘못 입력된 달입니다.");
	}
}
