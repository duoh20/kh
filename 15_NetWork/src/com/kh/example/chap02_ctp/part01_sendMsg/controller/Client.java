package com.kh.example.chap02_ctp.part01_sendMsg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public void startClient() {
		//클라이언트 용 TCP 소켓 프로그래밍 순서
		try {
		//0. 서버의 IP주소와 서버가 정한 포트 번호를 먼저 알아야 함
		//예제에서는 같은 컴퓨터에서 서버와 클라이언트를 생성하였기 때문에 IP주소가 같다. 원래 다른 게 맞음
			int port = 8500;
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			
		//1. 서버 IP주소 + 서버가 정한 포트 번호를 매개 변수로 클라이언트용 소켓 객체 생성
			Socket socket = new Socket(serverIP, port);
		
			if(socket != null) { //서버와 성공적으로 연결되었다면,
		//2. 서버와 입출력 스트림 생성
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
		
		//3. 보조 스트림 통해 성능 개선
				BufferedReader br = new BufferedReader(new InputStreamReader(input));
				PrintWriter pw = new PrintWriter(output);
		
		//4. 스트림을 통해 읽고 쓰기
		//	클라이언트 → 서버 메세지 전송
				pw.println("반가워요");
				pw.flush();
		//	서버  → 클라이언트 메세지 읽기
				System.out.println(br.readLine());
			
		//5. 통신 종료
				pw.close();
				br.close();
				socket.close();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
 catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
