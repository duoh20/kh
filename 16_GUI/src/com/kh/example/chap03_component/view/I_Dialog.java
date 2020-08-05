package com.kh.example.chap03_component.view;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class I_Dialog {
	public I_Dialog() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.add(panel);
		JButton button1 = new JButton("Simple Dialog");
		panel.add(button1);
		
		Dialog dialog = new Dialog(frame, "새로운 창 이름");		
		dialog.setBounds(150, 250, 200, 200);
		JLabel label = new JLabel("Simple Dialog Test");
		label.setHorizontalAlignment(JLabel.CENTER);	
		dialog.add(label, "North");
		
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			} //버튼을 누르면 dialog가 보이게 설정한다.
		});
		
		JButton button2 = new JButton("close");
		dialog.add(button2, "Center");
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			} //close 버튼을 누르면 dialog가 닫히도록 설정
		});
		
		JButton button3 = new JButton("Input Dialog");
		panel.add(button3);
		
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//1. 입력 다이어로그
				//String result = JOptionPane.showInputDialog("내용을 입력하세요");
				//System.out.println(result); //입력한 내용이 콘솔에 출력됨(아무것도 안쓰고 확인 시 공백, 취소 시 null 찍힘)
				
				//2. 확인 다이어로그
				//사용자의 선택에 따라 다른 결과물을 보여줄 때 사용할 수 있다.
				//선택한 옵션은 int 타입으로 반환된다.
				//int result = JOptionPane.showConfirmDialog(null, "확인하시겠습니까?" , "확인창", JOptionPane.YES_NO_OPTION); //반환값이 int
				//System.out.println(result); //exit:-1, YES:0, NO:1
				//int result = JOptionPane.showConfirmDialog(null, "확인하시겠습니까?" , "확인창", JOptionPane.YES_NO_CANCEL_OPTION); //반환값이 int
				//System.out.println(result); //exit:-1, YES:0, NO:1, cancel:2
				
				//3. 메세지 다이어로그
				//메세지 유형에 따라 다른 UI로 보여줌
				JOptionPane.showMessageDialog(null/*메세지 띄울 위치, null은 중앙*/, "위험합니다.", "danger", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "위험합니다.", "danger", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "위험합니다.", "danger", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "위험합니다.", "danger", JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(null, "위험합니다.", "danger", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		frame.setSize(300, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);		
	}
}
