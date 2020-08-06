package com.kh.example.chap03_component.view;

import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class G_Spinner {
	public G_Spinner() {
		JFrame frame = new JFrame();
		frame.setSize(500, 120);
		
		JPanel panel = new JPanel();
		
		//1. ListModel
		String[] items = {"소설", "잡지", "전공서적", "취미"};
		SpinnerListModel listModel = new SpinnerListModel(items);
		JSpinner listSpinner = new JSpinner(listModel);
		JLabel label = new JLabel("분류");
		panel.add(label);
		panel.add(listSpinner);
			
		//2. NumberModel
		SpinnerNumberModel numberModel = new SpinnerNumberModel(1, 0, 9, 1); //SpinnerNumberModel(시작값, 최소값, 최대값, 증가값)
		JSpinner numberSpiner = new JSpinner(numberModel);
		panel.add(numberSpiner);
		
		//3. DateModel
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		
		calendar.add(Calendar.YEAR, -50); //지금으로 부터 50년 전
		Date start = calendar.getTime();
		
		calendar.add(Calendar.YEAR, 100); //지금으로 부터 50년 후(50년 전부터 50년 후까지 포함해야해서)
		Date end = calendar.getTime();

		SpinnerDateModel dateModel = new SpinnerDateModel(today, start, end, Calendar.YEAR); 
		JSpinner dateSpinner = new JSpinner(dateModel);
		dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy/MM/dd HH:mm:ss"));
		panel.add(dateSpinner);
		
		JButton button = new JButton("전송");
		panel.add(button);
		
		JPanel resultPanel = new JPanel();
		JLabel text = new JLabel();
		resultPanel.add(text);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(listSpinner.getValue() + ", " + numberSpiner.getValue() + ", " + dateSpinner.getValue());
			}
		});
		
		frame.add(resultPanel);
		frame.add(panel, "North");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
}
