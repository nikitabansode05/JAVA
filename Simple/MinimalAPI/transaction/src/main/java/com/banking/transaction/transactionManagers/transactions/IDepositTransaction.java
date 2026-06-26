package com.banking.transaction.transactionManagers.transactions;

public interface IDepositTransaction {
     boolean credit(double amount,int accountNo);
}
