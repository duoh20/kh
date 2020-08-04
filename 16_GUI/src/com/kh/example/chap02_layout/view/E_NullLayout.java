package com.kh.example.chap02_layout.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class E_NullLayout extends JFrame {
	//원하는 모양대로 배치할 수 있는 이점이 있음
	public E_NullLayout() {
	super("NullLayout");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setBounds(200, 200, 500, 500);
	
	setLayout(null); //Layout 디폴트는 BorderedLayout이기 때문에 NullLayout을 사용하려면 꼭 null을 명시해야함, layout을 없애주는 역할이기 때문에 한 종류로 말하긴 어려움
	
	//라벨 추가
	JLabel lb = new JLabel("이름");
	lb.setLocation(50, 100);
	lb.setSize(150, 50);
	add(lb);
	
	//텍스트 박스 추가
	JTextField tf = new JTextField(20);
	tf.setBounds(110, 100, 200, 50);
	add(tf);
	
	//버튼 추가
	JButton btn = new JButton("추가");
	btn.setBounds(350, 100, 100, 50);
	add(btn);
	
	setVisible(true);
 	}
}
