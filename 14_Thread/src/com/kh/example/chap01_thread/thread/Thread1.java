package com.kh.example.chap01_thread.thread;


public class Thread1 extends Thread {
	@Override
	public void run() {
		setName("귀여운 Thread1");
		for(int i = 0; i < 10; i++) {
			//getName() 스레드의 이름 반환 메소드
			System.out.println(getName() + " ON...");
			try {
				Thread.sleep(1000); //스레드 지연 메소드 (1000 = 1초)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
