package structural.bridge.abstraction;

import structural.bridge.Implementer.PaymentProcessor;

public class CreditCardPayment extends Payment {
    public CreditCardPayment(PaymentProcessor processor) {
        super(processor);
    }

    @Override
    public void pay(String amount) {
        System.out.print("Credit Card Payment: ");
        processor.processPayment(amount);
    }
}
