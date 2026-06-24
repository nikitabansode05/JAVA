package com.banking.transaction.uiManagers;

import java.util.List;
import java.util.Scanner;

import com.banking.transaction.accountManagers.ITransactionService;
import com.banking.transaction.accountManagers.TransactionServiceImpl;
import com.banking.transaction.entities.Operation;
import com.banking.transaction.transactionManagers.AccountDepartment;


public class Menu {

    Scanner sc=new Scanner(System.in);

    public int getMenu(){
        int choice=0;
        System.out.println("********************************************");
        System.out.println("1)Show Balance");
        System.out.println("2)Credit");
        System.out.println("3)Debit");
        System.out.println("4)Transfer");
        System.out.println("5)Create account");
        System.out.println("6)Get Statement");
        System.out.println("7)Apply Interest");
        System.out.println("8)Apply Interest to all");
        System.out.println("9)Exit");
        System.out.println("********************************************");
        System.out.println("Enter your choice :");
        choice=sc.nextInt();

        return choice;
    }

    public void menuOperation(){
        int choice=0;
        int amount;
        int accountNo;
        int interest;
        ITransactionService operation=new TransactionServiceImpl();

        do { 
            getMenu();
            choice=sc.nextInt();

            switch(choice){
                case 1 :
                    {
                        accountNo=getAccountNo();
                        operation.getAccountDetails(accountNo);
                    }
                    
                    break;
                case 2 :
                    {
                        amount=getAmount();
                        accountNo=getAccountNo();
                        operation.credit(amount,accountNo);
                    }
                    break;
                case 3:
                    {
                        amount=getAmount();
                        accountNo=getAccountNo();
                        operation.debit(amount,accountNo);
                    }
                    break;
                case 4:
                    {
                        amount=getAmount();
                        System.out.println("Enter the account number to debit from : ");
                        int acc1=sc.nextInt();
                        System.out.println("Enter the account number to credit  : ");
                        int acc2=sc.nextInt();
                        operation.transation(acc1, acc2, amount);
                    }
                    break;
                case 5:
                    {
                        operation.createAccount();
                    }
                    break;
                case 6:
                    {
                        accountNo=getAccountNo();
                        List<Operation> operationList=operation.getStatement(accountNo);
                        System.out.print(operationList);
                    }
                    break;

                case 7:
                {
                    accountNo=getAccountNo();
                    interest=getInterest();
                    double totalInterest= operation.applyInterest(accountNo,interest);
                    System.out.println(totalInterest);
                }

                break;
                case 8:
                {
                    interest=getInterest();
                    operation.applyInteresttoAll(interest);
                }

                default:
                    System.out.println("Byeeee!!!!");
                    break;
            }
        } while (choice!=9);

    }

    public int getAccountNo(){
        System.out.println("Enter the account number : ");
        int accountNo=sc.nextInt();
        return accountNo;
    }

    public int getAmount(){
        System.out.println("Enter the amount number : ");
        int amount=sc.nextInt();
        return amount;
    }

    public int getInterest(){
        System.out.println("Enter the interest percent : ");
        int interest=sc.nextInt();
        return interest;
    }

    public void debitUI(){
        AccountDepartment accountOperation=new AccountDepartment();
        double amount=getAmount();
        int accountNo=getAccountNo();
        accountOperation.debit(amount,accountNo);
    }

    public void creditUI(){
        AccountDepartment accountOperation=new AccountDepartment();
        double amount=getAmount();
        int accountNo=getAccountNo();
        accountOperation.credit(amount,accountNo);
    }

    public void getAccountDetailUI(){
        AccountDepartment accountOperation=new AccountDepartment();
        int accountNo=getAccountNo();
        accountOperation.showAccountDetails(accountNo);
    }

    public void fundTransferUI(){
        AccountDepartment accountOperation=new AccountDepartment();
        double amount=getAmount();
        System.out.println("Enter the account number to debit from : ");
        int acc1=sc.nextInt();
        System.out.println("Enter the account number to credit  : ");
        int acc2=sc.nextInt();
        accountOperation.transation(acc1, acc2, amount);
    }

    public void applyInterest(){
        AccountDepartment accountOperation=new AccountDepartment();
        int accountNo=getAccountNo();
        double interest=getInterest();
        double totalInterest= accountOperation.applyInterest(accountNo,interest);
        System.out.println(totalInterest);
    }

    public void printStatement(){
        AccountDepartment accountOperation=new AccountDepartment();
        int accountNo=getAccountNo();
        List<Operation> operationList=accountOperation.getStatement(accountNo);
        System.out.print(operationList);
    }

    public void applyInterestToAll(){
        AccountDepartment accountOperation=new AccountDepartment();
        double interest=getInterest();
        accountOperation.applyInteresttoAll(interest);
    }

    public void createAccount(){
        AccountDepartment accountOperation=new AccountDepartment();
        accountOperation.createAccount();
    }
}
