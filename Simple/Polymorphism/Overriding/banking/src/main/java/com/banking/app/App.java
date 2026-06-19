package com.banking.app;

import com.banking.app.account.*;
import com.banking.app.services.Notification;
import com.banking.app.services.SMS;

public class App {
    public static void main(String[] args) {
       Notification sms=new SMS();
       Account account =new AccountImpl(8000,sms);

       account.withdraw(500);
       account.deposit(1000);
    }
}
