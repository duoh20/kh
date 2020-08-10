package miniproject.library.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.library.view.Frame.FrameEvent;

public class BookListPanel extends JPanel {
	
	public BookListPanel(FrameEvent frameEvent) {
		setSize(300, 400);
		setBackground(Color.blue);
		
		JButton btn = new JButton();
		btn.add(new JLabel("방가워"));
		
		setVisible(true);
	}
	
	public void openBookListPanel(Frame frame) {
		frame.add(this);
	}
	
	class BookListPanel$MouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	}
}
