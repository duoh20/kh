package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {

	public static void main(String[] args) {

		Member m = new Member();
		m.changeName("김수현");
		m.printName();
	}

}
