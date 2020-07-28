package com.kh.example.chap04_user.controller;

import java.util.Scanner;
import com.kh.example.chap04_user.model.exception.MyException;

public class MyExceptionController {
	Scanner sc = new Scanner(System.in);
	
	public void inputAge() {
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		try {
			checkAge(age);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void checkAge(int age) throws MyException {
		if(age < 19) {
			throw new MyException("만 19세 미만은 입장이 불가능합니다ㅠㅜ");
		} else {
			System.out.println("즐겨운 관람되세세요^^");
		}
	}

}
