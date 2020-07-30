package com.kh.example.chap01_String.controller;

import java.util.StringTokenizer;

public class StringController {
	
	public void method1() {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		
		System.out.println("str1과 str2의 주소는 같은가? " + (str1 == str2)); 
		System.out.println("str1과 str3의 주소는 같은가? " + (str1 == str3));
		
		//hashCode()
		//Object 안에 있는 메소드
		//str1,set2,set3에 담긴 문자가 모두 "java"로 같아서
		//hashCode()에 담길 char[] value "java"로 같기 때문에 동일한 hashCode()를 리턴한다.
		//비교할 요소에 담긴 문자열이 같으면(즉 String.equals()가 true면) hashCode()가 리턴하는 integer 값은 동일함
		System.out.println("Str1의 hashCode : " + str1.hashCode());
		System.out.println("Str2의 hashCode : " + str2.hashCode());
		System.out.println("Str3의 hashCode : " + str3.hashCode());
		
		//System클래스의 identityHashCode()
		System.out.println("Str1의 실주소값 : " + System.identityHashCode(str1));
		System.out.println("Str2의 실주소값 : " + System.identityHashCode(str2));
		System.out.println("Str3의 실주소값 : " + System.identityHashCode(str3));
		
		str2 += "oracle";
		System.out.println("Str1의 hashCode : " + str1.hashCode());
		System.out.println("Str2의 hashCode : " + str2.hashCode());
		System.out.println("Str3의 hashCode : " + str3.hashCode());
		
		System.out.println("Str1의 실주소값 : " + System.identityHashCode(str1));
		System.out.println("Str2의 실주소값 : " + System.identityHashCode(str2));
		System.out.println("Str3의 실주소값 : " + System.identityHashCode(str3));		
	}
	
	public void method2() {
		//StringBuffer
		//String을 이용해서 어떤 문자열 작업할 때 String 클래스 객체 생성을 통해서 하거나 리터럴로 작업했었음
		//계속해서 문자열 갑을 변경해야하는 경우 String 클래스의 특징인 불변 떄문에
		//값이 새로 생기고 참조 위치만 바꿔주기 때문에 가비지 컬렉터가 계속 지워한다는 단점이 있음
		//변경이 적고 읽기만 많은 경우에는 불변 클래스인 String 클래스가 더 용이
		
		//변경해햐하는 값이 많은 경우에는 StringBuffer나 StringBuilder로 하는 게 나음
		//StringBuffer나 StringBuilder는 변경과 저장을 위한 메모리 공간(버퍼)를 내부에 지니는데
		//처음에는 16개 문자를 저장할 수 있는 버퍼가 생성되고 문자가 저장됨에 따라 자동으로 증가함
		//초기 버퍼 크기를 지정할 수도 있고 문자열의 길이보다 16개의 문자를 더 저장할 수 있음
		//두 클래스는 다 동일하지만 동기화가 되느냐 안되느냐의 차이만 있음 (스레드 safe)
		StringBuffer buffer1 = new StringBuffer();
		System.out.println("초기 buffer1의 수용량 : " + buffer1.capacity());
		System.out.println("buffer1에 들어있는 실제 값의 길이 : " + buffer1.length());
		
		System.out.println();
		StringBuffer buffer2 = new StringBuffer(100); //초기 버퍼 크기 지정 예시
		System.out.println("buffer2의 수용량 : " + buffer2.capacity());
		System.out.println("buffer2에 들어있는 실제 값의 길이 : " + buffer2.length());
		
		System.out.println();
		StringBuffer buffer3 = new StringBuffer("abc"); //문자열의 길이보다 16개의 문자를 더 저장할 수 있음 예시 (기본 16 + 생성시 추가한 문자열 길이 3 = 19)
		System.out.println("buffer3의 수용량 : " + buffer3.capacity());
		System.out.println("buffer3에 들어있는 실제 값의 길이 : " + buffer3.length());
		
		System.out.println();
		System.out.println("buffer3의 실주소값 : " + System.identityHashCode(buffer3));
		
		//append(String str): String
		//append의 반환값은 StringBuffer임
		buffer3.append("abc");
		System.out.println("abc 추가한 후의 buffer3 : " + buffer3);
		System.out.println("abc 추가한 후의 buffer3 용량 : " + buffer3.capacity());
		System.out.println("abc 추가한 후의 buffer3 길이 : " + buffer3.length());
		buffer3.append("def");
		System.out.println("abc, def 추가한 후의 buffer3 : " + buffer3);
		System.out.println("abc, def 추가한 후의 buffer3 용량 : " + buffer3.capacity()); //capacity는 19를 넘지 않았기 때문에 수용량은 계속 19
		System.out.println("abc, def 추가한 후의 buffer3 길이 : " + buffer3.length());
		
		//method chaining: 메소드가 체인처럼 연결되어있음
		//반환값이 동일하다면 메소드를 이어서 붙일 수 있음
		//buffer3.append("1").append("2");
		//------------------- = 반환 타입이 StringBuffer
		//--------------------------------반환 타입이 StringBuffer
		
		//insert(int offset, String str):StringBuffer
		buffer3.insert(2, "zzz");
		System.out.println("zzz 추가한 후의 buffer3 : " + buffer3);
		
		//reverse
		buffer3.reverse();
		System.out.println("reverse 후의 buffer3 : " + buffer3);
		
		//delete(int start, int end):StringBuffer
		//start <= index < end 시작값 포함 마지막값 포함 안함
		buffer3.delete(2, 5);
		System.out.println("delete 후의 buffer3 : " + buffer3);
		
		StringBuffer sb = new StringBuffer("abc");
		sb = sb.append("zzz").insert(2,  "yy").reverse().delete(1,  3);
		//              abczzz   →  abyyczzz → zzzcyyba → zcyyba 
		System.out.println(sb);
	}
	
