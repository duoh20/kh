package com.kh.example.chap02_tcp.part01_sendMsg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//TCP 통신을 위해서 서버가 먼저 만들어져 있어야 한다.
	//TCP(Transmission Control Protocol)
	//서버와 클라이언트 간의 1:1 소켓 통신(연결 지향적 프로토콜)
	//데이터 전송 전 먼저 서버, 클라이언트가 연결되어있어야 함
	//	→ 서버가 먼저 실행되어 클라이언트의 요청 기다림
	//	→ 서버, 클라이언트용 프로그램을 따로 구현
	
	//데이터 전송 순서가 보장되고 수신 여부를 판단하여 손실 시 재전송
	//패킷을 관리할 필요가 없고 UDP보다 속도가 느림
	
	//ServerSocket
	//	포트와 연결되어 외부 요청을 기다리다 요청이 들어오면 Socket 생성하여
	//	소켓과 소켓 간의 통신이 이루어지도록 함
	//	한 포트에 한 ServerSocket만 연결 가능
	
	//Socket
	//	프로세스 간 통신 담당
	//	InputStream, OutputStream 보유
	//		이 스트림을 통해 프로세스 간의 통신 (입출력)이 이루어짐
	
	public void serverStart() {
		//서버용 TCP 프로그래밍 순서
		//1. 서버의 포트 번호 정함 (0~65535 사이 지정 가능, 1023까지는 이미 사용 중인 포트가 많아서 사용 안하는 게 좋다. 5000 이후로 사용할 것을 권장)
		int port = 8500;
		//2. 서버용 소켓 객체 생성 후 포트와 결합
		try {
			ServerSocket server = new ServerSocket(port);
	
		//3. 클라이언트에서 접속 요청이 오길 기다리기
			System.out.println("클라이언트의 요청을 기다리고 있습니다.");
		
		//4. 접속 요청이 오면 수락 후 해당 클라이언트에 대한 소켓 객체 생성
			Socket client = server.accept();
			
			String clientIP = client.getInetAddress().getHostAddress();
			System.out.println(clientIP + "가 연결을 요청함...");
			
		//5. 연결된 클라이언트와 입출력 스트림 생성
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
		
		//6. 보조 스트림을 통해 성능 개선 (in/outputStream이 바이트 기반이므로 문자 기반으로 바꿔줘야함)
			InputStreamReader isr = new InputStreamReader(input);
			BufferedReader br = new BufferedReader(isr); //성능 개선을 위해 보조스트림 추가
			
			//5~6의 구문을 한 줄로 표현 가능
			//BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pw = new PrintWriter(output);
			
		//7. 스트림을 통해 읽고 쓰기
			//클라이언트 → 서버로 전송한 메세지 읽어옴
			String message = br.readLine();
			System.out.println(clientIP + "가 보낸 메세지 : " + message);
			
			//서버 → 클라이언트로 메세지 전송
			pw.println("만나서 반갑습니다.");
			pw.flush(); //메세지를 보낸 후 스트림을 비워주는 메소드
		
		//8. 통신 종료
			//위에서 만든 길(스트림)을 모두 닫아줌
			pw.close();
			br.close();
			output.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
