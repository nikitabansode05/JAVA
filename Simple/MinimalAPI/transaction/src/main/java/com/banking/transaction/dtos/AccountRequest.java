package com.banking.transaction.dtos;

public class AccountRequest {
    private int accountNo;
    private String name;
    private double balance;

    public int getAccountNo() { return accountNo; }
    public void setAccountNo(int accountNo) { this.accountNo = accountNo; }
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public double getBalance(){return balance;}
    public void setBalance(double balance){this.balance=balance;}
}