package com.kh.example.chap01_use.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C_Inner {
	
	//내부 클래스는 외부 클래스의 필드를 공유할 수 있다.
	private JButton button1, button2;
	private JLabel label;
	
	public C_Inner() {
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
		
		button1.addActionListener(new MyEvent(label)); //필드를 공유하므로 label도 공유된다.
		button2.addActionListener(new MyEvent(label));
		
	}
	
	class C_Inner$MyEvent implements ActionListener {

		//내부클래스명은 "외부클래스명$내부클래스명"으로 명명한다.
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button1) {
				label.setText("버튼1이 눌렸습니다");
			} else if (e.getSource() == button2) {
				label.setText("버튼2가 눌렸습니다");
			}
		}
	}
}
