package com.banking.transaction.transactionManagers.operations;

public interface IWithdrawOperation {
    boolean debit(double amount,int accountNo);
}
