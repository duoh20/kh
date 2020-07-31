package com.kh.example.map.model.compare;

import java.util.Comparator;

public class SnackComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return -o1.compareTo(o2); //내림차순
	}

}
