package com.kh.example.practice4.meodel.vo;

public class Student {
	// 인스턴스 변수: 객체를 만들어야 사용할 수 있는 변수(static이 붙지 않음)
	// 클래스 변수: 객체를 만들지 않고 클래스로 접근하여 사용 가능한 변수(static 붙음)
	private static int grade;
	private int classroom;
	private String name;
	private double height;
	private char gender;
	
	//인스턴스 블록: 객체 생성 시 마다 초기화
	//클래스 블록: 프로그램 시작 시 1번만 초기화
	
	{
		classroom = 3;
		name = "김고은";
		height = 160.1;
		gender = '여';
	}

	static {
		grade = 4;
	}
	
	public Student() {}
	
	public void information() {
		System.out.printf("%d학년 %d반 %s(%c)의 키는 %fcm입니다.",
					grade, classroom, name, gender, height);
	}
}
