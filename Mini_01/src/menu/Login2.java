package menu;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import MyPage.Frame;
import admin.page3;
import controller.BookController;
import controller.MemberController;
import model.vo.Member;

public class Login2 extends JPanel{

	private Menu frame ;
	MemberController mc = new MemberController();
	BookController bc = new BookController();
	
	public Login2(Menu frame, Member v, String id) {
		
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
				
				
				int result = JOptionPane.showConfirmDialog(null, "이 기능은 미구현 입니다. \n 프로토타입의 기능을 확인 했습니다. \n 실행 시키시겠습니까? \n( 아니오를 누르시면 미구현 기능이 실행됩니다. )" , "확인창", JOptionPane.YES_NO_OPTION);
				
				if(result == 0 ) {
					Admin page = new Admin(id); 
					Dialog dialog = new Dialog(page , "관리자 설정");
				}
				else {
					Frame page = new Frame(id);
					Dialog dialog = new Dialog(page , "회원 설정");
				}
//				Admin page = new Admin(id); 
//				Dialog dialog = new Dialog(page , "관리자 설정");
			}
		});
		
		adminpage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				page3 page=new page3(); 
				Dialog dialog = new Dialog(page , "관리자 설정");
				
			
				
				
				

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
