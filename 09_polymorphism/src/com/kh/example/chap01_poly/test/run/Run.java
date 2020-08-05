package com.kh.example.chap01_poly.test.run;

import com.kh.example.chap01_poly.test.model.vo.Child1;
import com.kh.example.chap01_poly.test.model.vo.Child2;
import com.kh.example.chap01_poly.test.model.vo.Parent;

public class Run {
	public static void main(String[] args) {
//		new PolyController().method();	
		Parent[] pArr = new Parent[2];
		pArr[0] = new Child1();
		pArr[1] = new Child2();
		
		for(int i = 0; i < pArr.length; i++) {
			if(pArr[i] instanceof Child2)
				System.out.println(i + "번째에 있습니다.");
		}
	}
}
