package mvp.strategy;

public interface PaymentStrategy {

    Boolean pay(Double payAmmount);
    void getPaymentData();
    boolean verify();
	
}
