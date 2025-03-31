package behavioral.command;

public class ProcessPaymentCommand implements Command {
    private String orderId;

    public ProcessPaymentCommand(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        System.out.println("Processing payment for order: " + orderId);
    }

    @Override
    public void undo() {
        System.out.println("Refunding payment for order: " + orderId);
    }
}
