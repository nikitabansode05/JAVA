package com.tap.assesment.Repository;

import java.util.*;
import com.tap.assesment.Entity.*;
import com.tap.assesment.UI.*;

public class QuestionBank {
    private ArrayList<Question> questions=new ArrayList<Question>();
    UIManager ui=new UIManager();

    public void CreateQuestion(){

        Scanner sc=new Scanner(System.in);
        Question question=new Question();

        System.out.println("Enter id : ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the question you want to create :");
        String quest=sc.nextLine();
        System.out.println("Enter the option A : ");
        String a=sc.nextLine();
        System.out.println("Enter the option B : ");
        String b=sc.nextLine();
        System.out.println("Enter the option C : ");
        String c=sc.nextLine();
        System.out.println("Enter the option D : ");
        String d=sc.nextLine();
        System.out.println("Enter the correct option : ");
        char option=sc.next().charAt(0);
        sc.nextLine();
        System.out.println("Enter the subject : ");
        String sub=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the marks per question : ");
        int marks=sc.nextInt();


        question.setId(id);
        question.setTitle(quest);
        question.setOptionA(a);
        question.setOptionB(b);
        question.setOptionC(c);
        question.setOptionD(d);
        question.setCorrectAnswer(option);
        question.setSubject(sub);
        question.setEvaluationCriteria(marks);
        
        questions.add(question);
    }

    public void updateQuestion(int id){
        
    }

    public void deleteQuestion(int id){

    }

    public void readAllQuestion(){
        for(Question q:questions){
            System.out.println(q.getId()+") "+q.getTitle()+" a) "+q.getOptionA()+" b) "+q.getOptionB()+" c) "+q.getOptionC()+" d)"+q.getOptionD()+" Correct answer : "+q.getCorrectAnswer()+" Marks :"+q.getEvaluationCriteria());
        }
       
    }
}
