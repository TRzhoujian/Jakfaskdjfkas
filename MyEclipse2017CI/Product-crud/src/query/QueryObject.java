package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.druid.sql.ast.statement.SQLWithSubqueryClause.Entry;

public class QueryObject implements IQuery{
	private Integer currentPage =1;
	private Integer pageSize = 3;
	
	private List<Object> parameters = new ArrayList<>();
	private List<String> conditions = new ArrayList<>();
	private Map<String, String> OrderByMap = new LinkedHashMap<String, String>();
	@Override
	public String getQuery(boolean setOrderBy) {
		conditions.clear();
		parameters.clear();
		StringBuilder sql = new StringBuilder(220);
		this.customizedQuery();
		for (int i = 0; i < conditions.size(); i++) {
			if (i == 0) {
				sql.append(" where ");
			}else {
				sql.append(" and ");
			}
			sql.append(conditions.get(i));
		}
		if (setOrderBy) {
			if (OrderByMap.size()>0) {
				sql.append(" order by ");
				for (String key : OrderByMap.keySet()) {
					String colomnName = key;
					String orderByType = OrderByMap.get(key);
					sql.append(colomnName).append(" ").append(orderByType).append(",");
				}
				sql.deleteCharAt(sql.length() - 1);
			}
		}
		return sql.toString();
	}

	@Override
	public List<Object> getParameters() {
		return this.parameters;
	}
	protected void customizedQuery() {}
	protected void addQuery(String condition,Object...param) {
	    this.conditions.add(condition);	
	    this.parameters.addAll(Arrays.asList(param));
	}
	protected void SetOrderBy(String columName,OrderBy ascOrDesc) {
		OrderByMap.put(columName, ascOrDesc.name());
	}
	enum OrderBy {
		ASC,DESC;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
