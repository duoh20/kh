package com.kh.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.member.model.exception.MemberException;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

@SessionAttributes("loginUser")
//model 중에서 

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
//	/*** 파라미터 전송 받는 방법 ***/
//	//1. HttpServletRequest를 통해 전송 받기 (JSP/Servlet 방식)
//	@RequestMapping("login.me")
//	public void login(HttpServletRequest request) {
//		//매개변수로 HttpServletRequest 객체를 받아옴
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		
//		System.out.println("id : " + id + ", pwd : " + pwd);
//	}
	
//	//2. @RequestParam 어노테이션 방식
//	@RequestMapping("login.me")
//	public void login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
//		//@RequestParam은 받아온 값을 String id에 담아 매개 변수로 받아다주는 역할을 함
//		System.out.println("id : " + id + ", pwd : " + pwd);
//	}
	
//	//3. @RequestParam 어노테이션 생략
//	@RequestMapping("login.me")
//	public void login(String id, String pwd) {
//		//form에서 보낸 파라미터와 이름이 같아야 받아올 수 있음
//		System.out.println("id : " + id + ", pwd : " + pwd);
//	}
	
//	//4. @ModelAttribute 어노테이션 방식
//	@RequestMapping("login.me")
//	public void login(@ModelAttribute Member m) {
//		//form에서 값을 받아올 때, 설정한 객체의 getter, setter를 참조해 객체 받아옴
//		//요청 파라미터가 많을 때에는 객체 파라미터로 받아오면 편리함
//		System.out.println("id : " + m.getId() + ", pwd : " + m.getPwd());
//	}
	
//	//5. @ModelAttribute 어노테이션 생략
//	@RequestMapping("login.me")
//	public void login(Member m) {
//		
////		MemberService mService = new MemberServiceImpl();
////		System.out.println(mService.hashCode());
////		//위 방식은 결합도가 높은 코드
////		//:클래스 명을 바꾸면 에러가 나고, 계속 새로운 객체를 생성해서 새로운 주소를 할당받기 때문
////		//결합도가 낮은 코드를 만들려면?
////		// 1. 클래스명 바꿔도 영향받지 않게 하기
////		// 2. 해시코드 출력하면 같은 값이 나오게 하기
//		
//	Member loginUser = mService.memberLogin(m);
//	
//	}
	
//	/***** 요청 후 전달하고자 하는 데이터가 있을 경우 *****/
//	// 1.model 객체 사용 : 맵 형식(Key, value)
//	//					 scope는 request
//	@RequestMapping("login.me")
//	public String login(Member m, HttpSession session, Model model) {
//		
//		Member loginUser = mService.memberLogin(m);
//		
//		if(loginUser != null) {
//			session.setAttribute("loginUser", loginUser);
//			return "redirect:home.do";
//			//home.do에 요청할 것이기 때문에 resolver가 prefix와 surfix를 붙이지 않도록 리다이렉트를 붙여서 보냄
//		} else {
//			model.addAttribute("message", "로그인에 실패했습니다.");
//			//request.setAttribute()와 같다
//			return "../common/errorPage";
//			//*.me 형식으로 보냈기 때문에 매핑된 member-context.xml에서 경로를 설정한다.
//			// member-context.xml에 설정한 경로가 /WEB-INF/views/member인데
//			// errorPage는 /WEB-INF/views/common하위에 있으므로, return할 errprPage의 경로는 한 경로 위로 이동한 경로를 작성해주어야한다.
//		}
//	}
	
//	// 2. ModelAndView 객체 사용
//	// Model(맵 형식 : key와 value) + View(RequestDispatcher처럼 forward할 페이지 정보 담음)
//	// Model => 값을 집어 넣는 것
//	// View => 화면에 보여줄 것
//	@RequestMapping("login.me")
//	public ModelAndView login(Member m, HttpSession session, ModelAndView mv) {
//		
//		Member loginUser = mService.memberLogin(m);
//		
//		if(loginUser != null) {
//			session.setAttribute("loginUser", loginUser);
//			mv.setViewName("redirect:home.do");
//		} else {
//			mv.addObject("message", "로그인에 실패했습니다.");
//			 request.setAttribute(), model.addAtrribute()와 동일
//			mv.setViewName("../common/errorPage");
//		}
//		return mv;
//	}
	
//	//로그아웃용 컨트롤러1
//	@RequestMapping("logout.me")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:home.do";
//	}
	
	// 3. session에 저장할 @SessionAttributes 사용
	//	  model에 attribute가 추가될 때 자동으로 키값을 찾아 세션에 등록
	//	  sessionAttribute를 사용할 때 전제 조건은 Model.addAttributte()로 키 값을 셋팅해야 함
	//    선언한 키 값을 클래스 상단에 @SessionAttributs("키값")으로 사용하면 세션에 실림
