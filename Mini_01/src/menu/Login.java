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

import controller.BookController;
import controller.MemberController;
import model.vo.Member;


public class Login extends JPanel{

	BookController bc = new BookController();
	MemberController mc = new MemberController();
	private Menu frame ; 
	JTextArea textArea;
	JTextField id2;
	
	
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
		 
		
		id2 = new JTextField(20);
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

		
		
		
		frame.add(this);
		

		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				login2();
			
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
		
		
	
		
		
		id2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				login2();
			}
		});
		
		
	}// end	
	
	public void changePnel(JPanel panel) {
		
		frame.remove(this);
		
		frame.revalidate();
		frame.repaint();
		
		
	}	
	
	public void login2() {
		
		Member v = mc.logIn(id2.getText());
		String s = id2.getText();
		id2.setText("");

		 
		if(v!=null) {
			Login2 page = new Login2(frame , v , s);
			changePnel(page);
		}
		else {
			
			JOptionPane.showMessageDialog(null, "회원이 아닙니다.", "danger", JOptionPane.ERROR_MESSAGE);

		}
	}
}