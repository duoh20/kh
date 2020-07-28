package com.kh.example.array;

import java.util.Scanner;

public class A_Array {
	//배열은 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	//저장된 값마다 인덱스가 지정되는데 인텍스는 o부터 시작
	
	//배열 선언
	//		자료형[] 배열명;
	//  	자료형 배열명[];
	//배열 할당
    //		자료형[] 배열명 = new 자료형[배열크기];
	//		자료형 배열명[] = new 자료형[배열크기];
	//		new 연산자를 통해 Heap 영역에 배열 크기 만큼 공간 생성
	//		생성되는 순간 그 공간에 대한 주소 값이 생기고
	// 		주소 값은 stack에 있는 배열명 공간에 값이 대입 됨(참조하고 있음)
	//배열 초기화
	//		1) 인덱스 이용(인덱스는 zero-vased)
	//			배열명[인덱스 번호] = 값;
	//		2) for문 이용(규칙이 있을 때만 사용 가능)
	//			for(int i = 0; i < arr.length; i++){
	//				배열명[] = 값;
	//			}
	//		3) 선언과 동시에 초기화
	//			자료형[] 배열명 = {값};
	//			자료형[] 배열명 = new 자료형[]{값};

	public void method1() {
		//int 자료형만 넣을 수 있는 9개짜리 arr 배열 생성
		int[] arr = new int[9]; //배열 선언 및 할당
		arr[0] = 10; //인덱스는 0부터
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		arr[5] = 60;
		arr[6] = 70;
		arr[7] = 80;
		arr[8] = 90;
		//arr[9] = 100; //ArrayIndexOutOfBoundsException
		
		for(int i = 0; i < 9; i++) {
			System.out.print(arr[i] + " ");
		}
		
		for(int i = 0; i < 9; i++) {
			arr[i] = 10 * (i + 1);
		}
		
		System.out.println();
		
		for(int i = 0; i < arr.length; i++) { //.length = to get the length for arrays / .length() = to get the length of Strings
			System.out.print(arr[i] + " "); //length는 array에 속한 field를 가져오는 것임, 메소드가 아니라 변수이다.
		}
	}
	
	public void method2() {
		int[] iArr; //배열 선언
		iArr = new int[5]; //배열 할당
		System.out.println("iArr : " + iArr); //힙 영역에 저장된 참조 주소값 출력, 실제 주소 값은 아님
		
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " "); //int 기본 값이 0이므로 0이 저장됨
		}
		
		System.out.println();
		
		//double만 들어갈 수 있는 30칸짜리 dArr 배열 생성
		//new 연산자는 heap 영역에 double만 들어갈 수 있는 공간을 생성하고
		//그 공간에 대한 주소 값을 반환
		double[] dArr = new double[30];
		System.out.println("처음으로 만든 dArr의 크기 : " + dArr.length);
		System.out.println("처음으로 만든 dArr의 주소 : " + dArr);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("변경할 배열 크기 : ");
		int arrSize = sc.nextInt();
		//new가 한 번 더 쓰였으므로, 다른 주소 값을 할당한다.
		dArr = new double[arrSize];
		
		System.out.println("크기 바꾼 dArr의 크기 : " + dArr.length);
		System.out.println("크기 바꾼 dArr의 주소 : " + dArr);
	
		char[] cArr = {'a', 'b', 'c'};
		char[] cArr2 = new char[] {'d', 'e', 'f'};
		
		System.out.print("cArr : ");
		for(int i = 0; i < cArr.length; i++) {			
			System.out.print(cArr[i] + " ");
			if( i == cArr.length - 1) {
				System.out.println();				
			}
		}
		
		System.out.print("cArr2 : ");
		for(int i = 0; i < cArr2.length; i++) {			
			System.out.print(cArr2[i] + " ");
		}
	}
}