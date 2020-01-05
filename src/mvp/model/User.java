package mvp.model;

public class User {
	private String name;
	private String surname;
	private String billingAddress;
	private String deliveryAddress;
	private CreditCard card;
	
	public User(String name, String surname, String billingAddress, String deliveryAddress, CreditCard card) {
		super();
		this.name = name;
		this.surname = surname;
		this.billingAddress = billingAddress;
		this.deliveryAddress = deliveryAddress;
		this.card = card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}
}
