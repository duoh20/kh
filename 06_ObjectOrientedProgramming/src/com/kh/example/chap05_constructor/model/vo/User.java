package com.kh.example.chap05_constructor.model.vo;

import java.util.Date;

public class User {
	private String userId; //캡슐화가 OOP의 핵심, 필드 선언 시 private을 명시하자
	private String userPwd;
	private String userName;
	private Date enrollDate;
	
	//생성자의 사용 목적
	//		1. 객체 생성
	//		2. 매개변수로 전달 받은 값으로 필드 초기화
	
	//생성자 사용 시 주의 사항
	//		1. 반드시 이름이 클래스와 동일(대/소문자 구분)
	//		2. 반환형이 존재하지 않음
	
	//기본 생성자
	//		아무런 매개 변수가 없는 생성자
	//		JVM이 기본적으로 생성해줌
	//		단, 매개변수 있는 생성자를 만든다면 자동 생성이 되지 않음
	//		따라서 반드시 처음에 만들어주고 시작
	public  User() {}
	
	//매개변수 있는 생성자
	//		객체 생성과 필드 초기화, 두 가지 목적으로 사용
	//		같은 이름의 생성자를 만들려고 하는 경우 오버로딩 적용 되게 만들어 사용
	public User(String userId, String userPwd, String userName, Date enrollDate) {
		//this.userId = userId;
		//this.userPwd = userPwd;
		//this.userName = userName;
		this(userId, userPwd, userName);
		this.enrollDate = enrollDate;
		//this.를 쓰지 않는다면?
		//	전역변수보다 지역변수의 우선 순위가 더 높아서
		//	지역변수에 지역변수를 대입하는 것으로 인지하고
		//	The assignment to variable userPwd has no effect 에러가 발생		
	}
	
	//오버로딩, 위 User() 생성자와 매개 변수 종류와 순서는 같지만, 갯수가 다르므로 오버로딩 가능
	public User(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}

	public void inform() {
		System.out.println(userId + ", " + userPwd + ", " + userName + ", " + enrollDate);
	}

}
