package com.kh.example.chap03_2_chagePanel.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MainPage extends JPanel {
	
	private MainFrame frame;
	
	public MainPage() {}
	
	public MainPage(MainFrame frame) {
		
		this.frame = frame;
		
		setSize(300, 200);
		setBackground(Color.pink);
		
		addMouseListener(new MainPage$MyMouseAdaptor());
		frame.add(this); //매개 변수로 받아온 프레임에 나(패널)를 붙인다
	}
		
	class MainPage$MyMouseAdaptor extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
				SubPage page = new SubPage(frame);
				changePanel(page);
		}
	}
	
	public void changePanel(JPanel panel) {
		frame.remove(this);
		frame.revalidate();
		frame.repaint();
	}
}
