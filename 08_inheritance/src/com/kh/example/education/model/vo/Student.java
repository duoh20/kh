package com.kh.example.education.model.vo;

public class Student extends Academy {
	//private String academy;
	//private String acaAddr;
	//private String name;
	//private char classroom;
	private String course;
	private int money;
	
	public Student() {}
	public Student(String academy, String acaAddr,
				String name, char classroom, String course, int money) {
		//this.academy = academy;
		//this.acaAddr = acaAddr;
		//this.name = name;
		//this.classroom = classroom;
		super(academy, acaAddr, name, classroom);
		this.course = course;
		this.money = money;
	}
	
	//Academy 클래스에 이미 getter, setter가 있으므로 주석 처리
//	public String getAcademy() {
//		return academy;
//	}
//	public void setAcademy(String academy) {
//		this.academy = academy;
//	}
//	public String getAcaAddr() {
//		return acaAddr;
//	}
//	public void setAcaAddr(String acaAddr) {
//		this.acaAddr = acaAddr;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public char getClassroom() {
//		return classroom;
//	}
//	public void setClassroom(char classroom) {
//		this.classroom = classroom;
//	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	//public String inform() {
	//	return super.getAcademy() + " " + super.getAcaAddr() + " "
	//		 + super.getName() + " " + super.getClassroom() + " "
	//		 + course + " " + money;
	//	//private 맴버 변수는 접근이 불가능하므로 getter로 가져와야함
	//}
	
	//@Override //Overriding했다는 어노테이션(자동 완성 단축키 ctrl + space)
	//public String inform() {
	//	return super.inform() + course + " " + money;
	//}
	
	@Override
	public String toString() {
		return super.toString()+ course + " " + money;
	}
}
