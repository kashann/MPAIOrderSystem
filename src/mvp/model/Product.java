package mvp.model;

public class Product {
	private EBrand brand;
	private EComputerType type;
	private double price;
	
	public Product(EBrand brand, EComputerType type, double price) {
		super();
		this.brand = brand;
		this.type = type;
		this.price = round(price, 2);
	}

	public Product() {}

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
		this.price = round(price, 2);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) 
	    	throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
