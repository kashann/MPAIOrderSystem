package creational.concreteFactories;

import creational.AllInOne;
import creational.Desktop;
import creational.Factory;
import creational.Laptop;
import creational.concreteObjects.AsusAllInOn;
import creational.concreteObjects.AsusDesktop;
import creational.concreteObjects.AsusLaptop;

public class AsusFactory implements Factory{

	 private static AsusFactory instance; 
	  
	  private AsusFactory() {};
	  
	  synchronized public static AsusFactory getInstance()  
	  { 
	    if (instance == null)  
	    { 
	      instance = new AsusFactory(); 
	    } 
	    return instance; 
	  } 
	
	@Override
	public Laptop createLaptop() {
		return new AsusLaptop();
	}

	@Override
	public Desktop createDesktop() {
		return new AsusDesktop();
	}

	@Override
	public AllInOne createAllInOne() {
		return new AsusAllInOn();
	}

}
