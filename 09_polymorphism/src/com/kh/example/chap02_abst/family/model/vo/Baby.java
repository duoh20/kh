package com.kh.example.chap02_abst.family.model.vo;

public class Baby extends Family {
	public Baby() {}
	public Baby(String name, double weight, int health) {
		super(name, weight, health);
	}
	
	@Override
	public void eat() {
		super.setWeight(super.getWeight() + 3);
		super.setHealth(super.getHealth() + 1);
	}
	
	@Override
	public void sleep() {
		super.setHealth(super.getHealth() + 3);
	}
	
	
}
