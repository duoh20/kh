package com.kh.example.chap06_method.model.vo;

import java.util.Scanner;

public class Trainee {
	/*
	 	- name:String
	 	- ACADEMY:String = "KH"
	 	- classRoom:char
	 	- time:String
	 	- score: doble
	 	  ------------(static)
	 	
	 	+ Trainee()
	 	+ Trainee(name: String, classRoom:char, time:String, score:double)
	 	
	 	+ changeName(name:STring):void
	 	+ printName():String
	 	+ getACADEMY():String
	 	+ setClassRoom(classRoom:char)
	 	+ showClassRoom():char
	 */
	
	private String name;
	private final String ACADEMY = "KH";
	private char classRoom;
	private String time;
	private static double score;
	
	public Trainee() {}
	public Trainee(String name, char classRoom, String time, double score) {
		this.name = name;
		this.classRoom = classRoom;
		this.time = time;
		Trainee.score = score;
		//score는 static 영역에서 공유되는 값이므로
		//this.score가 아니라 Trainee.score로 접근한다.
		//this를 사용하면 객체 안에 초기화되기 때문에 static의 의미가 없음!!
		//Trainee 클래스 안의 static 속성을 유지해야하므로 Trainee.score로 접근한다.
	}
	
	//getter와 setter
	//필드 값을 가져오거나 변경하는 메소드
	//임의의 메소드 명으로도 사용할 수 있지만
	//프레임 워크에서 사용하기 위해 일반적으로 사용하는 get / set을 사용하여 메소드를 설정한다
	//public void changeName(String name) {
	//	this.name = name;
	//}
	public void setName(String name) {
		this.name = name;
	}
	
	//public String printName() {
	//	return name;
	//}
	public String getName() {
		return name;
	}
	
	//public String getACADEMY() {
	//	return ACADEMY;
	//}
	public String getACADEMY() {
		return ACADEMY;
	} //ACADEMY는 상수라서 setter는 의미 없음
	
	
	//public void setClassRoom(char classRoom) {
	//	this.classRoom = classRoom;
	//}
	public void setClassRoom(char classRoom) {
		this.classRoom = classRoom;
	}
	
	//public char showClassRoom() {
	//	return classRoom;
	//}
	public char getClassRoom() {
		return classRoom;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public static double getScore() {
		return Trainee.score;
		//The static field Trainee.score should be accessed in a static way
		//static은 객체 생성해서 가져오는 것이 아님!!
	}
	
	public static void setScore(double score) {
		Trainee.score = score;
	}
	//static 변수는 객체를 생성할 필요가 없이 불러올 수 있으므로
	//getter & setter도 static을 붙여서 생성한다.
	
	public String inform() {
		return ACADEMY + " " + name + " 훈련생은 " + classRoom + "반 " + time + "이고, 점수는 " + score + "입니다.";
	}
}
