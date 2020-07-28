package com.kh.example.chap02.loope;

import java.util.Scanner;

public class C_DoWhile {

	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		//키보드로 문자열 값을 입력 받아 exit가 들어올 때까지 출력 반복 실행
		
		//1. while
		//String str = ""; //String을 기본값인 null로 초기화하면 NullPointerException 발생
		//while(!str.equals("exit")) { //str에 비교할 값이 없어서 equals() 불가
		//System.out.print("문자열 입력 : ");
		//str = sc.nextLine();
		//System.out.println("내가 입력한 문자열 : " + str);
		//}
		
		//2. do-while
		String str = null; //do는 조건을 보지않고 실행함, 23 line에 의해 입력된 값이 str에 저장되므로 에러 발생 안함
		do {
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();
			System.out.println("내가 입력한 문자열 : " + str);
		} while(!str.equals("exit"));
	}
}
