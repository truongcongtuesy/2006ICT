# Lab 3 - Object-Oriented Software Development

## Exercise 1: Enhanced JavaAnimation Application

**File:** `exercise1/EnhancedJavaAnimation.java`

### Features Implemented:
- ✅ Main Screen with "Main Screen" label
- ✅ Configuration and Exit buttons
- ✅ Configuration Screen with Back button
- ✅ Enable Shadow checkbox
- ✅ Color selection (Red, Green, Blue radio buttons)
- ✅ Ball size slider (5-20) with live label update
- ✅ Enhanced arrow key controls:
  - Left/Right: Adjust X direction speed
  - Up/Down: Adjust Y direction speed
- ✅ Exit button closes application
- ✅ Real-time settings application

### How to Run:
```bash
mvn clean javafx:run
```

## Exercise 2: Banking System Class Diagram

**Files:**
- `banking-system-class-diagram.puml` - PlantUML class diagram
- `exercise2/` - Java implementation of all classes

### Classes Implemented:
- **Customer** - Manages customer information and accounts
- **Account** (Abstract) - Base class for all account types
- **SavingsAccount** - Account with interest rate
- **CheckingAccount** - Account with overdraft limit
- **Transaction** - Records account transactions
- **Statement** - Generates account statements
- **BankCard** - Bank card linked to accounts

### Relationships:
- **Aggregation**: Customer → Account (1..*)
- **Composition**: Account → Transaction (0..*)
- **Inheritance**: Account → SavingsAccount, CheckingAccount
- **Association**: Customer ↔ BankCard, BankCard ↔ Account, Statement ↔ Account

### Demo:
Run `BankingSystemDemo.java` to see the system in action.

## Technologies Used:
- Java 17
- JavaFX 17.0.2
- Maven
- PlantUML for diagrams
