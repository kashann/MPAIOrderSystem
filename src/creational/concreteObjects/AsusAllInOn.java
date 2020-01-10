package creational.concreteObjects;

import creational.AllInOne;

public class AsusAllInOn implements AllInOne {

	@Override
	public void printDescription() {
		System.out.println("Asus laptop with serial number " + this.hashCode());
	}

}
