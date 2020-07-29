package com.kh.example.chap03.assist.part01_buffer.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferDAO {
	public void output() {
		//try(FileWriter fw = new FileWriter("c_buffer.txt"); //생성자 구분자는 세미콜론
		//		BufferedWriter bw = new BufferedWriter(fw)) {
		//보조 스트림은 생성 시 기반 스트림을 받아야함
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))) {
			bw.write("안녕하세요\n");
			bw.write("반갑습니다\n");
			bw.write("저리가세요\n");
			bw.write("안녕하세요\n");
			bw.write("안녕하세요\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void input() {
		try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {
			String value;
			while((value = br.readLine()) != null) {//readLine() = String 한 줄씩 반환, 파일의 끝에 도달하면 null리턴
				System.out.println(value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
