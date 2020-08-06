package com.kh.practice.set.model.compare;

import java.util.Comparator;

import com.kh.practice.set.model.vo.Lottery;

public class SortedLottery implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String standard  = ((Lottery)o1).getName();
		String other = ((Lottery)o2).getName();
		
		if(standard.equals(other)) {
			String stPhoneNum = ((Lottery)o1).getPhone();
			String otPhoneNum = ((Lottery)o2).getPhone();
			return stPhoneNum.compareTo(otPhoneNum);
		}
		return standard.compareTo(other);
	}
}
