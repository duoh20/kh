package operator;

public class B_InDecrease {
	
	public void method1() {
		//���� ���� ������
		int num1 = 10;
		System.out.println("���� ���� ������ ���� �� : " + num1);
		System.out.println("++num1�� 1ȸ ���� �� ��� : " + (++num1));
		System.out.println("++num1�� 2ȸ ���� �� ��� : " + (++num1));
		System.out.println("++num1�� 3ȸ ���� �� ��� : " + (++num1));
		System.out.println("++num1�� 4ȸ ���� �� ��� : " + (++num1));
		System.out.println("++num1�� 5ȸ ���� �� ��� : " + (++num1));
		System.out.println("���� ���� ���� ���� �� num1�� �� : " + num1);
		
		//���� ���� ������
		int num2 = 10;
		System.out.println("���� ���� ������ ���� �� : " + num2);
		System.out.println("num2++�� 1ȸ ���� �� ��� : " + (num2++));
		System.out.println("num2++�� 2ȸ ���� �� ��� : " + (num2++));
		System.out.println("num2++�� 3ȸ ���� �� ��� : " + (num2++));
		System.out.println("num2++�� 4ȸ ���� �� ��� : " + (num2++));
		System.out.println("num2++�� 5ȸ ���� �� ��� : " + (num2++));
		System.out.println("���� ���� ���� ���� �� num2�� �� : " + num2);
	}
	
	public void method2() {
		int num1 = 20;
		
		int result1 = num1++ *3; // 20 * 3 = 60 --->21
		System.out.println("num1 : " + num1);
		System.out.println("result1 : " + result1);
		
		int num2 = 20;
		
		int result2 = ++num2 *3; // 21 * 3 = 60 --->21
		System.out.println("num2 : " + num2);
		System.out.println("result2 : " + result2);	
	}
	
	public void method3() {
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a++); //10
		System.out.println((++a) + (b++)); //12 + 20 ---> 32
		System.out.println((a++) + (--b) + (--c)); //12 + 20 + 29 ---> 61
		
		System.out.println("a : " + a); //13
		System.out.println("b : " + b); //20
		System.out.println("c : " + c); //29
	}
}
