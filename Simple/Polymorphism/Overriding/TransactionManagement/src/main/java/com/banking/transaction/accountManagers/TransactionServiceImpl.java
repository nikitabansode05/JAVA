package com.banking.transaction.accountManagers;

import com.banking.transaction.entities.Account;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.banking.transaction.entities.Operation;
import com.banking.transaction.listeners.AccountListenerImpl;
import com.banking.transaction.listeners.AccountListener;
import com.banking.transaction.repositories.OperationFileManager.OperationsFileIO;
import com.banking.transaction.repositories.OperationFileManager.OperationsFileIOImpl;
import com.banking.transaction.repositories.accountFileManager.AccountFileIO;
import com.banking.transaction.repositories.accountFileManager.AccountFileIOImpl;

public class TransactionServiceImpl implements ITransactionService{

    Account a1=new Account(101,"Nikita Bansode",8000.00,LocalDateTime.now());
    Account a2=new Account(102,"Tanya",7000.00,LocalDateTime.now());
    List<Account> accountList=new ArrayList<Account>();
    List<Operation> operations=new ArrayList<Operation>();

    AccountFileIO fileIO=new AccountFileIOImpl();
    OperationsFileIO operationsFile=new OperationsFileIOImpl();
    AccountListener listener=new AccountListenerImpl();

    Scanner sc=new Scanner(System.in);

    public TransactionServiceImpl(){
        accountList.add(a1);
        accountList.add(a2);
        try {
            fileIO.serializeAccount(accountList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAccountDetails(int accountNo){
        try{
            List<Account> deserializedAcc=fileIO.deserializeAccount();
            for(Account a:deserializedAcc){
            if(accountNo==a.getAccountNo()){
                System.out.println(a);
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @Override 
    public void createAccount(){
        System.out.println("Enter Account Number");
        int accNo=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Account Holder name");
        String name=sc.nextLine();
        sc.nextLine();

        System.out.println("Enter Account Balance");
        double balance=sc.nextDouble();

        Account account = new Account(accNo,name,balance,LocalDateTime.now());
        try{
            List<Account> deserializedAcc=fileIO.deserializeAccount();
            deserializedAcc.add(account);
            fileIO.serializeAccount(deserializedAcc);
      }catch(Exception e){
        e.printStackTrace();
      }
    }


    @Override
    public void debit(double amount,int accountNo){
        try{
            List<Account> deserializedAcc=fileIO.deserializeAccount();
            for(Account a:deserializedAcc){
                if((a.getAccountNo()==accountNo) && amount<a.getBalance()){
                    double newBalance=a.getBalance();
                    newBalance-=amount;
                    a.setBalance(newBalance);
                    Operation operation = new Operation(a.getAccountNo(),"debited",LocalDateTime.now(),amount);
                    operations.add(operation);
                    operationsFile.serializeOperation(operations);
                    listener.onDebit(amount,newBalance);
                }
            }
           
            fileIO.serializeAccount(deserializedAcc);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void credit(double amount,int accountNo){
        try{
            List<Account> deserializedAcc=fileIO.deserializeAccount();
            for(Account a:deserializedAcc){
                if(a.getAccountNo()==accountNo){
                    double newBalance=a.getBalance();
                    newBalance+=amount;
                    a.setBalance(newBalance);
                    Operation operation = new Operation(a.getAccountNo(),"credited",LocalDateTime.now(),amount);
                    operations.add(operation);
                    operationsFile.serializeOperation(operations);
                    listener.onCredit(amount, newBalance);
                }
            }
            fileIO.serializeAccount(deserializedAcc);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void transation(int accountNo1,int accountNo2,double amount){
        
        System.out.println("The transaction is successfull from account "+a1.getAccountNo()+" to "+a2.getAccountNo());
        try{
            List<Account> deserializedAcc=fileIO.deserializeAccount();

            for(Account a:deserializedAcc){
                if (accountNo1==a.getAccountNo()){
                    debit(amount,accountNo1);
                }
                if(accountNo2==a.getAccountNo()){
                    credit(amount,accountNo2);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Operation> getStatement(int accountNo){
        operations=operationsFile.deserializeOperation();
        List<Operation> accOperations=new ArrayList<Operation>();
        int count=0;
        for(Operation o:operations){
            if(o.getAccountNo()==accountNo){
                accOperations.add(o);
                count++;
            }
        }
        System.out.println(count);
        if(count>5){
            List<Operation> printOperations=new ArrayList<Operation>();
            for(int i=(count-1);i>=(count-5);i--){
                printOperations.add(accOperations.get(i));
            }
            return printOperations;
        }else{
                return accOperations;
        }
    }    
}
