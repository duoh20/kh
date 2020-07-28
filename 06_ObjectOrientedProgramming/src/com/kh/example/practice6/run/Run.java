package com.kh.example.practice6.run;

import com.kh.example.practice6.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		
		Book b1 = new Book();
		b1.inform();
		
		Book b2 = new Book("태백산맥", "해냄 출판사", "조정래");
		b2.inform();
		
		Book b3 = new Book("헤리포터", "블룸즈베리 퍼블리싱", "조엔K롤링", 24000, 0.1);
		b3.inform();
		
	}

}
