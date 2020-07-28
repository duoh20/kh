package com.kh.example.chap04_field.model.vo;

public class Product {
	private String name = "초코파이";
	private String brand = "오리온";
	private static int price = 2900;
	
	//인스턴스 블럭
	{
		name = "칸쵸";
		brand = "롯데";
		price = 1500;
	}

	//static(클래스) 블럭
	static {
		//name = "비빔면"; //name 전역 변수에 static 예약어가 없어서 에러 남
		//brand = "팔도";  //brand 전역 변수에 static 예약어가 없어서 에러 남
		price -= 100; // price -100한 값을 담아서 price가 2800이 되더라도, 인스턴스블록에 의해 객체 생성시 마다 1500원으로 초기화됨
	}

	public void info() {
		System.out.println(name + " " +  brand + " " + price);
	}
}
