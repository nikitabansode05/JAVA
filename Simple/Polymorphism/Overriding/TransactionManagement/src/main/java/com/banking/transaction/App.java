package com.banking.transaction;

import com.banking.transaction.uiManager.Menu;

import java.util.Scanner;

import com.banking.transaction.entities.Account;
import com.banking.transaction.services.ITransactionService;
import com.banking.transaction.services.TransactionServiceImpl;

public class App {
    public static void main(String[] args) {
        Menu menu=new Menu();
        int choice=0;
        Account a1=new Account(101,"Nikita Bansode",8000.00);
        Account a2=new Account(102,"Tanya",7000.00);
        int amount;
        Scanner sc=new Scanner(System.in);
        ITransactionService operation=new TransactionServiceImpl();

        
        do { 
            menu.getMenu();
            choice=sc.nextInt();

            switch(choice){
                case 1 :
                    System.out.println(a1.getBalance());
                    break;
                case 2 :
                    {
                        System.out.println("Enter amount to credit : ");
                        amount=sc.nextInt();
                        operation.credit(a1, amount);
                    }
                    break;
                case 3:
                    {
                        System.out.println("Enter amount to debit : ");
                        amount=sc.nextInt();
                        operation.debit(a1, amount);
                    }
                    break;
                case 4:
                     {
                        System.out.println("Enter amount to transfer : ");
                        amount=sc.nextInt();
                        operation.transation(a1, a2, amount);
                    }
                    break;
                default:
                    System.out.println("Byeeee!!!!");
                    break;
            }
        } while (choice!=5);
    }
}
