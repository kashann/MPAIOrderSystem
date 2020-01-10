package mvp.model;

import creational.AllInOne;
import creational.Desktop;
import creational.Laptop;

public class ProductBuilder {
	private Product product = new Product();

	public ProductBuilder buildProduct(EComputerType computerType) {
		this.product.setType(computerType);
		return this;
	}
	
	public ProductBuilder setProductBrand(EBrand brand) {
		this.product.setBrand(brand);
		return this;
	}
	
	public ProductBuilder setProductPrice(double price) {
		this.product.setPrice(price);
		return this;
	}
	
	public Product getFinalProduct() {
		return this.product;
	}

}
