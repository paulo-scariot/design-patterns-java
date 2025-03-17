package structural.bridge.Implementer;

public class BankAProcessor implements PaymentProcessor {
    @Override
    public void processPayment(String amount) {
        System.out.println("Processing payment of $" + amount + " through Bank A.");
    }
}