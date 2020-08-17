package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MemberController;
import model.vo.Member;

public class Join extends JPanel {

	MemberController mc = new MemberController();
	
	private Menu frame ;
	
	
	public Join(Menu frame) {
		

		
		
		this.frame = frame;
		
		
		setSize(400,600);
	
		setLayout(null);
		
		JLabel id1 = new JLabel("회원 번호 : ");
		
		id1.setLocation(20,100);
		id1.setSize(100,40);
		
		add(id1); 
		
		
		JTextField id2 = new JTextField(20);
		id2.setBounds(90,100,250,40);
		add(id2);
		
		
		
		JLabel name1 = new JLabel("이        름 : ");
		
		name1.setLocation(20,150);
		name1.setSize(100,40);
		
		add(name1);
		
		 
		JTextField name2 = new JTextField(20);
		name2.setBounds(90,150,250,40);
		add(name2);
		
		
		JLabel phone1 = new JLabel("전화번호 : ");
		
		phone1.setLocation(20,200);
		phone1.setSize(100,40);
		
		add(phone1);
		
		
		JTextField phone2 = new JTextField(20);
		phone2.setBounds(90,200,250,40);
		add(phone2);
		
		
		
		
		JButton loginBtn = new JButton("가입완료");
		loginBtn.setBounds(230,260,90,30);
		add(loginBtn);
		

		JButton joinBtn = new JButton("취소");
		joinBtn.setBounds(110,260,90,30);
		add(joinBtn);
		

		frame.add(this);
		
		
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Member m = new Member( id2.getText(),name2.getText(),phone2.getText() );
				
				System.out.println("가입 정보" +id2.getText()+ name2.getText()+phone2.getText());

				System.out.println(id2.getText());
				
			
			
				if (mc.join(id2.getText(),m) && (id2.getText() != null)) {
					System.out.println("성공적으로 회원가입 완료하였습니다.");
					
					
					
				} else {
					System.out.println("중복된 아이디이거나 잘못된 입력 입니다. 다시 시도해주세요.");
					JOptionPane.showMessageDialog(null, "중복된 아이디이거나 잘못된 입력 입니다. 다시 시도해주세요.", "danger", JOptionPane.ERROR_MESSAGE);//   x
				}
				Login page = new Login(frame);
				changePnel(page);
				
			}
		});
		
		
		
		
		joinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Login page = new Login(frame);
				changePnel(page);
				
			}
		});
		
		
		
		
	}
	
	
	
	public void changePnel(JPanel panel) {
		
		frame.remove(this);
		
		frame.revalidate();
		frame.repaint();
		
		
	}	
	
}
