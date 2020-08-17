package MyPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BookController;



public class BookListPanel extends JPanel {

	BookController bc = new BookController();
	
	public BookListPanel(String id) {
		setSize(400, 500);
		
		String[] header = {"책 제목", "타이틀", " 저자", "카테고리", "대여여부"};
		String[][] book = {{"","","","",""}};
		//System.out.println(bc.tableData(id));
		
		JLabel firstTitle = new JLabel("내가 대여한 책");
		firstTitle.setBounds(10, 10, 350, 60);
		firstTitle.setFont(new Font("돋움", Font.BOLD, 27));
		
		DefaultTableModel dtm = new DefaultTableModel(book, header);
		JTable table = new JTable(dtm);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(350, 350));
		table.setLocation(10, 100);
		
		add(firstTitle);
		add(scroll);
	}
}
