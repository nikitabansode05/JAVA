package com.banking.transaction.transactionManagers.transactions;

public interface IWithdrawTransaction {
    boolean debit(double amount,int accountNo);
}
