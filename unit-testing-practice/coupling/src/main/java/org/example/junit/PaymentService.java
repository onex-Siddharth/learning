package org.example.junit;

public class PaymentService {
    private final BankAccount account;
    private final TransactionLogger logger;

    public PaymentService(BankAccount account, TransactionLogger logger) {
        this.account = account;
        this.logger = logger;
    }

    public boolean makePayment(double amount, String recipient) {
        try {
            account.withdraw(amount);
            logger.logTransaction("Payment of " + amount + " to " + recipient);
            return true;
        } catch (IllegalArgumentException e) {
            logger.logError("Payment failed: " + e.getMessage());
            return false;
        }
    }

    public void receivePayment(double amount, String sender) {
        account.deposit(amount);
        logger.logTransaction("Received " + amount + " from " + sender);
    }

    public double getAccountBalance() {
        return account.getBalance();
    }
}
