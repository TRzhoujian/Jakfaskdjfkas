package Test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import dao.IProductDAO;
import dao.IProductDirDAO;
import dao.impl.ProductDAOImpl;
import dao.impl.ProductDirDAOImpl;
import domain.Product;
import query.ProductQueryObject;

public class ProductDAOTest {
	private IProductDAO dao = new ProductDAOImpl();
	private IProductDirDAO Dirdao = new ProductDirDAOImpl();
	@Test
	public void testSave() {
		dao.save(new Product("阿斯加德", "GR苟富贵", "富贵", new BigDecimal("122"), new BigDecimal("323"), (double) 2, 3L));
	}

	@Test
	public void testUpdate() {
		Product pro = dao.getProduct(3L);
		pro.setProductname("黒崎一護");
		dao.update(pro);
	}

	@Test
	public void testDelete() {
//		for (int i = 0; i < 10; i++) {
//			Long id = (long) (30 + i);
//			dao.delete(id);
//		}
		dao.delete(30L);
	}

	@Test
	public void testGetProduct() {
		Product pro = dao.getProduct(3L);
		System.out.println(Dirdao.getProductDir(pro.getDir_id()));
		System.out.println(Dirdao.getProductDir(pro.getDir_id()).getId());
	}

	@Test
	public void testList() {
		List<Product> list = dao.list();
		System.out.println(list);
		for (Product pro : list) {
			System.out.println(pro.getProductname() + pro.getCostPrice());
		}
	}
	
	@Test
	public void textquery2() {
		ProductQueryObject qo = new ProductQueryObject();
//		qo.setName("黒");
//		qo.setMinSalePrice(new BigDecimal(50));
//		qo.setMaxSalePrice(new BigDecimal(200));
//		qo.setKeyWord("黒");;
		List<Product> list = dao.query(qo);
		for (Product pro : list) {
			System.out.println(pro.getProductname() + "   " + pro.getSalePrice());
		}
	}
}
