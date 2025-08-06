package com.lab3.exercise2;

import java.util.Date;

/**
 * Demo class to test the Banking System
 * Demonstrates all relationships: inheritance, aggregation, composition, association
 */
public class BankingSystemDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Banking System Demo ===\n");
        
        // Create a customer
        Customer customer = new Customer("John Doe", "CUST001");
        System.out.println("Created customer: " + customer.getName() + " (ID: " + customer.getId() + ")");
        
        // Demonstrate Aggregation: Customer owns Accounts
        Account savingsAccount = customer.openAccount("SAVINGS");
        Account checkingAccount = customer.openAccount("CHECKING");
        
        System.out.println("Opened savings account: " + savingsAccount.getAccountNumber());
        System.out.println("Opened checking account: " + checkingAccount.getAccountNumber());
        
        // Demonstrate Composition: Account contains Transactions
        System.out.println("\n=== Testing Deposits and Withdrawals ===");
        savingsAccount.deposit(1000.0);
        savingsAccount.deposit(500.0);
        savingsAccount.withdraw(200.0);
        
        checkingAccount.deposit(2000.0);
        checkingAccount.withdraw(2500.0); // This will cause overdraft
        
        // Demonstrate Inheritance: SavingsAccount specific method
        System.out.println("\n=== Testing Inheritance: Savings Account Interest ===");
        if (savingsAccount instanceof SavingsAccount) {
            ((SavingsAccount) savingsAccount).applyInterest();
        }
        
        // Demonstrate Inheritance: CheckingAccount specific method
        System.out.println("\n=== Testing Inheritance: Checking Account Overdraft ===");
        if (checkingAccount instanceof CheckingAccount) {
            boolean isOverdrawn = ((CheckingAccount) checkingAccount).checkOverdraft();
            System.out.println("Checking account overdrawn: " + isOverdrawn);
        }
        
        // Demonstrate Association: Customer <-> BankCard
        System.out.println("\n=== Testing Association: Bank Card ===");
        BankCard debitCard = new BankCard("4532-1234-5678-9012", new Date(), customer);
        customer.addBankCard(debitCard);
        
        // Demonstrate Association: BankCard <-> Account
        debitCard.linkAccount(savingsAccount);
        debitCard.linkAccount(checkingAccount);
        
        // Test PIN validation
        System.out.println("PIN validation (1234): " + debitCard.validatePin("1234"));
        System.out.println("PIN validation (abc): " + debitCard.validatePin("abc"));
        
        // Test ATM withdrawal
        debitCard.withdrawFromATM(100.0);
        
        // Demonstrate Association: Statement <-> Account and Statement <-> Transaction
        System.out.println("\n=== Testing Association: Account Statements ===");
        Statement savingsStatement = new Statement("STMT001", "January 2025", savingsAccount);
        Statement checkingStatement = new Statement("STMT002", "January 2025", checkingAccount);
        
        savingsStatement.generate();
        checkingStatement.generate();
        
        // Display final account information
        System.out.println("=== Final Account Summary ===");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Number of accounts: " + customer.getAccounts().size());
        System.out.println("Number of bank cards: " + customer.getBankCards().size());
        
        for (Account account : customer.getAccounts()) {
            System.out.println("Account " + account.getAccountNumber() + 
                             " Balance: $" + account.getBalance() + 
                             " Transactions: " + account.getTransactions().size());
        }
    }
}
