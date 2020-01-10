package creational.concreteObjects;

import creational.Desktop;

public class AsusDesktop implements Desktop {

	public void printDescription() {
		System.out.println("Asus desktop with serial number " + this.hashCode());
	}

}
