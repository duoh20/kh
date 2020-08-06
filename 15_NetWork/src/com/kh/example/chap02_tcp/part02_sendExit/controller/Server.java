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
		//서버용 포트 생성
		int port = 9100;
		
		try {
		//서버 소캣 생성 후 포트와 결합
			ServerSocket server = new ServerSocket(port);
			
		//클라이언트 요청 대기
			System.out.println("클라이언트 요청 대기중...");
			
		//클라이언트 요청 수락 후 클라이언트에 대해 소캣 객체 생성
			Socket client = server.accept();
			
			                         //소캣에 연결된 주소를 찾는 메서드
			String clientIP = client.getInetAddress().getHostAddress();
			System.out.println(clientIP + "가 연결을 요청함...");
			
		//연결된 클라이언트와 입출력 스트림 생성
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			
		//보조스트림을 사용해 성능 개선
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(output);
	
		//스트림을 통해 읽고 쓰기
		//exit 입력할 때 까지 메세지 주고 받음
			while(true) {
				String message = br.readLine(); //클라이언트가 보낸 메세지 읽기
				
				if(!message.equals("exit")) {
					System.out.println(clientIP +"클라이언트가 보낸 메세지 : " + message);
					pw.println("메세지 받기 성공");
					pw.flush(); //버퍼에 담긴 내용 지움
				} else {
					System.out.println("통신 종료");
					break;
				}
			}
			
		//통신 종료
			br.close();
			pw.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
