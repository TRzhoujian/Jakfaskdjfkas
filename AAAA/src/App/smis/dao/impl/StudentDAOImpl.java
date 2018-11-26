package App.smis.dao.impl;

import java.util.List;

import App.smis.dao.IStudentDAO;
import App.smis.domain.Student;
import App.smis.handler.impl.BeanHandler;
import App.smis.handler.impl.BeanListHandler;
import App.smis.util.JdbcTemplate;

public class StudentDAOImpl implements IStudentDAO {
	@Override
	public void save(Student stu) {
		String sql = "insert into user1(name,age) values(?,?)";
		Object[] args = {stu.getName(),stu.getAge()};
		JdbcTemplate.update(sql, args);
	}

	@Override
	public void delete(long id) {
		String sql = "delete from user1 where id = ?";
		JdbcTemplate.update(sql, id);

	}

	@Override
	public void update(Student stu) {
		String sql = "update user1 set name = ?,age = ? where id =?";
		Object[] args = {stu.getName(),stu.getAge(),stu.getId()};
		JdbcTemplate.update(sql, args);

	}


	@Override
	public Student get(long id) {
		String sql = "select * from user1 where id = ?" ;
		Student stu = JdbcTemplate.query(sql,new BeanHandler<>(Student.class),id);
		return stu;
	}

	@Override
	public List<Student> list() {
		String sql = "select * from user1";
		return JdbcTemplate.query(sql,new BeanListHandler<>(Student.class));
	}

//	private class StudentHandler implements IresultSetHandler<List<Student>>{
//		@Override
//		public List<Student> handler(ResultSet rs) throws Exception {
//			List<Student> list = new ArrayList<>(); 
//			while (rs.next()) {
//				Long id = rs.getLong("id");
//				String name = rs.getString("name");
//				Integer age = rs.getInt("age");
//				Student stu = new Student(id,name,age);
//				list.add(stu);
//			}
//			return list;
//		}
//	}
	
	
	
}
