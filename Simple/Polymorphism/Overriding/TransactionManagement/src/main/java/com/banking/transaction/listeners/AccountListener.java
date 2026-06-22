package com.banking.transaction.listeners;

public interface AccountListener {
    void onUnderBalance();
    void onOverBalance();
    void onCredit(double amount,double balance);
    void onDebit(double amount,double balance);
}
