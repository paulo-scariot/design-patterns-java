package structural.bridge.abstraction;

import structural.bridge.Implementer.PaymentProcessor;

public abstract class Payment {
    protected PaymentProcessor processor;

    public Payment(PaymentProcessor processor) {
        this.processor = processor;
    }

    public abstract void pay(String amount);
}
