package com.kh.example.chap04_field.run;

import com.kh.example.chap04_field.model.vo.Product;

public class Run {

	public static void main(String[] args) {

		Product p1 = new Product();
		p1.info();
		
		Product p2 = new Product();
		p2.info();

		//p1~2 객체의 초기값 설정 step ::
		//	JVM에서 맴버 변수에 타입별 기본 값 저장
		//	필드에 명시한 값이 덮여 씌여짐
		//	static 초기화블럭 설정 값이 덮여 씌어짐 
		//	실행 클래스에서 객체를 생성할 때마다 초기화블럭에 설정한 값이 씌여짐
	}

}
