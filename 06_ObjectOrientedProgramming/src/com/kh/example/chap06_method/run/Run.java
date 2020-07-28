package com.kh.example.chap06_method.run;

import com.kh.example.chap06_method.controller.MethodController;
import com.kh.example.chap06_method.model.vo.Trainee;

public class Run {

	public static void main(String[] args) {
		MethodController mc = new MethodController();
		//mc.method1();
		
		//반환값 출력 방법
		//방법 1.
		//System.out.println(mc.method2());
		//방법 2
		//int result = mc.method2();
		//System.out.println(result);
		
		//mc.method3(1, 10);
		
		//방법 1.
		//System.out.println(mc.method4(2, 20));
		//방법 2
		//int result2 = mc.method4(2, 20);
		//System.out.println(result2);
		
		//int[] resultArr = mc.method5(); //얇은 복사
		//System.out.println("Run result Arr : " + resultArr);
		//for(int i = 0; i < resultArr.length; i++) {
		//	System.out.print(resultArr[i] + " ");
		//}
		//System.out.println();
		
		
		//User resultUser = mc.method6(); //얇은 복사
		//System.out.println("Run resultUser : " + resultUser);
		
		Trainee tt = new Trainee();
		System.out.println(tt.inform());
		tt.setName("박신우");
		tt.setTime("오후");
		tt.setClassRoom('G');
		//tt.setScore(80.0);
		//The static method setScore(double) from the type Trainee should be accessed in a static way
		Trainee.setScore(80.0);
		System.out.println(tt.inform());
	}

}
