package com.kh.homework.employ.view;

import java.util.Scanner;
import com.kh.homework.employ.controller.EmployeeController;

public class EmployeeMenu {
	Scanner sc = new Scanner (System.in);
	EmployeeController ec = new EmployeeController();
	
	public EmployeeMenu() {
		while(true) {
			System.out.println("1. 사원 추가");		
			System.out.println("2. 사원 수정");
			System.out.println("3. 사원 삭제");
			System.out.println("4. 사원 출력");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호를 누르세요 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
		
			if(menuNum != 9) {
				switch(menuNum) {
				case 1: insertEmp(); break;
				case 2: updateEmp(); break;
				case 3: deleteEmp(); break;
				case 4: pirntEmp(); break;
				default: System.out.println("번호를 잘못 입력하셨습니다.");
				}
			} else {
				System.out.print("프로그램을 종료합니다.");
				break;
			}
		}
	}
	
	public void insertEmp() {
		int empNo, salary ;
		double bonus;
		char gender;
		String name, phone, dept;
		
		System.out.print("사원 번호 : ");
		empNo = Integer.parseInt(sc.nextLine());
		System.out.print("사원 이름 : ");
		name = sc.nextLine();
		System.out.print("사원 성별 : ");
		gender = sc.nextLine().charAt(0);
		System.out.print("전화 번호 : ");
		phone = sc.nextLine();
		
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		char confirm = sc.nextLine().charAt(0);
		
		if(confirm == 'y' || confirm == 'Y') {
			System.out.print("사원 부서 : ");
			dept = sc.nextLine();
			System.out.print("사원 연봉 : ");
			salary = Integer.parseInt(sc.nextLine());
			System.out.print("보너스 율 : ");
			bonus =Double.parseDouble(sc.nextLine());
			ec.add(empNo, name, gender, phone, dept, salary, bonus);
		} else if (confirm == 'n' || confirm == 'N') {
			ec.add(empNo, name, gender, phone);
		} else {
			System.out.println("잘못 입력하셨습니다.");
			System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) :");
			confirm = sc.nextLine().charAt(0);
		}
	}
	
	public void updateEmp() {
		System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.");
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화 번호");
		System.out.println("2. 사원 연봉");
		System.out.println("3. 보너스 율");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 : ");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 1:
			System.out.print("수정할 전화 번호 : ");
			String phone = sc.nextLine();
			ec.modify(phone);
			break;
		case 2:
			System.out.print("수정할 사원 연봉 : ");
			int salary = Integer.parseInt(sc.nextLine());
			ec.modify(salary);
			break;
		case 3:
			System.out.print("수정할 보너스 율 : ");
			double bonus = Double.parseDouble(sc.nextLine());
			ec.modify(bonus);
			break;
		case 9:
			System.out.println("메인 메뉴로 돌아갑니다.");
			break;
		default: System.out.println("번호를 잘못 입력하셨습니다.");
		}
	}
	
	public void deleteEmp() {
		System.out.print("정말 삭제하시겠습니까?(y/n) : ");
		char confirm = sc.nextLine().charAt(0);
		
		if(confirm == 'y' || confirm == 'Y') {
			ec.remove();
			System.out.println("데이터 삭제에 성공하였습니다.");
		} else if (confirm == 'n' || confirm == 'N') {
			System.out.println("메인 메뉴로 돌아갑니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
			System.out.print("정말 삭제하시겠습니까?(y/n) : ");
			confirm = sc.nextLine().charAt(0);
		}
	}
	
	public void pirntEmp() {
		System.out.println(ec.inform());
	}
	
}
