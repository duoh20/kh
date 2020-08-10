package com.kh.example.chap03_2_chagePanel.view;

import java.awt.Color;

import javax.swing.JPanel;

public class SubPage extends JPanel {
	public SubPage(MainFrame frame) {
		setSize(250, 150);
		setBackground(Color.gray);		
		frame.add(this);
		
		
	}
}
