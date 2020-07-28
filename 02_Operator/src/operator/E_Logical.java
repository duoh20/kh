package operator;

import java.util.Scanner;

public class E_Logical {

	 Scanner sc = new Scanner(System.in);
	 
//	 public void method1() { 
//		 	System.out.print("정수 하나 입력: " );
//		 	int num = sc.nextInt();
//	 }
	 
	 public void method2() {
		 //입력한 문자 값이 대문자인지 확인
		 System.out.print("문자 하나 입력: ");
		 char ch = sc.nextLine().charAt(0);
		 
		 //문자는 A보다 크거나 같고, Z보다 작거나 같다
		 boolean result = ch >= 'A' && ch <= 'Z';
		 System.out.println("영어 대문자가 맞습니까? " + result);
		 
		 System.out.println("계속 하시려면 y 혹은 Y를 입력하세요.");
		 System.out.print("계속 하시겠습니까? (y/Y) : ");
		 
		 char answer = sc.nextLine().charAt(0);
		 boolean result2 = answer == 'y' || answer == 'Y';
		 
		 System.out.println("계속 하시겠다구요? : "+ result2);
	 }
}
