package com.kh.example.chap02_tcp.part02_sendExit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void startServer() {
		//1. 서버 포트번호 정하기
		int port = 8600;
		
		//2. 서버 용 소켓 생성 후 포트와 결합
		try {
			ServerSocket server = new ServerSocket(port);
		
		//3. 클라이언트 요청 오기 기다리기
			System.out.println("클라이언트의 요청을 기다리고 있습니다.");
			
		//4. 요청오면 수락 후 해당 클라이언트에 대한 소캣 객체 생성
			Socket client = server.accept();
			
			String clientIP = client.getInetAddress().getHostAddress();
			System.out.println(clientIP + "가 연결을 요청함...");
			
		//5. 연결된 클라이언트와 입출력 스트림 생성
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			
		//6. 보조스트림으로 성능 개선
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(output);
			
		//7. 스트림으로 읽고 쓰기
			while(true) {
				String message = br.readLine();
				
				if(!message.equals("exit")) { //클라이언트가 exit를 입력하지 않으면 계속 입력 받음
					System.out.println(clientIP + "가 보낸 메세지 : " + message);
					System.out.println("메세지 받기 성공");
				} else {
					System.out.println("접속 종료"); //클라이언트가 exit를 입력하면 종료
					break;
				}
			}
		//8. 통신 종료
			br.close();
			pw.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
