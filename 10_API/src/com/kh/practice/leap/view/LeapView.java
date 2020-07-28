package com.kh.practice.leap.view;

import java.util.Calendar;

import com.kh.practice.leap.controller.LeapController;

public class LeapView {
	LeapController lc = new LeapController();
	
	public LeapView() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		
		String yearInfo ="";
		if(lc.isLeapYear(year)) {
			yearInfo = "윤년";
		} else {
			yearInfo = "평년";
		}
		
		long dateCount = lc.leapDate(c);
		
		System.out.println(year + "년은 " + yearInfo + "입니다.");
		System.out.println("총 날짜 수 : " + dateCount);
		System.out.println(c);
	}
}
