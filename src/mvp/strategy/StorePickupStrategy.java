package mvp.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StorePickupStrategy implements PaymentStrategy {
	
	private String email;
	private String name;
	private String phoneNumber;
	private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public Boolean pay(Double payAmmount) {
		System.out.println("Paying " + String.valueOf(payAmmount) + " with STORE PICKUP METHOD");
		return true;
	}

	@Override
	public void getPaymentData() {
        try {
    		System.out.print("Enter your email: ");
			email = READER.readLine();
	        System.out.print("Enter your name ");
	        name = READER.readLine();
	        System.out.print("Enter the phone number: ");
            phoneNumber = READER.readLine();
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
		boolean condition = email.length() > 0 && name.length() > 0 && phoneNumber.length() > 0;
		return condition;
	}

}
