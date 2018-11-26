package util;

import java.util.ArrayList;
import java.util.List;

import domain.Product;
import handler.IresultSetHandler;
import handler.impl.ScalarHander;
import page.PageResult;
import query.IQuery;
@SuppressWarnings("all")
public class QueryUtil {
	public static PageResult query(IQuery qo ,String tableName,IresultSetHandler rsh) {
		String sql = "select * from " + tableName + qo.getQuery(true) + " limit ?,?";
		List<Object> newParams = new ArrayList<Object>(qo.getParameters());
		newParams.add((qo.getCurrentPage()-1) * qo.getPageSize());
		newParams.add(qo.getPageSize());
		List<Product> listDataList = JdbcTemplate.query(sql, rsh, newParams.toArray());
		
		
		String sql1 = "select count(*) from " + tableName + qo.getQuery(false);
		Integer totalCount = JdbcTemplate.query(sql1,new ScalarHander<>(Long.class),qo.getParameters().toArray()).intValue();
		return new PageResult(listDataList, totalCount, qo.getCurrentPage(), qo.getPageSize());
	}
}
