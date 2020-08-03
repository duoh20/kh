package com.kh.example.chap02_control.thread;

public class Thread4 implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i + "초");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("카운트 종료");
	}
}
