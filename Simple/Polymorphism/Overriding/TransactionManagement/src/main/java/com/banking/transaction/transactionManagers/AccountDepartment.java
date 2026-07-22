package com.banking.transaction.transactionManagers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

import com.banking.transaction.entities.Account;
import com.banking.transaction.entities.Operation;
import com.banking.transaction.listeners.AccountListener;
import com.banking.transaction.listeners.AccountListenerImpl;
import com.banking.transaction.repositories.OperationFileManager.OperationsFileIO;
import com.banking.transaction.repositories.OperationFileManager.OperationsFileIOImpl;
import com.banking.transaction.repositories.accountFileManager.AccountFileIO;
import com.banking.transaction.repositories.accountFileManager.AccountFileIOImpl;
import com.banking.transaction.transactionManagers.operations.IAccountOperation;
import com.banking.transaction.transactionManagers.operations.IDepositOperation;
import com.banking.transaction.transactionManagers.operations.IWithdrawOperation;
import com.banking.transaction.transactionManagers.operations.IFundTransfer;
import com.banking.transaction.transactionManagers.operations.IInterestOperation;

public class AccountDepartment implements IDepositOperation,IWithdrawOperation,IAccountOperation,IFundTransfer,IInterestOperation{

    @Override 
    public boolean credit(double amount,int accountNo){
        AccountFileIO accountFile=new AccountFileIOImpl();
        OperationsFileIO operationsFile=new OperationsFileIOImpl();
        AccountListener listener=new AccountListenerImpl();
       
        try{
            List<Account> accountList=accountFile.deserializeAccount();
            List<Operation> operations=operationsFile.deserializeOperation();
            for(Account a:accountList){
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
            accountFile.serializeAccount(accountList);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean debit(double amount,int accountNo){
        AccountFileIO accountFile=new AccountFileIOImpl();
        OperationsFileIO operationsFile=new OperationsFileIOImpl();
        AccountListener listener=new AccountListenerImpl();

        try{
            List<Account> accountList=accountFile.deserializeAccount();
            List<Operation> operations=operationsFile.deserializeOperation();
            for(Account a:accountList){
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
            accountFile.serializeAccount(accountList);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void showAccountDetails(int accountNo){
        AccountFileIO accountFile=new AccountFileIOImpl();
        try{
            List<Account> accountList=accountFile.deserializeAccount();
            for(Account a:accountList){
            if(accountNo==a.getAccountNo()){
                System.out.println(a);
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean createAccount(){
        Scanner sc=new Scanner(System.in);
        AccountFileIO accountFile=new AccountFileIOImpl();
        List<Account> accountList=accountFile.deserializeAccount();

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
            accountList=accountFile.deserializeAccount();
            accountList.add(account);
            accountFile.serializeAccount(accountList);
            return true;
        }catch(Exception e){
        e.printStackTrace();
        return false;
      }
    }

    @Override
    public List<Operation> getStatement(int accountNo){
        OperationsFileIO operationsFile=new OperationsFileIOImpl();
        List<Operation> operations=operationsFile.deserializeOperation();
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
    public boolean transation(int accountNo1,int accountNo2,double amount){
        try{
            AccountFileIO accountFile=new AccountFileIOImpl();
            List<Account> accountList=accountFile.deserializeAccount();

            for(Account a:accountList){
                if (accountNo1==a.getAccountNo()){
                    debit(amount,accountNo1);
                }
                if(accountNo2==a.getAccountNo()){
                    credit(amount,accountNo2);
                }
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public double applyInterest(int accountNo,double interest){

        AccountFileIO accountFile=new AccountFileIOImpl();
        OperationsFileIO operationsFile=new OperationsFileIOImpl();
        List<Account> accountList=accountFile.deserializeAccount();
        List<Operation> operations=operationsFile.deserializeOperation();
        List<Operation> getLog=new ArrayList<Operation>();
        List<Double> interests=new ArrayList<Double>();
        double totalinterest=0;

        for(Operation o:operations){
            if(o.getAccountNo()==accountNo){
                getLog.add(o);
            }
        }

       for(int i=0;i<getLog.size()-1;i++){
        LocalDate startDate = getLog.get(i).getDatetime().toLocalDate();
        LocalDate endDate = getLog.get(i+1).getDatetime().toLocalDate();
        double addInterest = interestCalculation(startDate,endDate,interest,getLog.get(i).getBalance());        
        interests.add(addInterest);
       }

       if(getLog == null || getLog.isEmpty()){
            double accountInterest=applyInterestToAccountWithoutTransaction(accountNo, interest);
            credit(accountInterest,accountNo);
            return accountInterest;
        }

       double getBalance=0;
       int getIndex=getLog.size()-1;

        LocalDateTime lastTransactionDate=getLog.get(getIndex).getDatetime();

       for(Account a:accountList){
        if(a.getAccountNo()==accountNo){
            getBalance=a.getBalance();
        }
       }
    
       for(int i=0;i<=interests.size()-1;i++){
        totalinterest+=interests.get(i);
       }

       double interestTillCurrentDate=interestCalculation(lastTransactionDate.toLocalDate(),LocalDate.now(),interest,getBalance);
       totalinterest+=interestTillCurrentDate;
       System.out.println("total interest after :"+totalinterest);

       double newBalance=getBalance+=totalinterest;
       System.out.println("The balance after appling interest :"+newBalance);
       credit(totalinterest,accountNo);
       return totalinterest;
    }

    @Override
    public void applyInteresttoAll(double interest){  
        AccountFileIO accountFile=new AccountFileIOImpl();
        List<Account> accountList=accountFile.deserializeAccount();
        List<Integer> accNo=new ArrayList<Integer>();

        for(Account a: accountList){
            accNo.add(a.getAccountNo());
        }

        for(int i:accNo){
            applyInterest(i, interest);
        }
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

    public double applyInterestToAccountWithoutTransaction(int accountNo,double interest){
        AccountFileIO accountFile=new AccountFileIOImpl();
        List<Account> accountList=accountFile.deserializeAccount();
        double calculatedInterest=0;
        for(Account a:accountList){
            if(a.getAccountNo()==accountNo){
                LocalDate startDate=a.getDatetime().toLocalDate();
                LocalDate endDate=LocalDate.now();
                calculatedInterest=interestCalculation(startDate, endDate, interest, a.getBalance());
            }
        }

        return calculatedInterest;
    }

}
