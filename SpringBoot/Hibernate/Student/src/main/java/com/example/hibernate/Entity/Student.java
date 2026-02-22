package com.example.hibernate.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Student(){}
    public Student(String name){
        this.name=name;
    }

    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id=id;
    }

    public String getName(){
       return this.name;
    }

    public void setName(String name){
        this.name=name;
    }
}