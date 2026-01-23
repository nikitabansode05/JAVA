package com.hr;

public class SalesManager extends SalesEmployee{

    private int bonus;

    public SalesManager(int id, String firstName, String lastName, String email, long contactNumber, String location,
            String birthDate, int incentive, int target, int achievedTarget, int basicSalary, int hra,int bonus) {
        super(id, firstName, lastName, email, contactNumber, location, birthDate, incentive, target, achievedTarget,
                basicSalary, hra);
        this.bonus=bonus;
    }
    
    @Override
   public void doWork(){
    System.out.println("Do work invoked from Sales Manager Class");
   }

   @Override
   public int computePay(){
    return (super.computePay()+bonus);
}
}