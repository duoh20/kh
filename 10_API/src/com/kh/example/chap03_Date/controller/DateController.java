package com.kh.example.chap03_Date.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateController {
	public void method1() {
		Date today = new Date();
		System.out.println(today);
		
		System.out.println(today.getTime());
		//getTime()메소드를 실행하면 long 타입의 1970.1.1 0:0:0부터 특정 시간까지 밀리세컨드 값을 반환함
		//Mon Jul 27 21:05:17 KST 2020
		//1595851517616
		
		Date time = new Date(1595851517616L);
		System.out.println(time);//결과: Mon Jul 27 21:05:17 KST 2020
		
		Date date = new Date(2020,7,27); //The constructor Date(int, int, int) is deprecated
	}
	
	public void method2() {
		//Calendar c = new Calendar();
		//Calendar는 추상 클래스이고 protected로 접근이 제한되어 있어 라서 객체 생성 불가
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		
		Calendar gc = new GregorianCalendar(); //다형성: 부모 타입의 변수에 자식 객체를 담을 수 있음
		System.out.println(gc);
		
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = c.get(Calendar.MONTH) + 1; //month는 0월부터 시작하므로, +1 을 해줌 
		System.out.println(month);
		
		int date = c.get(Calendar.DATE);
		System.out.println(date);
		
		int amPm = c.get(Calendar.AM_PM); //오전은 0, 오후는 1 반환
		String sAmPm = amPm == 0 ? "오전" : "오후";
		System.out.println(sAmPm);

		//int hour = c.get(Calendar.HOUR); //12시간제 시로 반환
		int hour = c.get(Calendar.HOUR_OF_DAY); //24시간제 시로 반환
		int minute = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		System.out.println(hour + ":" + minute + ":" + sec);
		
		int day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(day); //인덱스는 1~7이고 일요일부터 시작
	}
	
	public void method3() {
		int year = 2021;
		int month = 2;
		int date = 8;
		int hour = 21;
		int min = 5;
		int sec = 0;
		
		Calendar c = new GregorianCalendar(year, month, date, hour, min, sec);
		long time = c.getTimeInMillis();
		Date endDay = new Date(time);
		System.out.println(endDay);
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd E요일 a HH시 mm분 ss초"); //24시간제
		//2021-05-08 월요일 오후 21시 05분 00초
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd E요일 a hh시 mm분 ss초"); //12시간제
		//2021-05-08 월요일 오후 09시 05분 00초
		String fmt = sdf.format(endDay);
		System.out.println(fmt);		
	}
}
