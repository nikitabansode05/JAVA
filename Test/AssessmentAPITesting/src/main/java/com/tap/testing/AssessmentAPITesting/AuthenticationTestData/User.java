package com.tap.testing.AssessmentAPITesting.AuthenticationTestData;

public class User {
    private String email;
    private String password;

    public User(){
        email=null;
        password=null;
    }

    public User(String email,String password){
        this.email=email;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}

