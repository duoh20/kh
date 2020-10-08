package ncs.test7;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScoreFrame extends JFrame {
	private JTextField score = new JTextField();
	private JTextField total = new JTextField();
	private JTextField average = new JTextField();
	private JTextField sqlScore = new JTextField();
	private JButton calcBtn = new JButton("계산하기");
	
	public ScoreFrame() {
		setTitle("문제 7");
		setSize(400, 350);
		setLayout(null);	
		
		JLabel notion = new JLabel("점수를 입력하세요");
		notion.setFont(new Font("굴림", Font.PLAIN, 42));
		notion.setBounds(20, 20, 400, 50);
		
		JLabel javaLabel = new JLabel("자바 : ");
		javaLabel.setBounds(20, 90, 60, 30);
		score.setBounds(60, 90, 120, 30);
		
		JLabel sqlLabel = new JLabel("SQL : ");
		sqlLabel.setBounds(210, 90, 60, 30);
		sqlScore.setBounds(250, 90, 120, 30);		
		
		calcBtn.setBounds(150, 170, 100, 35);
		
		JLabel totalLabel = new JLabel("총점 : ");
		totalLabel.setBounds(20, 260, 60, 30);
		total.setBounds(60, 260, 120, 30);
		total.setEnabled(false);
		
		JLabel averageLabel = new JLabel("평균 : ");
		averageLabel.setBounds(210, 260, 60, 30);
		average.setBounds(250, 260, 120, 30);	
		average.setEnabled(false);
		average.setFont(new Font("굴림", Font.PLAIN, 30));
		average.setSelectedTextColor(new Color(1));
		
		add(notion);
		add(javaLabel);
		add(score);
		add(sqlLabel);
		add(sqlScore);
		add(calcBtn);
		add(totalLabel);
		add(total);
		add(averageLabel);
		add(average);
		
		calcBtn.addActionListener(new ScoreFrame$ActionHandler());
		
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ScoreFrame$ActionHandler implements ActionListener {
		
		public ScoreFrame$ActionHandler() {}
		
		public void actionPerformed(ActionEvent event) {
<<<<<<< HEAD
		if(event.getSource() == calcBtn) {
			int a = Integer.parseInt(score.getText());
			int b = Integer.parseInt(sqlScore.getText());
			
			total.setText(a + b + "");
			average.setText((a+b)/2 + "");
		}
=======
			if(event.getSource() == calcBtn) {
				int a = Integer.parseInt(score.getText());
				int b = Integer.parseInt(sqlScore.getText());
				
				total.setText(a + b + "");
				average.setText((a+b)/2 + "");
			}
>>>>>>> 91622fa8893134b9e02cf2efb1f226cbd4820691
		}
	}
}