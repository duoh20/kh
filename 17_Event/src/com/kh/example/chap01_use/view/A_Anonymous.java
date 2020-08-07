package com.kh.example.chap01_use.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class A_Anonymous {
	//익명 클래스 방법으로 이벤트 정의하기
	public void anonymousMethod() {
		JFrame frame = new JFrame();
		frame.setSize(250, 200);
		
		JPanel panel = new JPanel();
		JButton button1 = new JButton("버튼1");
		JButton button2 = new JButton("버튼2");
		JLabel label = new JLabel("아직 버튼이 눌리지 않았습니다.");
		
		panel.add(button1);
		panel.add(button2);
		panel.add(label);
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		
		button1.addActionListener(new ActionListener() /*익명 클래스 생성*/ { //익명 클래스를 구현한 내용 작성

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("버튼1 눌렸습니다.");
				System.out.println(e.getSource());
			}
		});
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("버튼2 눌렸습니다.");
				System.out.println(e.getSource());
			}
		});
	}
}
