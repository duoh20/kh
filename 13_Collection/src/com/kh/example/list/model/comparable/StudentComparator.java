package com.kh.example.list.model.comparable;

import java.util.Comparator;

import com.kh.example.list.model.vo.Student;

public class StudentComparator implements Comparator<Student> {
	
	//점수 순으로 정렬하기
	@Override
	public int compare(Student o1, Student o2) {
		int standard = o1.getScore();
		int object = o2.getScore();
		//비교 주체와 비교 대상의 객체의 점수 받아오기
		
		if(standard > object) {
			return 1; //내림차순 -1
		} else if (standard == object) {
			//return 0;
			//점수 순으로 정렬했는데, 점수가 같은 객체들은 이름 오름차순으로 정렬하고 싶다면??
			String standardName = o1.getName();
			String objectName = o2.getName();
			return standardName.compareTo(objectName);
		} else {
			return -1; //내림차순 1
		}
	}
}
