package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.print("1 이상의 숫자를 입력해주세요. ");		
		}
	}
	
	public void practice2() {
		while(true) {
			System.out.print("1 이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();
			
			if(num > 0) {
				for (int i = 1; i <= num; i++) {
					System.out.print(i + " ");
				}
				return;
			} else {
				System.out.println("1 이상의 숫자를 입력해주세요. ");		
			}
		}
	}
	
	public void practice3() {
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			for(int i = num; i > 0; i--) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
	}
	
	public void practice4() {
		while(true) {
			System.out.print("1 이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();
		
			if(num > 0) {
			for(int i = num; i > 0; i--) {
				System.out.print(i + " ");
				} return;
			} else {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			}
		}
	}
	
	public void practice5() {
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		
		if(num > 0) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i);
				sum += i;
				if(i < num) {
					System.out.print(" + ");
				}
			}
			System.out.println(" = " + sum);
		} else {
			System.out.println("1 이상의 정수를 입력하세요.");
		}		
	}
	
	public void practice6() {
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		int max, min;
		
		if (num1 > num2) {
			min = num2;
			max = num1;
		} else {
			min = num1;
			max = num2;
		}
		
		if(min > 0 && max > 0) {
			for (; min <= max; min++) {
				System.out.print(min + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
	}
	
	public void practice7() {
		
		while(true) {	
			int num1, num2, max, min = 0;
			
			System.out.print("첫 번째 숫자 : ");
			num1 = sc.nextInt();
			System.out.print("두 번째 숫자 : ");
			num2 = sc.nextInt();
			
			if (num1 > 0 && num2 > 0) {
			
				if (num1 > num2) {
					min = num2;
					max = num1;
				} else {
					min = num1;
					max = num2;
				}
			
				for (; min <= max; min++) {
					System.out.print(min + " ");
				}
				return;
			} else {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			}
		}
	}
	
	public void practice8() {
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}
	}
	
	public void practice9() {
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		if (dan > 1 && dan < 10) {
			for(; dan < 10; dan++) {
				System.out.println("=====" + dan + "단 =====");
				for (int i = 1; i < 10; i++) {
					System.out.println(dan + " * " + i + " = " + (dan*i));
				}
			System.out.println();
			}
		} else {
			System.out.println("9 이하의 숫자만 입력해주세요.");
		}
	}
	
	public void practice10() {
		while(true) {	
			System.out.print("숫자 : ");
			int dan = sc.nextInt();
			
			if (dan > 1 && dan < 10) {
				for(; dan < 10; dan++) {
					System.out.println("=====" + dan + "단 =====");
					for (int i = 1; i < 10; i++) {
						System.out.println(dan + " * " + i + " = " + (dan*i));
					}
				System.out.println();
				}
			return;
			} else {
				System.out.println("9 이하의 숫자만 입력해주세요.");
			}
		}
	}
	
	public void prctice11() {
		System.out.print("시작 숫자 : ");
		int start = sc.nextInt();
		System.out.print("공차 : ");
		int allowance  = sc.nextInt();
		
		int sum = start;

		for(int i = 0; i <10; i++) {
			System.out.print(sum + " ");
			sum += allowance;
		}
	}

	public void practice12() {
		while(true) {
			System.out.print("연산자(+, -, *, /, %) : ");
			String op = sc.next();

			if (!op.equals("exit")) {
				if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("%")) {
					System.out.print("정수1 : ");
					int num1 = sc.nextInt();
					System.out.print("정수2 : ");
					int num2 = sc.nextInt();

					switch(op) {
					case "+": System.out.println(num1 + " + " + num2 + " = " + (num1+num2)); break;
					case "-": System.out.println(num1 + " - " + num2 + " = " + (num1-num2)); break;
					case "*": System.out.println(num1 + " * " + num2 + " = " + (num1*num2)); break;
					case "/":
						if(num2 == 0) {
							System.out.println("0으로 나눌 수 없습니다.");
						} else {
							System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
						} break;
					case "%": System.out.println(num1 + " % " + num2 + " = " + (num1%num2)); break;
					}
				} else {
					System.out.println("없는 연산입니다. 다시 입력해주세요.");
				}
			} else {
				System.out.println("프로그램을 종료합니다."); return;
			}
		}
	}

	public void practice13() {
		System.out.print("정수 입력 : ");
		int row = sc.nextInt();

		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice14() {

		System.out.print("정수 입력 : ");
		int row = sc.nextInt();

		for (int i = 1; i <= row; i++) {
			for (int j = i; j <= row; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}	
}