package structural.Facade;

public class BankingFacade {
    private AccountService accountService;
    private SecurityService securityService;
    private TransactionService transactionService;
    private NotificationService notificationService;

    public BankingFacade() {
        this.accountService = new AccountService();
        this.securityService = new SecurityService();
        this.transactionService = new TransactionService();
        this.notificationService = new NotificationService();
    }

    public void withdrawMoney(String accountNumber, String pin, double amount) {
        if (accountService.isValidAccount(accountNumber) && securityService.authenticate(accountNumber, pin)) {
            if (transactionService.withdraw(accountNumber, amount)) {
                notificationService.sendNotification("Withdrawal of $" + amount + " successful.");
            }
        } else {
            System.out.println("Transaction Failed: Invalid credentials or account.");
        }
    }

    public void transferMoney(String fromAccount, String toAccount, String pin, double amount) {
        if (accountService.isValidAccount(fromAccount) && accountService.isValidAccount(toAccount)
                && securityService.authenticate(fromAccount, pin)) {
            if (transactionService.transfer(fromAccount, toAccount, amount)) {
                notificationService.sendNotification("Transfer of $" + amount + " successful.");
            }
        } else {
            System.out.println("Transaction Failed: Invalid credentials or account.");
        }
    }
}
