package com.banking.transaction.transactionManagers.operations;

import java.time.LocalDate;

public interface IInterestOperation {
    double applyInterest(int accountNo,double interest);
    void applyInteresttoAll(double interest);
    double interestCalculation(LocalDate fromdate,LocalDate todate,double interest,double balance);
}
