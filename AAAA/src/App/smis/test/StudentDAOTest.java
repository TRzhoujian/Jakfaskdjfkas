package App.smis.test;

import java.util.List;

import org.junit.Test;

import App.smis.dao.IStudentDAO;
import App.smis.dao.impl.StudentDAOImpl;
import App.smis.domain.Student;
import App.smis.handler.impl.ScalarHander;
import App.smis.util.JdbcTemplate;

public class StudentDAOTest {
	private IStudentDAO dao = new StudentDAOImpl();
	@Test
	public void testSave() {
		dao.save(new Student(null, "福山潤（ふくやまじゅん）", 32));
	}

	@Test
	public void testDelete() {
		for (int i = 0; i < 3; i++) {	
			dao.delete(52L + i);
		}
	}

	@Test
	public void testUpdate() {
		dao.update(new Student(51L, "福山潤（ふくやまじゅん）", 28));
	}
	
	
	@Test
	public void testCount() {
		String sql = "select count(id) from user1";
		Long count = JdbcTemplate.query(sql, new ScalarHander<>(Long.class));
		System.out.println(count);
	}
	
	
	@Test
	public void testGet() {
		Student student = dao.get(46L);
		System.out.println("ID(アイディー):" + student.getId() + "  名前(なまえ):" + student.getName() + "  年齢(ねんれい):" + student.getAge());
	}

	@Test
	public void testList() {
		List<Student> list = dao.list();
		for (Student student : list) {
			System.out.println("ID(アイディー):" + student.getId() + "  名前(なまえ):" + student.getName() + "  年齢(ねんれい):" + student.getAge());
		}
	}

}
