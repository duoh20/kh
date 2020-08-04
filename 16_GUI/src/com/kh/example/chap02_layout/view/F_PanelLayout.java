package com.kh.example.chap02_layout.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class F_PanelLayout extends JFrame {
	public F_PanelLayout() {
		super("PanelLayout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 500);
		
		setLayout(null); //Layout 디폴트는 BorderedLayout이기 때문에 NullLayout을 사용하려면 꼭 null을 명시해야함, layout을 없애주는 역할이기 때문에 한 종류로 말하긴 어려움
		
		//패널로 나누어서 넣어줘야 관리가 더 쉽기 때문에 프레임에는 패널이 붙도록 만들어야함
		//라벨 추가
		JLabel lb = new JLabel("이름");
		lb.setLocation(50, 100);
		lb.setSize(150, 50);
		
		//텍스트 박스 추가
		JTextField tf = new JTextField(20);
		tf.setBounds(110, 100, 200, 50);
		
		//버튼 추가
		JButton btn = new JButton("추가");
		btn.setBounds(350, 100, 100, 50);
		
		//패널 생성
		JPanel panel = new JPanel();
		panel.setSize(500, 500);
		panel.setLayout(null); //패널 레이아웃의 디폴트는 FlowLayout임
		
		//컴포넌트를 패널에 붙임
		panel.add(lb);
		panel.add(tf);
		panel.add(btn);
		setVisible(true);
		
		//패널을 프레임에 붙임
		add(panel);
	}
}
