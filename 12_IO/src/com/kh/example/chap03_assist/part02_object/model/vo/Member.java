package com.kh.example.chap03_assist.part02_object.model.vo;

import java.io.Serializable; 

public class Member implements Serializable {
	//직렬화 가능한 클래스임을 명시하기 위해 Serializable 인터페이스를 명시하고,
	//serialVersionUID를 생성한다.
	//Serializable은 마크 인터페이스로 기능 구현이 아니라 클래스의 특성을 알려주는 역할이다.
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private int age;
	private char gender;
	private transient double point;
	
	public Member() {};
	
	public Member(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
	public Member(String userId, String userPwd, String userName,
				String email, int age, char gender, double point) {
		this(userId, userPwd, userName);
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.point = point;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String toString() {
		return userId + userPwd + userName + email + age + gender + point;
	}
}
