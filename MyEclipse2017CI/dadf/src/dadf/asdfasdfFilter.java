package dadf;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.StingUtil;

public class asdfasdfFilter implements Filter{
	private String encoding;
	private String[] unCheckUris = {"/adfad","/asdfasd"};
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest =  (HttpServletRequest) request;
		HttpServletResponse httpResponse =  (HttpServletResponse) response;
		String requestUri = httpRequest.getRequestURI();
		
		if (!Arrays.asList(unCheckUris).contains(requestUri)) {
			
		}
//		httpRequest.setCharacterEncoding("UTF-8");
		
		if (StingUtil.hasLength(encoding) && httpRequest.getCharacterEncoding() == null) {
			httpRequest.setCharacterEncoding(encoding);	
		}
		chain.doFilter(httpRequest, httpResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding = filterConfig.getInitParameter("encoding");
	}

}
