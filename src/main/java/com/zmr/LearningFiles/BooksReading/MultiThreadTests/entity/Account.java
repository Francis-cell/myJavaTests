package com.zmr.LearningFiles.BooksReading.MultiThreadTests.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    public final Lock lock = new ReentrantLock();
    private String accountName;

    private double accountAmount;

    private Account(String accountName, double accountAmount) {
        this.accountName = accountName;
        this.accountAmount = accountAmount;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getAccountAmount() {
        return accountAmount;
    }

    public Account getBalance(String accountName, double accountAmount) {
        return new Account(accountName, accountAmount);
    }

    public Account getBalance() {
        return new Account(accountName, accountAmount);
    }

    public int compareTo(double a) {
        if (accountAmount > a) {
            return 1;
        } else if (accountAmount == a){
            return 0;
        } else {
            return -1;
        }
    }

    public void debit(double amount) {
        accountAmount -= amount;
    }

    public void credit(double amount) {
        accountAmount += amount;
    }
}
