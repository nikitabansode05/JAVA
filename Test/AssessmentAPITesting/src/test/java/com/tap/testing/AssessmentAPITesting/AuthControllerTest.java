package com.tap.testing.AssessmentAPITesting;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;


public class AuthControllerTest {
    
    @Test
    public void loginTest(){
        RestAssured.baseURI="http://localhost:5238";
        ObjectMapper mapper=new ObjectMapper();
        List<User> userList=new ArrayList<User>();
        List<ExpectedOutput> loginOutput=new ArrayList<ExpectedOutput>();

        try {
                    userList = mapper.readValue(
                    new File("src/main/resources/loginSample.json"),
                    new TypeReference<List<User>>() {}
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        try{
            loginOutput=mapper.readValue(
                new File("src/main/resources/outputSample.json"),
                new TypeReference<List<ExpectedOutput>>() {}
            );
        }catch(Exception e){
            e.printStackTrace();
        }

            System.out.println("Size of loginOutput = " + loginOutput.size());
            for (int i = 0; i < loginOutput.size(); i++) {
                System.out.println("Index " + i + ": " + loginOutput.get(i).getEmail());
}

            for(int i=0;i<=userList.size()-1;i++) {

                User u=userList.get(i);
                ExpectedOutput eo=loginOutput.get(i);

                // System.out.println("EO firstname = " + eo.getFirstname());
                // System.out.println("EO lastname = " + eo.getLastname());
                // System.out.println("EO role = " + eo.getRole());
                // System.out.println("EO id = " + eo.getId());

                // System.out.println("***************************************************************************************");
                // System.out.println(u.getEmail()+ " " + u.getPassword());


                   // System.out.println("***************************************************************************************");
                    // System.out.println(eo.getEmail()+ " " + eo.getRole());
                    // System.out.println("***************************************************************************************");

                    String loginCredentials = """
                        {
                            "email":"%s",
                            "password":"%s"
                        }
                        """.formatted(u.getEmail(), u.getPassword());

                    //System.out.println(loginCredentials);

            given()
                .contentType(ContentType.JSON)
                .body(loginCredentials)
            .when()
                .post("api/auth/login")
            .then()
            .statusCode(200)
            .body("user.email",equalTo(eo.getEmail()))
            .body("user.firstname",equalTo(eo.getFirstname()))
            .body("user.lastname",equalTo(eo.getLastname()))
            .body("user.id",equalTo(eo.getId()));
            //.body("user.userRoles[0].role.name",equalTo(eo.getRole()));
            }
            
        
    
    }

    
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
