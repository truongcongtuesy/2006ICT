package com.lab3.exercise2;

/**
 * CheckingAccount class that inherits from Account
 * Allows overdrafts up to a specified limit
 */
public class CheckingAccount extends Account {
    private double overdraftLimit;
    
    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
    
    /**
     * Checks if the account is overdrawn
     * @return true if the account balance is negative, false otherwise
     */
    public boolean checkOverdraft() {
        return balance < 0;
    }
    
    /**
     * Override withdraw method to allow overdrafts
     * @param amount Amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            this.balance -= amount;
            Transaction transaction = new Transaction(
                "TXN" + System.currentTimeMillis(),
                new java.util.Date(),
                -amount
            );
            transaction.process();
            addTransaction(transaction);
            
            if (checkOverdraft()) {
                System.out.println("Warning: Account is overdrawn. Balance: $" + balance);
            }
        } else {
            System.out.println("Withdrawal denied: Exceeds overdraft limit");
        }
    }
    
    // Getters and setters
    public double getOverdraftLimit() { return overdraftLimit; }
    public void setOverdraftLimit(double overdraftLimit) { this.overdraftLimit = overdraftLimit; }
}
