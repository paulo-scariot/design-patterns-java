package behavioral.command;

public class ValidateOrderCommand implements Command {
    private String orderId;

    public ValidateOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        System.out.println("Validating order: " + orderId);
    }

    @Override
    public void undo() {
        System.out.println("Reverting order validation: " + orderId);
    }
}