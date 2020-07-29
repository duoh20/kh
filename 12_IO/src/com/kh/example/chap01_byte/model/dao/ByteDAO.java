package com.kh.example.chap01_byte.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO {
	public void fileSave() {
		FileOutputStream fos = null;
		//fileSave() 안에서 지역 변수 fos를 사용할 수 있도록 try문 바깥에서 초기화
		
		try {
			//파일에 바이트 단위로 데이터를 저장하고 싶다.
			fos = new FileOutputStream("a_byte.txt"); //Write 시 파일이 덮어쓰기 됨
			//fos = new FileOutputStream("a_byte.txt", true); //Write 시 파일에 이어 써짐
			fos.write(97);
			//    아스키 코드 a
			
			byte[] bArr = {98, 99, 100, 101, 102, 103};
			//              b,  c,   d,   e,   f,   g      
			fos.write(bArr); //fos파일에 bArr을 입력
			
			fos.write(bArr, 1, 3); 
			// 1 인덱스부터 3개 추출 (이 예제에서: c, d, e) 
			
			/*} catch (FileNotFoundException | IOException e) {*/
			//FileNotFoundException이 IOException을 상속 받았기 때문에 병기할 수 없음
			//따로 작성한다.
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				//close()로 FileOutputstream을 닫아 줌
				//close()가 IOException을 위임하고 있으므로 try-catch 처리한다
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void fileOpen() {
		FileInputStream fis = null;
		
		try {
			//파일을 바이트 단위로 데이터를 읽어오고 싶다.
			//FileInputStream 클래스를 생성하면 FileNotFoundException 처리를 해야함
			fis = new FileInputStream("a_byte.txt");
			
			////1. 배열을 사용해 배열에 저장하여 읽어오기
			//int fileSize = (int)new File("a_byte.txt").length();
			////파일 사이즈 반환: long타입으로 반환하기 때문에 int로 캐스팅
			//byte[] bArr = new byte[fileSize];
			////읽어온 텍스트를 담을 배열 생성
			//fis.read(bArr);
			//for(int i = 0; i < bArr.length; i++) {
			//	//System.out.print(bArr[i] + " "); //int 반환
			//	System.out.print((char)bArr[i] + " "); //char 반환
			//}
			
			//2. 배열 저장 사용하지 않고 읽어오기
			//read()메서드 사용: 한 문자씩 읽어오기 때문에 반복문으로 돌려야함, 파일의 끝에 도달하면 -1 반환
			//while(fis.read() != -1) {
			//	System.out.print((char)fis.read() + " ");
			//} //이렇게 하면 조건문에서 한번 호출하고, print에서 또 read()를 호출해서 한 문자씩 건너뛰고 출력된다.
			int value;
			while((value = fis.read()) != -1) {
				System.out.print((char)value + " ");
			}
			//바이트 단위(127까지 가능)로 불러오기 때문에 한글은 깨진다.
			//바이트 단위를 넘어서는 문자는 Reader나 Writer를 이용해야한다. 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close(); //읽고 쓰고 난 후엔 꼭 닫자!!
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileSave2() {
		try (FileOutputStream fos = new FileOutputStream("a_byte.txt")) {
			//자동으로 close()하는 메소드에 의해 IOException이 위임되므로 예외 처리를 추가해주어야 한다.
			fos.write(97);
			byte[] bArr = {98, 99, 100, 101, 102, 103};
			fos.write(bArr);
			fos.write(bArr, 1, 3); 
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileOpen2() {
		try (FileInputStream fis = new FileInputStream("a_byte.txt")) {
			int value;
			while((value = fis.read()) != -1) {
				System.out.print((char)value + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
