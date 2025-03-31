package behavioral.mediator;

public interface User {
    void setMediator(ChatMediator chatMediator);
    void send(String message);
    void receive(String message);
}
