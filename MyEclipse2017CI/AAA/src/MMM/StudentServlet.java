package MMM;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smis.dao.IStudentDAO;
import smis.dao.impl.StudentDAOImpl;
import smis.domain.Student;

@WebServlet("/student")
public class StudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		dao = new StudentDAOImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cmdString = req.getParameter("cmd");
		if ("save".equals(cmdString) ) {
			this.update(req, resp);
		}else if ("edit".equals(cmdString) ) {
			this.edit(req, resp);
		}else if ("delete".equals(cmdString) ) {
			this.delete(req, resp);
		}else {
			this.list(req, resp);
		}
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> stus = dao.list();
		req.setAttribute("students", stus);
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
	
	
	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null && !"".equals(id)) {
			Long lid = Long.valueOf(id);
			Student student = dao.get(lid);
			req.setAttribute("student", student);	
		}
		req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
	}
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dao.delete(Long.valueOf(req.getParameter("id")));
		
		resp.sendRedirect("/student");
	}
	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nameString = req.getParameter("name");
		String ageString = req.getParameter("age");
		String idString = req.getParameter("id");
		Student stu = new Student(nameString, Integer.valueOf(ageString));
		if (idString != null && !"".equals(idString)) {
			stu.setId(Long.valueOf(idString));
			dao.update(stu);
		}else {
			dao.save(stu);	
		}
		
		resp.sendRedirect("/student");
	}
}
