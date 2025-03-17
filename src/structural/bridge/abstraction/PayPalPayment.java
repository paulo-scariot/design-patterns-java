package structural.bridge.abstraction;

import structural.bridge.Implementer.PaymentProcessor;

public class PayPalPayment extends Payment {
    public PayPalPayment(PaymentProcessor processor) {
        super(processor);
    }

    @Override
    public void pay(String amount) {
        System.out.print("PayPal Payment: ");
        processor.processPayment(amount);
    }
}