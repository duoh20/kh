package com.kh.example.chap03_component.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class F_List {
	public F_List() {
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		
		String[] cities = {"서울", "대전", "대구", "부산", "경기", "인천", "강원", "제주"};
		JList<String> list = new JList<String>(cities); //리스트에 도시 리스트 추가
		
		JPanel resultPanel = new JPanel();
		JLabel label = new JLabel("선택된 항목 : ");
		JTextField selected = new JTextField(10);
		selected.setEditable(false);
	
		resultPanel.add(label);
		resultPanel.add(selected);
		
		//frame.add(list, "North"); //scroller에 list를 담았기 때문에, scroller를 추가해준다.
		frame.add(resultPanel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		JScrollPane scroller = new JScrollPane(list); //list에 스크롤 생성
		scroller.setPreferredSize(new Dimension(200,100));
		frame.add(scroller, "North");
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				List<String> l = list.getSelectedValuesList(); //선택된 것에 대한 리스트를 뽑아오는 메소드, 반환 값은 java.util의 List임! 
				String result = "";
				for(int i = 0; i < l.size(); i++) {
					result += l.get(i) + " ";
				}
				selected.setText(result);
			} //선택된 항목이 TextFiled인 selected에 출력됨, Ctrl. 누른채로 리스트의 아이템을 선택하면 다중 선택 가능
		});
		
		//list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //default, 여러 개 선택 가능
		//list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //한 개만 선택 가능
		//list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); //인접한 것만 여러 개 선택 가능
		list.setBorder(BorderFactory.createLineBorder(Color.red, 10)); //보더 색상이나 굵기 설정 가능
	}
}
