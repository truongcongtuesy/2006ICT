package com.lab3.exercise2;

/**
 * SavingsAccount class that inherits from Account
 * Earns interest on the balance
 */
public class SavingsAccount extends Account {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }
    
    /**
     * Applies interest to the account balance
     */
    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        
        // Create a transaction for the interest earned
        Transaction interestTransaction = new Transaction(
            "INT" + System.currentTimeMillis(),
            new java.util.Date(),
            interest
        );
        interestTransaction.process();
        addTransaction(interestTransaction);
        
        System.out.println("Interest applied: $" + interest + 
                          " New balance: $" + balance);
    }
    
    // Getters and setters
    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
}
