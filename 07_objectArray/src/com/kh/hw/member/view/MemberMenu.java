package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public MemberMenu() {}

	public void mainMenu() {
		while(true) {
			if(mc.existMemberNum() < 10) {
				System.out.println("최대 등록 가능한 회원 수는 10명입니다.");
				System.out.println("현재 등록된 회원 수는 " + mc.existMemberNum() + "명입니다.");
				System.out.println("1. 새 회원 등록");
				System.out.println("2. 회원 검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				int menuNum = Integer.parseInt(sc.nextLine());
				
				if(menuNum != 9) {
					switch(menuNum) {
					case 1: insertMember(); break;
					case 2: searchMember(); break;
					case 3: updateMember(); break;
					case 4: deleteMember(); break;
					case 5: printAll(); break;
					default:
						System.out.println("없는 번호입니다. 다시 입력해주세요.");
						System.out.print("메뉴 번호 : ");
						menuNum = Integer.parseInt(sc.nextLine());
						break;
					}
					System.out.println();
				} else {
					System.out.print("프로그램을 종료합니다.");
					break;
				}
			} else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
				System.out.println("2. 회원 검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				int menuNum = Integer.parseInt(sc.nextLine());
				
				if(menuNum != 9) {
					switch(menuNum) {
					case 1: ; break;
					case 2: ; break;
					case 3: ; break;
					case 4: ; break;
					case 5: ; break;
					default:
						System.out.println("없는 번호입니다. 다시 입력해주세요.");
						System.out.print("메뉴 번호 : ");
						menuNum = Integer.parseInt(sc.nextLine());
						break;
					}
					System.out.println();
				} else {
					System.out.print("프로그램을 종료합니다.");
					break;
				}
			}
		}
	}
	
	public void insertMember() {
		String id, name, password, email;
		char gender;
		int age;
		
		System.out.println("새 회원을 등록합니다.");
		System.out.print("아이디 : ");
		id = sc.nextLine();
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("비밀번호 : ");
		password = sc.nextLine();
		System.out.print("이메일 : ");
		email = sc.nextLine();
		
		String genderStr = null;	
		while(true) {
			System.out.print("성별(M/F): ");
			genderStr = sc.nextLine();
		
			if(genderStr.toUpperCase().equals("M") || genderStr.toUpperCase().equals("F") ) {
				gender = genderStr.charAt(0);
				break;
			} else {
				System.out.println("성별을 다시 입력하세요.");
			}
		}
		
		System.out.print("나이: ");
		age = Integer.parseInt(sc.nextLine());
		
		mc.insertMember(id, name, password, email, gender, age);
	}
	
	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 1: searchId(); break;
		case 2: searchName(); break;
		case 3: searchEmail(); break;
		case 9: System.out.println("메인으로 돌아갑니다."); break;
		default: System.out.println("잘못 입력하셨습니다."); break;
		}
	}
	
	public void searchId() {
		System.out.print("검색할 아이디 : ");
		String id = sc.nextLine();
		
		
		if (mc.searchId(id) != null) {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(mc.searchId(id));
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	public void searchName() {
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		Member[] result = mc.searchName(name); //m[i]에 대한 정보를 가지고 있음
		
		if(result != null) {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(int i = 0; i < result.length; i++) {
				if(result[i].getName().equals(name)) {
					System.out.println(result[i].inform());
				}
			}
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	public void searchEmail() {
		System.out.print("검색할 이메일 : ");
		String email = sc.nextLine();
		Member[] result = mc.searchName(email);
		
		if(result != null) {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(int i = 0; i < result.length; i++)
				if(result != null) {
					System.out.println(result[i].inform());
				}
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	public void updateMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 1: searchId(); break;
		case 2: searchName(); break;
		case 3: searchEmail(); break;
		case 9: System.out.println("메인으로 돌아갑니다."); break;
		default: System.out.println("잘못 입력하셨습니다."); break;
		}
	}
	
//	public void updatePassword() {}
//	public void updateName() {}
//	public void updateEmail() {}
	public void deleteMember() {
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 1: searchId(); break;
		case 2: searchName(); break;
		case 9: System.out.println("메인으로 돌아갑니다."); break;
		default: System.out.println("잘못 입력하셨습니다."); break;
		}
	}
//	public void deleteOne() {}
	
	public void deleteAll() {
		Member[] m = mc.printAll();
		System.out.println("정말 모두 삭제하시겠습니까? (Y/N) : ");
		char confirm = sc.nextLine().charAt(0);
		
		if(confirm == 'y' || confirm == 'Y' ) {
			for(int i = 0; i < m.length; i++) {
				if(m != null)
					m[i] = null;
			}
			System.out.println("성공적으로 삭제하였습니다.");
		} else if(confirm == 'n' || confirm == 'N' ){
			System.out.println("메인으로 돌아갑니다.");			
		} else {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("정말 모두 삭제하시겠습니까? (Y/M) : ");
			confirm = sc.nextLine().charAt(0);
		}
	}

	public void printAll() {
		Member[] m = mc.printAll();
		if(mc.existMemberNum() == 0) {
			System.out.println("저장된 회원이 없습니다.");
		} else {
			for(int i = 0; i < MemberController.SIZE; i++) {
				if(m[i] != null) {
					System.out.println(m[i].inform());
				}
			}
		}
	}
	
}