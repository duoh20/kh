package com.kh.example.chap03_component.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class E_ComboBox {
	public E_ComboBox() { //콤보 박스 (=드랍 다운 박스)
		JFrame frame = new JFrame("ComboBox"); //컨테이너 생성
		frame.setSize(300, 200);
		
		String[] animals = {"dog", "cat", "tiger"};
		
		JComboBox<String> animalList = new JComboBox<String>(animals); //JComboBox는 타입 제한 필요, animals 배열의 타입인 String으로 제한
		animalList.setSelectedIndex(1); //배열의 인덱스에 대응하는 요소가 콤보 박스 기본 값으로 노출 (이 예제에서는 cat이 기본 값으로 노출)
		
		JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		
		frame.add(animalList, "North"); //생성한 animalList 콤보 박스를 컨테이너에 추가
		frame.add(label, "South");
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		//콤보 박스의 아이템을 누르면 대응하는 동물 이미지가 나오는 이벤트 추가
		animalList.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox<String> cb = (JComboBox<String>)e.getSource();
					String name = (String)cb.getSelectedItem(); //사진을 불러오는 이름 역할
					Image img = new ImageIcon("image/" + name + ".PNG").getImage().getScaledInstance(150, 150, 0); //name에 대응하는 이미지 불러옴
					label.setIcon(new ImageIcon(img)); //이미지 라벨을 불러옴
				}				
		});
	}
	
}
