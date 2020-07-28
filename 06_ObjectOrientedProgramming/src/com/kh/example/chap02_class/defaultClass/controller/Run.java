package com.kh.example.chap02_class.defaultClass.controller;

public class Run {

	public static void main(String[] args) {
		
		DefaultClass dc = new DefaultClass();
		dc.test();
		//default 클래스는 같은 패키지 안에 있어야 불러올 수 있음
		//같은 패키지 안에 있기 때문에 improt도 필요 없음
	}

}
