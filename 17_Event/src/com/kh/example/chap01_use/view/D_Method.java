package com.kh.example.chap01_use.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class D_Method implements ActionListener {
	//클래스에 인터페이스 직접 구현해서 사용하기
	
	//필드로 만들어서 외부에서 접근할 수 있게 함
	private JButton button1, button2;
	private JLabel label;
	
	public D_Method() {
		JFrame frame = new JFrame();
		frame.setSize(250, 200);
		
		JPanel panel = new JPanel();
		button1 = new JButton("버튼1");
		button2 = new JButton("버튼2");
		label = new JLabel("아직 버튼이 눌리지 않았습니다.");
		
		panel.add(button1);
		panel.add(button2);
		panel.add(label);
		
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button1.addActionListener(this); //addActionLister는 ActionListener 구현한 것을 매개변수로 받는다.
		button2.addActionListener(this); // 내 클래스 내부에 이미 구현해두었으므로 this를 넣어준다
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			label.setText("버튼1을 눌렀습니다.");
		} else if (e.getSource() == button2) {
			label.setText("버튼2을 눌렀습니다.");
		}
		
	}
}
