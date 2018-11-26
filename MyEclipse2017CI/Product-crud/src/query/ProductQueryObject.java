package query;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.StingUtil;
@Getter@Setter
@ToString
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

	
}
