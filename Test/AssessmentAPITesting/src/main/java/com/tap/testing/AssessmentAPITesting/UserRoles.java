package com.tap.testing.AssessmentAPITesting;

public class UserRoles {
    private int id;
    private int userId;
    private int roleId;
    private Role role;

    public UserRoles(){
        id=0;
        userId=0;
        roleId=0;
        role=null;
    }

    // Getter & Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter & Setter for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter & Setter for roleId
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role=role;
    }

}
