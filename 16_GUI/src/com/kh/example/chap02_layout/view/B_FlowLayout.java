package com.kh.example.chap02_layout.view;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class B_FlowLayout extends JFrame {
	public B_FlowLayout() {
		super("B_FlowLayout");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 800, 500);
		
		//FlowLayout 왼쪽에서 오른쪽으로 흐르듯이 컴포넌트가 배치되는 레이아웃
		setLayout(new FlowLayout()); //디폴트 정렬 값은 CENTER
		add(new JButton("1번"));
		add(new JButton("2번"));
		add(new JButton("3번"));
		add(new JButton("4번"));
		add(new JButton("5번"));
		add(new JButton("6번"));
		add(new JButton("7번"));
		add(new JButton("8번"));
		add(new JButton("9번"));
		add(new JButton("10번"));
		add(new JButton("11번"));
		add(new JButton("12번"));
		add(new JButton("13번"));//컨테이너 너비보다 배치할 컴포넌트가 많으면 다음 줄로 넘겨줌
		add(new JButton("14번"));
		add(new JButton("15번"));
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setLayout(new FlowLayout(FlowLayout.RIGHT)); //TRAILING도 오른쪽 정렬
		setLayout(new FlowLayout(FlowLayout.LEFT)); //LEADING도 왼쪽 정렬
	}
}
