package com.banking.transaction.transactionManagers.operations;

import java.util.List;

import com.banking.transaction.entities.Operation;

public interface IAccountOperation {
    void showAccountDetails(int accountNo);
    boolean createAccount();
    List<Operation> getStatement(int accountNo);
}
