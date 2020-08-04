package com.kh.example.chap03_component.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class B_RadioButton {
	public B_RadioButton() {
		JFrame frame = new JFrame();
		frame.setTitle("RadioButton Component");
		//frame.setSize(300, 150);
		frame.setResizable(false);
		
		JPanel topPanel = new JPanel();
		JLabel label = new JLabel("어떤 크기의 음료를 주문하시겠습니까?");
		topPanel.add(label);
		frame.add(topPanel, "North");
		
		//라디오 버튼을 담을 패널과 라디오 버튼 생성
		//뭔가를 눌렀을 때 반응해야할 곳에 이벤트를 걸어줘야함
		JPanel sizePanel = new JPanel();
		JRadioButton small = new JRadioButton("Small size"); //라디오 버튼 우측에 노출할 문구
		JRadioButton medium = new JRadioButton("Medium size");
		JRadioButton large = new JRadioButton("Large size");
		//라디오 버튼을 그룹으로 만들어 줘야 한 개만 선택할 수 있음, 그룹으로 인식하지 못하면 모두 선택 가능
		ButtonGroup sizeGroup = new ButtonGroup();
		sizeGroup.add(small);
		sizeGroup.add(medium);
		sizeGroup.add(large);
		//패널에 생성한 라디오 버튼 추가
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		frame.add(sizePanel, "Center");
		
		JPanel resultpanel = new JPanel();
		JLabel text = new JLabel("크기가 선택되지 않았습니다.");
		resultpanel.add(text);
		frame.add(resultpanel, "South");
		
		frame.pack(); //컨테이너 크기를 정하지 않았을 때, 컴포넌트에 맞추어 최소한의 영역을 갖게 하는 메소드
		
		//라디오 버튼에 이벤트 걸기
		small.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("Small Size가 선택되었습니다.");
			}
		});
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("Medium Size가 선택되었습니다.");
			}
		});
		large.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("Large Size가 선택되었습니다.");
			}
		});		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
