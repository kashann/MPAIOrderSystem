package mvp.model.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreditCardPayment implements PaymentStrategy {
	
	String cardNumber;
	String expiringMonth;
	String cvv;
	private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public Boolean pay(Double payAmmount) {
		System.out.println("Paying " + String.valueOf(payAmmount) + " with CREDIT CARD METHOD");
		return true;
	}

	@Override
	public void getPaymentData() {
        try {
    		System.out.print("Enter credit card number: ");
			cardNumber = READER.readLine();
	        System.out.print("Enter the expire month ");
	        expiringMonth = READER.readLine();
	        System.out.print("Enter the CVV code: ");
            cvv = READER.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

        if (verify()) {
            System.out.println("Data verification has been successful.");
        } else {
            System.out.println("Wrong email or password!");
        }
		
	}

	@Override
	public boolean verify() {
        boolean condition = cardNumber != null && Long.valueOf(cardNumber) > 0 && cvv.length() > 0;
		return condition;
	}

	
}
