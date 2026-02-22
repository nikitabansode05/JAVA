package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.hibernate.Entity.Student;
import com.example.hibernate.Util.HibernateUtil;


public class App 
{
    public static void main( String[] args )
    {
        try{
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        //create
        Student s = new Student("Ivor");
        session.save(s);

        //read
        Student student = session.get(Student.class,1);
        System.out.println(student.getName());

        //update
        student.setName("Chunky");
        session.update(student);

        //delete
        session.delete(student);

        tx.commit();
        session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
