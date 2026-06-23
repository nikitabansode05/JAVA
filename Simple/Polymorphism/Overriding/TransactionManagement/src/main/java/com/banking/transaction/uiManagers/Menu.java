package com.banking.transaction.uiManagers;

import java.util.List;
import java.util.Scanner;

import com.banking.transaction.accountManagers.ITransactionService;
import com.banking.transaction.accountManagers.TransactionServiceImpl;
import com.banking.transaction.entities.Operation;

public class Menu {
    public void getMenu(){
        System.out.println("********************************************");
        System.out.println("1)Show Balance");
        System.out.println("2)Credit");
        System.out.println("3)Debit");
        System.out.println("4)Transfer");
        System.out.println("5)Create account");
        System.out.println("6)Get Statement");
        System.out.println("7)Apply Interest");
        System.out.println("8)Exit");
        System.out.println("********************************************");
        System.out.println("Enter your choice :");
    }

    public void menuOperation(){
        int choice=0;
        int amount;
        Scanner sc=new Scanner(System.in);
        ITransactionService operation=new TransactionServiceImpl();

        do { 
            getMenu();
            choice=sc.nextInt();

            switch(choice){
                case 1 :
                    {
                        System.out.println("Enter the Account Number : ");
                        int accountNo=sc.nextInt();
                        operation.getAccountDetails(accountNo);
                    }
                    
                    break;
                case 2 :
                    {
                        System.out.println("Enter amount to credit : ");
                        amount=sc.nextInt();
                        System.out.println("Enter the account number : ");
                        int accountNo=sc.nextInt();

                        operation.credit(amount,accountNo);
                    }
                    break;
                case 3:
                    {
                        System.out.println("Enter amount to debit : ");
                        amount=sc.nextInt();
                        System.out.println("Enter the account number : ");
                        int accountNo=sc.nextInt();

                        operation.debit(amount,accountNo);
                    }
                    break;
                case 4:
                     {
                        System.out.println("Enter amount to transfer : ");
                        amount=sc.nextInt();
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
                        System.out.println("Enter the account number : ");
                        int accountNo=sc.nextInt();
                        List<Operation> operationList=operation.getStatement(accountNo);
                        System.out.print(operationList);
                    }
                    break;

                case 7:
                {
                    System.out.println("Enter the account number : ");
                    int accountNo=sc.nextInt();
                    System.out.println("Enter the interest percent : ");
                    int interest=sc.nextInt();
                    double balance= operation.calculateInterest(accountNo,interest);
                }

                    break;
                default:
                    System.out.println("Byeeee!!!!");
                    break;
            }
        } while (choice!=8);

    }
}
