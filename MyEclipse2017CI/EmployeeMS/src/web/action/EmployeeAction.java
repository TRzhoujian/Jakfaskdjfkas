package web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.IEmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import domain.Employee;
import page.PageResult;
import query.EmployeeQueryObject;

public class EmployeeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private IEmployeeDAO dao = new EmployeeDAOImpl();
	private Employee e = new Employee();
	private EmployeeQueryObject eqo = new EmployeeQueryObject();
	private Integer currentPage=1;
	public String list() {
		System.out.println("list:"+eqo.getCurrentPage());
		PageResult result = dao.query1(eqo);
		ActionContext.getContext().put("result", result);
		return SUCCESS;
	}

	

	public String delete() {
		if (e.getId() !=null) {
			dao.delete(e.getId());	
		}
		return "list";
	}
	public String input() {
		if (e.getId()!=null) {
			e = dao.getEmployee(e.getId());
		}
		return INPUT;
	}
	public String save() {
		if (e.getId() !=null) {
			dao.update(e);;
		}else {
			dao.save(e);
		}
		return "list";
	}

	
	public void validateSave() {
		System.out.println("sadfasdfsad");
	}
	
	
	
	///////////////////////////////////
	public Employee getE() {
		return e;
	}

	public void setE(Employee e) {
		this.e = e;
	}
	
	public EmployeeQueryObject getEqo() {
		return eqo;
	}

	public void setEqo(EmployeeQueryObject eqo) {
		this.eqo = eqo;
	}



	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	
}
