import java.util.ArrayList;
import java.util.List;

/**
 * Account class representing a bank account
 * Manages account details, balance, and transaction history
 * 
 * @author Prabhu Bhalke
 * @version 1.0
 */
public class Account {
    private String accountNumber;
    private String pin;
    private String accountHolder;
    private double balance;
    private List<Transaction> transactions;
    private boolean isActive;
    
    /**
     * Constructor to create a new account
     * 
     * @param accountNumber The account number
     * @param pin The PIN for the account
     * @param accountHolder The name of the account holder
     * @param initialBalance The initial balance
     */
    public Account(String accountNumber, String pin, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.isActive = true;
        
        // Add initial balance transaction
        addTransaction("Account Created", initialBalance, balance);
    }
    
    /**
     * Get the account number
     * 
     * @return The account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Get the PIN
     * 
     * @return The PIN
     */
    public String getPin() {
        return pin;
    }
    
    /**
     * Set the PIN
     * 
     * @param pin The new PIN
     */
    public void setPin(String pin) {
        this.pin = pin;
        addTransaction("PIN Changed", 0.0, balance);
    }
    
    /**
     * Get the account holder name
     * 
     * @return The account holder name
     */
    public String getAccountHolder() {
        return accountHolder;
    }
    
    /**
     * Get the current balance
     * 
     * @return The current balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Get the transaction history
     * 
     * @return List of transactions
     */
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
    
    /**
     * Deposit money into the account
     * 
     * @param amount The amount to deposit
     * @return true if successful, false otherwise
     */
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit", amount, balance);
            return true;
        }
        return false;
    }
    
    /**
     * Withdraw money from the account
     * 
     * @param amount The amount to withdraw
     * @return true if successful, false otherwise
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawal", -amount, balance);
            return true;
        }
        return false;
    }
    
    /**
     * Add a transaction to the history
     * 
     * @param type The type of transaction
     * @param amount The amount involved
     * @param balance The balance after transaction
     */
    public void addTransaction(String type, double amount, double balance) {
        transactions.add(new Transaction(type, amount, balance));
    }
    
    /**
     * Transfer money to another account
     * 
     * @param recipient The recipient account
     * @param amount The amount to transfer
     * @return true if successful, false otherwise
     */
    public boolean transfer(Account recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
            addTransaction("Transfer Out", -amount, balance);
            recipient.addTransaction("Transfer In", amount, recipient.getBalance());
            return true;
        }
        return false;
    }
    
    /**
     * Check if the account has sufficient funds
     * 
     * @param amount The amount to check
     * @return true if sufficient funds, false otherwise
     */
    public boolean hasSufficientFunds(double amount) {
        return balance >= amount;
    }
    
    /**
     * Check if the account is active
     * 
     * @return true if active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }
    
    /**
     * Set the active status of the account
     * 
     * @param active The active status
     */
    public void setActive(boolean active) {
        this.isActive = active;
    }
    
    /**
     * Get account summary
     * 
     * @return String representation of account summary
     */
    public String getAccountSummary() {
        return String.format("Account: %s | Holder: %s | Balance: ₹%.2f", 
                           accountNumber, accountHolder, balance);
    }
    
    @Override
    public String toString() {
        return getAccountSummary();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return accountNumber.equals(account.accountNumber);
    }
    
    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }
} 