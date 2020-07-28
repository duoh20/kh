package com.kh.example.practice5.modle.vo;

public class Lotto {
	
	private int[] lotto = new int[6];
	
	{
		lotto = new int[6];
		
		/*
		 * 	i == 0
		 * 		비교할 값 : x
		 * 	i == 1
		 * 		비교할 값 : 0
		 * 	i == 2
		 * 		비교할 값 : 0, 1
		 * 	i == 3
		 * 		비교할 값 : 0, 1, 2
		 * 	i == 4
		 * 		비교할 값 : 0, 1, 2, 3
		 * 	i == 5
		 * 		비교할 값 : 0, 1, 2, 3, 4
		 */
		
		for(int i = 0; i <lotto.length; i ++) {
			lotto[i] = (int)(Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
			
				}
			}
		}
	}
	
	public Lotto() {}
	
	public void information() {
		for(int i = 0; i < lotto.length; i++) {
			if(lotto[i] < 10) {
				System.out.print("0" + lotto[i] + " ");
			} else {
				System.out.print(lotto[i] + " ");
			}
		}
	}
}