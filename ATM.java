import java.util.Scanner;

/**
 * Enhanced ATM Simulation System with Dual Login
 * Supports both customer and bank official operations
 * 
 * @author Prabhu Bhalke
 * @version 2.0
 */
public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();
    private static Account currentAccount = null;
    private static BankOfficial currentOfficial = null;
    private static boolean isOfficialMode = false;
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                ENHANCED ATM SIMULATION SYSTEM              ║");
        System.out.println("║                    Official Banking System                 ║");
        System.out.println("║                        Welcome!                             ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        
        // Initialize with sample data
        initializeSampleData();
        
        while (true) {
            if (currentAccount == null && currentOfficial == null) {
                showMainLoginMenu();
            } else if (isOfficialMode) {
                showOfficialMenu();
            } else {
                showCustomerMenu();
            }
        }
    }
    
    /**
     * Initialize sample accounts and bank officials
     */
    private static void initializeSampleData() {
        // Initialize sample accounts
        bank.addAccount(new Account("123456789", "1234", "Prabhu Bhalke", 5000.0));
        bank.addAccount(new Account("987654321", "5678", "John Doe", 2500.0));
        bank.addAccount(new Account("456789123", "9012", "Jane Smith", 7500.0));
        bank.addAccount(new Account("111222333", "1111", "Alice Johnson", 10000.0));
        bank.addAccount(new Account("444555666", "2222", "Bob Wilson", 3500.0));
        
        // Initialize bank officials
        bank.addOfficial(new BankOfficial("OFF001", "admin123", "Manager", "John Manager"));
        bank.addOfficial(new BankOfficial("OFF002", "staff456", "Staff", "Sarah Staff"));
        bank.addOfficial(new BankOfficial("OFF003", "super789", "Supervisor", "Mike Supervisor"));
        
        System.out.println("✓ Sample accounts and officials initialized successfully!");
        System.out.println();
    }
    
    /**
     * Display main login menu with options for customer and official
     */
    private static void showMainLoginMenu() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                      MAIN LOGIN MENU                        │");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Customer Login                                            │");
        System.out.println("│ 2. Bank Official Login                                       │");
        System.out.println("│ 3. Exit                                                      │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.print("Enter your choice (1-3): ");
        
        String choice = scanner.nextLine();
        System.out.println();
        
        switch (choice) {
            case "1":
                showCustomerLoginMenu();
                break;
            case "2":
                showOfficialLoginMenu();
                break;
            case "3":
                exit();
                break;
            default:
                System.out.println("✗ Invalid choice. Please enter 1, 2, or 3.");
                System.out.println();
        }
    }
    
    /**
     * Display customer login menu
     */
    private static void showCustomerLoginMenu() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                      CUSTOMER LOGIN                         │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        
        if (bank.authenticate(accountNumber, pin)) {
            currentAccount = bank.getAccount(accountNumber);
            isOfficialMode = false;
            System.out.println("✓ Login successful! Welcome, " + currentAccount.getAccountHolder() + "!");
            System.out.println();
        } else {
            System.out.println("✗ Invalid account number or PIN. Please try again.");
            System.out.println();
        }
    }
    
    /**
     * Display bank official login menu
     */
    private static void showOfficialLoginMenu() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                    BANK OFFICIAL LOGIN                      │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.print("Enter Official ID: ");
        String officialId = scanner.nextLine();
        
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        if (bank.authenticateOfficial(officialId, password)) {
            currentOfficial = bank.getOfficial(officialId);
            isOfficialMode = true;
            System.out.println("✓ Login successful! Welcome, " + currentOfficial.getName() + " (" + currentOfficial.getRole() + ")!");
            System.out.println();
        } else {
            System.out.println("✗ Invalid official ID or password. Please try again.");
            System.out.println();
        }
    }
    
    /**
     * Display customer menu
     */
    private static void showCustomerMenu() {
        while (true) {
            System.out.println("┌──────────────────────────────────────────────────────────────┐");
            System.out.println("│                      CUSTOMER MENU                         │");
            System.out.println("├──────────────────────────────────────────────────────────────┤");
            System.out.println("│ 1. Check Balance                                             │");
            System.out.println("│ 2. Withdraw Money                                            │");
            System.out.println("│ 3. Deposit Money                                             │");
            System.out.println("│ 4. Transfer Money                                            │");
            System.out.println("│ 5. View Transaction History                                  │");
            System.out.println("│ 6. Change PIN                                                │");
            System.out.println("│ 7. Request Account Statement                                 │");
            System.out.println("│ 8. Logout                                                    │");
            System.out.println("│ 9. Exit                                                      │");
            System.out.println("└──────────────────────────────────────────────────────────────┘");
            System.out.print("Enter your choice (1-9): ");
            
            String choice = scanner.nextLine();
            System.out.println();
            
            switch (choice) {
                case "1":
                    checkBalance();
                    break;
                case "2":
                    withdrawMoney();
                    break;
                case "3":
                    depositMoney();
                    break;
                case "4":
                    transferMoney();
                    break;
                case "5":
                    viewTransactionHistory();
                    break;
                case "6":
                    changePIN();
                    break;
                case "7":
                    requestAccountStatement();
                    break;
                case "8":
                    logout();
                    return;
                case "9":
                    exit();
                    return;
                default:
                    System.out.println("✗ Invalid choice. Please enter a number between 1-9.");
                    System.out.println();
            }
        }
    }
    
    /**
     * Display bank official menu
     */
    private static void showOfficialMenu() {
        while (true) {
            System.out.println("┌──────────────────────────────────────────────────────────────┐");
            System.out.println("│                    BANK OFFICIAL MENU                      │");
            System.out.println("├──────────────────────────────────────────────────────────────┤");
            System.out.println("│ 1. Create New Account                                        │");
            System.out.println("│ 2. View All Accounts                                         │");
            System.out.println("│ 3. Search Account                                            │");
            System.out.println("│ 4. Block/Unblock Account                                     │");
            System.out.println("│ 5. View Bank Statistics                                      │");
            System.out.println("│ 6. Process Account Requests                                  │");
            System.out.println("│ 7. View Transaction Logs                                     │");
            System.out.println("│ 8. Manage Bank Officials                                     │");
            System.out.println("│ 9. Logout                                                    │");
            System.out.println("│ 10. Exit                                                     │");
            System.out.println("└──────────────────────────────────────────────────────────────┘");
            System.out.print("Enter your choice (1-10): ");
            
            String choice = scanner.nextLine();
            System.out.println();
            
            switch (choice) {
                case "1":
                    createNewAccount();
                    break;
                case "2":
                    viewAllAccounts();
                    break;
                case "3":
                    searchAccount();
                    break;
                case "4":
                    manageAccountStatus();
                    break;
                case "5":
                    viewBankStatistics();
                    break;
                case "6":
                    processAccountRequests();
                    break;
                case "7":
                    viewTransactionLogs();
                    break;
                case "8":
                    manageOfficials();
                    break;
                case "9":
                    logout();
                    return;
                case "10":
                    exit();
                    return;
                default:
                    System.out.println("✗ Invalid choice. Please enter a number between 1-10.");
                    System.out.println();
            }
        }
    }
    
    // Customer Operations
    private static void checkBalance() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                        BALANCE INQUIRY                      │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println("Account Holder: " + currentAccount.getAccountHolder());
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Current Balance: ₹" + String.format("%.2f", currentAccount.getBalance()));
        System.out.println();
        
        currentAccount.addTransaction("Balance Inquiry", 0.0, currentAccount.getBalance());
    }
    
    private static void withdrawMoney() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                         WITHDRAWAL                          │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.println("Available denominations: ₹100, ₹200, ₹500, ₹1000, ₹2000");
        System.out.print("Enter amount to withdraw: ₹");
        
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            
            if (amount <= 0) {
                System.out.println("✗ Amount must be greater than zero.");
                System.out.println();
                return;
            }
            
            if (amount > currentAccount.getBalance()) {
                System.out.println("✗ Insufficient funds. Your balance is ₹" + 
                                 String.format("%.2f", currentAccount.getBalance()));
                System.out.println();
                return;
            }
            
            if (amount > 50000) {
                System.out.println("✗ Maximum withdrawal limit is ₹50,000 per transaction.");
                System.out.println();
                return;
            }
            
            if (amount > 10000) {
                System.out.print("Enter PIN for verification: ");
                String pin = scanner.nextLine();
                if (!currentAccount.getPin().equals(pin)) {
                    System.out.println("✗ Invalid PIN. Transaction cancelled.");
                    System.out.println();
                    return;
                }
            }
            
            currentAccount.withdraw(amount);
            
            System.out.println("✓ Withdrawal successful!");
            System.out.println("Amount withdrawn: ₹" + String.format("%.2f", amount));
            System.out.println("New balance: ₹" + String.format("%.2f", currentAccount.getBalance()));
            System.out.println();
            
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid amount format. Please enter a valid number.");
            System.out.println();
        }
    }
    
    private static void depositMoney() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                          DEPOSIT                            │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.print("Enter amount to deposit: ₹");
        
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            
            if (amount <= 0) {
                System.out.println("✗ Amount must be greater than zero.");
                System.out.println();
                return;
            }
            
            if (amount > 100000) {
                System.out.println("✗ Maximum deposit limit is ₹1,00,000 per transaction.");
                System.out.println();
                return;
            }
            
            currentAccount.deposit(amount);
            
            System.out.println("✓ Deposit successful!");
            System.out.println("Amount deposited: ₹" + String.format("%.2f", amount));
            System.out.println("New balance: ₹" + String.format("%.2f", currentAccount.getBalance()));
            System.out.println();
            
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid amount format. Please enter a valid number.");
            System.out.println();
        }
    }
    
    private static void transferMoney() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                         MONEY TRANSFER                      │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.print("Enter recipient account number: ");
        String recipientAccountNumber = scanner.nextLine();
        
        Account recipientAccount = bank.getAccount(recipientAccountNumber);
        if (recipientAccount == null) {
            System.out.println("✗ Recipient account not found.");
            System.out.println();
            return;
        }
        
        if (recipientAccountNumber.equals(currentAccount.getAccountNumber())) {
            System.out.println("✗ Cannot transfer to your own account.");
            System.out.println();
            return;
        }
        
        System.out.print("Enter amount to transfer: ₹");
        
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            
            if (amount <= 0) {
                System.out.println("✗ Amount must be greater than zero.");
                System.out.println();
                return;
            }
            
            if (amount > currentAccount.getBalance()) {
                System.out.println("✗ Insufficient funds. Your balance is ₹" + 
                                 String.format("%.2f", currentAccount.getBalance()));
                System.out.println();
                return;
            }
            
            if (amount > 25000) {
                System.out.println("✗ Maximum transfer limit is ₹25,000 per transaction.");
                System.out.println();
                return;
            }
            
            System.out.print("Enter PIN for verification: ");
            String pin = scanner.nextLine();
            if (!currentAccount.getPin().equals(pin)) {
                System.out.println("✗ Invalid PIN. Transaction cancelled.");
                System.out.println();
                return;
            }
            
            currentAccount.withdraw(amount);
            recipientAccount.deposit(amount);
            
            System.out.println("✓ Transfer successful!");
            System.out.println("Amount transferred: ₹" + String.format("%.2f", amount));
            System.out.println("Recipient: " + recipientAccount.getAccountHolder());
            System.out.println("Your new balance: ₹" + String.format("%.2f", currentAccount.getBalance()));
            System.out.println();
            
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid amount format. Please enter a valid number.");
            System.out.println();
        }
    }
    
    private static void viewTransactionHistory() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                    TRANSACTION HISTORY                      │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.println("Account: " + currentAccount.getAccountNumber());
        System.out.println("Holder: " + currentAccount.getAccountHolder());
        System.out.println();
        
        if (currentAccount.getTransactions().isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.printf("%-20s %-15s %-15s %-15s%n", "Date & Time", "Type", "Amount", "Balance");
            System.out.println("─────────────────────────────────────────────────────────────────");
            
            for (Transaction transaction : currentAccount.getTransactions()) {
                System.out.printf("%-20s %-15s %-15s %-15s%n",
                    transaction.getDateTime(),
                    transaction.getType(),
                    "₹" + String.format("%.2f", transaction.getAmount()),
                    "₹" + String.format("%.2f", transaction.getBalance()));
            }
        }
        System.out.println();
    }
    
    private static void changePIN() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                          CHANGE PIN                          │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.print("Enter current PIN: ");
        String currentPin = scanner.nextLine();
        
        if (!currentAccount.getPin().equals(currentPin)) {
            System.out.println("✗ Current PIN is incorrect.");
            System.out.println();
            return;
        }
        
        System.out.print("Enter new PIN (4 digits): ");
        String newPin = scanner.nextLine();
        
        if (newPin.length() != 4 || !newPin.matches("\\d+")) {
            System.out.println("✗ PIN must be exactly 4 digits.");
            System.out.println();
            return;
        }
        
        System.out.print("Confirm new PIN: ");
        String confirmPin = scanner.nextLine();
        
        if (!newPin.equals(confirmPin)) {
            System.out.println("✗ PINs do not match.");
            System.out.println();
            return;
        }
        
        currentAccount.setPin(newPin);
        System.out.println("✓ PIN changed successfully!");
        System.out.println();
    }
    
    private static void requestAccountStatement() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                    ACCOUNT STATEMENT                        │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.println("Account Statement for: " + currentAccount.getAccountHolder());
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Current Balance: ₹" + String.format("%.2f", currentAccount.getBalance()));
        System.out.println("Statement Date: " + java.time.LocalDate.now());
        System.out.println();
        
        System.out.println("Recent Transactions:");
        System.out.println("────────────────────");
        
        if (currentAccount.getTransactions().isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : currentAccount.getTransactions()) {
                System.out.println(transaction.getTransactionSummary());
            }
        }
        System.out.println();
        
        currentAccount.addTransaction("Statement Requested", 0.0, currentAccount.getBalance());
    }
    
    // Bank Official Operations
    private static void createNewAccount() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                      CREATE NEW ACCOUNT                     │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        if (bank.accountExists(accountNumber)) {
            System.out.println("✗ Account number already exists.");
            System.out.println();
            return;
        }
        
        System.out.print("Enter Account Holder Name: ");
        String accountHolder = scanner.nextLine();
        
        System.out.print("Enter Initial PIN (4 digits): ");
        String pin = scanner.nextLine();
        
        if (pin.length() != 4 || !pin.matches("\\d+")) {
            System.out.println("✗ PIN must be exactly 4 digits.");
            System.out.println();
            return;
        }
        
        System.out.print("Enter Initial Balance: ₹");
        try {
            double initialBalance = Double.parseDouble(scanner.nextLine());
            
            if (initialBalance < 0) {
                System.out.println("✗ Initial balance cannot be negative.");
                System.out.println();
                return;
            }
            
            Account newAccount = new Account(accountNumber, pin, accountHolder, initialBalance);
            bank.addAccount(newAccount);
            
            System.out.println("✓ Account created successfully!");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Initial Balance: ₹" + String.format("%.2f", initialBalance));
            System.out.println();
            
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid balance format. Please enter a valid number.");
            System.out.println();
        }
    }
    
    private static void viewAllAccounts() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                        ALL ACCOUNTS                          │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.printf("%-15s %-20s %-15s %-10s%n", "Account No.", "Account Holder", "Balance", "Status");
        System.out.println("─────────────────────────────────────────────────────────────────");
        
        for (Account account : bank.getAllAccounts()) {
            System.out.printf("%-15s %-20s %-15s %-10s%n",
                account.getAccountNumber(),
                account.getAccountHolder(),
                "₹" + String.format("%.2f", account.getBalance()),
                account.isActive() ? "Active" : "Blocked");
        }
        System.out.println();
    }
    
    private static void searchAccount() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                       SEARCH ACCOUNT                         │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.println("Search by:");
        System.out.println("1. Account Number");
        System.out.println("2. Account Holder Name");
        System.out.print("Enter choice (1-2): ");
        
        String choice = scanner.nextLine();
        System.out.println();
        
        switch (choice) {
            case "1":
                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();
                Account account = bank.getAccount(accountNumber);
                if (account != null) {
                    displayAccountDetails(account);
                } else {
                    System.out.println("✗ Account not found.");
                }
                break;
            case "2":
                System.out.print("Enter Account Holder Name: ");
                String name = scanner.nextLine();
                var accounts = bank.searchAccountsByName(name);
                if (!accounts.isEmpty()) {
                    System.out.println("Found " + accounts.size() + " account(s):");
                    for (Account acc : accounts) {
                        displayAccountDetails(acc);
                    }
                } else {
                    System.out.println("✗ No accounts found with that name.");
                }
                break;
            default:
                System.out.println("✗ Invalid choice.");
        }
        System.out.println();
    }
    
    private static void displayAccountDetails(Account account) {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                      ACCOUNT DETAILS                         │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Current Balance: ₹" + String.format("%.2f", account.getBalance()));
        System.out.println("Status: " + (account.isActive() ? "Active" : "Blocked"));
        System.out.println("Total Transactions: " + account.getTransactions().size());
        System.out.println();
    }
    
    private static void manageAccountStatus() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                    MANAGE ACCOUNT STATUS                    │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        Account account = bank.getAccount(accountNumber);
        if (account == null) {
            System.out.println("✗ Account not found.");
            System.out.println();
            return;
        }
        
        System.out.println("Current Status: " + (account.isActive() ? "Active" : "Blocked"));
        System.out.println("1. Block Account");
        System.out.println("2. Unblock Account");
        System.out.print("Enter choice (1-2): ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                account.setActive(false);
                System.out.println("✓ Account blocked successfully.");
                break;
            case "2":
                account.setActive(true);
                System.out.println("✓ Account unblocked successfully.");
                break;
            default:
                System.out.println("✗ Invalid choice.");
        }
        System.out.println();
    }
    
    private static void viewBankStatistics() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                     BANK STATISTICS                          │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.println(bank.getBankStatistics());
        
        System.out.println("Account Distribution:");
        System.out.println("High Balance Accounts (>₹10,000): " + bank.getAccountsAboveBalance(10000).size());
        System.out.println("Low Balance Accounts (<₹1,000): " + bank.getAccountsBelowBalance(1000).size());
        System.out.println();
    }
    
    private static void processAccountRequests() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                   PROCESS ACCOUNT REQUESTS                  │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.println("No pending requests at this time.");
        System.out.println("This feature would handle account opening requests,");
        System.out.println("loan applications, and other customer requests.");
        System.out.println();
    }
    
    private static void viewTransactionLogs() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                    TRANSACTION LOGS                         │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.println("Recent Bank Transactions:");
        System.out.println("─────────────────────────");
        
        // Get all transactions from all accounts
        for (Account account : bank.getAllAccounts()) {
            if (!account.getTransactions().isEmpty()) {
                System.out.println("Account: " + account.getAccountNumber() + " (" + account.getAccountHolder() + ")");
                for (Transaction transaction : account.getTransactions()) {
                    System.out.println("  " + transaction.getTransactionSummary());
                }
                System.out.println();
            }
        }
    }
    
    private static void manageOfficials() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                   MANAGE BANK OFFICIALS                     │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.println("Current Officials:");
        System.out.printf("%-10s %-15s %-15s%n", "ID", "Name", "Role");
        System.out.println("─────────────────────────────────────────");
        
        for (BankOfficial official : bank.getAllOfficials()) {
            System.out.printf("%-10s %-15s %-15s%n", 
                official.getOfficialId(), 
                official.getName(), 
                official.getRole());
        }
        System.out.println();
        
        System.out.println("1. Add New Official");
        System.out.println("2. Remove Official");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter choice (1-3): ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                addNewOfficial();
                break;
            case "2":
                removeOfficial();
                break;
            case "3":
                break;
            default:
                System.out.println("✗ Invalid choice.");
        }
        System.out.println();
    }
    
    private static void addNewOfficial() {
        System.out.print("Enter Official ID: ");
        String officialId = scanner.nextLine();
        
        if (bank.getOfficial(officialId) != null) {
            System.out.println("✗ Official ID already exists.");
            return;
        }
        
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter Role (Manager/Staff/Supervisor): ");
        String role = scanner.nextLine();
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        BankOfficial newOfficial = new BankOfficial(officialId, password, role, name);
        bank.addOfficial(newOfficial);
        
        System.out.println("✓ Official added successfully!");
    }
    
    private static void removeOfficial() {
        System.out.print("Enter Official ID to remove: ");
        String officialId = scanner.nextLine();
        
        if (bank.removeOfficial(officialId)) {
            System.out.println("✓ Official removed successfully!");
        } else {
            System.out.println("✗ Official not found.");
        }
    }
    
    private static void logout() {
        if (isOfficialMode) {
            System.out.println("✓ Logged out successfully. Thank you for using the banking system!");
        } else {
            System.out.println("✓ Logged out successfully. Thank you for using our ATM!");
        }
        System.out.println();
        currentAccount = null;
        currentOfficial = null;
        isOfficialMode = false;
    }
    
    private static void exit() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    Thank you for using                      ║");
        System.out.println("║                ENHANCED ATM SIMULATION SYSTEM              ║");
        System.out.println("║                         Goodbye!                            ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        scanner.close();
        System.exit(0);
    }
} 