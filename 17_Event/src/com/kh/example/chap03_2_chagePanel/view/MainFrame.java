package com.kh.example.chap03_2_chagePanel.view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		setSize(300, 200);
		
		new MainPage(this); //메인 페이지에 나(프레임)를 넘겨준다.
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
