package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		r = new Rectangle(x, y, height, width);
		return r + " / " + width * height; //객체 r의 toStrung() 정보가 나옴
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r = new Rectangle(x, y, height, width);
		return  r + " / " + 2 * (width + height); //곱하기는 ()으로 묶지 않아도 됨
	}
}
