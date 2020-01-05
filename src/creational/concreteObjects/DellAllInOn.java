package creational.concreteObjects;

import creational.AllInOne;

public class DellAllInOn implements AllInOne {

	@Override
	public void printDescription() {
		System.out.println("Dell AllInOne with serial number "+ this.hashCode());
	}

}
