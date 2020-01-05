package mvp.model;

public class Product {
	private EBrand brand;
	private EComputerType type;
	private double price;
	
	public Product(EBrand brand, EComputerType type, double price) {
		super();
		this.brand = brand;
		this.type = type;
		this.price = price;
	}

	public EBrand getBrand() {
		return brand;
	}

	public void setBrand(EBrand brand) {
		this.brand = brand;
	}

	public EComputerType getType() {
		return type;
	}

	public void setType(EComputerType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
