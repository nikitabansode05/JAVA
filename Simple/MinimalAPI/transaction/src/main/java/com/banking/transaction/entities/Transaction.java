package com.banking.transaction.entities;

import java.time.LocalDateTime;

public class Transaction {
    int accountNo;
    String transactionType;
    LocalDateTime datetime;
    double amount;
    double balance;

    public Transaction() {
    }

    public Transaction(int accountNo,String transactionType,LocalDateTime datetime,double amount,double balance){
        this.accountNo=accountNo;
        this.transactionType=transactionType;
        this.datetime=datetime;
        this.amount=amount;
        this.balance=balance;
    }

    public void setAccountNo(int accountNo){
        this.accountNo=accountNo;
    }

    public int getAccountNo(){
        return accountNo;
    }

    public void settransactionType(String transactionType){
        this.transactionType=transactionType;
    }

    public String gettransactionType(){
        return transactionType;
    }

    public LocalDateTime getDatetime(){
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime){
        this.datetime=datetime;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }

    public double getAmount(){
        return amount;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString(){
        return ("Account No :"+accountNo+" transaction Type :"+transactionType+" amount :"+amount+" DateTime : "+datetime+" Balance"+balance);
    }
}
