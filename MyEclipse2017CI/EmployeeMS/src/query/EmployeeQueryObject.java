package query;

import java.util.Date;

import util.StingUtil;

public class EmployeeQueryObject extends QueryObject{
	private String name;
	private Date lowerDate;
	private Date higherDate;
	private Integer currentPage = 1;
	public void customizedQuery() {
		if (StingUtil.hasLength(getName())) {
			super.addQuery("name like ?", "%"+name+"%");
		}
		if (lowerDate != null) {
			super.addQuery("hireDate >= ?", lowerDate);
		}
		if (higherDate != null) {
			super.addQuery("hireDate <= ?", higherDate);
		}
//		if (StingUtil.hasLength(getKeyWord())) {
//			super.addQuery("productName like ? or brand like ?", "%"+keyWord+"%","%"+keyWord+"%");
//		}
		super.SetOrderBy("hireDate", OrderBy.ASC);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Date getLowerDate() {
		return lowerDate;
	}

	public void setLowerDate(Date lowerDate) {
		this.lowerDate = lowerDate;
	}

	public Date getHigherDate() {
		return higherDate;
	}

	public void setHigherDate(Date higherDate) {
		this.higherDate = higherDate;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "EmployeeQueryObject [name=" + name + ", lowerDate=" + lowerDate + ", higherDate=" + higherDate + "]";
	}

	
	

	
}
