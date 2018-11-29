package dao.impl;

import java.util.List;

import dao.IProductDAO;
import domain.Product;
import handler.impl.BeanHandler;
import handler.impl.BeanListHandler;
import handler.impl.ScalarHander;
import page.PageResult;
import query.ProductQueryObject;
import util.JdbcTemplate;
import util.QueryUtil;

public class ProductDAOImpl  implements IProductDAO{

	@Override
	public void save(Product pro) {
		String sql = "insert into Product(productname,brand,supplier,salePrice,costPrice,cutoff,dir_id) values(?,?,?,?,?,?,?)";
		Object[] args = {pro.getProductname(),pro.getBrand(),pro.getSupplier(),pro.getSalePrice(),pro.getCostPrice(),pro.getCutoff(),pro.getDir_id()};
		JdbcTemplate.update(sql, args);
	}

	@Override
	public void update(Product pro) {
		// TODO Auto-generated method stub
		String sql = "update Product set productname = ?,brand = ?,supplier = ?,salePrice = ?,costPrice = ?,cutoff = ?,dir_id = ? where id =?";
		Object[] args = {pro.getProductname(),pro.getBrand(),pro.getSupplier(),pro.getSalePrice(),pro.getCostPrice(),pro.getCutoff(),pro.getDir_id(),pro.getId()};
		JdbcTemplate.update(sql, args);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String sql = "delete from Product where id = ?";
		JdbcTemplate.update(sql, id);
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		String sql = "select * from Product where id = ?" ;
		Product stu = JdbcTemplate.query(sql,new BeanHandler<>(Product.class),id);
		return stu;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		String sql = "select * from Product";
		return JdbcTemplate.query(sql,new BeanListHandler<>(Product.class));
	}

	

	@Override
	public List<Product> query(ProductQueryObject pqo) {
		String sql = "select * from Product" + pqo.getQuery(true);
		System.out.println(sql);
		System.out.println(pqo.getParameters());
		return JdbcTemplate.query(sql,new BeanListHandler<>(Product.class),pqo.getParameters().toArray());
	}

	@Override
	public PageResult queryPage(Integer currentPage, Integer pageSize) {
		String sql = "select *from product limit ?,?";
		Object[] args = {(currentPage-1) * pageSize ,pageSize};
		List<Product> listDataList = JdbcTemplate.query(sql, new BeanListHandler<>(Product.class), args);
		
		
		String sql1 = "select count(*) from product";
		Integer totalCount = JdbcTemplate.query(sql1,new ScalarHander<>(Long.class)).intValue();
		return new PageResult(listDataList, totalCount, currentPage, pageSize);
	}

	@Override
	public PageResult query1(ProductQueryObject qo) {
		return QueryUtil.query(qo, "product", new BeanListHandler<>(Product.class));
	}

}
