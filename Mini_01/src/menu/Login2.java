package menu;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import Contoller.MemberController;
import MyPage.Frame;
import admin.page3;
import model.vo.Member;

public class Login2 extends JPanel{

	private Menu frame ;
	MemberController mc = new MemberController();
	
	public Login2(Menu frame, Member v) {
		
		this.frame = frame;
		
		setLayout(null);
		
		JLabel Title = new JLabel("KH 도서관");
		Title.setFont(new Font("궁서 보통", Font.BOLD, 20));
		Title.setBounds(165, 10, 100, 80);
		add(Title);
		
		JButton logoutBtn = new JButton("로그 아웃");
		logoutBtn.setBounds(280,140,100,40);
		add(logoutBtn);
		
		
		JButton adminpage = new JButton("관리자설정");
		adminpage.setBounds(280,190,100,20);
		
		JButton mypage = new JButton("마이페이지");
		mypage.setBounds(280,190,100,20);
		
		
		JLabel view = new JLabel();
		view.setBounds(70,135,200,50);
		
		frame.add(this);
		
		
		System.out.println(v);
		
		if(v!=null) {
			
			
			
			if(v.getPower() == true) {
				
				
				
				
				add(adminpage);
				
				
				view.setText(v.getName()+" 관리자님  환영합니다.");
				add(view);
				JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
				
			}
			else {
				
				
				
				add(mypage);
				

				view.setText(v.getName()+" 회원님  환영합니다.");
				add(view);
				JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
			}
			
		}
	
		
	
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Login page = new Login(frame);
				changePnel(page);
				
			}
		});
		
		
		mypage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Frame page = new Frame();
				Dialog dialog = new Dialog(page , "회원 설정");
			}
		});
		
		adminpage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				page3 page=new page3(); 
				Dialog dialog = new Dialog(page , "관리자 설정");
				
			
				
//				dialog.setLayout(new FlowLayout(FlowLayout.CENTER) );
//				dialog.setBounds(150,250,400,600);
//				
//				
//				JLabel bookname = new JLabel("책 이름 : ");
//				
//				bookname.setLocation(20,100);
//				bookname.setSize(100,40);
//				
//				dialog.add(bookname); 
//				
//				
//				JTextField bookname2 = new JTextField(25);
//				bookname2.setBounds(90,100,250,40);
//				dialog.add(bookname2);
//				
//				
//				
//				JLabel author = new JLabel("작가 명 : ");
//				
//				author.setLocation(20,150);
//				author.setSize(100,40);
//				
//				dialog.add(author);
//				
//				 
//				JTextField author2 = new JTextField(25);
//				author2.setBounds(90,150,250,40);
//				dialog.add(author2);
//				
//				
//				JLabel price = new JLabel("가     격 : ");
//				
//				price.setLocation(20,200);
//				price.setSize(100,40);
//				
//				dialog.add(price);
//				
//				
//				JTextField price2 = new JTextField(25);
//				price2.setBounds(90,200,250,40);
//				dialog.add(price2);
//				
//				
//				
//				
//				JButton bookAdd = new JButton("추가");
//				bookAdd.setBounds(230,260,90,30);
//				dialog.add(bookAdd);
//				
//
//				JButton cancel = new JButton("취소");
//				cancel.setBounds(110,260,90,30);
//				dialog.add(cancel);
//				
//				dialog.setVisible(true);
//				
//				
//				
//				
//			
//				
//				
//				bookAdd.addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						String s = price2.getText();
//						
//						Book b = new Book(bookname2.getText(), author2.getText(),  price2.getText() );
//						bc.insertBook(b);
//						System.out.println(b);
//						bc.Save();
//						
//						
//						
//						dialog.dispose();
//						
//					}
//				});
//				
//				cancel.addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						
//						dialog.dispose();
//					}
//				});
//
			}
			
		});
		
		
	}
	
		public void changePnel(JPanel panel) {
				
				frame.remove(this);
				
				frame.revalidate();
				frame.repaint();
				
				
			}	
}
