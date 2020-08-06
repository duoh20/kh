package com.kh.example.chap03_component.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class H_Slider {
	public H_Slider() {
		JFrame frame = new JFrame();
		
		JPanel panel1 = new JPanel();
		JLabel label = new JLabel("슬라이더를 움직여보세요", JLabel.CENTER);
		panel1.add(label);
		
		JPanel panel2 = new JPanel();
		JSlider slider = new JSlider(0, 30, 15); //JSlider(최대값, 최소값, 기본값)
		slider.setMajorTickSpacing(5); //슬라이더에 큰 눈금 간격 설정
		slider.setMinorTickSpacing(1); //슬라이더에 작은 눈금 간격 설정
		slider.setPaintTicks(true); //디폴트는 false, 슬라이더에 눈금을 표시함
		slider.setPaintLabels(true); //디폴트는 false, 슬라이더에 눈금 숫자표시
		JButton button = new JButton("전송");
		panel2.add(slider);
		panel2.add(button);
		
		JPanel resultPanel = new JPanel();
		JLabel text = new JLabel("결과 값 : ");
		JLabel result = new JLabel("");
		resultPanel.add(text);
		resultPanel.add(result);
		
		frame.add(panel1, "North");
		frame.add(panel2, "Center");
		frame.add(resultPanel, "South");
	
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText(slider.getValue() + "");
			}
		});
		
		
		
		
		frame.pack();
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
