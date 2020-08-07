package com.kh.example.chap01_use.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class B_Other {
	public B_Other() {
		JFrame frame = new JFrame();
		frame.setSize(250, 200);
		
		JPanel panel = new JPanel();
		JButton button1 = new JButton("버튼1");
		JButton button2 = new JButton("버튼2");
		JLabel label = new JLabel("아직 버튼이 눌리지 않았습니다.");
		
		panel.add(button1);
		panel.add(button2);
		panel.add(label);
		
		
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button1.addActionListener(new MyEvent(label)); //MyEvent 클래스에 직접 구현한 이벤트를 생성자 생성하여 호출함
		button2.addActionListener(new MyEvent(label)); //버튼을 클릭할 때 라벨이 바뀌는 기능을 구현하려고 함, 외부 클래스에 이벤트 리스너를 구현하고, 이 클래스의 객체를 생성하여 매개변수로 넘겨 연결해 사용한다.
		
	}
}

class MyEvent implements ActionListener { //외부 클래스에 이벤트 구현하고 생성자를 통해 불러오기
	private JLabel label;
	
	public MyEvent(JLabel label) { //매개변수가 하는 일!! 객체 생성 & 필드 초기화!!!!
		this.label = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		//System.out.println(button);
		if(button.equals("버튼1")) {
			label.setText("버튼1이 눌렸습니다.");
		} else if(button.equals("버튼2")) {
			label.setText("버튼2가 눌렸습니다.");
		}
	}
}