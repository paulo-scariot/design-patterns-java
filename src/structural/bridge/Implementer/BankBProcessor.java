package structural.bridge.Implementer;

public class BankBProcessor implements PaymentProcessor {
    @Override
    public void processPayment(String amount) {
        System.out.println("Processing payment of $" + amount + " through Bank B.");
    }
}
