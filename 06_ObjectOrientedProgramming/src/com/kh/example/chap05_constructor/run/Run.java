package com.kh.example.chap05_constructor.run;

import java.util.Date;
import com.kh.example.chap05_constructor.model.vo.User;

public class Run {

	public static void main(String[] args) {
		User u1 = new User();
		//            ------기본생성자: 객체 생성
		u1.inform(); //참조 자료형이므로 모두 null
		
		//The constructor User() is undefined
		//User()라는 기본 생성자가 정의되어 있지 않으면 나타나는 에러
		
		User u2 = new User("uer01", "pass01", "강건강", new Date());
		u2.inform();
		
		User u3 = new User("uer01", "pass01", "강건강");
		u3.inform();
	}

}
