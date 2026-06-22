package com.banking.transaction.services;

import com.banking.transaction.entities.Account;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TransactionServiceImpl implements ITransactionService{

    ObjectMapper mapper=new ObjectMapper();
    File accountHistory=new File("AccountDetails.json");


    Account a1=new Account(101,"Nikita Bansode",8000.00,LocalDateTime.now());
    Account a2=new Account(102,"Tanya",7000.00,LocalDateTime.now());


    public List<Account> accountList=new ArrayList<Account>();

    Scanner sc=new Scanner(System.in);

    public TransactionServiceImpl(){
        mapper.registerModule(new JavaTimeModule());

        accountList.add(a1);
        accountList.add(a2);

        try {
            mapper.writeValue(accountHistory, accountList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAccountDetails(int accountNo){
        try{
            List<Account> deserializedAcc=mapper.readValue(accountHistory,new TypeReference<List<Account>>() {});
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
        List<Account> deserializedAcc=mapper.readValue(accountHistory,new TypeReference<List<Account>>() {});
        deserializedAcc.add(account);

        mapper.writeValue(accountHistory,deserializedAcc);
      }catch(Exception e){
        e.printStackTrace();
      }
    }


    @Override
    public void debit(double amount,int accountNo){
        try{
            List<Account> deserializedAcc=mapper.readValue(accountHistory,new TypeReference<List<Account>>() {});
            for(Account a:deserializedAcc){
                if(a.getAccountNo()==accountNo){
                    double newBalance=a.getBalance();
                    newBalance-=amount;
                    a.setBalance(newBalance);
                    a.setDatetime(LocalDateTime.now());
                    System.out.println("The Balance after debit is : "+newBalance);
                }
            }
            mapper.writeValue(accountHistory,deserializedAcc);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void credit(double amount,int accountNo){
        try{
            List<Account> deserializedAcc=mapper.readValue(accountHistory,new TypeReference<List<Account>>() {});
            for(Account a:deserializedAcc){
                if(a.getAccountNo()==accountNo){
                    double newBalance=a.getBalance();
                    newBalance+=amount;
                    a.setBalance(newBalance);
                    a.setDatetime(LocalDateTime.now());
                    System.out.println("The Balance after credit is : "+newBalance);
                }
            }

            mapper.writeValue(accountHistory,deserializedAcc);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void transation(int accountNo1,int accountNo2,double amount){
        
        System.out.println("The transaction is successfull from account "+a1.getAccountNo()+" to "+a2.getAccountNo());
        try{
            List<Account> deserializedAcc=mapper.readValue(accountHistory,new TypeReference<List<Account>>() {});

            for(Account a:deserializedAcc){
                if (accountNo1==a.getAccountNo()){
                    debit(amount,accountNo1);
                    a.setDatetime(LocalDateTime.now());
                }
                if(accountNo2==a.getAccountNo()){
                    credit(amount,accountNo2);
                    a.setDatetime(LocalDateTime.now());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
