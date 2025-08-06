package com.lab3.exercise2;

import java.util.Date;

/**
 * Transaction class representing a financial transaction
 * Composed by Account (when account is deleted, transactions are also deleted)
 */
public class Transaction {
    private String transactionId;
    private Date date;
    private double amount;
    
    public Transaction(String transactionId, Date date, double amount) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
    }
    
    /**
     * Processes the transaction
     */
    public void process() {
        // Transaction processing logic
        System.out.println("Processing transaction: " + transactionId + 
                          " Amount: $" + amount + " Date: " + date);
    }
    
    // Getters and setters
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
