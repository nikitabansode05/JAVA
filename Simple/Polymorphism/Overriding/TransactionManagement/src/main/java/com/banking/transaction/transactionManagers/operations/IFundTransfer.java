package com.banking.transaction.transactionManagers.operations;

public interface IFundTransfer {
    boolean transation(int accountNo1,int accountNo2,double amount);
}
