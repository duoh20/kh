package MyPage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {
		
	public Frame(String id) {
		super("도서관리 프로그램");
		setSize(400, 600);
		setLayout(null);
		
		add(new BookListPanel(id)); //나의 대출 기록 패널 열기
		revalidate();
		repaint();
		
		JButton toMainBtn = new JButton("메인으로");
		toMainBtn.setBounds(25, 500, 350, 50);
		add(toMainBtn);
		
		toMainBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
