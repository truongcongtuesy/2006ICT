package com.lab3.exercise2;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer class representing a bank customer
 * Aggregates accounts and is associated with bank cards
 */
public class Customer {
    private String name;
    private String id;
    private List<Account> accounts;
    private List<BankCard> bankCards;
    
    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
        this.accounts = new ArrayList<>();
        this.bankCards = new ArrayList<>();
    }
    
    /**
     * Opens a new account for the customer
     * @param accountType Type of account to create
     * @return The newly created account
     */
    public Account openAccount(String accountType) {
        Account account;
        String accountNumber = "ACC" + System.currentTimeMillis();
        
        if ("SAVINGS".equalsIgnoreCase(accountType)) {
            account = new SavingsAccount(accountNumber, 0.0, 0.03); // 3% interest rate
        } else if ("CHECKING".equalsIgnoreCase(accountType)) {
            account = new CheckingAccount(accountNumber, 0.0, 1000.0); // $1000 overdraft limit
        } else {
            throw new IllegalArgumentException("Invalid account type: " + accountType);
        }
        
        accounts.add(account);
        return account;
    }
    
    /**
     * Closes an existing account
     * @param account The account to close
     */
    public void closeAccount(Account account) {
        accounts.remove(account);
    }
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public List<Account> getAccounts() { return new ArrayList<>(accounts); }
    
    public List<BankCard> getBankCards() { return new ArrayList<>(bankCards); }
    
    public void addBankCard(BankCard card) {
        this.bankCards.add(card);
    }
    
    public void removeBankCard(BankCard card) {
        this.bankCards.remove(card);
    }
}
