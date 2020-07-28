package com.kh.example.practice7.run;

import com.kh.example.practice7.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		Employee e = new Employee(1004, "김정민", "영업2팀", "마케터",
									36,'남', 340, 0.3, "010-1234-5678", "서울시 서초구");
	
		e.setEmpNo(100);
		e.setEmpName("박신우");
		e.setDept("교육부");
		e.setJob("강사");
		e.setAge(20);
		e.setGender('F');
		e.setSalary(100);
		e.setBonusPoint(0.01);
		e.setPhone("010-1111-2022");
		e.setAddress("서울시 강남구 역삼동");
		
		System.out.println(e.getJob());
		System.out.println(e.getEmpName());
		System.out.println(e.getDept());
		System.out.println(e.getJob());		
		System.out.println(e.getAge());
		System.out.println(e.getGender());
		System.out.println(e.getSalary());
		System.out.println(e.getBonusPoint());
		System.out.println(e.getPhone());
		System.out.println(e.getAddress());
	}

}
