package org.example;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }
    public void deposit(int amount) {
        balance += amount;
    }
    public void withdraw(int amount) {
        if (amount >= balance) {
            throw  new IllegalArgumentException("Insufficient Balance");
        }
        balance -= amount;
    }
    public int getBalance() {
        return balance;
    }
}

