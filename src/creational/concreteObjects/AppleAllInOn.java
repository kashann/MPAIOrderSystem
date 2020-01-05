package creational.concreteObjects;

import creational.AllInOne;

public class AppleAllInOn implements AllInOne {

	@Override
	public void printDescription() {
		System.out.println("Apple AllInOne with serial number "+ this.hashCode());
	}

}
