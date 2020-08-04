package com.kh.example.chap02_layout.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_BorderLayout extends JFrame {

	public A_BorderLayout() {
	//1. 컨테이너 설정하기
		super("BorderLayout"); //타이틀 설정 방법1
		//setTitle("BorderLayout"); //타이틀 설정 방법2
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 800, 500);
		
	//2. 레이아웃 설정
		//BorderLayout 구역을 5개로 나눠 배치하는 레이아웃
		setLayout(new BorderLayout()); //BorderLayout 설정, 레이아웃을 따로 설정하지 않으면 디폴트는 BorderLayout
		
	//3. 컴포넌트 생성
		//버튼(컴포넌트의 한 종류) 생성
		JButton northB = new JButton("북"); //북이라는 이름의 버튼 생성
		JButton southB = new JButton("남");
		JButton eastB = new JButton("동"); 
		JButton westB = new JButton("서"); 
		JButton centerB = new JButton("가운데");
		
	//4. 컨테이너에 컴포넌트 추가
		add(northB, "North"); //대소문자를 구분해서 작성해야 JFrame이 인지할 수 있음
		add(southB, "South");
		add(eastB, "East");
		add(westB, "West");
		add(centerB, "Center");
	}
}
