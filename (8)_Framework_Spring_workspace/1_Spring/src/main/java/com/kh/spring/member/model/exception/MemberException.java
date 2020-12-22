package com.kh.spring.member.model.exception;

public class MemberException extends RuntimeException {
	//Exception은 CheckedException과 UncheckedException으로 나뉜다.
	//CheckedException: 반드시 예외 처리 필요
	//UncheckedException: 예외 처리 해도 되고 안해도 
	//RuntimeException은 반드시 예외처리를 하지 않아도 됨
	public MemberException() {}
	
	public MemberException(String msg) {
		super(msg);
	}

}
