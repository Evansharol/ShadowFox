package xxx.yyy;

/**
 * Unit test for simple App.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
    
    

public class AppTest {

    private App app;  // Declare the App object

    @BeforeEach
    public void setUp() {
        app = new App();  // Initialize the App object before each test
    }

    @Test
    public void testDeposit() {
        app.deposit(100);  // Make a deposit
        assertEquals(100, app.getBalance());  // Assert the balance is correct
    }

    @Test
    public void testWithdraw() {
        app.deposit(100);  // Deposit some funds
        app.withdraw(50);  // Withdraw funds
        assertEquals(50, app.getBalance());  // Assert the balance is correct
    }

    @Test
    public void testTransactionHistory() {
        app.deposit(100);  // Deposit some funds
        app.withdraw(50);  // Withdraw funds
        assertEquals(2, app.getTransactionHistory().size());  // Assert transaction history contains 2 records
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        app.deposit(100);
        app.withdraw(150);  // Try to withdraw more than balance
        assertEquals(100, app.getBalance());  // Balance should remain the same
        assertEquals(2, app.getTransactionHistory().size());  // Ensure history contains 2 records (deposit and failed withdrawal)
    }

    // Add more tests here...
}
