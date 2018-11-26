package App.smis.dao;

import java.util.List;

import App.smis.domain.Student;


public interface IStudentDAO {
	void save (Student stu);
	void delete(long id);
	void update(Student stu);
	Student get(long id);
	List<Student> list();
}