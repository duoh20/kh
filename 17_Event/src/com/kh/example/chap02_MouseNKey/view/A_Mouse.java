package com.kh.example.chap02_MouseNKey.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class A_Mouse extends JFrame implements MouseListener, MouseMotionListener { //마우스의 모든 이벤트를 사용하려면 implements해도 괜찮지만, 한 두 개 이벤트만 사용하고 싶다면 Adaptor 클래스를 활용하자.

	//implements하면 5 개 메소드를 구현해야한다
	
	public A_Mouse() {
		setSize(300, 200);
		
		JPanel panel = new JPanel();
		//panel.addMouseListener(this); //내 클래스가 MouseListener를 구현하고 있으니까 this로 받아옴
		panel.addMouseMotionListener(this); //내 클래스가 MouseListener를 구현하고 있으니까 this로 받아옴
		
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void display(String s, MouseEvent e) {
		System.out.println(s + " x = " + e.getX() + ", y =" + e.getY()); //getX(), getY():마우스를 클릭한 x, y 좌표 리턴
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		display("MoseClicked (# of clicks : "+ e.getClickCount() +")", e); //getClickCount(): 마우스를 연속 클릭한 카운트 반환, mouseClicked: 한 번 씩 짧게 클릭
	}

	@Override
	public void mousePressed(MouseEvent e) {
		display("Mouse pressed (# of clicks : " + e.getClickCount()  + ")", e); //mousePressed: 마우스 꾹 누르기
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		display("Mouse released (# of clicks : " + e.getClickCount()  + ")", e); //mouseReleased: 마우스 꾹 누르다가 놓기
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		display("Mouse enter", e); //mouseEntered: 마우스 커서가 UI로 들어옴
	}

	@Override
	public void mouseExited(MouseEvent e) {
		display("Mouse exited", e); //mouseReleased: 마우스 커서가 UI에서 나감
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		display("Mouse dragged", e); //mouseEntered: 마우스 드래그
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		display("Mouse moved", e); //mouseEntered: 마우스 움직임
		
	}

}
