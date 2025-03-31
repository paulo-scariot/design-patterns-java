package behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {
    private List<Command> commandList = new ArrayList<>();

    public OrderProcessor(Command... commands) {
        this.commandList = new ArrayList<>();
        for (Command command : commands) {
            this.commandList.add(command);
        }
    }

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void processOrder() {
        System.out.println("Processing order...");
        for (Command command : commandList) {
            command.execute();
        }
        System.out.println("Order processed successfully!");
    }

    public void cancelOrder() {
        System.out.println("Canceling order...");
        for (int i = commandList.size() - 1; i >= 0; i--) {
            commandList.get(i).undo();
        }
        System.out.println("Order cancellation completed.");
    }
}
