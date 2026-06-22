package com.banking.transaction.listeners;

public class AccountListenerImpl implements AccountListener{

    @Override
    public void onUnderBalance() {
        System.out.println("There is insufficient balance in your account");
    }

    @Override
    public void onOverBalance(){
        System.out.println("The balance is much more than expected");
    }

    @Override
    public void onCredit(double amount,double balance){
        System.out.println(amount+" has been credited , total balance is :"+balance);

    }

    @Override
    public void onDebit(double amount,double balance){
        System.out.println(amount+" has been debited, total balance is :"+balance);
    }
}
