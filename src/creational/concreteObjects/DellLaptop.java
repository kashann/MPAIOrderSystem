package creational.concreteObjects;

import creational.Laptop;

public class DellLaptop implements Laptop {

	@Override
	public void printDescription() {
		System.out.println("Dell laptop with serial number "+ this.hashCode());
	}
}
