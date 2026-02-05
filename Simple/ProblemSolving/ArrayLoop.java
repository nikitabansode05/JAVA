/*Write a Java program that:

Creates an array of integers: {3, 7, 10, 15, 20}

Uses a for loop to:
print each number
check using if-else whether the number is even or odd
If the number is 10, use continue to skip printing its type
If the number is 20, use break to stop the loop
Use a boolean variable to track whether any even number was found

After the loop, print:
"Even number found" or "No even number found"

Topics covered:
✔ arrays
✔ for loop
✔ if–else
✔ boolean
✔ break
✔ continue
✔ operators*/

public class ArrayLoop{

    public static void main(String[] args){
        int[] numbers={3,7,10,15,20};

        for(int i=0;i<=numbers.length;i++){
            if(numbers[i]%2==0){
                if(numbers[i]==10){
                    continue;
                } 
                if(numbers[i]==20){
                    break;
                }
                System.out.println("The number is even : "+numbers[i]);
            }
            else{
                System.out.println("The number is odd : "+numbers[i]);
            }
            
        }
    }
}