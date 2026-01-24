package com.hr;

import com.hr.Interface.IInterviewPanel;
import com.hr.Interface.IManagerBenefits;
import com.hr.Interface.ITrainer;

public class SalesManager extends SalesEmployee implements IManagerBenefits,IInterviewPanel,ITrainer{

    private int bonus;

    public SalesManager(){
        
    }

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

    @Override
    public void approveLeave(){
        System.out.println("This is approve leave from SalesManager Inherited from IManagerBenefits");
    }

    @Override
    public void takeInterview(){
        System.out.println("Take Interview function from Sales Manager inherited from IInterview");
    }

    @Override
    public void train(){
        System.out.println("Train function from sales Manager inherited from ITrainer");
    }

    @Override
    public float calculateBonus(){
        System.out.println("Calculate Bonus from manager doesnt directly inherit from IBonusEligible");
        return (float) 0.2;
    }

    
}