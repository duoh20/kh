package com.kh.example.chap03.branch;

import java.util.Scanner;

public class A_Break { //break문은 가장 가까운 반복문을 나감

	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		//문자열을 입력 받아 글자 개수를 출력하는 프로그램
		//end가 입력되면 반복 종료
		
		//1. do-while 사용
		//String user = null;
		//do {
		//	System.out.print("문자열 입력 : ");
		//	user = sc.nextLine();
		//	System.out.println("글자 수 : " + user.length());
		//} while (!str.equals("end"));
		
		//2. break문 사용
		do {
			System.out.print("문자열 입력 : ");
			String user = sc.nextLine();
			if(user.equals("end")){
				break;
			}
			System.out.println("글자 수 : " + user.length());
		} while (true);
	}
}
