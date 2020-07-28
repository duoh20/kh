package com.kh.variable;

public class D_Print {
	public void printlnExample() {
		System.out.println("안녕하세요");
		System.out.println("반갑습니다");
		System.out.println(); //줄바꿈만 하는 것
	}
	
	public void printExample() {
		System.out.print("안녕하세요");
		System.out.print("반갑습니다");	
		/*
		 * System.out.print(); //error
		 * The method print(boolean) in the type PrintStream is not applicable for the arguments ()
		 */
	}
	
	public void printfExample() {
		String str1 = "안녕하세요";
		String str2 = "반갑습니다";
		
		//System.out.printf(format, args)
		//                  포맷터 지정
		//                          포맷터에 맞게 값 대입
		
		System.out.printf("%s, 만나서 %s.\n", str1, str2);
		//                               줄바꿈
		System.out.printf("%s, 김과장입니다! \n", str2);
		
		//미니 문제
		//안녕하세요, 저는 20살 박신우 강사입니다. 만나서 반갑습니다.
		int age = 20;
		String name = "박신우";
		String job = "강사";
		
		System.out.println(str1 + ", 저는 " + age + "살 " + name + " " + job + "입니다. 만나서"+ str2 + ".");
		System.out.printf("%s, 저는 %d살 %s %s 입니다. 만나서 %s.", str1, age, name, job, str2);
	}
}
