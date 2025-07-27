import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Transaction class representing a bank transaction
 * Records transaction details with timestamp
 * 
 * @author Prabhu Bhalke
 * @version 1.0
 */
public class Transaction {
    private String type;
    private double amount;
    private double balance;
    private LocalDateTime timestamp;
    private String transactionId;
    
    private static int transactionCounter = 1;
    
    /**
     * Constructor to create a new transaction
     * 
     * @param type The type of transaction
     * @param amount The amount involved
     * @param balance The balance after transaction
     */
    public Transaction(String type, double amount, double balance) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.timestamp = LocalDateTime.now();
        this.transactionId = generateTransactionId();
    }
    
    /**
     * Generate a unique transaction ID
     * 
     * @return The transaction ID
     */
    private String generateTransactionId() {
        String timestamp = this.timestamp.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TXN" + timestamp + String.format("%04d", transactionCounter++);
    }
    
    /**
     * Get the transaction type
     * 
     * @return The transaction type
     */
    public String getType() {
        return type;
    }
    
    /**
     * Get the transaction amount
     * 
     * @return The transaction amount
     */
    public double getAmount() {
        return amount;
    }
    
    /**
     * Get the balance after transaction
     * 
     * @return The balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Get the transaction timestamp
     * 
     * @return The timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    /**
     * Get the transaction ID
     * 
     * @return The transaction ID
     */
    public String getTransactionId() {
        return transactionId;
    }
    
    /**
     * Get formatted date and time string
     * 
     * @return Formatted date and time
     */
    public String getDateTime() {
        return timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
    
    /**
     * Get formatted date string
     * 
     * @return Formatted date
     */
    public String getDate() {
        return timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    /**
     * Get formatted time string
     * 
     * @return Formatted time
     */
    public String getTime() {
        return timestamp.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    
    /**
     * Check if transaction is a credit transaction
     * 
     * @return true if credit, false otherwise
     */
    public boolean isCredit() {
        return amount > 0;
    }
    
    /**
     * Check if transaction is a debit transaction
     * 
     * @return true if debit, false otherwise
     */
    public boolean isDebit() {
        return amount < 0;
    }
    
    /**
     * Get the absolute amount
     * 
     * @return The absolute amount
     */
    public double getAbsoluteAmount() {
        return Math.abs(amount);
    }
    
    /**
     * Get transaction summary
     * 
     * @return String representation of transaction summary
     */
    public String getTransactionSummary() {
        String amountStr = isCredit() ? "+₹" : "-₹";
        amountStr += String.format("%.2f", getAbsoluteAmount());
        
        return String.format("%s | %s | %s | Balance: ₹%.2f", 
                           getDateTime(), type, amountStr, balance);
    }
    
    /**
     * Get detailed transaction information
     * 
     * @return Detailed transaction information
     */
    public String getDetailedInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Transaction ID: ").append(transactionId).append("\n");
        info.append("Type: ").append(type).append("\n");
        info.append("Amount: ₹").append(String.format("%.2f", amount)).append("\n");
        info.append("Balance: ₹").append(String.format("%.2f", balance)).append("\n");
        info.append("Date: ").append(getDate()).append("\n");
        info.append("Time: ").append(getTime()).append("\n");
        return info.toString();
    }
    
    @Override
    public String toString() {
        return getTransactionSummary();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Transaction that = (Transaction) obj;
        return transactionId.equals(that.transactionId);
    }
    
    @Override
    public int hashCode() {
        return transactionId.hashCode();
    }
} 