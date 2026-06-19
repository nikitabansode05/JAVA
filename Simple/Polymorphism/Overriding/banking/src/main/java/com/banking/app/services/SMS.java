package com.banking.app.services;

public class SMS implements Notification{
    @Override
    public void withdrawNotification(){
        System.out.println("SMS:The money has been withdrawed");
    }

    @Override
    public void depositNotification(){
        System.out.println("SMS:The money has been deposited");
    }
}
