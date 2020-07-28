package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice1 {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("문자 : ");
		String str = sc.nextLine();
		char letter = str.charAt(0);
	
		System.out.println(letter + " unicode : " + (int)letter);
	}
}
