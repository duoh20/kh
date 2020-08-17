package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.BookController;
import model.vo.Book;

public class Scroll extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BookController bc = new BookController();
	ArrayList<Book> b1 = (ArrayList) bc.getBlist();

	private Menu frame;

	public Scroll(Menu frame) {
		
		
		this.frame = frame;
	
		 setSize(400,200);
	
		 setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		JTextField such1 = new JTextField(27);
		
		
		JButton Btn = new JButton("새로고침");
		
		
		
		JLabel such2 = new JLabel("[검색] : ");
		
		add(such2);
		add(such1);
//		add(Btn);
		
		JTextArea	textArea = new JTextArea();
		
		textArea.setFont(new Font("궁서 보통", Font.BOLD, 12));
		textArea.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		
		
		
		
//		
//		 JScrollPane scroll = new JScrollPane(textArea);
//		 scroll.setPreferredSize(new Dimension(350,250));
		 
		 
		 
		 
		 
		
//		 for(Book b2:b1) {
//			 
//			 if(b2.getIsRentalable() == true) {
//			    textArea.append(b2.getBookID() + "" + b2.getTitle()  + " " + b2.getCategory() + " 대여중  \n"); 
//			 }
//			 else {
//				 textArea.append(b2.getBookID() + " " + b2.getTitle()  + " " + b2.getCategory() + " 대여가능  \n"); 
//			 }
//		 }
		 
		 
		 	String [] header = {"책 제목" , "작가" , "장르", "대여 여부"};
		 	String data[][] = new String[0][4];
			
			
			DefaultTableModel dtm = new DefaultTableModel(data,header) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;   //0805  7:17
							// 수정만 안됨
				}
			};
		
			for(Book b2: b1 ) {
				
				if(b2.getIsRentalable() == true) {
					String [] s1 = { b2.getTitle() , b2.getAuthor(), b2.getCategory() , " 대여중  \n"};
					
					dtm.addRow(s1);
//				    textArea.append(b2.getBookID() + "" + b2.getTitle()  + " " + b2.getCategory() + " 대여중  \n"); 
				 }
				 else {
//					 textArea.append(b2.getBookID() + " " + b2.getTitle()  + " " + b2.getCategory() + " 대여가능  \n"); 
					 String [] s1 = { b2.getTitle() , b2.getAuthor(), b2.getCategory() , " 대여가능  \n"};
					dtm.addRow(s1);
				 }
				
		
			}
			
//			Book b3 = b1.get(b1.size()-1);
//			
//			if(b3.getIsRentalable() == true) {
//				String [] s0 = { b3.getTitle() , b3.getAuthor(), b3.getCategory() , " 대여중  \n"};
//				dtm.addRow(s0);
//			 }
//			 else {
//				 String [] s0 = { b3.getTitle() , b3.getAuthor(), b3.getCategory() , " 대여가능  \n"};
//				dtm.addRow(s0);
//			 }
			// 1 . 기본적인 테이블 만들기 
			
			JTable table = new JTable(dtm);
			table.getColumnModel().getColumn(0).setPreferredWidth(200);
			table.getColumnModel().getColumn(1).setPreferredWidth(50);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			
			table.getTableHeader().setReorderingAllowed(false); // 이동 제한 
			
			table.getTableHeader().setResizingAllowed(false);  // 크기 조절 제한 
		
			JScrollPane scroll = new JScrollPane(table);
			scroll.setPreferredSize(new Dimension(350,250));
		 
//			table.getColumnModel().getColumn(0).setPreferredWidth(40);
	  
		 
		add(scroll);
		
		
	
			
			
		 
		such1.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				bc.Open();
				bc= new BookController();
				
				textArea.setText("");
				 
				JTextField t = (JTextField)e.getSource();
				
				String key = t.getText();
				
				t.setText(""); 
				boolean v = bc.searchBookByBookID(key);
				
				
//			
//				 ArrayList<Book> b1 = (ArrayList)bc.searchBookByTitle(key);
//				 
//				 if(b1.isEmpty()) {
//					
//					 textArea.append("검색 결과가 없습니다.\n");
//				 }
//				 else {
//					
//					 dtm.setNumRows(0);
//					 
//					 for(Book b2:b1) {
//						 
//						 if(b2.getIsRentalable() == true) {
//								String [] s1 = { b2.getBookID() , b2.getTitle(), b2.getCategory() , " 대여중  \n"};
//								dtm.addRow(s1);
////							    textArea.append(b2.getBookID() + "" + b2.getTitle()  + " " + b2.getCategory() + " 대여중  \n"); 
//							 }
//							 else {
////								 textArea.append(b2.getBookID() + " " + b2.getTitle()  + " " + b2.getCategory() + " 대여가능  \n"); 
//								 String [] s1 = { b2.getBookID() , b2.getTitle(), b2.getCategory() , " 대여가능  \n"};
//								dtm.addRow(s1);
//							 }
//					 }
//					 
//				 }
				 
				int selectRow = table.getSelectedRow();  // 선택된 ROW 반환
				int colNum = dtm.getColumnCount();
				String[] objArr= new String[colNum];
				
				dtm.setNumRows(0);
		
//					objArr[i] = (String) dtm.getValueAt(selectRow, i);
					
					
			ArrayList<Book> list = (ArrayList<Book>)bc.searchBook(key);
			
					System.out.println(list.size()+" ? ");
					
					
			for (int i = 0; i < list.size(); i++) {
							
				Book b2 = list.get(i);
				
				if( !(list.isEmpty())) {
					
					if(b2.getIsRentalable() == true) {
						String [] s1 = { b2.getTitle() , b2.getAuthor(), b2.getCategory() , " 대여중  \n"};
						System.out.println(b2.getTitle()+" " + b2.getAuthor()+" " + b2.getCategory()+" " +b2.getIsRentalable());
						dtm.addRow(s1);
//					    textArea.append(b2.getBookID() + "" + b2.getTitle()  + " " + b2.getCategory() + " 대여중  \n"); 
					 }
					 else {
//						 textArea.append(b2.getBookID() + " " + b2.getTitle()  + " " + b2.getCategory() + " 대여가능  \n"); 
						 String [] s1 = { b2.getTitle() , b2.getAuthor(), b2.getCategory() , " 대여가능  \n"};
						 System.out.println(b2.getTitle()+" " + b2.getAuthor()+" " + b2.getCategory()+" " +b2.getIsRentalable()+i);
						dtm.addRow(s1);
						
					 }
						 
				}
					 
				
			
				}
		
			if(key.equals("")) {
				
				Book b3 = b1.get(b1.size()-1);
				
				if(b3.getIsRentalable() == true) {
					String [] s0 = { b3.getTitle() , b3.getAuthor(), b3.getCategory() , " 대여중  \n"};
					dtm.addRow(s0);
				 }
				 else {
					 String [] s0 = { b3.getTitle() , b3.getAuthor(), b3.getCategory() , " 대여가능  \n"};
					dtm.addRow(s0);
				 }
			}
			
			bc.saveAll();
			if( (list.isEmpty())) {
		
				
				String [] s1 = {"검색 결과가 없습니다." , "", "" , ""};
				dtm.addRow(s1);
			}
		}
			
	
	});
		
		
		Btn.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {

		Scroll scroll = new Scroll(frame);

		changePnel(scroll);

		frame.add(scroll, "South");
	}

	});

	};

	public void changePnel(JPanel panel) {

		frame.remove(this);
		frame.revalidate();
		frame.repaint();

	}

}
