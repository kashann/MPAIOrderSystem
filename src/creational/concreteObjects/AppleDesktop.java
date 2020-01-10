package creational.concreteObjects;

import creational.Desktop;

public class AppleDesktop implements Desktop {

	@Override
	public void printDescription() {
		System.out.println("Apple desktop with serial number " + this.hashCode());
	}

}
