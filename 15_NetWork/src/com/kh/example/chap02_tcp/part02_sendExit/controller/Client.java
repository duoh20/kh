package com.kh.example.chap02_tcp.part02_sendExit.controller;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
		public void startClient() {
		try {
			BufferedReader br = null;
			PrintWriter pw = null;
		//서버의 포트 번호와 IP 확인
			int port = 9100;
			String serverIP = InetAddress.getLocalHost().getHostAddress();
		//IP주소와 port로 서버와 연결 소캣 생성
			Socket socket = new Socket(serverIP, port);
			
		//서버와 입출력 스트림 생성
			if(socket != null) {
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
		//보조스트림으로 성능 향상
				br = new BufferedReader(new InputStreamReader(input));
				pw = new PrintWriter(output);
		
		//스트림을 통해 읽고 쓰기
				Scanner sc = new Scanner(System.in);
				
				do {
					System.out.print("대화 입력 : ");
					String message = sc.nextLine();
					
					pw.println(message);
					pw.flush();
					
					if(message.equals("exit")) {
						break;
					}
					
					String serverMsg = br.readLine();
					System.out.println(serverMsg);
				} while(true);
				
			}
		//통신 종료
			br.close();
			pw.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
