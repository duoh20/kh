package com.kh.example.chap02_conrtol.run;

import com.kh.example.chap02_control.controller.InterruptController;
import com.kh.example.chap02_control.thread.Thread4;

public class Run {

	public static void main(String[] args) {
//		Thread4 thread4 = new Thread4();
//		new Thread(thread4).start();
		
		InterruptController ic = new InterruptController();
		ic.sleepInterrupt();
	}
}
