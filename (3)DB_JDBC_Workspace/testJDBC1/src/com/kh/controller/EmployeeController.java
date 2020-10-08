package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.EmployeeDAO;
import com.kh.model.vo.Employee;
import com.kh.view.Menu;

public class EmployeeController {
	
	private EmployeeDAO empDAO = new EmployeeDAO();
	private Menu menu = new Menu();
	
	//전체 사원 정보 조회
	public void selectAll() {
		ArrayList<Employee> list = empDAO.selectAll();
		
		if(!list.isEmpty()) {
			menu.selectAll(list);
		} else {
			menu.displayError("조회 결과가 없습니다.");
		}
	}

	public void selectEmployee() {
		//사번 입력 view 호출
		int empNo = menu.selectEmpNo();
		
		//전달받은 값을 DAO로 전달
		Employee emp = empDAO.selectEmployee(empNo);
		
		if(emp != null) {
			menu.selectEmployee(emp);
		} else {
			menu.displayError("해당 사번의 검색 결과가 없습니다.");
		}
	}

	public void insertEmployee() {
		Employee e  = menu.insertEmployee();
		int result = empDAO.insertEmployee(e);
		
		if(result > 0) {
			menu.displaySuccess(result + "개의 행을 추가했습니다.");
		} else {
			menu.displayError("데이터 삽입 과정 중 오류 발생");
		}
	}
	
	public void updateEmployee() {
		int empNo = menu.selectEmpNo();
		
		Employee e = menu.upateEmployee();
		e.setEmpNo(empNo);
		
		int result = empDAO.updateEmployee(e);
		if(result > 0) {
			menu.displaySuccess(result + "개의 행을 수정했습니다.");
		} else {
			menu.displayError("데이터 수정 과정 중 오류 발생");
		}
	}

	public void deleteEmployee() {
		int empNo = menu.selectEmpNo();
		
		char check = menu.deleteEmployee();
		
		if(check == 'y') {
			int result = empDAO.deleteEmployee(empNo);
			
			if(result > 0) {
				menu.displaySuccess(result + "개의 행을 삭제했습니다.");
			} else {
				menu.displayError("데이터 삭제 과정 중 오류 발생");
			}
		} else if(check == 'n') {
			menu.displayError("사원 정보 삭제 취소");
		} else {
			menu.displayError("잘못 입력하셨습니다. (y 또는 n 입력)");
		}
	}
}
