package com.kh.practice.numRange.controller;

import com.kh.practice.numRange.exception.NumRangeException;

public class NumberController {
	public NumberController() {}
	
	public boolean checkDouble(int num1, int num2) throws NumRangeException {
		if(0 < num1 && num1 <= 100) {
			if(num1 % num2 == 0) {
				return true;
			}
		} else {
			throw new NumRangeException("1부터 100 사이의 값이 아닙니다.");
		}
		return false;
	}
}
