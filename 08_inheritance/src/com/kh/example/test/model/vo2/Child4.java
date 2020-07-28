package com.kh.example.test.model.vo2;

import com.kh.example.test.model.vo.Parent;

public class Child4 extends Parent {
	public Child4() {
		//super.num = 10; private: 클래스 내부 외 접근 불가 
		//super.dNum = 10.0; default: 같은 패키지에서 접근 불가
		super.bool = false; //protected: 패키지가 달라도 후손 클래스는 접근 가능
		super.ch = 'a'; // public: 모두 접근 가능
	}
}
