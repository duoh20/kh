package com.kh.example.chap01_container.view;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class JFrameView2 {
	public void showJFrame() {
		JFrame frame = new JFrame("My Second Frame"); //생성자로 title 설정
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //static필드이므로 클래스명(JFrame)으로 필드 접근 가능 
		//frame.setTitle("My Second Frame"); //혹은 setTitle로 title 설정 가능
		
		Rectangle r = new Rectangle(300, 200, 800, 500);
		frame.setBounds(r); //Rectangle 객체로 사이즈 정보 불러오기도 가능
		
		frame.setResizable(false); //크기 조정 불가능하게 막기
		try {
			frame.setIconImage(ImageIO.read(new File("image/icon.png"))); //아이콘 설정
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
