package creational.concreteObjects;

import creational.Desktop;

public class DellDesktop implements Desktop {

	@Override
	public void printDescription() {
		System.out.println("Dell desktop with serial number " + this.hashCode());
	}

}
