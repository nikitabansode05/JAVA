package com.tap.testing.AssessmentAPITesting;


import static org.hamcrest.CoreMatchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class AuthControllerTest {
    
    @Test
    public void loginTest(){

        RestAssured.baseURI="http://localhost:5238";

        String loginCredentials= """
                {
                    "email":"nikita.bansode@example.com",
                    "password":"12345"
                }
                """;
        given()
            .contentType(ContentType.JSON)
            .body(loginCredentials)
        .when()
            .post("api/auth/login")
        .then()
         .statusCode(200)
        .body("user.email",equalTo("nikita.bansode@example.com"))
        .body("user.firstname",equalTo("nikita"))
        .body("user.lastname",equalTo("bansode"))
        .body("user.id",equalTo(7))
        .body("user.userRoles[0].role.name",equalTo("student"));
    }

    @Test
    public void registerTest(){
        String registerUser="""
                   
                {
                "aadharId":"989876765454",
                "firstname":"ui",
                "lastname":"ux",
                "email":"ui.ux@gmail.com",
                "contactNumber":"8907654321",
                "password":"12345"
}
                """;
        given()
            .contentType(ContentType.JSON)
            .body(registerUser)
        .when()
            .post("api/auth/register")
        .then()
            .statusCode(200)
            .body("message",equalTo("User registered successfully!"))
            .log().all(); 
    }
}
