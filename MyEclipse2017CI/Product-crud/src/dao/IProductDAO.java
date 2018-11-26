package dao;


import java.util.List;

import domain.Product;
import page.PageResult;
import query.ProductQueryObject;

public interface IProductDAO {
	void save (Product obj);
	void update (Product obj);
	void delete (Long id);
	Product getProduct (Long id);
	List<Product> list();
	
	
	List<Product> query(ProductQueryObject pqo);
	PageResult queryPage(Integer currentPage,Integer pageSize);
	
	PageResult query1(ProductQueryObject qo);
}
