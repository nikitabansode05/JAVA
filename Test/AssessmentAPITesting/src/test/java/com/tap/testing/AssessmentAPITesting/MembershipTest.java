package com.tap.testing.AssessmentAPITesting;

import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class MembershipTest {
    
    @Test
    public void updateRole(){
       RestAssured.baseURI="http://localhost:5238";
       String roles="""
                    [
                        {
                        "id":1,
                        "name":"student",
                        "lob":"HR"
                        },
                        {
                            "id":3,
                            "name":"sme",
                            "lob":"HR"
                        }
                    ]
               """;
        given()
            .pathParam("id", 1)
            .contentType(ContentType.JSON)
            .body(roles)
        .when()
            .post("api/membership/updaterole/{id}")
        .then()
            .statusCode(200)
            .body(equalTo("true"));
    }

   @Test
    public void updateSmeSubject(){
        RestAssured.baseURI="http://localhost:5238";

        given()
            .pathParam("id", 1)
            .pathParam("subjectid",3)
        .when()
            .post("api/membership/assignsubject/{id}/addsubject/{subjectid}")
        .then()
            .statusCode(200);
    }

    @Test
    public void removeAssignSubject(){

        RestAssured.baseURI="http://localhost:5238";

        given()
            .pathParam("id",2)
            .pathParam("subjectid", 4)
        .when()
            .post("api/membership/assignsubject/{id}/removesubject/{subjectid}")
        .then()
            .statusCode(200);
    }
}
