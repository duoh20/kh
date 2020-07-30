package com.kh.example.list.model.vo;

public class Student implements Comparable<Student>/*Student만 가지고 정렬할거니까 제네릭 설정*/ {
	private String name;
	private int score;
	
	public Student() {}
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name +"(" + score + "점)";
	}
	
	//equals와 hashCode는 관련이 깊음!
	//equals 메소드에 의해 같은 객체로 판단된다면 hashCode도 같은 값을 가져야한다.
	//따라서 euqals를 재정의하면 hashCode도 재정의 해야함
	@Override
	public int hashCode() {
		final int PRIME = 31;//소수(1과 나 자신만 약수로 가짐),컴퓨터가 계산하기 좋은 숫자
		int result = 1;
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		result = PRIME * result + score; //같은 이름이면서, 같은 스코어면 같음으로 처리할 수 있도록 처리한 것
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		//1. 객체 자체 비교 (같은 객체인지 비교)
		if(this == obj /*같은 객체이면(this는 내 주소, obj는 매개변수로 받은 주소)*/) {
			return true;
		}
		if(obj == null) /*객체를 받아왔는데 null이면 당연히 false*/ {
			return false;
		}
		if(getClass() != obj.getClass()/*getClass로 주소값을 가져와서 비교)*/) {
			return false;
		}
		
		//2. 객체 필드 비교 (객체 안에 담긴 필드 값이 같은지 비교)
		//이 예제에서는 name과 score에 대한 비교가 필요함
		Student other = (Student)obj;
		if(name == null) { //name은 String 타입이므로 내용을 비교해야함
			if (other.name != null) {
				return false; //String이 null이면 당연히 거짓
			}
		} else if(!name.equals(other.name)) {
			return false; //String이 달라도 거짓
		}
		if(score != other.score) {
			//score는 int 타입이므로 리터럴만 비교하면 됨
			return false;
		}
		return true; //위 경우가 모두 해당되지 않으면 true
	}
	
	@Override
	//Comparable 인터페이스에 구현되지 않은 추상 메소드를 구현해주어야함
	public int compareTo(Student o) {
		//이름(String) 오름차순
		//String 클래스도 Comparable 인터페이스를 구현하고 있다 = 정렬 기준이 세워져 있음
		//String은 기본적으로 오름차순이 정렬 기준, compareTo() 사용하자
		String otherName = o.name;
		int result = name.compareTo(otherName);
		/*          비교 주체                           비교 대상
		 	비교 주체  = 비교 대상 →  0반환
		 	비교 주체  > 비교 대상 →  1반환
		 	비교 주체  < 비교 대상 → -1반환
		 */
		return result;
		//내림차순으로 하려면 return -result;
	}
	
}
