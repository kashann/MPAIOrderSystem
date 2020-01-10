package creational.concreteObjects;

import creational.Laptop;

public class AppleLaptop implements Laptop {

	@Override
	public void printDescription() {
		System.out.println("Apple laptop with serial number " + this.hashCode());
	}
}
