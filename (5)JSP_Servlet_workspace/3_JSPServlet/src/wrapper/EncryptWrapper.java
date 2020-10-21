package wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{
	//회원 가입 시 비밀번호는 전달할 때 암호화를 마친 상태로 보내줘야 하므로  HttpServletRequestWrapper 상속
	
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// 부모 타입(HttpServletRequestWrapper)에 기본 생성자가 없음
		// 반드시 명시적으로 HttpServletRequestWrapper를 매개변수로 하는 생성자 작성
	}
	
	//view : <input type="text" name="userId">
	//Servlet : String id = request.getParameter("String");
	@Override
	public String getParameter(String name) {
		String value = "";
		
		if(name != null && (name.equals("userPwd") || name.equals("joinUserPwd") || name.equals("newPwd"))) {
			//암호화 진행 O: 암호화 대상은 비밀번호임 input 태그의 name이 userPwd인 경우에만 암호화 진행
			getSha512(super.getParameter(name));
		} else {
			//암호화 진행 X, 원래대로 가져옴
			value = super.getParameter(name);
		}
		return value;
	}

	private String getSha512(String userPwd) {
		String encPwd = null; //암호화한 pwd를 담을 변수
		
		MessageDigest md = null; //java.security 패키지의 클래스 사용, SHA-512 방식의 암호화 객체
		//SHA-512 방식은 지향하는 암호화 방식은 아님, 추후 Spring에서 bcript를 사용할 예정
		
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		//전달 받은 userPwd를 byte 배열로 변경
		byte[] bytes = userPwd.getBytes(Charset.forName("UTF-8"));
		
		//바이트로 쪼갠 userPwd를 업데이트
		md.update(bytes);
		
		//Base64 인코딩을 하기 위한 클래스,encPwd에 암호화한 비밀번호 담음
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		
		return encPwd;
	}
	
}
