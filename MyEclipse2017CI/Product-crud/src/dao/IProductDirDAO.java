package dao;

import java.util.List;

import domain.ProductDir;

public interface IProductDirDAO {
	ProductDir getProductDir(Long id);
	List<ProductDir> list();
	
	
}
