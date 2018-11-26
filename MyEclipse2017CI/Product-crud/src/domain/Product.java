package domain;

import java.math.BigDecimal;

import lombok.Data;

//Bootstrap
@Data
public class Product {
	private Long id;
	private String productname;
	private String brand;
	private String supplier;
	private BigDecimal salePrice;
	private BigDecimal costPrice;
	private Double cutoff;
	private Long dir_id;
	
	

	public Product() {
		super();
	}

	public Product(String productname, String brand, String supplier, BigDecimal salePrice, BigDecimal costPrice,
			Double cutoff, Long dir_id) {
		super();
		this.productname = productname;
		this.brand = brand;
		this.supplier = supplier;
		this.salePrice = salePrice;
		this.costPrice = costPrice;
		this.cutoff = cutoff;
		this.dir_id = dir_id;
	}
	
	
}
