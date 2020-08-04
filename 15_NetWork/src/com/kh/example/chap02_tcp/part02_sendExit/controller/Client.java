package com.kh.example.chap02_tcp.part02_sendExit.controller;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public void startClient() {
		try {
			//1. 서버의 포트 번호와 IP를 가져와서 클라이언트용 소켓 생성
			int port = 8600;
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			
			Socket socket = new Socket(serverIP, port);
			
			if(socket != null) { //socket이 null이라면 연결이 안되었다는 의미
			//2. 서버와 입출력 스트림 생성
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
			
			//3. 보조 스트림을 통해 성능 개선
				BufferedReader br = new BufferedReader(new InputStreamReader(input));
				PrintWriter pw = new PrintWriter(output);
				
			//4. 스트림을 통해 읽고 쓰기
				Scanner sc = new Scanner(System.in);
				
				do {
					System.out.print("대화 입력 : ");
					String message = sc.nextLine();
					
					//pw를 통해 메세지를 입력, exit가 입력되면 더 이상 입력 받지 않음
					pw.println(message);
					pw.flush();
					
					if(message.contentEquals("exit")) {
						System.out.println("접속 종료");
						break;
					}
					
					String serverMsg = br.readLine();
					System.out.println(serverMsg);
				} while(true);
				
			// 5. 통신 종료
				pw.close();
				br.close();
				socket.close();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
