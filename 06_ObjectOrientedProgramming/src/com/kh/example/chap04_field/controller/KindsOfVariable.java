package com.kh.example.chap04_field.controller;

public class KindsOfVariable { //← 클래스 영역 시작
	
	//클래스 영역에 작성하는 변수: 필드(Field)
	//필드 == 맴버 변수 == 맴버 필드 == 전역 변수
	private int globalNum;
	
	public void method1(int num) { //← 메소드 영역 시작
		//              ------- 매개 변수(지역변수)
		
		int localNum; //지역 변수
		//System.out.println(localNum);
		//The local variable localNum may not have been initialized
		//지역 변수는 선언 외에 다시 사용하기 위해서는 반드시 초기화가 되어있어야함
	
		System.out.println(num);
		//num은 매개 변수로 호출할 때 값을 넘겨 받기 때문에 초기화하지 않아도 됨
		
		System.out.println(globalNum);
		//필드에 glovalNum이 선언되어 있어서 사용 가능
	} //← 메소드 영역 끝
	
	public void method2() {
		//System.out.println(localNum); //지역 변수는 해당 지역(블록 안)에서만 사용 가능
		System.out.println(globalNum); //필드에 선언되어 있어서 범위 내에 속함 
	}
} //← 클래스 영역 끝
