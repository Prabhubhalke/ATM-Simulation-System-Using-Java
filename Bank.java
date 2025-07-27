import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Bank class representing a banking system
 * Manages multiple accounts and provides authentication
 * 
 * @author Prabhu Bhalke
 * @version 1.0
 */
public class Bank {
    private Map<String, Account> accounts;
    private Map<String, BankOfficial> officials;
    private String bankName;
    
    /**
     * Constructor to create a new bank
     */
    public Bank() {
        this.accounts = new HashMap<>();
        this.officials = new HashMap<>();
        this.bankName = "ATM Simulation Bank";
    }
    
    /**
     * Constructor to create a new bank with custom name
     * 
     * @param bankName The name of the bank
     */
    public Bank(String bankName) {
        this.accounts = new HashMap<>();
        this.officials = new HashMap<>();
        this.bankName = bankName;
    }
    
    /**
     * Get the bank name
     * 
     * @return The bank name
     */
    public String getBankName() {
        return bankName;
    }
    
    /**
     * Add a new account to the bank
     * 
     * @param account The account to add
     * @return true if successful, false if account already exists
     */
    public boolean addAccount(Account account) {
        if (account != null && !accounts.containsKey(account.getAccountNumber())) {
            accounts.put(account.getAccountNumber(), account);
            return true;
        }
        return false;
    }
    
    /**
     * Remove an account from the bank
     * 
     * @param accountNumber The account number to remove
     * @return true if successful, false if account doesn't exist
     */
    public boolean removeAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            return true;
        }
        return false;
    }
    
    /**
     * Get an account by account number
     * 
     * @param accountNumber The account number
     * @return The account if found, null otherwise
     */
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
    
    /**
     * Check if an account exists
     * 
     * @param accountNumber The account number to check
     * @return true if account exists, false otherwise
     */
    public boolean accountExists(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }
    
    /**
     * Authenticate a user with account number and PIN
     * 
     * @param accountNumber The account number
     * @param pin The PIN
     * @return true if authentication successful, false otherwise
     */
    public boolean authenticate(String accountNumber, String pin) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.getPin().equals(pin);
        }
        return false;
    }
    
    /**
     * Get all accounts in the bank
     * 
     * @return List of all accounts
     */
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }
    
    /**
     * Get total number of accounts
     * 
     * @return The total number of accounts
     */
    public int getTotalAccounts() {
        return accounts.size();
    }
    
    /**
     * Get total balance of all accounts
     * 
     * @return The total balance
     */
    public double getTotalBalance() {
        double total = 0.0;
        for (Account account : accounts.values()) {
            total += account.getBalance();
        }
        return total;
    }
    
    /**
     * Transfer money between accounts
     * 
     * @param fromAccountNumber The source account number
     * @param toAccountNumber The destination account number
     * @param amount The amount to transfer
     * @return true if successful, false otherwise
     */
    public boolean transferMoney(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);
        
        if (fromAccount != null && toAccount != null && fromAccount.hasSufficientFunds(amount)) {
            return fromAccount.transfer(toAccount, amount);
        }
        return false;
    }
    
    /**
     * Get account statistics
     * 
     * @return String containing bank statistics
     */
    public String getBankStatistics() {
        StringBuilder stats = new StringBuilder();
        stats.append("Bank Statistics:\n");
        stats.append("Total Accounts: ").append(getTotalAccounts()).append("\n");
        stats.append("Total Balance: ₹").append(String.format("%.2f", getTotalBalance())).append("\n");
        stats.append("Average Balance: ₹").append(String.format("%.2f", getTotalBalance() / getTotalAccounts())).append("\n");
        return stats.toString();
    }
    
    /**
     * Search accounts by account holder name
     * 
     * @param name The name to search for
     * @return List of accounts matching the name
     */
    public List<Account> searchAccountsByName(String name) {
        List<Account> matchingAccounts = new ArrayList<>();
        String searchName = name.toLowerCase();
        
        for (Account account : accounts.values()) {
            if (account.getAccountHolder().toLowerCase().contains(searchName)) {
                matchingAccounts.add(account);
            }
        }
        
        return matchingAccounts;
    }
    
    /**
     * Get accounts with balance above a certain amount
     * 
     * @param minBalance The minimum balance threshold
     * @return List of accounts with balance above the threshold
     */
    public List<Account> getAccountsAboveBalance(double minBalance) {
        List<Account> highBalanceAccounts = new ArrayList<>();
        
        for (Account account : accounts.values()) {
            if (account.getBalance() >= minBalance) {
                highBalanceAccounts.add(account);
            }
        }
        
        return highBalanceAccounts;
    }
    
    /**
     * Get accounts with balance below a certain amount
     * 
     * @param maxBalance The maximum balance threshold
     * @return List of accounts with balance below the threshold
     */
    public List<Account> getAccountsBelowBalance(double maxBalance) {
        List<Account> lowBalanceAccounts = new ArrayList<>();
        
        for (Account account : accounts.values()) {
            if (account.getBalance() <= maxBalance) {
                lowBalanceAccounts.add(account);
            }
        }
        
        return lowBalanceAccounts;
    }
    
    // Bank Official Management Methods
    
    /**
     * Add a new bank official
     * 
     * @param official The official to add
     * @return true if successful, false if official already exists
     */
    public boolean addOfficial(BankOfficial official) {
        if (official != null && !officials.containsKey(official.getOfficialId())) {
            officials.put(official.getOfficialId(), official);
            return true;
        }
        return false;
    }
    
    /**
     * Remove a bank official
     * 
     * @param officialId The official ID to remove
     * @return true if successful, false if official doesn't exist
     */
    public boolean removeOfficial(String officialId) {
        if (officials.containsKey(officialId)) {
            officials.remove(officialId);
            return true;
        }
        return false;
    }
    
    /**
     * Get a bank official by ID
     * 
     * @param officialId The official ID
     * @return The official if found, null otherwise
     */
    public BankOfficial getOfficial(String officialId) {
        return officials.get(officialId);
    }
    
    /**
     * Check if an official exists
     * 
     * @param officialId The official ID to check
     * @return true if official exists, false otherwise
     */
    public boolean officialExists(String officialId) {
        return officials.containsKey(officialId);
    }
    
    /**
     * Authenticate a bank official
     * 
     * @param officialId The official ID
     * @param password The password
     * @return true if authentication successful, false otherwise
     */
    public boolean authenticateOfficial(String officialId, String password) {
        BankOfficial official = officials.get(officialId);
        if (official != null) {
            return official.authenticate(password);
        }
        return false;
    }
    
    /**
     * Get all bank officials
     * 
     * @return List of all officials
     */
    public List<BankOfficial> getAllOfficials() {
        return new ArrayList<>(officials.values());
    }
    
    /**
     * Get total number of officials
     * 
     * @return The total number of officials
     */
    public int getTotalOfficials() {
        return officials.size();
    }
    
    @Override
    public String toString() {
        return bankName + " - " + getTotalAccounts() + " accounts, " + getTotalOfficials() + " officials";
    }
} 