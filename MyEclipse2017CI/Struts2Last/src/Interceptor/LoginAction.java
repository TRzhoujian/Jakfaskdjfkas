package Interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Model.User;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	@Override
	public String execute() throws Exception {
		if (username.equals("zhou") && password.equals("123456")) {
			return Action.SUCCESS;
		}
		ActionContext.getContext().put("errorMsg", "账号密码错误");
		return "login";
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
