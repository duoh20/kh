package com.kh.example.chap03_1_chagePanel.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	//프레임은 한 개만 만들고, 화면 전환은 패널을 이용한다.
	//이 예제에서는 메인이 프레임 역할을 한다.
	
	private JPanel panel;
	
	public Main() {
		setSize(300, 200);
		
		Panel1 panel1 = new Panel1();
		add(panel1);
		
		panel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				remove(panel1);
				add(new Panel2());
				revalidate(); //다시 유요화시키는 메소드
				repaint(); //revalidate()랑 셋뚜셋뚜로 많이 사용, 안써도 상관은 없음
			}
		});
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
