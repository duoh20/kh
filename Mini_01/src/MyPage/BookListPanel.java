package MyPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Contoller.BookController;



public class BookListPanel extends JPanel {

	BookController bc = new BookController();
	
	public BookListPanel() {
		setSize(800, 800);
		setBackground(Color.pink);
		
		String[] header = {"bookId", "title", " author", "category", "isRentalable"};
		Object[][] data = bc.listBookInfo();
		
		
		JLabel firstTitle = new JLabel("내가 대여한 책");
		firstTitle.setBounds(10, 10, 700, 30);
		firstTitle.setFont(new Font("돋움", Font.BOLD, 27));
		
		DefaultTableModel dtm = new DefaultTableModel(data, header);
		JTable table = new JTable(dtm);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(700,200));
		table.setLocation(10, 100);
		
		
		JTable secondTitle = new JTable(dtm);
		JScrollPane scroll2 = new JScrollPane(secondTitle);
		scroll2.setPreferredSize(new Dimension(700,200));
		table.setSize(700, 350);
		JLabel label2 = new JLabel("나의 대출 기록");
		label2.setSize(200, 200);
		label2.setFont(new Font("돋움", Font.BOLD, 27));
		add(label2, "North");
		add(scroll2, "South");
		
		JButton myMenuBtn = new JButton("내 정보 설정");
		JButton toMainBtn = new JButton("메인으로");
		myMenuBtn.setPreferredSize(new Dimension(700,50));
		toMainBtn.setPreferredSize(new Dimension(700,50));
		toMainBtn.setLocation(50,700);
		
		add(firstTitle);
		add(scroll);
		add(myMenuBtn);
		add(toMainBtn);
	}
}
