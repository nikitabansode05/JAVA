package com.tap.testing.AssessmentAPITesting;


import static org.hamcrest.CoreMatchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
// import tools.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;


public class AuthControllerTest {
    
    @Test
    public void loginTest(){
        RestAssured.baseURI="http://localhost:5238";
        ObjectMapper mapper=new ObjectMapper();
        List<User> userList=new ArrayList<User>();
       
        System.out.println("***************************************************************************************");
        try {
                    userList = mapper.readValue(
                    new File("src/main/resources/loginSample.json"),
                    new TypeReference<List<User>>() {}
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        
            
            for(User u : userList) {
                System.out.println(u.getEmail()+ " " + u.getPassword());
                System.out.println("***************************************************************************************");
            
            // String loginCredentials= """
            //     {
            //         "email":userList.get(i.getEmail()),
            //         "password":userList.get(i.getPassword())
            //     }
            //     """;

            // String loginCredentials= """
            //     {
            //         "email":"nikita.bansode@example.com",
            //         "password":"12345"
            //     }
            //     """;
            String loginCredentials = """
                {
                    "email":"%s",
                    "password":"%s"
                }
                """.formatted(u.getEmail(), u.getPassword());

            System.out.println(loginCredentials);

            given()
                .contentType(ContentType.JSON)
                .body(loginCredentials)
            .when()
                .post("api/auth/login")
            .then()
            .statusCode(200);
            // .body("user.email",equalTo(sample.email));
            // .body("user.firstname",equalTo("nikita"))
            // .body("user.lastname",equalTo("bansode"))
            // .body("user.id",equalTo(7))
            // .body("user.userRoles[0].role.name",equalTo("student"));
        }
    
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
