/*  Write a Java program that:

 Declares two variables
 one int with value 10
 one double with value 5.5
 Typecasts the double value into an int and stores it in a new variable
 Uses operators to calculate and print:
 sum
 multiplication
 Uses an if-else statement to check:
 if the sum is greater than 20, print "Big Number"
 else print "Small Number"

 Topics covered:
 ✔ variable
 ✔ datatype
 ✔ typecasting
 ✔ if–else*/

 public class BasicMath{
   private static int num1=10;
   private static double num2=5.5;

    public static void main(String[] args) {

        int castedNum=(int)num2;

        int sum=num1+castedNum;
        System.out.println(sum);
        int multiplication=num1*castedNum;
        System.out.println(multiplication);

        if(sum>20){
            System.out.println("Big Number"); 
        }else{
            System.out.println("Small Number");
        }
    }

 }