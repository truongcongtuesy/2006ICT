package com.lab3.exercise2;

import java.util.List;
import java.util.ArrayList;

/**
 * Statement class representing an account statement
 * Associated with Account and references Transactions
 */
public class Statement {
    private String statementId;
    private String period;
    private Account account;
    private List<Transaction> transactions;
    
    public Statement(String statementId, String period, Account account) {
        this.statementId = statementId;
        this.period = period;
        this.account = account;
        this.transactions = new ArrayList<>();
    }
    
    /**
     * Generates the statement by collecting transactions from the account
     */
    public void generate() {
        // Get all transactions from the associated account
        transactions = account.getTransactions();
        
        System.out.println("=== BANK STATEMENT ===");
        System.out.println("Statement ID: " + statementId);
        System.out.println("Period: " + period);
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Current Balance: $" + account.getBalance());
        System.out.println("\n=== TRANSACTIONS ===");
        
        if (transactions.isEmpty()) {
            System.out.println("No transactions for this period.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
        
        System.out.println("=== END OF STATEMENT ===\n");
    }
    
    /**
     * Adds a specific transaction to the statement
     * @param transaction Transaction to add
     */
    public void addTransaction(Transaction transaction) {
        if (!transactions.contains(transaction)) {
            transactions.add(transaction);
        }
    }
    
    // Getters and setters
    public String getStatementId() { return statementId; }
    public void setStatementId(String statementId) { this.statementId = statementId; }
    
    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }
    
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
    
    public List<Transaction> getTransactions() { return new ArrayList<>(transactions); }
}
