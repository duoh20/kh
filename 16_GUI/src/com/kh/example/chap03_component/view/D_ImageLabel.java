package com.kh.example.chap03_component.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class D_ImageLabel {
	//라벨에 이미지가 들어가서 이미지 라벨이라고 한다
	public D_ImageLabel() {
		JFrame frame = new JFrame("ImageLabel");
		frame.setSize(250,300);
		JPanel panel = new JPanel();
		
		//ImageIcon ii = new ImageIcon("image/user.PNG"); //이미지의 원본 사이즈가 나와서 크기 조정이 필요
		Image icon = new ImageIcon("image/user.PNG").getImage().getScaledInstance(150, 150, 0); //이미지 크기를 적용할 수 있다.
		JLabel label = new JLabel(new ImageIcon(icon)); //이미지를 바로 넣어줄 수 없음, ImageIcon()에 매개변수로 넣어준다.
		
		JButton button = new JButton("이미지 보기");
		panel.add(label, "North");
		panel.add(button, "Center");
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		button.addActionListener(new ActionListener() {
		//이미지 보기를 누르면 이미지가 바뀌는 이벤트 추가
			@Override
			public void actionPerformed(ActionEvent e) {
				//익명 함수라서 바깥에 사용된 변수 명에 관계 없이 변수 명을 중복할 수 있다.
				Image icon = new ImageIcon("image/dog.PNG").getImage().getScaledInstance(150, 150, 0);
				Image icon2 = new ImageIcon("image/tiger.PNG").getImage().getScaledInstance(150, 150, 0);
				label.setIcon(new ImageIcon(icon));
				label.setIcon(new ImageIcon(icon2));
			}
		});
	}

}
