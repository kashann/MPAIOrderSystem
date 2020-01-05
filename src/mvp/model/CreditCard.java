package mvp.model;

public class CreditCard {
	private long number;
	private String holder;
	private int expiryMonth;
	private int expiryYear;
	private int cvv;
	
	public CreditCard(long number, String holder, int expiryMonth, int expiryYear, int cvv) {
		super();
		this.number = number;
		this.holder = holder;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cvv = cvv;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
}
