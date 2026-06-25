package com.banking.transaction.entities;

import java.time.LocalDateTime;

public class Account{
    
    private int accountNo;
    private String name;
    private double balance;
    private LocalDateTime datetime;
    
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

    public LocalDateTime getDatetime(){
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime){
        this.datetime=datetime;
    }

    public Account(){}

    public Account(int accountNo,String name,double balance,LocalDateTime datetime){
        this.accountNo=accountNo;
        this.name=name;
        this.balance=balance;
        this.datetime=datetime;
    }
    
    @Override
    public String toString(){
        return ("Account Number : "+accountNo+" Name: "+name+" Balance : "+balance+" Date Time :"+datetime);
    }

}