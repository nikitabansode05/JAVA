package com.banking.transaction.transactionManagers.operations;

import java.util.List;

import com.banking.transaction.entities.Operation;
import com.banking.transaction.entities.Account;

public interface IAccountOperation {
    Account showAccountDetails(int accountNo);
    boolean createAccount(int accNo,String name,double balance);
    List<Operation> getStatement(int accountNo);
}
