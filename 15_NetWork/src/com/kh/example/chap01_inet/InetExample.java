package com.kh.example.chap01_inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetExample {
	public static void main(String[] args) {
		try {
			//static 메소드는 생성자 생성 필요 없이 클래스명(ex.System.~)으로 접근할 수 있음
			InetAddress localIP = InetAddress.getLocalHost(); //지역 호스트의 Host명과 IP주소 반환
			System.out.println("내 PC 명: " + localIP.getHostName()); //호스트 이름 반환
			System.out.println("내 IP : " + localIP.getHostAddress()); //IP주소 반환
			
			InetAddress ieiIp = InetAddress.getByName("www.iei.or.kr"); //도메인 명을 통해 IP 주소 얻기
			System.out.println("iei 서버 명 : " + ieiIp.getHostName());
			System.out.println("iei 서버 IP : " + ieiIp.getHostAddress());
			
			InetAddress[] googleIPs = InetAddress.getAllByName("www.google.com");
			System.out.println("google IP 개수 : " + googleIPs.length);
			for (InetAddress ip : googleIPs) {
				System.out.println(ip.getHostAddress());
			}
			
			InetAddress[] naverIPs = InetAddress.getAllByName("www.naver.com");
			System.out.println("naver IP 개수 : " + naverIPs.length);
			for (InetAddress ip : naverIPs) {
				System.out.println(ip.getHostAddress());
			}
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		}
	}
}
