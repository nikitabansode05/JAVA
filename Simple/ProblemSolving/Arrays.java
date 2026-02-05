/*Write a Java program that simulates a simple menu-driven calculator:

Use a String variable to store the user’s name and print a welcome message
Use a switch statement to choose an operation:
1 → Addition
2 → Subtraction
3 → Multiplication
4 → Division
Store two numbers in variables (int)
Use typecasting to ensure division gives a decimal result
Use Math class to:
find the maximum of the two numbers
Use a while loop to allow the user to perform calculations until they choose to exit
Use if-else to:
prevent division by zero
Store the results of each calculation in an array
After exiting, print all stored results using a for loop
*/
import java.util.*;

public class Arrays {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String userName;
        int takeNum;
        int num1;
        int num2;

        System.out.println("Enter Username : ");
        userName=input.nextLine();
        System.out.println("*********WELCOME"+" "+userName+"**********");

        System.out.println("Enter the num 1 : ");
        num1=input.nextInt();
        System.out.println("Enter the num 2 : ");
        num2=input.nextInt();

        int maxNo=Math.max(num1,num2);
        System.out.println("The maximun no is : "+maxNo);

        double[] result={0,0,0,0};

        do{
            System.out.println("Enter your choice\n"+"1) Addition\n"+"2)Subtraction\n"+"4)Multiplication\n"+"4)Division\n"+"5)Exit");
            takeNum=input.nextInt();

        switch(takeNum){
            case 1:
                {
                    double sum=(double)num1+num2;
                    System.out.println("The addition is : "+sum);
                    result[0]=sum;
                }
                break;
            case 2:
                {
                    double sub=(double)num1-num2;
                    System.out.println("The subtraction is : "+sub);
                    result[1]=sub;
                }
                break;
            case 3:
                {
                    double mul=(double)num1*num2;
                    System.out.println("The multiplication is : "+mul);
                    result[2]=mul;
                }
                break;
            case 4:
                {
                    if(num2!=0){
                        double div=(double)num1/num2;
                        System.out.println("The division is : "+div);
                        result[3]=div;
                    }else{
                        System.out.println("Can't divide by zero");
                    }
                   
                }
                break;
            default:
                {
                 System.out.println("Byeeeeee!!");
                 for(int i=0;i<result.length;i++){
                 System.out.println("Result is : "+result[i]);
                 }
                }
               
                break;
        }
    }while(takeNum!=5);
}
}
