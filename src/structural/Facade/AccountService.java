package structural.Facade;

public class AccountService {
    public boolean isValidAccount(String accountNumber) {
        System.out.println("Validating account: " + accountNumber);
        return true;
    }
}
