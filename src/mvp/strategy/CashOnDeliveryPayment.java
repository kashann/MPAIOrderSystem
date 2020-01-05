package mvp.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CashOnDeliveryPayment implements PaymentStrategy {
	
    private String email;
    private String password;
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public Boolean pay(Double payAmmount) {
		System.out.println("Paying " + String.valueOf(payAmmount) + " with CASH ON DELIVERY METHOD");
		return true;
	}

	@Override
	public void getPaymentData() {
        try {
    		System.out.print("Enter the user's email: ");
			email = READER.readLine();
	        System.out.print("Enter the password: ");
	        password = READER.readLine();

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
	        return email.length() > 0 && password.length() > 0;
	 }

}
