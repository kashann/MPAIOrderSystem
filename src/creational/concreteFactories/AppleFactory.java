package creational.concreteFactories;

import creational.AllInOne;
import creational.Desktop;
import creational.Factory;
import creational.Laptop;
import creational.concreteObjects.AppleAllInOn;
import creational.concreteObjects.AppleDesktop;
import creational.concreteObjects.AppleLaptop;

public class AppleFactory implements Factory{
	 private static AppleFactory instance;
	 
	 private AppleFactory()  {}
	  
	 synchronized public static AppleFactory getInstance() { 
		if (instance == null) {
			instance = new AppleFactory(); 
		} 
		return instance; 
	 } 
	
	@Override
	public Laptop createLaptop() {
		return new AppleLaptop();
	}

	@Override
	public Desktop createDesktop() {
		return new AppleDesktop();
	}

	@Override
	public AllInOne createAllInOne() {
		return new AppleAllInOn();
	}
}
