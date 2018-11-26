package query;

import java.math.BigDecimal;

import util.StingUtil;

public class ProductQueryObject extends QueryObject{
	private String name;
	private BigDecimal minSalePrice;
	private BigDecimal maxSalePrice;
	private String keyWord;
	
	public void customizedQuery() {
		if (StingUtil.hasLength(getName())) {
			super.addQuery("productName like ?", "%"+name+"%");
		}
		if (getMinSalePrice() != null) {
			super.addQuery("salePrice >= ?", minSalePrice);
		}
		if (getMaxSalePrice() != null) {
			super.addQuery("salePrice <= ?", maxSalePrice);
		}
		if (StingUtil.hasLength(getKeyWord())) {
			super.addQuery("productName like ? or brand like ?", "%"+keyWord+"%","%"+keyWord+"%");
		}
		super.SetOrderBy("salePrice", OrderBy.ASC);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMinSalePrice() {
		return minSalePrice;
	}

	public void setMinSalePrice(BigDecimal minSalePrice) {
		this.minSalePrice = minSalePrice;
	}

	public BigDecimal getMaxSalePrice() {
		return maxSalePrice;
	}

	public void setMaxSalePrice(BigDecimal maxSalePrice) {
		this.maxSalePrice = maxSalePrice;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public String toString() {
		return "ProductQueryObject [name=" + name + ", minSalePrice=" + minSalePrice + ", maxSalePrice=" + maxSalePrice
				+ ", keyWord=" + keyWord + "]";
	}

	
}
