package mvp.model.strategy;

public interface PaymentStrategy {

    Boolean pay(Double payAmmount);
    void getPaymentData();
    boolean verify();
	
}
