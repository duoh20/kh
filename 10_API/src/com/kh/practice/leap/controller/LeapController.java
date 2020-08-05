package com.kh.practice.leap.controller;

import java.util.Calendar;

public class LeapController {
	public boolean isLeapYear(int year) { //평년인지 윤년인지 검증하는 메소드
		if(year % 4 == 0 && year % 100 != 0 || year % 300 == 0 ) {
			return true;
		}
		return false;
	}
	
//나의 풀이 (오답)
//이번년까지의 전 일 수를 구해서 의도에 맞지 않음
//	public long leapDate(Calendar c) {
//		long dateCount = 0;
//		int start = 1; //0년부터 구해서 1년치 일 수가 더 더해진 오류 있음
//		int year = c.get(Calendar.YEAR);
//		
//		while(start <= year) {
//			if(isLeapYear(year)) {
//				dateCount += 366;
//				start++;
//			} else {
//				dateCount += 365;
//				start++;
//			}
//		}
//		return dateCount;
//	}
	
	public long leapDate(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
		
		long count = 0L;
		
		for(int i = 1; i < year; i++) { //전년도 까지 일 수 구하기
			if(isLeapYear(i)) {
				count += 366; //윤년이면 count에 366 더함
			} else {
				count += 365; //평년이면 count에 365 더함
			}
		}
		
		if(isLeapYear(year)) { //올해(윤년일 경우)의 전달까지 일 수 더하기
			for(int i = 1; i < month; i++) {
				switch(i) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
					count += 31;
					break;
				case 2 :
					count += 29;
					break;
				default:
					count += 30;
				}
			}
		} else { //올해(평년일 경우)의 전달까지 일 수 더하기
			for(int i = 1; i < month; i++) {
				switch(i) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
					count += 31;
					break;
				case 2 :
					count += 28;
					break;
				default:
					count += 30;
				}
			}
		}
		
		count += date; //올해 이번 달의 일 수 더하기
		return count;
	}
}
