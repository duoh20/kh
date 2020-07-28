package com.kh.homework.employ.controller;

import com.kh.homework.employ.model.vo.Employee;

public class EmployeeController {
	
	Employee e = new Employee();
	
	public void add(int empNo, String name, char gender, String phone) {
		e.setEmpNo(empNo);
		e.setName(name);
		e.setGender(gender);
		e.setPhone(phone);
	}
	
	public void add(int empNo, String name, char gender, 
				String phone, String dept,int salary, double bonus) {
		e.setEmpNo(empNo);
		e.setName(name);
		e.setGender(gender);
		e.setDept(dept);
		e.setSalary(salary);
		e.setBonus(bonus);
		e.setSalary(salary);
		e.setBonus(bonus);
	}
	
	public void modify(String phone) {
		e.setPhone(phone);
	}
	
	public void modify(int salary) {
		e.setSalary(salary);
	}
	
	public void modify(double bonus) {
		e.setBonus(bonus);
	}
	
	public Employee remove() {
		e = null;
		return e;
	}
	
	public String inform() {
		if (e == null) {
			return "사원 데이터가 없습니다.";
		} else {
			return e.printEmployee();
		}
	}
}
