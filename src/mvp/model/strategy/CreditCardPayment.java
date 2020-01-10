package mvp.model.strategy;

import mvp.model.User;

public class CreditCardPayment implements PaymentStrategy {	
	private User user;

	@Override
	public Boolean pay(Double payAmmount) {
		System.out.println("Paying " + payAmmount + " EUR with CREDIT CARD");
		return true;
	}

	@Override
	public void getPaymentData(User user) {
        this.user = user;
        if (verify()) {
            System.out.println("Credit card info OK!");
        } else {
            System.out.println("Wrong credit card info!");
        }
	}

	@Override
	public boolean verify() {
        boolean condition = String.valueOf(user.getCard().getNumber()).length() == 16 && user.getCard().getCvv() > 0;
		return condition;
	}

	
}
