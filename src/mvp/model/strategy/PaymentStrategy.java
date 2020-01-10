package mvp.model.strategy;

import mvp.model.User;

public interface PaymentStrategy {
    public Boolean pay(Double payAmmount);
    public void getPaymentData(User user);
    public boolean verify();
}
