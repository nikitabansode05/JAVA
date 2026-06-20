package com.banking.transaction.services;

import com.banking.transaction.entities.Account;

public interface ITransactionService {
    void debit(Account a1,double amount);
    void credit(Account a1,double amount);
    void transation(Account a1,Account a2,double amount);
}
