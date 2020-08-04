package com.kh.example.chap03_component.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C_CheckBox {
	public C_CheckBox() {		
		JFrame frame = new JFrame();
		
		//체크박스 만들기 : 여러 개 선택 가능
		String[] fruits = {"apple", "orange", "banana"};
		
		JCheckBox[] buttons = new JCheckBox[3]; //객체 공간만 생성된 상태 객체 배열은 객체 생성까지 잊지말자!
		for(int i = 0; i <buttons.length; i++) {
			buttons[i] = new JCheckBox(fruits[i]);
		}
		
		JPanel checkPanel = new JPanel(); //패널이나 컴포넌트의 이름을 의미있게 잘 지어주자.
		for(int i = 0; i < buttons.length; i++) {
			checkPanel.add(buttons[i]);
		}
		
		JPanel resultPanel = new JPanel();
		JLabel text = new JLabel("선택한 과일이 없습니다.");
		resultPanel.add(text);
		
		frame.add(checkPanel, "North");
		frame.add(resultPanel, "Center");
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					String result = "";
					int count = 0;
					
					for(int i = 0; i <buttons.length; i++) {
						if(buttons[i].isSelected()) {
							result += buttons[i].getText() + " ";
							count++;
						}
						text.setText(result);
					}
					
					if(count == 0) { //선택된 과일이 없는 경우
							text.setText("선택한 과일이 없습니다.");
					}
				}				
			});
		}

		
		
		
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
