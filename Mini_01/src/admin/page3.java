package admin;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.BookController;
import model.vo.Book;

public class page3 extends JFrame{

	BookController bc = new BookController();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public page3() {


		JFrame frame = new JFrame();
		//		JPanel panel = new JPanel();

		//		super("KH도서관");
		setBounds(700,150,400,600);
		setTitle("KH도서관");
		setLayout(null);


		JButton addbook = new JButton("책 추가");
		Dialog addbook1 = new Dialog(frame, "책 추가");
		addbook1.setBounds(700,150,800,800);
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
		panel1.setLayout(new GridLayout(5,2));
		panel1.setSize(400, 200);

		JTextField addbook5 = new JTextField(20);
		panel1.add(new JLabel("추가할 책의 번호를 입력하세요 : "));
		panel1.add(addbook5);
		
		JTextField addbook2 = new JTextField(20);
		panel1.add(new JLabel("추가할 책의 제목을 입력하세요 : "));
		panel1.add(addbook2);

		JTextField addbook3 = new JTextField(20);
		panel1.add(new JLabel("추가할 책의 작가를 입력하세요 : "));
		panel1.add(addbook3);

		JTextField addbook4 = new JTextField(20);
		panel1.add(new JLabel("추가할 책의 장르를 입력하세요 : "));
		panel1.add(addbook4);

		

		JTextArea textArea = new JTextArea(10,30);

		JButton addbutton = new JButton("확인");
		panel1.add(addbutton);

		addbook1.add(panel1, BorderLayout.NORTH);
		addbook1.add(textArea, BorderLayout.CENTER);
		//		panel1.add(addbutton, BorderLayout.SOUTH);

		addbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {



				String title = addbook2.getText() + "\n";
				String author = addbook3.getText() + "\n";
				String category = addbook4.getText() + "\n";
				String bookID = addbook5.getText() + "\n";
				System.out.println(title+author+category+bookID);
				addbook2.setText("");


				textArea.append("제목 : " + title + "작가 : " + author + "장르 : " +category+ "책 번호 :  "+bookID+"\n" );

				addbook2.requestFocus();
				addbook3.requestFocus();
				addbook4.requestFocus();
				addbook5.requestFocus();

				Book b = new Book(bookID,title, author,  category );
				addbook2.setText("");
				addbook3.setText("");
				addbook4.setText("");
				addbook5.setText("");
				bc.addNewBook(b);
				JOptionPane.showMessageDialog(null, "책 추가 완료.");

			}
		});

		//				try{
		//					FileWriter fw =new FileWriter("bookFile.txt",true);    //파일명과 같은 파일명이 존재할시 덧붙여쓸여부판단
		//					BufferedWriter bf=new BufferedWriter(fw);
		//
		//					bf.write(addbook2.getText()+" ");
		//					bf.write(addbook3.getText()+" ");
		//					bf.write(addbook4.getText()+"\n");    //마지막은 입력후 한줄 내린다.
		//
		//					bf.close();        //저장 후 텍스트필드의 값을 가져온 자원들을 해제한다.
		//
		//					addbook2.setText("");
		//					addbook3.setText("");
		//					addbook4.setText("");
		//
		//					FileReader fr=new FileReader("bookFile.txt");    //String형으로 파일을 읽어온다.
		//					BufferedReader br=new BufferedReader(fr);    //한줄씩읽기위해(그리고 빠른속도로 읽어들인다)
		//					String str=null;        //while조건부
		//
		//					while((str=br.readLine())!=null){
		//						System.out.println(str);        //null이 될때까지 한줄씩 읽어온다.
		//					}
		//
		//					br.close();        //읽어온 자원들을 해제한다.
		//				}catch(Exception n){
		//					System.out.println(n);
		//				}




		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

		JButton delbook = new JButton("책 삭제");
		Dialog delbook1 = new Dialog(frame, "책 삭제");
		delbook1.setBounds(700,150,400,600);
		delbook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "미구현 기능 입니다.");
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
				JOptionPane.showMessageDialog(null, "미구현 기능 입니다.");
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
				JOptionPane.showMessageDialog(null, "미구현 기능 입니다.");
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
				JOptionPane.showMessageDialog(null, "미구현 기능 입니다.");
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
	}



}




















