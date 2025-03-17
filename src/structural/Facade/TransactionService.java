package structural.Facade;

public class TransactionService {
    public boolean withdraw(String accountNumber, double amount) {
        System.out.println("Withdrawing $" + amount + " from account: " + accountNumber);
        return true;
    }

    public boolean deposit(String accountNumber, double amount) {
        System.out.println("Depositing $" + amount + " to account: " + accountNumber);
        return true;
    }

    public boolean transfer(String fromAccount, String toAccount, double amount) {
        System.out.println("Transferring $" + amount + " from " + fromAccount + " to " + toAccount);
        return true;
    }
}
