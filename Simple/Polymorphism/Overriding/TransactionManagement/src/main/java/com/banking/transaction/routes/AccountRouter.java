package com.banking.transaction.routes;

import com.banking.transaction.uiManagers.Menu;

public class AccountRouter{

    Menu menu=new Menu();

    public void accountMenuRouter(){
        int choice=0;
        do { 
            choice=menu.getMenu();

            switch(choice){
                case 1 :
                    {
                        menu.getAccountDetailUI();
                    }
                    
                    break;
                case 2 :
                    {
                        menu.creditUI();
                    }
                    break;
                case 3:
                    {
                       menu.debitUI();
                    }
                    break;
                case 4:
                    {
                        menu.fundTransferUI();
                    }
                    break;
                case 5:
                    {
                       menu.createAccountUI();
                    }
                    break;
                case 6:
                    {
                       menu.printStatementUI();
                    }
                    break;

                case 7:
                {
                   menu.applyInterestUI();
                }

                break;
                case 8:
                {
                    menu.applyInterestToAllUI();
                }

                default:
                    System.out.println("Byeeee!!!!");
                    break;
            }
        } while (choice!=9);

    }
}