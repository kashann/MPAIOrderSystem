package mvp.model.strategy;

import mvp.model.User;

public class BankTransferStrategy implements PaymentStrategy {
	private User user;

	@Override
	public Boolean pay(Double payAmmount) {
		System.out.println("Paying " + payAmmount + " EUR with BANK TRANSFER METHOD");
		return true;
	}

	@Override
	public void getPaymentData(User user) {
		this.user = user;

        if (verify()) {
            System.out.println("Waiting for bank transfer...");
        } else {
            System.out.println("Wrong credentials!");
        }
		
	}

	@Override
	public boolean verify() {
		boolean condition = user.getEmail().length() > 0 && String.valueOf(user.getPhoneNumber()).length() == 9 && user.getName().length() > 0;
		return condition;
	}

}
