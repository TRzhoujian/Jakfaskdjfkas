package Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionContext {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private static ThreadLocal<ActionContext>  threadLocal = new ThreadLocal<ActionContext>();
	public ActionContext(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}
	
	public static void setContext(ActionContext actionContext) {
		// TODO Auto-generated method stub
		threadLocal.set(actionContext);
	}
	
	public static ActionContext getContext() {
		return threadLocal.get();

	}
	
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
