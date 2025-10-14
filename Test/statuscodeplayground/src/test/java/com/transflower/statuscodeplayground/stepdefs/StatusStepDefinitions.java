package com.transflower.statuscodeplayground.stepdefs;

// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.server.LocalServerPort;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class StatusStepDefinitions {

   // @LocalServerPort
   // private int port;
    
    private Response response;

    //private ResponseEntity<String> response;

   // private final RestTemplate restTemplate = new RestTemplate();

    @When("I send GET request to {string}")
    public void iSendGetRequestTo(String path) {
        String url = "http://localhost:8080" + path;
        response = given().when().get(url);
        //response = restTemplate.getForEntity(url, String.class);
    }

    @When("I send POST request to {string}")
    public void iSendPostRequestTo(String path) {
        String url = "http://localhost:8080" + path;
        response = given().when().post(url);
       // response = restTemplate.postForEntity(url, null, String.class);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int expectedStatus) {
        response.then().statusCode(expectedStatus);
        //assertEquals(expectedStatus, response.getStatusCodeValue());
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String expectedContent) {
        // Example: validate response body contains expected content
        String actualResponse = response.getBody().asString(); // assuming 'response' is available
        Assert.assertTrue(actualResponse.contains(expectedContent),
            "Expected response to contain: " + expectedContent);

            System.out.println("Actual response: " + actualResponse);
}
    // @And("the response should contain {string}")
    // public void theResponseShouldContain(String expectedText) {
    //     assertTrue(response.getBody().toLowerCase().contains(expectedText.toLowerCase()));
    // }
}