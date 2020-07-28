package com.kh.example.array;

import java.util.Arrays;

public class B_ArrayCopy {

	//얕은 복사 : 배열의 주소만 복사
	//깊은 복사 : 새로운 배열을 만들어 실제 내부 값 복사
	
	public void method1() {
		int[] originArr = {1, 2, 3, 4, 5}; //배열 선언과 동시에 초기화
		int[] copyArr = originArr; //얕은 복사
		
		//originArr과 복사한 copyArr의 복사 결과 확인
		for (int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
		
		//originArr의 첫번째 배열 값만 99로 변경
		originArr[0] = 99;
		
		//originArr과 복사한 copyArr에 저장된 데이터 비교: 두 배열에 담긴 값이 동일함
		for (int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
		
		//동일한 이유: copyArr이 originArr과 동일한 주소 값만 들고 왔기 때문
		System.out.println("originArr의 주소 : " + originArr);
		System.out.println("copyArr의 주소 : " + copyArr);
	}
	
	public void method2() { //깊은 복사
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[5]; //복사할 값을 담을 배열 생성
		
		//1. for문을 이용한 복사
		for(int i = 0; i < originArr.length; i++) {
			copyArr[i] = originArr[i];
		}
		
		//복사한 결과 값 원본과 확인 : 동일
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}		
		System.out.println();
		
		//originArr의 데이터 변경
		originArr[0] = 99;
		
		//두 배열의 결과 값 비교: originArr만 변경됨
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
		
		//두 배열의 주소가 다르기 때문에 원본을 변경해도 복사본 자료에 영향 X
		System.out.println("originArr의 주소 : " + originArr);
		System.out.println("copyArr의 주소 : " + copyArr);
	}
	
	public void method3() {
		//2. System 클래스의 arrayCopy() 메소드를 이용한 복사
		//				   매개변수(인자) :  해당 메소드(여기서는 arraycopy())에 값을 전달
		//System.arraycopy(src, srcPos, dest, destPos, length);
		//	src    : 원본(복사할) 배열
		//  srcPos : 원본 배열에서 복사를 시작할 위치
		//  dest   : 복사(한 내용을 담을) 배열
		//	destPos   : 복사 배열에서 붙여 넣기를 시작할 위치
		//  length : (몇 개를 복사할지에 대한)복사 길이

		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[10];
		
		System.out.println("=== 복사 전 ===");
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
		
		//originArr 배열의 모든 값을 copyArr의 3 인덱스부터 복사
		System.arraycopy(originArr, 0, copyArr, 3, originArr.length);
		
		System.out.println();
		System.out.println("=== 복사 후 ===");
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
	}
	
	public void method4() {
		//3. Arrays 클래스 안의 coppyOf() 메소드를 이용한 복사
		//		Arrays.copyOf(original, newLength)
		// 					original	: 원본배열
		//					newLength	: 새로운 길이 

		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[10];
		
		System.out.println("=== 복사전 ===");
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
		
		copyArr= Arrays.copyOf(originArr, originArr.length);
		
		System.out.println();
		System.out.println("=== 복사후 ===");
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
	}
}

