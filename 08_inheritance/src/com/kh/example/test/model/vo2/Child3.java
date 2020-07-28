package com.kh.example.test.model.vo2;

import com.kh.example.test.model.vo.Parent;

public class Child3 {
	public Child3() {
		//상속 없이 접근하려면 객체 생성
		Parent p = new Parent();
		//p.num = 10; private 접근 불가
		//p.dNum = 20; default 다른 패키지에서 접근 불가
		//p.bool = false; protected 다른 패키지에서 접근 불가
		p.ch = 'a'; // public: 모두 접근 가능
	}
}
