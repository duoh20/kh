package com.kh.example.chap01_encapsulation;

import com.kh.example.chap02_class.publicClass.controller.PublicClass;

public class Run {

	public static void main(String[] args) {

		Account a = new Account();
		a.displayBalace();
		
		a.deposit(1000000);
		a.displayBalace();		
		
		a.deposit(1500000);
		a.displayBalace();		
		
		a.withdraw(500000);
		a.displayBalace();		
	
		//a.balance -= 2000000;
		//캡슐화하지 않으면 외부에서 바로 데이터에 접근 가능
		//캡슐화 후에 에러 발생
		//The field Account.balance is not visible
		
		a.withdraw(500000);
		a.displayBalace();
	}

}
