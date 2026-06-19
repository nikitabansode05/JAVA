package com.banking.app.services;

public class Email implements Notification{
    @Override
    public void withdrawNotification(){
        System.out.println("Email:The money has been withdrawed");
    }

    @Override
    public void depositNotification(){
        System.out.println("Email:The money has been deposited");
    }
}
