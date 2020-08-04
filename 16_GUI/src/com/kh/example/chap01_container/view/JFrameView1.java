package com.kh.example.chap01_container.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class JFrameView1 extends JFrame { //J가 붙으면 swing에 있는 것
	public JFrameView1() { //클래스 자체가 JFrame이므로 메소드로 접근 가능
		//super("setTitle() 대신 이렇게 이름을 설정할 수도 있습니다.");
		setVisible(true); //!!필수!! 눈에 보이게 설정해줘야 프레임이 보임, this 붙이지 않아도 상관 없음
		setDefaultCloseOperation(EXIT_ON_CLOSE); //!!필수!! 프레임을 닫았을 때 프로세스도 정상적으로 종료될 수 있도록 함
		
		//this.setSize(800, 500); //사이즈 설정해야 setVisible해도 보임
		//setLocation(300,200); //프레임 실행 위치 설정, 기본은 왼쪽 상단에 붙어서 열림
		setBounds(300, 200, 800, 500); //사이즈 설정과 실행 위치 설정을 한 번에 설정 가능한 메소드 (가로 위치, 세로 위치, 프레임 너비, 프레임 높이)
		
		setTitle("My First Frame"); //프레임 상태바에 표시할 이름 설정

		
		try {
			setIconImage(ImageIO.read(new File("image/icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		setResizable(false); //창 크기 변경하지 못하게 막기
	}
}
