package com.hr;

import com.hr.Interface.IAppraisable;

public class SalesEmployee extends Employee implements IAppraisable{

    int incentive;
    int target;
    int achievedTarget;
    int basicSalary;
    int hra;

    public SalesEmployee(){

    }
    
    public SalesEmployee(int id, String firstName, String lastName, String email, long contactNumber, String location, String birthDate,
                        int incentive,int target,int achievedTarget,int basicSalary,int hra
    ) {
        super(id, firstName, lastName, email, contactNumber, location, birthDate);
        this.incentive=incentive;
        this.target=target;
        this.achievedTarget=achievedTarget;
        this.basicSalary=basicSalary;
        this.hra=hra;

    }

    @Override
    public void doWork(){
        System.out.println("Do work function overrided inside SalesEmployee class");
    }

    @Override
    public int computePay(){
        System.out.println("The computePay is called from child class");
        int salary=this.basicSalary+this.hra;

        if(achievedTarget>=target){
        salary=salary+incentive;
        return salary;
        }

        return salary;
    }

    @Override
    public void conductAppraisal() {
        System.out.println("Conducting appraisal for Sales Employee: "+ this.firstName + " " + this.lastName);
    }
}
