package com.kh.variable;

public class C_Cast {
	public void rule1() {
		int num = 'a';
		//4byte ← 2byte (자동 형변환)
		System.out.println("num: " + num);
		
		char c = 65;
		System.out.println("c: " + c);
		
		char c2 = (char)num;
		System.out.println("c: " + c2);
		
		int num2 = -97;
		char c3 = (char)num2;

		System.out.println("c3: " + c3);
	}
	
	public void rule2() {
		int iNum = 10;
		long lNum = 100L;
		
		//  int sum = iNum + lNum;
		//             int + long
		//(자동 형변환)long + long = long (type mismatch error)
		
		//방법1. 수행결과를 int로 강제 형변환
		int sum1 = (int)(iNum + lNum);
		System.out.println("sum1 : " + sum1);
		
		//방법2. long형의 값을 int로 강제 형변환
		int sum2 = iNum + (int)lNum;
		System.out.println("sum2 : " + sum2);
				
		//방법3. 결과 자료형을 long으로 받기
		long sum3 = iNum + lNum;
		System.out.println("sum3 : " + sum3);
	}
}
