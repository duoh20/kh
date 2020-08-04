package com.kh.example.chap03_component.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class A_Text {
	public A_Text() {
		JFrame frame = new JFrame();
		frame.setSize(800, 300);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2)); //3행 2열의 그리드 레이아웃 사용, 안채워도 상관 없음
		panel.setSize(800, 300);
		
		//TextField : 한 줄 짜리 글을 입력할 수 있는 텍스트 상자
		JTextField id = new JTextField(30);
		panel.add(new JLabel("ID"));
		panel.add(id);
		
		//PasswordField : 비밀번호를 입력할 수 있는 TextField
		//				입력 중 입력한 값을 볼 수 없으며 한글 입력 불가
		JPasswordField password = new JPasswordField(30);
		panel.add(new JLabel("PASSWORD"));
		panel.add(password);
		
		//TextArea : 여러 줄의 텍스트를 입력할 수 있는 상자
		JTextArea textArea = new JTextArea(10, 30);
		textArea.setEditable(false); //수정 불가(read only)
		
		JButton btn = new JButton("보내기");
		
		frame.add(panel, BorderLayout.NORTH); //Layout을 설정하지 않아, 디폴트 레이아웃인 BorderLayout 적용 됨
		frame.add(textArea, BorderLayout.CENTER);
		frame.add(btn, BorderLayout.SOUTH);
		
		//이벤트 생성
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String text = "id = " + id.getText() + "\n";
				id.setText(""); //id를 가져온 후 지움
				
				String showPwd = ""; //password를 가져온 후 지움
				char[] pwdArr = password.getPassword();
				for(int i = 0; i<pwdArr.length; i++) {
					showPwd += pwdArr[i] + "";
				}
				
				text += "password = " + showPwd + "\n";
				password.setText("");
		
				textArea.append(text); //읽어온 id와 password를 텍스트 필드에 보여줌
				id.requestFocus(); //작업 완료 후 다시 id로 포커스 이동
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
