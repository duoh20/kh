package com.kh.homework.shape.view;

import java.util.Scanner;
import com.kh.homework.shape.controller.ShapeController;

public class ShapeMenu {
	Scanner sc = new Scanner(System.in);
	ShapeController spr = new ShapeController();
	
	public void inputMenu() {
		System.out.println("===== 도형 프로그램 =====");
		System.out.println("3. 삼각형");
		System.out.println("4. 사각형");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 3 : triangleMenu(); break;
		case 4 : squareMenu(); break;
		case 9 : System.out.println("프로그램을 종료합니다."); break;
		default: System.out.println("잘못된 번호입니다. 다시 입력하세요.");
		}
	}
	
	public void triangleMenu() { //타입은 3
		System.out.println("===== 삼각형 =====");
		System.out.println("1. 삼각형 면적");
		System.out.println("2. 삼각형 색칠");
		System.out.println("3. 삼각형 정보");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 1 : inputData(3, menuNum); break;
		case 2 : inputData(3, menuNum); break;
		case 3 : inputData(3, menuNum); break;
		case 9 : System.out.println("메인으로 돌아갑니다."); inputMenu(); break;
		default: System.out.println("잘못된 번호입니다. 다시 입력하세요.");
		}
	}
	
	public void squareMenu() { //타입은 4
		System.out.println("===== 사각형 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 면적");
		System.out.println("3. 사각형 색칠");
		System.out.println("4. 사각형 정보");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 1 : inputData(4, menuNum); break;
		case 2 : inputData(4, menuNum); break;
		case 3 : inputData(4, menuNum); break;
		case 4 : inputData(4, menuNum); break;
		case 9 : System.out.println("메인으로 돌아갑니다."); inputMenu(); break;
		default: System.out.println("잘못된 번호입니다. 다시 입력하세요.");
		}
	}
	
	public void inputData(int type, int menuNum) {
		if(menuNum == 1) {
			System.out.print("높이 : ");
			double height = Double.parseDouble(sc.nextLine());
			System.out.print("너비 : ");
			double width = Double.parseDouble(sc.nextLine());
			
			System.out.println("면적 : " + spr.calcPerimeter(type, height, width));
		}

	}
	
	public void printlnform(int type) {
		System.out.println(spr.paint());
	}
}
