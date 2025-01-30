package xxx.yyy;

/**
 * Hello world!
 *
 */
import java.util.ArrayList;
import java.util.List;

public class App {

    private double balance;
    private List<String> transactionHistory;  // The list that holds the transaction history

    // Constructor to initialize balance and transactionHistory
    public App() {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();  // Initialize the transactionHistory list
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            transactionHistory.add("Deposited: " + amount);  // Add deposit transaction to history
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            transactionHistory.add("Withdrew: " + amount);  // Add withdrawal transaction to history
        } else {
            transactionHistory.add("Failed withdrawal attempt: " + amount);  // Add failed withdrawal attempt to history
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
