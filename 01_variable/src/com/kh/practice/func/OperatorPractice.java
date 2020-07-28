package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("정수 : ");
		int num = sc.nextInt();
		String result = (num > 0) ? "양수다." : "양수가 아니다.";
		
		System.out.println(result);
	}
	
	public void practice2() {
		System.out.print("정수 : ");
		int num = sc.nextInt();
		String result = (num == 0) ? "0이다." : (num > 0) ? "양수다." : "음수다.";
		
		System.out.println(result);
	}
	
	public void practice3() {
		System.out.print("정수 : ");
		int num = sc.nextInt();
		String result = (num == 0) ? "0이다." : (num%2 == 0) ? "짝수다." : "홀수다.";
		
		System.out.println(result);
	}

	public void practice4() {
		System.out.print("인원수 : ");
		int people = sc.nextInt();
		System.out.print("사탕수 : ");
		int candy = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + (candy/people));
		System.out.println("남는 사탕 개수 : " + (candy%people));
	}
	
	public void practice5() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		System.out.print("반(숫자만) : ");
		int classNum= sc.nextInt();
		System.out.print("번호(숫자만) : ");
		int number = sc.nextInt();
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		String genderResult = (gender == 'M' || gender == 'm') ? "m" : "여학생";
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();
		
		System.out.println(grade + "학년 " + classNum+ "반 " + number + "번 " + name + " " +  genderResult + "의 성적은 " + score + "이다." );
	}
	
	public void practice6() {
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		String result = (age > 19) ? "성인" : (age < 13) ? "어린이" : "청소년";
		System.out.println(result);
	}

	public void practice7() {
		System.out.print("국어 : ");
		int korean = sc.nextInt();
		System.out.print("영어 : ");
		int english = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int sum = korean + english + math;
		double average = sum/3.0;
		
		String result = (korean > 39 && english > 39 && math > 39&& average >= 60) ? "합격" : "불합격";
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + average);
		System.out.println(result);
	}
	
	public void practice8() {
		System.out.print("주민번호를 입력하세요(-포함) : ");
		String id = sc.nextLine();
		
		char gender = id.charAt(7);
		String result = (gender != '1' && gender != '2' && gender != '3'&& gender != '4') ? "주민번호를 다시 확인해주세요." : (gender == '1'&& gender != '3') ? "남자" : "여자";
 
		System.out.println(result);
	}
	
	public void practice9() {
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력 : ");
		int num3 = sc.nextInt();
		
		boolean result = (num3 > num2 || num3 <= num1) ? true : false;
		System.out.println(result);
	}
	
	public void practice10() {
		System.out.print("입력1 : ");
		int num1 = sc.nextInt();
		System.out.print("입력2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력3 : ");
		int num3 = sc.nextInt();
		
		boolean result = (num1 == num2 && num1 == num3 && num2 ==num3) ? true : false;
		System.out.println(result);
	}
	
	public void practice11() {
		
		System.out.print("A사원의 연봉 : ");
		int incomeA = sc.nextInt();
		double incentiveA = incomeA * 1.4;
		
		System.out.print("B사원의 연봉 : ");
		int incomeB = sc.nextInt();
		double incentiveB = incomeB* 1;
		
		System.out.print("C사원의 연봉 : ");
		int incomeC = sc.nextInt();
		double incentiveC = incomeC * 1.15;
	
		String resultA = (incentiveA >=3000) ? "3000 이상" : "3000 미만";
		String resultB = (incentiveB >=3000) ? "3000 이상" : "3000 미만";
		String resultC = (incentiveC >=3000) ? "3000 이상" : "3000 미만";
	
		System.out.println();
		System.out.println("A사원의 연봉/연봉+a : " + incomeA + "/"+ incentiveA);
		System.out.println(resultA);
		System.out.println("B사원의 연봉/연봉+a : " + incomeB + "/"+ incentiveB);
		System.out.println(resultB);
		System.out.println("C사원의 연봉/연봉+a : " + incomeC + "/"+ incentiveC);
		System.out.println(resultC);
	}
}
