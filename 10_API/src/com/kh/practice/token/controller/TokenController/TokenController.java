package com.kh.practice.token.controller.TokenController;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {}
	
	public String afterToken(String str) {
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
		//나의 답안, 대문자만 받아와서 나머지 문자는 substring으로 가져옴
		//str = firstLetter + input.substring(1);
		//풀이
		str += firstLetter; //char형을 String형에 넣어야하므로 + 연산자 사용  
		for(int i = 1; i < input.length(); i++) { //input의 length 만큼 돌려서 두번째 글짜부터 순차적으로 가져옴
			str += input.charAt(i);
		}
		return str;
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		
		//나의 답안, 한 문자씩 String 배열에 담아서 한 문자씩 one과 비교했다.
//		String[] inputedString = new String[input.length()];
//		for(int i = 0; i < inputedString.length; i++) {
//			inputedString[i] = input.substring(i, i+1);
//		}
//		
//		//equalsIgnoreCase를 사용하려고 one을 String으로 바꿨다.
//		String str = "" + one;
//		for(int i = 0; i < inputedString.length; i++) {
//			if(inputedString[i].equalsIgnoreCase(str)) {
//				count++;
//			}
//		}
		
		//풀이
		//단, 아래 코드는 대소문자를 구분해서 count 한다
		for(int i = 0; i <input.length(); i++) {
			if(one == input.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
