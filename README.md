# ATM-Simulation-System-Using-Java

A comprehensive Java-based ATM (Automated Teller Machine) simulation system with **dual login functionality** - supporting both customer and bank official operations. This project demonstrates advanced object-oriented programming principles and secure banking operations.

## ✨ Features

### 🔐 **Dual Authentication System**
- **Customer Login**: Account number + PIN authentication
- **Bank Official Login**: Official ID + Password authentication
- **Role-based Access Control**: Different privileges for different user types
- **Session Management**: Secure logout and session handling

### 💰 **Customer Features**
- **Balance Inquiry**: Check current account balance
- **Cash Withdrawal**: Withdraw money with denomination support (₹50,000 max)
- **Cash Deposit**: Deposit money with validation (₹1,00,000 max)
- **Money Transfer**: Transfer funds between accounts (₹25,000 max)
- **Transaction History**: View detailed transaction records with timestamps
- **PIN Management**: Secure PIN modification
- **Account Statement**: Request detailed account statements

### 🏛️ **Bank Official Features**
- **Account Management**: Create, view, and manage customer accounts
- **Account Search**: Search by account number or holder name
- **Account Status Control**: Block/unblock accounts
- **Bank Statistics**: View comprehensive bank-wide statistics
- **Transaction Monitoring**: Monitor all bank transactions
- **Official Management**: Add/remove bank officials
- **Request Processing**: Handle customer requests

### 🎯 **Security Features**
- **PIN Authentication**: 4-digit PIN verification
- **Transaction Limits**: Configurable withdrawal and transfer limits
- **Large Amount Verification**: Additional PIN verification for large transactions
- **Account Status Control**: Active/blocked account management
- **Input Validation**: Comprehensive input sanitization
- **Error Handling**: Secure error messages without data exposure

## 🛠️ Technical Implementation

### **Architecture Overview**
```
┌─────────────────────────────────────────────────────────────┐
│                    ATM Simulation System                    │
├─────────────────────────────────────────────────────────────┤
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────┐     │
│  │    ATM      │    │    Bank     │    │  Account    │     │
│  │  (Main UI)  │◄──►│ (Management)│◄──►│ (Individual)│     │
│  └─────────────┘    └─────────────┘    └─────────────┘     │
│         │                   │                   │           │
│         │                   │                   │           │
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────┐     │
│  │ Transaction │    │BankOfficial │    │   Account   │     │
│  │ (Records)   │    │ (Staff)     │    │  Status     │     │
│  └─────────────┘    └─────────────┘    └─────────────┘     │
└─────────────────────────────────────────────────────────────┘
```

### **Core Classes**
1. **`ATM.java`** - Main application with dual login interface
2. **`Bank.java`** - Central banking system management
3. **`Account.java`** - Individual account management
4. **`Transaction.java`** - Transaction recording and tracking
5. **`BankOfficial.java`** - Bank staff management and authentication

### **Design Patterns Used**
- **Object-Oriented Programming**: Proper encapsulation, inheritance, and polymorphism
- **Single Responsibility Principle**: Each class has a specific purpose
- **Data Validation**: Comprehensive input validation and error handling
- **Transaction Management**: Atomic operations for data integrity
- **Role-Based Access Control**: Different privileges for different user types

## 🚀 Getting Started

### **Prerequisites**
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, VS Code) or command line

