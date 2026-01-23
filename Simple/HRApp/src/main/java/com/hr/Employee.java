package com.hr;

public abstract class Employee {
    int id;
    String firstName;
    String lastName;
    String email;
    long contactNumber;
    String location;
    String birthDate;

    Employee(int id,String firstName,String lastName,String email,long contactNumber,String location,String birthDate){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.contactNumber=contactNumber;
        this.location=location;
        this.birthDate=birthDate;
    }


    public abstract void doWork();

    public abstract int computePay();

    @Override
    public String toString(){
        return("Id :"+id+" "+"Name :"+firstName+" "+lastName+" "+
               "Email :"+email+"Contact Number :"+contactNumber+"Location :"+location+
                "Birth Date :"+birthDate);
    }
}
