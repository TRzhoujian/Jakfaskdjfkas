package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.IEmployeeDAO;
import domain.Employee;
import handler.impl.BeanHandler;
import handler.impl.BeanListHandler;
import handler.impl.ScalarHander;
import page.PageResult;
import query.EmployeeQueryObject;
import util.JdbcTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO{

	@Override
	public void save(Employee e) {
		String sql = "insert into t_employee values(NULL,?,?,?,?)";
		Object[] args = {e.getName(),e.getPassword(),e.getEmail(),e.getHireDate()};
		JdbcTemplate.update(sql, args);
	}

	

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
		String sql = "update t_employee set name = ?,password = ?,email = ?,hireDate = ? where id =?";
		Object[] args = {e.getName(),e.getPassword(),e.getEmail(),e.getHireDate(),e.getId()};
		JdbcTemplate.update(sql, args);
	}

	
	@Override
	public List<Employee> list() {
		String sql = "select * from t_employee";
		return JdbcTemplate.query(sql,new BeanListHandler<>(Employee.class));
		
	}

	@Override
	public Employee getEmployee(Long id) {
		String sql = "select * from t_employee where id = ?" ;
		Employee stu = JdbcTemplate.query(sql,new BeanHandler<>(Employee.class),id);
		return stu;
	}



	@Override
	public void delete(Long id) {
		String sql = "delete from t_employee where id = ?";
		JdbcTemplate.update(sql, id);
		
	}



	@Override
	public List<Employee> query(EmployeeQueryObject pqo) {
		String sql = "select * from t_employee" + pqo.getQuery(false);
		return JdbcTemplate.query(sql,new BeanListHandler<>(Employee.class),pqo.getParameters().toArray());
	}



	@Override
	public PageResult queryPage(Integer currentPage, Integer pageSize) {
		String sql = "select *from t_employee limit ?,?";
		Object[] args = {(currentPage-1) * pageSize ,pageSize};
		List<Employee> listDataList = JdbcTemplate.query(sql, new BeanListHandler<>(Employee.class), args);
		
		
		String sql1 = "select count(*) from t_employee";
		Integer totalCount = JdbcTemplate.query(sql1,new ScalarHander<>(Long.class)).intValue();
		return new PageResult(listDataList, totalCount, currentPage, pageSize);
	}



	@Override
	public PageResult query1(EmployeeQueryObject qo) {
		String sql = "select * from t_employee" + qo.getQuery(false) + " limit ?,?";
		List<Object> newParams = new ArrayList<Object>(qo.getParameters());
		newParams.add((qo.getCurrentPage()-1) * qo.getPageSize());
		newParams.add(qo.getPageSize());
		List<Employee> listDataList = JdbcTemplate.query(sql, new BeanListHandler<>(Employee.class), newParams.toArray());
		
		
		String sql1 = "select count(*) from t_employee"  + qo.getQuery(false);
		Integer totalCount = JdbcTemplate.query(sql1,new ScalarHander<>(Long.class),qo.getParameters().toArray()).intValue();
		return new PageResult(listDataList, totalCount, qo.getCurrentPage(), qo.getPageSize());
	}

}
