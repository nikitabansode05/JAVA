package com.tap.testing.AssessmentAPITesting;

// import io.restassured.RestAssured;

// import org.testng.annotations.Test;

// import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class SubjectControllerTest {

    static{
        RestAssured.baseURI = "http://localhost:5238";
    }

    @Test
    public void testGetAllSubjects() {
        
        given()
        .when()
            .get("/api/subject/subjects")

        .then()
            .statusCode(200)
            .body("[0].id", equalTo(1));   // Validate first element's ID
    }


    //@Test
    public void addSubject(){
        RestAssured.baseURI="http://localhost:5238";

        String addBody;
        addBody = """
                  {
                      "id":15,
                      "title":"Physics"
                  }
                  """;
        given()
            .contentType(ContentType.JSON)
            .body(addBody)
        .when()
            .post("api/subject/add")
        .then()
            .statusCode(200)
            .body(equalTo("Subject added successfully."));
    }

   //@Test
    public void deleteSubject(){
        RestAssured.baseURI="http://localhost:5238";

        given()
            .pathParam("id", 1)
        .when()
            .delete("/api/subject/delete/{id}")
        .then()
            .statusCode(200)
            .body(equalTo("Subject deleted successfully."));
    }
}
