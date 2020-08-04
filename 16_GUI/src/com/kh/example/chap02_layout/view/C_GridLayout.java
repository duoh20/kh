package com.kh.example.chap02_layout.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class C_GridLayout extends JFrame {
	public C_GridLayout() {
		super("C_GridLayout");
		//setVisible(true); 맨 위에 두면 컴포넌트가 종종 안보일 때가 있므로 이 메서드는 맨 아래에 두는 것이 좋음
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 800, 500);
		
		//GridLayout 가로, 세로의 일정 수만큼 배치할 때 사용
		setLayout(new GridLayout(5, 5, 10, 20)); //매개변수로 간격 설정
		
		for(int i = 1; i < 26; i++) {
			String str = new Integer(i).toString();
			add(new JButton(str));
		}
		
		setVisible(true);
	}
}
