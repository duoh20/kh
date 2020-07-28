package com.kh.practice.dimension;

import java.util.Scanner;

public class DimensionPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		String[][] sArr = new String[3][3];
		sArr[0][0] = "(0, 0)";
		sArr[0][1] = "(0, 1)";
		sArr[0][2] = "(0, 2)";
		
		sArr[1][0] = "(1, 0)";
		sArr[1][1] = "(1, 1)";
		sArr[1][2] = "(1, 2)";
		
		sArr[2][0] = "(2, 0)";
		sArr[2][1] = "(2, 1)";
		sArr[2][2] = "(2, 2)";
		
		for(int i =0; i < sArr.length; i++) {
			for(int j = 0; j < sArr.length; j++) {				
				System.out.print(sArr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice2() {
		int[][] iArr = new int[4][4];
		int value = 0;
	
		for(int i = 0 ; i < iArr.length; i++) {
			for(int j = 0; j < iArr.length; j++) {
				value++;
				iArr[i][j] = value;
			}
		}

		for(int i = 0 ; i < iArr.length; i++) {
			for(int j = 0; j < iArr.length; j++) {
				System.out.printf("%3d", iArr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice3() {
		int[][] iArr = new int[4][4];
		int value = 17;
	
		for(int i = 0 ; i < iArr.length; i++) {
			for(int j = 0; j < iArr.length; j++) {
				value--;
				iArr[i][j] = value;
			}
		}

		for(int i = 0 ; i < iArr.length; i++) {
			for(int j = 0; j < iArr.length; j++) {
				System.out.printf("%3d", iArr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice4() {
		int[][] iArr = new int[4][4];
	
		//  0,0   0,1   0,2  (0,3)
		//  1,0   1,1   1,2  (1,3)
		//  2,0   2,1   2,2  (2,3)
		// (3,0) (3,1) (3,2) (3,3)
		
		int sum = 0;
		int l = 0;
		for(int i = 0 ; i < iArr.length; i++) {
			for(int j = 0; j < iArr.length; j++) {
				if(i < iArr.length-1 && j < iArr.length-1) {
					iArr[i][j] = (int)(Math.random() * 10 + 1);
				} else if(i == 3 && j < iArr.length-1){
					for (int k = 0; k < iArr.length; k++) {
						sum += iArr[k][l];
						l++;
					}
					iArr[i][j] = sum;
					sum = 0;
					}
				}
			}
		//else if(i < 3 && j == 3) {
//					int sum = 0;
//					for (int k = 0; k < 3; k++) {
//							sum += iArr[0][k];
//						}
//					iArr[i][j] = sum;
//				} else if(i == 3 && j < 3) {
//					int sum = 0;
//					for (int k = 0; k < 3; k++) {
//							sum += iArr[k][0];
//						}
//					iArr[i][j] = sum;
//				}
//			}
//		}

		for(int i = 0 ; i < iArr.length; i++) {
			for(int j = 0; j < iArr.length; j++) {
				System.out.printf("%3d", iArr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice5() {
		int[][] iArr = new int[4][4];
		int value = 17;
	
		for(int i = 0 ; i < iArr.length; i++) {
			for(int j = 0; j < iArr.length; j++) {
				value--;
				iArr[i][j] = value;
			}
		}

		for(int i = 0 ; i < iArr.length; i++) {
			for(int j = 0; j < iArr.length; j++) {
				System.out.printf("%3d", iArr[i][j]);
			}
			System.out.println();
		}
	}	
}