//	@RequestMapping("login.me")
//	public String login(Member m, Model model) {
//		
//		Member loginUser = mService.memberLogin(m);
//		
//		if(loginUser != null) {
//			model.addAttribute("loginUser", loginUser);
//			return "redirect:home.do";
//		} else {
////			model.addAttribute("message", "로그인에 실패했습니다.");
////			return "../common/errorPage";
//			throw new MemberException("로그인에 실패했습니다.");
//		}
//	}
	
	//로그아웃용 컨트롤러2
	//@SessionAttribute로 선언하면 session.invalidate()가 먹히지 않음
	@RequestMapping("logout.me")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:home.do";
	}
	
	@RequestMapping("enrollView.me")
	public String enrollView() {
		return "memberJoin";
	}
	
	@RequestMapping("minsert.me")
	public String memberInsert(@ModelAttribute Member m, @RequestParam("post") String post,
														 @RequestParam("address1") String address1,
														 @RequestParam("address2") String address2) {
		m.setAddress(post + "/" + address1 + "/" + address2);
		
		// JSP/Servlet : SHA-512
		// Spring : Bcrypt 암호화 방식 (같은 값을 넣어도 다른 값으로 암호화됨)
		// 암호화한 패스워드 encPwd를 m객체의 비밀번호로 업데이트
		String encPwd = bcrypt.encode(m.getPwd());
		//System.out.println(encPwd);
		m.setPwd(encPwd);
		
		int result = mService.insertMember(m);
		
		if(result > 0) {
			return "redirect:home.do";
		} else {
			throw new MemberException("회원 가입에 실패했습니다.");
		}
		
	}
	
	// 비밀번호 암호화 후 복호화 처리
	@RequestMapping("login.me")
	public String login(Member m, Model model) {
		
		Member loginUser = mService.memberLogin(m);
		//loginUser에는 아이디가 일치했을 때의 활성 유저 정보가 들어있는 상태
		//즉, 지금 loginUser의 pwd는 DA에 저장된 암호화된 비밀번호임

		if(bcrypt.matches(m.getPwd(), loginUser.getPwd())){
		//bcrypt.match(view에서 받아온 암호, DB에 저장된 암호); -> 일치하면 true 리턴
			model.addAttribute("loginUser", loginUser);
			return "redirect:home.do";
		} else {
			throw new MemberException("로그인에 실패했습니다.");
		}
	}
	
	@RequestMapping("myinfo.me")
	public String myInfoView() {
		return "mypage";
	}
	
	@RequestMapping("mpwdUpdateView.me")
	public String mpwdUpdateView() {
		return "memberPwdUpdateForm";
	}
	
	@RequestMapping("mPwdUpdate.me")
	public String mpwdUpdate(@SessionAttribute("loginUser") Member m, Model model, 
							 @RequestParam("pwd") String pwd, @RequestParam("newPwd1") String newPwd) {
		
		if(bcrypt.matches(pwd, m.getPwd())) {
			String encPwd = bcrypt.encode(newPwd);
			m.setPwd(encPwd);
			int result = mService.pwdUpdate(m);
			
			if(result > 0) {
				Member member = mService.memberLogin(m);
				model.addAttribute("loginUser", member);
				return "mypage";
			} else {
				throw new MemberException("비밀번호 업데이트에 실패했습니다.");
			}
		} else {
			throw new MemberException("비밀번호가 일치하지 않습니다."); 
		}
	}
	
	@RequestMapping("mupdateView.me")
	public String mupdateView() {
		return "memberUpdateForm";
	}
	
	@RequestMapping("mupdate.me")
	public String memberUpdate(@ModelAttribute Member m, Model model,
						  	   @RequestParam("post") String post, @RequestParam("address1") String address1, @RequestParam("address2") String address2) {
		
		m.setAddress(post + "/" + address1 + "/" + address2);
		
		int result = mService.updateMember(m);
		
		if(result > 0) {
			//@SessionAttributes를 설정하려면 Model 객체가 필요함
			model.addAttribute("loginUser", m);
			return "mypage";
		} else {
			throw new MemberException("회원정보 업데이트에 실패했습니다.");
		}
	}
	
	@RequestMapping("mdelete.me")
	public String deleteMember(@RequestParam("id") String id, SessionStatus status) {
		
		int result = mService.deleteMember(id);
		
		if(result > 0) {
			status.setComplete();
			return "redirect: home.do";
		} else {
			throw new MemberException("회원 탈퇴에 실패했습니다.");
		}
	}
}
