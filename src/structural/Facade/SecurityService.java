package structural.Facade;

public class SecurityService {
    public boolean authenticate(String accountNumber, String pin) {
        System.out.println("Authenticating account: " + accountNumber);
        return pin.equals("1234");
    }
}
