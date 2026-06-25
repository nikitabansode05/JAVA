package com.banking.transaction.accountManagers;

import java.time.LocalDate;
import java.util.List;

import com.banking.transaction.entities.Operation;

public interface ITransactionService {
    double calculateInterest(int accountNo,double interest);
    double applyInterest(int accountNo,double interest);
    void applyInteresttoAll(double interest);
    double interestCalculation(LocalDate fromdate,LocalDate todate,double interest,double balance);
}
