package creational.concreteFactories;

import creational.AllInOne;
import creational.Desktop;
import creational.Factory;
import creational.Laptop;
import creational.concreteObjects.DellAllInOn;
import creational.concreteObjects.DellDesktop;
import creational.concreteObjects.DellLaptop;

public class DellFactory implements Factory{

	 private static DellFactory instance; 
	  
	  private DellFactory() {};
	  
	  synchronized public static DellFactory getInstance()  
	  { 
	    if (instance == null)  
	    { 
	      instance = new DellFactory(); 
	    } 
	    return instance; 
	  } 
	
	@Override
	public Laptop createLaptop() {
		return new DellLaptop();
	}

	@Override
	public Desktop createDesktop() {
		return new DellDesktop();
	}

	@Override
	public AllInOne createAllInOne() {
		return new DellAllInOn();
	}

}
