package com.kh.example.education.model.vo;

public class Academy {
	private String academy;
	private String acaAddr;
	private String name;
	private char classroom;
	
	public Academy() {}
	public Academy(String academy, String acaAddr,
				String name, char classroom) {
		this.academy = academy;
		this.acaAddr = acaAddr;
		this.name = name;
		this.classroom = classroom;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getAcaAddr() {
		return acaAddr;
	}
	public void setAcaAddr(String acaAddr) {
		this.acaAddr = acaAddr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getClassroom() {
		return classroom;
	}
	public void setClassroom(char classroom) {
		this.classroom = classroom;
	}
	
	//public String inform() {
	//	return academy + " " + acaAddr + " " + name + " " + classroom;
	//}
	
	@Override
	public String toString() {
		return academy + " " + acaAddr + " " + name + " " + classroom;
	}
}
