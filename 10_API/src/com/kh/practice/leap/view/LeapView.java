package com.kh.practice.leap.view;

import java.util.*;

import com.kh.practice.leap.controller.LeapController;

public class LeapView {
	LeapController lc = new LeapController();

// 나의 풀이
//	public LeapView() {
//		Calendar c = Calendar.getInstance();
//		int year = c.get(Calendar.YEAR);
//		
//		String yearInfo ="";
//		if(lc.isLeapYear(year)) {
//			yearInfo = "윤년";
//		} else {
//			yearInfo = "평년";
//		}
//		
//		long dateCount = lc.leapDate(c);
//		
//		System.out.println(year + "년은 " + yearInfo + "입니다.");
//		System.out.println("총 날짜 수 : " + dateCount);
//	}
	
	public LeapView() {
		Calendar c = new GregorianCalendar();
		int year = c.get(Calendar.YEAR);
		
		boolean leap = lc.isLeapYear(year);
		if(leap) {
			System.out.println(year + "년은 윤년입니다.");
		} else {
			System.out.println(year + "년은 평년입니다.");
		}
		
		System.out.println("총 날짜 수 : " + lc.leapDate(c));
	}
}