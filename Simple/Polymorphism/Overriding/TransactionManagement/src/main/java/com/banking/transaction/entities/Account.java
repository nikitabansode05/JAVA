package com.banking.transaction.entities;

public class Account{
    private int accountNo;
    private String name;
    private double balance;

    public int getAccountNo(){
        return accountNo;
    }

    public void setAccountNo(int accountNo){
        this.accountNo=accountNo;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }

    public Account(){}

    public Account(int accountNo,String name,double balance){
        this.accountNo=accountNo;
        this.name=name;
        this.balance=balance;
    }
    
    @Override
    public String toString(){
        return ("Account Number : "+accountNo+" Name: "+name+" Balance : "+balance);
    }

}