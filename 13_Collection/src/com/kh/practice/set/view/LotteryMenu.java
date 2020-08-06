package com.kh.practice.set.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.kh.practice.set.controller.LotteryController;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryMenu {
	Scanner sc = new Scanner(System.in);
	LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		int menu = 0;
		while(menu != 9) {
			System.out.println("****** 메인 메뉴 ******");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 당첨 대상 확인");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1: insertObject(); break;
			case 2: deleteObject(); break;
			case 3: winObject(); break;
			case 4: sortedWinObject(); break;
			case 5: searchWinner(); break;
			case 9: System.out.println("프로그램을 종료합니다."); break;
			default: System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void insertObject() {
		System.out.print("추가할 추첨 대상 수 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < num; i++) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("휴대폰 번호 ('-'빼고) : ");
			String phoneNumber = sc.nextLine();
			Lottery l = new Lottery(name, phoneNumber);
			boolean result = lc.insertObject(l);
			if(!result) {
				i--;
				System.out.println("중복된 대상입니다. 다시 입력하세요.");
			} else {
				lc.insertObject(l);
				System.out.println("추가 완료되었습니다.");
			}
		}
		System.out.println(num + "명 추가 완료되었습니다.");
	}
	
	public void deleteObject() {
		System.out.print("삭제할 대상의 이름 : ");
		String name = sc.nextLine();
		System.out.print("삭제할 대상의 휴대폰 번호 ('-'빼고) : ");
		String phoneNumber = sc.nextLine();		
		boolean result = lc.deletObject(new Lottery(name, phoneNumber));
		if (result) {
			System.out.println("삭제 완료되었습니다.");
		} else {
			System.out.println("존재하지 않는 대상입니다.");
		}
	}
	
	public void winObject() {
		System.out.println(lc.winObject());
	}
	
	public void sortedWinObject() {
		Iterator<Lottery> it = lc.sortedWinObject().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void searchWinner() {
		System.out.print("검색 대상의 이름 : ");
		String name = sc.nextLine();
		System.out.print("검색 대상의 휴대폰 번호 ('-'빼고) : ");
		String phoneNumber = sc.nextLine();
	
		boolean result = lc.searchWinner(new Lottery(name, phoneNumber));
		if(result) {
			System.out.println("축하합니다. 당첨 목록에 존재합니다.");
		} else {
			System.out.println("안타깝지만 당첨 목록에 존재하지 않습니다.");
		}
	}
}