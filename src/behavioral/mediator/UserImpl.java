package behavioral.mediator;

public class UserImpl implements User {
    protected ChatMediator mediator;
    protected String name;

    public UserImpl(String name) {
        this.name = name;
    }

    @Override
    public void setMediator(ChatMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received: " + message);
    }
}
