package menu;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Menu extends JFrame {

	public void mainMenu() {

		setSize(400, 600);

		Login Login = new Login(this);

		add(Login, "Center");
		
		

		setTitle("도서관 관리 프로그램");

		setResizable(false);

		Scroll scroll = new Scroll(this);

		add(scroll, "South");

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
