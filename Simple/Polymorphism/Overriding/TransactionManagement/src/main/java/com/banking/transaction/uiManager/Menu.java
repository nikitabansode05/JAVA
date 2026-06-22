package com.banking.transaction.uiManager;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.banking.transaction.entities.Account;
import com.banking.transaction.services.ITransactionService;
import com.banking.transaction.services.TransactionServiceImpl;

public class Menu {
    public void getMenu(){
        System.out.println("********************************************");
        System.out.println("1)Show Balance");
        System.out.println("2)Credit");
        System.out.println("3)Debit");
        System.out.println("4)Transfer");
        System.out.println("5)Create account");
        System.out.println("6)Exit");
        System.out.println("********************************************");
        System.out.println("Enter your choice :");
    }

    public void menuOperation(){
        int choice=0;
        Account a1=new Account(101,"Nikita Bansode",8000.00,LocalDateTime.now());
        Account a2=new Account(102,"Tanya",7000.00,LocalDateTime.now());
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
                default:
                    System.out.println("Byeeee!!!!");
                    break;
            }
        } while (choice!=6);

    }
}
