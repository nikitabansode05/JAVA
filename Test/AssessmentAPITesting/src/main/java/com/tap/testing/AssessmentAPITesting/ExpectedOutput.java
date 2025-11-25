package com.tap.testing.AssessmentAPITesting;

import java.util.List;

public class ExpectedOutput {
    private int id;
    private String aadharId;
    private String firstname;
    private String lastname;
    private String email;
    private String contactNumber;
    private String password;
    private List<UserRoles> userRoles;

    public ExpectedOutput() {
        id=0;
        aadharId=null;
        firstname=null;
        lastname=null;
        email=null;
        contactNumber=null;
        password=null;
        userRoles=null;
    }

    // Getter & Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter & Setter for aadharId
    public String getAadharId() {
        return aadharId;
    }

    public void setAadharId(String aadharId) {
        this.aadharId = aadharId;
    }

    // Getter & Setter for firstname
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Getter & Setter for lastname
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Getter & Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter & Setter for contactNumber
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Getter & Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    // Getter & Setter for userRole
    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRole) {
        this.userRoles = userRole;
    }

}
