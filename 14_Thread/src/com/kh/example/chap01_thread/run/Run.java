package com.kh.example.chap01_thread.run;

import com.kh.example.chap01_thread.thread.Thread1;
import com.kh.example.chap01_thread.thread.Thread2;
import com.kh.example.chap01_thread.thread.Thread3;

public class Run {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		t1.start();
		
		Thread2 t2 = new Thread2();
		//t2.start(); //Runnable을 상속 받았기 때문에 start() 없음
		Thread thread2 = new Thread(t2); //Thread 생성자를 호출
		thread2.start();
		
		Thread3 t3 = new Thread3();		
		t3.run();
	}

}
