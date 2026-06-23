package com.banking.transaction.listeners;

public class AccountListenerImpl implements AccountListener{

    @Override
    public void onCredit(double amount,double balance){
        System.out.println(amount+" has been credited , total balance is :"+balance);

    }

    @Override
    public void onDebit(double amount,double balance){
        System.out.println(amount+" has been debited, total balance is :"+balance);
    }
}
