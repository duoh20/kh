package com.kh.example.chap02_abst.family.model.vo;

public class Family {
	private String name;
	private double weight;
	private int health;

	public Family() {}
	public Family(String name, double weight, int health) {
		this.name = name;
		this.weight = weight;
		this.health = health;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	@Override
	public String toString() {
		return name + ", " + weight + ", " + health;
	}
	
//	//추상메서드 선언
//	public abstract void eat();
//	public abstract void sleep();
//	//클래스와 메소드에 abstract 선언해야함
//	//클래스에 abstract 선언하지 않으면
//	//The type Family must be an abstract class to define abstract methods 에러 발생
}
