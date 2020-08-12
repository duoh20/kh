package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Contoller.BookController;
import model.vo.Book;

public class Scroll  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BookController bc = new BookController();
	
	private Menu frame ; 
	
	public Scroll(Menu frame) {
		
		
		this.frame = frame;
	
		 setSize(400,200);
	
		 setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		JTextField such1 = new JTextField(27);
		
		
		JButton Btn = new JButton("새로고침");
		
		
		
		JLabel such2 = new JLabel("[검색] : ");
		
		add(such2);
		add(such1);
//		add(Btn);
		
		JTextArea	textArea = new JTextArea();
		
		textArea.setFont(new Font("궁서 보통", Font.BOLD, 12));
		textArea.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		
		
		
		
		
		 JScrollPane scroll = new JScrollPane(textArea);
		 scroll.setPreferredSize(new Dimension(350,250));
		 
		 
		 
		 ArrayList<Book> b1 = (ArrayList)bc.getBlist();
		 
		
		 for(Book b2:b1) {
			 
			 textArea.append(b2 + "\n"); 
		 }
		 
		 
		 
		add(scroll);
		
		
		scroll.setVisible(true);
			
			
		 
		such1.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				textArea.setText("");
				 
				JTextField t = (JTextField)e.getSource();
				
				String key = t.getText();
				
				t.setText(""); 
			
				 ArrayList<Book> b1 = (ArrayList)bc.searchBookByTitle(key);
				 
				 if(b1.isEmpty()) {
					
					 textArea.append("검색 결과가 없습니다.\n");
				 }
				 else {
					 for(Book b2:b1) {
						 
						 textArea.append(b2 + "\n"); 
					 }
					 
				 }
				 
				 
			
			}
		});
		
		
		Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 
				 Scroll scroll = new Scroll(frame);
				
				 changePnel(scroll);
				 
				 frame.add(scroll,"South");
			}
		});

		
		 
		
	};
	
	public void changePnel(JPanel panel) {
		
		
		frame.remove(this);
		frame.revalidate();
		frame.repaint();
		
		
	}	

}
