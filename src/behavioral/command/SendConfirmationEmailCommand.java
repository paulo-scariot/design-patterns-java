package behavioral.command;

public class SendConfirmationEmailCommand implements Command {
    private String email;

    public SendConfirmationEmailCommand(String email) {
        this.email = email;
    }

    @Override
    public void execute() {
        System.out.println("Sending confirmation email to: " + email);
    }

    @Override
    public void undo() {
        System.out.println("Recalling confirmation email to: " + email);
    }
}
