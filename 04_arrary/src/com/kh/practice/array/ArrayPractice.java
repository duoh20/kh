package com.kh.practice.array;

import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		int[] iArr = new int[10];
		
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = i+1;
		}
		
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}
	
	public void practice2() {
		int[] iArr = new int[10];
		
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = 10 - i;
		}
		
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}
	
	public void practice3() {			
		System.out.println("양의 정수를 입력하세요.");
		
		while(true) {
			System.out.print("양의 정수 : ");
			int length = sc.nextInt();
			
			if(length > 0) {
				int[] iArr = new int[length];
				for(int i = 0; i < iArr.length; i++) {
					iArr[i] = i + 1;
				}
				
				for(int i = 0; i < iArr.length; i++) {
					System.out.print(iArr[i] + " ");
				} break;
			} else {
				System.out.println("양의 정수만 입력할 수 있습니다.");
			}
		}
	}
	
	public void practice4() {
		String[] sArr = new String[5];
		sArr[0] = "사과";
		sArr[1] = "귤";
		sArr[2] = "포도";
		sArr[3] = "복숭아";
		sArr[4] = "참외";
		
		System.out.println(sArr[1]);
	}
	
	public void practice5() {
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		char[] cArr = str.toCharArray();
		
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		int chNum = 0;
		System.out.print(str + "에 " + ch + "가 존재하는 위치(인덱스) : ");
		for(int i = 0; i < str.length(); i++) {
			if(cArr[i] == ch) {
				chNum += 1;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println(ch + " 개수 : " + chNum);
	}
	
	public void practice6() {
		String day[] = {"월", "화", "수", "목", "금","토","일"};
		
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int index = sc.nextInt();
		
		if(index >= 0 && index < 7) {
			System.out.println(day[index] + "요일");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void practice7() {
		System.out.print("정수 : ");
		int index = sc.nextInt();
		int[] iArr = new int[index];
		
		for(int i = 0; i < iArr.length; i++) {
			System.out.print("배열" + i +"번째 인덱스에 넣을 값 : ");
			int num = sc.nextInt();
			iArr[i] = num;
		}
		
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		
		System.out.println();
		int sum = 0;
		for(int i = 0; i < iArr.length; i++) {
			sum += iArr[i];
		}
		System.out.println("총합 : " + sum);
	}
	
	public void practice8() {
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int iArr[] = new int[num];
		int value = 0;
		
		if (num >= 3 && num % 2 == 1) {
			for(int i = 0; i < iArr.length; i++) {
				if(i < num/2+1) {
					value = i + 1;
					iArr[i] = value;
				} else {
					value = num - i;
					iArr[i] = value;
				}
			}
			for (int i = 0; i < iArr.length; i++) {
				System.out.print(iArr[i] + " ");
			}			
		} else {
			System.out.println("다시 입력하세요.");
		}
	}
	
	public void practice9() {
		String[] chickenMenu = {"양념", "후라이드", "간장", "마늘", "황금 올리브", "핫"};
		
		System.out.print("치킨 이름을 입력하세요 : ");
		String order = sc.nextLine();
		boolean isTrue = false;
		
		for(int i = 0; i < chickenMenu.length; i++) {
			if(order.equals(chickenMenu[i])) {
				isTrue = true;
				break;
			}
		}

		if(isTrue == true) {
			System.out.println(order + "치킨 배달 가능");			
		} else {
			System.out.println(order + "치킨은 없는 메뉴입니다.");
		}
	}
	
	public void practice10() {
		System.out.print("주민등록번호(-포함) : ");
		String idNum = sc.nextLine();
		String[] idArr = {idNum};
		
		for (int i = 0; i < idArr.length; i++) {
			idArr[i] = idNum;
		}
		
		for (int i = 0; i < idArr.length; i++){ //배열의 크기만큼 반복
			for(int j = 0; j < idArr[i].length(); j++) { //데이터 길이만큼 반복
				if(j < 8) {
					System.out.print(idArr[i].charAt(j));
				} else {
					System.out.print("*");
				}
			}
		}
	}
	
	public void practice11() {
		int[] iArr = new int[10];
		
		for (int i = 0; i < iArr.length; i++) {
			int random = (int)(Math.random() * 10 + 1);
			iArr[i] = random;
		}
		
		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}
	
	public void practice12() {
		int[] iArr = new int[10];
		
		//난수 배열 생성
		for (int i = 0; i < iArr.length; i++) {
			int random = (int)(Math.random() * 10 + 1);
			iArr[i] = random;
		}
		
		//생성한 난수 배열 확인
		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		System.out.println();
		
		//최대값 최소값 비교
		int min = iArr[0];
		int max = iArr[0];;
		for(int i = 1; i < iArr.length; i++) {
			
			if(max < iArr[i]) {
				max = iArr[i];
			}
			
			if(min > iArr[i]) {
				min = iArr[i];
			}
		}
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
	
	public void practice13() {
		int[] iArr = new int[10];
		
		//중복 제거한 난수 배열 생성
		for (int i = 0; i < iArr.length; i++) {
			int random = (int)(Math.random() * 10 + 1);
			iArr[i] = random;
			 
			for (int j = 0; j < i; j++) {
				if(iArr[i] == iArr[j]) {
					i--;
				}
			}
		}
		
		//생성한 난수 배열 확인
		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}
	
	public void practice14() {
		int[] lotto = new int[6];
		
		for (int i = 0; i < lotto.length; i++) {
			int random = (int)(Math.random() * 100 + 1);
			if (random > 46) {
				i--;
				continue;
			}
			lotto[i] = random;
		}
		
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
	}
}