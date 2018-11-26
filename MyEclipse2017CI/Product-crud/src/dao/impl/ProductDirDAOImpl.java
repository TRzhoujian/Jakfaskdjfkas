package dao.impl;

import java.util.List;

import dao.IProductDirDAO;
import domain.ProductDir;
import handler.impl.BeanHandler;
import handler.impl.BeanListHandler;
import util.JdbcTemplate;

public class ProductDirDAOImpl implements IProductDirDAO{
	

	public ProductDir getProductDir(Long id) {
		// TODO Auto-generated method stub
		String sql = "select * from ProductDir where id = ?" ;
		ProductDir proDir = JdbcTemplate.query(sql,new BeanHandler<>(ProductDir.class),id);
		return proDir;
	}

	@Override
	public List<ProductDir> list() {
		// TODO Auto-generated method stub
		String sql = "select * from ProductDir";
		return JdbcTemplate.query(sql,new BeanListHandler<>(ProductDir.class));
	}


}
