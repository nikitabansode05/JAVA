package com.tap.testing.AssessmentAPITesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import static org.hamcrest.CoreMatchers.*;

public class InterviewControllerTest {
    
    //@Test
    public void getAllInterviewCandidates(){

        RestAssured.baseURI="http://localhost:5238";
        
        given()
        .when()
            .get("/api/interviews/details")
        .then()
            .statusCode(200)
            .body("[0].firstname",equalTo("sanika"));
    }

    //@Test
    public void getInterviewCandidatesSubject(){
        RestAssured.baseURI="http://localhost:5238";

        given()
            .pathParam("candidateId", 1)
        .when()
            .get("candidate/{candidateId}")
        .then()
            .statusCode(200);
    }

    //@Test
    public void getInterviewDetails(){
        RestAssured.baseURI="http://localhost:5238";

        given()
            .pathParam("interviewId", 1)
        .when()
            .get("api/interviews/{interviewId}")
        .then()
         .statusCode(200);
    }

   // @Test
    public void rescheduleInterview1(){
        RestAssured.baseURI="http://localhost:5238";

        given()
            .pathParam("interviewId", 4)
            .pathParam("date", 2025-28-11)
        .when()
            .put("api/interviews/{interviewId}/date/{date}")
        .then()
            .statusCode(200);
    }

   // @Test
    public void rescheduleInterview2(){
        RestAssured.baseURI="http://localhost:5238";

        given()
            .pathParam("interviewId", 4)
            .pathParam("time", "10:00 AM")
        .when()
            .put("api/interviews/{interviewId}/time/{time}")
        .then()
            .statusCode(200);
    }

   // @Test
    public void rescheduleInterview3(){
        RestAssured.baseURI="http://localhost:5238";
        given()
            .pathParam("interviewId", 3)
            .pathParam("time", "11:30 AM")
            .pathParam("date", 2024-03-01)
        .when()
            .put("api/interviews/{interviewId}/time/{time}/date/{date}")
        .then()
            .statusCode(200)
            .body(equalTo("true"));
    }

   // @Test
    public void changeInterviewer(){
        RestAssured.baseURI="http://localhost:5238";

        given()
            .pathParam("interviewId", 4)
            .pathParam("smeId", 3)
        .when()
            .put("api/interviews/{interviewId}/subjectexperts/{smeId}")
        .then()
            .statusCode(200);
    }

   // @Test
    public void cancelInterview(){
        RestAssured.baseURI="http://localhost:5238";

        given()
            .pathParam("interviewId", 4)
        .when()
            .delete("api/interviews/{interviewId}")
        .then()
            .statusCode(200);
    }
}

