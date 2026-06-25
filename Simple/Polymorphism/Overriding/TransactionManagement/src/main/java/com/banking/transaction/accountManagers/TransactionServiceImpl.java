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
    public double applyInterest(int accountNo,double interest){
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
        LocalDateTime startDateTime = getLog.get(i).getDatetime();
        LocalDateTime endDateTime =getLog.get(i+1).getDatetime();
        LocalDate startDate = startDateTime.toLocalDate();
        LocalDate endDate = endDateTime.toLocalDate();
        double addInterest = interestCalculation(startDate,endDate,interest,getLog.get(i).getBalance());        
        interests.add(addInterest);
       }

       double getBalance=0;
       int getIndex=getLog.size()-1;
       LocalDateTime lastTransactionDate=getLog.get(getIndex).getDatetime();

       System.out.println(lastTransactionDate);

       for(Account a:accountList){
        if(a.getAccountNo()==accountNo){
            getBalance=a.getBalance();
        }
       }

       double interestTillCurrentDate=interestCalculation(lastTransactionDate.toLocalDate(),LocalDate.now(),interest,getBalance);
    
       for(int i=0;i<=interests.size()-1;i++){
        totalinterest+=interests.get(i);
       }

       totalinterest+=interestTillCurrentDate;
       System.out.println("total interest after :"+totalinterest);

       double newBalance=getBalance+=totalinterest;
       System.out.println("The balance after appling interest :"+newBalance);
       return totalinterest;
    }

    @Override
    public double interestCalculation(LocalDate fromdate,LocalDate todate,double interest,double balance){
        long days = ChronoUnit.DAYS.between(fromdate, todate);
        double principleAmount=balance;
        double base=1+((interest/100)/365);
        double power=days;
        double calculateBasePower=Math.pow(base, power);
        double finaAmount= principleAmount*(calculateBasePower);
        double calculatedInterest = finaAmount-principleAmount; 
        return calculatedInterest;
    }

    @Override 
    public void applyInteresttoAll(double interest){

        accountList=fileIO.deserializeAccount();
        List<Integer> accNo=new ArrayList<Integer>();

        for(Account a: accountList){
            accNo.add(a.getAccountNo());
        }

        for(int i:accNo){
            calculateInterest(i, interest);
        }
    }

    public void applyInterestToSteadyAccount(int accountNo,int interest){
        accountList=fileIO.deserializeAccount();
        double calculatedInterest=0;
        double balance=0;
        for(Account a:accountList){
            if(a.getAccountNo()==accountNo){
                LocalDate startDate=a.getDatetime().toLocalDate();
                LocalDate currentDate=LocalDate.now();
                calculatedInterest=interestCalculation(startDate,currentDate,interest,a.getBalance());
                balance=a.getBalance()+calculatedInterest;
            }
        }
    }

}

