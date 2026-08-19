package src;

public abstract class Account {
    // Strict access modifiers for data security
    protected int accountNumber;
    protected String accountHolder;
    protected double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Abstract method to be implemented by child classes
    public abstract void displayAccountDetails();
}
