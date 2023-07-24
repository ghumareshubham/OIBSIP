import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private int balance;
    private int userId;
    private int userPin;
    private List<String> transactionHistory;

    // Constructor
    public Account(int accountNumber, int balance, int userId, int userPin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.userId = userId;
        this.userPin = userPin;
        this.transactionHistory = new ArrayList<>();
    }

    // Methods for deposit
    public void deposit(int amount) {
        balance += amount;
        addTransaction("Deposit: +" + amount);//it will concat and add this string to List
    }
 // Methods for  withdraw
    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            addTransaction("Withdraw: -" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
 // Methods for  transfer
    public void transfer(int amount, Account targetAccount) {
        if (balance >= amount) {
            balance -= amount;
            targetAccount.deposit(amount);
            addTransaction("Transfer: -" + amount + " to Account " + targetAccount.getAccountNumber());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Method to add transactions to the history
    private void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    // Getters and setters for account attributes
    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public int getUserId() {
        return userId;
    }

    public int getUserPin() {
        return userPin;
    }
}
