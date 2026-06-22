package com.banking.transaction.entities;

public class Operation {
    Account account;
    String operationType;

    public Operation() {
    }

    public Operation(Account account,String operationType){
        this.account=account;
        this.operationType=operationType;
    }

    public void setAccount(Account account){
        this.account=account;
    }

    public Account getAccount(){
        return account;
    }

    public void setOperationType(String operationType){
        this.operationType=operationType;
    }

    public String getOperationType(){
        return operationType;
    }

    @Override
    public String toString(){
        return ("Account :"+account+" Operation Type :"+operationType);
    }
}
