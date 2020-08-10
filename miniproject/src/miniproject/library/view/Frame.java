package miniproject.library.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	JPanel p = new JPanel();
	
	public Frame() {
		super("도서관리 프로그램");
		setSize(800, 800);
		setLayout(null);
		
		p.setBounds(300, 300, 200, 200);
		
		JButton btn = new JButton("일단 눌러바");
		btn.setBounds(100, 100, 100, 100);
		JLabel label = new JLabel("나의 대출 기록으로 이동합니다.");
		p.add(btn);
		p.add(label);
		
		add(p);
				
		btn.addMouseListener(new Frame$MouseEvent());
		
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class Frame$MouseEvent extends MouseAdapter { //내부 클래스로 마우스 어뎁터 클래스 상속
		@Override
		public void mouseClicked(MouseEvent e) {
			remove(p); //기존 패널 지우고
			add(new BookListPanel()); //나의 대출 기록 패널 열기
			revalidate(); //초기화(?)
			repaint(); //초기화
		}
	}
}
