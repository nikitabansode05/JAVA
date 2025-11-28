package com.tap.testing.AssessmentAPITesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class UserSessionControllerTest {
    
    //@Test
    public void logout(){
        RestAssured.baseURI="http://localhost:5238";

        given()
            .pathParam("userId", 2)
        .when()
            .post("api/usersession/logout/{userId}")
        .then()
            .statusCode(200);
    }

    @Test 
    public void getUserHistory(){
        RestAssured.baseURI="http://localhost:5238";

        given()
             .pathParam("userId", 2)
        .when()
            .get("api/usersession/history/{userId}")
        .then()
            .statusCode(200);
    }
}
