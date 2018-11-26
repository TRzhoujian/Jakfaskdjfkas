package Test;

import org.junit.Test;

import dao.IProductDAO;
import dao.impl.ProductDAOImpl;
import page.PageResult;
import query.ProductQueryObject;

public class PageTest {
	private IProductDAO dao = new ProductDAOImpl();
	@Test
	public void testPage1() throws Exception{
		PageResult pageResult = dao.queryPage(1, 3);
		for (Object pro : pageResult.getListData()) {
			System.out.println(pro);
		}
	}
	@Test
	public void testPage2() throws Exception{
		ProductQueryObject qo = new ProductQueryObject();
//		qo.setCurrentPage(1);
//		qo.setPageSize(10);
		PageResult pageResult = dao.query1(qo);
		System.out.println(pageResult);
		for (Object pro : pageResult.getListData()) {
			System.out.println(pro);
		}
	}
}
