package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice3() {
		System.out.print("가로 : ");
		double width = sc.nextDouble();
		
		System.out.print("세로 : ");
		double height = sc.nextDouble();
		
		System.out.println("면적 : " + (width * height));
		System.out.println("둘레 : " + ((width + height)*2));
	}
}
