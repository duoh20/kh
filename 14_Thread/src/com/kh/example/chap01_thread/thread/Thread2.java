package com.kh.example.chap01_thread.thread;

public class Thread2 implements Runnable {
	@Override
	public void run() {
		Thread.currentThread().setName("멋진 Thread2"); //스레드 이름 설정
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "ON...");
			//Runnable은 인터페이스이므로 getName()을 호출할 수 없다.
			//Thread 클래스의 curruntThread()를 이용해 getName()을 호출한다.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
