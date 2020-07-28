package com.kh.example.chap01_poly.test.model.vo;

public class Parent {
	public int x;
	public int y;
	
	public Parent() {}
	public Parent(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void printParent() {
		System.out.println("나 부모야");
	}
	
	public void print() {
		System.out.println("나 부모야!!!!!!!");
	}
	
}