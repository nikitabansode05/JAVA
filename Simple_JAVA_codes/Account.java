import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class Account {
    private double balance;
    
    Account(){
        balance=1000;
    }

    Account(int bal){
        balance=bal;
    }

    public double getbalance(){
        return balance;
    }
    
    public void setbalance(double balance){
        this.balance=balance;
    }

    public void withdraw(double money){
       this.balance=balance-money;
    }

    public void deposit(double money){
        this.balance=balance+money;
    }

    public void display(Account a){
        System.out.println("The balance in the account is : "+a.getbalance());
    }

    public Date joinDate(){
        Calendar calendar= Calendar.getInstance();
        calendar.set(2005,Calendar.OCTOBER,5);
        Date d1=calendar.getTime();
        return d1;
    }

    public static void main(String []args){
        Account a1=new Account();
        System.out.println("Welcome to Central Bank of India");
        a1.deposit(500);
        a1.display(a1);  
    }
}

