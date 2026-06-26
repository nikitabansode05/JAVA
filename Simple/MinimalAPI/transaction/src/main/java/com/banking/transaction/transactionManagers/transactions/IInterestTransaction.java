package com.banking.transaction.transactionManagers.transactions;

import java.time.LocalDate;

public interface IInterestTransaction {
    double applyInterest(int accountNo,double interest);
    void applyInteresttoAll(double interest);
    double interestCalculation(LocalDate fromdate,LocalDate todate,double interest,double balance);
}
