import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private List<Account> accounts;
    private Account currentAccount;
    private Scanner scanner;

    // Constructor
    public ATM() {
        this.accounts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Method to add an account to the ATM
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to start the ATM application
    public void start() {
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter user PIN: ");
        int userPin = scanner.nextInt();

        // Check if the user ID and PIN are correct and set the currentAccount
        boolean validUser = false;
        for (Account account : accounts) {
            if (account.getUserId() == userId && account.getUserPin() == userPin) {
                validUser = true;
                currentAccount = account;
                break;
            }
        }

        if (validUser) {
            showMenu();
        } else {
            System.out.println("Invalid user ID or PIN. Exiting...");
        }
    }

    // Method to display the main menu
    private void showMenu() {
        boolean quit = false;

        while (!quit) {
            System.out.println("\nMain Menu");
            System.out.println("1. View Balance");
            System.out.println("2. View Transactions History");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: " + currentAccount.getBalance());
                    break;
                case 2:
                    displayTransactionHistory();
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    currentAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. Your new balance is: " + currentAccount.getBalance());
                    break;
                case 4:
                    System.out.print("Enter the amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    currentAccount.withdraw(withdrawAmount);
                    System.out.println("Withdrawal successful. Your new balance is: " + currentAccount.getBalance());
                    break;
                case 5:
                    System.out.print("Enter the account number to transfer: ");
                    int targetAccountNumber = scanner.nextInt();
                    Account targetAccount = findAccount(targetAccountNumber);
                    if (targetAccount != null) {
                        System.out.print("Enter the amount to transfer: ");
                        int transferAmount = scanner.nextInt();
                        currentAccount.transfer(transferAmount, targetAccount);
                        System.out.println("Transfer successful. Your new balance is: " + currentAccount.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Thank you for using the ATM!");
    }

    // Method to find an account based on account number
    private Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // Method to display transaction history
    private void displayTransactionHistory() {
        List<String> transactionHistory = currentAccount.getTransactionHistory();
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
