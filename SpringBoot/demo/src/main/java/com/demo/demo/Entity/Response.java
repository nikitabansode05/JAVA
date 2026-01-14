package com.demo.demo.Entity;

public class Response {
    private int id;
    private String username;
    private String email;

    public Response(){
        id=0;
        username=null;
        email=null;
    }

    public Response(int id,String username,String email){
        this.id=id;
        this.username=username;
        this.email=email;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public void setName(String name){
        this.username=name;
    }
    public String getName(){
        return username;
    }

    public void setMail(String email){
        this.email=email;
    }
    public String getMail(){
        return email;
    }

}
