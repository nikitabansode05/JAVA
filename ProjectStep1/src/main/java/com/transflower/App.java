package com.transflower;

import com.transflower.Entity.QuestionBank;
import com.transflower.Repository.FileIO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        QuestionBank question1=new QuestionBank(1,"What is Java","language","cafe","religion","city",'a',3);
        System.out.println("Object created");
        FileIO.serialize(question1);
        System.out.println("Object Serialized");

        //FileIO.Deserialize(jsonString);
    }
}
