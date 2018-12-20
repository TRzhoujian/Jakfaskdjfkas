package domain;

import java.util.Date;

public class Employee {
	private Long id;
	private String name;
	private String password;
	private String email;
	private Date hireDate;
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", hireData="
				+ hireDate + "]";
	}
	
	
	public Employee() {
		super();
	}


	public Employee(Long id, String name, String password, String email, Date hireDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.hireDate = hireDate;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	
	
}