package com.tap.EndToEndTesting;

import org.testng.annotations.Test;
//import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class APITesting {
    @Test
    public void getAllProductTest(){
        RestAssured.baseURI="http://localhost:9090";

        given()
        .when().get("/api/products")
        .then()
        .statusCode(200)
        .body("size()", greaterThan(0))
        .body("[0].name", notNullValue());
    }
}
