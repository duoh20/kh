package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr;
	
	public BookMenu() {
		bc.makefile();
		bArr = bc.fileRead();
	}
	
	public void mainMenu() {
		int menu = 0;
		while(menu != 9){
			System.out.println("1. 도서 추가 저장");
			System.out.println("2. 저장 도서 출력");
			System.out.println("9. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1: fileSave(); break;
			case 2: fileRead(); break;
			case 9: System.out.println("프로그램을 종료합니다."); break;
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void fileSave() {
		System.out.print("도서 명 : ");
		String title = sc.nextLine();
		System.out.print("저자 명 : ");
		String author = sc.nextLine();
		System.out.print("도서 가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("출판 날짜(yyyy-mm-dd) : ");
		String[] dArr = sc.nextLine().split("-");
		int year = Integer.parseInt(dArr[0]);
		int month = Integer.parseInt(dArr[1]);
		int date = Integer.parseInt(dArr[2]);
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, date);
		System.out.print("할인율 : ");
		double discount = Double.parseDouble(sc.nextLine());
		
		Book b = new Book(title, author, price, c, discount);
		
		for(int i = 0; i < bArr.length; i++) {
			if (bArr[i] == null) {
				bArr[i] = b;
				break;
			}
		}
		
		bc.fileSave(bArr);
	} 
	
	public void fileRead() {
		Book[] book = bc.fileRead();
		for(Book b : book) {
			if(b != null) {
				System.out.println(b);
			} else {
				break;
			}
		}
	}
}
