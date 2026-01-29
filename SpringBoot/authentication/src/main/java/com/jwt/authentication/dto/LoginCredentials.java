package com.jwt.authentication.dto;

public class LoginCredentials {
    private String username;
    private String role;

    public void setName(String username){
        this.username=username;
    }

    public String getName(){
        return username;
    }

    public void setRole(String role){
        this.role=role;
    }

    public String getRole(){
        return role;
    }
}
