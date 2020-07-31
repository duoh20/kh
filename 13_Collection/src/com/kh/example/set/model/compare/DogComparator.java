package com.kh.example.set.model.compare;

import java.util.Comparator;

import com.kh.example.set.model.vo.Dog;

public class DogComparator implements Comparator<Dog> {

	//몸무게 오름차순으로 정렬 시키기
	@Override
	public int compare(Dog o1, Dog o2) {
		double standard = o1.getWeight();
		double object = o2.getWeight();
		
		if(standard > object) {
			return 1;
		} else if (standard == object) {
			//return 0; 같은 몸무게가 있을 경우 같은 객체로 보고 중복 제거하므로 이름으로 재배열하도록 수정
			return o1.getName().compareTo(o2.getName()); //같은 몸무게면 이름순으로 비교
		} else {
			return -1;
		}
	}
}