	public void method3() {
		String str = "Hello World";
		System.out.println("str : " + str);
		
		//1.charAt(0)
		
		//2.concat(str):String
		//매개변수에 들어온 String을 마지막에 붙여줌
		String concatStr = str.concat("!!!");
		System.out.println("concatStr : " + concatStr);
		str += "!!!";
		System.out.println("+= : " + concatStr);
		
		//3.equals()
		
		//4. substring(int beginIndex) //시작하는 값부터 끝까지 다 나옴
		//	 subString(int beginIndex, int endIndex) //시작과 끝을 지정해서 나옴
		//beginIndex <= index < endIndex
		System.out.println("str.substring(6) : " + str.substring(6));
		System.out.println("str.substring(6) : " + str.substring(0, 4));
		
		//5. toUpperCase, toLowerCase
		System.out.println(str.toUpperCase()); //모두 대문자로 변경
		System.out.println(str.toLowerCase()); //모두 소문자로 변경
		//사용 예제: 나가려면 exit를 입력하세요
		//조건식을 if(str.
		
		//6.equlasIgnoreCase
		//대문자인지 소문자인지 무시하고 비교함
		String str2 = "Wonderful";
		String str3 = "wonderful";
		System.out.println(str2.equals(str3));
		System.out.println(str2.equalsIgnoreCase(str3));
		
		//7.trim()
		//문자열 앞뒤의 빈 공간을 제거해주는 메소드
		String str4 = "      Java";
		String str5 = "Java      ";
		String str6 = "   Java   ";
		System.out.println(str4 + " : " + str4.trim());
		System.out.println(str5 + " : " + str5.trim() + "!");
		System.out.println(str6 + " : " + str6.trim());
		
		//8.split()
		//매개 변수를 구분 인자로 사용하여 쪼개 String[]에 넣음
		String splitStr = "Java, Orcle, JDBC, Front, Server, Framework";
		String[] strArr = splitStr.split(", ");
		for(String elem:strArr) {
			System.out.print(elem + "/");
		}
	}
	
	public void method4() {
		String str = "Java, Orcle, JDBC, Front, Server, Framework";
		StringTokenizer st = new StringTokenizer(str, ", ");
		System.out.println(st.countTokens()); //토큰 개수 반환
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		String str2 = "Apple,Banana_Cream*Dssert#Egg Fruit";
		StringTokenizer st2 = new StringTokenizer(str2, ",_*# ");
		while(st2.hasMoreTokens()) { //boolean 반환, 다음 토큰이 있는지 판단
			System.out.println(st2.nextToken());
		}
	}
}

