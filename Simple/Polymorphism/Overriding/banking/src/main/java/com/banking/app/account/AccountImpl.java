package com.banking.app.account;

import com.banking.app.services.Notification;

public class AccountImpl implements Account{
    private double balance;
    private Notification notification;
    
    public AccountImpl(){

    }

    public AccountImpl(double balance,Notification notification){
        this.balance=balance;
        this.notification=notification;
    }
    
    @Override
    public  void deposit(double amount){
        this.balance-=amount;
        notification.depositNotification();
        System.out.println(balance);
    }

    @Override
    public  void withdraw(double amount){
        this.balance+=amount;
        notification.withdrawNotification();
        System.out.println(balance);
    }
}
