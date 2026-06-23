package com.banking.transaction.accountManagers;

import com.banking.transaction.entities.Account;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    List<Account> accountList=new ArrayList<Account>();
    List<Operation> operations=new ArrayList<Operation>();

    AccountFileIO fileIO=new AccountFileIOImpl();
    OperationsFileIO operationsFile=new OperationsFileIOImpl();
    AccountListener listener=new AccountListenerImpl();

    Scanner sc=new Scanner(System.in);

    public TransactionServiceImpl(){ }

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
                    Operation operation = new Operation(a.getAccountNo(),"debited",LocalDateTime.now(),amount,a.getBalance());
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
                    Operation operation = new Operation(a.getAccountNo(),"credited",LocalDateTime.now(),amount,a.getBalance());
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
        
        System.out.println("The transaction is successfull from account "+accountNo1+" to "+accountNo2);
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

    @Override
    public double calculateInterest(int accountNo,double interest){
        accountList=fileIO.deserializeAccount();
        operations=operationsFile.deserializeOperation();
        List<Operation> getLog=new ArrayList<Operation>();
        List<Double> interests=new ArrayList<Double>();
        double totalinterest=0;

        for(Operation o:operations){
            if(o.getAccountNo()==accountNo){
                getLog.add(o);
            }
        }

       for(int i=0;i<getLog.size()-1;i++){
        System.out.println("**********************************************************************************");
        LocalDateTime startDateTime = getLog.get(i).getDatetime();
        LocalDateTime endDateTime =getLog.get(i+1).getDatetime();

        LocalDate startDate = startDateTime.toLocalDate();
        LocalDate endDate = endDateTime.toLocalDate();

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Total Days :"+days);

        double principleAmount=getLog.get(i).getBalance();
        System.out.println("Principal Amount :"+principleAmount);

        double base=1+((interest/100)/365);
        System.out.println("base :"+base);

        double power=days;

        double calculateBasePower=Math.pow(base, power);
        System.out.println("base power : "+calculateBasePower);

        double amount= principleAmount*(calculateBasePower);
        System.out.println("amount : "+amount);

        double addInterest = amount-principleAmount;
        System.out.println("Add interest :"+addInterest);
        
        interests.add(addInterest);
       }

       for(int i=0;i<interests.size()-1;i++){
        totalinterest+=interests.get(i);
       }

       System.out.println("Total interest :"+totalinterest);
       System.out.println("***************************************************");

       return totalinterest;
    }

    @Override 
    public void ApplyInteresttoAll(double interest){

        accountList=fileIO.deserializeAccount();
        List<Integer> accNo=new ArrayList<Integer>();

        for(Account a: accountList){
            accNo.add(a.getAccountNo());
        }

        for(int i:accNo){
            calculateInterest(i, interest);
        }
    }
}


// import java.time.LocalDateTime;
// import java.time.temporal.ChronoUnit;

// public class Main {
//     public static void main(String[] args) {
//         LocalDateTime startDateTime = LocalDateTime.parse("2026-06-22T23:00:00");
//         LocalDateTime endDateTime = LocalDateTime.parse("2026-06-23T05:00:00");

//         // Approach A: Strict 24-hour duration (returns 0 because 24 hours haven't passed)
//         long strictDays = ChronoUnit.DAYS.between(startDateTime, endDateTime);

//         // Approach B: Calendar days (returns 1 because it spans into the next day)
//         long calendarDays = ChronoUnit.DAYS.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());

//         System.out.println("Strict 24-hour days: " + strictDays);
//         System.out.println("Calendar days: " + calendarDays);
//     }
// }