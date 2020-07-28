package com.kh.practice.leap.controller;

import java.util.Calendar;

public class LeapController {
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && year % 100 != 0 || year % 300 == 0 ) {
			return true;
		}
		return false;
	}
	
	public long leapDate(Calendar c) {
		long dateCount = 0;
		int start = 0;
		int year = c.get(Calendar.YEAR);
		
		while(start <= year) {
			if(isLeapYear(year)) {
				dateCount += 366;
				start++;
			} else {
				dateCount += 365;
				start++;
			}
		}
		return dateCount;
	}
}
