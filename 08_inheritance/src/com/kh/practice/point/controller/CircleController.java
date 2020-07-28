package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		Circle circle = new Circle(x, y, radius);
		return "면적: " + x + ", " + y + ", " + radius + " / " + (Math.PI * radius * radius);
	}

	public String calcCircum(int x, int y, int radius) {
		Circle circle = new Circle(x, y, radius);
		return "둘레: " + x + ", " + y + ", " + radius + " / " + (Math.PI * radius * 2);
	}
}
