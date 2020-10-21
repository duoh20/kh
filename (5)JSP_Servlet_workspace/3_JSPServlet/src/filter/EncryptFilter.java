package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import wrapper.EncryptWrapper;

@WebFilter(
		servletNames = { 
				"MemberInsertServlet", 
				"LoginServlet", 
				"UpdatePwdFormServlet"
		})
public class EncryptFilter implements Filter {

    public EncryptFilter() {}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//ServletRequest equest를 그대로 보내면 암호화가 제대로 적용되 않기 때문에,
		//EncryptWrapper에서 사용하는 HttpServletRequest로 request를 변환해주어야 함
		HttpServletRequest hsr = (HttpServletRequest)request;
		EncryptWrapper ew = new EncryptWrapper(hsr);
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
