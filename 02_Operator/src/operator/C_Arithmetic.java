package operator;

public class C_Arithmetic {
	public void method(){
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		System.out.println("num1 * num2 = " + (num1 * num2));
		System.out.println("num1 / num2 = " + (num1 / num2));
		System.out.println("num1 % num2 = " + (num1 % num2));
	}
	
	public void test() {
		int a = 5;
		int b = 10;
		
		int c= (++a) + b;
		//       6    10
		// a=6 b=10 c =16
		
		int d = c / a;
		//      16  6
		// d = 2
		
		int e = c % a;
		//      16   6
		
		
		int f = e++;
		int g = (--b) + (d--);
		int h = 2;
		int i = a++ + b / (--c / f) * (g-- - d) %(++e +h);
		
		System.out.println("a: " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + a);
		System.out.println("d : " + d);
		System.out.println("e : " + e);
		System.out.println("f : " + f);
		System.out.println("g : " + g);
		System.out.println("h : " + h);
		System.out.println("i : " + i);
	}
}
