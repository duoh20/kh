package com.kh.practice.token.controller.TokenController;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {}
	
	public String AfterToken(String str) {
		StringTokenizer st = new StringTokenizer(str, " ");
		String str2 = "";
		while(st.hasMoreTokens()){
			str2 += st.nextToken();
		}
		return str2;
	}
	
	public String firstCap(String input) {
		String str = "";
		char firstLetter = input.toUpperCase().charAt(0);
		str = firstLetter + input.substring(1);
		return str;
	}
	
	public int findChar(String input, char one) {
		String[] inputedString = new String[input.length()];
		for(int i = 0; i < inputedString.length; i++) {
			inputedString[i] = input.substring(i, i+1);
		}
		
		int count = 0;
		String str = "" + one;
		for(int i = 0; i < inputedString.length; i++) {
			if(inputedString[i].equalsIgnoreCase(str)) {
				count++;
			}
		}
		return count;
	}
}
