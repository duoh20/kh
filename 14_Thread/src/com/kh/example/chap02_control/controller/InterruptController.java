package com.kh.example.chap02_control.controller;

import java.util.Scanner;

import com.kh.example.chap02_control.thread.Thread5;

public class InterruptController {
	public void sleepInterrupt() {
		//Thread 실행 중 값을 입력 받으면 카운트를 종료하도록 만듦
		Thread5 th5 = new Thread5();
		Thread thread = new Thread(th5);
		thread.start();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아무 값이나 입력하세요 : ");
		String input = sc.nextLine();
		
		System.out.println("입력한 값 : " + input);
		//interrupt를 사용해 실행 대기 상태로 만듦
		thread.interrupt(); //InterruptedException 발생시키는 메소드
		
		System.out.println("inInterrupted() : " + thread.isInterrupted());
		//interrupt()가 true로 적용되었지만, sleep()이 설정을 초기화 시켜서 멈추지 않고 계속 카운트한다.
		//따라서 Thread5의 반복문에 "실행 중이다"는 조건식을 걸고 catch 구문에 한 번 더 interrupt를 걸어준다.
	}
}
