package com.kh.example.chap03_component.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class J_Table {
	public J_Table() {
		JFrame frame = new JFrame();
		
		//집어 넣을 데이터 만들기
		
		String[] header = {"이름", "자바", "디비", "화면"};
		Object[][] data = {{"강건강", 100, 95, 85},
						   {"남나눔", 58, 95, 78},
						   {"도대담", 42, 14, 100},
						   {"류라라", 65, 72, 55}};
		//1. 기본적인 테이블 만들기
		//JTable table = new JTable(data, header);
		////frame.add(table);
		//JScrollPane scroll = new JScrollPane(table);		
		//scroll.setPreferredSize(new Dimension(200, 80));
		//frame.add(scroll);
		
		//DefaultTableModel dtm = new DefaultTableModel(data, header);
		DefaultTableModel dtm = new DefaultTableModel(data, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; //테이블 수정 못하도록 overriding해서 수정
			}
		};
		JTable table = new JTable(dtm);
		JScrollPane scroll = new JScrollPane(table);
		frame.add(scroll, "North");		
		
		//데이터(행) 추가
		Object[] addArr = {"문미미", 58, 75, 17};
		dtm.addRow(addArr);
		
		//행과 열 개수 구하기
		System.out.println("행 : " + dtm.getRowCount()); //header는 포함 안함
		System.out.println("열 : " + dtm.getColumnCount());
	
		System.out.println("열 이름: " + dtm.getColumnName(0)); //해당하는 열의 이름 가져오기
		dtm.removeRow(0); //지정 인덱스 행 삭제
		System.out.println(dtm.getValueAt(1, 2)); // 지정 인덱스 행, 열에 해당하는 데이터 가져오기
		dtm.setValueAt(5000, 2, 2); // 지정 인덱스 행, 열에 해당하는 데이터 변경
		table.setRowSelectionInterval(0, 2); //지정 행이 미리 선택된 상태로 열림 (index1 <= 범위 <= index2)
		
		//테이블 조작 관련 설정
		table.getTableHeader().setReorderingAllowed(false); //테이블의 열 순서 변경 불가
		table.getTableHeader().setResizingAllowed(false); //테이블 열 간격 변경 불가
		//table.setEnabled(false); //테이블 값 수정 + 행 선택 불가 (read only)
		//테이블 값 수정 못하고 행 선택만 가능하게 하고 싶다면, isCellEitable()을 오버라이딩해야함
		
		//테이블 클릭하면 자료가 보이게 만들기
		
		JPanel select = new JPanel();
		JTextArea ta = new JTextArea(10, 30);
		select.add(ta);
		frame.add(select, "South");		
		
		table.addMouseListener(new MouseListener() { //5개 메소드를 오버라이딩 해야함

			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = table.getSelectedRow(); //몇 번째 행을 선택했는지를 가져옴
				int colNum = table.getColumnCount(); //한 행씩 읽고 "\n"하기 위해 열의 크기를 알아옴
				Object[] objArr = new Object[colNum];
				for(int i = 0; i < objArr.length; i++) {
					objArr[i] = dtm.getValueAt(selectRow, i);
					
					if(i == colNum -1/*마지막 열이라면*/) {
						ta.append(objArr[i] + "\n"); //개행 문자 추가하여 띄어쓰기
					} else {
						ta.append(objArr[i] + " "); //열 사이에 공백 넣어서 행 정보 출력
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
}
