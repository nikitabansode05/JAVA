/*Question: Student Marks Analysis System

Write a Java program that uses a 2D array to store marks of students and performs multiple operations.

Requirements:

Create a 2D integer array where:
Rows represent students
Columns represent subjects
Example: 3 students and 4 subjects
Initialize the array with marks (hardcoded).
For each student, do the following:
Use a for loop to calculate the total marks
Use typecasting to calculate the average marks (decimal value)
Use if–else to decide:
Average ≥ 75 → "Distinction"
Average ≥ 60 → "First Class"
Average ≥ 40 → "Pass"
Else → "Fail"
Use a String array to store grades for each student.
Use the Math class to:
Find the highest total marks among all students
Find the lowest total marks
Use a boolean variable to check if any student has failed.
Use a while loop to display a menu:
1 → Display all student marks in table format
2 → Display total, average, and grade of each student
3 → Display highest and lowest scorer
4 → Exit
Use a switch statement to handle menu choices.
Use break to exit the loop and continue where appropriate.*/

public class StudentMarks {
    public static void main(String[] args){
        int[][] studentMarks={{45,76,12,78},{34,87,9,34},{34,67,98,23}};
        int sum=0;
        double average;
        double [] maxmin={0,0,0,0};
        String[] grade={"A","B","C","D"};

        for(int i=0;i<3;i++){   //rows
            for (int j=0;j<4;j++){ //columns
                System.out.println("Marks of student "+(i+1)+ " is : "+studentMarks[i][j]);   
                sum=sum+studentMarks[i][j]; 
            }
             average=(double)sum/4;
             maxmin[i]=average;

             System.out.println("The average marks of student "+(i+1)+" is : "+average);
             if(average>=75){
                grade[i]="A";
                System.out.println("Distinction!!"+" Grade : "+grade[i]);  
             }else if(average>=60){
                grade[i]="B";
                System.out.println("First Class!!"+" Grade : "+grade[i]);  
             }else if(average>=40){
                grade[i]="C";
                System.out.println("Pass!!"+" Grade : "+grade[i]);
             }else{
                grade[i]="D";
                System.out.println("Fail!!"+" Grade : "+grade[i]);
             }
             sum=0;
            System.out.println("\n");
           
        }

    }
}
