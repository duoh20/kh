package miniproject.library.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
		
	public Frame() {
		super("도서관리 프로그램");
		setSize(800, 800);
		setLayout(null);

		add(new BookListPanel()); //나의 대출 기록 패널 열기
		revalidate();
		repaint();
		
		this.setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
