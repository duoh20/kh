package com.kh.practice.charCheck.controller;

import java.io.IOException;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharCheckController {
	public CharCheckController() {}
	
	public int countAlpha(String s) throws CharCheckException{
		int count = 0;
		
		if(s.contains(" ")) {
			throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");			
		} else {
			char[] cArr = new char[s.length()];
			for(int i = 0; i < cArr.length; i++) {
				cArr[i]= s.charAt(i);
			}
			
			for(int j = 0; j < cArr.length; j++) {
				if(64 < cArr[j] && cArr[j] < 123) { //아스키 값으로 영대 대문자 65~90, 소문자 97~122
					count++;
				}
			}
		}
		return count;
	}
}
