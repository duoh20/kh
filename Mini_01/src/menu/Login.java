package menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Contoller.BookController;
import Contoller.MemberController;
import model.vo.Member;


public class Login extends JPanel{

	BookController bc = new BookController();
	MemberController mc = new MemberController();
	private Menu frame ; 
	JTextArea textArea;
	
	
	
	public Login(Menu frame) {
		
		this.frame = frame;
		
		setSize(400,400);
		

		setLayout(null);
		
		JLabel Title = new JLabel("KH 도서관");
		Title.setFont(new Font("궁서 보통", Font.BOLD, 20));
		Title.setBounds(165, 10, 100, 80);
		add(Title);
		
		JLabel id1 = new JLabel("회원 번호 : ");
		
		id1.setLocation(25,100);
		id1.setSize(100,120);
		
		add(id1);
		 
		
		JTextField id2 = new JTextField(20);
		id2.setBounds(100,140,180,40);
		add(id2);
		 
		
		
		JButton loginBtn = new JButton("로그인");
		loginBtn.setBounds(290,140,90,40);
		add(loginBtn);
		

		JButton joinBtn = new JButton("회원가입");
		joinBtn.setBounds(290,190,90,20);
		add(joinBtn);
		
		
	
		JButton logoutBtn = new JButton("로그 아웃");
		logoutBtn.setBounds(280,140,100,40);
		add(logoutBtn);
		logoutBtn.setVisible(false);
		
		
		JButton adminpage = new JButton("관리자설정");
		adminpage.setBounds(280,190,100,20);
		adminpage.setVisible(false);
		add(adminpage);
		
		JButton mypage = new JButton("마이페이지");
		mypage.setBounds(280,190,100,20);
		mypage.setVisible(false);
		add(mypage);
		
		JLabel view = new JLabel();
		view.setBounds(70,135,200,50);
//		
//		JButton saveBtn = new JButton("저장");
//		saveBtn.setBounds(280,250,90,40);
//		add(saveBtn);
		
		
		
//		JTextField such1 = new JTextField();
//		such1.setBounds(15,300,365,25);
//		add(such1);
//		
//		
//		JLabel such2 = new JLabel("[ 검색 ]");
//		such2.setBounds(15,250,365,25);
//		add(such2);
//		
//		
//		
//		textArea = new JTextArea(10,30);
//		textArea.setEditable(false);
//		textArea.setBounds(15, 250, 365, 300);
//		textArea.setFont(new Font("궁서 보통", Font.BOLD, 12));
//		textArea.setBorder(BorderFactory.createLineBorder(Color.gray));
//		textArea.setVisible(false);
		
		
		  
		 
		 
		

		 
		
		
		
		
//		 ArrayList<Book> fb = bc.getBlist();
//		 
//		 for(Book fb2:fb) {
//			 
//			 textArea.append(fb2 + "\n"); 
//		 }
//		
//		add(textArea);
		
		
		
		
		frame.add(this);
		
//		such1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
////				textArea.setText("");
//				 
//				JTextField t = (JTextField)e.getSource();
//				
//				String key = t.getText();
//				
//				t.setText(""); 
//				
//				 ArrayList<Book> b1 = bc.searchBook("");
//				 
//				 
//				 for(Book b2:b1) {
//					 
//					 textArea.append(b2 + "\n"); 
//				 }
//				 
//				 Scroll scroll = new Scroll(frame, textArea);
//				 
//				 frame.add(scroll);
//
//			
//				
//				 
//			
//			}
//		});
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				Member v =mc.logIn(id2.getText());
				id2.setText("");
//				
				System.out.println(v);
				
//				
//				if(v!=null) {
//					
//					id1.setVisible(false); 
//					id2.setVisible(false);
//					loginBtn.setVisible(false);
//					joinBtn.setVisible(false);
//					logoutBtn.setVisible(true);
//					
//					
//					if(v.getPower() == true) {
//						
//						
//						
//						
//						adminpage.setVisible(true);
//						view.setText(v.getName()+" 관리자님  환영합니다.");
//						add(view);
//						JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
//						
//					}
//					else {
//						
//						
//						
//						mypage.setVisible(true);
//						view.setText(v.getName()+" 회원님  환영합니다.");
//						add(view);
//						JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
//					}
//					
//				}
//				else {
//					
//					JOptionPane.showMessageDialog(null, "회원이 아닙니다.", "danger", JOptionPane.ERROR_MESSAGE);
//					id2.requestFocus();
//					bc.showMlist();
//		
//				}
				
				if(v!=null) {
					Login2 page = new Login2(frame , v);
					changePnel(page);
				}
				else {
					
					JOptionPane.showMessageDialog(null, "회원이 아닙니다.", "danger", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		
		
		
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				id1.setVisible(true);
				id2.setVisible(true);
				loginBtn.setVisible(true);
				logoutBtn.setVisible(false);
				joinBtn.setVisible(true);
				mypage.setVisible(false);
				adminpage.setVisible(false);
				view.setText("");
				add(view);
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				
				
			}
		});
		
		
		joinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				Join page = new Join(frame);
				changePnel(page);
				
				
				
			}
		});
		
		
		

//		mypage.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				
//			}
//		});
//		
//		adminpage.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				Dialog dialog = new Dialog(frame , "관리자 설정");
//				
//			
//				
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
//						int p =  Integer.parseInt(s);  
//						Book b = new Book(bookname2.getText(), author2.getText(),  p );
//						bc.insertBook(b);
//						bc.Save();
//						bc.Open();
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
//			}
//		});
		
		
	}// end
	
	
	
	
	public void changePnel(JPanel panel) {
		
		frame.remove(this);
		
		frame.revalidate();
		frame.repaint();
		
		
	}	
}
