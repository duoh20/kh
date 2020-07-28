package com.kh.example.chap03.branch;

public class B_Continue {
	//반복문 안에서만 사용 가능
	//continue문 아래의 내용을 실행하지 말고 다음 단계로 건너 뛰라는 의미
	
	public void method1() {
		//1~100의 정수 합계 출력, 단 4의 배수는 빼고 계산
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {			
			if(i % 4 == 0){ 
				continue;
			}
			System.out.print(i + " ");
			sum += i;
		}
		
	System.out.println();
	System.out.println("sum : " + sum);
	}
	
	public void method2() {
		//짝수 단, 짝수 수는 뺀 구구단 출력
		for (int i = 2; i < 10; i++) {
			System.out.println("====== " + i +"단 ======");
				for(int j = 1; j < 10; j++) {
					if(i % 2 == 0 || j % 2 == 0) {
						continue;
					}
				System.out.println( i + " * " + j + " = " + (i * j));
				}
			System.out.println();
		}
	}	
}
