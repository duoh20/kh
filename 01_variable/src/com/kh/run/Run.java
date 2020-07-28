package com.kh.run;

import com.kh.variable.E_KeyboardInput;

public class Run { //실행 클래스
	public static void main(String[] args) {
		
		// 기능 클래스(A_Variable) 알맹이 만들기
		
		//1_알맹이 만들기
		//A_Variable이 어떤 위치에 있는지 모르기 때문에 패키지를 import 해주어야함
		//com.kh.variable.A_Variable av = new com.kh.variable.A_Variable();
		
		//2_import한 후 사용
		//A_Variable av = new A_Variable();  
		//av.declareVariable();
		//av.initVariable();
		
		
		//B_Constant bc = new B_Constant();
		//bc.finalConstant();
		
		
		//C_Cast cc = new C_Cast();
		//cc.rule1();
		//cc.rule2();
		
		
		//D_Print dp = new D_Print();
		//dp.printlnExample();
		//dp.printExample();
		//dp.printfExample();
		
		
		E_KeyboardInput eki = new E_KeyboardInput();
		eki.input1();
		eki.input2();
	}
}