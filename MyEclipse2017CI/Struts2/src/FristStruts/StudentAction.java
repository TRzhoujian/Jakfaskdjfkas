package FristStruts;
import java.util.Map;

import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Model.User;


public class StudentAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Map<String, Parameter> parameters = ctx.getParameters();
		Map<String, Object> session = ctx.getSession();
		session.put("AAA", parameters);
		System.out.println(parameters);
		return SUCCESS;
	}
	@Override
	public Model.User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
