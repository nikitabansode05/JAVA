package com.banking.transaction.services;

public interface ITransactionService {
    void debit(double amount,int accountNo);
    void credit(double amount,int accountNo);
    void transation(int accountNo1,int accountNo2,double amount);
    void getAccountDetails(int accountNo);
    void createAccount();
}
