package com.banking.transaction.services;

import com.banking.transaction.entities.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class TransactionServiceImpl implements ITransactionService{

    private ObjectMapper mapper=new ObjectMapper();
    File accountHistory=new File("AccountDetails.json");

    @Override
    public void debit(Account a1,double amount){
        double newBalance=a1.getBalance();
        newBalance-=amount;
        a1.setBalance(newBalance);
        System.out.println("The Balance after debit is : "+newBalance);
        try{
            mapper.writeValue(accountHistory, a1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void credit(Account a1,double amount){
        double newBalance=a1.getBalance();
        newBalance+=amount;
        a1.setBalance(newBalance);
        System.out.println("The Balance after credit is : "+newBalance);
        try{
            mapper.writeValue(accountHistory, a1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void transation(Account a1,Account a2,double amount){
        debit(a1,amount);
        credit(a2,amount);
        System.out.println("The transaction is successfull from account "+a1.getAccountNo()+" to "+a2.getAccountNo());
        try{
            mapper.writeValue(accountHistory, a1);
            mapper.writeValue(accountHistory, a2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
