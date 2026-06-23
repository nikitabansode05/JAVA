package com.banking.transaction.accountManagers;

import java.util.List;

import com.banking.transaction.entities.Operation;

public interface ITransactionService {
    void debit(double amount,int accountNo);
    void credit(double amount,int accountNo);
    void transation(int accountNo1,int accountNo2,double amount);
    void getAccountDetails(int accountNo);
    void createAccount();
    List<Operation> getStatement(int accountNo);
    double calculateInterest(int accountNo,double interest);
    void ApplyInteresttoAll(double interest);
}
