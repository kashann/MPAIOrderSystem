package mvp.model;

import java.util.Calendar;

public class CreditCard {
	private long number;
	private String holder;
	private int expiryMonth;
	private int expiryYear;
	private int cvv;
	
	public CreditCard(long number, String holder, int expiryMonth, int expiryYear, int cvv) {
		super();
		if(String.valueOf(number).length() == 16)
			this.number = number;
		else throw new IllegalArgumentException();
		if(!holder.isEmpty())
			this.holder = holder;			
		else throw new IllegalArgumentException();
		if(expiryMonth >= 1 && expiryMonth <= 12)
			this.expiryMonth = expiryMonth;
		else throw new IllegalArgumentException();
		if(expiryYear >= Calendar.getInstance().get(Calendar.YEAR)%100 && String.valueOf(expiryYear).length() == 2)
			this.expiryYear = expiryYear;
		else throw new IllegalArgumentException();
		if(String.valueOf(cvv).length() == 3)
			this.cvv = cvv;
		else throw new IllegalArgumentException();
	}

	public void setNumber(long number) {
		if(String.valueOf(number).length() == 16)
			this.number = number;
		else throw new IllegalArgumentException();
	}

	public void setHolder(String holder) {
		if(!holder.isEmpty())
			this.holder = holder;			
		else throw new IllegalArgumentException();
	}

	public void setExpiryMonth(int expiryMonth) {
		if(expiryMonth >= 1 && expiryMonth <= 12)
			this.expiryMonth = expiryMonth;
		else throw new IllegalArgumentException();
	}

	public void setExpiryYear(int expiryYear) {
		if(expiryYear >= Calendar.getInstance().get(Calendar.YEAR)%100 && String.valueOf(expiryYear).length() == 2)
			this.expiryYear = expiryYear;
		else throw new IllegalArgumentException();
	}

	public void setCvv(int cvv) {
		if(String.valueOf(cvv).length() == 3)
			this.cvv = cvv;
		else throw new IllegalArgumentException();
	}

	public long getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public int getExpiryMonth() {
		return expiryMonth;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	public int getCvv() {
		return cvv;
	}
}
