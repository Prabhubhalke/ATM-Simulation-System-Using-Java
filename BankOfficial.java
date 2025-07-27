/**
 * BankOfficial class representing a bank official
 * Manages official details, authentication, and role-based access
 * 
 * @author Prabhu Bhalke
 * @version 2.0
 */
public class BankOfficial {
    private String officialId;
    private String password;
    private String role;
    private String name;
    private boolean isActive;
    
    /**
     * Constructor to create a new bank official
     * 
     * @param officialId The official ID
     * @param password The password for authentication
     * @param role The role of the official
     * @param name The name of the official
     */
    public BankOfficial(String officialId, String password, String role, String name) {
        this.officialId = officialId;
        this.password = password;
        this.role = role;
        this.name = name;
        this.isActive = true;
    }
    
    /**
     * Get the official ID
     * 
     * @return The official ID
     */
    public String getOfficialId() {
        return officialId;
    }
    
    /**
     * Get the password
     * 
     * @return The password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Set the password
     * 
     * @param password The new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Get the role
     * 
     * @return The role
     */
    public String getRole() {
        return role;
    }
    
    /**
     * Set the role
     * 
     * @param role The new role
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    /**
     * Get the name
     * 
     * @return The name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the name
     * 
     * @param name The new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Check if the official is active
     * 
     * @return true if active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }
    
    /**
     * Set the active status
     * 
     * @param active The active status
     */
    public void setActive(boolean active) {
        this.isActive = active;
    }
    
    /**
     * Authenticate the official
     * 
     * @param password The password to check
     * @return true if authentication successful, false otherwise
     */
    public boolean authenticate(String password) {
        return this.password.equals(password) && isActive;
    }
    
    /**
     * Check if the official has manager privileges
     * 
     * @return true if manager, false otherwise
     */
    public boolean isManager() {
        return "Manager".equalsIgnoreCase(role);
    }
    
    /**
     * Check if the official has supervisor privileges
     * 
     * @return true if supervisor, false otherwise
     */
    public boolean isSupervisor() {
        return "Supervisor".equalsIgnoreCase(role);
    }
    
    /**
     * Check if the official has staff privileges
     * 
     * @return true if staff, false otherwise
     */
    public boolean isStaff() {
        return "Staff".equalsIgnoreCase(role);
    }
    
    /**
     * Get official summary
     * 
     * @return String representation of official summary
     */
    public String getOfficialSummary() {
        return String.format("ID: %s | Name: %s | Role: %s | Status: %s", 
                           officialId, name, role, isActive ? "Active" : "Inactive");
    }
    
    @Override
    public String toString() {
        return getOfficialSummary();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankOfficial that = (BankOfficial) obj;
        return officialId.equals(that.officialId);
    }
    
    @Override
    public int hashCode() {
        return officialId.hashCode();
    }
} 