package MyPage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
		
	public Frame() {
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