package creational.concreteObjects;

import creational.Laptop;

public class AsusLaptop implements Laptop {

	@Override
	public void printDescription() {
		System.out.println("Asus laptop with serial number "+ this.hashCode());
	}

}
