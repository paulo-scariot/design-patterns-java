package behavioral.command;

public class ShipOrderCommand implements Command {
    private String orderId;

    public ShipOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        System.out.println("Shipping order: " + orderId);
    }

    @Override
    public void undo() {
        System.out.println("Canceling shipment of order: " + orderId);
    }
}