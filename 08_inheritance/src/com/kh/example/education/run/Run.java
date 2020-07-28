package com.kh.example.education.run;

import com.kh.example.education.model.vo.Student;
import com.kh.example.education.model.vo.Teacher;

public class Run {

	public static void main(String[] args) {
		Teacher t = new Teacher("KH정보교육원", "서울시 강남구", "박신우", 'G', "자바", 5);
		//System.out.println(t.inform());
		System.out.println(t);
		System.out.println(t.toString());
		//Object를 상속받는 참조 변수를 출력하면 t[.toString()] 생략되어 있는 형태임 
		//toString()은 대표 값을 출력하는 메소드인데,
		//이 메소드를 오버라이딩해서 출력될 대표 값을 설정해준다.
		//앞으로 inform(), showInfo()와 같은 정보 출력 메서드는
		//toString()으로 대체해서 사용한다.

		
		//Student s = new Student("KH정보교육원", "서울시 강남구", "학생이름", 'G', "스마트 콘텐츠", 30);
		//System.out.println(s.inform());
		//System.out.println(s);
		
		System.out.print("안녕하세요\t반갑다");
	}

}
