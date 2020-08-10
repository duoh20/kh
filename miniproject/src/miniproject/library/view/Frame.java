package miniproject.library.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	public Frame() {
		super("도서관리 프로그램");
		setSize(800, 800);
		setLayout(null);
		
		JPanel p = new JPanel();
		p.setBounds(200, 200, 200, 200);
		
		JButton btn = new JButton("일단 눌러바");
		btn.setBounds(100, 100, 100, 100);
		JLabel label = new JLabel("누르세요.");
		p.add(btn);
		p.add(label);
		
		add(p);
				
		//btn.addMouseListener(new FrameEvent());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	class FrameEvent extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			new BookListPanel(this);
		}
	}
}
