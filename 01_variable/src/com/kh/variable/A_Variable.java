package com.kh.variable;

public class A_Variable { //��� Ŭ����
	public void declareVariable() {
		//변수 선언 후 초기화
		//A. 변수 선언: 메모리에 저장 공간만 생성
		//1. 논리형
		boolean isTrue;
		
		//2. 문자형
		//2-1. 문자
		char ch;
		//2-2. 문자열
		String str;
		
		//3. 숫자형
		//3-1. 정수형
		byte bNum;
		short sNum;
		int iNum;
		long lNum;
		//3-2. 실수형
		float fNum;
		double dNum;
		
		//B. 초기화(대입)
		isTrue = true; //true-false만 저장 가능
		
		ch = 'A'; //''안에 작성
		str = "ABCD"; //""안에 작성
		
		bNum = 1;
		sNum = 2;
		iNum = 4;
		lNum = 8L;
		
		fNum = 4.0f;
		dNum = 8.0;
		
		System.out.println("isTrue�� ��: " + isTrue);
		System.out.println("ch�� ��: " + ch);
		System.out.println("str�� ��: " + str);
		System.out.println("bNum�� ��: " + bNum);
		System.out.println("sNum�� ��: " + sNum);
		System.out.println("iNum�� ��: " + iNum);
		System.out.println("lNum�� ��: " + lNum);
		System.out.println("fNum�� ��: " + fNum);
		System.out.println("dNum�� ��: " + dNum);
	}
	
	public void initVariable() {
		//���� ����� ���ÿ� �ʱ�ȭ
		//1. ����
		boolean isTrue = false;
		
		//2. ������
		char ch = 'A';
		String str = "�����";
		
		//3. ������
		byte bNum = 1;
		short sNum = 2;
		int iNum = 4;
		long lNum = 8L;
		
		float fNum = 4.0f;
		double dNum = 8.0d;
		
		System.out.println("isTrue�� ��: " + isTrue);
		System.out.println("ch�� ��: " + ch);
		System.out.println("str�� ��: " + str);
		System.out.println("bNum�� ��: " + bNum);
		System.out.println("sNum�� ��: " + sNum);
		System.out.println("iNum�� ��: " + iNum);
		System.out.println("lNum�� ��: " + lNum);
		System.out.println("fNum�� ��: " + fNum);
		System.out.println("dNum�� ��: " + dNum);
	}
}
