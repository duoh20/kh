package miniproject.library.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

		public MainFrame() {
			setTitle("도서관 관리 프로그램");
			setSize(800, 600);
			
			JPanel p = new JPanel();
			JButton b = new JButton("버튼");
			
			add(p);
			add(b, "South");
			add(new Frame());
			revalidate();
			repaint();
			
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
}
