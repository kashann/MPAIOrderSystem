package mvp.model.strategy;

import mvp.model.User;

public class CashOnDeliveryPayment implements PaymentStrategy {
    private User user;

	@Override
	public Boolean pay(Double payAmmount) {
		System.out.println("Paying " + payAmmount + " EUR with CASH ON DELIVERY METHOD");
		return true;
	}

	@Override
	public void getPaymentData(User user) {
		this.user = user;

        if (verify()) {
            System.out.println("Waiting for Cash on delivery...");
        } else {
            System.out.println("Wrong credentials!");
        }
	}
	
	 @Override
	 public boolean verify() {
		 boolean condition = user.getEmail().length() > 0 && String.valueOf(user.getPhoneNumber()).length() == 9;
		 return condition;
	 }

}
