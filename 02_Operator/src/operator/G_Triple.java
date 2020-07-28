package operator;

import java.util.Scanner;

public class G_Triple {
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		//입력한 정수가 양수인지 아닌지 판별
		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();
		
		String result = num > 0 ? "양수다." : (num < 0)? "양수가 아니다." : "0이다.";
		System.out.println(num + " : " + result);
	}
	
	public void method2() {
		//입력한 정수가 홀수인지 짝수인지 판별
		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();
		
		String result = num == 0 ? "0이다." : (num%2 == 0 ? "짝수입니다." : "홀수입니다.");
		System.out.println("숫자 " + num + "는 " + result);
	}
}
