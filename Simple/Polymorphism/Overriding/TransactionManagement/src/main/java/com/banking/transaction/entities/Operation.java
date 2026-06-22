package com.banking.transaction.entities;

import java.time.LocalDateTime;

public class Operation {
    int accountNo;
    String operationType;
    LocalDateTime datetime;
    double amount;

    public Operation() {
    }

    public Operation(int accountNo,String operationType,LocalDateTime datetime,double amount){
        this.accountNo=accountNo;
        this.operationType=operationType;
        this.datetime=datetime;
        this.amount=amount;
    }

    public void setAccountNo(int accountNo){
        this.accountNo=accountNo;
    }

    public int getAccountNo(){
        return accountNo;
    }

    public void setOperationType(String operationType){
        this.operationType=operationType;
    }

    public String getOperationType(){
        return operationType;
    }

    public LocalDateTime getDatetime(){
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime){
        this.datetime=datetime;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }

    public double getAmount(){
        return amount;
    }

    @Override
    public String toString(){
        return ("Account No :"+accountNo+" Operation Type :"+operationType+" amount :"+amount+" DateTime : "+datetime);
    }
}
