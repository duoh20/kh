package com.kh.example.chap00_file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {
	public void method() {
		
		try {
			File f1 = new File("test.txt");//파일을 생성, 메소드 자체에 throws IOException이 걸려있어서 예외 처리 필요
			f1.createNewFile();//위치 지정을 안하고 메소드를 호출하면 작업중인 workspace> project 디렉토리 최상단에 파일이 생성됨 
			
			File f2 = new File("c:\\test\\test.txt");
			f2.createNewFile(); //c 드라이브 하위에 test 폴더가 없기으면 지정된 경로를 찾을 수 없다는 에러 발생
			
			File f3 = new File("c:\\temp3\\temp2");
			File f4 = new File("c:\\temp3\\temp2\\test.txt");
			//f4.createNewFile(); //지정된 경로를 찾을 수 없다는 에러 발생, 메소드로 폴더 생성 만들어야 함
			f3.mkdirs(); //폴더를 만드는 메소드, f3 생성자에 담은 경로에 따라 디렉토리 생성
			f4.createNewFile();//파일 생성
			f4.delete();//파일만 삭제
			
			System.out.println(f2.exists()); //boolean값 반환: true
			System.out.println(f3.exists()); //boolean값 반환: true
			System.out.println(f3.isFile()); //boolean값 반환: false

			System.out.println("파일 명 : " + f1.getName()); //boolean값 반환: false
			System.out.println("파일 용량 : " + f1.length());//boolean값 반환: false			
			System.out.println("저장 절대 경로 : " + f1.getAbsolutePath());//변하지 않은 경로	
			System.out.println("저장 상대 경로 : " + f1.getPath());//내 위치에 따라 바뀌는 경로			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
