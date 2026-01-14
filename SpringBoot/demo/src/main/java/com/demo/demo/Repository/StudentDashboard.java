package com.demo.demo.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.demo.Entity.Response;

@Repository
public class StudentDashboard {
    
    private static Connection conn;

    static{
        try{
                String url="jdbc:mysql://localhost:3306/tap";
                String username="root";
                String password="password";

                conn=DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }

    public List< Response> getUserByRole(){
        String query="SELECT r.name AS role, COUNT(u.id) AS total_users " + 
                        "FROM users u " + 
                        "JOIN userroles ur ON u.id = ur.userid " + 
                        "JOIN roles r ON ur.roleid = r.id " + 
                        "GROUP BY r.name;";
        
        List<Response> listRes=new ArrayList<>();
        String query1="select * from students";
        try{
            Statement statement=conn.createStatement();
            ResultSet rs=statement.executeQuery(query1);
            
            while(rs.next()){
                Response res=new Response();
                res.setId(rs.getInt("id"));
                res.setName(rs.getString("name"));
                res.setMail(rs.getString("email"));
                listRes.add(res);
           }
        }catch(Exception e){
            e.printStackTrace();
        }
       return listRes;
    }
}
