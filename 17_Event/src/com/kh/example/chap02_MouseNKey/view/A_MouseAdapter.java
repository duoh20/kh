package com.kh.example.chap02_MouseNKey.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_MouseAdapter extends MouseAdapter {
	private JButton button;
	private int count = 0;
	
	public A_MouseAdapter() {
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		button = new JButton();
		frame.add(button);
	
		button.addMouseListener(this);		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int num = count % 7;
		if(num == 0) {
			button.setBackground(Color.red);		
		} else if(num == 1) {
			button.setBackground(Color.orange);
		} else if(num == 2) {
			button.setBackground(Color.yellow);
		} else if(num == 3) {
			button.setBackground(Color.green);
		} else if(num == 4) {
			button.setBackground(Color.blue);
		} else if(num == 5) {
			button.setBackground(new Color(0, 0, 165));
		} else {
			button.setBackground(new Color(149, 54, 255));
		}
		count++;
	}
}
