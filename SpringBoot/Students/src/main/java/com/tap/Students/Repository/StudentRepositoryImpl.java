package com.tap.Students.Repository;

import java.sql.*;

//import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;

import com.tap.Students.Entity.Student;


public class StudentRepositoryImpl implements IStudentRepository {

    private static String password;
    private static String name;
    private static String url;
    private static Connection conn;
    private static Statement st;

    static{
        try{
             password="password";
             name="root";
             url="jdbc:mysql://localhost:3306/tap";
             Connection conn= DriverManager.getConnection(url,name,password);
             Statement st=conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }

    public StudentRepositoryImpl(){
        Student stu=new Student();
    }

    public StudentRepositoryImpl(Student stu){
        Student student= stu;
    }

    public void create(){
       try{
            st.executeUpdate("insert into students value('Anant Ambani','anant@gmail.com')");
       }catch(Exception e){
        System.out.println(e);
       }   
    }

    public void update(){
        try{
            st.executeUpdate("update students name='Mukesh' where id=4");
        }catch(Exception e){
            System.out.println(e);
        }
        
    } 

    public void delete(){
        try{
            st.executeUpdate("delete from students where id=4");
        }catch(Exception e){
            System.out.println(e);
        }    
    }

    public void display(){
        try{
            st.executeQuery("select * from students");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public Student getById(int id){
      Student stu=new Student();
      return stu;
    }
}
