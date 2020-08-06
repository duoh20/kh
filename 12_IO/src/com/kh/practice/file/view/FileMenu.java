package com.kh.practice.file.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		int menu = 0;
		do {
			System.out.println("***** My Note ****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1: fileSave(); break;
			case 2: fileOpen(); break;
			case 3: fileEdit(); break;
			case 9: System.out.println("프로그램을 종료합니다."); break;
			default: System.out.println("잘못 입력하셨습니다.\n다시 입력해주세요.");
			}
		} while(menu != 9);
	}
	
	public void fileSave() {
		String textInput = "";
		StringBuilder sb = new StringBuilder();
		do{
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			textInput = sc.nextLine();
			if(textInput != "ex끝it") {
				sb.append(textInput + "\n");
			}
		} while(!textInput.equals("ex끝it"));
		
		System.out.print("저장할 파일 명을 입력해주세요. : ");
		String file = sc.nextLine();
		
		if(fc.checkName(file)) {
			char confirm = ' ';
			do {
				System.out.println("이미 존재하는 파일입니다.\n덮어쓰시겠습니까?(y/n)");
				confirm = sc.nextLine().toUpperCase().charAt(0);
				if(confirm == 'Y') {
					fc.fileSave(file, sb);
				} else if (confirm == 'N') {
					return;
				} else {
					System.out.println("잘못 입력하셨습니다.\n 파일을 덮어쓰시겠습니까?(y/n)");
				}
			} while(confirm != 'Y' && confirm != 'N');
		} else {
			fc.fileSave(file, sb);
		}
	}
	
	public void fileOpen() {
		System.out.print("열 파일 명 : ");
		String file = sc.nextLine();
		StringBuilder sb = new StringBuilder(fc.fileOpen(file));
		
		if(fc.checkName(file) == true) {
			System.out.println(sb.toString());
		} else {
			System.out.println("존재하지않는 파일입니다.");
		}
	}
	
	public void fileEdit() {
		System.out.print("수정할 파일 명 : ");
		String file = sc.nextLine();
		StringBuilder sb = new StringBuilder(fc.fileOpen(file));
		String textInput = "";
		
		if(fc.checkName(file)) {
			do{
				System.out.println("파일에 저장할 내용을 입력하세요.");
				System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
				System.out.print("내용 : ");
				textInput = sc.nextLine();
				if (textInput != "ex끝it") {
					sb.append(textInput +"\n");
				}
			} while(!textInput.equals("ex끝it"));
			fc.fileSave(file, sb);
		} else {
			System.out.println("없는 파일입니다.");
		}
	}
}
