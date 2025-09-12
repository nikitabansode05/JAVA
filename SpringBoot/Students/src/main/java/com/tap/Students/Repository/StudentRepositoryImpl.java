package com.tap.students.Repository;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Repository;

import com.tap.students.Entity.Student;

@Repository
public class StudentRepositoryImpl implements IStudentRepository {

    private static Connection conn;
    private static Statement st;
    private static PreparedStatement ps;
    private List<Student> stu=new ArrayList<>();
    private List<String> students=new ArrayList<>();
    
    static {
        try (InputStream input = StudentRepositoryImpl.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties props = new Properties();
            props.load(input);
        
            String url = props.getProperty("db.url");
            String name = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            String driver = props.getProperty("db.driver");
            Class.forName(driver);
            conn=DriverManager.getConnection(url,name,password);
            st=conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean create(String name,String email){
       try{
            //st.executeUpdate("insert into students(name,email) values('Anant Ambani','anant@gmail.com')");
            ps=conn.prepareStatement("insert into students(name,email) values(?,?)");
            ps.setString(1,name);
            ps.setString(2,email);
            ps.executeUpdate();

            return true;
       }catch(Exception e){
        System.out.println(e);
        return false;
       }   
    }
   
    @Override
    public boolean update(String name,int id){
        try{
            //st.executeUpdate("update students set name='Mukesh' where id=4");
            ps=conn.prepareStatement("update students set name=? where id=?");
            ps.setString(1,name);
            ps.setInt(2,id);
            ps.executeUpdate();

            return true;
        }catch(Exception e){
            System.out.println(e);

            return false;
        }
    } 

    @Override
    public boolean delete(int id){
        try{
            //st.executeUpdate("delete from students where id=4");
            ps=conn.prepareStatement("delete from students where id=?");
              ps.setInt(1,id);
            ps.executeUpdate();

            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }    
    }

    @Override
    public List<String> display(){
        try{
            ResultSet rs=st.executeQuery("select * from students");
            while(rs.next()){
               students.add(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return students;
    }

    @Override
    public Student getById(int id){
        try{
             ResultSet rs=st.executeQuery("select * from students");
        while(rs.next()){
            int id1=rs.getInt(1);
            String name1=rs.getString(2);
            String email=rs.getString(3);   
            stu.add(new Student(id1,name1,email));
        }     
        for(Student student:stu){
            if(student.getID()==id){
                return student;
            }
        }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
