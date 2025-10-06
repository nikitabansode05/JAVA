package com.tap.EndToEndTesting;

import org.testng.annotations.Test;
//import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;


public class APITestingTest {
    @Test
    public void getAllProductTest(){
        RestAssured.baseURI="http://localhost:2005";

        given()
        .when().get("/api/products")
        .then()
        .statusCode(200)
        .body("size()", greaterThan(0))
        .body("[0].name", notNullValue());
    }

    @Test
    public void getProductById(){
        RestAssured.baseURI="http://localhost:2005";
        given()
        .when()
        .get("/api/products/1")
        .then()
        .statusCode(200);
    }


    @Test
    public void createProduct(){
        RestAssured.baseURI="http://localhost:2005";
        String newProductJSON="""
                {
                    "id":4,
                    "name":"Asus", 
                    "price":70000   
                }
                """;

        given()
        .contentType(ContentType.JSON)
        .body(newProductJSON)
        .when()
        .post("api/products")
        .then()
        .body("name" ,notNullValue())
        .body("id",notNullValue())
        .body("price",greaterThan(15000.0F));
    }
}