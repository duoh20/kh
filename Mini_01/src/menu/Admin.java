package menu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.BookController;
import model.vo.Book;

public class Admin extends JFrame{

BookController bc = new BookController();
ArrayList<Book> b1 = (ArrayList) bc.getBlist();

	
	
	public Admin(String id) {
		

		
		
		
		setSize(400,600);
	
		setLayout(new FlowLayout(FlowLayout.CENTER) );
		
		
		JLabel bookname = new JLabel("책 이름 : ");
		
		bookname.setLocation(20,100);
		bookname.setSize(100,40);
		
		add(bookname); 
		
		
		JTextField bookname2 = new JTextField(25);
		bookname2.setBounds(90,100,250,40);
		add(bookname2);
		
		
		
	
		
		
		
		
		JButton bookAdd = new JButton("추가");
		bookAdd.setBounds(230,260,90,30);
		add(bookAdd);
		

		JButton cancel = new JButton("반납");
		cancel.setBounds(110,260,90,30);
		add(cancel);
		
		
		setVisible(true);
		
		
		JTextArea ar = new JTextArea(20,20);
		ar.setBounds(90,200,250,40);
		
		
		
		
		
		ArrayList<String> Slist = bc.getList();
		
		for(String s:Slist) {
			ar.append(s+"\n");
		}
		
		add(ar);
		ar.setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	
		
	
		// 책 추가 완료 
		
		bookAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
//				Book b = new Book(bookname2.getText(), author2.getText(),  price2.getText() ,"");
//				bookname2.setText("");
//				author2.setText("");
//				price2.setText("");
//				bc.addNewBook(b);
//				JOptionPane.showMessageDialog(null, "책 추가 완료.");
				
				
				Book  b = bc.searchBook2(bookname2.getText()) ;
//				
				bookname2.setText("");
				
				ArrayList al =(ArrayList) bc.getBlist();
				
				if(!al.contains(b)) {
					b=null;
				}
				
				
				if(b!=null) {
					    bc.rentMap(id, b);
					   
				    
				    
				    
				}
				else {
					JOptionPane.showMessageDialog(null, "잘못된 입력 입니다. 다시 시도해주세요.", "danger", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		// 취소 돌아가기 
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Book  b = bc.searchBook2(bookname2.getText()) ;
				bookname2.setText("");
				
				if(b!=null) {
					 if (bc.returnMap(id, b.getTitle())) {
						 JOptionPane.showMessageDialog(null, b.getTitle() +"이 반납되었습니다.");
					 }
					 else {
						 
						 JOptionPane.showMessageDialog(null, "잘못된 입력 입니다. 다시 시도해주세요.", "danger", JOptionPane.ERROR_MESSAGE);
					 }
				}
				else
				{
					JOptionPane.showMessageDialog(null, "잘못된 입력 입니다. 다시 시도해주세요.", "danger", JOptionPane.ERROR_MESSAGE);
				}
				
				dispose();
				
			}
		});
		
		
		
		
	}
	
	
	
}
