# Lab 3 - Object-Oriented Software Development

## Exercise 1: Enhanced JavaAnimation Application

### ✅ **Implemented Features**

All required features have been successfully implemented:

#### **a. Main Screen Label**
- Added "Main Screen" label at the top of the main screen
- Styled with large, bold font for clear visibility

#### **b. Configuration and Exit Buttons**
- Added "Configuration" button below "Start Game" button
- Added "Exit" button below "Configuration" button
- Both buttons properly styled and functional

#### **c. Configuration Screen Navigation**
- Configuration button switches to new Configuration Screen
- Smooth transition between screens

#### **d. Configuration Screen Layout**
- "Configuration" label displayed at the top
- "Back" button positioned at the bottom
- Proper spacing and alignment

#### **e. Back Button Functionality**
- Back button returns to Main Screen
- Preserves all configuration settings

#### **f. Configuration Controls**
- ✅ **Enable Shadow checkbox**: Toggles shadow effect on/off
- ✅ **Color radio buttons**: Red, Green, Blue options for ball color
- ✅ **Ball size label**: Displays current ball size value
- ✅ **Size slider**: Range 5-20, updates label in real-time

#### **g. Real-time Settings Application**
- All configuration changes apply immediately to the game
- Ball color, shadow effect, and size update dynamically during gameplay

#### **h. Enhanced Arrow Key Controls**
- **Left Arrow**: Decreases X-direction speed
- **Right Arrow**: Increases X-direction speed  
- **Up Arrow**: Increases Y-direction speed (upward)
- **Down Arrow**: Decreases Y-direction speed (downward)
- Speed changes are gradual and capped at reasonable limits

#### **i. Exit Functionality**
- Exit button properly closes the entire application

### **🎮 How to Run**
```bash
mvn clean javafx:run
```

### **🎯 Key Implementation Details**

1. **State Management**: Configuration settings persist across screen transitions
2. **Real-time Updates**: Ball appearance updates during gameplay based on current settings
3. **Enhanced Physics**: Improved ball movement with variable speed control
4. **User Experience**: Intuitive interface with clear visual feedback
5. **Professional Styling**: Consistent button sizes and attractive layout

---

## Exercise 2: Banking System Class Diagram

### **🏦 System Overview**

Designed and implemented a comprehensive Banking System with proper OOP relationships:

### **📊 Class Diagram Relationships**

#### **✅ Inheritance**
- `Account` (abstract) ← `SavingsAccount`
- `Account` (abstract) ← `CheckingAccount`

#### **✅ Aggregation** 
- `Customer` ◇→ `Account` (1 to many)
- Customer owns accounts but accounts can exist independently

#### **✅ Composition**
- `Account` ◆→ `Transaction` (1 to many)
- When account is deleted, its transactions are also deleted

#### **✅ Association**
- `Customer` ↔ `BankCard` (1 to many)
- `BankCard` ↔ `Account` (many to many)
- `Statement` ↔ `Account` (many to 1)
- `Statement` ↔ `Transaction` (1 to many)

### **🏗️ Class Implementations**

| Class | Key Features |
|-------|-------------|
| **Customer** | Manages accounts, owns bank cards |
| **Account** | Abstract base with deposit/withdraw |
| **SavingsAccount** | Interest calculation functionality |
| **CheckingAccount** | Overdraft protection and warnings |
| **Transaction** | Immutable transaction records |
| **Statement** | Account statement generation |
| **BankCard** | PIN validation, ATM operations |

### **🧪 Demo Results**

The `BankingSystemDemo` successfully demonstrates:

- ✅ **Account Creation**: Savings and Checking accounts
- ✅ **Transaction Processing**: Deposits, withdrawals, interest
- ✅ **Inheritance**: Specialized account behaviors
- ✅ **Overdraft Handling**: CheckingAccount overdraft warnings
- ✅ **Bank Card Operations**: PIN validation, ATM withdrawals
- ✅ **Statement Generation**: Complete transaction history

### **🎯 Key Achievements**

1. **Complete UML Implementation**: All 7 classes with proper relationships
2. **Functional Banking Operations**: Real-world banking scenarios
3. **Proper OOP Design**: Inheritance, encapsulation, polymorphism
4. **Comprehensive Testing**: Demo covers all functionality
5. **Professional Code Quality**: Clean, documented, maintainable

---

## **📁 Project Structure**

```
src/main/java/com/lab3/
├── exercise1/
│   └── EnhancedJavaAnimation.java    # Enhanced game with all features
└── exercise2/                        # Banking System classes
    ├── Account.java                  # Abstract base class
    ├── SavingsAccount.java          # Inherits from Account
    ├── CheckingAccount.java         # Inherits from Account
    ├── Customer.java                # Aggregates accounts
    ├── Transaction.java             # Composed by Account
    ├── Statement.java               # Associated with Account
    ├── BankCard.java                # Associated with Customer
    └── BankingSystemDemo.java       # Complete system demonstration

docs/lab3/
└── banking-system-class-diagram.puml # PlantUML class diagram
```

## **🏆 Lab 3 Completion Summary**

- ✅ **Exercise 1**: JavaAnimation enhanced with all 9 required features
- ✅ **Exercise 2**: Complete Banking System with UML relationships
- ✅ **Code Quality**: Professional, well-documented implementations
- ✅ **Testing**: Both exercises thoroughly tested and functional
- ✅ **Documentation**: Comprehensive PlantUML diagrams and docs

Both exercises demonstrate advanced OOP concepts including inheritance, polymorphism, composition, aggregation, and association patterns in real-world applications.
