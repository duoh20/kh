package com.kh.practice.charCheck.view;

import java.util.Scanner;

import com.kh.practice.charCheck.controller.CharCheckController;
import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterMenu {
	Scanner sc = new Scanner(System.in);
	CharCheckController ccc = new CharCheckController();
	
	public void menu() {
		System.out.print("문자열 : ");
		String s = sc.nextLine();
		
		try {
			int count = ccc.countAlpha(s);
			System.out.printf("\'%s\'에 포함된 영문자 개수 : %d", s, count);
		} catch (CharCheckException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
