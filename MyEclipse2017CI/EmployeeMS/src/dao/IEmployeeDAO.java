package dao;

import java.util.List;

import domain.Employee;
import page.PageResult;
import query.EmployeeQueryObject;

public interface IEmployeeDAO {
	void save(Employee e);
	void delete(Long id);
	void update(Employee e);
	Employee getEmployee (Long id);
	List<Employee> list();
	
	
	//高级查询
	List<Employee> query(EmployeeQueryObject pqo);
	
	//分页查询	
	PageResult queryPage(Integer currentPage,Integer pageSize);
	
	
	//高级查询 +  分页查询
	PageResult query1(EmployeeQueryObject qo);
}
