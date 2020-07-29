package com.kh.example.chap03_assist.part02_object.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.example.chap03_assist.part02_object.model.vo.Member;

public class ObjectDAO {
	public void fileSave() {
		Member[] mar = {new Member("user01", "pass01", "강건강", "kang@kh.or.kr", 25, '남', 1250.7),
				        new Member("user02", "pass02", "남나눔", "nam456@kh.or.kr", 17, '남', 1221.6),
				        new Member("user03", "pass03", "도대담", "do789@kh.or.kr", 23, '남', 12534.6)};
		
		//객체를 파일에 저장하고 싶음 (직렬화 필요)
		//--→ 객체 관련된 보조스트림 필요: ObjectInputStream, ObjectOutputStream
		//          --→ ObjectOutputStream(확정)
		//    --→ 파일 저장 관련 스트림 필요: FileOutputStream(확정,기반), FileWriter
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d_object.txt"))) {
			for(int i = 0; i < mar.length; i++) {
				oos.writeObject(mar[i]);
			} //실행시켜보면 깨져서 보인다. 이게 정상임. 객체는 문자가 아니기 때문이다.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileOpen() {
		//파일에 저장된 객체를 읽어오고 싶음(역직렬화)
		//         ------------→ 객체 관련된 보조스트림 필요: ObjectInputStream(확정), ObjectOutputStream
		//--→ 파일 출력 관련 스트림 필요: FileInputStream(확정), FileReader(같은 자료 타입만 사용 가능하므로 x)       
		//point는 직렬화 하고 싶지 않다면? Member 클래스의 필드에서 맴버 변수 point에 transient 예약어를 추가함
		//이렇게 되면 직렬화 시 ponit에는 double 자료형의 기본 값이 들어간다.
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d_object.txt"))) {
			Member[] mar = new Member[3]; //Member[4]로 설정하면 EOFException 발생, catch문에 예외 처리 필요
			for(int i = 0; i < mar.length; i++) {
				mar[i] = (Member)ois.readObject(); //Object를 반환하므로 Member로 다운 캐스팅
			}
			
			for(Member m : mar) {				
				System.out.println(m);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			//파일 크기를 넘어서면 발생하는 에러, catch문을 추가하고 처리 구문은 비워두어도 됨
			//EOFException는 컬랙션(크기가 정해지지 않은 자료를 저장할 때 유용함)에서 겪을 수 있는 에러이므로 catch에 처리해두자
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//invalid type code AC
	}
}
