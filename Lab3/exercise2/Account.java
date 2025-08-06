package com.lab3.exercise2;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Account class - base class for all account types
 * Contains transactions through composition
 */
public abstract class Account {
    protected String accountNumber;
    protected double balance;
    private List<Transaction> transactions;
    
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }
    
    /**
     * Deposits money into the account
     * @param amount Amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            Transaction transaction = new Transaction(
                "TXN" + System.currentTimeMillis(),
                new java.util.Date(),
                amount
            );
            transaction.process();
            transactions.add(transaction);
        }
    }
    
    /**
     * Withdraws money from the account
     * @param amount Amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            Transaction transaction = new Transaction(
                "TXN" + System.currentTimeMillis(),
                new java.util.Date(),
                -amount
            );
            transaction.process();
            transactions.add(transaction);
        }
    }
    
    // Getters and setters
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public List<Transaction> getTransactions() { return new ArrayList<>(transactions); }
    
    protected void setBalance(double balance) { this.balance = balance; }
    
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
