package mvp.model;

public class Product {
	private String name;
	private double price;
	private EBrand brand;
	
	public Product(String name, double price, EBrand brand) {
		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public EBrand getBrand() {
		return brand;
	}

	public void setBrand(EBrand brand) {
		this.brand = brand;
	}	
}
