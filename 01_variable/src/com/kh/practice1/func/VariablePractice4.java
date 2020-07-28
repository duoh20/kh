package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice4 {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice4(){
	
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		char firstLetter = str.charAt(0);
		char secondLetter = str.charAt(1);
		char thirdLetter = str.charAt(2);
		
		System.out.println("첫 번째 문자 : " + firstLetter);
		System.out.println("두 번째 문자 : " + secondLetter);
		System.out.println("세 번째 문자 : " + thirdLetter);
	}
}
