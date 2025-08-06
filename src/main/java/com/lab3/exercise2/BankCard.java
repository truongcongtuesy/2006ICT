package com.lab3.exercise2;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * BankCard class representing a bank card
 * Associated with Customer and Account
 */
public class BankCard {
    private String cardNumber;
    private Date expiryDate;
    private Customer owner;
    private List<Account> linkedAccounts;
    
    public BankCard(String cardNumber, Date expiryDate, Customer owner) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.owner = owner;
        this.linkedAccounts = new ArrayList<>();
    }
    
    /**
     * Validates the PIN for the card
     * @param pin PIN to validate
     * @return true if PIN is valid, false otherwise
     */
    public boolean validatePin(String pin) {
        // Simple PIN validation logic (in real system, would be more secure)
        return pin != null && pin.length() == 4 && pin.matches("\\d{4}");
    }
    
    /**
     * Withdraws money from ATM using the card
     * @param amount Amount to withdraw
     */
    public void withdrawFromATM(double amount) {
        if (linkedAccounts.isEmpty()) {
            System.out.println("No accounts linked to this card");
            return;
        }
        
        // Use the first linked account for withdrawal
        Account account = linkedAccounts.get(0);
        account.withdraw(amount);
        System.out.println("ATM withdrawal: $" + amount + " from account " + 
                          account.getAccountNumber());
    }
    
    /**
     * Links an account to this card
     * @param account Account to link
     */
    public void linkAccount(Account account) {
        if (!linkedAccounts.contains(account)) {
            linkedAccounts.add(account);
        }
    }
    
    /**
     * Unlinks an account from this card
     * @param account Account to unlink
     */
    public void unlinkAccount(Account account) {
        linkedAccounts.remove(account);
    }
    
    // Getters and setters
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    
    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
    
    public Customer getOwner() { return owner; }
    public void setOwner(Customer owner) { this.owner = owner; }
    
    public List<Account> getLinkedAccounts() { return new ArrayList<>(linkedAccounts); }
}
