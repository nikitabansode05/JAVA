package com.banking.transaction;

import com.banking.transaction.uiManagers.Menu;

public class App {
    public static void main(String[] args) {
       Menu operation=new Menu();
       operation.menuOperation();
    }
}





























 // operations=operationsFile.deserializeOperation();
        // accountList=fileIO.deserializeAccount();
        // double totalBalance=0;
        // int count=0;
        // for(Operation o:operations){
        //     if((o.getAccountNo()==accountNo)){
        //         totalBalance+=o.getBalance();
        //         count++;
        //     }
        // }
        // double averageBalance=(totalBalance/count);
        // double calculateInterest=(interest/100)*averageBalance;
        // double newBalance=totalBalance+calculateInterest;
        // for(Account a:accountList){
        //     if(a.getAccountNo()==accountNo){
        //         a.setBalance(newBalance);
        //     }
        // }
        // fileIO.serializeAccount(accountList);
        // Operation operation=new Operation(accountNo,"Interest",LocalDateTime.now(),calculateInterest,newBalance);
        // operations.add(operation);
        // operationsFile.serializeOperation(operations);