### **Installation & Setup**

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/enhanced-atm-simulation.git
   cd enhanced-atm-simulation
   ```

2. **Compile the Project**
   ```bash
   javac *.java
   ```

3. **Run the Application**
   ```bash
   java ATM
   ```

## 📋 Usage Guide

### **Main Login Menu**
```
┌──────────────────────────────────────────────────────────────┐
│                      MAIN LOGIN MENU                        │
├──────────────────────────────────────────────────────────────┤
│ 1. Customer Login                                            │
│ 2. Bank Official Login                                       │
│ 3. Exit                                                      │
└──────────────────────────────────────────────────────────────┘
```

### **Sample Login Credentials**

#### **Customer Accounts**
| Account Number | PIN  | Account Holder | Initial Balance |
|----------------|------|----------------|-----------------|
| `123456789`    | 1234 | Prabhu Bhalke  | ₹5,000.00       |
| `987654321`    | 5678 | John Doe       | ₹2,500.00       |
| `456789123`    | 9012 | Jane Smith     | ₹7,500.00       |
| `111222333`    | 1111 | Alice Johnson  | ₹10,000.00      |
| `444555666`    | 2222 | Bob Wilson     | ₹3,500.00       |

#### **Bank Officials**
| Official ID | Password | Role       | Name            |
|-------------|----------|------------|-----------------|
| `OFF001`    | admin123 | Manager    | John Manager    |
| `OFF002`    | staff456 | Staff      | Sarah Staff     |
| `OFF003`    | super789 | Supervisor | Mike Supervisor |

### **Customer Operations**
1. **Balance Check**: View current account balance
2. **Withdraw**: Cash withdrawal (max ₹50,000)
3. **Deposit**: Cash deposit (max ₹1,00,000)
4. **Transfer**: Money transfer (max ₹25,000)
5. **History**: View transaction history
6. **PIN Change**: Modify PIN securely
7. **Statement**: Request account statement

### **Bank Official Operations**
1. **Create Account**: Add new customer accounts
2. **View Accounts**: List all bank accounts
3. **Search Account**: Find accounts by number or name
4. **Manage Status**: Block/unblock accounts
5. **Statistics**: View bank-wide statistics
6. **Transaction Logs**: Monitor all transactions
7. **Manage Officials**: Add/remove bank staff

## 📁 Project Structure

```
enhanced-atm-simulation/
├── ATM.java              # Main application with dual login
├── Bank.java             # Central banking system
├── Account.java          # Individual account management
├── Transaction.java      # Transaction handling
├── BankOfficial.java     # Bank staff management
├── README.md            # Project documentation
└── .gitignore           # Git ignore configuration
```

## 🧪 Testing Scenarios

### **Customer Testing**
- ✅ Valid login with sample accounts
- ✅ Invalid login attempts
- ✅ Balance inquiry functionality
- ✅ Withdrawal with various amounts
- ✅ Deposit operations
- ✅ Money transfer between accounts
- ✅ PIN change process
- ✅ Transaction history viewing
- ✅ Account statement requests

### **Bank Official Testing**
- ✅ Official authentication
- ✅ Account creation process
- ✅ Account search functionality
- ✅ Account status management
- ✅ Bank statistics viewing
- ✅ Transaction monitoring
- ✅ Official management

### **Security Testing**
- ✅ Invalid credential handling
- ✅ Transaction limit enforcement
- ✅ Large amount verification
- ✅ Input validation
- ✅ Session management

## 🔒 Security Considerations

### **Implemented Security Features**
- **PIN Validation**: Secure 4-digit PIN verification
- **Transaction Limits**: Configurable limits for different operations
- **Session Management**: Proper logout and session handling
- **Input Sanitization**: Comprehensive input validation
- **Error Handling**: Secure error messages
- **Account Status Control**: Active/blocked account management

### **Recommended Enhancements**
- **PIN Hashing**: Implement salted hash for PIN storage
- **Database Integration**: Persistent data storage
- **Network Security**: Multi-user ATM network
- **Audit Logging**: Comprehensive audit trails
- **Multi-factor Authentication**: Additional security layers
- **Encryption**: Data encryption for sensitive information

## 📈 Future Enhancements

### **Potential Features**
- **Database Integration**: MySQL/PostgreSQL for persistent storage
- **GUI Interface**: JavaFX or Swing-based graphical interface
- **Network Support**: Multi-user ATM network system
- **Card Support**: Magnetic stripe/EMV card reading
- **Receipt Printing**: Transaction receipt generation
- **Multi-language**: Internationalization support
- **Mobile App**: Companion mobile application
- **API Integration**: RESTful API for external systems

### **Technical Improvements**
- **Unit Testing**: Comprehensive JUnit test coverage
- **Logging**: Advanced logging with Log4j/SLF4J
- **Configuration**: External configuration files
- **Dependency Management**: Maven/Gradle integration
- **CI/CD Pipeline**: Automated testing and deployment
- **Docker Support**: Containerized deployment

## 👨‍💻 Author

**Prabhu Bhalke**
- 🎓 Computer Science Engineering Student
- ☕ Java Programming Enthusiast
- 🚀 Software Development Learner
- 📧 Email: prabhubhalke379@gmail.com
- 💼 LinkedIn: [Prabhu Bhalke](https://linkedin.com/in/prabhu-bhalke)

## 📄 License

This project is created for **educational purposes** and demonstration of Java programming concepts. Feel free to use, modify, and distribute for learning purposes.

## 🤝 Contributing

We welcome contributions! Here's how you can help:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

### **Areas for Contribution**
- 🐛 Bug fixes and improvements
- ✨ New feature implementations
- 📚 Documentation enhancements
- 🧪 Additional test cases
- 🔒 Security improvements
- 🎨 UI/UX enhancements

## 📞 Support & Contact

For questions, support, or collaboration:

- 📧 **Email**: prabhubhalke379@gmail.com
- 💼 **LinkedIn**: [Prabhu Bhalke](https://linkedin.com/in/prabhu-bhalke)
- 🐛 **Issues**: [GitHub Issues](https://github.com/yourusername/enhanced-atm-simulation/issues)

## ⭐ Show Your Support

If you find this project helpful, please give it a ⭐ on GitHub!

---

<div align="center">

**⭐ Star this repository if you found it useful! ⭐**

*Built with ❤️ by [Prabhu Bhalke](https://linkedin.com/in/prabhu-bhalke)*

</div>

---

**⚠️ Disclaimer**: This is a simulation system for educational purposes. It does not connect to real banking systems or handle actual money transactions. Use responsibly and only for learning purposes. 
