package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProductDAO;
import dao.impl.ProductDAOImpl;
import net.sf.json.JSONArray;
import page.PageResult;
import query.ProductQueryObject;
import util.StingUtil;
@WebServlet("/m1")
public class Myservlet extends HttpServlet{
	private IProductDAO dao = new ProductDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductQueryObject qo = new ProductQueryObject();
		this.requestObj(req,qo);
		PageResult pageResult = dao.query1(qo);
		//		req.setAttribute("pageResult", pageResult);
//		System.out.println(pageResult);
		JSONArray jsonarray = JSONArray.fromObject(pageResult);



		resp.setContentType("text/json;charset=UTF-8");
		try 
		{
			resp.getWriter().print(jsonarray);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	private void requestObj(HttpServletRequest req, ProductQueryObject qo) {
		String name = req.getParameter("name");
		String minSalePrice = req.getParameter("minSalePrice");
		String maxSalePrice = req.getParameter("maxSalePrice");
		String dirId = req.getParameter("dirId");
		String keyword = req.getParameter("keyword");

		if (StingUtil.hasLength(name)) {
			qo.setName(name);
		}
		if (StingUtil.hasLength(minSalePrice)) {
			qo.setName(minSalePrice);
		}
		if (StingUtil.hasLength(maxSalePrice)) {
			qo.setName(maxSalePrice);
		}
		if (StingUtil.hasLength(dirId)) {
			qo.setName(dirId);
		}
		if (StingUtil.hasLength(keyword)) {
			qo.setName(keyword);
		}
	}


}
