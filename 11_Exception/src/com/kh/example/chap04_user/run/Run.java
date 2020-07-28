package com.kh.example.chap04_user.run;

import com.kh.example.chap04_user.controller.MyExceptionController;

public class Run {
	public static void main(String[] args) {
		MyExceptionController mec = new MyExceptionController();
		mec.inputAge();
	}
}
