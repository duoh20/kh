package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice1 {
	
	Scanner sc = new Scanner(System.in);

	public void practice1(){
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("성별을 입력하세요(남/여) : ");
		String sexStr = sc.nextLine();
		char sex = sexStr.charAt(0);
		
		System.out.print("나이를 입력하세요 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.print("키를 입력하세요(cm) : ");
		float height = Float.parseFloat(sc.nextLine());
		
		System.out.print("키 " + height + "cm인 " + age + "살 " + sex + "자 " + name + "님 반갑습니다^^");
		
	}
}
