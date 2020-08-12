package admin;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class page3 extends JFrame{
	
	
	public page3() {
		
		
		JFrame frame = new JFrame();
//		JPanel panel = new JPanel();
		
//		super("KH도서관");
		setBounds(700,150,400,600);
		setTitle("KH도서관");
		setLayout(null);
		
		
		JButton addbook = new JButton("책 추가");
		Dialog addbook1 = new Dialog(frame, "책 추가");
		addbook1.setBounds(700,150,400,600);
		addbook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addbook1.setVisible(true);
			}
		});
		

		
		JButton button1= new JButton("닫기");
		addbook1.add(button1,"South");
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addbook1.dispose();
			}
		});
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,2));
		panel1.setSize(400, 150);
		
		JTextField addbook2 = new JTextField(20);
		panel1.add(new JLabel("추가할 책 제목을 입력하세요."));
		panel1.add(addbook2);
		
		JTextArea textArea = new JTextArea(10,30);
		
		JButton addbutton  = new JButton("추가");
		panel1.add(addbutton);
		
		addbook1.add(panel1, BorderLayout.NORTH);
		addbook1.add(textArea, BorderLayout.CENTER);
//		addbook1.add(addbutton, BorderLayout.SOUTH);
		
		addbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String title = addbook2.getText() + "\n";
				System.out.println(title);
				addbook2.setText("");
				
				textArea.append("제목 : " + title );
				addbook2.requestFocus();
			}
		});
		
		
		JButton delbook = new JButton("책 삭제");
		Dialog delbook1 = new Dialog(frame, "책 삭제");
		delbook1.setBounds(700,150,400,600);
		delbook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delbook1.setVisible(true);
			}
		});
		
		JButton button2= new JButton("닫기");
		delbook1.add(button2,"South");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delbook1.dispose();
			}
		});
		
		
		JButton bookinfo = new JButton("책 정보 수정");
		Dialog bookinfo1 = new Dialog(frame, "책 정보 수정");
		bookinfo1.setBounds(700,150,400,600);
		bookinfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bookinfo1.setVisible(true);	
			}
		});
		
		JButton button3= new JButton("닫기");
		bookinfo1.add(button3,"South");
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bookinfo1.dispose();
			}
		});
		
		
		JButton overlist = new JButton("연체자 목록");
		Dialog overlist1 = new Dialog(frame, "연체자 목록");
		overlist1.setBounds(700,150,400,600);
		overlist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				overlist1.setVisible(true);				
			}
		});
		
		JButton button4= new JButton("닫기");
		overlist1.add(button4,"South");
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				overlist1.dispose();
			}
		});
		
		JButton member = new JButton("회원관리");
		Dialog member1 = new Dialog(frame, "회원관리");
		member1.setBounds(700,150,400,600);
		member.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				member1.setVisible(true);				
			}
		});
		
		JButton button5= new JButton("닫기");
		member1.add(button5,"South");
		button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				member1.dispose();
			}
		});
		
		
		addbook.setBounds(50, 50, 280, 70);
		delbook.setBounds(50, 150, 280, 70);
		bookinfo.setBounds(50, 250, 280, 70);
		member.setBounds(50, 350, 280, 70);
		overlist.setBounds(50, 450, 280, 70);
		
		
		add(addbook);
		add(delbook);
		add(bookinfo);
		add(overlist);
		add(member);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
