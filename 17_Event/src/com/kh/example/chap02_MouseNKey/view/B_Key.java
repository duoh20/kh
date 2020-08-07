package com.kh.example.chap02_MouseNKey.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class B_Key extends JFrame implements KeyListener {

	public B_Key() {
		setSize(300, 200);
		
		JTextField tf = new JTextField();
		add(tf);
		
		tf.addKeyListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void display(String s, KeyEvent e) {
		char c = e.getKeyChar(); //입력 받은 문자 반환
		
		boolean isAlt = e.isAltDown(); //alt 키를 눌렀는지 여부 확인
		boolean isControl = e.isControlDown(); //ctrl 키를 눌렀는지 여부 확인
		boolean isShift = e.isShiftDown(); //shift 키를 눌렀는지 여부 확인
		
		String modifiers = "isAlt : " + isAlt + ", isControl : " + isControl + ", isShift : " + isShift;
		System.out.println(s + " " + c + " " + modifiers);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		display("key Typed", e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		display("key Pressed", e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		display("key Released", e);
	}
}
