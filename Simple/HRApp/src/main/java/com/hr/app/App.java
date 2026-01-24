package com.hr.app;
import com.hr.Employee;
import com.hr.Interface.IAppraisable;
import com.hr.SalesEmployee;
import com.hr.SalesManager;

public class App{

    public static void main(String[] args){
   
        Employee Sansa=new SalesEmployee(1,"Sansa","Stark","sansa@gmail.com",1524367890,"WinterFell","2001-23-09",100,200,3000,4000,409);
        Employee Nikita=new SalesManager(1, "Nikita", "Bansode", "nikita@email.com", 123645789,"Pune" , "2005-10-05", 1000,20000, 203990,39000, 1020, 3420);
   
        Sansa.doWork();
        Nikita.doWork();   
        System.out.println(Sansa.computePay());
        System.out.println(Nikita.computePay());

        SalesManager Mrunmayee=new SalesManager();
        IAppraisable appraisable=Mrunmayee;

        Mrunmayee.approveLeave();
        appraisable.conductAppraisal();
        appraisable.train();
        // appraisable.takeInterview();
        }
}

