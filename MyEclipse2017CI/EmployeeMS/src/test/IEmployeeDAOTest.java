package test;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.IEmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import domain.Employee;
import query.EmployeeQueryObject;

class IEmployeeDAOTest {
	private IEmployeeDAO dao = new EmployeeDAOImpl();
	@Test
	void testSave() {
		Employee employee = new Employee(null, "桐谷和人","123456", "xxxxxx@qq.com", new Date());
		dao.save(employee);
	}

	@Test
	void testDelete() {
		dao.delete(1L);
	}

	@Test
	void testUpdate() {
		Employee employee = new Employee(3L, "桐谷和人","54434", "xxxxxx@qq.com", new Date());
		dao.update(employee);
	}

	@Test
	void testGet() {
		Employee employee = dao.getEmployee(3L);
		System.out.println(employee);
	}

	@Test
	void testList() {
		List<Employee> list = dao.list();
		for (Employee e : list) {
			System.out.println(e);
		}
	}
	@Test
	void testQuery() {
		EmployeeQueryObject qObject = new EmployeeQueryObject();
		qObject.setName("桐");
		List<Employee> query = dao.query(qObject);
		for (Employee e : query) {
			System.out.println(e);
		}
	}
}
